package ch.heigvd.amt.amtproject.rest.dto;


public class BadgeDTO extends BadgeSummaryDTO {

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
