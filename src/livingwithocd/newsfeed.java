package livingwithocd;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class newsfeed implements Initializable {
    @FXML
    private Button post_button;
    @FXML
    private Button logout_button;
    @FXML
    private Button username_button;
    @FXML
    private Label label_welcome;
    @FXML
    private TextArea text_area;
    @FXML
    private TextArea content_area;
    @FXML
    private Button nextid;
    private String namexx;
    @FXML
    private Hyperlink link1;
    @FXML
    private Hyperlink link2;
    @FXML
    private Hyperlink link3;
    @FXML
    private Hyperlink link4;
    @FXML
    private Hyperlink link5;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //content_area.setText("");
        logout_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"FXMLDocument.fxml","LOG IN !!!",null,null);
            }
        });
        post_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str=text_area.getText();
                content_area.setText(str);
                DBUtils.post(str,username_button.getText());
            }
        });
        username_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile.changeScene(event,"profile.fxml","Profile",namexx,username_button.getText());
            }
        });
        link1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Is Clicked");
                    Desktop.getDesktop().browse(new URI("https://medlineplus.gov/obsessivecompulsivedisorder.html"));
                } catch (Exception e) {
                    System.out.println("Exception is: " + e);
                }
            }
        });
        link2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Is Clicked");
                    Desktop.getDesktop().browse(new URI("https://iocdf.org/about-ocd/who-gets/"));
                } catch (Exception e) {
                    System.out.println("Exception is: " + e);
                }
            }
        });
        link3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Is Clicked");
                    Desktop.getDesktop().browse(new URI("https://iocdf.org/about-ocd/what-causes-ocd/"));
                } catch (Exception e) {
                    System.out.println("Exception is: " + e);
                }
            }
        });
        link4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Is Clicked");
                    Desktop.getDesktop().browse(new URI("https://iocdf.org/about-ocd/how-is-ocd-diagnosed/"));
                } catch (Exception e) {
                    System.out.println("Exception is: " + e);
                }
            }
        });
        link5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Is Clicked");
                    Desktop.getDesktop().browse(new URI("https://iocdf.org/about-ocd/ocd-treatment/"));
                } catch (Exception e) {
                    System.out.println("Exception is: " + e);
                }
            }
        });

    }
    /*
    public void getInf(int count){
        Connection connection = null;
        PreparedStatement postexists = null;
        ResultSet resultSet = null;
        String s=Integer.toString(count);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ocd", "root", "nazmussadat1");
            postexists = connection.prepareStatement("SELECT post_content FROM posts ORDER BY post_id DESC LIMIT +?,?");
            postexists.setString(1,s);////////Problem
            resultSet=postexists.executeQuery();
            if(!resultSet.isBeforeFirst()){
                //NO POSTS.
            }
            else{
                while (resultSet.next()) {
                    String retrivedString=resultSet.getString("post_content");
                    content_area.setText(retrivedString);

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(postexists!=null){
                try{
                    postexists.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection!=null)
            {
                try{
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }
    }

         */
    public void setUser(String name,String username) {
        username_button.setText("" + username);
        label_welcome.setText("Welcome "+name+" !");
        namexx=name;
    }
    public void setText(int text){
    }
}