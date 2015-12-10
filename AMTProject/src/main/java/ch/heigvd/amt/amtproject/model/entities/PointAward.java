package ch.heigvd.amt.amtproject.model.entities;

import javax.validation.constraints.NotNull;

public class PointAward extends Award {

    @NotNull
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
