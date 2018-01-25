package defaultStaticInterfaces;

public interface MyInterfaceB {
    default void newMethod(){
        System.out.println("Newly added default method");
    }
    void existingMethod(String str);
}
