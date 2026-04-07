import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{

    @Override
    public void start(Stage primaryStage)
    {

        Parent root;
        try
        {

            // load root with .fxml from SceneBuilder
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Under Path: Subs your way!");// set title of window
            primaryStage.setScene(scene);// set it up
            primaryStage.show();// actually show window

        } catch (IOException e)
        {
            e.printStackTrace();

        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}