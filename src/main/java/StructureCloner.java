import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

public class StructureCloner {

    public Object createEmptyInstanceByClass(Class<?> aClass) {
        try {
            Constructor<?>[] constructors = ReflectionUtils.findConstructors(aClass);
            Optional<Constructor<?>> constructorOptional = ReflectionUtils.getConstructorWithoutParameters(constructors);
            if (constructorOptional.isPresent()) {
                return constructorOptional.get().newInstance();
            }
            constructorOptional = Arrays.stream(constructors).findAny();
            if (constructorOptional.isPresent()) {
                Constructor<?> constructor = constructorOptional.get();
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] parameters = Arrays.stream(parameterTypes)
                        .map(this::createEmptyInstanceByClass)
                        .toArray();
                return constructor.newInstance(parameters);
            }
            throw new RuntimeException("Constructors not found in a class " + aClass.getName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


}
