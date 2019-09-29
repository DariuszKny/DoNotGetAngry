package learn.board;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RedFieldMap {


    public ArrayList<Coordinates> loadRedMap(){

    ArrayList<Coordinates> redFieldMap = new ArrayList<>();

/// START FIELDS

        redFieldMap.add(0,new Coordinates(0,8));
        redFieldMap.add(1,new Coordinates(1,8));
        redFieldMap.add(2,new Coordinates(2,8));

//   MAIN FIELDS


        redFieldMap.add(3,new Coordinates(1,4));
        redFieldMap.add(4,new Coordinates(2,4));
        redFieldMap.add(5,new Coordinates(3,4));
        redFieldMap.add(6,new Coordinates(4,4));
        redFieldMap.add(7,new Coordinates(4,3));
        redFieldMap.add(8,new Coordinates(4,2));
        redFieldMap.add(9,new Coordinates(4 ,1));
        redFieldMap.add(10,new Coordinates(5 ,1));
        redFieldMap.add(11,new Coordinates(6 ,1));
        redFieldMap.add(12,new Coordinates(6 ,2));
        redFieldMap.add(13,new Coordinates(6 ,3));
        redFieldMap.add(14,new Coordinates(6 ,4));
        redFieldMap.add(15,new Coordinates(7 ,4));
        redFieldMap.add(16,new Coordinates(8 ,4));
        redFieldMap.add(17,new Coordinates(9 ,4));
        redFieldMap.add(18,new Coordinates(9 ,5));
        redFieldMap.add(19,new Coordinates(9 ,6));
        redFieldMap.add(20,new Coordinates(8 ,6));
        redFieldMap.add(21,new Coordinates(7 ,6));
        redFieldMap.add(22,new Coordinates(6 ,6));
        redFieldMap.add(23,new Coordinates(6 ,7));
        redFieldMap.add(24,new Coordinates(6 ,8));
        redFieldMap.add(25,new Coordinates(6 ,9));
        redFieldMap.add(26,new Coordinates(5 ,9));
        redFieldMap.add(27,new Coordinates(4 ,9));
        redFieldMap.add(28,new Coordinates(4 ,8));
        redFieldMap.add(29,new Coordinates(4 ,7));
        redFieldMap.add(30,new Coordinates(4 ,6));
        redFieldMap.add(31,new Coordinates(3 ,6));
        redFieldMap.add(32,new Coordinates(2 ,6));
        redFieldMap.add(33,new Coordinates(1 ,6));
        redFieldMap.add(34,new Coordinates(1 ,5));

//   END FIELDS

        redFieldMap.add(35,new Coordinates(2 ,5));
        redFieldMap.add(36,new Coordinates(3 ,5));
        redFieldMap.add(37,new Coordinates(4 ,5));





        return redFieldMap;
    }


}









