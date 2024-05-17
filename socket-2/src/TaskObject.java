import java.io.Serializable;

public class TaskObject implements ITask, Serializable{
    int x;
    int result;
    public void setExecNumber(int x){
        this.x = x;
    } // クライアントで最初に計算させる数字を入力しておく関数

    public int getX(){
        return x;
    }

    public void exec(){
        if(x <= 1){
            return;
        }
        else{
            for(int i = 2; i <= x; i ++){
                if(isPrime(i)){
                    result = i;
                }
            }
        }

    } // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。

    public int getResult(){
        return result;
    } // クライアントで結果を取り出す関数
    
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        
        // 2と3の倍数以外の奇数を確認
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        // 6k ± 1の形の数のみを確認
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}
