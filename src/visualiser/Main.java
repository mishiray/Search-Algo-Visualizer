package visualiser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/visualiser/root.fxml"));
        primaryStage.setTitle("Group 8 AI Visualizer");
        primaryStage.setScene(new Scene(root, 1130, 700));
        primaryStage.show();
    }
}
