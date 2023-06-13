package com.anji.finance.ccfc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "CcFraudScoreInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcFraudScoreInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ccId", referencedColumnName = "id")
	private CcInfo ccId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ccIssuerId", referencedColumnName = "id")
	private CcIssuerInfo ccIssuerId;

	@Column(name = "score")
	private int score;

}
