package learn;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import learn.board.Coordinates;
import learn.board.Field;
import learn.board.GameController;
import learn.board.SetBackGround;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        String source = "/board1234.png";
        Image image = new Image(getClass().getResource(source).toString());

        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setBackground(SetBackGround.setNewBackground(image));
        grid.setGridLinesVisible(true);

        GameController gameController = new GameController();


        for (int col = 0; col < 12; col++) {
            for (int row = 0; row < 12; row++) {
                Field field  = new Field(getClass().getResource("/empty.png").toString(), col, row, gameController, grid);
                grid.add(field, col, row, 1, 1);
            }
        }

        gameController.startField(grid);




        Scene scene = new Scene(grid, 600, 600, Color.WHITE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}