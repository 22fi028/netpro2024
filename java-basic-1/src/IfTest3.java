//IfTest3 xが7,8,9ながbignumber
//xが4,5,6ならmiddle number
//xが1,2,3ならsmall numberを表示するプログラムを書け
//xがそれ以外(10や-1なら)ならout of scopeと表示するプログラムをかけ

public class IfTest3 {
	public static void main(String[] args) { 
		int x=Integer.parseInt(args[0]);
		/*以下を改造する。**/
        if(x>=7){
			System.out.println(x+" is Big Number");
		}
        else if(x<7 && x >=4){
            System.out.println(x + " is middle number");
        }
        else if(x<4 && x >=1){
            System.out.println(x + " is small number");
        }
        else{
            System.out.println("Out of Scope");
        }
	
	

	}//main end
}//class end
