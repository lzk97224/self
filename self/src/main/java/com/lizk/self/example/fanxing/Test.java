package com.lizk.self.example.fanxing;

public class Test {
	public static void main(String[] args) {
		
		Manager mgr1 = new Manager("Jack", 10000.99);
		Manager mgr2 = new Manager("Tom", 10001.01);
		Pair<Manager> managerPair = new Pair<Manager>(mgr1, mgr2);
		printEmployeeBoddies(managerPair);
		
	}

	
	public static void printEmployeeBoddies(Pair<? extends Employee> pair){
		System.out.println(pair.getFirst().getName() + ":" + pair.getSecond().getName());
	}


}	
