package com.anji.finance.ccfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anjiboddupally
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppError {

	private String timestamp;
	
	private Integer status;
	
	private String error;
	
	private String path;
	
	
	
}
