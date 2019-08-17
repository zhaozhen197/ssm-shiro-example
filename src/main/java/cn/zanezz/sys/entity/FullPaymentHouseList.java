package cn.zanezz.sys.entity;

import java.util.List;

public class FullPaymentHouseList {
    private List<FullPaymentHouse> fullPaymentHouseList;
    public FullPaymentHouseList() {
    }

    public FullPaymentHouseList(List<FullPaymentHouse> insuranceList) {
        this.fullPaymentHouseList = insuranceList;
    }

    public List<FullPaymentHouse> getFullPaymentHouseList() {
        return fullPaymentHouseList;
    }

    public void setFullPaymentHouseList(List<FullPaymentHouse> fullPaymentHouseList) {
        this.fullPaymentHouseList = fullPaymentHouseList;
    }

    @Override
    public String toString() {
        return "InsuranceList{" +
                "fullPaymentHouseList=" + fullPaymentHouseList +
                '}';
    }
}
