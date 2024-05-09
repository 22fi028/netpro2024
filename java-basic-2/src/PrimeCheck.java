import java.util.ArrayList;

public class PrimeCheck {
    public static void main(String[] args){
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 3; i <= 100000; i ++){
            boolean check = false;
            for(int j = 2; j < i; j ++){
                if(i % j == 0) check = true;
            }
            if(check == false && i != 5) prime.add(i);
        }

        int pre = prime.get(0);
        int next = 0;
        int[][] count = new int[4][4];
        
        for(int i = 0; i < count.length; i ++){
            for(int j = 0; j < count[i].length; j ++){
                count[i][j] = 0;
            }
        }

        for(Integer p : prime){
            next = p % 10;
            if(pre == 1){
                if(next == 1){
                    count[0][0] ++;
                }else if(next == 3){
                    count[0][1] ++;
                }else if(next == 7){
                    count[0][2] ++;
                }else if(next == 9){
                    count[0][3] ++;
                }

            }else if(pre == 3){
                if(next == 1){
                    count[1][0] ++;
                }else if(next == 3){
                    count[1][1] ++;
                }else if(next == 7){
                    count[1][2] ++;
                }else if(next == 9){
                    count[1][3] ++;
                }

            }else if(pre == 7){
                if(next == 1){
                    count[2][0] ++;
                }else if(next == 3){
                    count[2][1] ++;
                }else if(next == 7){
                    count[2][2] ++;
                }else if(next == 9){
                    count[2][3] ++;
                }

            }else if(pre == 9){
                if(next == 1){
                    count[3][0] ++;
                }else if(next == 3){
                    count[3][1] ++;
                }else if(next == 7){
                    count[3][2] ++;
                }else if(next == 9){
                    count[3][3] ++;
                }

            }

            pre = next;
        }

        System.out.print(
        "1-1: " + count[0][0] + "\n" +
        "1-3: " + count[0][1] + "\n" +
        "1-7: " + count[0][2] + "\n" +
        "1-9: " + count[0][3] + "\n" +
        "3-1: " + count[1][0] + "\n" +
        "3-3: " + count[1][1] + "\n" +
        "3-7: " + count[1][2] + "\n" +
        "3-9: " + count[1][3] + "\n" +
        "7-1: " + count[2][0] + "\n" +
        "7-3: " + count[2][1] + "\n" +
        "7-7: " + count[2][2] + "\n" +
        "7-9: " + count[2][3] + "\n" +
        "9-1: " + count[3][0] + "\n" +
        "9-3: " + count[3][1] + "\n" +
        "9-7: " + count[3][2] + "\n" +
        "9-9: " + count[3][3] ); 
    }
}
