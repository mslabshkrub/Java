package by.gsu.pms.service;

import by.gsu.pms.entity.Butter;
import by.gsu.pms.entity.Byn;

import java.util.LinkedList;
import java.util.List;

public class ButterService {

    private List<Butter> butters;

    public ButterService(List<Butter> butters) {
        this.butters = butters;
    }

    public void setButters(List<Butter> butters) {
        this.butters = butters;
    }

    public Byn totalCost() {
        Byn total = new Byn();
        for(Butter butter : butters) {
            total = total.add(butter.getPrice());
        }
        return total;
    }

    public long herbalSupplementsCount() {
        List<Butter> buttersCopy = new LinkedList<>(butters);
        return buttersCopy.stream().filter(Butter::isHerbalSupplements).count();
    }
}
