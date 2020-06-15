package by.gsu.pms.util;

import java.util.Collection;

public class Printer {
    public static <T> void print(Collection<T> collection) {
        if(!collection.isEmpty()) {
            collection.forEach(System.out::println);
        }
    }
}
