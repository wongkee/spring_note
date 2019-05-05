package spring_in_action.beans.autowiring;


import org.springframework.stereotype.Component;

@Component("harddaynight")
public class HardDayNight implements CompactDisc {
    @Override
    public void play() {
        System.out.println("I am playing HarddayNight!");
    }
}
