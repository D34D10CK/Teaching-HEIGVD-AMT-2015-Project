package ch.heigvd.amt.amtproject.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reputation extends AbstractEntity<Long> {

    @Column(columnDefinition = "Integer default 0")
    private int points;

    @OneToMany
    private List<Badge> badges;

    @ManyToOne
    private UserLevel level;

    public Reputation(List<Badge> badges, UserLevel level) {
        this.level = level;
        this.badges = badges;
    }

    public Reputation() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

}
