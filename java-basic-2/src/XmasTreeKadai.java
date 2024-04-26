public class XmasTreeKadai{
    public static void main(String[] args){
        //int X=Integer.parseInt(args[0]);
        //int Y=Integer.parseInt(args[1]);

        int leaf = 19;
        int stemW = 3;
        int stemH = 7;

        for(int i = 0; i < leaf + stemH; i ++){
            for(int j = 0; j < leaf * 2; j ++){
                if(i < leaf){
                    if(j < leaf - i || j >= leaf + i){
                            if((i + j)%4 == 0 )
                            {
                                System.out.print("+");
                            }else{
                            System.out.print(" ");
                            }
                    }else{
                        System.out.print("*");
                    }
                }else{
                    if(j < leaf - stemW/2 || j > leaf + stemW/2){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }
}