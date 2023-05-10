/*
 * Created by Ayomitide OAJ
 * 
 * 
 */

package mycontrols.dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopUp {

    private static VBox popContent;

    public static void pop(String title, Node content){
        Stage stage = new Stage();
        //set up user content
        popContent = new VBox(20);
        popContent.setAlignment(Pos.CENTER);
        popContent.setPadding(new Insets(20,20,0,20));
        popContent.getChildren().setAll(content);
        //set up close functionality
        Label closeInstruction = new Label("Press any key to close.");
        closeInstruction.setFocusTraversable(true); //needed to make press-any-key-close work
        popContent.getChildren().add(closeInstruction);
        popContent.setOnKeyTyped( e -> stage.close());
        stage.focusedProperty().addListener( (l,o,n) -> {
            if (!n) stage.close();
        } );
        stage.setScene(new Scene(popContent));
        stage.setTitle(title);
        stage.show();
    }
}
