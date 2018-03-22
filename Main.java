package sample;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(root, 1000, 600);

        primaryStage.setTitle("Application");
        primaryStage.setScene(scene);
        primaryStage.show();



        SwapCoordinates swapCoord = new SwapCoordinates();
        swapCoord.setRoot(root);
        swapCoord.swapCoordinates();


    }

    public static void main(String[] args) {
        launch(args);
    }
}