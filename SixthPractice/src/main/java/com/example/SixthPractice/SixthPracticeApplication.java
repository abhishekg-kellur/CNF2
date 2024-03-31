package com.example.SixthPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SixthPracticeApplication {
	SessionFactory sf = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sf.openSession();
	
	
	public void insert(int id, String usn, int totalmarks) {
		Transaction tr = session.beginTransaction();
		Student s = new Student();
		s.setId(id);
		s.setTotalmarks(totalmarks);
		s.setUsn(usn);
		session.save(s);
		tr.commit();
	}
	
	public void delete(int id) {
		Transaction tr = session.beginTransaction();
		Query<?> q = session.createQuery("delete from Student where id = :id");
		q.setParameter("id", id);
		int status = q.executeUpdate();
		tr.commit();
		if (status == 0) {
			System.out.println(id + " Deleted successfully");
		} else {
			System.out.println(id + " not found");
		}
	}
	
	public void display() {
		List<Student> students = session.createQuery("from Student", Student.class).list();
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
	}
	
	public static void main(String[] args) {
		SixthPracticeApplication sx = new SixthPracticeApplication();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.insert \n 2.delete \n 3.display \n 4.exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.print("Enter the Student Details to insert \n");
				System.out.print("Enter the Student id \n");
				int id = sc.nextInt();
				System.out.print("Enter the Student usn \n");
				String usn = sc.next();
				System.out.print("Enter the Student totalmarks \n");
				int tm = sc.nextInt();
				sx.insert(id, usn, tm);
				break;
			case 2:
				System.out.print("Enter student id to delete\n");
				System.out.print("Enter the Student id \n");
				int idInt = sc.nextInt();
				sx.delete(idInt);
				break;
			case 3:
				sx.display();
				break;
			case 0:
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}
		
	}

}
