package ch.heigvd.amt.amtproject.model.entities;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public abstract class Award extends AbstractEntity<Long> {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar obtainmentDate;

    @NotNull
    private String reason;
    
    @ManyToOne
    private EndUser user;

    public Award(Calendar obtainmentDate, String reason, EndUser user) {
        this.reason = reason;
        this.obtainmentDate = obtainmentDate;
        this.user = user;
    }

    public Award() {
    }

    public Calendar getObtainmentDate() {
        return obtainmentDate;
    }

    public void setObtainmentDate(Calendar obtainmentDate) {
        this.obtainmentDate = obtainmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public EndUser getUser() {
        return user;
    }

    public void setUser(EndUser user) {
        this.user = user;
    }
    
    
}
