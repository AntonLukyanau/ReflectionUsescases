import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Optional;

public class ReflectionUtils {

    public static Optional<Constructor<?>> getConstructorWithoutParameters(Constructor<?>[] constructors) {
        return Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterTypes().length == 0)
                .findAny();
    }

    public static Constructor<?>[] findConstructors(Class<?> aClass) {
        Constructor<?>[] constructors = aClass.getConstructors();
        if (constructors.length == 0) {
            constructors = aClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
            }
        }
        return constructors;
    }

}
