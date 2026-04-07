import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//this class allows the creating of popup windows to inform user of anything.
//Given a title and a msg it will prompt user
public class AlertBox
{
    public static void popUp(String title, String msg)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);// let user click on main scene until popup is resolved
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText(msg);
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, okButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}
