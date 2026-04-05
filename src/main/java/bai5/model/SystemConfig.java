package bai5.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {

    @Value("Cyber Center")
    private String branchName;

    @Value("08:00")
    private String openingHour;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "branchName='" + branchName + '\'' +
                ", openingHour='" + openingHour + '\'' +
                '}';
    }
}