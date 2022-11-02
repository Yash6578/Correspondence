package com.ashokit.correspondence.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeDetails {
	String citizenName;
	String citizenEmail;
	String planName;
	Character planStatus;
	LocalDate planStartDate;
	LocalDate planEndDate;
	Double benefitAmt; 
	String denialReason;
}
