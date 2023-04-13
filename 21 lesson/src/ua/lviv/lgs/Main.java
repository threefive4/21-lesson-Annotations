package ua.lviv.lgs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Main {
    public void writeAnnotatedFieldsToFile(Object object, String filename) throws IOException, IllegalAccessException, IOException {
        Class<?> clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                field.setAccessible(true);
                MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
                String value = annotation.value() + ": " + field.get(object);
                writer.write(value);
                writer.newLine();
            }
        }

        writer.close();
    }

}
