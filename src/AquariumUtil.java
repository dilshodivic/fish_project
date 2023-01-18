import java.util.Random;

public class AquariumUtil {
    public static final int coordinateX = 5;
    public static final int coordinateY = 5;
    public static final int totalAmount = (coordinateX + 1) * (coordinateY + 1);

    public static Random random = new Random();

    public static int getRandom(int n) { // 0,1,2,3,4....n-1
        return random.nextInt(n);
    }

    public static int getRandomBetween(int a, int b) { //a, a+1, a+2 .... b-1
        // 5 , 10 ->  5,6,7,8,9
        return random.nextInt(a, b);
    }

    public static Gender getRandomGender() {
        if (random.nextInt(2) == 0) {
            return Gender.M;
        }
        return Gender.F;
    }

}
