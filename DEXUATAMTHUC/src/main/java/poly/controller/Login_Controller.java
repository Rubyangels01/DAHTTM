package poly.controller;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import poly.DAO.*;

import poly.bean.USER;
@RequestMapping("/users")
@Controller
public class Login_Controller {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String DangKy() {
        return "users/Register";
    }
	 @RequestMapping(value = "/Login", method = RequestMethod.GET)
	    public String home() {
	        return "users/Login";
	    }
	 
	 @RequestMapping("/signup")
		public String register(HttpServletRequest request, Model model) throws SQLException
		{
		
		 USER_DAO user_DAO = new USER_DAO();
			 // Lấy dữ liệu từ người dùng nhập về
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");	
			String message = "Mật khẩu không khớp!";
			if(!password.equals(confirmPassword))
			{
				 
				model.addAttribute("error", true);
				request.setAttribute("message", message);
				return "users/Register";
			}
			USER user = new USER(username,email,password);
			user_DAO.ADD_USERS(user);
			return "users/Login";
			
		}
	@RequestMapping("/checkLogin")
	public String checkLogin(HttpServletRequest request,Model model) throws SQLException 
	{
		USER_DAO user_DAO = new USER_DAO();
		 HttpSession session = request.getSession();
		String message = "Sai thông tin đăng nhập!";
		String username= request.getParameter("email");
		String password = request.getParameter("password");
//		ListKH  list = new ListKH();
		boolean found = false;
		
		 if(username.equals("admin") && password.equals("123"))
			{	
			
			 session.setAttribute("maUser", "KitChen");
         	session.setAttribute("email", "admin11@gmail.com");         	
         	session.setAttribute("nameuser", "admin");
         	session.setAttribute("password", "123");
//				return "admin/MainHome";
			}
		 else {
			 
			 if(!user_DAO.LISTUSER().isEmpty())
				{
					 for (USER user : user_DAO.LISTUSER()) 
					 {
				            
				           
				            	if (user.getEmail().equals(username) && user.getPassword().equals(password)) 
					            {
					            	found = true;					            	
					            			session.setAttribute("User", user);
					            			
					            	session.setAttribute("maUser", user.getMaUser());
					            	session.setAttribute("email", user.getEmail());
					            	session.setAttribute("nameuser", user.getTenUser());				            	
					            	session.setAttribute("password", user.getPassword());
					            	return "users/Main";
					                
					                
					            
							}
				        }
				}	        		       	    	    	
	    
	}
		 request.setAttribute("message", message);
	    	return "users/Login";
	}
}
