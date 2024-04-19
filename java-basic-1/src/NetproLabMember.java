import java.util.Random;

public class NetproLabMember {
    public static void main(String[] args){
        int[][] member = new int[15][3];
        Random random = new Random();
        for(int i = 0; i < member.length ; i ++){
            member[i][0] = 110 + random.nextInt(-10,10);
            double w = member[i][0] * (0.2 + 0.01*i);
            member[i][1] = (int)w;
            member[i][2] = 10 + random.nextInt(-3,3);
        }
        double p = 1;
        for(int i = 0; i < member.length; i ++){
            p = p * combination(member[i][0] - member[i][1], member[i][2]) / combination(member[i][0], member[i][2]);
        }
        System.out.println("確率は" +p);
    }

    public static double combination(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        } else {
            return combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
    
}
