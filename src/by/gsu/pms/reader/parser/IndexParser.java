package by.gsu.pms.reader.parser;

import by.gsu.pms.factory.BusinessTripFactory;

public class IndexParser implements Parser{
    @Override
    public void parse(String key, String val) {
        BusinessTripFactory businessTripFactory = BusinessTripFactory.getInstance();

        if(val.isEmpty()) {
            return;
        }

        String[] vals = val.split(";");
        Long[] indices = new Long[vals.length];
        for(int i = 0; i < vals.length; i++) {
            indices[i] = Long.valueOf(vals[i].trim());
        }
        businessTripFactory.setIndices(indices);
    }
}
