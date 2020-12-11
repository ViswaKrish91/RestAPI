import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;

import java.util.Properties;
import java.io.*;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test_GetEmployeeDetails{
	
	String name = "Mahesh";
	int age = 30;
	
	@Test
	public void Test_GetEmployeeDetails(){}
	
	
	  
	   public String getName() 
	   {
	      return name;
	   }
	   public void setName(String name) 
	   {
	      this.name = name;
	   }
	   public int getAge() 
	   {
	      return age;
	   }
	   public void setAge(int age) 
	   {
	      this.age = age;
	   }
	   public String toString()
	   {
	      return "Employee [ name: "+name+", age: "+ age+ " ]";
	   }	
	   
	   public void writeJSON(Test_GetEmployeeDetails employee) throws JsonGenerationException, JsonMappingException, IOException{
		   ObjectMapper mapper = new ObjectMapper();	
		   mapper.writeValue(new File("src/test/resource/Employee.json"), employee);
		}
	   
	   
	
	@Test
	public void test_01() throws IOException {
		

		Properties prop=new Properties(); 
	    FileInputStream reader=new FileInputStream("Global.properties");  
	    prop.load(reader);
	    String Name = prop.getProperty("EmployeeName");
		
	    ObjectMapper objectMapper = new ObjectMapper();
		
	    Test_GetEmployeeDetails employee = objectMapper.readValue(new File("src/test/resources/Employee.json"), Test_GetEmployeeDetails.class);
	    Assert.assertEquals(employee.getName(), Name);
		
	}

}
