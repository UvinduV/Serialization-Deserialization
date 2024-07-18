package lk.ijse;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try{
            //Creating the object
            Student s1 =new Student(01,"sanketh");

            //Creating stream and writing the object
            FileOutputStream fos=new FileOutputStream("student.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            // Method for serialization of object
            oos.writeObject(s1);

            oos.close();
            fos.close();

            System.out.println("Object has been serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }


        ///Deserialization
        try {
            // Reading the object from a file
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Method for deserialization of object
            Student s2 = (Student)ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Object has been deserialized ");
            System.out.println("deserialized student = " + s2);


        } catch(IOException | ClassNotFoundException e) {
            System.out.println("IOException is caught");
        }


    }
}
