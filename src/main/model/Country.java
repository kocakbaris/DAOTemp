package main.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.IEntity;

import com.mysql.jdbc.Statement;

public class Country implements IEntity
{
	static Connection con;
	private int code;
	private String name;
	private boolean isDel;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return getName();
	}
	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}

	public Country getById(int id)
	{
		con=main.Connections.OpenConnection();
		String query = "select * from ECI.pays where id_pays="+id+";";
		List<Country> myListLocal=new ArrayList<Country>();
		myListLocal=getbyQuery(query);
		return myListLocal.get(0);
	}
	public void deleteById(int id)
	{
		con=main.Connections.OpenConnection();
		String query = "call supprimer_pays("+id+");";
		ExecuteQuery(query);	
	}
	public List<Country> getListOfEntity() 
	{
		con=main.Connections.OpenConnection();
		String query = "select * from ECI.pays order by id_pays;";
		List<Country> myListLocal=new ArrayList<Country>();
		myListLocal=getbyQuery(query);
		return myListLocal;

	}
	private List<Country> getbyQuery(String query)
	{
		List<Country> myListLocal=new ArrayList<Country>();
		Country resp=null;
		ResultSet resultSet = null;
		try 
		{
			Statement statement = (Statement) con.createStatement();
			resultSet = ((java.sql.Statement) statement).executeQuery(query);
			while (resultSet.next()) 
			{
				//String tableName = resultSet.getString(1);
				resp=new Country();
				resp.setCode(Integer.parseInt(resultSet.getString(1)));
				resp.setName(resultSet.getString(2));
				resp.setDel(resultSet.getBoolean(3));
				myListLocal.add(resp);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return myListLocal;
	}
	public int addCountry(Country ctr) 
	{
		con=main.Connections.OpenConnection();
		String phrase="'"+ctr.getName()+"'";
		System.out.println(phrase);
		String query = "select eci.insert_pays("+phrase+");";
		return insertquery(query);
		
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
	private void ExecuteQuery(String query)
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
	public void updateCountry(Country ctr) 
	{
		con=main.Connections.OpenConnection();
		String phrase=ctr.getCode()+",'"+ctr.getName()+"'";
		System.out.println(phrase);
		String query = "call update_pays("+phrase+");";
		ExecuteQuery(query);
		
	}
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IEntity clone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getIdentifier() {
		// TODO Auto-generated method stub
		return this.getCode();
	}

}
