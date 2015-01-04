package main.model;

import main.IEntity;

public class Administrator extends AbstractPerson implements IEntity {

	public Administrator()
	{}
	public Administrator(String login, String passWord, String firstName, String lastName, String email) {
		super(login, passWord, firstName, lastName, email);
	}

	protected Administrator(Administrator administrator) {
		super(administrator);
	}
	
	@Override
	public String toString() {
		return this.firstName+" "+this.lastName;
		/*
		return "Administrator [login=" + login + ", passWord=" + passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";*/
	}

	@Override
	public Administrator clone()
	{ return new Administrator(this); }
}
