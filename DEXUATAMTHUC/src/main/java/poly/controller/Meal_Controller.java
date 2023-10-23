package poly.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.DAO.MEAL_DAO;
import poly.bean.MEAL;



@Controller
public class Meal_Controller {
	
	@RequestMapping(value = "users/Main", method = RequestMethod.GET)
	public String Home(Model model) throws SQLException {
		MEAL_DAO meal_dao = new MEAL_DAO();
	    model.addAttribute("famousfood",meal_dao.getFamousFood());
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
	    model.addAttribute("famousfood",meal_dao.getFamousFood());
	    return "users/Famous_List";
	}
	@RequestMapping(value = "users/suggest", method = RequestMethod.GET)
	public String listSuggest(Model model, HttpSession session) throws SQLException {
	    MEAL_DAO mealDao = new MEAL_DAO();
	    
	    // Kiểm tra xem session có tồn tại giá trị "maUser" hay không
	    Integer maUser = (Integer) session.getAttribute("maUser");
//	    model.addAttribute("message", maUser);
	    
	    if (maUser == null) {
	        
	        return "users/Login";
	    }
	    model.addAttribute("Suggest_BreakFast", mealDao.generateMixedList(maUser, 3));
	    model.addAttribute("Suggest_Lunch", mealDao.generateMixedList(maUser, 1));
	    model.addAttribute("Suggest_Dinner", mealDao.generateMixedList(maUser, 4));
	    model.addAttribute("Suggest_Dessert", mealDao.generateMixedList(maUser, 2));
	    return "users/Suggest";
	}
	
	@RequestMapping(value = "users/Infor_Meal{id}", method = RequestMethod.GET)
	public String productDetail(@PathVariable("id") String melaId, ModelMap model, HttpServletRequest request)
			throws SQLException {
		// xử lý mã sản phẩm và chuẩn bị dữ liệu

		MEAL_DAO mealDao = new MEAL_DAO();
		for (MEAL meal : mealDao.getAllMeal()) {
			if (meal.getMaMon() == Integer.parseInt(melaId)) {
				
					request.setAttribute("imgUrl", meal.getHinhAnh());
					request.setAttribute("tenMon", meal.getTenMon());
					 model.addAttribute("NguyenLieu",mealDao.GET_NGUYENLIEU(meal.getMaMon()));
					 model.addAttribute("BuocLam",mealDao.GET_STEP(meal.getMaMon()));
					return "users/DeTail_Meal";

				}

			} 
		return "users/DeTail_Meal";


		// trả về view hiển thị chi tiết sản phẩm
	}
//	@RequestMapping(value = "users/suggest", method = RequestMethod.GET)
//	public String suggest() {
//		return "users/Suggest";
//	}
}
