package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Pedro Rocha", "pedro@gmail.com", "5517985623692", "21684132"); 
		User u2 = new User(null, "Ana Maria", "ana@gmail.com", "5581998651478", "18943213"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));	
		
		Order o1 = new Order(null, Instant.parse("2022-09-20T15:23:08Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2022-11-21T09:23:25Z"), OrderStatus.CANCELED, u2); 
		Order o3 = new Order(null, Instant.parse("2022-12-22T19:14:01Z"), OrderStatus.SHIPPED, u1);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));	
	}	
}
