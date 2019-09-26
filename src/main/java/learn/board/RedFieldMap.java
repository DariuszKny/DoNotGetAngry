package learn.board;



import java.util.HashMap;
import java.util.Map;

public class RedFieldMap {

   static public Map<Integer, Coordinates> getRedMap() {
       Map<Integer, Coordinates> redMap = new HashMap<>();
       GameController gameController = new GameController();

        redMap.put(1,new Coordinates(2,5));
        return redMap;
    }
}







