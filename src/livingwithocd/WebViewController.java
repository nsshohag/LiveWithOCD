package livingwithocd;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class WebViewController implements Initializable {
    @FXML
    private WebView mywebview;
    @FXML
    private Button reload_button;
    @FXML
    private Button backtologin;
    @FXML
    private WebEngine engine;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // engine=mywebview.getEngine();
       // engine.load("https://medlineplus.gov/obsessivecompulsivedisorder.html");

        backtologin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mywebview.getEngine().load(null);
                DBUtils.changeScene(event,"FXMLDocument.fxml","Log In !",null,null);
            }
        });
    }

}
