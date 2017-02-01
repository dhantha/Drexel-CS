// Dhantha Gunarathna assn4
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.sql.*;

public class assn4
{
	// need to read from stdin
	public static void main(String[] args)
	{
		// let the input string parse and call the methods
		// on the object accordingly 
		//Scanner in = new Scanner(System.in);
		//String line;
		int total;
		int sales;
		int once;
		int fives;
		int tens;
		int twenties;
		
		Boolean flag = true;
		assn4 register = new assn4(flag);
		
		
		int l = args.length;
		String[] splitArray = new String[l];
		//System.out.println(l);
		
		
		for(int a=0;a<l;a++)
		{
			splitArray[a] = args[a];
		}
		
		String command = splitArray[0];
		//System.out.println(command);
		command = command.trim();
		//System.out.println("splitArray[0] is " + command);
		//check for args lengths 
		//if its other than init update the global variables 1st 
		if(command.equals("init"))  //s.equals("/quit")
		{
			try
			{
				//System.out.println("in init");
				flag = false;
				register = new assn4(flag);
				total = Integer.parseInt(splitArray[1]);
				sales = 0;
				once  = Integer.parseInt(splitArray[3]);
				fives = Integer.parseInt(splitArray[4]); //System.out.println(fives);
				tens   = Integer.parseInt(splitArray[5]);
				twenties = Integer.parseInt(splitArray[6]);
				
				register = new assn4(sales,total,once,fives,tens,twenties,flag);		
				//System.out.println("out init");
			}
			catch(Exception e)
			{
				System.out.println("Bad Argument");
				//System.out.println("1");
				System.exit(1);					
			}
			
		}
		else if(command.equals("purchase"))
		{
			try
			{					
				//System.out.println("in purchase");
				int[] updateVals = register.updateRegister();
				sales = updateVals[0];
				total = updateVals[1];				
				once  = updateVals[2];
				fives = updateVals[3]; //System.out.println(fives);
				tens  = updateVals[4];
				twenties = updateVals[5];
				
				register = new assn4(sales,total,once,fives,tens,twenties,flag);	
				
				sales = Integer.parseInt(splitArray[1]);
				once  = Integer.parseInt(splitArray[3]);
				fives = Integer.parseInt(splitArray[4]);
				tens  = Integer.parseInt(splitArray[5]);
				twenties = Integer.parseInt(splitArray[6]);	
				// create a new register and set the values
				// make the transaction
				
								
				register.purchase(sales,once,fives,tens,twenties);
			}
			catch(Exception e)
			{
				System.out.println("Bad Argument");
				//System.out.println("1");
				System.exit(1);							
			}
		}
		else if(command.equals("change"))
		{
			try
			{					
				//System.out.println("in change");	
				// error check here
				for(int i=1;i<splitArray.length;i++)
				{
					if(splitArray[i].equals("="))
					{
						// need to update the db
						String[] changeReceived = Arrays.copyOfRange(splitArray,1,i);
						String[] changeToGive = Arrays.copyOfRange(splitArray,i+1,splitArray.length);
						
						int change_l = changeReceived.length;
						int toGive_l = changeToGive.length;
						
						int credit = 0;
						int debit = 0;
						
						//System.out.println(change_l);
						//System.out.println(toGive_l);
						
						int[] credits = new int[change_l];
						int[] debits = new int [toGive_l];
						
						for(int i_c=0;i_c<change_l;i_c++)
						{
							try
							{
								credits[i_c] = Integer.parseInt(changeReceived[i_c]);
							}
							catch(NumberFormatException nfe){}
						}
						
						for(int i_d=0;i_d<toGive_l;i_d++)
						{
							try
							{
								debits[i_d] = Integer.parseInt(changeToGive[i_d]);
							}
							catch(NumberFormatException nfe){}								
						}
						int tOnce = 0;
						int tFives = 0;
						int tTens = 0;
						int tTwenties = 0;
						
						int pOnce = 0;
						int pFives = 0;
						int pTens = 0;
						int pTwenties = 0;							
						
						//change taking
						if(change_l == 1){credit = 1*credits[0];tOnce = credits[0];}
						else if(change_l == 2){credit = 1*credits[0] + 5*credits[1];tOnce = credits[0];tFives = credits[1];}
						else if(change_l == 3){credit = 1*credits[0] + 5*credits[1] + 10*credits[2];tOnce = credits[0];tFives = credits[1];tTens = credits[2];}
						else if(change_l == 4){credit = 1*credits[0] + 5*credits[1] + 10*credits[2] + 20*credits[3];tOnce = credits[0];tFives = credits[1];tTens = credits[2];tTwenties = credits[3];}
						
						//need to give
						if(toGive_l == 1){debit = 1*debits[0];pOnce = debits[0];}
						else if(toGive_l == 2){debit = 1*debits[0] + + 5*debits[1];pOnce = debits[0];pFives = debits[1];}
						else if(toGive_l == 2){debit = 1*debits[0] + + 5*debits[1] + 10*debits[2];pOnce = debits[0];pFives = debits[1];pTens = debits[2];}
						else if(toGive_l == 4){debit = 1*debits[0] + 5*debits[1] + 10*debits[2] + 20*debits[3];pOnce = debits[0];pFives = debits[1];pTens = debits[2];pTwenties = debits[3];}
												
						if(credit == debit)
						{
							// match the change
							// make 2 update 								
							// add update
							// make a new register with updated values 
							int[] updateVals = register.updateRegister();
							sales = updateVals[0];
							total = updateVals[1];				
							once  = updateVals[2];
							fives = updateVals[3]; //System.out.println(fives);
							tens  = updateVals[4];
							twenties = updateVals[5];
							
							register = new assn4(sales,total,once,fives,tens,twenties,flag);	
							register.change(tOnce,tFives,tTens,tTwenties,pOnce,pFives,pTens,pTwenties);
							String returnChange = " ";
							for(int j=0;j<changeToGive.length;j++)
							{
								returnChange = returnChange + " " + changeToGive[j];								
							}
							System.out.println(returnChange);							
						}
						else
						{
							System.out.println("Bad Argument");
							//System.out.println("1");
							System.exit(1);
						}						
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("Bad Argument");
				//System.out.println("1");
				System.exit(1);					
			}
		}
		else if(command.equals("report"))
		{
			//System.out.println("in report");
			// make a new register update the values 
			int[] updateVals = register.updateRegister();
			sales = updateVals[0];
			total = updateVals[1];				
			once  = updateVals[2];
			fives = updateVals[3]; //System.out.println(fives);
			tens  = updateVals[4];
			twenties = updateVals[5];
			
			register = new assn4(sales,total,once,fives,tens,twenties,flag);	
			register.report();
			
		}
		else
		{
			System.out.println("unrecognized command");
			System.exit(1);
		}
	}
		
	
	// private variables
	private int rTotal;
	private int rSales;
	private int rOnces;
	private int rFives;
	private int rTens;
	private int rTwenties;
	
	
	// constructor
	public assn4(Boolean fl)
	{
		if(!fl) //if the flag is false register does not exists 
		{
			dropTable();
			initDb();			
		}				
	}
	
	public assn4(int sales,int total, int onces,int fives,int tens, int twenties,Boolean fl)
	{
		rSales = sales;
		rTotal = total;
		rOnces = onces;
		rFives	= fives;
		rTens = tens;
		rTwenties = twenties;
		
		if(!fl){insertDb(rTotal,rOnces,rFives,rTens,rTwenties);}
		else
		{
			//System.out.println("already there");
		}
		// create table and insert into the db
	}
	
	public void purchase(int sales,int onces,int fives,int tens, int twenties )
	{
		int pTotal = 1*onces + 5*fives + 10*tens + 20*twenties;
		//System.out.println(pTotal);
		
		rOnces = rOnces + onces; //Integer.parseInt(cOnce);
		rFives	= rFives + fives; // Integer.parseInt(cFives);
		rTens = rTens + tens; // Integer.parseInt(cTens);
		rTwenties = rTwenties + twenties; //Integer.parseInt(cTwenties); 
		
		if(sales > pTotal)
		{
			// error code 2, not enough money
			System.out.println("Not enough money to make the purchase");
			//System.out.println("3");
			System.exit(2);
		}
		
		
		else
		{
			int diff = pTotal - sales; // diff only has values from 1 - 19
			if(diff > rTotal)
			{
				System.out.println("Not enough money in the register to give change");
				//System.out.println("3");
				System.exit(3);
			}
			
			String cOnce = "0";
			String cFives = "0";
			String cTens = "0";
			String cTwenties = "0";
			if(diff < 5)
			{
				cOnce = Integer.toString(diff % 5);
			}
			else if (5 <= diff && diff < 10)
			{
				cFives  = "1";
				cOnce = Integer.toString(diff % 5);				
			}
			else if (10 < diff && diff < 20)
			{
				if(diff % 5 == 0)
				{
					cTens = "1";
					cFives = "1";					
				}
				else if(diff % 5 < 5)
				{
					cTens = "1";
					cOnce = Integer.toString(diff % 5);
				}
				else
				{
					cTens = "1";
					cFives = "1";
					cOnce = Integer.toString(diff % 5);
				}
			}
			//System.out.println(cOnce + " " + cFives + " " + cTens + " " + cTwenties);
			rSales = rSales + sales;
			rTotal = rTotal + sales;
			rOnces = rOnces - Integer.parseInt(cOnce);
			rFives	= rFives - Integer.parseInt(cFives);
			rTens = rTens - Integer.parseInt(cTens);
			rTwenties = rTwenties - Integer.parseInt(cTwenties);	
				
			if(rOnces < 0 || rFives < 0 || rTens < 0 || rTwenties < 0)
			{
				System.out.println("Not enough money in the register to give balance");
				//System.out.println("3");
				System.exit(2);
			}
			System.out.println(cOnce + " " + cFives + " " + cTens + " " + cTwenties);
			updateDb(rSales,rTotal,rOnces,rFives,rTens,rTwenties);//fives,tens,twenties);			
		}
	}
	
	public void change(int tonce,int tfives,int ttens, int ttwenties,int ponce,int pfives,int ptens, int ptwenties)
	{
		// change 0 0 0 1 = 5 1 1 0
		// return whats on the left
		// no need to write to db
		rSales = rSales + 0;
		rTotal = rTotal + 0;
		rOnces = rOnces + tonce - ponce; //Integer.parseInt(cOnce);
		rFives	= rFives + tfives - pfives; //Integer.parseInt(cFives);
		rTens = rTens + ttens - ptens;// Integer.parseInt(cTens);
		rTwenties = rTwenties + ttwenties - ptwenties; // Integer.parseInt(cTwenties);
		if(rOnces < 0 || rFives < 0 || rTens < 0 || rTwenties < 0)
		{
			System.out.println("Not enough money in the register");
			//System.out.println("3");
			System.exit(3);
		}
		else
		{
			updateDb(rSales,rTotal,rOnces,rFives,rTens,rTwenties);
		}
		
		//System.out.println(once + " " + fives + " " + tens + " " + twenties) ;
		
	}
	
	public void report()
	{
		// read the record from the db 
		String[] selects = selectDb();		
		String sa = selects[0];
		String to = selects[1];
		String on = selects[2];
		String fi = selects[3];
		String te = selects[4];
		String tw = selects[5];
		
		System.out.println(sa + " : " + to + " = " + on + " " + fi + " " + te + " " + tw);	
	}
	
	public int[] updateRegister()
	{
		String[] selects = selectDb();
		int[] returnIntArray = new int[6];
		
		for(int h=0;h<6;h++)
		{
			returnIntArray[h] = Integer.parseInt(selects[h]);
		}
		return returnIntArray;		
	}
	
	public void initDb()
	{
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			//System.out.println("Opened init database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE REGISTRY " +
					   "(ID INT PRIMARY KEY     NOT NULL," +
					   " SALES          INT     NOT NULL, " + 
					   " TOTAL          INT     NOT NULL, " + 
					   " ONCE           INT     NOT NULL, " + 
					   " FIVES          INT     NOT NULL, " +
					   " TENS           INT     NOT NULL, " +
					   " TWENTIES       INT     NOT NULL);"; 
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} 
		catch ( Exception e ) 
		{
			System.err.println("unable to connect to db please add the test.db into the same direcory");
			//System.out.println("4");
			System.exit(4);
		}
		//System.out.println("Table created successfully");
	}
	
	public void insertDb(int total,int once,int fives,int tens, int twenties)
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    c.setAutoCommit(false);
		    //System.out.println("Opened insert database successfully");
			////System.out.println("inside the funcn db " + tens);
			stmt = c.createStatement();
			String sql = "INSERT INTO REGISTRY (ID,SALES,TOTAL,ONCE,FIVES,TENS,TWENTIES)" +
                   "VALUES (1, 0," + total + "," + once + "," + fives + "," + tens + "," + twenties + ");"; 
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} 
		catch ( Exception e )
		{
			//System.out.println("bomb here");
			System.err.println("unable to connect to db please add the test.db into the same direcory");
			//System.out.println("4");
			System.exit(4);
		}
		//System.out.println("Records inserted successfully");		
	}
	
	public void updateDb(int sales,int total,int once,int fives,int tens, int twenties)
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    c.setAutoCommit(false);
		    //System.out.println("Opened update database successfully");

			stmt = c.createStatement();
			String sql = "UPDATE REGISTRY set SALES = " + sales + "," + "TOTAL = " + total + "," + "ONCE = " + once + "," +
						"FIVES = " + fives + "," + "TENS = " + tens + "," + "TWENTIES = " + twenties + " WHERE ID=1;";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} 
		catch ( Exception e )
		{
			System.err.println("unable to connect to db please add the test.db into the same direcory");
			//System.out.println("4");
			System.exit(4);
		}
		//System.out.println("Records updated successfully");			
	}
	
	public String[] selectDb()
	{
		Connection c = null;
		Statement stmt = null;
		String[] returnString = new String[6];
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			//System.out.println("Opened selectDb database successfully");
			
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM REGISTRY;" );
			while ( rs.next() )
			{
				//int id = rs.getInt("id");
				String  sales = rs.getString("SALES");
				String  total = rs.getString("TOTAL");
				String  once = rs.getString("ONCE");
				String  fives = rs.getString("FIVES");
				String  tens = rs.getString("TENS");
				String  twenties = rs.getString("TWENTIES");
				
				returnString[0] = sales;
				returnString[1] = total;
				returnString[2] = once;
				returnString[3] = fives;
				returnString[4] = tens;
				returnString[5] = twenties;        
			}
			rs.close();
			stmt.close();
			c.close();
			
			//System.out.println("selects are handover from selectDb successfully");
		}
		catch ( Exception e )
		{
			System.err.println("unable to connect to db please add the test.db into the same direcory");
			//System.out.println("4");
			System.exit(4);
		}
		//System.out.println("Operation selected successfully");
		return returnString;
	}
	
	public void dropTable()
	{
		Connection c = null;
		Statement stmt = null;
		try 
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			//System.out.println("dropTable function called successfully");

			stmt = c.createStatement();
			String sql = "DROP TABLE REGISTRY";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			//System.out.println("table dropped successfully");
			
		}
		catch ( Exception e ) 
		{
			System.err.println("unable to connect to db please add the test.db into the same direcory");
			//System.out.println("4");
			System.exit(4);
		}
	}	
}