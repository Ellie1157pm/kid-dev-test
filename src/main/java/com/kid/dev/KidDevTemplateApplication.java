package com.kid.dev;

import com.kid.dev.domain.ArraySort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KidDevTemplateApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(KidDevTemplateApplication.class, args);

		// No.1 Construct Array Sort Object
		ArraySort arraySort = new ArraySort();

		// No.1 Sort Array
		arraySort.sort();
	}

}
