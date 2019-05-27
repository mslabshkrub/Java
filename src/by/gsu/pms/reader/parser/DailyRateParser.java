package by.gsu.pms.reader.parser;

import by.gsu.pms.factory.BusinessTripFactory;
import by.gsu.pms.model.Byn;

public class DailyRateParser implements Parser{
    @Override
    public void parse(String key, String val) {
        BusinessTripFactory businessTripFactory = BusinessTripFactory.getInstance();

        if(val.isEmpty()) {
            return;
        }

        businessTripFactory.setDailyAllowanceRate(new Byn(Integer.parseInt(val)));
    }
}
