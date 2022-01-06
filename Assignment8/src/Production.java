// Assignment #: 8
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30
//  Description: The Production class describes a Production.
//               It also provides their accessor, mutator methods,
//               and toString method.

import java.io.Serializable;

public class Production implements Serializable {
 private String companyName;
 private String locationCity;
 private String locationState;

 //Constructor method to initialize intance variables.
 public Production()
  {
      companyName = new String("?");
      locationCity= new String("?");
      locationState = new String("?");
  }

 //Accessor method for companyName
 public String getCompanyName()
  {
   return companyName;
  }

 //Accessor method for locationCity
 public String getLocationCity()
  {
   return locationCity;
  }

 //Accessor method for locationState
 public String getLocationState()
  {
    return locationState;
  }

 //Mutator method for companyName
 public void setCompanyName(String someCompanyName)
  {
   companyName = someCompanyName;
  }

 //Mutator method for locationCity
 public void setLocationCity(String someLocationCity)
  {
   locationCity = someLocationCity;
  }

 //Mutator method for locationState
 public void setLocationState(String someLocationState)
  {
    locationState = someLocationState;
  }
 
 public void copy(Production other) {
	 this.companyName = other.companyName;
	 this.locationCity = other.locationCity;
	 this.locationState = other.locationState;
 }

 //This method return a string containing the attribute information of a Production
 public String toString()
  {
   String result;

      result = companyName + " at " + locationCity + "," + locationState;

   return result;
  }
} 

//done