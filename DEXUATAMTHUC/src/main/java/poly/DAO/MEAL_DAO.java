package poly.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.internal.compiler.IDebugRequestor;

import poly.bean.CT_BUOCLAM;
import poly.bean.MEAL;
import poly.bean.NGUYENLIEU;

public class MEAL_DAO {

	  private Connection connection;
	  int TIMKIEM,LUU = 0;
	  int YEUTHICH,XEM = 1;
	  
	     public MEAL_DAO() 
			// TODO Auto-generated constructor stub
		 throws SQLException {
	    	 try {
	    	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	    } catch (ClassNotFoundException e) {
	    	        e.printStackTrace();
	    	    }
	        // Khởi tạo kết nối đến database
	        String url = "jdbc:sqlserver://ADMIN-PC:1435;databaseName=DEXUATAMTHUC;encrypt=false;trustServerCertificate=true;";
	        String username = "sa";
	        String password = "123";
	        connection = DriverManager.getConnection(url, username, password);
	    }
	     private MEAL getMealById(int id) throws SQLException {
	    	    String query = "SELECT * FROM MONAN WHERE IDMON = ?";
	    	    
	    	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	    	        statement.setInt(1, id);

	    	        try (ResultSet resultSet = statement.executeQuery()) {
	    	            if (resultSet.next()) {
	    	                int maMon = resultSet.getInt("IDMON");
	    	                String tenMon = resultSet.getString("TENMON");
	    	                String hinhAnh = resultSet.getString("HINHANH");
	    	                String mota = resultSet.getString("MOTA");
	    	                int idLoai = resultSet.getInt("IDLOAI");
	    	                int idND = resultSet.getInt("ID_ND");
	    	                int idCT = resultSet.getInt("IDCONGTHUC");
	    	                return new MEAL(maMon,idLoai,idND,idCT, tenMon, hinhAnh,mota);
	    	            }
	    	        }
	    	    }

