package sample;

import javafx.scene.control.Alert;

public class AlertError {
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public void callAlertError(String typeOfError) {
        alert.setTitle("Error Dialog");
        alert.setHeaderText(typeOfError);
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
    }
}
