package Learn;


import Learn.Board.SetBackGround;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

         String source1 = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\REDPAWN1.png";
        Image redPawn1 = new Image(new FileInputStream(source1));

        String source2 = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\REDPAWN2.png";
        Image redPawn2 = new Image(new FileInputStream(source2));

        String source3 = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\REDPAWN3.png";
        Image redPawn3 = new Image(new FileInputStream(source3));

        String greenPawn1Source = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\GREENPAWN1.png";
        Image greenPawn1 = new Image(new FileInputStream(greenPawn1Source));

        String greenPawn2Source = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\GREENPAWN2.png";
        Image greenPawn2 = new Image(new FileInputStream(greenPawn2Source));

        String greenPawn3Source = "C:\\JavaProjects\\Dariusz-Knysak-kodilla-java-NotGetAngry\\NotGetAngry\\src\\main\\resources\\GREENPAWN3.png";
        Image greenPawn3 = new Image(new FileInputStream(greenPawn3Source));

        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(400, 400, 0, 0));
        grid.setBackground(SetBackGround.setNewBackground(image));
        grid.setGridLinesVisible(true);

        ImageView img1 = new ImageView(redPawn1);
        ImageView img2 = new ImageView(redPawn2);
        ImageView img3 = new ImageView(redPawn3);

        ImageView GreenPawnImg1 = new ImageView(greenPawn1);
        ImageView GreenPawnImg2 = new ImageView(greenPawn2);
        ImageView GreenPawnImg3 = new ImageView(greenPawn3);



        grid.add(img1, 1, 9, 1, 1);
        grid.add(img2, 2, 9, 1, 1);
        grid.add(img3, 3, 9, 1, 1);

        grid.add(GreenPawnImg1, 10, 9, 1, 1);
        grid.add(GreenPawnImg2, 9, 9, 1, 1);
        grid.add(GreenPawnImg3, 8, 9, 1, 1);


        Scene scene = new Scene(grid, 600, 600, Color.WHITE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}