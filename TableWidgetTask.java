package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableColumn;
import java.util.ArrayList;



public class TableWidgetTask {
    private Label labelTableWidgetTask = new Label("TableWidget task");
    private TextField lineTextTableWidget = new TextField();
    private Button buttonForAddInTable = new Button();
    private Button buttonForMoveToRight = new Button();
    private Button buttonForMoveToLeft = new Button();

    private ArrayList<Coordinates> dictionaryTableWidgetTask = new ArrayList<>();

    private static ObservableList<ClassForTableWrapper>  allClass
            = FXCollections.observableArrayList();

    private static TableView<ClassForTableWrapper> table;

    public static void createTableBox () {
        table = new TableView<>();
        TableColumn firstColumn = new TableColumn("First column");
        firstColumn.setCellValueFactory(new PropertyValueFactory<ClassForTable, String>("str1"));
        firstColumn.setMinWidth(200);
        TableColumn secondColumn = new TableColumn("Second column");
        secondColumn.setCellValueFactory(new PropertyValueFactory<ClassForTable, String>("str2"));
        secondColumn.setMinWidth(200);

        table.setItems(allClass);
        table.getColumns().addAll(firstColumn,secondColumn);
    }

    public void startTableWidgetTask (GridPane root) {
        lineTextTableWidget.setPromptText("Enter string");
        buttonForAddInTable.setText("Add to table");
        buttonForMoveToRight.setText("Move to right");
        buttonForMoveToLeft.setText("Move to left");

        createTableBox();

        buttonForAddInTable.setOnAction((event) -> {
            if (!lineTextTableWidget.getText().equals("")) {
                ClassForTable cls = new ClassForTable(lineTextTableWidget.getText(), "");
                allClass.add(new ClassForTableWrapper(cls));
            }
        });

        buttonForMoveToRight.setOnAction((event) -> {
                ObservableList<ClassForTableWrapper> selectedItem = table.getSelectionModel().getSelectedItems();
                try {
                    if (!selectedItem.get(0).getStr1().equals("")) {
                        allClass.set(allClass.indexOf(selectedItem.get(0)), new ClassForTableWrapper(new ClassForTable("", selectedItem.get(0).getStr1())));
                    }
                }
                catch (Exception ex) {
                    AlertError alert = new AlertError();
                    alert.callAlertError("Choose a line!");
                }
        });

        buttonForMoveToLeft.setOnAction((event) -> {
                ObservableList<ClassForTableWrapper> selectedItem = table.getSelectionModel().getSelectedItems();
                try {
                    if (!selectedItem.get(0).getStr2().equals("")) {
                        allClass.set(allClass.indexOf(selectedItem.get(0)), new ClassForTableWrapper(new ClassForTable(selectedItem.get(0).getStr2(), "")));
                    }
                }
                catch (Exception ex) {
                AlertError alert = new AlertError();
                alert.callAlertError("Choose a line!");
            }
        });

        dictionaryTableWidgetTask.add(new Coordinates(labelTableWidgetTask, 0,11));
        dictionaryTableWidgetTask.add(new Coordinates(lineTextTableWidget, 0,12));
        dictionaryTableWidgetTask.add(new Coordinates(buttonForAddInTable, 1,12));
        dictionaryTableWidgetTask.add(new Coordinates(buttonForMoveToRight,0,13));
        dictionaryTableWidgetTask.add(new Coordinates(buttonForMoveToLeft, 1,13));
        dictionaryTableWidgetTask.add(new Coordinates(table, 0,14));

        root.setConstraints(labelTableWidgetTask, 0, 11);
        root.setConstraints(lineTextTableWidget, 0, 12);
        root.setConstraints(buttonForAddInTable, 1, 12);
        root.setConstraints(buttonForMoveToRight, 0, 13);
        root.setHalignment(buttonForMoveToRight, HPos.CENTER);
        root.setConstraints(buttonForMoveToLeft, 1, 13);
        root.setHalignment(buttonForMoveToLeft, HPos.CENTER);
        root.setConstraints(table, 0, 14);

        root.getChildren().addAll(labelTableWidgetTask,lineTextTableWidget,buttonForAddInTable,buttonForMoveToRight,buttonForMoveToLeft,table);
    }

    public ArrayList<Coordinates> getDictionary () {
        return dictionaryTableWidgetTask;
    }
}
