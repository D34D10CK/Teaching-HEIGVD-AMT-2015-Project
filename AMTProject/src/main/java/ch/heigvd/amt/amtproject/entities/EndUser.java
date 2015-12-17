package ch.heigvd.amt.amtproject.entities;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({
    @NamedQuery(name = "EndUser.findByApp", query = "select e from EndUser e where e.app = :app"),
    @NamedQuery(name = "EndUser.findByAppAndUserId", 
            query = "select e from EndUser e where e.userId = :userid")
})
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"app_id", "userid"}))
public class EndUser extends AbstractEntity<Long> {

    @Column(nullable = false)
    private String userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Calendar dateCrea;

    @ManyToOne
    private Application app;

    @OneToMany(mappedBy = "endUser")
    List<PointAward> points;

    @OneToMany(mappedBy = "endUser")
    List<BadgeAward> badges;

    public EndUser() {
        userId = UUID.randomUUID().toString();
    }

    public EndUser(String userId, Calendar dateCrea, Application app) {
        this.userId = userId;
        this.dateCrea = dateCrea;
        this.app = app;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String UserId) {
        this.userId = UserId;
    }

    public Calendar getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Calendar dateCrea) {
        this.dateCrea = dateCrea;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public List<PointAward> getPoints() {
        return points;
    }

    public void setPoints(List<PointAward> points) {
        this.points = points;
    }

    public List<BadgeAward> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeAward> badges) {
        this.badges = badges;
    }
}
