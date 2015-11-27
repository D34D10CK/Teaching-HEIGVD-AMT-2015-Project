package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Badge extends AbstractEntity<Long> {

    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Lob
    private byte[] picture;

    @ManyToOne
    private Application app;

    public Badge(String name, byte[] picture, Application app) {
        this.name = name;
        this.picture = picture;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setApp(Application app) {
        this.app = app;
    }
}
