package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(name = "Level.findByApiKey", query = "select l from Level l where l.application.apiKey.apiKey = :apiKey")
})

@Entity
@Table(name = "Levels")
public class Level extends AbstractEntity<Long> {

    @ManyToOne
    private Application application;

    @NotNull
    private String name;

    @NotNull
    private int requiredPoints;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }
}
