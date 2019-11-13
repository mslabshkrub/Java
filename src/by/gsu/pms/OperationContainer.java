package by.gsu.pms;

import by.gsu.pms.operation.Minus;
import by.gsu.pms.operation.Multiply;
import by.gsu.pms.operation.Operation;
import by.gsu.pms.operation.Plus;

import java.util.HashMap;
import java.util.Map;

public class OperationContainer {
    private static final Map<String, Operation> map = new HashMap<>();

    static {
        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiply());
    }

    public static Operation getOperation(String code) {
        return map.get(code);
    }
}
