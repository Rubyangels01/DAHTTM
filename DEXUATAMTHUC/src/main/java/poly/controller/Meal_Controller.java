package poly.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.DAO.MEAL_DAO;



@Controller
public class Meal_Controller {
	@RequestMapping(value = "users/Main", method = RequestMethod.GET)
	public String Home() {
		return "users/Main";
	}
	@RequestMapping(value = "users/mainfood", method = RequestMethod.GET)
	public String Catogory(Model model) throws SQLException {
		MEAL_DAO meal_dao = new MEAL_DAO();
	    model.addAttribute("MainFood", meal_dao.getTypeFood(1));
	    model.addAttribute("DessertFood",meal_dao.getTypeFood(2));
	    model.addAttribute("BreakFast",meal_dao.getTypeFood(3));
	    return "users/Category";
	}
	@RequestMapping(value = "users/famousfood", method = RequestMethod.GET)
	public String List_Famous(Model model) throws SQLException {
		MEAL_DAO meal_dao = new MEAL_DAO();
	    model.addAttribute("famousfood",meal_dao.getFamousFood(1));
	    return "users/Famous_List";
	}
}
