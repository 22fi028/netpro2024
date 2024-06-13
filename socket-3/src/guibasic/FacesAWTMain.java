//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        private int w;
        private int h;
        private int xStart;
        private int yStart;
        

        FaceFrame() {
            
        }

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            private FaceObj[] fobj = new FaceObj[9];
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fobj[count] = new FaceObj(j* w + 50, i * h + 50, 200, 200);
                    count++;
                }
            }
            for (int i = 0; i < fobj.length; i++) {
                fobj[i].drawFace(g);
            }
        }

    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        public FaceObj(int x, int y, int w, int h) {
            this.xStart = x;
            this.yStart = y;
            this.w = w;
            this.h = h;
        }

        int w = 200;
        int h = 200;
        int xStart = 50;
        int yStart = 50;

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        public void drawRim(Graphics g) { // wが横幅、hが縦幅
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)
            g.drawLine(xStart + 45, yStart + 40, xStart + 80, yStart + 40);
            g.drawLine(xStart + w - 45, yStart + 40, xStart + w - 80, yStart + 40);
        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            g.drawLine(xStart + w / 2, yStart + h / 2, xStart + w / 2, yStart + h / 2 + 20);
        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            g.drawOval(xStart + 45, yStart + 65, r, r);
            g.drawOval(xStart + w - 45 - r, yStart + 65, r, r);

        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;
            g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
        }

    }

}// Faces class end