	    	    // Trong trường hợp không tìm thấy món ăn, trả về null hoặc xử lý tùy ý
	    	    return null;
	    	}

	    public ArrayList<MEAL> getAllMeal() throws SQLException {
	    	ArrayList<MEAL> Meal_List = new ArrayList<>();
	        // Thực hiện truy vấn để lấy tất cả các sản phẩm từ database
	        String query = "SELECT * FROM MONAN";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	       
	        // Duyệt qua các dòng kết quả trả về và tạo đối tượng Product từ mỗi dòng
	        while (resultSet.next()) 
	        {
	            int maMon = resultSet.getInt("IDMON");
	            String tenMon = resultSet.getString("TENMON");
	            String hinhAnh = resultSet.getString("HINHANH");
	            String moTa = resultSet.getString("MOTA");
	            int idLoai = resultSet.getInt("IDLOAI");
	            int idND = resultSet.getInt("ID_ND");
                int idCT = resultSet.getInt("IDCONGTHUC");            
	            MEAL meal = new MEAL(maMon,idLoai,idND,idCT, tenMon, hinhAnh,moTa);
	            Meal_List.add(meal);
	        }
	        return Meal_List;
	    }
	    public ArrayList<MEAL> getTypeFood(int typefood) throws SQLException {
	        ArrayList<MEAL> LIST_FOOD = new ArrayList<>();

	        // Thực hiện truy vấn để lấy tất cả các sản phẩm nước hoa nam từ database
	        String query = "SELECT * FROM MONAN WHERE IDLOAI = ?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, typefood);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                // Duyệt qua các dòng kết quả trả về và tạo đối tượng MEAL từ mỗi dòng
	                while (resultSet.next()) {
	                    int maMon = resultSet.getInt("IDMON");
	                    String tenMon = resultSet.getString("TENMON");
	                    String hinhAnh = resultSet.getString("HINHANH");
	                    String moTa = resultSet.getString("MOTA");
	                    int idLoai = resultSet.getInt("IDLOAI");                   
	                    int idND = resultSet.getInt("ID_ND");
	                    int idCT = resultSet.getInt("IDCONGTHUC");            
	    	            MEAL meal = new MEAL(maMon,idLoai,idND,idCT, tenMon, hinhAnh,moTa);
	                    LIST_FOOD.add(meal);
	                }
	            }
	        }

	        return LIST_FOOD;
	    }
	    
	    
	    
	    public ArrayList<MEAL> getFamousFood() throws SQLException {
	        ArrayList<MEAL> LIST_FOOD = new ArrayList<>();

	        
	        String query = "SELECT M.*, \n" +
	                "       COUNT(DX.IDMON) AS LuotXem, \n" +
	                "       COUNT(DTK.IDMON) AS LuotTimKiem\n" +
	                "FROM MONAN M\n" +
	                "LEFT JOIN DL_HANHDONG DX ON M.IDMON = DX.IDMON AND DX.HANHDONG = 0\n" +
	                "LEFT JOIN DL_HANHDONG DTK ON M.IDMON = DTK.IDMON AND DTK.HANHDONG = 1\n" +
	                "GROUP BY M.IDMON, M.TENMON, M.HINHANH, M.MOTA, M.IDLOAI,M.ID_ND,M.IDCONGTHUC\n" +
	                "ORDER BY LuotTimKiem DESC, LuotXem DESC;";

	        try (PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            // Duyệt qua các dòng kết quả trả về và tạo đối tượng MEAL từ mỗi dòng
	            while (resultSet.next()) {
	                int maMon = resultSet.getInt("IDMON");
	                String tenMon = resultSet.getString("TENMON");
	                String hinhAnh = resultSet.getString("HINHANH");
	                String moTa = resultSet.getString("MOTA");
	                int idLoai = resultSet.getInt("IDLOAI");	              	             
	                int idND = resultSet.getInt("ID_ND");
	                int idCT = resultSet.getInt("IDCONGTHUC");            
		            MEAL meal = new MEAL(maMon,idLoai,idND,idCT, tenMon, hinhAnh,moTa);
	                LIST_FOOD.add(meal);
	            }
	        }

	        return LIST_FOOD;
	    }
	    //HÀM KIỂM TRA TRẠNG THÁI ĐỐI VỚI 1 NGƯỜI DÙNG ĐÃ CÓ HÀNH ĐỘNG NÀO VỚI MÓN ĂN NÀY CHƯA
	    public int CHECK_STATUS(int iduser, int idmon, int action) throws SQLException {
	    	int status = -1;

	        // Thực hiện truy vấn để lấy tất cả các sản phẩm nước hoa nam từ database
	        String query = "SELECT dbo.CHECK_ACTION_USER(?,?,?) AS TRANGTHAI;";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	        	statement.setInt(1, iduser);
	            statement.setInt(2, idmon);  // Sửa thành setInt(2, action)
	            statement.setInt(3, action);   // Sửa thành setInt(2, action)
	           

	            try (ResultSet resultSet = statement.executeQuery()) {
	                // Duyệt qua các dòng kết quả trả về và tạo đối tượng MEAL từ mỗi dòng
	                while (resultSet.next()) {
	                	status = resultSet.getInt("TRANGTHAI");	                   
	                    
	                }
	            }
	        }

	        return status;
	    }
	    // Hàm tính điểm cho hàm người dùng đó đối với món ăn
	    public int Point_Action_Like_Save(int action,int idmon, int iduser) throws SQLException {
	    	int point = -1;
	    	if(CHECK_STATUS(iduser, idmon,action) == 0)
	    	{
	    		point = 0;
	    		
	    	}
	    	else {
	    		point = 1;	    		
			}
	        

	        return point;
	    }
	    // HÀM KIỂM TRA XEM NGƯỜI DÙNG ĐÃ XEM MÓN ĂN HAY TÌM KIẾM MÓN ĂN NÀY CHƯA
	    public int CHECK_STATUS_VIEW(int iduser, int idmon, int action) throws SQLException {
	    	int status = -1;

	        // Thực hiện truy vấn để lấy tất cả các sản phẩm nước hoa nam từ database
	        String query = "SELECT dbo.CountUserViews(?,?,?) AS TRANGTHAI;";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	        	statement.setInt(1, iduser);
	            statement.setInt(2, idmon);  // Sửa thành setInt(2, action)
	            statement.setInt(3, action);   // Sửa thành setInt(2, action)
	           

	            try (ResultSet resultSet = statement.executeQuery()) {
	                // Duyệt qua các dòng kết quả trả về và tạo đối tượng MEAL từ mỗi dòng
	                while (resultSet.next()) {
	                	status = resultSet.getInt("TRANGTHAI");	                   
	                    
	                }
	            }
	        }

	        return status;
	    }
	    // HÀM TÍNH SỐ LƯỢNG XEM HAY TÌM KIẾM 1 MÓN ĂN CỦA NGƯỜI DÙNG gần nhất trong 1 ngày
	    public int COUNT_VIEW_SEARCH_USER(int action, int idmon, int idnd,int time) throws SQLException {

	        int count = -1;
	        if(CHECK_STATUS_VIEW(idnd, idmon, action) == 0)
	        {
	        	count = 0;
	        }
	        else {
	        	
	        	String query = "SELECT COUNT(*) AS LUOTXEM\r\n"
	        			+ "FROM DL_HANHDONG\r\n"
	        			+ "WHERE (HANHDONG = ?)\r\n"
	        			+ "      AND ID_ND = ?\r\n"
	        			+ "      AND IDMON = ?\r\n"
	        			+ "      AND DATEDIFF(DAY, THOIGIAN, GETDATE()) <= ?;";
		        
		        try (PreparedStatement statement = connection.prepareStatement(query)) {
		            statement.setInt(1,action);
		            statement.setInt(2, idnd);  // Sửa thành setInt(2, action)
		            statement.setInt(3,idmon);    // Sửa thành setInt(3, idnd)
		            statement.setInt(4, time);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                // Duyệt qua các dòng kết quả trả về và lấy giá trị lượt xem
		                if (resultSet.next()) {
		                	count = resultSet.getInt("LUOTXEM");
		                }
		            }
		        }
			}
	        // Thực hiện truy vấn để lấy tổng số lượt xem từ DS_HANHDONG
	        

	        return count;
	    }
	    //HÀM TÍNH SỐ LƯỢT XEM HAY TÌM KIẾM CỦA NGƯỜI DÙNG ĐỐI VỚI 1 MÓN ĂN
	    {
	    	
	    }
	    // Hàm tính thời gian chênh lệch mà người dùng đã tìm kiếm or xem so với thời gian hiện tại
	    public int getTimeToNow(int action, int idmon, int idnd) throws SQLException {
//	 	   public int getLuotXem(int idmon, int action, int idnd) throws SQLException {
	 	        int time = 0;
	 	        if(CHECK_STATUS_VIEW(idnd, idmon, action) == 0)
	 	        {
	 	        	time = 0;
	 	        }
	 	        else {
	 	        // Thực hiện truy vấn ngày gần nhất mà người dùng đó xem món ăn đó là bao nhiều ngày so với hiện tại
		 	        String query = "SELECT TOP 1 DATEDIFF(SECOND, THOIGIAN, GETDATE()) AS SoNgayGanNhat\r\n"
		 	        		+ "FROM DL_HANHDONG\r\n"
		 	        		+ "WHERE HANHDONG = ? AND ID_ND = ? AND IDMON = ?\r\n"
		 	        		+ "ORDER BY THOIGIAN DESC;\r\n"
		 	        		;
		 	        
		 	        try (PreparedStatement statement = connection.prepareStatement(query)) {
		 	            statement.setInt(1, action);
		 	            statement.setInt(2, idnd);  // Sửa thành setInt(2, action)
		 	            statement.setInt(3, idmon);    // Sửa thành setInt(3, idnd)

		 	            try (ResultSet resultSet = statement.executeQuery()) {
		 	                // Duyệt qua các dòng kết quả trả về và lấy giá trị lượt xem
		 	                if (resultSet.next()) {
		 	                	time = resultSet.getInt("SoNgayGanNhat");
		 	                }
		 	            }
		 	        }
				}
	 	        

	 	        return time;
	 	    }
	    
	    public List<MEAL> LIST_SUGGEST(int idnd, int typefood) throws SQLException {
	        // Các hệ số để điều chỉnh ảnh hưởng của mỗi yếu tố
	        int heSoTimKiemGanDay = 7;
	        int heSoXemGanDay = 6;
	        int heSoYeuThich = 5;
	        int heSoLuu = 4;

	        Map<Integer, Integer> thongTinMonAn = new HashMap<>();

	        for (MEAL meal : getTypeFood(typefood)) {
	            int diemMonAn = 0;
	            int timeToNow = getTimeToNow(1, meal.getMaMon(), idnd);
	            
	            if (timeToNow == 0) {
	                diemMonAn = 0;
	            } else if (timeToNow <= 86400) { // Thời gian chênh lệch là 1 ngày
	                diemMonAn = COUNT_VIEW_SEARCH_USER(TIMKIEM, meal.getMaMon(), idnd, 1) * heSoTimKiemGanDay +
	                        COUNT_VIEW_SEARCH_USER(XEM, meal.getMaMon(), idnd, 1) * heSoXemGanDay +
	                        Point_Action_Like_Save(YEUTHICH, meal.getMaMon(), 1) * heSoYeuThich +
	                        Point_Action_Like_Save(LUU, meal.getMaMon(), 0) * heSoLuu;
	            } else if (timeToNow <= 259200) { // Thời gian chênh lệch là 3 ngày
	                diemMonAn = COUNT_VIEW_SEARCH_USER(TIMKIEM, meal.getMaMon(), idnd, 3) * (heSoTimKiemGanDay - 2) +
	                        COUNT_VIEW_SEARCH_USER(XEM, meal.getMaMon(), idnd, 3) * heSoXemGanDay - 1 +
	                        Point_Action_Like_Save(YEUTHICH, meal.getMaMon(), idnd) * heSoYeuThich +
	                        Point_Action_Like_Save(LUU, meal.getMaMon(), idnd) * heSoLuu;
	            } else { // Hơn 3 ngày
	                diemMonAn = COUNT_VIEW_SEARCH_USER(TIMKIEM, meal.getMaMon(), idnd, timeToNow) * 1 +
	                        COUNT_VIEW_SEARCH_USER(XEM, meal.getMaMon(), idnd, timeToNow) * heSoXemGanDay - 3 +
	                        Point_Action_Like_Save(YEUTHICH, meal.getMaMon(), idnd) * heSoYeuThich +
	                        Point_Action_Like_Save(LUU, meal.getMaMon(), 0) * heSoLuu;
	            }

	            thongTinMonAn.put(meal.getMaMon(), diemMonAn);
	        }

	        // Sắp xếp danh sách thông tin món ăn với điểm từ trên xuống
	        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(thongTinMonAn.entrySet());

	        // Sắp xếp theo giảm dần của giá trị (điểm)
	        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

	        // Lọc các món ăn có điểm dưới 12
	        List<MEAL> sortedMeals = new ArrayList<>();
	        for (Map.Entry<Integer, Integer> entry : sortedList) {
	            int maMon = entry.getKey();
	            int diem = entry.getValue();

	            if (diem < 12) {
	                break; // Dừng khi gặp món có điểm dưới 12
	            }

	            MEAL meal = getMealById(maMon);
	            // Hàm này cần phải được thay thế bằng hàm lấy thông tin món ăn theo ID

	            sortedMeals.add(meal);
	        }

	        return sortedMeals;
	    }	    
	    
	    public List<MEAL> getRelatedMeals(int idnd, int typefood) throws SQLException {
	        List<MEAL> relatedMeals = new ArrayList<>();

	        // Danh sách các món ăn được gợi ý
	        List<MEAL> suggestedMeals = LIST_SUGGEST(idnd, typefood);

	        // Tìm kiếm các món ăn có tên chứa từ khóa
	        for (MEAL meal : getTypeFood(typefood)) {
	            for (MEAL suggestedMeal : suggestedMeals) {
	                // Tách tên món ăn thành các từ
	                String[] keywords = suggestedMeal.getTenMon().toLowerCase().split("\\s+");

	                // Kiểm tra xem từng từ khóa có xuất hiện trong tên món ăn không
//	                boolean containsKeyword = true;
	                for (String keyword : keywords) {
	                    if (meal.getTenMon().toLowerCase().contains(keyword)) {
	                    	 relatedMeals.add(meal);
	                    }
	                   
	                }

	                // Nếu tất cả các từ khóa đều xuất hiện, thêm vào danh sách món ăn liên quan
	                
	            }
	        }

	        // Loại bỏ các món ăn trùng lặp trong danh sách
	        Set<MEAL> uniqueMeals = new HashSet<>(relatedMeals);
	        relatedMeals.clear();
	        relatedMeals.addAll(uniqueMeals);

	        return relatedMeals;
	    }
	    public List<MEAL> generateMixedList(int idnd, int typefood) throws SQLException {
	        List<MEAL> mixedList = new ArrayList<>();

	        // Lấy 60% danh sách món ăn phổ biến
	        if(getRelatedMeals(idnd, typefood).size() == 0)
	        {
	        	mixedList.addAll(getTypeFood(typefood));
	        }
	        else {
	        	int popularCount = (int) (0.6 * getTypeFood(typefood).size());
		        mixedList.addAll(getTypeFood(typefood).subList(0, popularCount));
		        
		        // Lấy 40% danh sách món ăn theo sở thích người dùng
		        int userPreferenceCount = (int) (0.4 * getRelatedMeals(idnd, typefood).size());
		        mixedList.addAll(getRelatedMeals(idnd, typefood).subList(0, userPreferenceCount));
			}
	        

	        return mixedList;
	    }

	    public ArrayList<NGUYENLIEU> GET_NGUYENLIEU(int idMonan) throws SQLException {
	        ArrayList<NGUYENLIEU> LIST_NL = new ArrayList<>();

	        // Thực hiện truy vấn để lấy tất cả các sản phẩm nước hoa nam từ database
	        String query = "EXEC GETALLNGUYENLIEU @IDMONAN = ?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, idMonan);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                // Duyệt qua các dòng kết quả trả về và tạo đối tượng MEAL từ mỗi dòng
	                while (resultSet.next()) {
	                    int idNL = resultSet.getInt("IDNGUYENLIEU");
	                    String tenNL = resultSet.getString("TENNGUYENLIEU");
	                    String tenDV = resultSet.getString("TENDONVI");
	                    int soLuong = resultSet.getInt("SOLUONG");                   
	                      NGUYENLIEU nguyenlieu = new NGUYENLIEU(idNL,soLuong,tenNL,tenDV);
	    	           
	                    LIST_NL.add(nguyenlieu);
	                }
	            }
	        }

	        return LIST_NL;
	    }
	    
	    public ArrayList<CT_BUOCLAM> GET_STEP(int idMonan) throws SQLException {
	        ArrayList<CT_BUOCLAM> LIST_BUOCLAM = new ArrayList<>();

	        // Thực hiện truy vấn để lấy tất cả các sản phẩm nước hoa nam từ database
	        String query = "SELECT BL.BUOCLAM, BL.MOTA\r\n"
	        		+ "FROM MONAN MA\r\n"
	        		+ "JOIN CT_BUOCLAM BL ON BL.IDCONGTHUC = MA.IDCONGTHUC\r\n"
	        		+ "WHERE MA.IDMON = ?;";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, idMonan);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                // Duyệt qua các dòng kết quả trả về và tạo đối tượng MEAL từ mỗi dòng
	                while (resultSet.next()) {
	                    int buocLam = resultSet.getInt("BUOCLAM");
	                    String moTa = resultSet.getString("MOTA");             
	                     CT_BUOCLAM ct_buoclam = new CT_BUOCLAM(buocLam,moTa);
	    	           
	                     LIST_BUOCLAM.add(ct_buoclam);
	                }
	            }
	        }

	        return LIST_BUOCLAM;
	    }
	    

	    // hàm thêm một khách hàng vào cơ sở dữ liệu
//	    public void addCustomer(KhachHang khachHang) throws SQLException {
//	        String query = "INSERT INTO KhachHang (fullName, email, phone,accountName,pass) VALUES (?, ?, ?,?,?)";
//	        try (PreparedStatement statement = connection.prepareStatement(query)) {
//	            statement.setString(1, khachHang.getFullName());
//	            statement.setString(2, khachHang.getEmail());
//	            statement.setString(3, khachHang.getPhone());
//	            statement.setString(4, khachHang.getAccountName());
//	            statement.setString(5, khachHang.getPassword());
//	            statement.executeUpdate();
//	        }
//	    }
//	    
//	    public void updateKH(KhachHang kh) throws SQLException {
//	        String query = "UPDATE KhachHang SET DiachiNH = ? WHERE makh=?"; 
//	        try (PreparedStatement statement = connection.prepareStatement(query)) {
//	            statement.setString(1, kh.getDiachiNH());
//	            statement.setInt(2, kh.getMaKH());
//	     
//	            statement.executeUpdate();
//	        }
//	    }
//
//	    public void close() throws SQLException {
//	        // Đóng kết nối đến database
//	        if (connection != null) {
//	            connection.close();
//	        }
//	    }


}
