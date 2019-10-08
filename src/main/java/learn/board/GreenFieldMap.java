package learn.board;

import java.util.ArrayList;

public class GreenFieldMap {

    public ArrayList<Coordinates> loadGreenMap(){
        ArrayList<Coordinates> greenFieldMap = new ArrayList<>();
/// START FIELDS
        greenFieldMap.add(0,new Coordinates(8,8));
        greenFieldMap.add(1,new Coordinates(9,8));
        greenFieldMap.add(2,new Coordinates(10,8));

//   MAIN FIELDS
        greenFieldMap.add(3,new Coordinates(9,6));
        greenFieldMap.add(4,new Coordinates(8,6));
        greenFieldMap.add(5,new Coordinates(7,6));
        greenFieldMap.add(6,new Coordinates(6,6));
        greenFieldMap.add(7,new Coordinates(6,7));
        greenFieldMap.add(8,new Coordinates(6,8));
        greenFieldMap.add(9,new Coordinates(6 ,9));
        greenFieldMap.add(10,new Coordinates(5 ,9));
        greenFieldMap.add(11,new Coordinates(4 ,9));
        greenFieldMap.add(12,new Coordinates(4 ,8));
        greenFieldMap.add(13,new Coordinates(4 ,7));
        greenFieldMap.add(14,new Coordinates(4 ,6));
        greenFieldMap.add(15,new Coordinates(3 ,6));
        greenFieldMap.add(16,new Coordinates(2 ,6));
        greenFieldMap.add(17,new Coordinates(1 ,6));
        greenFieldMap.add(18,new Coordinates(1 ,5));
        greenFieldMap.add(19,new Coordinates(1 ,4));
        greenFieldMap.add(20,new Coordinates(2 ,4));
        greenFieldMap.add(21,new Coordinates(3 ,4));
        greenFieldMap.add(22,new Coordinates(4 ,4));
        greenFieldMap.add(23,new Coordinates(4 ,3));
        greenFieldMap.add(24,new Coordinates(4 ,2));
        greenFieldMap.add(25,new Coordinates(4 ,1));
        greenFieldMap.add(26,new Coordinates(5 ,1));
        greenFieldMap.add(27,new Coordinates(6 ,1));
        greenFieldMap.add(28,new Coordinates(6 ,2));
        greenFieldMap.add(29,new Coordinates(6 ,3));
        greenFieldMap.add(30,new Coordinates(6 ,4));
        greenFieldMap.add(31,new Coordinates(7 ,4));
        greenFieldMap.add(32,new Coordinates(8 ,4));
        greenFieldMap.add(33,new Coordinates(9 ,4));
        greenFieldMap.add(34,new Coordinates(9 ,5));
//   END FIELDS
        greenFieldMap.add(35,new Coordinates(8 ,5));
        greenFieldMap.add(36,new Coordinates(7 ,5));
        greenFieldMap.add(37,new Coordinates(6 ,5));
        return greenFieldMap;
    }
}
