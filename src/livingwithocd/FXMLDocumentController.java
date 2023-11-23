package livingwithocd;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button_login;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private Button button_signup;
    @FXML
    public MenuBar menubar;
    @FXML
    private Menu menu;
    @FXML
    private MenuItem menuitemabout;
    @FXML
    private MenuItem menuitemclose;
    @FXML
    private Hyperlink link;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event, tf_username.getText(), tf_password.getText());
            }
        });
        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBUtils.changeScene(event, "sign-up.fxml", "SignUp", null, null);
            }
        });
        //menubar.getMenus().addAll(menu);
        menu.getItems().addAll(menuitemabout, menuitemclose);
        menuitemclose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Platform.exit();

            }
        });
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Is Clicked");
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/sadat.sanchay"));
                } catch (Exception e) {
                    System.out.println("Exception is: " + e);
                }
            }
        });
        menuitemabout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    Parent root = null;
                    FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("web-view.fxml"));
                    root = loader.load();
                    WebViewController ob=loader.getController();
                    Stage stage = (Stage) menubar.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
                catch(Exception e){
                    System.out.println("Exception is: "+e);
                }

            }
        });
    }
}