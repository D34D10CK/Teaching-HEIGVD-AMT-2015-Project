package ch.heigvd.amt.amtproject.rest.dto;

import javax.ejb.Stateless;

@Stateless
public class LevelDTO {

    private String name;
    private int requiredPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }
}
