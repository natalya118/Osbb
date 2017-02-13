package com.osbb.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Requests")
public class Request implements Serializable{

	
	@Id
	@NotEmpty
	@Column(name="request_id", nullable=false)
	private Integer requestId;

	@NotEmpty
	@Column(name="request_date")
	private String RequestDate;
	
	@NotEmpty
	@Column(name="request_author_id")
	private String requestAuthorId;
	
	@NotEmpty
	@Column(name="request_osbb_id")
	private String requestOsbbId;
	
	@NotEmpty
	@Column(name="request_title", nullable=false)
	private String requestTitle;

	@NotEmpty
	@Column(name="request_body", nullable=false)
	private String requestBody;

	
	@Column(name="request_voting_id")
	private String requestVotingId;


	public Integer getRequestId() {
		return requestId;
	}


	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}


	public String getRequestDate() {
		return RequestDate;
	}


	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}


	public String getRequestAuthorId() {
		return requestAuthorId;
	}


	public void setRequestAuthorId(String requestAuthorId) {
		this.requestAuthorId = requestAuthorId;
	}


	public String getRequestOsbbId() {
		return requestOsbbId;
	}


	public void setRequestOsbbId(String requestOsbbId) {
		this.requestOsbbId = requestOsbbId;
	}


	public String getRequestTitle() {
		return requestTitle;
	}


	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}


	public String getRequestBody() {
		return requestBody;
	}


	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}


	public String getRequestVotingId() {
		return requestVotingId;
	}


	public void setRequestVotingId(String requestVotingId) {
		this.requestVotingId = requestVotingId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RequestDate == null) ? 0 : RequestDate.hashCode());
		result = prime * result + ((requestAuthorId == null) ? 0 : requestAuthorId.hashCode());
		result = prime * result + ((requestBody == null) ? 0 : requestBody.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((requestOsbbId == null) ? 0 : requestOsbbId.hashCode());
		result = prime * result + ((requestTitle == null) ? 0 : requestTitle.hashCode());
		result = prime * result + ((requestVotingId == null) ? 0 : requestVotingId.hashCode());
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
		Request other = (Request) obj;
		if (RequestDate == null) {
			if (other.RequestDate != null)
				return false;
		} else if (!RequestDate.equals(other.RequestDate))
			return false;
		if (requestAuthorId == null) {
			if (other.requestAuthorId != null)
				return false;
		} else if (!requestAuthorId.equals(other.requestAuthorId))
			return false;
		if (requestBody == null) {
			if (other.requestBody != null)
				return false;
		} else if (!requestBody.equals(other.requestBody))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (requestOsbbId == null) {
			if (other.requestOsbbId != null)
				return false;
		} else if (!requestOsbbId.equals(other.requestOsbbId))
			return false;
		if (requestTitle == null) {
			if (other.requestTitle != null)
				return false;
		} else if (!requestTitle.equals(other.requestTitle))
			return false;
		if (requestVotingId == null) {
			if (other.requestVotingId != null)
				return false;
		} else if (!requestVotingId.equals(other.requestVotingId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", RequestDate=" + RequestDate + ", requestAuthorId="
				+ requestAuthorId + ", requestOsbbId=" + requestOsbbId + ", requestTitle=" + requestTitle
				+ ", requestBody=" + requestBody + ", requestVotingId=" + requestVotingId + "]";
	}


	
}
