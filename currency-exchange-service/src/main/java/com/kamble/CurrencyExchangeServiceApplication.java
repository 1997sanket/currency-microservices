package com.kamble;

import com.kamble.currencyexchange.CurrencyExchange;
import com.kamble.currencyexchange.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}


	@PostConstruct
	public void insertValuesInDataBase() {
		List<CurrencyExchange> list = List.of(
				new CurrencyExchange(1001L, "USD", "INR", BigDecimal.valueOf(65.00)),
				new CurrencyExchange(1002L, "EUR", "INR", BigDecimal.valueOf(75.00)),
				new CurrencyExchange(1003L, "AUD", "INR", BigDecimal.valueOf(25.00))
				);

		currencyExchangeRepository.saveAll(list);
	}
}
