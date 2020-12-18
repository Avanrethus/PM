/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kozik.PracaMagisterska.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Avanrethus
 */
@ConfigurationProperties(prefix="storage")
public class StorageProperties {
    
    	/**
	 * Folder location for storing files
	 */
	private String location = "C:\\Users\\Windows\\Desktop\\Magisterskie Semestr III\\PracaMagisterka\\uploadFiles";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
