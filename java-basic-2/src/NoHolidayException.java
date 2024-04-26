public class NoHolidayException extends Exception{
    // warningを防ぐための宣言
    private static final long serialVersionUID = 1L;

    // コンストラクタ
    public NoHolidayException(String msg){
        super(msg);
    }
}
