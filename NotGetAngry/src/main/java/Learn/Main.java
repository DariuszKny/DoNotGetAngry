package Learn;


import Learn.Board.SetBackGround;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private static  Image image = new Image("file:/images/board1234.png");


    @Override
    public void start(Stage primaryStage)  {



        GridPane grid = new GridPane();
        grid.setHgap(17);
        grid.setVgap(16);
        grid.setPadding(new Insets(40, 22, 22, 45));
        grid.setBackground(SetBackGround.setNewBackground(image));




        Scene scene = new Scene(grid, 600, 600, Color.WHITE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}