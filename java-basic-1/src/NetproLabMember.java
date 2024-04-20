import java.util.Random;

public class NetproLabMember {
    // エントリーポイント
    public static void main(String[] args){
        int[][] member = new int[15][3]; // 配列の生成
        Random random = new Random(); //  // ランダム初期化
        for(int i = 0; i < member.length ; i ++){ // 配列の初期化
            member[i][0] = 110 + random.nextInt(21) - 10; // 学生総人数
            member[i][1] = (20 + 1*i); // 女子学生の割合
            member[i][2] = 10 + random.nextInt(7) - 3; // 研究室の人数
        }
        
        double p = 1; // 確率の変数
        for(int i = 0; i < member.length; i ++){
            // 学生総人数‐女子学生C研究室の人数/学生総人数C研究室の人数
            p *= combination(member[i][0] - (int)(member[i][0] * ((double)member[i][1]/100)), member[i][2]) / combination(member[i][0], member[i][2]);
        }
        System.out.println("確率は" +p);    // 出力
    }

    // コンビネーション関数
    public static double combination(int n, int r) {
        if (n < 0 || r < 0) {
            throw new IllegalArgumentException("引数に問題あり");
        } else if (n == r || r == 0) {
            return 1;
        } else if (n < r) {
            return 0;
        } else {
            double c = 1;
            for (int i = 1; i <= r; i++) {
                c *= (n - i + 1) / i;
            }
            return c;
        }
    }

}
