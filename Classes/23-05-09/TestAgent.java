import java.lang.reflect.Type;

public class TestAgent {
    public static void main(String[] args){
        Agent x = new Agent("jeff");
    }

    try {
        Class<?> C = Class.forName("MyAgent");
        Type[] T = C.getGenericInterfaces();

        boolean found = false;

        for (Type t: T){
            if (t.getTypeName() == "Agent"){
                found = true;
            }
        }
        if (!found){
            System.out.println("Agent must implement interace Agent");
        }
        Method agisco = C.getMethod("action");

    } catch (ClassNotFoundException e) {
        System.out.println("CClass MyAgent not provided");
    }
}
