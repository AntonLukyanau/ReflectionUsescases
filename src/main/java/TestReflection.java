import java.util.Arrays;
import java.util.Collection;

public class TestReflection {
    public static void main(String[] args) {

        CollectionCloner<String> cloner = new CollectionCloner<>();
        Collection<String> strings = cloner.cloneCollection(Arrays.asList("7","5","4","3"));
        System.out.println(strings);
//        try {
//            Class<?> enumClass = Class.forName("org.example.serializable.SingletonEnum");
//            for (Constructor<?> constructor : enumClass.getConstructors()) {
//                System.out.println(constructor);
//            }
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
