package main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import main.Connections;
import main.AbstractMySQLDAO;
import main.model.AbstractPerson;
import main.model.Administrator;
import main.model.Student;



public class AdministratorsMysqlDAO extends AbstractMySQLDAO<Administrator> {

	static Connection con;
	public AbstractPerson getPersonByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractPerson getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AbstractPerson> getPeopleByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AbstractPerson> getPeopleByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AbstractPerson> getAllPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

	public void modifyAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

	public void removeAdministratorByLogin(String login) {
		// TODO Auto-generated method stub
		
	}

	public void removeAdministratorByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	public void removeAllAdministrator() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administrator> getListOfEntity() {
		con=main.Connections.OpenConnection();
		String query = "Select * from ECI.Responsables;";
		List<Administrator> myListLocal=new ArrayList<Administrator>();
		myListLocal=getbyQuery(query);
		return myListLocal;
	}

	@Override
	public void updateEntity(Administrator entity) {
		con=main.Connections.OpenConnection();
		String phrase=entity.getId()+",'"+entity.getLogin()+"','"+entity.getPassWord()+"','"+
				entity.getLastName()+"','"+entity.getFirstName()+"','"+entity.getEmail()+"'";
		System.out.println(phrase);
		String query = "call update_responsable("+phrase+");";
		ExecuteQuery(query);
		
	}

	@Override
	public void deleteAllEntity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addEntity(Administrator entity) 
	{
		con=main.Connections.OpenConnection();
		String phrase="'"+entity.getLogin()+"','"+entity.getPassWord()+"','"+
				entity.getLastName()+"','"+entity.getFirstName()+"','"+entity.getEmail()+"'";
		System.out.println(phrase);
		String query = "select insert_responsable("+phrase+");";
		return insertquery(query);
		
	}
	public void deleteById(int id)
	{
		
		con=main.Connections.OpenConnection();
		String query = "call supprimer_responsables("+id+");";
		ExecuteQuery(query);		
	
	}
	private int insertquery(String query)
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
	@Override
	public void deleteEntityByIdentifier(String identifier) {
		// TODO Auto-generated method stub
		
	}
	private List<Administrator> getbyQuery(String query)
	{
		List<Administrator> myListLocal=new ArrayList<Administrator>();
		Administrator resp=null;
		ResultSet resultSet = null;
		try 
		{
			Statement statement = (Statement) con.createStatement();
			resultSet = ((java.sql.Statement) statement).executeQuery(query);
			while (resultSet.next()) 
			{
				//String tableName = resultSet.getString(1);
				resp=new Administrator();
				resp.setId(Integer.parseInt(resultSet.getString(1)));
				resp.setLogin(resultSet.getString(2));
				resp.setPassWord(resultSet.getString(3));
				resp.setFirstName(resultSet.getString(5));
				resp.setLastName(resultSet.getString(4));
				resp.setEmail(resultSet.getString(6));
				resp.setDel(resultSet.getBoolean(7));
				//System.out.println(resp.isDel());
				myListLocal.add(resp);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return myListLocal;
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
