package learn;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import learn.board.*;

public class Main extends Application  {
    public static void main(String[] args) {
        launch(args);
    }
    public Main() {
    }
    @Override
    public  void start(Stage primaryStage) throws IOException {
        InstructionImage.display("New Game", "Please start new Game");
        String source = "/Game_Board.png";
        Image image = new Image(getClass().getResource(source).toString());

        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setBackground(SetBackGround.setNewBackground(image));

        GameController gameController = new GameController();

        TurnChanger turnChanger = new TurnChanger();
        StartBoard startBoard = new StartBoard();

        gameController.addFieldMap(grid);
        startBoard.startField(gameController, grid);
        turnChanger.setTurnChangeGreen(gameController,grid);

        Scene scene = new Scene(grid, 600, 600, Color.WHITE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}