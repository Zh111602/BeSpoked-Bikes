/*
 *  Author: Zhen Hong Tan
 *  BeSpoked Bikes Application
 */

package profiseeProject;

import java.sql.Connection;
import java.time.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Product {
	public static void main(String[] args) throws SQLException {
		// The following code establish connection to localhost sql server
		String url = "jdbc:mysql://localhost:3306/testing";
		String uname = "root";
		String password = "password";
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		int input = 0;
		String newLine = System.getProperty("line.separator");
		
		// Do-while loop for the application
		do {
			// list out all the available choices, and ask for user input
			System.out.println(newLine + newLine);
			System.out.println("1. Display a list of salespersons.");
			System.out.println("2. Update a salesperson.");
			System.out.println("3. Display a list of products.");
			System.out.println("4. Update a product.");
			System.out.println("5. Display a list of customers");
			System.out.println("6. Display a list of sales.");
			System.out.println("7. Create a sale.");
			System.out.println("8. Display a quarterly salesperson commission report.");
			System.out.println("Press 0 to quit.");
			System.out.println();
			System.out.println("Please pick one.");
			System.out.println("Enter a number: ");
			input = reader.nextInt(); // Scans the next token of the input as an int.
			
			//switch statement to handle the user input.
			switch (input) {
			
			// print out a list of salesperson
			case 1 : 		
				String query = "select * from Salesperson;";
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				try {
					// create connection and statement, execute the query and get result.
					  Connection con = DriverManager.getConnection(url,uname,password);
					  Statement statement = con.createStatement();
					  ResultSet result = statement.executeQuery(query);
					  
					  // printint out the list
					  System.out.println();
					  System.out.println("ID : FirstName : LastName : Address : Phone : StartDate");
					  System.out.println("-------------------------------------------------------");
					  while (result.next()) {
					    String print = "";
					    for (int i = 1; i <= 6 ; i++) {
					    	if (i == 1)
						    	  print += result.getString(i) + "  : ";
					    	if (i == 2)
						    	  print += result.getString(i) + " :    ";
					    	if (i == 3)
						    	  print += result.getString(i) + "   : ";
					    	if (i == 4)
						    	  print += result.getString(i) + " : ";
					    	if (i == 5)
						    	  print += result.getString(i) + " : ";
					    	if (i == 6)
						    	  print += result.getString(i);
					    }
					    System.out.println(print);
					  }} catch (SQLException e) {
					    e.printStackTrace();
					  }
				break;
			
				// update a specific salesperson.
			case 2:
				// ask for the salespersonID from client and what to update, then update it.
				System.out.println();
				System.out.println("Please enter the ID of the salesperson.");
				Scanner read = new Scanner(System.in);
				int n = read.nextInt();
				System.out.println();
				System.out.println("1: FirstName" + newLine + "2: LastName");
				System.out.println("3: Address" + newLine + "4: Phone");
				int x = read.nextInt();
				String ans = null;
				if (x == 1) ans = "FirstName";
				if (x == 2) ans = "LastName";
				if (x == 3) ans = "Address";
				if (x == 4) ans = "Phone";
				if (ans == null) break;
				
				System.out.println(newLine + "Please enter the new " + ans);
				read = new Scanner(System.in);
				String s = read.nextLine();
				
				String query2 = ("update salesperson set " + ans + " = '" + s + "'where id = " + n);
				
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				try {
					// create connection and statement, execute the query and get result.
					  Connection con = DriverManager.getConnection(url,uname,password);
					  Statement statement = con.createStatement();
					  int result = statement.executeUpdate(query2);
					  
					  System.out.println(result + "row updated.");
					  } catch (SQLException e) {
					    e.printStackTrace();
					  }
				break;
				
			// display the list of product.
			case 3: 
				String query3 = "select * from Product;";
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				try {
					// create connection and statement, execute the query and get result.
					  Connection con = DriverManager.getConnection(url,uname,password);
					  Statement statement = con.createStatement();
					  ResultSet result = statement.executeQuery(query3);
					  
					  System.out.println(newLine + "ID :  Name  : Manufacturer : PurchasePrice : SalePrice : QTYonHand : Commission");
					  System.out.println("-------------------------------------------------------------------------------");
					  while (result.next()) {
					    String print = "";
					    for (int i = 1; i <= 7 ; i++) {
					    	if (i == 1)
						    	  print += result.getString(i) + " : ";
					    	if (i == 2)
						    	  print += result.getString(i) + " :    ";
					    	if (i == 3)
						    	  print += result.getString(i) + "   :       ";
					    	if (i == 4)
						    	  print += result.getString(i) + "      :     ";
					    	if (i == 5)
						    	  print += result.getString(i) + "   :     ";
					    	if (i == 6)
						    	  print += result.getString(i) + "     :   ";
					    	if (i == 7)
						    	  print += result.getString(i) + " %";
					    }
					    System.out.println(print);
					  }} catch (SQLException e) {
					    e.printStackTrace();
					  }
				break;
				
			case 4 : 
				// ask for the productID from client and what to update, then update it.
				System.out.println();
				System.out.println("Please enter the ID of the product.");
				Scanner read4 = new Scanner(System.in);
				int n4 = read4.nextInt();
				System.out.println();
				System.out.println("1: Manufacturer" + newLine + "2: PurchasePrice");
				System.out.println("3: SalePrice" + newLine + "4: Commission%");
				int x4 = read4.nextInt();
				String ans4 = null;
				if (x4 == 1) ans4 = "manufacturer";
				if (x4 == 2) ans4 = "purchaseprice";
				if (x4 == 3) ans4 = "saleprice";
				if (x4 == 4) ans4 = "commission";
				if (ans4 == null) break;
				
				System.out.println(newLine + "Please enter the new " + ans4);
				read4 = new Scanner(System.in);
				String s4 = read4.nextLine();
				
				String query4 = ("update product set " + ans4 + " = '" + s4 + "'where id = " + n4);
				
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				try {
					// create connection and statement, execute the query and get result.
					  Connection con = DriverManager.getConnection(url,uname,password);
					  Statement statement = con.createStatement();
					  int result = statement.executeUpdate(query4);
					  
					  System.out.println(result + "row updated.");
					  } catch (SQLException e) {
					    e.printStackTrace();
					  }
				break;
				
			case 5: 
				// display a list of customers
				String query5 = "select * from Customer;";
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				try {
					// create connection and statement, execute the query and get result.
					  Connection con = DriverManager.getConnection(url,uname,password);
					  Statement statement = con.createStatement();
					  ResultSet result = statement.executeQuery(query5);
					  
					  System.out.println(newLine + "ID : FirstName : LastName : Address : Phone : StartDate");
					  System.out.println("-------------------------------------------------------");
					  while (result.next()) {
					    String print = "";
					    System.out.println();
					    for (int i = 1; i <= 6 ; i++) {
					    	if (i == 1)
						    	  print += result.getString(i) + " :    ";
					    	if (i == 2)
						    	  print += result.getString(i) + "    :    ";
					    	if (i == 3)
						    	  print += result.getString(i) + "    :   ";
					    	if (i == 4)
						    	  print += result.getString(i) + "  :  ";
					    	if (i == 5)
						    	  print += result.getString(i) + " :   ";
					    	if (i == 6)
						    	  print += result.getString(i);
					    }
					    System.out.println(print);
					  }} catch (SQLException e) {
					    e.printStackTrace();
					  }
				break;
				
			case 6:
				// display a list of sales
				// display a list of customers
				String query6 = "select sales.ID,product.name, customer.firstName, salesperson.firstname, sales.salesdate from sales " + 
						"left join product on product.id = sales.productid " + 
						"left join customer on sales.customerid = customer.customerid " + 
						"left join salesperson on sales.salespersonid = salesperson.id ";
				System.out.println();
				System.out.println("Do you want to filter by date range? (y/n)");
				Scanner read6 = new Scanner(System.in);
				char c = read6.next().charAt(0);
				// if the user would like to filter by date range, get the range from the user and print it out
				if (c == 'y') {
					System.out.println(newLine + "Please enter the date range (> '2021-10-11')");
					read6 = new Scanner(System.in);
					String str = read6.nextLine();
					query6 += "where sales.salesDate " + str;
					System.out.println();
				}
				query6+= ";";
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				try {
					// create connection and statement, execute the query and get result.
					  Connection con = DriverManager.getConnection(url,uname,password);
					  Statement statement = con.createStatement();
					  ResultSet result = statement.executeQuery(query6);
					  
					  System.out.println("ID : ProductName : CustomerName: SalespersonName: SalesDate ");
					  System.out.println("-------------------------------------------------------------");
					  while (result.next()) {
					    String print = "";
					    System.out.println();
					    for (int i = 1; i <= 5 ; i++) {
					    	if (i == 1)
					    	  print += result.getString(i) + "  :   ";
					    	if (i == 2)
					    		print += result.getString(i) + "   :    ";
					    	if (i == 3)
					    		print += result.getString(i) + "    :    ";
					    	if (i == 4)
					    		print += result.getString(i) + "   : ";
					    	if (i == 5)
					    		print += result.getString(i);
					    }
					    System.out.println(print);
					  }} catch (SQLException e) {
					    e.printStackTrace();
					  }
				break;
				
			case 7:
				// create a sale
				
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				  String query7 = "select * from Sales;";
				  Connection con = DriverManager.getConnection(url,uname,password);
				  Statement statement = con.createStatement();
				  ResultSet result = statement.executeQuery(query7);
				  
				  int salesID = 1;
				  while (result.next()) {
					  // get the newID for the sale
					  salesID++;
				  }  
				  
				  // ask for the productID, customerID, salespersonID
				  System.out.println(newLine + "Please enter the ProductID");
				  Scanner read7 = new Scanner(System.in);
				  int pID = read7.nextInt();
				  System.out.println(newLine + "Please enter the customerID");
				  read7 = new Scanner(System.in);
				  int cID = read7.nextInt();
				  System.out.println(newLine + "Please enter the SalespersonID");
				  read7 = new Scanner(System.in);
				  int sID = read7.nextInt();
				  
				  // create a new sale
				  query7 = "insert into sales value (" + salesID + ", " + pID + ", " + cID + ", "+ sID + ", CURDATE());";
				  statement.executeUpdate(query7);
				  
				  System.out.println(newLine + "Successfully addedd!");
				  
				  // decrement the quantity on hand 
				  query7 = "update product set qtyonhand = qtyonhand - 1 where id = " + pID + ";";
				  statement.executeUpdate(query7);	
				break;
				
			case 8:
				// display a quarterly salesperson commission report
				try {
					// load and register the driver
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  } catch (ClassNotFoundException e) {
					    e.printStackTrace();
					  }
				
				Connection conn = DriverManager.getConnection(url,uname,password);
				Statement st = conn.createStatement();
				ResultSet res;
				String query8 = "select productid, salespersonid, salesdate from Sales;";
				res = st.executeQuery(query8);
				// HashMap
				// key - salespersonID
				// value - total commission
				HashMap<Integer, Integer> map = new HashMap<>();
				// get the last 3 months
				LocalDate date = LocalDate.of(2021,10,6);
				
				while (res.next()) {
					int pid = Integer.parseInt(res.getString(1));
					LocalDate dt = LocalDate.parse(res.getString(3));
					// continue to the next one if the sales is already more than 3 months.
					if(date.compareTo(dt) > 0) 
						continue;
					
					Statement st2 = conn.createStatement();
					// get the discount % from the discount table, and check if the sale falls between the discount date range
					String q2 = "select discountpercentage from discount where product = " + pid + "  and enddate > '" + dt + "'  and begindate < '" + dt + "' ;";
					ResultSet res2 = st2.executeQuery(q2);

					int discount = 0;
					while (res2.next()) {
						discount = Integer.parseInt(res2.getString(1));
					}
					q2 = "select saleprice, commission from product where id = " + pid + ";";
					res2 = st2.executeQuery(q2);
					
					// Calculate the commission after the discount (if there is)
					int saleprice = 0;
					int commission = 0;
					if(res2.next()) {
						saleprice = Integer.parseInt(res2.getString(1));
						commission = Integer.parseInt(res2.getString(2));
					}
					int value  =  (saleprice * (100 - discount) * commission) / 10000;
					int temp = Integer.parseInt(res.getString(2));
					if (map.containsKey(temp)) {
						map.put(temp,map.get(temp) + value);
					}else {
						map.put(temp,value);
					}
				}
				
				// print out the salespersonID and commission for the last 3 month.
				int i = 0;
				System.out.println("SalespersonID : Commission");
				System.out.println("--------------------------");
				while (!map.isEmpty()) {
					if (map.containsKey(i)) {
						System.out.println("     " + i + "        : " + map.get(i));
						map.remove(i);
					}
					i++;
				}
				break;
				
				
			}
		} while (input != 0);
		reader.close();


	}

}
