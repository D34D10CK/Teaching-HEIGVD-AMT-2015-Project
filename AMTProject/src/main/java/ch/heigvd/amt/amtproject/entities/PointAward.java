package ch.heigvd.amt.amtproject.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(name = "PointAward.getPointsOfUser", query = "select sum(p.points) from PointAward p where p.endUser.id = :user")
})
@Entity
public class PointAward extends Award {

    @NotNull
    private int points;

    @ManyToOne
    private EndUser endUser;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
