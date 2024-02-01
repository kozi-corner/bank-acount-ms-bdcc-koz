package net.kozi.customerservice;

import net.kozi.customerservice.config.GlobalConfig;
import net.kozi.customerservice.entities.Customer;
import net.kozi.customerservice.repos.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
//@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.lastName("Abdelhamid")
							.firstName("Taoufiqallah")
							.email("abdelhamid@gmail.com")
							.build(),
					Customer.builder()
							.lastName("Maria")
							.firstName("Bella")
							.email("maria@gmail.com")
							.build()
			);
			customerRepo.saveAll(customerList);

		};
	}

}
