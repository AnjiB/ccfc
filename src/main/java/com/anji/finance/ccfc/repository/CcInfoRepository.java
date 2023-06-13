package com.anji.finance.ccfc.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anji.finance.ccfc.entity.CcInfo;

/**
 * @author anjiboddupally
 *
 */

public interface CcInfoRepository extends JpaRepository<CcInfo, Long> {
	
    public CcInfo findByCcNo(String ccNumber);
    
    public CcInfo findByExpDate(LocalDate expDate);
}
