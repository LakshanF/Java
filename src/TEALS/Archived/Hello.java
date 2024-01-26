public class Hello{
    public static void main(String[] args){
        int valueType=5;
        ChangeValueType(valueType);
        System.out.println("Value is now: " + valueType);
    }

    public static void ChangeValueType(int number){
        number *=2;
    }
}