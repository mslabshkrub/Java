package by.gsu.pms.util;

import java.util.Collection;
import java.util.List;

public class Printer {
    public static <T> void printAll(Collection<T> collection) {
        collection.forEach(System.out::println);
        System.out.println();
    }

    public static <T> void printByIndex(List<T> list, int index) {
        System.out.println(list.get(index));
        System.out.println();
    }
}
