package abstractizare.first;

import java.util.concurrent.ThreadLocalRandom;

public class RandomOutTask implements Task {
    public void execute() {
        System.out.println("RandomOutTask");
    }

    public RandomOutTask() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        System.out.println(randomNumber);
    }
}
