package com.example.gui.basic.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Leo Huang
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField textfield;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        textfield.setText("JavaFX 8 Hello World");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
