package com.osbb.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="News")
public class News implements Serializable{
	@Id
	@NotEmpty
	@Column(name="news_id", nullable=false)
	private String newsId;
	
	@NotEmpty
	@Column(name="news_date", nullable = false)
	private Date newsDate;
	
	@NotEmpty
	@Column(name="news_title", nullable = false)
	private String newsTitle;
	
	@NotEmpty
	@Column(name="news_body", nullable = false)
	private String newsBody;
	
	
	@Column(name="news_photo")
	private byte[] newsPhoto;
	
	@Column(name="news_author_id")
	private String newsAuthorId;
	
	@Column(name="news_osbb_id")
	private String newsOsbbId;

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

	public byte[] getNewsPhoto() {
		return newsPhoto;
	}

	public void setNewsPhoto(byte[] newsPhoto) {
		this.newsPhoto = newsPhoto;
	}

	public String getNewsAuthorId() {
		return newsAuthorId;
	}

	public void setNewsAuthorId(String newsAuthorId) {
		this.newsAuthorId = newsAuthorId;
	}

	public String getNewsOsbbId() {
		return newsOsbbId;
	}

	public void setNewsOsbbId(String newsOsbbId) {
		this.newsOsbbId = newsOsbbId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newsAuthorId == null) ? 0 : newsAuthorId.hashCode());
		result = prime * result + ((newsBody == null) ? 0 : newsBody.hashCode());
		result = prime * result + ((newsDate == null) ? 0 : newsDate.hashCode());
		result = prime * result + ((newsId == null) ? 0 : newsId.hashCode());
		result = prime * result + ((newsOsbbId == null) ? 0 : newsOsbbId.hashCode());
		result = prime * result + Arrays.hashCode(newsPhoto);
		result = prime * result + ((newsTitle == null) ? 0 : newsTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (newsAuthorId == null) {
			if (other.newsAuthorId != null)
				return false;
		} else if (!newsAuthorId.equals(other.newsAuthorId))
			return false;
		if (newsBody == null) {
			if (other.newsBody != null)
				return false;
		} else if (!newsBody.equals(other.newsBody))
			return false;
		if (newsDate == null) {
			if (other.newsDate != null)
				return false;
		} else if (!newsDate.equals(other.newsDate))
			return false;
		if (newsId == null) {
			if (other.newsId != null)
				return false;
		} else if (!newsId.equals(other.newsId))
			return false;
		if (newsOsbbId == null) {
			if (other.newsOsbbId != null)
				return false;
		} else if (!newsOsbbId.equals(other.newsOsbbId))
			return false;
		if (!Arrays.equals(newsPhoto, other.newsPhoto))
			return false;
		if (newsTitle == null) {
			if (other.newsTitle != null)
				return false;
		} else if (!newsTitle.equals(other.newsTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsDate=" + newsDate + ", newsTitle=" + newsTitle + ", newsBody="
				+ newsBody + ", newsPhoto=" + Arrays.toString(newsPhoto) + ", newsAuthorId=" + newsAuthorId
				+ ", newsOsbbId=" + newsOsbbId + "]";
	}
	
	
	
}
