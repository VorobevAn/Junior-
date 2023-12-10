package Seminar2.task1;

import Seminar2.task1.Animal;
import Seminar2.task1.Cat;
import Seminar2.task1.Dog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Animal[] animals = new Animal[]{
                new Dog("sharic", 3, "mops"),
                new Cat("myrzic",2,"grey")};

        for (Animal animal: animals){
            allFields(animal);
            try {
                Method method = animal.getClass().getMethod("makeSound");
                method.invoke(animal);
            } catch (Exception e) {
                System.out.println("Метода 'makeSound()' нет.");
            }
            System.out.println();
        }

        }

        public static <T>void allFields (T obj){
            Class<?> animalClass = obj.getClass();
            Field[] declaredFields = animalClass.getDeclaredFields();
            Field[] inheritedFields = animalClass.getSuperclass().getDeclaredFields();
            Field[] resultFields = new Field[declaredFields.length + inheritedFields.length];
            Arrays.setAll(resultFields, i -> (i < declaredFields.length ? declaredFields[i] :inheritedFields[i - declaredFields.length]));
            for (Field animal : resultFields) {
                System.out.println(animal.getName());
        }

    }


}
