public class Unit9{
    public static void main(String[] args) {
        //Simple();

        Complex();
    }

    static void Simple(){
        A[] elements = {new A(), new B(), new C(), new D()};
        for (A a : elements) {
            System.out.println(a);
            a.M1();
            a.M2();
            System.out.println();
        }
    }

    static void Complex(){
        G[] elements = {new E(), new F(), new G(), new H()};
        for (G a : elements) {
            System.out.println(a);
            a.M1();
            a.M2();
            System.out.println();
        }
    }
}

public class E extends F{
    public void M2(){
        System.out.println("E 2");
        M1();
    }            
}

public class F extends G{
    public String toString(){
        return "F";
    }            

    public void M2(){
        System.out.println("F 2");
        super.M2();
    }            
}

public class G{
    public String toString(){
        return "G";
    }            

    public void M1(){
        System.out.println("G 1");
    }            

    public void M2(){
        System.out.println("G 2");
    }            
}

public class H extends E{
    public void M1(){
        System.out.println("H 1");
    }            
}


public class A{
    public String toString(){
        return "A";
    }

    public void M1(){
        System.out.println("A-1");
    }

    public void M2(){
        System.out.println("A-2");
    }

}

public class B extends A{
    public void M2(){
        System.out.println("B-2");
    }
}

public class C extends A{
    public String toString(){
        return "C";
    }

    public void M1(){
        System.out.println("C-1");
    }

}

public class D extends C{
    public void M2(){
        System.out.println("D-2");
        M1();
    }

}
