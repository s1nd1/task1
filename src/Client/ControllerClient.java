package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;

public class ControllerClient {
    private Connection conn;
    @FXML
    private Button buttonGo;

    @FXML
    private TextField textFieldPort;

    @FXML
    private Button buttonConnect;

    @FXML
    private TextField textFieldSend;

    @FXML
    private Text textSend;

    @FXML
    private Button buttonExit;

    @FXML
    private Text textPort;

    @FXML
    void buttonActConnect(ActionEvent event) {

        try {
            conn=new Connection(Integer.parseInt(textFieldPort.getText()));
            textFieldPort.setVisible(false);
            buttonConnect.setVisible(false);
            textPort.setVisible(false);
            textSend.setVisible(true);
            textFieldSend.setVisible(true);
            buttonGo.setVisible(true);
        } catch (IOException e) {
            conn.ShowWindowFailedConn();
        }

    }

    @FXML
    void buttonActExit(ActionEvent event) {
    System.exit(0);
    }

    @FXML
    void buttonActSend(ActionEvent event) throws IOException {
    conn.sendMessage(textFieldSend.getText());
    textFieldPort.setVisible(true);
    buttonConnect.setVisible(true);
    textPort.setVisible(true);
    textSend.setVisible(false);
    textFieldSend.setVisible(false);
    buttonGo.setVisible(false);
    }

}
