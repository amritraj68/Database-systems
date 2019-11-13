/* @Author : Amrit Raj
 Student Id : 1001723851
*/
package insertstatements;

import connection.JDBCconnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

public class Insert_Into_Tables {
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException{
        
        addCountry();
        addPlayers();
        addPlayerCards();
        addPlayerAssistGoals();
        addMatchResults();
        System.out.println("connected from main");
    }

    // Start of addCountry method
    public static void addCountry() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
       Connection connection = JDBCconnect.createConnection();
       System.out.println("Adding to the COUNTRY table");
       
       connection.setAutoCommit(false);

	PreparedStatement insert_into_country = null;
        
        insert_into_country = (PreparedStatement) connection.prepareStatement("INSERT INTO COUNTRY VALUES(?,?,?,?)");

        FileInputStream input = new FileInputStream("C://Users//Amrit Raj Singh//Desktop//FALL 2019//DATABASE SYSTEMS//PROJECT 1//Country.xls");
	 	
        POIFSFileSystem fs = new POIFSFileSystem(input);

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFSheet sheet = wb.getSheetAt(0);

	 	Row row;

	 	for(int i=0; i<=sheet.getLastRowNum(); i++)
	 	{
	 		row = sheet.getRow(i);
	 		
	 		String countryName = row.getCell(0).getStringCellValue();
	 		int population = (int) row.getCell(1).getNumericCellValue();
	 		int numOfWorldCupWon = (int) row.getCell(2).getNumericCellValue();
	 		String manager = row.getCell(3).getStringCellValue();
	 		
	 		insert_into_country.setString(1, countryName);
	 		insert_into_country.setInt(2, population);
			insert_into_country.setInt(3, numOfWorldCupWon);
			insert_into_country.setString(4, manager);
 
			insert_into_country.executeUpdate();
    
	 		System.out.println("Import rows "+i);

	 	} // end of for loop

	 	connection.commit();

	 	insert_into_country.close();

	 	input.close();
                
