package com.saikiran.springmvc.website.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.saikiran.springmvc.website.model.RegistrationDetails;

public class RepositoryDAO {
	 
    public ArrayList<RegistrationDetails> regDetails = new ArrayList<RegistrationDetails>();
   public String retrievedName=null,retrievedCourse=null;
   int retrievedFee=0, retrievedYear=0;
   static int i=0;
   static boolean j = true;
   static Connection connection=null;
   static PreparedStatement preparedStatement =null;
   static ResultSet resultSet = null;
   static boolean value = false;
   public static final String CREATE_TABLE = "create table userinfo(Name name varying(40) NOT NULL , Course text varying(40) NOT NULL, Fee integer varying(40) NOT NULL, Year integer varying(40) NOT NULL,currentDate text varying(40) NOT NULL)";
   public static final String SELECT_TABLE = "select * from userinfo";
   public static final String UPDATE_TABLE = "Insert into userinfo values(?,?,?,?,?)";
   public static final String DELETE_TABLE = "delete from userinfo where Name =? and PhoneNumber=?";
   public static final String DROP_TABLE = "drop table userinfo";
   
   public void closeConnection()
   {
       try {
           connection.close();
       } catch (SQLException ex) {
           Logger.getLogger(RepositoryDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public void getConnection()
   {
       try {
           Class.forName("org.postgresql.Driver");
           try {
               connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mydb", "postgres", "SaiKiran16");
           } catch (SQLException ex) {
               Logger.getLogger(RepositoryDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
       catch (ClassNotFoundException ex) {
           Logger.getLogger(RepositoryDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
    public void createTable()
    {
       try {
           preparedStatement = connection.prepareStatement(CREATE_TABLE);
           value = preparedStatement.execute();
            preparedStatement.close();
            
       } catch (SQLException ex) {
        System.out.print("");
       }
      
    }
       
    public boolean tableCreationCheck()
    {
       try {
           value = preparedStatement.execute(SELECT_TABLE);
           preparedStatement.close();
       }  catch(NullPointerException npr)
           {
               System.out.print("");
           } catch (SQLException ex) {
           Logger.getLogger(RepositoryDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        return value;
        
    }
    
    public void InsertUserInfoValues(ArrayList<RegistrationDetails> userInfoIterator)
    {
       try {
           for(i=0;i<userInfoIterator.size();i++)
           {
        preparedStatement = connection.prepareStatement(UPDATE_TABLE);
        System.out.println(userInfoIterator.get(i).getName());
        preparedStatement.setString(1, userInfoIterator.get(i).getName());
        preparedStatement.setString(2, userInfoIterator.get(i).getCourse());
        preparedStatement.setInt(3, userInfoIterator.get(i).getFee());
        preparedStatement.setInt(4, userInfoIterator.get(i).getYear());
         preparedStatement.setString(5, userInfoIterator.get(i).getCurDate());
        j = preparedStatement.execute();
        preparedStatement.close();
           } 
           if(j == false)
           {
       System.out.println("-----------------------------------------");
       System.out.println("Your information has been updated to the database successfully!");
       System.out.println("-----------------------------------------");
           }
           else
           {
               System.err.println("Something went wrong please try again!");
           }
       } catch (SQLException ex) {
           Logger.getLogger(RepositoryDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
       public ArrayList<RegistrationDetails> RetrieveUserInformationValues()
       {
       try {
           preparedStatement = connection.prepareStatement(SELECT_TABLE);
           resultSet = preparedStatement.executeQuery();
           System.out.println("Name"+ "\t"+"EmailID"+"\t"+"Phone Number");
           while((resultSet.next()))
           {
            RegistrationDetails info = new RegistrationDetails();   
           retrievedName = resultSet.getString(1);
           retrievedCourse = resultSet.getString(2);
           retrievedFee = resultSet.getInt(3);
           retrievedYear = resultSet.getInt(4);
           String retrievedCurDate = resultSet.getString(5);
           info.setName(retrievedName);
           info.setCourse(retrievedCourse);
           info.setFee(retrievedFee);
           info.setYear(retrievedYear);
           info.setCurDate(retrievedCurDate);
           regDetails.add(info);
        
           }
           resultSet.close();
           preparedStatement.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(RepositoryDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
          return regDetails;
    
       } 
}
