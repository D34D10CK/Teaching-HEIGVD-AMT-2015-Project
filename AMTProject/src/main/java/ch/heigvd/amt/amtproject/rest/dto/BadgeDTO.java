package ch.heigvd.amt.amtproject.rest.dto;


public class BadgeDTO extends BadgeSummaryDTO {

    private String name;
    private String imageUrl;

	public BadgeDTO() {
	}

	public BadgeDTO(String name, String imageUrl) {
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
	public void setName(String name) {
		this.name = name;
	}
}
