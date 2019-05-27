package by.gsu.pms.reader.parser;

import by.gsu.pms.factory.BusinessTripFactory;

public class AccountParser implements Parser{
    @Override
    public void parse(String key, String val) {
        BusinessTripFactory businessTripFactory = BusinessTripFactory.getInstance();

        String index = key.replace("account", "");
        businessTripFactory.getBusinessTripByIndex(Long.valueOf(index)).setEmployeeAccount(val);
    }
}
