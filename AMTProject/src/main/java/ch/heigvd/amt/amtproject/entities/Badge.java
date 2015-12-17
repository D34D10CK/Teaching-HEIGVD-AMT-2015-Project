package ch.heigvd.amt.amtproject.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = "Badge.findAllByApiKey", 
            query = "select b from Badge b, Application a where b.app = a and a.apiKey.apiKey = :apiKey"),
    @NamedQuery(name = "Badge.findByNameAndApp",
            query = "select b from Badge b where b.app = :app and b.name = :name")
})
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"app_id", "name"}))
public class Badge extends AbstractEntity<Long> {

    @Column(nullable = false)
    private String name;

    @NotNull
    private String imageUrl;

    @ManyToOne
    private Application app;
    
    @ManyToOne
    private List<BadgeAward> badgeAwards;

    public Badge(String name, String url, Application app) {
        this.name = name;
        imageUrl = url;
        this.app = app;
    }

    public Badge() {
    }

    public String getName() {
        return name;
    }

    public Application getApp() {
        return app;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        imageUrl = url;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public List<BadgeAward> getBadgeAwards() {
        return badgeAwards;
    }

    public void setBadgeAwards(List<BadgeAward> badgeAwards) {
        this.badgeAwards = badgeAwards;
    }
    
    
}
