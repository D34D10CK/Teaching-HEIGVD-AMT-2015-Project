package ch.heigvd.amt.amtproject.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "BadgeAward.getBadgesOfUser", 
            query = "select b.badge from BadgeAward b where b.user.userId = :userId and b.user.app = :app")
})

@Entity
public class BadgeAward extends Award {

    @ManyToOne//(mappedBy="badgeAwards")
    private Badge badge;
    
    @ManyToOne
    private EndUser user;
    
    public BadgeAward(){ }

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
