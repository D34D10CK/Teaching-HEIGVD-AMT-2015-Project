package ch.heigvd.amt.amtproject.model.entities;

import javax.validation.constraints.NotNull;

public class BadgeAward {

    @NotNull
    private Badge badge;

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
