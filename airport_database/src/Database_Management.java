import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database_Management
{
	

	public static void main(String[] args) throws SQLException
	{
		
		System.out.println("MySQL Connect Example");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "airport_satabase";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		
		//Elegxos an exei sundethei h vasi
		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to database");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 

		try
		{
			Statement st = conn.createStatement();
			int val = st.executeUpdate("INSERT INTO `customer` VALUES (\"A007\", \"James\",\"Bond\", \"Fort\")");
			System.out.println("1 row affected");
		}
		catch(SQLException s)
		{
			System.out.println("SQL statement is not executed!");
		}

	    try
		{
			Statement st = conn.createStatement();
			int val = st.executeUpdate("INSERT INTO `flight` VALUES (\"F777\", \"USAir\", 1, 1, 1, \"AAA\", \"ZZZ\", \"2020-06-10 10:30:00\", \"2020-06-10 12:30:00\", 2, 60, 20, 0, 200, 0)");
			System.out.println("1 row affected");
		}
		catch(SQLException s)
		{
			System.out.println("SQL statement is not executed!");
		}

		try
		{
			Statement st = conn.createStatement();
			int val = st.executeUpdate("INSERT INTO `reservation` VALUES (\"R007\", \"New York\", \"2020-05-10 12:30:00\", \"F002\", \"2020-06-10 05:30:00\", \"2020-06-10 6:30:00\", \"Business\", 250, 160, \"κρατημένη - εξοφλημένη\", 250, 0, \"A007\")");
			System.out.println("1 row affected");
		}
		catch(SQLException s)
		{
			System.out.println("SQL statement is not executed!");
		}

		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT flightnum, flight_aircode\r\n" + "FROM Flight\r\n" + "ORDER BY Flight_Aircode\r\n" + "");
			System.out.println("Flight Number: " + "\t" + "Airline Code: ");
			while (res.next()) {
				String i = res.getString("flightnum");
				String j = res.getString("flight_aircode");
				System.out.println(i + "\t\t" + j);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
			}

		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT flightnum, flight_totalbus, flight_occubus, flight_totaleco, flight_occueco\r\n" +
											"FROM Flight\r\n" +
											"WHERE (flight_TotalBus = flight_OccuBus) AND (flight_TotalEco = flight_OccuEco)");
			System.out.println("Flight Number: " + "\t" + "Total Business Class Seats" + "\t" + "Occupied Business Class Seats" + "\t" + "Total Economy Class Seats" + "\t" + "Occupied Economy Class Seats");
			while (res.next()) {
				String i = res.getString("flightnum");
				String j = res.getString("flight_totalbus");
				String k = res.getString("flight_occubus");
				String l = res.getString("flight_totaleco");
				String m = res.getString("flight_occueco");
				System.out.println(i + "\t\t" + j + "\t\t" + k + "\t\t" + l + "\t\t" + m);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
			}

		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT FlightNum, Flight_DepCityCode, Flight_ArrCityCode\r\n" +
											"FROM Flight\r\n" +
											"WHERE ((Flight_DepCityCode = \"YYZ\") AND (Flight_ArrCityCode = \"JFK\")) OR ((Flight_DepCityCode = \"JFK\") AND (Flight_ArrCityCode = \"YYZ\"))\r\n" +
											"ORDER BY FlightNum");
			System.out.println("Flight Number: " + "\t" + "flight_depcitycode: " + "\t" + "flight_arrcitycode: ");
			while (res.next()) {
				String a = res.getString("flightnum");
				String b = res.getString("flight_depcitycode");
				String c = res.getString("flight_arrcitycode");

				System.out.println(a + "\t\t" + b + "\t\t" + c);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
			}















