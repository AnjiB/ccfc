package com.anji.finance.ccfc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anji.finance.ccfc.dto.CCFraudInfo;
import com.anji.finance.ccfc.service.FraudService;

/**
 * @author anjiboddupally
 *
 */

@RestController
@RequestMapping("/v1/fraudcheck")
public class FraudController {

	@Autowired
	FraudService fraudService;

	@GetMapping(value = "/score", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CCFraudInfo> getTutorialById(@RequestParam(name = "cc", required = true) String ccNo,
			@RequestParam(name = "exp", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expDate) {
		try {
			return new ResponseEntity<>(fraudService.getFraudInfo(ccNo, expDate), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
