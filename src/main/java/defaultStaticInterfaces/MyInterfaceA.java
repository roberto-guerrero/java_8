package defaultStaticInterfaces;

public interface MyInterfaceA {
    default void newMethod(){
        System.out.println("Newly added default method");
    }
    void existingMethod(String str);
}
