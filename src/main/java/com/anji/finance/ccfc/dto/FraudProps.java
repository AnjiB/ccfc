package com.anji.finance.ccfc.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author anjiboddupally
 *
 */

@Data
@Builder
public class FraudProps {
	
	private String issuer;
	
	private int fraudScore;

}
