import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class MarketClient {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            boolean loop = true;

            while (loop) {
                System.out.println("商品を注文します");

                System.out.println("商品名を打ってください↓");

                String name = scanner.next();
                int nop = 0;
                if (name.equals("exit")) {
                    nop = 1;
                    loop = false;
                } else {
                    System.out.println("個数を打ってください ↓");
                    nop = scanner.nextInt();
                }

                Product product = new Product();
                product.setName(name);
                product.setNop(nop);

                oos.writeObject(product);
                oos.flush();

                Product response = (Product) ois.readObject();

                String resName = response.getName();
                int resNop = response.getNop();
                System.out.println(resName);
                if(loop)System.out.println("サービスは" + (resNop-nop));

            }

            scanner.close();
            ois.close();
            oos.close();
            socket.close();

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