                connection.close();
       
    } // end of addCountry
    
    
    // Start of addPlayerCards
    public static void addPlayerCards() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
       Connection connection = JDBCconnect.createConnection();
       
       System.out.println("Adding to the PLAYER_CARD table");
       
       connection.setAutoCommit(false);

	PreparedStatement insert_into_player_cards = null;
        
        insert_into_player_cards = (PreparedStatement) connection.prepareStatement("INSERT INTO PLAYER_CARDS VALUES(?,?,?)");

        FileInputStream input = new FileInputStream("C://Users//Amrit Raj Singh//Desktop//FALL 2019//DATABASE SYSTEMS//PROJECT 1//Player_Cards.xls");
	 	
        POIFSFileSystem fs = new POIFSFileSystem(input);

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFSheet sheet = wb.getSheetAt(0);

	 	Row row;

	 	for(int i=0; i<=sheet.getLastRowNum(); i++)
	 	{
	 		row = sheet.getRow(i);
	 		
	 		int playerId = (int) row.getCell(0).getNumericCellValue();
	 		int yellowCards = (int) row.getCell(1).getNumericCellValue();
                        int redCards = (int) row.getCell(2).getNumericCellValue();
                        
	 		
	 		insert_into_player_cards.setInt(1, playerId);
			insert_into_player_cards.setInt(2, yellowCards);
                        insert_into_player_cards.setInt(3, redCards);
			
 
			insert_into_player_cards.executeUpdate();
    
	 		System.out.println("Import rows "+i);

	 	} // end of for loop

	 	connection.commit();

	 	insert_into_player_cards.close();

	 	input.close();
                
                connection.close();
       
    } // end of addPlayerCards
    
    //Start of Match_Results
    
     public static void addMatchResults() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
       Connection connection = JDBCconnect.createConnection();
       
       System.out.println("Adding to the MATCH_RESULTS table");
       
       connection.setAutoCommit(false);

	PreparedStatement insert_into_match_results = null;
        
        insert_into_match_results = (PreparedStatement) connection.prepareStatement("INSERT INTO MATCH_RESULTS VALUES(?,?,?,?,?,?,?,?)");

        FileInputStream input = new FileInputStream("C://Users//Amrit Raj Singh//Desktop//FALL 2019//DATABASE SYSTEMS//PROJECT 1//Match_results.xls");
	 	
        POIFSFileSystem fs = new POIFSFileSystem(input);

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFSheet sheet = wb.getSheetAt(0);

	 	Row row;

	 	for(int i=0; i<=sheet.getLastRowNum(); i++)
	 	{
	 		row = sheet.getRow(i);
	 		
	 		int matchId = (int) row.getCell(0).getNumericCellValue();
                        
                        java.util.Date DOB = row.getCell(1).getDateCellValue(); // java.util.Date
                        java.sql.Date sqlDate = new java.sql.Date(DOB.getTime());
                        
	 		String team1 = row.getCell(2).getStringCellValue();
                        String team2 = row.getCell(3).getStringCellValue();
                        int team1Score = (int) row.getCell(4).getNumericCellValue();
                        int team2Score = (int) row.getCell(5).getNumericCellValue();
                        String stadiumName = row.getCell(6).getStringCellValue();
                        String hostCity = row.getCell(7).getStringCellValue();
                        
	 		
	 		insert_into_match_results.setInt(1, matchId);
			insert_into_match_results.setDate(2, sqlDate);
                        insert_into_match_results.setString(3, team1);
                        insert_into_match_results.setString(4, team2);
                        insert_into_match_results.setInt(5, team1Score);
                        insert_into_match_results.setInt(6, team2Score);
                        insert_into_match_results.setString(7, stadiumName);
                        insert_into_match_results.setString(8, hostCity);
 
			insert_into_match_results.executeUpdate();
    
	 		System.out.println("Import rows "+i);

	 	} // end of for loop

	 	connection.commit();

	 	insert_into_match_results.close();

	 	input.close();
                
                connection.close();
       
    } // end of Match_Results
    
     // Start of addPlayers method
     public static void addPlayers() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
       Connection connection = JDBCconnect.createConnection();
       
       System.out.println("Adding to the PLAYERS table");
       
       connection.setAutoCommit(false);

	PreparedStatement insert_into_players = null;
        
        insert_into_players = (PreparedStatement) connection.prepareStatement("INSERT INTO PLAYERS VALUES(?,?,?,?,?,?,?,?,?,?,?)");

        FileInputStream input = new FileInputStream("C://Users//Amrit Raj Singh//Desktop//FALL 2019//DATABASE SYSTEMS//PROJECT 1//Players.xls");
	 	
        POIFSFileSystem fs = new POIFSFileSystem(input);

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFSheet sheet = wb.getSheetAt(0);

	 	Row row;

	 	for(int i=0; i<=sheet.getLastRowNum(); i++)
	 	{
	 		row = sheet.getRow(i);
	 		
                        int playerId = (int) row.getCell(0).getNumericCellValue();
	 		String name = row.getCell(1).getStringCellValue();
	 		String fName = row.getCell(2).getStringCellValue();
                        String lName = row.getCell(3).getStringCellValue();
                        java.util.Date DOB = row.getCell(4).getDateCellValue(); // java.util.Date
                        
                        java.sql.Date sqlDate = new java.sql.Date(DOB.getTime());
                        
                        String country = row.getCell(5).getStringCellValue();
	 		int height = (int) row.getCell(6).getNumericCellValue();
	 		String club = row.getCell(7).getStringCellValue();
                        String position = row.getCell(8).getStringCellValue();
                        int caps_for_country = (int) row.getCell(9).getNumericCellValue();
                        String is_Captain = row.getCell(10).toString();
	 		
	 		
                        insert_into_players.setInt(1, playerId);
                        insert_into_players.setString(2, name);
                        insert_into_players.setString(3, fName);
                        insert_into_players.setString(4, lName);
                        insert_into_players.setDate(5, sqlDate);
                        insert_into_players.setString(6, country);
	 		insert_into_players.setInt(7, height);
                        insert_into_players.setString(8, club);
                        insert_into_players.setString(9, position);
			insert_into_players.setInt(10, caps_for_country);
			insert_into_players.setString(11, is_Captain);
                        
			insert_into_players.executeUpdate();
                        
                     //   System.out.println("added to batch");
                        
	 		System.out.println("Import rows "+i);

	 	} // end of for loop
        //int[] executeBatch = insert_into_players.executeBatch();
        
       // System.out.println("Batch Executed");
        //  int [] executeBatch = new int[20];
        //executeBatch = insert_into_players.executeBatch();
        //System.out.println ("Total records inserted in bulk from CSV file " + executeBatch.length); 

	 	connection.commit();

	 	insert_into_players.close();

	 	input.close();
                
                connection.close();
       
    } // end of addPlayers method
     
     // Start of PlayerAssistGoals
     public static void addPlayerAssistGoals() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
       Connection connection = JDBCconnect.createConnection();
       
       System.out.println("Adding to the PLAYER_ASSIST_GOALS table");
       
       connection.setAutoCommit(false);

	PreparedStatement insert_into_player_assist_goals = null;
        
        insert_into_player_assist_goals = (PreparedStatement) connection.prepareStatement("INSERT INTO PLAYER_ASSIST_GOALS VALUES(?,?,?,?,?)");

        FileInputStream input = new FileInputStream("C://Users//Amrit Raj Singh//Desktop//FALL 2019//DATABASE SYSTEMS//PROJECT 1//Player_Assists_Goals.xls");
	 	
        POIFSFileSystem fs = new POIFSFileSystem(input);

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFSheet sheet = wb.getSheetAt(0);

	 	Row row;

	 	for(int i=0; i<=sheet.getLastRowNum(); i++)
	 	{
	 		row = sheet.getRow(i);
	 		
	 		int playerId = (int) row.getCell(0).getNumericCellValue();
	 		int numberOfMatches = (int) row.getCell(1).getNumericCellValue();
                        int goals = (int) row.getCell(2).getNumericCellValue();
                        int assists = (int) row.getCell(3).getNumericCellValue();
                        int minutesPlayed = (int) row.getCell(4).getNumericCellValue();
                        
	 		
	 		insert_into_player_assist_goals.setInt(1, playerId);
			insert_into_player_assist_goals.setInt(2, numberOfMatches);
                        insert_into_player_assist_goals.setInt(3, goals);
                        insert_into_player_assist_goals.setInt(4, assists);
                        insert_into_player_assist_goals.setInt(5, minutesPlayed);
			
 
			insert_into_player_assist_goals.executeUpdate();
    
	 		System.out.println("Import rows "+i);

	 	} // end of for loop

	 	connection.commit();

	 	insert_into_player_assist_goals.close();

	 	input.close();
                
                connection.close();
    } 
    
} // end of main