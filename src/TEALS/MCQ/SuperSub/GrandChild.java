package TEALS.MCQ.SuperSub;

public class GrandChild extends Child   {
    public void First(){
        System.out.println("Grand child First");
        super.First();
    }

    public void Second(){
        super.Second();
        System.out.println("grand Child Second");
    }
    
}
