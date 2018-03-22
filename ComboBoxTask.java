package sample;

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class ComboBoxTask {

    private Label labelComboBoxTask = new Label("ComboBox task");
    private ComboBox<String> box = new ComboBox<>();
    private ArrayList<String> listForBox = new ArrayList<>();
    private TextField lineText = new TextField();
    private Button buttonAddToBox = new Button();

    private ArrayList <Coordinates> dictionaryComboBoxTask = new ArrayList<>();

    public void startComboBoxTask(GridPane root) {
        lineText.setPrefColumnCount(20);
        lineText.setPromptText("Enter string");

        buttonAddToBox.setText("Add to box");

        buttonAddToBox.setOnAction((event) -> {
            String text = lineText.getText();
            if(!listForBox.contains(text)) {
                listForBox.add(text);
                box.getItems().add(text);
            }
            else {
                AlertError alert = new AlertError();
                alert.callAlertError("Incorrect text. This text already is.");
            }
        });

        dictionaryComboBoxTask.add(new Coordinates(labelComboBoxTask,0,0));
        dictionaryComboBoxTask.add(new Coordinates(lineText, 0,1));
        dictionaryComboBoxTask.add(new Coordinates(buttonAddToBox, 1,1));
        dictionaryComboBoxTask.add(new Coordinates(box, 0,2));

        root.setConstraints(labelComboBoxTask,0,0);
        root.setConstraints(lineText, 0, 1);
        root.setConstraints(buttonAddToBox, 1, 1);
        root.setHalignment(buttonAddToBox, HPos.CENTER);
        root.setConstraints(box, 0, 2);

        root.getChildren().addAll(labelComboBoxTask,lineText,buttonAddToBox,box);
    }


    public ArrayList<Coordinates> getDictionary () {
        return dictionaryComboBoxTask;
    }
}