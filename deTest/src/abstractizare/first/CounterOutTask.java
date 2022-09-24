package abstractizare.first;

public class CounterOutTask implements Task {
    public void execute() {
        System.out.println("CounterOutTask");
    }

    public CounterOutTask() {
        for(int i=0;i>5;i++){
            System.out.println(i);
        }
    }
}
