package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimationFaceLook {// 顔のオブジェクト

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = w;
    }

    public GUIAnimationFaceLook() {

    }

    void makeFace(Graphics g) {
        // makeRim(g);
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeMouth(g, w / 2);
    }

    public void makeFace(Graphics g, String emotion) {
        // **ここにemotion毎の顔を用意する。*///
        if (emotion.equals("normal")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 7);
            makeBrow(g);
            makeMouth(g, w / 2);
        } else if (emotion.equals("smile")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 7);
            makeSmileBrow(g);
            makeMouth(g, w / 2);
        } else if (emotion.equals("angly")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 7);
            makeAnglyBrow(g);
            makeMouth(g, w / 2);
        }else{
            makeEyes(g, w / 5);
            makeNose(g, h / 7);
            makeBrow(g);
            makeMouth(g, w / 2);
        }
    }

    /*
     * public void makeRim(Graphics g) { g.drawLine(xStart, yStart, xStart + h,
     * yStart); g.drawLine(xStart, yStart, xStart, yStart + w);
     * g.drawLine(xStart, yStart + w, xStart + h, yStart + w); g.drawLine(xStart
     * + h, yStart, xStart + h, yStart + w); }
     */

    void makeBrow(Graphics g){
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 2 * h / 10;
        g.drawLine(xMiddle - w/3, yMiddle - h/50, xMiddle - w/10, yMiddle - h/50);
        g.drawLine(xMiddle + w/3, yMiddle - h/50, xMiddle + w/10, yMiddle - h/50);
    }
    void makeEyes(Graphics g, int eyeSize) {
        g.setColor(Color.black);
        g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
    }// makeEyes()

    public void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart
                + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }// makeNose() end

    public void makeMouth(Graphics g, int mouseSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle + mouseSize / 2,
                yMiddle);
    }

    public void makeAnglyBrow(Graphics g) { // xは目の幅 呼ばれる方(=定義する方)
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 2 * h / 10;
        g.drawLine(xMiddle - w/3, yMiddle - h/10, xMiddle - w/10, yMiddle - h/50);
        g.drawLine(xMiddle + w/3, yMiddle - h/10, xMiddle + w/10, yMiddle - h/50);
    }
    void makeSmileBrow(Graphics g){
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 2 * h / 10;
        g.drawLine(xMiddle - w/3, yMiddle - h/20, xMiddle - w/10, yMiddle - h/50);
        g.drawLine(xMiddle + w/3, yMiddle - h/20, xMiddle + w/10, yMiddle - h/50);
    }
}// FaceObj End