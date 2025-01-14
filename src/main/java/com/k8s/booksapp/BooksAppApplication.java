package com.k8s.booksapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BooksAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksAppApplication.class, args);
	}
}
