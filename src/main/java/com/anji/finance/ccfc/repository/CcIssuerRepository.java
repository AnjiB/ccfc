package com.anji.finance.ccfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anji.finance.ccfc.entity.CcIssuerInfo;

/**
 * @author anjiboddupally
 *
 */

public interface CcIssuerRepository extends JpaRepository<CcIssuerInfo, Long> {
	
	 public CcIssuerInfo findByCcNo(String ccNumber);
 
}
