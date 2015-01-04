package main.model;

import main.IEntity;

public abstract class AbstractPerson implements IEntity {
	
	protected int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String login;
	protected String passWord;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected boolean isDel;
	protected AbstractPerson()
	{}
	
	protected AbstractPerson(String login, String passWord, String firstName, String lastName, String email) {
		this.login = login;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	protected AbstractPerson(AbstractPerson person) {
		this.login = person.login;
		this.passWord = person.passWord;
		this.firstName = person.firstName;
		this.lastName = person.lastName;
		this.email = person.email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractPerson [login=" + login + ", passWord=" + passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPerson other = (AbstractPerson) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	public int getIdentifier() {
		return this.id;
	}

	public String getLabel() {
		return this.login + " - " + this.lastName + " " + this.firstName;
	}
	
	public abstract AbstractPerson clone();

	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}
}
