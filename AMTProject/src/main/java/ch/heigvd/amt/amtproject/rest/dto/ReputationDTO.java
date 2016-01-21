package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.entities.Badge;
import java.util.List;

public class ReputationDTO {

    private List<BadgeDTO> badges;
    private long points;
	private String level;
	private long nextLevel;
	private long prevLevel;

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

	public long getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(long nextLevel) {
		this.nextLevel = nextLevel;
	}
	public long getPrevLevel() {
		return prevLevel;
	}

	public void setPrevLevel(long prevLevel) {
		this.prevLevel = prevLevel;
	}
    
}
