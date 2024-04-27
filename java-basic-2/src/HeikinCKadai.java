import java.util.ArrayList;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args){
        int sum = 0;
        int pass = 80;
        int n = 100;

        Kamoku[] math = new Kamoku[n];
        Random rand = new Random();

        ArrayList<Integer> array = new ArrayList<>();

        // math初期化
        for (int i = 0; i < math.length; i ++){
            math[i] = new Kamoku(rand.nextInt(101));
        }

        // 平均計算
        for(int i = 0; i < math.length; i ++){
            sum += math[i].getScore();
            if(math[i].getScore() >= pass){
                array.add(math[i].getScore());
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
