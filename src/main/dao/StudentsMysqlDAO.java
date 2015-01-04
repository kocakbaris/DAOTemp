package main.dao;
import main.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import main.AbstractMySQLDAO;
import main.model.Student;



public class StudentsMysqlDAO extends AbstractMySQLDAO<Student> {

	static Connection con;
	@Override
	public List<Student> getListOfEntity() 
	{
		con=main.Connections.OpenConnection();
		String query = "select * from ECI.etudiants;";
				/*"Select id_etudiant,login,mot_de_passe,e.nom,prenom,num_national ,date_naissance,"
				+ "sexe,adresse,l.codepostal,l.id_localite,telephone,mail,GSM,l.localite,p.id_pays"
				+ " from ECI.etudiants e,ECI.pays p,ECI.localite l where"
				+ "	e.lieu_de_naissance=l.id_localite and p.id_pays=e.id_nationalite;";*/
		List<Student> myListLocal=new ArrayList<Student>();
		myListLocal=getbyQuery(query);
		return myListLocal;

	}
	
	@Override
	public void updateEntity(Student entity) {
		con=main.Connections.OpenConnection();
		String phrase=entity.getId()+",'"+entity.getPassWord()+"','"+entity.getLastName()+"','"+entity.getFirstName()+"','"+
				entity.getNationalNumber()+"','"+entity.getDateNaissance()+"','"+entity.getSexe()+"','"+entity.getAdress()+"',"+
				entity.getCity()+",'"+entity.getPhone()+"','"+entity.getEmail()+"','"+entity.getGSM()+"',"+entity.getNationalite()+
				","+entity.getLieudeNaissance();
		System.out.println(phrase);
		String query = "call update_etudiant("+phrase+");";
		ExecuteQuery(query);
	}

	@Override
	public void deleteAllEntity() {
		con=main.Connections.OpenConnection();
		String query = "DELETE from ECI.etudiants;";
		ExecuteQuery(query);		
	}

	@Override
	public int addEntity(Student entity) {
		
		return 0;
	}

	@Override
	public void deleteEntityByIdentifier(String identifier) {
		// TODO Auto-generated method stub
		
	}

	public AbstractPerson getPersonByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractPerson getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getPeopleByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getPeopleByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getAllPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentByNationalNumber(String nationalNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getStudentByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getStudentByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int addStudent(Student entity) 
	{
		String phrase="'"+entity.getPassWord()+"','"+entity.getLastName()+"','"+entity.getFirstName()+"','"+
				entity.getNationalNumber()+"','"+entity.getDateNaissance()+"','"+entity.getSexe()+"','"+entity.getAdress()+"',"+
				entity.getCity()+",'"+entity.getPhone()+"','"+entity.getEmail()+"','"+entity.getGSM()+"',"+entity.getNationalite()+
				","+entity.getLieudeNaissance();
		System.out.println(phrase);
		String query = "select insert_etudiant("+phrase+");";
		return insertquery(query);
	}

	public void modifyStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void removeStudentByLogin(String login) {
		// TODO Auto-generated method stub
		
	}

	public void removeStudentByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	public void removeStudentByNationalNumber(String nationalNumber) {
		// TODO Auto-generated method stub
		
	}
	public int insertquery(String query)
	{
		int a=0;
		ResultSet resultSet = null;
		try 
		{
			Statement statement = (Statement) con.createStatement();
			resultSet = ((java.sql.Statement) statement).executeQuery(query);
			while (resultSet.next()) 
			{
				a=resultSet.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return a;
	}
	private List<Student> getbyQuery(String query)
	{
		List<Student> myListLocal=new ArrayList<Student>();
		Student resp=null;
		ResultSet resultSet = null;
		try 
		{
			Statement statement = (Statement) con.createStatement();
			resultSet = ((java.sql.Statement) statement).executeQuery(query);
			while (resultSet.next()) 
			{
				/* num_national, 
				 date_naissance, 

				 sexe, id_ville, 
				 adresse, 
				 telephone, 
				 mail, 
				 GSM,
				 id_nationalite,
				 lieu_de_naissance*/
				
				resp=new Student();
				resp.setId(Integer.parseInt(resultSet.getString(1)));
				resp.setLogin(resultSet.getString(2));
				resp.setPassWord(resultSet.getString(3));
				resp.setLastName(resultSet.getString(4));
				resp.setFirstName(resultSet.getString(5));
				resp.setNationalNumber(resultSet.getString(6));
				resp.setDateNaissance(resultSet.getString(7));
				resp.setSexe(resultSet.getString(8).charAt(0));
				resp.setAdress(resultSet.getString(9));
				//resp.setZipCode(resultSet.getString(10));
				resp.setCity(Integer.parseInt(resultSet.getString(10)));
				resp.setPhone(resultSet.getString(11));
				resp.setEmail(resultSet.getString(12));
				resp.setGSM(resultSet.getString(13));

				resp.setNationalite(Integer.parseInt(resultSet.getString(14)));
				resp.setLieudeNaissance(Integer.parseInt(resultSet.getString(15)));
				resp.setDel(resultSet.getBoolean(16));
				myListLocal.add(resp);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return myListLocal;
	}
	public void deleteById(int id)
	{
		con=main.Connections.OpenConnection();
		String query = "call supprimer_etudiants("+id+");";
		ExecuteQuery(query);		
	}
	public void ExecuteQuery(String query)
	{
		ResultSet resultSet = null;
		try 
		{
			Statement statement = (Statement) con.createStatement();
			resultSet = ((java.sql.Statement) statement).executeQuery(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		
	}
}
