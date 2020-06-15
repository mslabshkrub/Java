package by.gsu.pms.util;

import by.gsu.pms.entity.Butter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializator {
    public static boolean serialization(List<Butter> butters, String filename) {
        boolean flag = false;
        File file = new File(filename);
        ObjectOutputStream outputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                outputStream = new ObjectOutputStream(fileOutputStream);
                outputStream.writeObject(butters);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File cannot be create " + e);
        } catch (NotSerializableException e) {
            System.err.println("Class doesn't support serialization " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Stream close error");
            }
        }
        return flag;
    }

    public static List<Butter> deserialization(String filename) throws InvalidObjectException {
        boolean flag = false;
        List<Butter> butters = new ArrayList<>();
        File file = new File(filename);
        ObjectInputStream inputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            inputStream = new ObjectInputStream(fileInputStream);
            butters = (List) inputStream.readObject();
            return butters;
        } catch (ClassNotFoundException e) {
            System.err.println("Class doesn't exist " + e);
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist for deserialization " + e);
        } catch (InvalidClassException e) {
            System.err.println("Class version mismatch");
        } catch (IOException e) {
            System.err.println("General I/O error" + e);
        }
        finally {
            try{
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Stream close error");
            }
        }
        throw new InvalidObjectException("Object didn't restore");
    }
}
