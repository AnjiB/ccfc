package com.anji.finance.ccfc.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.finance.ccfc.dto.CCFraudInfo;
import com.anji.finance.ccfc.dto.FraudProps;
import com.anji.finance.ccfc.entity.CcFraudScoreInfo;
import com.anji.finance.ccfc.entity.CcInfo;
import com.anji.finance.ccfc.entity.CcIssuerInfo;
import com.anji.finance.ccfc.repository.CcFraudScoreRepository;
import com.anji.finance.ccfc.repository.CcInfoRepository;
import com.anji.finance.ccfc.repository.CcIssuerRepository;

/**
 * @author anjiboddupally
 *
 */

@Service
public class FraudService {

	@Autowired
	private CcInfoRepository ccInfoRepository;

	@Autowired
	private CcIssuerRepository ccIssuerRepository;

	@Autowired
	private CcFraudScoreRepository ccFraudScoreRepository;

	public CCFraudInfo getFraudInfo(String ccNumber, LocalDate expDate) {

		CcInfo ccInfo = ccInfoRepository.findByCcNo(ccNumber);

		CcIssuerInfo ccIssuerInfo = ccIssuerRepository.findByCcNo(ccNumber);

		CcFraudScoreInfo score = ccFraudScoreRepository.findByCcIdAndCcIssuerId(ccInfo.getId(),
				ccIssuerInfo.getId());

		FraudProps fp = FraudProps.builder().fraudScore(score.getScore()).issuer(ccIssuerInfo.getIssuer()).build();

		CCFraudInfo fInfo = CCFraudInfo.builder().ccNumber(ccNumber).expDate(expDate)
				.issueDate(ccIssuerInfo.getIssueDate()).fraudProps(fp).build();

		return fInfo;
	}

}
