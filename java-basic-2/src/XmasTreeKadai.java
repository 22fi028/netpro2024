import java.util.Scanner;

public class XmasTreeKadai{
    public static void main(String[] args){

        XmasTreeKadai xmk = new XmasTreeKadai();

        while(true){
            xmk.MakeATree();
        }
    }

    public void MakeATree(){
        Scanner scan = new Scanner(System.in);
        System.out.println("葉の幅(int),幹の幅(int),幹の長さ(int),雪の記号(String),葉の記号(String)/\n"
            + "を入力してください。");

        String str = scan.next();
        String[] data = str.split(",");
        while(data.length != 5){
            System.out.println("もう一度入力してください。");
            str = scan.next();
            data = str.split(",");
        }
        int leafW = Integer.parseInt(data[0]);
        int stemW = Integer.parseInt(data[1]);
        int stemH = Integer.parseInt(data[2]);
        String snow = data[3];
        String leaves = data[4];

        System.out.println("葉の幅：" + leafW
            + "\n 幹の幅：" + stemW
            + "\n 幹の高さ：" + stemH
            + "\n 雪の記号：" + snow
            + "\n 葉の記号：" + leaves
            + "\n");

        for(int i = 0; i < leafW + stemH; i ++){
            for(int j = 0; j < leafW * 2; j ++){
                if(i < leafW){
                    if(j < leafW - i || j >= leafW + i){
                            if((i + j)%4 == 0 )
                            {
                                System.out.print(snow);
                            }else{
                            System.out.print(" ");
                            }
                    }else{
                        System.out.print(leaves);
                    }
                }else{
                    if(j < leafW - stemW/2 || j > leafW + stemW/2){
                        System.out.print(" ");
                    }else{
                        System.out.print(leaves);
                    }
                }
            }
            System.out.println();
        }
    }
}