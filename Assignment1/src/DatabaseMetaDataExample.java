import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
public class DatabaseMetaDataExample {
final static String driverClass	= "oracle.jdbc.driver.OracleDriver";
final static String connectionURL= "jdbc:oracle:thin:@localhost:1521:CUSTDB";
final static String userID= "scott";
final static String userPassword= "tiger";
Connection con = null;
/**
* Construct a DatabaseMetaDataExample object. This constructor
* will create an Oracle database connection.
*/
public DatabaseMetaDataExample() {
try {
System.out.print("  Loading JDBC Driver  -> " + driverClass + "\n");
Class.forName(driverClass).newInstance();
System.out.print("  Connecting to        -> " + connectionURL + "\n");
this.con = DriverManager.getConnection(connectionURL, userID, userPassword);
System.out.print("  Connected as         -> " + userID + "\n");
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (InstantiationException e) {
e.printStackTrace();
} catch (IllegalAccessException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}
}
private static void prt(Object s) {
System.out.print(s);
}
private static void prt(int i) {
System.out.print(i);
}
private static void prtln(Object s) {
prt(s + "\n");
}
private static void prtln(int i) {
prt(i + "\n");
}
private static void prtln() {
prtln("");
}
/**
* Run the DatabaseMetaData Example. This method will use a
* DatabaseMetaData object to obtain the capabilities of the
* JDBC driver and the database during runtime.
*/
public void runExample() {
DatabaseMetaData md = null;
try {
// Obtain a DatabaseMetaData object from our current
// connection  
md = con.getMetaData();
prtln();
prtln("  DatabaseMetaData Information");
prtln("  ============================");
prt("  - Product Name          : ");
try {
prtln(md.getDatabaseProductName());
} catch (SQLException e) { 
prtln("java.sql.SQLException: Unsupported feature");
}
prt("  - Product Version Number : ");
try {
prtln(md.getDatabaseProductVersion());
} catch (SQLException e) {
prtln("java.sql.SQLException: Unsupported feature");
}
prt("  - Database Major Version : ");
try {
prtln(md.getDatabaseMajorVersion());
} catch (SQLException e) {
prtln("java.sql.SQLException: Unsupported feature");
}
prt("  - Database Minor Version : ");
try {
prtln(md.getDatabaseMinorVersion());
} catch (SQLException e) {
prtln("java.sql.SQLException: Unsupported feature");
}
prt("  - Driver Name            : ");
try {
prtln(md.getDriverName());
} catch (SQLException e) {
prtln("java.sql.SQLException: Unsupported feature");
}
prtln("  - Driver Major Version   : " + md.getDriverMajorVersion());
prtln("  - Driver Minor Version   : " + md.getDriverMinorVersion());
prt("  - Username               : ");
try {
prtln(md.getUserName());
} catch (SQLException e) {
prtln("java.sql.SQLException: Unsupported feature");
}
prt("  - Catalogs               : ");
try {
ResultSet catalogs = md.getCatalogs();
while (catalogs.next()) {
prtln("    - " + catalogs.getString(1) );
}
catalogs.close();
} catch (SQLException e) {
prtln("java.sql.SQLException: Unsupported feature");
}
prtln();
} catch (SQLException e) {
e.printStackTrace();
}
}
/**
* Close down Oracle connection.
*/
public void closeConnection() {
try {
System.out.print("  Closing Connection...\n");
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
/**
* Sole entry point to the class and application.
* @param args Array of String arguments.
* @exception java.lang.InterruptedException
*            Thrown from the Thread class.
*/
public static void main(String[] args)
throws java.lang.InterruptedException {
DatabaseMetaDataExample dmde = new DatabaseMetaDataExample();
dmde.runExample();
dmde.closeConnection();
}
}