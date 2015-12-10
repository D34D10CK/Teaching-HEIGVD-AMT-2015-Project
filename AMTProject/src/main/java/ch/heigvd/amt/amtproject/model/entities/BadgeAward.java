package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BadgeAward extends Award {

    @NotNull
    private Badge badge;

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
