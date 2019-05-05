package spring_in_action.beans.autowiring;

public class Revolver implements  CompactDisc {
    @Override
    public void play() {
        System.out.println("revolver");
    }
}
