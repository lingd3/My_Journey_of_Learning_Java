package com.dan.spring.innerBean;

public class Customer {

	private Person person;

	public Customer(Person p) {
		person = p;
	}

	public Customer() {
	}

	public void setPerson(Person p) {
		person = p;
	}

	@Override
	public String toString() {
		return "Customer [person=" + person + "]";
	}

}
