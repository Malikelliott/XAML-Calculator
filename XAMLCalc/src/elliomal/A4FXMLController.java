package elliomal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author malik
 */
public class A4FXMLController implements Initializable {

    @FXML
    private Label lblRes;
    @FXML
    private TextField xField, yField;
    @FXML
    private Button xPowY, max, min, evenOdd, clearX, clearY, clearBoth, exit;
    @FXML
    private ImageView imgMain;
    @FXML
    private void swap(MouseEvent event){
        imgMain.setImage(new Image(getClass().getResource("cal2.jpg").toExternalForm()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Controls for the X^Y button
        xPowY.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                double value1 = Double.parseDouble(xField.getText());
                double value2 = Double.parseDouble(yField.getText());
                double result = Math.pow(value1,value2);
                lblRes.setText(String.format("%.2f", result));
            }
        });
        
        //Controls for the MAX button
        max.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                double value1 = Double.parseDouble(xField.getText());
                double value2 = Double.parseDouble(yField.getText());
                double result = 0;
                if (value1 > value2)
                    result = value1;
                else
                    result = value2;
                lblRes.setText(String.format("%.2f", result));
            }
        });
        
        //Controls for the MIN button
        min.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                double value1 = Double.parseDouble(xField.getText());
                double value2 = Double.parseDouble(yField.getText());
                double result = 0;
                if (value1 < value2)
                    result = value1;
                else
                    result = value2;
                lblRes.setText(String.format("%.2f", result));
            }
        });
        
        //Controls for the "Even or Odd" button
        evenOdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                double value1 = Double.parseDouble(xField.getText());
                double value2 = Double.parseDouble(yField.getText());
                String result = "";
                if (value1 % 2 == 0 && value2 % 2 == 0){
                    result = "Both values are even";}
                else if (value1 % 2 == 0 && value2 % 2 != 0){
                    result = "X is even, Y is odd";}
                else if (value1 % 2 != 0 && value2 % 2 == 0){
                    result = "X is odd, Y is even";}
                else{
                    result = "Both values are odd";}
                lblRes.setText(String.format(result));
            }
        });
        
        //Clear the respective fields when the button is clicked
        clearX.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                xField.clear();
            }
        });
        
        clearY.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                yField.clear();
            }
        });
        
        clearBoth.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                xField.clear();
                yField.clear();
            }
        });
        
        //exit the program when button is clicked
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
            }
        });
    }    
}
