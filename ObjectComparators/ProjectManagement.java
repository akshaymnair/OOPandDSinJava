

// Assignment #: 8
//  Description: Managers array of projects where you can add, delete,
//				 and sort the projects in the array

import java.io.*;
import java.util.*;

public class ProjectManagement implements Serializable
{
	private Project[] projectList;
	private int currentProjectsCount;
	private int maxSize;

	//constructor begins with a maximum Size and instantiates an array of that size with null
	public ProjectManagement(int maximumSize)
	{
		
		maxSize = maximumSize;
		projectList = new Project [maxSize];
		
		for(int i = 0; i < projectList.length; i ++)
		{
			projectList[i] = null;			
		}
		
		currentProjectsCount = 0; //starts with zero projects
	}

	public int projectNumberExists(int projectNumber)
	{
		int index = -1; //will stay -1 if matching project isn't found
		
		for(int i = 0; i < currentProjectsCount; i ++)
		{
			if (projectList[i].getProjNumber() == projectNumber)
			{
				index = i;
			}
		}
		
		return index; //index of project with matching project number
		
	}
	
	public int managerExists(String firstName, String lastName, int deptNum)
	{
		int index = -1; //will stay -1 if matching project isn't found
		
		for(int i = 0; i < currentProjectsCount; i ++)
		{
			Manager matchingManager = projectList[i].getProjManager();
			
			
			//matching first name, last name, and department number
			if (((matchingManager.getFirstName()).equals(firstName)) &&
				((matchingManager.getLastName()).equals(lastName)) &&
				(matchingManager.getDeptNum() == deptNum))
			
				{
					index = i;
				}
		}
	
		return index;
		
	}
	
	public boolean addProject(String projTitle, int projNumber, String projLocation, String firstName, String lastName, int deptNum)
	{
		//checks if the same project number doesn't exist, as well as makes sure the array isn't full
		if (projectNumberExists(projNumber) == -1 && currentProjectsCount < maxSize)
		{
			//creates new project with all components
			Project newProject = new Project();
			newProject.setProjTitle(projTitle);
			newProject.setProjNumber(projNumber);
			newProject.setProjLocation(projLocation);
			newProject.setProjManager(firstName, lastName, deptNum);
			
			projectList[currentProjectsCount] = newProject; //adds project to array
			
			currentProjectsCount++;
			
			return true;
			
		}
		
		else
			return false; //if project number already exists or the array is full
	}

	
	public boolean removeProjectNumber(int projectNumber)
	{
		int projectIndex = projectNumberExists(projectNumber); //finds index of project by project number
		
		if (projectIndex != -1) //proceeds only if project exists
		{
			for(int i = projectIndex; i < projectList.length - 1; i++) //shifts all elements in array back one
			{
				projectList[i] = projectList[i+1];
			}
				
				currentProjectsCount--; //updates current project count
				return true;
		}
		
		
		else
			return false;
	}
	
	public void sortByProjectNumber()
	{
		//arranges projectList array in increasing project number order
		
		ProjectNumberComparator numComparator = new ProjectNumberComparator();
		
		Sorts byProjNumber = new Sorts();
		byProjNumber.sort(projectList, currentProjectsCount, numComparator);
		
	}
	
	public void sortByManager()
	{
		//arranges projectList array in increasing order based on the compare method of ManagerComparator
		
		ManagerComparator managerComp = new ManagerComparator();
		Sorts byManager = new Sorts();
		byManager.sort(projectList, currentProjectsCount, managerComp);
		
	}

	
	public String listProjects() //lists each project in projectList
	{
		String projectListString = "\n";
		
		if(currentProjectsCount != 0)
		{
			for(int i = 0; i < currentProjectsCount; i ++)
			{
				projectListString += projectList[i].toString();			
			}		
			
			projectListString += "\n";
			
			return projectListString;
		}
	
		else
			return "\nno project\n\n";
	}
	

	public void closeProjectManagement() //clears all elements in ProjectList
	{
		for(int i = 0; i < projectList.length; i ++)
		{
			projectList[i] = null;			
		}
		
		currentProjectsCount = 0;
		
	}

} //end of ProjectManagement class
