package com.microservice.inventory_service;

import com.microservice.inventory_service.repository.InventoryRepository;
import com.microservice.inventory_service.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args ->{
			Inventory inventory = new Inventory();
			inventory.setSkuCode(("Iphone_13"));
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode(("Iphone_13_red"));
			inventory1.setQuantity(5);


			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);


		} ;
	}

}
