
// Assignment #: 8
//  Description: Compares projects based on the different aspects
//				 of the project Manager

import java.util.*;


public class ManagerComparator implements Comparator<Project>
{
	private Manager manager1;
	private Manager manager2;
	private int deptNum1;
	private String firstName1;
	private String lastName1;
	private int deptNum2;
	private String firstName2;
	private String lastName2;
	private int difference;
	
	//compares manager objects first by department number, then first name, then last name
	public int compare(Project first, Project second) 
	{
		manager1 = first.getProjManager();
		manager2 = second.getProjManager();
		
		deptNum1 = manager1.getDeptNum();
		deptNum2 = manager2.getDeptNum();
		
		firstName1 = manager1.getFirstName();
		firstName2 = manager2.getFirstName();
		
		lastName1 = manager1.getLastName();
		lastName2 = manager2.getLastName();
			
		
		difference = deptNum1 - deptNum2;
		
		if ((deptNum1 - deptNum2) == 0)
		{
			difference = firstName1.compareTo(firstName2);
			
			if (firstName1.compareTo(firstName2) == 0)
			{
				difference = lastName1.compareTo(lastName2);
			}
			
		}
		
		return difference; //will return zero if everything is the same
	
	}
		
		
}//end of MangerComparator class