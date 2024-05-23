import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientOnce {

    public static void main(String arg[]) {

        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");
            System.out.println("計算させます。");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // ｘを入力
            System.out.println("数字を入力してください↓");
            int  x = scanner.nextInt();

            // ｘが1以下の時の処理
            while(x <= 1){
                System.out.println("もう一度入力してください。");
                x = scanner.nextInt();
            }

            // ｘに格納
            TaskObject obj = new TaskObject();
            obj.setExecNumber(x);

            // アウトプット
            oos.writeObject(obj);
            oos.flush();

            // インプット
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TaskObject returnObj = (TaskObject) ois.readObject();
            System.out.println("最大素数は" + returnObj.getResult() + "です。");

            // close処理
            ois.close();
            oos.close();
            socket.close();
            scanner.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }

    }
}