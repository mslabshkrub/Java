package by.gsu.pms.factory;

import by.gsu.pms.model.BusinessTrip;
import by.gsu.pms.model.Byn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BusinessTripFactory {
    private static BusinessTripFactory ourInstance = new BusinessTripFactory();

    private Long[] indices;

    private Map<Long, BusinessTrip> indexBusinessTripMap = new HashMap<>();

    private BusinessTrip[] businessTrips;

    private Byn dailyAllowanceRate = new Byn(150);

    public static BusinessTripFactory getInstance() {
        return ourInstance;
    }

    private BusinessTripFactory() {
    }

    public void setDailyAllowanceRate(Byn dailyAllowanceRate) {
        this.dailyAllowanceRate = dailyAllowanceRate;
    }

    public BusinessTrip getBusinessTripByIndex(Long index) {
        if (!indexBusinessTripMap.containsKey(index)) {
            indexBusinessTripMap.put(index, new BusinessTrip(dailyAllowanceRate));
        }
        return indexBusinessTripMap.get(index);
    }

    public void setIndices(Long[] indices) {
        this.indices = indices;
    }

    public void clear() {
        indexBusinessTripMap.clear();
        indices = null;
        businessTrips = null;
    }

    public BusinessTrip[] toArray() {
        businessTrips = new BusinessTrip[10];
        int position = 0;

        if (indices != null) {
            for (Long index : indices) {
                if (businessTrips.length == position) {
                    resize();
                }
                businessTrips[position] = indexBusinessTripMap.get(index);
                position++;
            }
            return Arrays.copyOfRange(businessTrips, 0, position);
        }

        for (Map.Entry<Long, BusinessTrip> entry : indexBusinessTripMap.entrySet()) {
            if (businessTrips.length == position) {
                resize();
            }
            businessTrips[position] = entry.getValue();
            position++;
        }
        return Arrays.copyOfRange(businessTrips, 0, position);

    }

    private void resize() {
        BusinessTrip[] tmp = businessTrips;
        businessTrips = Arrays.copyOf(tmp, tmp.length + 10);
    }
}
