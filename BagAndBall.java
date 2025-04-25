import java.util.*;

enum Color {
    RED, YELLOW, GREEN;
}

class Ball {
    Color color;

    Ball(Color color) {
        this.color = color;
    }
}

class Bag {
    final int capacity = 12;
    int yCount = 0, gCount = 0, rCount = 0, totalCount = 0;
    List<Ball> balls = new ArrayList<>();

    boolean add(Ball ball) {
        if (totalCount >= capacity)
            return false; // bag full

        if (ball.color == Color.RED && rCount + 1 > gCount)
            return false; // red > green not allowed
        if (ball.color == Color.YELLOW && yCount + 1 > 0.4 * capacity)
            return false; // yellow > 40% not allowed

        balls.add(ball);
        totalCount++;

        if (ball.color == Color.RED)
            rCount++;
        else if (ball.color == Color.YELLOW)
            yCount++;
        else if (ball.color == Color.GREEN)
            gCount++;
        return true;
    }
}

public class BagAndBall {
    public static void main(String args[]) {
        Bag bag = new Bag();

        Ball ball1 = new Ball(Color.RED);
        Ball ball2 = new Ball(Color.GREEN);
        Ball ball3 = new Ball(Color.GREEN);
        Ball ball4 = new Ball(Color.YELLOW);

        System.out.println(bag.add(ball1)); // false: red > green
        System.out.println(bag.add(ball2)); // true
        System.out.println(bag.add(ball4)); // true
        System.out.println(bag.add(ball3)); // true
    }
}
