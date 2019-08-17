package cn.zanezz.sys.entity;

import java.util.List;

public class MortgageHouseList {
    private List<MortgageHouse> mortgageHouseList;
    public MortgageHouseList() {
    }

    public MortgageHouseList(List<MortgageHouse> mortgageHouseList) {
        this.mortgageHouseList = mortgageHouseList;
    }

    public List<MortgageHouse> getMortgageHouseList() {
        return mortgageHouseList;
    }

    public void setMortgageHouseList(List<MortgageHouse> mortgageHouseList) {
        this.mortgageHouseList = mortgageHouseList;
    }

    @Override
    public String toString() {
        return "MortgageHouseList{" +
                "mortgageHouseList=" + mortgageHouseList +
                '}';
    }
}
