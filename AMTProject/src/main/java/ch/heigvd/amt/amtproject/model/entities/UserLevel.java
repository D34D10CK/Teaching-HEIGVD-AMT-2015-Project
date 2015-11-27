package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class UserLevel extends AbstractEntity<Long> {

    @NotNull
    private String name;

    @NotNull
    private int requiredPoints;

    public UserLevel(String name, int requiredPoints) {
        this.name = name;
        this.requiredPoints = requiredPoints;
    }

    public UserLevel() {
    }

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
