public class ExThreadsMain implements Runnable {
    static int range = 30;
    private int min = 0;
    private String name;

    public ExThreadsMain(int min, String name){
        this.min = min;
        this.name = name;
    }

    public String getName(){
        return name;
    }


    // メインメソッド
    public static void main(String[] args) {
        ExThreadsMain[] threads = new ExThreadsMain[5];

        // threads[0] = new ExThreadsMain(0*range, "0");
        // threads[0] = new ExThreadsMain(1*range, "1");
        // threads[0] = new ExThreadsMain(2*range, "2");
        for(int i = 0; i < threads.length; i ++){
            threads[i] = new ExThreadsMain((i+1) * range, "thread-" + i);
        }

        // new Thread(threads[0]).start();
        // new Thread(threads[1]).start();
        // new Thread(threads[2]).start();
        for(ExThreadsMain etm : threads){
            new Thread(etm).start();
        }

        // メインメソッドでも同じ動作を実行
        try {
            for (int i = 0; i < range; i ++) {
                if(isPrime(i)){
                    System.out.println("main " + i + " is a prime number.");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        
    }

    // 素数か調べ、素数で合ったらコンソールに出力する
    @Override
    public void run() {
        try {
            for (int i = min; i < min + range; i++) {
                if(isPrime(i)){
                    System.out.println(name + " " + i + " is a prime number.");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    // 素数か調べるメソッド
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
