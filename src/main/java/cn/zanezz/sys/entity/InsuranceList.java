package cn.zanezz.sys.entity;

import java.util.List;

public class InsuranceList {

    private List<Insurance> insuranceList;

    public InsuranceList() {
    }

    public InsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    @Override
    public String toString() {
        return "InsuranceList{" +
                "insuranceList=" + insuranceList +
                '}';
    }
}
