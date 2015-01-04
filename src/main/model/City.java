package main.model;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.IEntity;

import com.mysql.jdbc.Statement;

public class City implements IEntity
{
	static Connection con;
	private int code;
	private String zipCode;
	private String name;
	private int idCountry;
	private boolean isDel;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}

	
	public String toString()
	{
		return getZipCode()+" "+getName(); 
	}
	public List<City> getListOfEntity(int idPays) 
	{
		con=main.Connections.OpenConnection();
		String query = "select * from ECI.Localite where id_pays="+idPays+";";
		List<City> myListLocal=new ArrayList<City>();
		myListLocal=getbyQuery(query);
		return myListLocal;

	}
	public void deleteById(int id)
	{
		con=main.Connections.OpenConnection();
		String query = "call supprimer_localite("+id+");";
		ExecuteQuery(query);	
	}
	public City getById(int id)
	{
		con=main.Connections.OpenConnection();
		String query = "select * from ECI.Localite where id_localite="+id+";";
		List<City> myListLocal=new ArrayList<City>();
		myListLocal=getbyQuery(query);
		return myListLocal.get(0);
	}
	private List<City> getbyQuery(String query)
	{
		List<City> myListLocal=new ArrayList<City>();
		City resp=null;
		ResultSet resultSet = null;
		try 
		{
			Statement statement = (Statement) con.createStatement();
			resultSet = ((java.sql.Statement) statement).executeQuery(query);
			while (resultSet.next()) 
			{
				resp=new City();
				resp.setCode(Integer.parseInt(resultSet.getString(1)));
				resp.setZipCode(resultSet.getString(2));
				resp.setName(resultSet.getString(3));
				resp.setIdCountry(Integer.parseInt(resultSet.getString(4)));
				resp.setDel(resultSet.getBoolean(5));
				myListLocal.add(resp);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return myListLocal;
	}
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
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
	public void updateCity(City ctr) 
	{
		con=main.Connections.OpenConnection();
		String phrase=ctr.getCode()+",'"+ctr.getZipCode()+"','"+ctr.getName()+"',"+ctr.getIdCountry();
		System.out.println(phrase);
		String query = "call update_localite("+phrase+");";
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
	public int addCity(City ctr)
	{
		con=main.Connections.OpenConnection();
		String phrase="'"+ctr.getZipCode()+"','"+ctr.getName()+"',"+ctr.getIdCountry();
		System.out.println(phrase);
		String query = "select insert_localite("+phrase+");";
		return insertquery(query);
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
