package com.anji.finance.ccfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anji.finance.ccfc.entity.CcFraudScoreInfo;

/**
 * @author anjiboddupally
 *
 */
public interface CcFraudScoreRepository extends JpaRepository<CcFraudScoreInfo, Long> {
	
	@Query("SELECT ccf FROM CcFraudScoreInfo ccf WHERE ccf.ccId.id=:ccId AND ccf.ccIssuerId.id = :ccIssuerId")
	CcFraudScoreInfo findByCcIdAndCcIssuerId(@Param("ccId") Long ccId, @Param("ccIssuerId") Long ccIssuerId);
}
