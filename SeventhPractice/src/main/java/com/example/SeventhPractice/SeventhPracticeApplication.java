package com.example.SeventhPractice;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SeventhPracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SeventhPracticeApplication.class, args);
		StudentService ss = context.getBean(StudentService.class);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.create \n 2.read \n 3.update \n 4.delete");
			System.out.println("eneter ur choice");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter name");
				String nameString = sc.next();
				System.out.println("enter age");
				int age = sc.nextInt();
				ss.addStudent(nameString, age);
				break;
			case 2:
				System.out.println("All students");
				ss.getAllStudents().forEach(System.out::println);
				break;
			case 3:
				System.out.println("Enter id");
				Long idLong = sc.nextLong();
				System.out.println("Enter name");
				String nameSt = sc.next();
				System.out.println("enter age");
				int ageint = sc.nextInt();
				ss.updateStudent(idLong, nameSt, ageint);
				break;
			case 4:
				System.out.println("Enter id to delete");
				Long idLong2 = sc.nextLong();
				ss.deleteStudent(idLong2);
				break;
			case 5:
				context.close();
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}
	}

}
