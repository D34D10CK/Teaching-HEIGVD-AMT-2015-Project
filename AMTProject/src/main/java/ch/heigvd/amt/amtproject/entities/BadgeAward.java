package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(name = "BadgeAward.getBadgesOfUser", query = "select b from BadgeAward b where b.endUser.id = :user")
})

@Entity
public class BadgeAward extends Award {

    @OneToMany(mappedBy="badgeAwards")
    private Badge badge;
    
    @ManyToOne
    private EndUser user;

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public EndUser getUser() {
        return user;
    }

    public void setUser(EndUser user) {
        this.user = user;
    }
}
