
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MouseAndKeyListenerSample extends JFrame implements MouseListener,MouseMotionListener,KeyListener{

	public static void main (String[] args) {
		MouseAndKeyListenerSample frm = new MouseAndKeyListenerSample("");
		frm.setBounds(300,300,300,300);//画面左上からの座標(x,y)でウィンドウの位置とウィンドウの大きさ（w,h）
		frm.setVisible(true);
	}
	public MouseAndKeyListenerSample(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addMouseListener(this);
		//mouseClickedとmousePressedとmouseReleasedとmouseEnteredとmouseExitedを使う場合はMouseListenerを継承
		addMouseMotionListener(this);
		//mouseDraggedとmouseMovedを使う場合はMouseMotionListenerを継承
		addKeyListener(this);
		//keyTypedとkeyPressedとkeyReleasedを使う場合はkeyListenerを継承
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// マウスがクリックされたとき　mouseReleaseと使い方は同じです
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// マウスが押されたとき　mouseReleaseと使い方は同じです
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
		switch(e.getButton()) {
		case MouseEvent.BUTTON1:
			System.out.println("左ボタンが押された");
			
			break;
		case MouseEvent.BUTTON2:
			System.out.println("真ん中ボタン（ホイールのボタン）が押された");
			break;
		case MouseEvent.BUTTON3:
			System.out.println("右ボタンが押された");
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("マウスが入った");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("マウスが出た");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// キーが入力されたとき　keyReleaseと使い方は同じです
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// キーが押されたとき　keyReleaseと使い方は同じです
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//　キーを離したとき（ここを使うのが良いと思います）
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("↑");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("↓");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("←");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("→");
			break;
		case KeyEvent.VK_0:
			System.out.println("0");
			break;
			//以下同じようにVK_1など
		case KeyEvent.VK_9:
			System.out.println("0");
			break;
		case KeyEvent.VK_A:
			System.out.println("A");
			break;
			//以下同じようにVK_Rなど
		case KeyEvent.VK_Q:
			int answer = JOptionPane.showConfirmDialog(MouseAndKeyListenerSample.this,"終了しますか？","確認",JOptionPane.YES_NO_OPTION);
			if(answer == JOptionPane.YES_OPTION) {
				System.exit(1);
			}else if(answer == JOptionPane.NO_OPTION){
				System.out.println("終了はキャンセルされました");
			}
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("スペース");
			break;
		case KeyEvent.VK_BACK_SPACE:
			System.out.println("バックスペース");
			break;
		case KeyEvent.VK_DELETE:
			System.out.println("デリート");
			break;
		}
		
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		System.out.println("マウスがドラッグされた："+p.getX()+":"+p.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		System.out.println("マウスが動いた："+p.getX()+":"+p.getY());
		
	}

}