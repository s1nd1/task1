package Server;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Server {
    ServerSocket socketServer;
    private InputStream is;
    private OutputStream os;
    TextArea log;

    Server(int port, TextArea a) throws IOException, InterruptedException {
        socketServer = new ServerSocket(port);
        log = a;
        listen();
    }

    public void listen() throws IOException, InterruptedException {
        while (true) {
            Socket client;
            byte clientMessage[] = new byte[100];
            client = socketServer.accept();
            is = client.getInputStream();
            os = client.getOutputStream();
            while (client.isConnected()) {
                if (client.isConnected()) {
                    is.read(clientMessage);
                } else break;
                StringBuffer buffer = new StringBuffer(new String(clientMessage));
                log.appendText("Получено сообщение от клиента:" + buffer + " \nКлиент->" + client.getInetAddress() + ":" + client.getPort() + "\n");
                buffer.reverse();
                String buf = new String(buffer);
                log.appendText("Отправлен ответ клиенту:" + buf + " \nКлиент->" + client.getInetAddress() + ":" + client.getPort() + "\n");
                System.out.println(buf);
                if (client.isConnected()) {
                    os.write(buf.getBytes());
                }
                break;
            }
            client.close();
        }
    }
}
