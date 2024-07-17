package saveandmouse.textsave;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

public class BufferedWriterSample {
	public static final String FILE_NAME = "save.txt";
	public static final void main(String[] args) {
		PrintWriter pr = null;
		
		//セーブする情報
		Place place = new Place(1/*エリア*/,3/*ステージ*/);
		Hero hero = new Hero("主人公"/*名前*/,50/*レベル*/,250/*体力*/,150/*魔法力*/);
		
		try {
			String path = BufferedWriterSample.class.getResource("")+FILE_NAME;//プログラムのクラスファイルがある場所をgetResource("")で取得し、ファイル名を指定
			//作成したテキストファイルは、BufferedWriterSample.classのファイルがある場所にあります
			File file = new File(new URI(path));//Fileクラスはテキストファイルの場所をURIで指定する
			if(!file.exists()) {//そのファイルが存在するか確認する（セーブデータがあるか確認）
				file.createNewFile();//なければファイル（セーブデータ）を新たに作る
			}
			pr = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			pr.println(Place.AREA+":"+place.getArea());//それぞれデータを入力
			pr.println(Place.STAGE+":"+place.getStage());
			pr.println(Hero.NAME+":"+hero.getName());
			pr.println(Hero.LEVEL+":"+hero.getLevel());
			pr.println(Hero.HP+":"+hero.getHP());
			pr.println(Hero.MP+":"+hero.getMP());
			
			System.out.println("セーブ完了");
		}catch(IOException | URISyntaxException e){
			e.printStackTrace();
		}finally {//プログラムが正常に実行されてもエラーによりcatch文が実行されても必ずfinallyブロックは実行されます
			if(pr != null) {pr.close();}
		}
		
	}
}