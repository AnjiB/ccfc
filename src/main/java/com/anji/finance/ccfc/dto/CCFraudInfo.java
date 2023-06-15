package com.anji.finance.ccfc.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * @author anjiboddupally
 *
 */

@Data
@Builder
public class CCFraudInfo {

	private String ccNumber;
	
	private LocalDate issueDate;

	private LocalDate expDate;
	
	private FraudProps fraudProps;
	
	private Error error;
	
}
