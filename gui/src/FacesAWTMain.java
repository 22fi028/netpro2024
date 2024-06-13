import java.awt.Color;
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

        private int w = 200;
        private int h = 200;
        private int xStart;
        private int yStart;

        FaceFrame() {

        }

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            FaceObj[] fobj = new FaceObj[9];
            Color color = new Color(255,100, 0);
            g.setColor(color);
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fobj[i* 3 + j] = new FaceObj(j * w + 100, i * h + 100, 200, 200, 10 + count * 5, 20 + count * 6, 70 - count * 4);

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

        private int w;
        private int h;
        private int xStart;
        private int yStart;
        int bf;
        int mr;
        int nr;
        int re;

        public FaceObj(int x, int y, int w, int h, int bf, int mr, int nr) {
            this.xStart = x;
            this.yStart = y;
            this.w = w;
            this.h = h;
            this.bf = bf;
            this.mr = mr;
            this.nr = nr;
            this.re = re;
        }

        public int getXStart(){
            return this.xStart;
        }

        public void drawFace(Graphics g) {
            
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, nr);
            drawMouth(g, mr);
        }

        public void drawRim(Graphics g) { // wが横幅、hが縦幅
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)
            g.drawLine(xStart + 45, yStart + 40, xStart + 80, yStart + bf);
            g.drawLine(xStart + w - 45, yStart + 40, xStart + w - 80, yStart + bf);
        }

        public void drawNose(Graphics g, int r) { // rは鼻の穴の半径
            g.fillOval(xStart + w/2 -10 - r/5, yStart + 120, r / 5, r / 5);
            g.fillOval(xStart + w/2 +10 - r/5, yStart + 120, r / 5, r / 5);
        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            g.drawOval(xStart + 45, yStart + 65, r, r);
            g.drawOval(xStart + w - 45 - r, yStart + 65, r, r);
            g.fillOval(xStart + 45 + r / 2 - r / 10, yStart + r / 2 - r / 10 + 65, r / 5, r / 5);
            g.fillOval(xStart + w + r / 2 - r / 10 - 45 - r, yStart + r / 2 - r / 10 + 65, r / 5, r / 5);

        }

        public void drawMouth(Graphics g, int mr) { // mrは口の幅
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;
            g.drawOval(xStart + w / 2 - mr / 2, yStart + 150, mr, mr * 1 / 2);
        }

    }

}// Faces class end
