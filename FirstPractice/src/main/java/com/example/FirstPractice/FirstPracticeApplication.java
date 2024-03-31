package com.example.FirstPractice;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstPracticeApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SpringApplication.run(FirstPracticeApplication.class, args);
		ApplicationContext aContext = new ClassPathXmlApplicationContext("customer_ticket.xml");
		Customer c = aContext.getBean("cust", Customer.class);
		Ticket t = c.getTicket();
		
		while(true) {
			System.out.println("1.insert \n 2.display \n 3.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("Enter customer name");
				c.setName(scanner.next());
				System.out.println("Enter address");
				c.setAddress(scanner.next());
				System.out.println("Enter ticket details\n Enter ticket number");
				t.setTicketNo(scanner.nextInt());
				System.out.println("Enter ticket price");
				t.setPrice(scanner.nextInt());
				System.out.println("Enter seat number");
				t.setSeatNo(scanner.nextInt());
				System.out.println("Enter ticket type");
				t.setTicketType(scanner.next());
				break;
			case 2:
				System.out.println("customer details");
				System.out.println("Name: " + c.getName());
				System.out.println("Address: " + c.getAddress());
				System.out.println("Ticket no. " + t.getTicketNo());
				System.out.println("Ticket price: "+ t.getPrice());
				System.out.println("Seat number:" + t.getSeatNo());
				System.out.println("Ticket type: "+ t.getTicketType());
				break;
			case 3:
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
