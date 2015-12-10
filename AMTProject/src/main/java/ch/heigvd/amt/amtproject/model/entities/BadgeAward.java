package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(name = "BadgeAward.getBadgesOfUser", query = "select b from BadgeAward b where b.endUser.id = :user")
})
@Entity
public class BadgeAward extends Award {

    @OneToOne
    private Badge badge;

    @ManyToOne
    private EndUser endUser;

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
