// Assignment #: 8
//  Description: used to sort a list of Project objects


import java.io.*;
import java.util.*;

public class Sorts
{
	public static void sort(Project[] projectList, int size, Comparator <Project> projectCompare)
	{
		//uses insertion sorting to arrange projects by either manager or project number
		
		for (int index = 1; index < size; index++)
		{
			Project currentPosition = projectList[index];
			Project previousPosition = projectList[index - 1];
				
			int difference = projectCompare.compare(currentPosition,previousPosition);
			
			//if difference is less than zero, then previous is before current
			while (index > 0 && difference < 0) //switches current with previous if requirements are met
			{
				projectList[index] = projectList[index-1];
				index--;
			}
            
			projectList[index] = currentPosition;
		}
	
	}

}//end of Sorts class
	
	
	
	
	