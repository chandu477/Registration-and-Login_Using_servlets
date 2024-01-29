package in.sp.backend;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-Form")
public class Login extends HttpServlet {
	

		
		 public void doGet(HttpServletRequest request, 
			      HttpServletResponse response)
			      throws ServletException, IOException 
			   {
			 RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");
 		rd.include(request, response);
		  
			   }
		   

		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
	              PrintWriter out= response.getWriter();
		        // Retrieve form parameters
		        
		        String email = request.getParameter("email");
		        String password = request.getParameter("password");
		        
		        
		        //jdbc (java datbase connectivity)
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		        	
		        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration_data","root","Mumbai@123");
		        	PreparedStatement ps=con.prepareStatement("Select *from register where emial=? and password=?");
		        	
		        	
		        	ps.setString(1, email);
		        	ps.setString(2, password);
		        	
		        	
		        	ResultSet rs=ps.executeQuery();
		        	
		        	if(rs.next()) {
		        		
		        		HttpSession session= request.getSession();
		        		session.setAttribute("session_name",rs.getString(1));
		        		
		        		
		        		
		        		
		        		
//		        		
		        		RequestDispatcher rd =request.getRequestDispatcher("/Profile.jsp");
		        		rd.include(request, response);
		        		
		        	}else {
		        		response.setContentType("text/html");
		        		out.println("<h3 style='color:red'>Error ! email id and password didnt matched</h3>");
		        	
	      		     RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");
	        		 rd.include(request, response);
		        	}
		        }
		        catch(Exception e){
		        	
		        	e.printStackTrace();
		        	response.setContentType("text/html");
	        		out.println("<h3 style='color:red'>"+e.getMessage()+"</h3>");
	        		//redirect to the new page 
      		RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");
        		rd.include(request, response);
		        }

		        
		    }
		}




