// Assignment #: 8
//  Description: Compares project numbers of two projects

import java.util.*;


public class ProjectNumberComparator implements Comparator<Project>
{
	private int firstNum;
	private int secondNum;
	private int difference;
	
	public int compare(Project first, Project second) 
	{
		//takes the project numbers for both projects
		firstNum = first.getProjNumber();
		secondNum = second.getProjNumber();
		
		difference = firstNum - secondNum; //find and difference
		
			
		return difference;
		
	}	
		
}		