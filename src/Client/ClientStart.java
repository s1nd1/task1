package Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ClientStart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fileFxml/clientWindow.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Client");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}