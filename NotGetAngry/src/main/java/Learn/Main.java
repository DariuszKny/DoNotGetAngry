package Learn;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class Main extends Application {

    private Image imageback = new Image("file:resources/board1234.png");
    private Image startDice = new Image("file:resources/DICEROLL6.png");
    private Image redPawn1 = new Image("file:resources/REDPAWN1.png");
    private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(600, 600, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setBackground(background);

        ImageView img = new ImageView(redPawn1);
        pawns.getChildren().add(img);

        grid.add(pawns, 0, 0, 3, 1);

        Scene scene = new Scene(grid, 600, 600, Color.BLACK);

        primaryStage.setTitle("DoNotGetAngry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}