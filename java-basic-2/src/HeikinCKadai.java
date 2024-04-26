import java.util.ArrayList;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args){
        int[] score = new int[100];
        Random rand = new Random();
        int sum = 0;
        int pass = 80;
        int n = 100;
        ArrayList<Integer> array = new ArrayList<>();

        // score初期化
        for (int i = 0; i < score.length; i ++){
            score[i] = rand.nextInt(100);
        }

        // 平均計算
        for(int i = 0; i < score.length; i ++){
            sum += score[i];
            if(score[i] >= pass){
                array.add(score[i]);
            }
        }
        double avg = (double)(sum / n);
        System.out.println("平均点は"+ avg + "\n");
        System.out.println("以下合格者の点数です。" + "\n");

        for(Integer i : array){
            System.out.println(i + "\n");
        }

    }
}
