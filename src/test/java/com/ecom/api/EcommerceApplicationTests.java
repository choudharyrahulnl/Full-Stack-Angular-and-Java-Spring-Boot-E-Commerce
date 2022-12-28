package com.ecom.api;

import com.ecom.api.services.impl.CountryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class EcommerceApplicationTests {

	@Autowired
	private CountryServiceImpl countryService;

	@Test
	void contextLoads() {
	}

//	@Test
//	@Sql(scripts = "insert-countries.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//	@Sql(scripts = "delete-countries.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	void listAllCountries() {
//		assertEquals(countryService.findAll(),6);
//	}

}
