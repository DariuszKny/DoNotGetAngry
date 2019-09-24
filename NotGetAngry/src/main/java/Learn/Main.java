package Learn;


import Learn.Board.SetBackGround;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;


public class Main extends Application  {



    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        String source = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\images\\board1234.png";
         Image image = new Image(new FileInputStream(source));

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