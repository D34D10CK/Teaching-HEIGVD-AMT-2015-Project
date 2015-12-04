package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = "Badge.findAllByApiKey", query = "")
})
public class Badge extends AbstractEntity<Long> {

    // TODO comment modifier pour avoir un nom unique par badge
    // d'une même application mais pouvant être utilisé par une
    // autre application
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    private String imageUrl;

    @ManyToOne
    private Application app;

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

    public String getPictureUrl() {
        return imageUrl;
    }

    public void setPictureUrl(String url) {
        imageUrl = url;
    }

    public void setApp(Application app) {
        this.app = app;
    }
}
