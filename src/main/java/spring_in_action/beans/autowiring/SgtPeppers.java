package spring_in_action.beans.autowiring;


import org.springframework.stereotype.Component;

@Component("sgtpeppers")  //表明该类作为组件类，spring要为这个类创建bean
public class SgtPeppers implements CompactDisc {
    private  String title="Sgt. Pepper's Lonely Hearts Club Band";
    private  String  artist="This Beatles";
    @Override
    public void play() {
        System.out.println("Playing" + title+" by " +artist);
    }
}
