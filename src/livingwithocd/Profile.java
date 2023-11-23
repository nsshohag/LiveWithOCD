package livingwithocd;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    @FXML
    private Button backtonewsfeed;
    @FXML
    private Label name_label;
    private String usernamex;
    @FXML
    private TextArea textarea1;
    @FXML
    private TextArea textarea2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backtonewsfeed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               DBUtils.changeScene(event,"newsfeedfxml.fxml","newsfeed",name_label.getText(),usernamex);
            }
        });

    }
    public void setUser(String name){
        name_label.setText(""+name);
    }
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String name, String username) {
        Parent root = null;
        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                Profile ob = loader.getController();
                ob.setUser(name);
                ob.usernamex=username;
                ob.textarea1.setText(DBUtils.getpost(ob.usernamex,1));
                ob.textarea2.setText(DBUtils.getpost(ob.usernamex,2));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
