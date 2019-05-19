package Client;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
    Socket sock;
    static InputStream is;
    static OutputStream os;
    Connection(int port) throws IOException {
        sock=new Socket(InetAddress.getByName("localhost"), port);
        is=sock.getInputStream();
        os=sock.getOutputStream();
    }
    public void sendMessage(String text) throws IOException {
        String mess;
        System.out.println(text);
        byte bytemessage2[]=text.getBytes();//преобразование сообщения из типа String в тип byte[]
        os.write(bytemessage2);//запись в выходной поток преобразованного сообщения
        byte readmessage[]=new byte[100];//создаем массив байт для чтения информации от сервера
        int k=is.read(readmessage);
        mess=new String(readmessage,0, k);
        JOptionPane.showMessageDialog(null, "Полученное сообщение от сервера: \n"+mess);
    }
    public static void ShowWindowFailedConn() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Ошибка подключния");
        alert.setContentText("Повторите попытку");
        alert.showAndWait();

    }
}
