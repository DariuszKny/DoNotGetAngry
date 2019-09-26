package learn.board;

import java.util.Random;

public class RollTheDice {
        public static int rollTheDice() {
            Random random = new Random();
            return random.nextInt(6) + 1;
        }
}
