<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"> -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/561/561611.png">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script> -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap">

  
    <title>Cooky.com Header</title>
    <style>
        /* Reset CSS */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Montserrat', sans-serif;
        }

        /* Header Styles */
        header {
            font-family: 'Montserrat', sans-serif;
            background-color: #ff6600;
            color: #fff;
            padding: 10px 0;
            text-decoration: none;
        }

        main {
            font-family: 'Montserrat', sans-serif;
            position: relative;
            width: 100%;
            /* margin-bottom: 40px; */
            background-color: #f1f1f1;
            min-height: 100px;
            
        }

        /* footer {
            background-color: #ff6600;
            color: #fff;
            padding-bottom: 50px; 
        } */

        footer {
            font-family: 'Montserrat', sans-serif;
            position: relative;
            width: 100%;
            background: #ff6600;
            min-height: 100px;
            padding: 20px 50px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            /* max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px; */
        }

        .logo {
            font-size: 32px;
            font-weight: bold;
            text-transform: uppercase;
        }

        nav ul {
            list-style: none;
            display: flex;
            margin-bottom: auto;
            
        }

        nav li {
            margin-right: 20px;
        }

        nav a {
            
            text-decoration: none;
            color: #fff;
            /* font-weight: bold; */
            font-size: 18px;
        }
        nav a:hover {
            color: black;
            text-decoration: none;
        }

        .search-box {
            display: flex;
            align-items: center;
        }

        .search-input {
            border: none;
            padding: 8px;
            border-radius: 10px;
        }
        
        .search-icon {
            margin-right: 10px;
            font-size: 24px;
        }

        .login-btn{
            /* background-color: transparent; */
            background-color: #ff6600;
            border: 2px solid #fff;
            /* color: #fff; */
            padding: 8px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        .login-btn a {
            color: #fff;
            text-decoration: none;
            /* font-weight: bold; */
            
        }

        .login-btn a:hover {
            color: #323232;
        }

        .banner-image {
            /* width: 70em; 
            height: 20em; */
            /* width: auto; */
            object-fit: cover;
            width: 1920px;
            height: 500px;
            /* height: auto; */
            display: block;
            /* margin: 20px auto; Điều chỉnh khoảng cách dưới header  */
            max-width: 100%;
        }
        .meal-image
        {
            width: 30em;
            height: 20em;
            /* height: auto; */
            /* display: block; */
            display: flex;
            margin-bottom: 10px;
            
            /* width: 30em;
            height: 20em;
            /* height: auto; */
            /* display: block; */
            /* display: flex;
            margin-bottom: 10px; */

            /* width: 15em;
            height: 15em;
            align-items: right; */
            /* display: block; */
            /* margin: 20px auto; /* Điều chỉnh khoảng cách dưới header 
         max-width: 100%; */
        }
        .image-container {
            margin-top:  50px; /* Khoảng cách 20px xung quanh container */
            margin-left: 2.3em;
        }
        /* .col-md-12
        {
            margin-right: 50em;
        } */
        .Name-meal
        {
            text-align: center;
            font-weight: 3px;
            font-family: 'Times New Roman', Times, serif;
            /* font-size: 5em; */
        }
        
        .Name-meal a {
            color: #323232;
            font-size: 18px;
            text-decoration: underline;
            
        }

        .Name-meal a:hover {
            color: #ff6600;
            font-size: 18px;
            text-decoration: underline;
            
        }

        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            /* background-color: white; */
            background-color: rgb(255, 255, 255);
            background-clip: border-box;
            border: 1px solid rgba(0, 0, 0, 0.125);
            border-radius: 10px;
        }

        .card-title {
            
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            /* background-color: white; */
            background-color: rgb(255, 255, 255);
            background-clip: border-box;
            border: 1px solid rgba(0, 0, 0, 0.125);
            border-radius: 10px;
            padding: 15px 10px 5px 10px;
            text-align: center;
            font-weight: bold;
        }

        .card-detail {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            /* background-color: white; */
            background-color: rgb(255, 255, 255);
            background-clip: border-box;
            border: 1px solid rgba(0, 0, 0, 0.125);
            border-radius: 10px;
            padding: 0px 0px 0px 10px;
        }

        p {
            font-size: 24px;
            
            
        }

        

        .card-img {
            width: 100%;
            border-radius: 10px;
        }

        .py-5 {
            padding-top: 3rem !important;
            padding-bottom: 3rem !important;
            
            
        }

        h5 {
            font-size: 20px;
        }

        .center {
            text-align: center;
        }

        .dropbtn {
            background-color: #ff6600;
            color: #fff;
            /* padding: 16px; */
            font-size: 18px;
            /* font-weight: bold; */
            border: none;
            cursor: pointer;
        }

        .dropbtn:hover, .dropbtn:focus {
            background-color: #ff6600;
            color: #323232;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 200px;
            overflow: auto;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: #323232;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            border-bottom: 2px solid #323232;
        }

        .dropdown a:hover {background-color: #ff6600;}

        .show {display: block;}
        
        .search-box {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: #fff;
            height: 40px;
            border-radius: 40px;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            
        }

        .search-box:hover > .search-txt {
            width: 960px;
            
            padding: 0 6px;
        }

        

        .search-box:hover > .search-btn {
            background: #fff;
            color: #323232;
        }

        .search-btn {
            color: #323232;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background: #323232;
            display: flex;
            justify-content: center;
            align-items: center;
            transition: 0.4s;
            color: white;
            cursor: pointer;
            text-decoration: none;
        } 

        .search-btn > i {
            font-size: 20px;
        } 

        .search-txt {
            border: none;
            background: none;
            outline: none;
            padding: 0;
            color: #323232;
            font-size: 16px;
            transition: 0.4s;
            line-height: 40px;
            width: 0px;
            font-weight: bold;
        }


        .btn-save {
            width: 85%;
            position: relative;
            border-radius: 5px;
            padding: 5px 10px 5px 10px;
            margin-top: 15px;
            margin-bottom: 15px;
            margin-left: 20px;
            background-color: white;
            border-radius: 1px solid rgba(0, 0, 0, 0.125);
        }

        .btn-save:hover {
            width: 85%;
            position: relative;
            border-radius: 5px;
            padding: 5px 10px 5px 10px;
            margin-top: 15px;
            margin-bottom: 15px;
            margin-left: 20px;
            background-color: #ff6600;
            color: #f1f1f1;
            border-radius: 1px solid rgba(0, 0, 0, 0.125);
            

        }

        /* .btn-like
        {
            margin-top: 2em;
            padding: 5px 10em 5px 10em;
            background-color: rgb(255, 255, 255);
            border-radius: 10px;
            text-align: center;
            margin-left: 5em;
        } */

        .btn-like {
            width: 85%;
            position: relative;
            border-radius: 5px;
            padding: 5px 10px 5px 10px;
            margin-top: 15px;
            margin-bottom: 15px;
            margin-left: 20px;
            background-color: white;
            border-radius: 1px solid rgba(0, 0, 0, 0.125);
           
           
        }

        .btn-like:hover {
            width: 85%;
            position: relative;
            border-radius: 5px;
            padding: 5px 10px 5px 10px;
            margin-top: 15px;
            margin-bottom: 15px;
            margin-left: 20px;
            background-color: #ff6600;
            color: #f1f1f1;
            border-radius: 1px solid rgba(0, 0, 0, 0.125);
            

        }

        .social-icon,
        .menu {
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 10px 0;
            flex-wrap: wrap;
        }

        .social-icon__item,
        .menu__item {
            list-style: none;
        }

        .social-icon__link {
            font-size: 2rem;
            color: #fff;
            margin: 0 10px;
            display: inline-block;
            transition: 0.5s;
        }
        .social-icon__link:hover {
            transform: translateY(-10px);
        }

        .menu__link {
            font-size: 1.2rem;
            color: #fff;
            margin: 0 10px;
            display: inline-block;
            transition: 0.5s;
            text-decoration: none;
            opacity: 0.75;
            font-weight: 300;
        }

        .menu__link:hover {
            opacity: 1;
            text-decoration: none;
        }

        .footer p {
            color: #fff;
            margin: 15px 0 10px 0;
            font-size: 1rem;
            font-weight: 300;
            font-family: 'Montserrat', sans-serif;
        }

        
        
    </style>
</head>
<body>
    <header>
        <div class="container">
            <div class="logo">KITCHEN</div>
            <nav>
                <ul>
                    <li><a href="Home.html">Trang Chủ</a></li>
                    <!-- <li><a href="#">Món Ăn</a></li> -->
                    <li class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">Danh Mục
                            <i class="fa fa-caret-down"></i>
                        
                            <div id="myDropdown" class="dropdown-content">  <!--dropdown danh mục -->
                                <a href="#">Danh Mục Món Ăn</a>
                                <a href="GoiYMonAn.html">Gợi Ý Hôm Nay</a>
                                <a href="TimKiemMonAn.html">Tìm Kiếm Món Ăn</a>
                                <a href="MonAnPhoBien.html">Món Ăn Phổ Biến</a>
                                <a href="DSYeuThich.html">Danh Sách Yêu Thích</a>
                                <a href="TaoMon.html">Tạo Món Ăn</a>
                         </div>
                        </button>
                    </li>

                    <script>
                        /* When the user clicks on the button, 
                        toggle between hiding and showing the dropdown content */
                        function myFunction() {
                          document.getElementById("myDropdown").classList.toggle("show");
                        }
                        
                        // Close the dropdown if the user clicks outside of it
                        window.onclick = function(event) {
                          if (!event.target.matches('.dropbtn')) {
                            var dropdowns = document.getElementsByClassName("dropdown-content");
                            var i;
                            for (i = 0; i < dropdowns.length; i++) {
                              var openDropdown = dropdowns[i];
                              if (openDropdown.classList.contains('show')) {
                                openDropdown.classList.remove('show');
                              }
                            }
                          }
                        }
                    </script>

                   
                    <li><a href="#">Tin Tức</a></li>
                </ul>
            </nav>
            <button class="login-btn"><a href="DangNhap.html" >Đăng Nhập</a></button>
        </div>
    </header>

    <main>
        
    <div class="container py-5">
        <div class="row">
            
                <div class="col-md-9">
                    <div class="card">
                        <img class="meal-detail card-img" src="${imgUrl}">
                    </div>

                    <div class="py-5">
                        <div class="card-title">
                            <p>
                                ${tenMon}
                            </p>
                        </div>
                    </div>

                    <div class="card-detail">
                        <h2 class="center">Cách Làm ${tenMon}</h2>
                        <h3>Nguyên Liệu</h3>
                         <c:forEach items="${NguyenLieu}" var="NGUYENLIEU">
					<h4>- ${NGUYENLIEU.soLuong} ${NGUYENLIEU.tenDonVi} ${NGUYENLIEU.tenNguyenLieu}</h4>
				</c:forEach>
                        
                      
                        <h3>Cách Làm</h3>
                        <c:forEach items="${BuocLam}" var="CT_BUOCLAM">
					 <h4>Bước ${CT_BUOCLAM.buocLam}: ${CT_BUOCLAM.moTa}</h4>                         
				</c:forEach>
                       
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <div>
                            <button class="btn-save" type="button">Lưu</button>
                        </div>
                    
                        <div>
                            <button class="btn-like" type="button">Thích</button>
                            
                        </div>
                    </div>
                    
                </div>

            
            <!-- <div class="col-md-12">
                <div class="col-md-9">
                    <img class="meal-detail" src="https://goeco.link/ZRylO" alt="">
                    
                    <p>
                        Một chiếc bánh “thuần healthy”, gluten-free, dùng 100% bột yến mạch, nhưng vẫn cực mềm, ẩm, 
                        và thơm nức mùi chuối tươi đây ạ Bánh chuối thì không phải nói nhiều rồi,
                         nhưng phiên bản lần này còn “khuyến mãi” thêm mùi thơm mộc mạc của yến mạch, 
                         vị thanh nhẹ và kết cấu siêu ẩm xốp từ sữa chua, và đương nhiên là cực nhiều dưỡng chất nữa cơ.

                    Mỗi sáng chỉ cần 1 – 2 lát bánh này với cốc sữa hạt nữa là vừa đủ chất, vừa no lâu, 
                    vừa tốt cho tiêu hóa. Cách làm cực đơn giản ạ, chỉ cần trộn tất cả nguyên liệu với nhau, 
                    nướng bằng lò hay NCKD đều được cả
                    </p>
                    <h2>Cách Làm Sườn Xào Chua Ngọt</h2>

                    <h3>Nguyên Liệu</h3>
                    <h4>- 120 sữa chua</h4>
                    <h4>- 10 gram đường vàng
                    </h4>
                    <h4>- 120 sữa chua</h4>
                    <h4>- 30 gram dầu ăn</h4>
                    <h4>- ¼ thìa cafe bột quế (không bắt buộc – nếu có bánh sẽ có màu vàng đậm đẹp hơn)</h4>
                    <h3>Cách Làm</h3>
                    <h4>Bước 1: 2 muỗng dầu hào, 2 muỗng tương cà, 2 muỗng mắm, 2 muỗng đường, 3 muỗng chanh hoặc dấm, 
                        1 muỗng rưỡi tương ớt. Trộn đều sốt</h4>
                        <h4>Bước 2: Mang sườn đi trần nước sôi khoảng 5-7p, sau đó vớt sườn ra cho vào chảo đảo cho vàng nhớ là nhỏ lửa thôi,
                             sau đó cho phần sốt đã chuẩn bị vào rim trong 5 phút rồi tắt bếp cho ra đĩa</h4>




                </div>
                <div class="col-md-3">
                    <div >
                        <button class="btn-save" type="button">Lưu</button>
                    </div>
                    
                    <div >
                        <button class="btn-like" type="button">Thích</button>
                        
                    </div>
                    
                    
                </div>
               
                
            </div>  -->
        </div>
    </div>
    </main>

    <footer>
        <div class="footer">
            
            <ul class="social-icon">
                <li class="social-icon__item"><a class="social-icon__link" href="#">
                    <ion-icon name="logo-facebook"></ion-icon>
                  </a></li>
                <li class="social-icon__item"><a class="social-icon__link" href="#">
                    <ion-icon name="logo-twitter"></ion-icon>
                  </a></li>
                <li class="social-icon__item"><a class="social-icon__link" href="#">
                    <ion-icon name="logo-linkedin"></ion-icon>
                  </a></li>
                <li class="social-icon__item"><a class="social-icon__link" href="#">
                    <ion-icon name="logo-instagram"></ion-icon>
                  </a></li>
              </ul>
              <ul class="menu">
                <li class="menu__item"><a class="menu__link" href="#">Trang chủ</a></li>
                <li class="menu__item"><a class="menu__link" href="#">Danh Mục</a></li>
                <li class="menu__item"><a class="menu__link" href="#">Nấu Ăn</a></li>
                <li class="menu__item"><a class="menu__link" href="#">Tin Tức</a></li>
              </ul>
              <p class="text-center">&copy;All Rights Reserved</p>
              <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
                <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        </div>
    </footer>
        
        
   

</body>
</html>