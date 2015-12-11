package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.model.entities.Badge;
import java.util.List;

public class ReputationDTO {

    private List<Badge> badges;
    private int points;

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
