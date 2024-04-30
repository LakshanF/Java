package TEALS.MCQ.SuperSub;

public class Child extends Parent {
    public void First(){
        System.out.println("Child First");
        super.First();
    }

    public void Second(){
        super.Second();
        System.out.println("Child Second");
    }
    
}
