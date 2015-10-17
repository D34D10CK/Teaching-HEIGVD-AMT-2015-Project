package ch.heigvd.amt.amtproject.model.entities;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = "Application.findByApiKey", query = "select a from Application a where a.apiKey = :apiKey")
})
public class Application extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String apiKey;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    private String name;
    
    public Application() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
