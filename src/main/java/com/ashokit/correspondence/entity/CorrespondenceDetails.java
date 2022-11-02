package com.ashokit.correspondence.entity;

import javax.persistence.*;

@Entity
@Table(name = "CORRESPONDENCE_DETAILS")
public class CorrespondenceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CORRESPONDENCE_ID")
	Long correspondenceId;
	
	@Column(name = "CASE_NUMBER")
	Long caseNo;
	
	@Column(name = "SEND_STATUS")
	Character sendStatus;

	@Lob
	@Column(name = "PDF")
	byte[] pdf;
}
