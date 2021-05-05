package come.currency1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
/**
 * Servlet implementation class Employe
 */
public class Employe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		 System.out.println("init...");
		}
	    	
		

		// TODO Auto-generated method stub
	

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
    	{
    		//1st step : load the driver
    		//System.out.println("Trying to load the driver.......");

    		System.out.println("Trying to load the driver.......");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver loaded....");
		
			//2nd step : connect to the database 
			System.out.println("Trying to connect to the database");
//jdbc:oracle:thin:@localhost:1521:yourInstanceName XE/ORCL/OSE whaterver name found in tnsnames.ora file
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","sai121298");
			System.out.println("Connected to the database");
			
    		 Statement stmt = conn.createStatement(); 
    	ResultSet rs= stmt.executeQuery("select * from emp");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
    	PrintWriter pw = response.getWriter();
    	response.setContentType("text/html");
    	  
    	pw.println("<html><body>");
    	pw.println("<table border=2>");  
    	pw.println("<tr><th>	  EmpId  	</th><th>	  EmpName	  </th><th> JOB	</th><th> COMM </th><th> Salary	  </th><tr>");
    	while (rs.next()) 
        {  
            int n = rs.getInt("empno");   
            String nm = rs.getString("ename");  
            String j = rs.getString("JOB");
            int c = rs.getInt("comm");
            int s = rs.getInt("SAL"); 
            pw.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + j + "</td><td>"+c+ "</td><td>" + s + "</td></tr>");
	    pw.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + j + "</td><td>"+c+ "</td><td>" + s + "</td></tr>");
	    pw.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + j + "</td><td>"+c+ "</td><td>" + s + "</td></tr>");   
        }  
        pw.println("</table>");  
        pw.println("</html></body>");  
        conn.close();  
       }  
	catch (Exception e) 
    { 
	 System.out.println("error");  
    }  
	
	}

}
