package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.model.entities.Level;
import java.net.URI;

public class LevelDTO {

    private String name;
    private int requiredPoints;
    private URI href;

    public LevelDTO() {
    }

    public LevelDTO(Level level) {
        name = level.getName();
        requiredPoints = level.getRequiredPoints();
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

    public URI getHref() {
        return href;
    }

    public void setHref(URI href) {
        this.href = href;
    }
}
