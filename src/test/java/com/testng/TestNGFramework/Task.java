package com.testng.TestNGFramework;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.testng.annotations.Test;

public class Task {
	static Scanner s = new Scanner(System.in);

	@Test(enabled = false)
	public void fibannociSeries() {
		int x = 0;
		int y = 1;
		int c = 0;

		System.out.print("Enter the number ");
		int a = s.nextInt();
		for (int i = 0; i < a; i++) {
			c = x + y;
			System.out.println(c);
			x = y;
			y = c;

		}
		// System.out.println(c);
	}

	@Test(enabled = false)
	public void armstrongNumber() {
		System.out.println("Enter the number : ");
		int num = s.nextInt();
		int temp = num;
		int a = 0;
		int total = 0;
		while (temp > 0) {
			a = temp % 10;
			total = total + a * a * a;
			temp = temp / 10;

		}
		if (total == num) {
			System.out.println("This is Armstrong Number");
		} else {
			System.out.println("This is not Armstrong Number");
		}
		System.out.println(total);
	}

	@Test
	public void repeatedProgram() {
		String a = "by the people for the people of the people";
		String b[] = a.split(" ");
		Map<String, Integer> entry = new HashMap();
		for (String i : b) {
			if (entry.containsKey(i)) {
				Integer n = entry.get(i);
//				System.out.println(n);
				entry.put(i, n + 1);
			} else {
				entry.put(i, 1);
			}
		}
		
		System.out.println(entry);
		Set<Entry<String,Integer>> itr = entry.entrySet();
		for(Entry<String, Integer> value:itr) {
			System.out.println(value.getKey()+"   =    "+value.getValue());
		}
	}

	@Test(enabled = false)
	public void factorialNumber() {
		System.out.println("Enter the number : ");
		int num = s.nextInt();
		int total=1;
		for (int i = num; i > 0; i--) {
			total = total * i;
		}
		System.out.println(total);

	}
}
