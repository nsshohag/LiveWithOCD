package livingwithocd;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private TextField tf_name;
    @FXML
    private Button button_login;
    @FXML
    private Button button_signup;

    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;

    @FXML
    private Label password_cons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    button_signup.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            int i,blankspacex=0,usernamecharlength=0;
            for(i=0;i<tf_password.getText().length();i++){
                if(tf_password.getText().charAt(i)==' '){
                    blankspacex++;
                }
            }
            int countblankspace=0;
            String temp=tf_username.getText();
            for(i=0;i<tf_username.getText().length();i++)
            {
                if(temp.charAt(i)==' ')
                    countblankspace++;
            }
            if(tf_username.getText().length()==0||tf_password.getText().length()==0||tf_name.getText().length()==0){
                System.out.println("Please fill in the information");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill in all information to sign up !");
                alert.show();
            }
            else if(countblankspace!=0){
                password_cons.setText("Username must not contain blankspace");
            }
            else if(tf_username.getText().length()<3)
            {
                password_cons.setText("Username must contain at least 3 letters !");
            }
            else if(blankspacex!=0){
                password_cons.setText("Password must not contain blank space !");
            }
            else if(tf_password.getText().length()<8)
            {
                password_cons.setText("Password must contain at least 8 characters !");
            }
            else if(!tf_name.getText().trim().isEmpty()&&!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty())
            {
                DBUtils.signUpUser(event,tf_name.getText(),tf_username.getText(),tf_password.getText());
            }
            else
            {
                System.out.println("Please fill in the information");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill in all information to sign up !");
                alert.show();
            }
        }
    });


    button_login.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.changeScene(event,"FXMLDocument.fxml","Log In !",null,null);
        }
    });
    }
}
