import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc2ScannerFile {

	public static void main(String args[]){
		try{
			File file = new File("C:/Users/ryuki/Desktop/targetfile.txt");
			Scanner scan = new Scanner(file);
			scan.useDelimiter("¥¥r¥¥n");

			int line = 1;

            String str = "";
			while(scan.hasNext()){
				str = scan.next();
				System.out.println(line + ":" + str);
				line++;
			}
            System.out.println("値を入力してください。");
            Scanner figscan = new Scanner(System.in);
            int fig = figscan.nextInt();

            System.out.println("合計は:" + (fig + Integer.parseInt(str)));
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
}

//  課題    ファイルから読み込むキーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。
