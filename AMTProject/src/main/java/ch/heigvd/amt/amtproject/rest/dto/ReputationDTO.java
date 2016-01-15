package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.entities.Badge;
import java.util.List;

public class ReputationDTO {

    private List<BadgeDTO> badges;
    private long points;
    private String level;

    public List<BadgeDTO> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeDTO> badges) {
        this.badges = badges;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
}
