package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

//配列で5つのボールを動かしてみよう

public class MovingBallAWT {
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(500, 500);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.show();
	}


	static class FFrame extends Frame implements Runnable {

		Thread th;
		Ball myBall1;
		Ball myBall2;
		int rd1 = 3;
		int rd2 = 5;
		Random random = new Random();

		private boolean enable = true;
		private int counter = 0;

		FFrame() {
			th = new Thread(this);
			th.start();
		}

		public void run() {


			myBall1 = new Ball();
			myBall1.setPosition(200, 150);
			myBall1.setR(10);
			myBall1.setColor(Color.RED);

			myBall2 = new Ball();
			myBall2.setPosition(50, 250);
			myBall2.setR(20);
			myBall2.setColor(Color.GREEN);

			while (enable) {

				try {
					th.sleep(50);
					counter++;
					myBall1.setColor(random.nextInt(0,255),random.nextInt(0,255),random.nextInt(0,255));
					myBall2.setColor(random.nextInt(0,255),random.nextInt(0,255),random.nextInt(0,255));
					if (counter >= 200) enable = false;
					myBall1.setR(myBall1.getR() + rd1);
					if(myBall1.getR() <10){
						rd1 = -rd1;
					}
					else if(myBall1.getR() > 100){
						rd1 = -rd1;
					}
					myBall2.setR(myBall2.getR() + rd2);
					if(myBall2.getR() <5){
						rd2 = -rd2;
					}
					else if(myBall2.getR() > 150){
						rd2 = -rd2;
					}
				} catch (InterruptedException e) {
				}


				myBall1.move();
				myBall2.move();

				repaint();  // paint()メソッドが呼び出される
			}
		}


		public void paint(Graphics g) {
			myBall1.draw(g);
			myBall2.draw(g);
		}

		// Ball というインナークラスを作る
		class Ball {
			int x;
			int y;
			int r; // 半径
			int red;
			int blue;
			int green;
			Color c = Color.RED;

			int xDir = 1;  // 1:+方向  -1: -方向
			int yDir = 1;

			void setColor(Color c) {
				this.c = c;
			}

			void setColor(int r, int b, int g){
				this.c = new Color(r, g, b);
			}


			void move() {

				if ((xDir == 1) && (x >= 300)) {
					xDir = -1;
				}
				if ((xDir == -1) && (x <= 100)) {
					xDir = 1;
				}

				if (xDir == 1) {
					x = x + 10;
				} else {
					x = x - 10;
				}


				if ((yDir == 1) && (y >= 300)) {
					yDir = -1;
				}
				if ((yDir == -1) && (y <= 100)) {
					yDir = 1;
				}

				if (yDir == 1) {
					y = y + 10;
				} else {
					y = y - 10;
				}


			}


			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			public int getR(){
				return this.r;
			}
			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);  // rは半径なので2倍にする
			}

		}//innner class Ball end

	}

}
