package com.example.SecondPractice;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SecondPracticeApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SpringApplication.run(SecondPracticeApplication.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("college_department.xml");
		Department d = ac.getBean("department", Department.class);
		
		while (true) {
			System.out.println("1.insert \n 2.display \n 3.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Department id");
				d.setId(scanner.nextInt());
				System.out.println("Enter department name");
				d.setName(scanner.next());
				System.out.println("Enter department description");
				d.setDescription(scanner.next());
				scanner.nextLine();
				break;
			case 2:
				System.out.println("Displaying outputs");
				System.out.println("Department details:");
				System.out.println("ID: " + d.getId() + "Name: " + d.getName() + "Description: " + d.getDescription());
				System.out.println("College details");
				College c = d.getCollege();
				System.out.println("Name: " + c.getName() + "Address: " + c.getAddress());
				break;
			case 3:
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
