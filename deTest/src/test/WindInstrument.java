package test;

public class WindInstrument implements Instrument{

    public void play() {
        System.out.println("WindInstrument.play()");
    }

    public String what() {
        return "WindInstrument";
    }

    public void adjust() {
    }
}
