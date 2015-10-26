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
    @NamedQuery(name = "Application.findByApiKey", query = "select a from Application a where a.apiKey = :apiKey"), 
    @NamedQuery(name = "Application.findByUser", query = "select a from Application a where a.user = :user")})
public class Application extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String apiKey;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    private String name;
    
    @NotNull
    private String description;
    
    @NotNull
    private boolean enable;
    
    public Application() {
    }

    public Application(String apiKey, User user, String name, String description) {
        this.apiKey = apiKey;
        this.user = user;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    
}
