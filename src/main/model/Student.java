package main.model;

import main.IEntity;

public class Student extends AbstractPerson implements IEntity {
	
	
	private String nationalNumber;
	private String adress;
	private String dateNaissance;
	private char Sexe;
	private int nationalite;
	private int lieudeNaissance;
	private String zipCode;
	private int city;
	private String phone;
	private String GSM;
	
	public Student()
	{}
	public Student(String login, String passWord, String firstName, String lastName, String email,
			String nationalNumber, String adress, String zipCode, int city, String phone) {
		super(login, passWord, firstName, lastName, email);
		this.nationalNumber = nationalNumber;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.phone = phone;
	}
	
	public Student(Student student)
	{
		super(student.login, student.passWord, student.firstName, student.lastName, student.email);
		this.nationalNumber = student.nationalNumber;
		this.adress = student.adress;
		this.zipCode = student.zipCode;
		this.city = student.city;
		this.phone = student.phone;
	}
	public String getGSM() {
		return GSM;
	}
	public void setGSM(String gsm) 
	{
		GSM = gsm;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public char getSexe() {
		return Sexe;
	}
	public void setSexe(char sexe) {
		Sexe = sexe;
	}
	public int getNationalite() {
		return nationalite;
	}
	public void setNationalite(int nationalite) {
		this.nationalite = nationalite;
	}
	public int getLieudeNaissance() {
		return lieudeNaissance;
	}
	public void setLieudeNaissance(int lieudeNaissance) {
		this.lieudeNaissance = lieudeNaissance;
	}

	public String getNationalNumber() {
		return nationalNumber;
	}

	public void setNationalNumber(String nationalNumber) {
		this.nationalNumber = nationalNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return this.lastName+" "+this.firstName; 
		/*return "Student [nationalNumber=" + nationalNumber + ", adress=" + adress + ", zipCode=" + zipCode + ", city="
				+ city + ", phone=" + phone + ", login=" + login + ", passWord=" + passWord + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";*/
	}
	
	@Override
	public Student clone()
	{ return new Student(this); }
	
}
