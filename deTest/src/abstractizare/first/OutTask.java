package abstractizare.first;

public class OutTask implements Task {
    public OutTask (String mesaj){
        System.out.println(mesaj);
    }


    public void execute(){
        System.out.println("OutTask");
    }
}
