import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class MarketServer {

    private static String serverProcess(String product, int nop) {
        String result = "";
        for (int i = 0; i < nop; i++) {
            result += product + " ";
        }
        return result;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");
            boolean loop = true;
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (loop) {

                Product product = (Product) ois.readObject();// Integerクラスでキャスト。

                String productName = product.getName();
                System.out.println("商品名は" + productName);
                if (productName.equals("exit")) {
                    loop = false;
                }
                int nop = product.getNop();
                System.out.println("個数は" + nop);

                Product response = new Product();
                if (loop) {
                    Random random = new Random();
                    int service = random.nextInt(0, 4);
                    response.setNop(nop + service);
                    response.setName("お届けは" + serverProcess(productName, response.getNop())+ "です。");
                } else {
                    response.setName("ご利用ありがとうございました。");
                    response.setNop(0);
                }

                oos.writeObject(response);
                oos.flush();

                // close処理

            }
            // socketの終了。
            ois.close();
            oos.close();
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }

}
