package main;

public interface IEntity {
	
	// label a afficher dans la liste des entites
	public String getLabel();
	public IEntity clone();
	public int getIdentifier();
	public boolean isDel();
}
