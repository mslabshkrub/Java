package by.gsu.pms.reader.parser;

import by.gsu.pms.factory.BusinessTripFactory;
import by.gsu.pms.model.Byn;

public class TransportParser implements Parser{
    @Override
    public void parse(String key, String val) {
        BusinessTripFactory businessTripFactory = BusinessTripFactory.getInstance();

        if(val.isEmpty()) {
            return;
        }

        String index = key.replace("transport", "");
        businessTripFactory.getBusinessTripByIndex(Long.valueOf(index)).setTransExp(new Byn(Integer.parseInt(val)));
    }
}
