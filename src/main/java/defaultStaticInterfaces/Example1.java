package defaultStaticInterfaces;

public class Example1 implements MyInterface {

    //Implementing abstract method
    public void existingNormalMethod(String str) {
        System.out.println("String is: "+str);
    }

    public static void main(String[] args) {
        //calling the static method
        MyInterface.newStaticMethod();

        Example1 obj = new Example1();

        //calling the new default method
        obj.newDefaultMethod();

        //calling the abstract method
        obj.existingNormalMethod("This is the abstract method.");
    }
}
