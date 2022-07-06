package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Callable {




public static void main(String[] args)
{
String url= "jdbc:sqlserver://ec2-54-191-44-79.us-west-2.compute.amazonaws.com;databaseName=TrainingApril22";
String user = "logup";
String password = "Logu@123";
Connection connection = null;
try
{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
connection = DriverManager.getConnection("jdbc:sqlserver://ec2-54-191-44-79.us-west-2.compute.amazonaws.com;databaseName=TrainingApril22;integratedSecurity=false;encrypt=false;trustServerCertificate=false","logup","Logu@123");
CallableStatement callableStatement = connection.prepareCall("{call [Ten Most Expensive Products]()}");
ResultSet resultSet=callableStatement.executeQuery();

while(resultSet.next())
{

	System.out.println("Ten Most Expensive Products->"+resultSet.getString("TenMostExpensiveProducts")+ " "+"UnitPrice->"+resultSet.getString("UnitPrice"));

}
resultSet.close();
callableStatement.close();
connection.close();
}catch (Exception e) {
System.out.println("catch block");
e.printStackTrace();
}
}



}
