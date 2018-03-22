package sample;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;


public class RadioButtonTask {

    private Label labelRadioButtonTask = new Label("RadioButton task");
    private TextField lineTextRadioButton = new TextField();
    private Button buttonForChoiceRadioButton = new Button();
    private RadioButton radioBtn1 = new RadioButton("Morning");
    private RadioButton radioBtn2 = new RadioButton("Evening");
    private RadioButton radioBtn3 = new RadioButton("Night");
    private ToggleGroup toggleGroup = new ToggleGroup();

    private ArrayList<Coordinates> dictionaryRadioButtonTask = new ArrayList<>();

    public void startRadioButtonTask(GridPane root) {
        lineTextRadioButton.setPromptText("Choice string");
        buttonForChoiceRadioButton.setText("Enter to choose");

        radioBtn1.setToggleGroup(toggleGroup);
        radioBtn2.setToggleGroup(toggleGroup);
        radioBtn3.setToggleGroup(toggleGroup);

        buttonForChoiceRadioButton.setOnAction((event) -> {
            if ( lineTextRadioButton.getText().equals(radioBtn1.getText()) ) {
                radioBtn1.setSelected(true);
            }
            else if ( lineTextRadioButton.getText().equals(radioBtn2.getText()) ) {
                radioBtn2.setSelected(true);
            }
            else if ( lineTextRadioButton.getText().equals(radioBtn3.getText()) ) {
                radioBtn3.setSelected(true);
            }
            else {
                AlertError alert = new AlertError();
                alert.callAlertError("Try to enter other text!");
            }
        });

        dictionaryRadioButtonTask.add(new Coordinates(labelRadioButtonTask, 0,5));
        dictionaryRadioButtonTask.add(new Coordinates(lineTextRadioButton, 0,6));
        dictionaryRadioButtonTask.add(new Coordinates(buttonForChoiceRadioButton, 1,6));
        dictionaryRadioButtonTask.add(new Coordinates(radioBtn1, 0,7));
        dictionaryRadioButtonTask.add(new Coordinates(radioBtn2, 1,7));
        dictionaryRadioButtonTask.add(new Coordinates(radioBtn3, 2,7));

        root.setConstraints(labelRadioButtonTask, 0, 5);
        root.setConstraints(lineTextRadioButton, 0, 6);
        root.setConstraints(buttonForChoiceRadioButton, 1, 6);
        root.setConstraints(radioBtn1, 0, 7);
        root.setHalignment(radioBtn1, HPos.CENTER);
        root.setConstraints(radioBtn2, 1, 7);
        root.setHalignment(radioBtn2, HPos.CENTER);
        root.setConstraints(radioBtn3, 2, 7);
        root.setHalignment(radioBtn3, HPos.CENTER);

        root.getChildren().addAll(labelRadioButtonTask,lineTextRadioButton,buttonForChoiceRadioButton,radioBtn1,radioBtn2,radioBtn3);
    }

    public ArrayList<Coordinates> getDictionary () {
        return dictionaryRadioButtonTask;
    }

}