package com.anji.finance.ccfc.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author anjiboddupally
 *
 */

@Entity
@Table(name = "CcInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ccNo")
	private String ccNo;

	@Column(name = "expDate")
	private LocalDate expDate;

}
