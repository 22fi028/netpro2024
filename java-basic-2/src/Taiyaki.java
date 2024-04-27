public class Taiyaki{

	//================　属性　==================

	//外から見えない
	private			String	 inside;

	//外から見える
	public			String	 inthemouse;

	//外から見えるけど変えられない
	public final	String	 fire;

	//外から見えて、全てのたい焼きが共有している
	public static	String	 phrase = "おいしいよ！";

	//----------------------------------------


	//================　機能　==================

	//新しいたい焼きを作る(newしたときに呼ばれる)
	public Taiyaki(String inside, String fire) {
		this.inside	 = inside;
		this.fire = fire;
		return;
	}


	//しゃべる
	public void 自己紹介(){

		//口に何か入ってたら喋れない
		if(this.inthemouse != null){
			System.out.println("><((( '< 「モゴモゴ」");
			return;
		}

		System.out.print("><((( '< 「ぼくの中身は" + this.inside + "で、焼き加減は" + this.fire + "だよ！」");
		System.out.println("「" + Taiyaki.phrase + "」");
		return;
	}


	//----------------------------------------

}
