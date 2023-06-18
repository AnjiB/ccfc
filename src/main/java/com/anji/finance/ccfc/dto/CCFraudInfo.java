package com.anji.finance.ccfc.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author anjiboddupally
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class CCFraudInfo extends AppError {

	private String ccNumber;
	
	private LocalDate issueDate;

	private LocalDate expDate;
	
	private FraudProps fraudProps;
	
	@Builder
    public CCFraudInfo(String timeStamp, int status, String error, String path, 
    		String ccNumber, LocalDate issueDate, LocalDate expDate, FraudProps fraudProps) {
        super(timeStamp, status, error, path);
        this.ccNumber = ccNumber;
        this.issueDate = issueDate;
        this.expDate = expDate;
        this.fraudProps = fraudProps;
    }
	
}
