package main;

import java.util.List;
import java.sql.Connection;
public abstract class AbstractMySQLDAO<Entity extends IEntity> {

	protected String identifierFieldName = null;
	protected String tableName = null;
	
	protected Entity getEntityByIdentifier(String identifier) // throws Exception
	{
		/*if (identifierFieldName == null)
			throw new Exception("Le nom du champ identifiant est null.");
	
		if (tableName == null)
			throw new Exception("Le nom de la table est null.");*/
		
		String query = "SELECT * FROM " + tableName + " WHERE " + identifierFieldName + " = " + identifier;
		
		return null;
	}
	//toutes les classes sont protected..
	protected List<Entity> getListOfEntity()
	{
		return null;
	}
	
	
	public abstract void updateEntity(Entity entity);
	public abstract void deleteAllEntity();
	public abstract int addEntity(Entity entity);
	
	public void deleteEntity(Entity entity)
	{
		this.deleteEntityByIdentifier(entity.getLabel());
	}
	public abstract void  deleteEntityByIdentifier(String identifier);
	
	
}
