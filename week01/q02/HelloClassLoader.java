import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new HelloClassLoader();
        Class<?> clazz = classLoader.loadClass("Hello");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(obj);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("Hello.xlass");
        int length;
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(file)) {
            length = fis.available();
            bytes = new byte[length];
            fis.read(bytes);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
