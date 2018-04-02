
// Assignment #: 8
//  Description: The Manager class describes a manager.
//               It also provides their accessor, mutator methods,
//               and toString method.

import java.io.*;

public class Manager implements Serializable
{

	private String firstName;
	private String lastName;
	private int deptNum;

	public Manager() //constructor with instance variables
	{
		firstName = new String("?");
		lastName= new String("?");
		deptNum = 0;
	}

	//Accessor methods
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
	return lastName;
	}

	public int getDeptNum()
	{
		return deptNum;
	}

	//Modifier methods
	public void setFirstName(String someFirstName)
	{
		firstName = someFirstName;
	}

	public void setLastName(String someLastName)
	{
		lastName = someLastName;
	}

	public void setDeptNum(int someDeptNum)
	{
		deptNum = someDeptNum;
	}

	
	public void copy(Manager other)
	{
		this.firstName = other.getFirstName();
		this.lastName = other.getLastName();
		this.deptNum = other.getDeptNum();
	}
  
  
	//returns string of manager variables
	public String toString()
	{
		String result;
	
		result = firstName + " " + lastName + ", Dept Num:" + deptNum;

		return result;
	}

} //Manager class
