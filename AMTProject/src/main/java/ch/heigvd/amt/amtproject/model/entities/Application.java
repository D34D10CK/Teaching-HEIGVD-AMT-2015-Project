package ch.heigvd.amt.amtproject.model.entities;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = "Application.findByApiKey", query = "select a from Application a where a.apiKey = :apiKey"), 
    @NamedQuery(name = "Application.findByUser", query = "select a from Application a where a.user = :user")})
public class Application extends AbstractEntity<Long> {


    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    private String name;
    
    @NotNull
    private String description;
    
    @NotNull
    private boolean enable;
    
    @OneToMany(mappedBy="app")
    private List<User> users;
    
    @OneToOne
    private ApiKey apiKey;
    
    public Application() {
    }

    public Application(ApiKey apiKey, User user, String name, String description) {
        this.apiKey = apiKey;
        this.user = user;
        this.name = name;
        this.description = description;
    }
    
    

    public ApiKey getApiKey() {
        return apiKey;
    }

    public void setApiKey(ApiKey apiKey) {
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
