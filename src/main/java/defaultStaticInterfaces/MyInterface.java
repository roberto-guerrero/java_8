package defaultStaticInterfaces;

public interface MyInterface {
    /* This is a default method (java 8) and is not mandatory to implement it in the class */
    default void newDefaultMethod() {
        System.out.println("Newly added default method");
    }

    static void newStaticMethod() {
        System.out.println("Newly added static method");
    }

    /* This is an abstract method and must be implemented in the class */
    void existingNormalMethod(String str);
}
