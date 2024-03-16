package com.ysoftech.learning.dvdproject;

import com.ysoftech.learning.dvdproject.repository.FilmSpringDataJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = DvdProjectApplication.class)
@ExtendWith(SpringExtension.class)
class DvdProjectApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	private AddressService addressService;

	@Autowired
	private FilmSpringDataJpaRepository filmRepository;

	@Test
	void contextLoads() {
//		logger.info("Addresses: => {}", addressService.getAllAddressLazyTest());
	}

	@Test
	void filmTest() {
		logger.info("Films => {}", filmRepository.findAll());
	}

}