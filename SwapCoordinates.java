package sample;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;


public class SwapCoordinates {
    private GridPane root = new GridPane();

    private ArrayList<Coordinates> dictionary = new ArrayList<>();

    private ComboBoxTask comboBox = new ComboBoxTask();
    private SwapTask swap = new SwapTask();
    private RadioButtonTask radioButton = new RadioButtonTask();
    private CheckBoxTask checkBox = new CheckBoxTask();
    private TableWidgetTask tableWidget = new TableWidgetTask();

    private Button buttonStart = new Button("Start");
    private Button buttonStop = new Button("Stop");
    private boolean isPressed = false;
    private Thread th;

    public void swapCoordinates() {
        comboBox.startComboBoxTask(root);
        swap.startSwapTask(root);
        radioButton.startRadioButtonTask(root);
        checkBox.startCheckBoxTask(root);
        tableWidget.startTableWidgetTask(root);
        root.setConstraints(buttonStart, 3, 0);
        root.setConstraints(buttonStop, 3, 1);
        root.getChildren().addAll(buttonStart, buttonStop);
        addCoordinates();

        buttonStart.setOnAction((event) -> {
            isPressed = false;
            th = new Thread(() -> {
                try {
                    while (!isPressed) {
                        Coordinates buf = dictionary.get(0);
                        for (int count = 0; count < dictionary.size() - 1; count++) {
                            dictionary.get(count).setHigth(dictionary.get(count + 1).getHigth());
                            dictionary.get(count).setWigth(dictionary.get(count + 1).getWigth());
                        }
                    dictionary.get(dictionary.size() - 1).setHigth(buf.getHigth());
                        dictionary.get(dictionary.size() - 1).setWigth(buf.getWigth());
                        swap();

                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Exception!");
                }
            });
            th.start();

        });

        buttonStop.setOnAction((event) -> {
            isPressed = true;
            th.interrupt();
        });

    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot (GridPane root)  {
        this.root = root;
    }
    public void addCoordinates () {
        dictionary.addAll(comboBox.getDictionary());
        dictionary.addAll(swap.getDictionary());
        dictionary.addAll(radioButton.getDictionary());
        dictionary.addAll(checkBox.getDictionary());
        dictionary.addAll(tableWidget.getDictionary());
    }

    public void swap() {
        for (int i = 0; i < dictionary.size(); i++) {
            Coordinates coordinates = dictionary.get(i);
            root.setConstraints(coordinates.getNode(), coordinates.getHigth(), coordinates.getWigth());
        }
    }
}
