package sample;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;

public class CheckBoxTask {

    private Label labelCheckBoxTask = new Label("CheckBoxTask task");
    private TextField lineTextCheckBox = new TextField();
    private Button buttonForChoiceCheckBox = new Button();
    private CheckBox checkBox1 = new CheckBox("Morning");
    private CheckBox checkBox2 = new CheckBox("Evening");
    private CheckBox checkBox3 = new CheckBox("Night");

    private ArrayList<Coordinates> dictionaryCheckBoxTask = new ArrayList<>();

    public void startCheckBoxTask (GridPane root) {
        lineTextCheckBox.setPromptText("Enter string");
        buttonForChoiceCheckBox.setText("Enter to choose");

        buttonForChoiceCheckBox.setOnAction((event) -> {
            if ( lineTextCheckBox.getText().equals(checkBox1.getText()) ) {
                if(checkBox1.isSelected()) {
                    checkBox1.setSelected(false);
                }
                 else
                     checkBox1.setSelected(true);
            }
            else if ( lineTextCheckBox.getText().equals(checkBox2.getText()) ) {
                if(checkBox2.isSelected()) {
                    checkBox2.setSelected(false);
                }
                else
                    checkBox2.setSelected(true);
            }
            else if ( lineTextCheckBox.getText().equals(checkBox3.getText()) ) {
                if (checkBox3.isSelected()) {
                    checkBox3.setSelected(false);
                }
                else
                    checkBox3.setSelected(true);
            }
            else {
                AlertError alert = new AlertError();
                alert.callAlertError("Try to enter other text!");
            }
        });

        dictionaryCheckBoxTask.add(new Coordinates(labelCheckBoxTask, 0,8));
        dictionaryCheckBoxTask.add(new Coordinates(lineTextCheckBox, 0,9));
        dictionaryCheckBoxTask.add(new Coordinates(buttonForChoiceCheckBox, 1,9));
        dictionaryCheckBoxTask.add(new Coordinates(checkBox1, 0,10));
        dictionaryCheckBoxTask.add(new Coordinates(checkBox2, 1,10));
        dictionaryCheckBoxTask.add(new Coordinates(checkBox3,2,10));

        root.setConstraints(labelCheckBoxTask, 0, 8);
        root.setConstraints(lineTextCheckBox, 0, 9);
        root.setConstraints(buttonForChoiceCheckBox, 1, 9);
        root.setConstraints(checkBox1, 0, 10);
        root.setHalignment(checkBox1, HPos.CENTER);
        root.setConstraints(checkBox2, 1, 10);
        root.setHalignment(checkBox2, HPos.CENTER);
        root.setConstraints(checkBox3, 2, 10);
        root.setHalignment(checkBox3, HPos.CENTER);

        root.getChildren().addAll(labelCheckBoxTask,lineTextCheckBox,buttonForChoiceCheckBox,checkBox1,checkBox2,checkBox3);
    }


    public ArrayList<Coordinates> getDictionary () {
        return dictionaryCheckBoxTask;
    }
}
