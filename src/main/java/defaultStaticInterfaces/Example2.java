package defaultStaticInterfaces;

//This example shows error as both interfaces have a default method with same signature.
//For that reason, "newMethod" MUST implement its own implementation.

public class Example2 implements MyInterfaceA, MyInterfaceB {

    public void existingMethod(String str){
        System.out.println("String is: "+str);
    }
    public void disp(String str){
        System.out.println("String is: "+str);
    }
    public void newMethod() {
        System.out.println("Implementation of default method");
    }

    public static void main(String[] args) {
        Example2 obj = new Example2();
        obj.newMethod();
    }
}
