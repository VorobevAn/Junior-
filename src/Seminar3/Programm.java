package Seminar3;

import java.io.*;

public class Programm {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Vasiliy", 33, 4.6);

        //сериализация
        try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект сериализован.");
        }
        // десериализация
        try (FileInputStream fileInputStream = new FileInputStream("student.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект десериализован.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Вывод обьекта после десериализации");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл не сохранен так как transient): " + student.getGPA());

    }
}




