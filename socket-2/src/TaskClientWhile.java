import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String[] arg) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("計算させます。");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            boolean loop = true;

            while (loop) {
                System.out.println("数字を入力してください↓");
                int x = scanner.nextInt();
                if (x <= 1) {
                    loop = false;
                    System.out.println("終了します。");
                }
                TaskObject obj = new TaskObject();
                obj.setExecNumber(x);

                if (loop) {
                    oos.writeObject(obj);
                    oos.flush();

                    TaskObject returnObj = (TaskObject) ois.readObject();

                    System.out.println("最大素数は" + returnObj.getResult() + "です。");
                }

            }

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
