package learn.board;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class GameController {

    private Map<Coordinates, Field> fields = new HashMap<>();

    public void addField(Coordinates coordinates, Field field) {
        fields.put(coordinates, field);
    }

    public void handleOnMouseClicked(Field field) {

        System.out.println("Clicked element col "+field.getColumn()+ " row "+field.getRow()+ " state "+field.getFieldState());

        if(field.getFieldState() == FieldState.RED){

            field.setImage(new Image(getClass().getResource("/GREENPAWN1.png").toString()));
            field.setFieldState(FieldState.GREEN);
        }


        else if(field.getFieldState() == FieldState.GREEN){

            field.setImage(new Image(getClass().getResource("/REDPAWN1.png").toString()));
            field.setFieldState(FieldState.RED);
        }

    }
}
