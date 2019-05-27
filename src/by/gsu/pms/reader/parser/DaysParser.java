package by.gsu.pms.reader.parser;

import by.gsu.pms.factory.BusinessTripFactory;

public class DaysParser implements Parser{
    @Override
    public void parse(String key, String val) {
        BusinessTripFactory businessTripFactory = BusinessTripFactory.getInstance();

        if(val.isEmpty()) {
            return;
        }

        String index = key.replace("days", "");
        businessTripFactory.getBusinessTripByIndex(Long.valueOf(index)).setNumOfDays(Integer.parseInt(val.trim()));
    }
}
