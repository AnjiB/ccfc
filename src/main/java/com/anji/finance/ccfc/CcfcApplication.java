package com.anji.finance.ccfc;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anjiboddupally
 *
 */

@SpringBootApplication
public class CcfcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcfcApplication.class, args);
		
		System.out.println(LocalDate.now().toString());
	}

}
