package com.ashokit.correspondence.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CORRESPONDENCE_STATUS")
public class CorrespondenceStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CORRESPONDENCE_ID")
	Long correspondenceId;
	
	@Column(name = "CASE_NUMBER")
	Long caseNo;
	
	@Column(name = "SEND_STATUS")
	Character sendStatus;
	
	
	//NOTICE		BLOB
}
