package by.gsu.pms.util;

import java.util.Collection;

public class Printer {
    public static <T> void print(Collection<T> collection) {
        collection.forEach(System.out::println);
        System.out.println();
    }
}
