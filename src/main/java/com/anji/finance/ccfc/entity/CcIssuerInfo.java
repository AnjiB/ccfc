package com.anji.finance.ccfc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author anjiboddupally
 *
 */

@Entity
@Table(name = "CcIssuerInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcIssuerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ccNo")
	private String ccNo;

	@Column(name = "issueDate")
	private LocalDate issueDate;
	
	@Column(name = "issuer")
	private String issuer;
	
	
}
