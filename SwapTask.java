package sample;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;


public class SwapTask {

    private Label labelSwapTask = new Label("Swap task");
    private TextField lineTextSwap = new TextField();
    private Button firstButtonSwap = new Button();
    private Button secondButtonSwap = new Button();

    private ArrayList<Coordinates> dictionarySwapTask = new ArrayList<>();

    public void startSwapTask(GridPane root) {
        lineTextSwap.setPrefColumnCount(20);
        lineTextSwap.setPromptText("Enter string");

        firstButtonSwap.setText("Press");
        secondButtonSwap.setText("Press");

        firstButtonSwap.setOnAction((event) -> {
            secondButtonSwap.setText(lineTextSwap.getText());
        });

        secondButtonSwap.setOnAction((event) -> {
            String textFromButton = firstButtonSwap.getText();
            firstButtonSwap.setText(secondButtonSwap.getText());
            secondButtonSwap.setText(textFromButton);
        });

        dictionarySwapTask.add(new Coordinates(labelSwapTask, 0,3));
        dictionarySwapTask.add(new Coordinates(lineTextSwap, 0,4));
        dictionarySwapTask.add(new Coordinates(firstButtonSwap, 1,4));
        dictionarySwapTask.add(new Coordinates(secondButtonSwap, 2,4));

        root.setConstraints(labelSwapTask, 0,3);
        root.setConstraints(lineTextSwap, 0, 4);
        root.setConstraints(firstButtonSwap, 1, 4);
        root.setConstraints(secondButtonSwap, 2, 4);

        root.getChildren().addAll(labelSwapTask,lineTextSwap,firstButtonSwap,secondButtonSwap);
    }


    public ArrayList<Coordinates> getDictionary () {
        return dictionarySwapTask;
    }
}