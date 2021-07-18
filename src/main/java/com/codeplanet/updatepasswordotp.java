package com.codeplanet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatepasswordusingotp")
public class updatepasswordotp extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
		{
			String email=req.getParameter("email");
			String otp=req.getParameter("otp");
			String psw=req.getParameter("psw");
			Connection con=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nikproject", "root", "nikita");
			PreparedStatement pst =con.prepareStatement("update user set password=? where email =?");
			pst.setString(1, psw);
			pst.setString(2, email);
			pst.executeUpdate();
			} catch(Exception ex) {
			}
			req.setAttribute("email", email);
			
		}
}

