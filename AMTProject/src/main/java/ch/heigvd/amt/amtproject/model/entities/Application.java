package ch.heigvd.amt.amtproject.model.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({

    @NamedQuery(name = "Application.findByApiKey", query = "select a from Application a where a.apiKey.apiKey = :apiKey"),
    @NamedQuery(name = "Application.findByUser", query = "select a from Application a where a.account = :user"),
    @NamedQuery(name = "Application.findNumberByUser" , query = "select count(eu) from Application a, EndUser eu where eu.app = a and a.account = :user group by eu.app")
})

public class Application extends AbstractEntity<Long> {

    @NotNull
    @ManyToOne
    private Account account;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private boolean enable;

    @OneToOne
    private ApiKey apiKey;

    @OneToMany(mappedBy = "app")
    private List<EndUser> endUsers;

    @OneToMany(mappedBy = "app")
    private List<Badge> badges;

    @OneToMany(mappedBy = "application")
    private List<Level> levels;

    @OneToMany
    private List<Rule> rules;
    
    public Application() {
    }

    public Application(ApiKey apiKey, Account user, String name, String description, boolean enable) {
        this.apiKey = apiKey;
        this.account = user;
        this.name = name;
        this.description = description;
        this.enable = enable;
    }

    public ApiKey getApiKey() {
        return apiKey;
    }

    public void setApiKey(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public Account getUser() {
        return account;
    }

    public void setUser(Account user) {
        this.account = user;
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

    public List<EndUser> getEndUsers() {
        return endUsers;
    }

    public Account getAccount() {
        return account;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setEndUsers(List<EndUser> endUsers) {
        this.endUsers = endUsers;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
