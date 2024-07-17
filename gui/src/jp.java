

public class jp{
    
    public static int judge(int a, int b, int c){
        if(a == b && b == c){
            return 3;
        }
        else if(a != b && b != c && c != a){
            return 1;
        }
        else if(a == b && c != a || b == c && a != b || c == a && b != c){
            return 2;
        }
        return 0;
    }

    public void main(String [] args){
        // 不等辺三角形
        System.out.println(judge(1,2,3));

        // 正三角形
        System.out.println(judge(3,3,3));

        // 二等辺三角形 a=b
        System.out.println(judge(2,2,3));

        // 二等辺三角形 b=c
        System.out.println(judge(3,2,2));

        // 二等辺三角形 c=a
        System.out.println(judge(2,3,2));
    }
}