/*		//Erwthma (v)
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter flight number: ");
		String flightnum = sc.nextLine();

		System.out.print("Enter Airline code: ");
		String first_aircode = sc.nextLine();


		try{
			Statement st = conn.createStatement();
		    String query = "SELECT flightnum, flight_aircode\r\n" +
		    				"FROM Flight\r\n" +
		    				"WHERE (flight_AvStatus = 1) AND (flightnum=?) AND (flight_aircode=?)";
		    PreparedStatement preparedStmt = conn.prepareStatement(query);
			System.out.println("List of available flights");
			System.out.println("Flight Number: " + "\t" + "Airline Code: ");
		    preparedStmt.setString (1, flightnum);
		    preparedStmt.setString(2, first_aircode);
	        preparedStmt.executeUpdate();
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
		}

		System.out.println("\n\n");


		try{

			String query = "INSERT INTO `reservation` "
					+ " (re_num, re_flightnum, re_status)" + " values (R555, ?, krathmenh)";

		    PreparedStatement preparedStmt = conn.prepareStatement(query);
		    preparedStmt.setString(1, "re_flightnum");
	        preparedStmt.executeUpdate();
	        System.out.println("1 row affected");
		}catch(SQLException s){
			System.out.println("SQL statement is not executed!");
		}

*/















/*		//Erwthma (vi)
		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT re_num, re_status\r\n" +
											"FROM reservation\r\n" +
											"ORDER BY re_num");
			System.out.println("Results after query execution");
			System.out.println("Reservation Number: " + "\t" + "Reservation Status: ");
			while (res.next()) {
				String i = res.getString("re_num");
				String j = res.getString("re_status");
				System.out.println(i + "\t\t\t" + j);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
		}


		System.out.println("\n\n");


		Scanner sc = new Scanner(System.in);
		System.out.print("Enter reservation number: ");
		String answ = sc.nextLine();

		try{
			String query = "UPDATE Reservation\r\n" +
					"SET Re_Status = \"kratimen-exoflimeni\"\r\n" +
					"WHERE Re_Num = ?\r\n" +
					"";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, answ);
			preparedStmt.executeUpdate();

			System.out.println("1 row affected");

		}catch(SQLException s){
			System.out.println("SQL statement is not executed!");
		}


		System.out.println("\n\n");

		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT re_num, re_status\r\n" +
											"FROM reservation\r\n" +
											"ORDER BY re_num");
			System.out.println("Results after query execution");
			System.out.println("Reservation Number: " + "\t" + "Reservation Status: ");
			while (res.next()) {
				String i = res.getString("re_num");
				String j = res.getString("re_status");
				System.out.println(i + "\t\t\t" + j);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
		}

*/


















/*		//Erwthma (vii) //vale "AirCa" th prwth kai USAir th deuterh
		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT re_num, re_status\r\n" +
											"FROM reservation\r\n" +
											"ORDER BY re_num");
			System.out.println("Results before query execution");
			System.out.println("Reservation Number: " + "\t" + "Reservation Status: ");
			while (res.next()) {
				String i = res.getString("re_num");
				String j = res.getString("re_status");
				System.out.println(i + "\t\t\t" + j);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
			}

		System.out.println("\n\n");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Airline code: ");
		String answ = sc.nextLine();
		try{
			String query = "DELETE FROM reservation\r\n" +
							"WHERE re_status=\"akurwmeni\" and re_flightnum in (SELECT flightnum \r\n" +
																				"FROM flight \r\n" +
																				"WHERE flight_aircode=?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, answ);
			preparedStmt.executeUpdate();
			System.out.println("Deletion query executed");
		}catch(SQLException s){
			System.out.println("SQL statement is not executed!");
		}

		System.out.println("\n\n");

		try{
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT re_num, re_status\r\n" +
											"FROM reservation\r\n" +
											"ORDER BY re_num");
			System.out.println("Results after query execution");
			System.out.println("Reservation Number: " + "\t" + "Reservation Status: ");
			while (res.next()) {
				String i = res.getString("re_num");
				String j = res.getString("re_status");
				System.out.println(i + "\t\t\t" + j);
			}
			}catch(SQLException s){
				System.out.println("SQL code does not execute.");
			}

*/





		conn.close();
		System.out.println("Disconnected from database");
	}

}
