/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.rest.dto;

import java.net.URI;


public class BadgeSummaryDTO {
    private URI href;
	private String name;
	private String imageUrl;

    public void setHref(URI href) {
        this.href = href;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getHref() {
        return href;
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
}
