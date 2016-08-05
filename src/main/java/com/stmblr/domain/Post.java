package com.stmblr.domain;



import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Post extends AbstractDomainClass {

	@NotEmpty
	private String title;
	@NotEmpty
	private String description;

	@NotEmpty
	private String postUrl;

	//private String createDate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrition) {
		this.description = descrition;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	/**
	 * @return the lastUpdated
	 **
	 * 
	 *         /**
	 * @return the createDate
	 */
	/*public String getCreateDate() {
		return createDate;
	}

	*//**
	 * @param createDate
	 *            the createDate to set
	 *//*
	public void setCreateDate() {
		this.createDate = new Date().toString();
	}*/

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * @PreUpdate
	 * 
	 * @PrePersist public void updateTimeStamps() { lastUpdated = new Date(); if
	 * (dateCreated==null) { dateCreated = new Date(); } }
	 */

}
