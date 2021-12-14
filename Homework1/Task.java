import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task {
    final private int number;
    private final ArrayList<Integer> attempts;

    public Task() {
        number = rand();
        attempts = new ArrayList<>();
    }

    public int rand(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    public int rand() {
        return (int) (Math.random() * 100);
    }

    public void start() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean trueFalse = true;
        int max = 100;
        int min = 0;
        System.out.println("Try to guess the number from 0 to 100!");
        while (trueFalse) {
            try {
                System.out.println("Enter your number:");
                int temp = Integer.parseInt(bufferedReader.readLine());
                if (temp > max || temp < min) {
                    throw new ArithmeticException();
                }
                attempts.add(temp);
                if (temp == number) {
                    System.out.println("Congratulations! You won!");
                    System.out.println("You guessed it in " + attempts.size() + " tries");
                    System.out.println("Your tries: " + attempts);
                    trueFalse = false;
                } else if (temp > number) {
                    max = temp;
                    System.out.println("The hidden number is less");
                } else {
                    min = temp;
                    System.out.println("The hidden number is greater");
                }
            } catch (IOException e) {
                System.out.println("Error, try again");
            } catch (ArithmeticException e) {
                System.out.println("The number must be between " + min + " and " + max);
            }
        }

    }

    public static void main(String[] args) {
        Task t = new Task();
        t.start();
    }
}
