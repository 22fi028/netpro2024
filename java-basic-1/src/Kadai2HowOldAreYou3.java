// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kadai2HowOldAreYou3 {
    public static void main(String[] args) { 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
			System.out.println("何歳ですか?");
			String line = reader.readLine();
			int age = Integer.parseInt(line);
            while(age >= 120 || age < 0){
                System.out.println("あなたの年齢をもう一度入力してください。");
                line = reader.readLine();
			    age = Integer.parseInt(line);
            }
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは2030年、" + (age + 6) + "歳ですね。");
            if(age >=112){
                System.out.println("あなたの生まれた元号は明治です。");
            }
            else if(age < 112 && age >=98){
                System.out.println("あなたの生まれた元号は大昭です。");
            }
            else if(age < 98 && age >= 36){
                System.out.println("あなたの生まれた元号は昭和です。");
            }
            else if(age < 36 && age >= 6){
                System.out.println("あなたの生まれた元号は平成です。");
            }
            else if(age < 6){
                System.out.println("あなたの生まれた元号は令和です。");
            }
		}
		catch(IOException e) {
			System.out.println(e);
		}


	}
}
