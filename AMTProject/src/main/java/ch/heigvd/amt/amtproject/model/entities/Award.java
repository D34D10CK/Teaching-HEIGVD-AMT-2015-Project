package ch.heigvd.amt.amtproject.model.entities;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    public Award(Calendar obtainmentDate, String reason) {
        this.reason = reason;
        this.obtainmentDate = obtainmentDate;
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
}
