package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.dao.StudentsMysqlDAO;
import main.gui.MainFrame;
import main.model.Student;
public class App {

	public static void main(String[] args) throws SQLException {
		
		MainFrame mf=new MainFrame();
		mf.show();
		/*StudentsMysqlDAO sd=new StudentsMysqlDAO();
		List<Student> myListLocal=new ArrayList<Student>();
		myListLocal=sd.getListOfEntity();
		for(int i=0;i<myListLocal.size();i++)
		{ 
			System.out.println(myListLocal.get(i).toString());
		}*/
		// liste des méthodes chaque dao :
		
		// 	-	select *
		// 	-	un select par champs unique (id, login, email) -> return <entity>
		//	-	(select par les autres champs)	-> return list<entity>
		//	-	delete *
		// 	-	update en recevant un <entity> et tu mets à jour tout le record
		//		void update(Student student)		
		//	-	delete par id
		//	-	insert
		//	-	(suppresion logique)
		
		//		- void delLog(
		//		- void delLog(Student student)
		
		
		// CRUD pour les administrateurs
		
		
		
		// CRUD pour les étudiants
		
		// Read  pour les personnes

	}

}
