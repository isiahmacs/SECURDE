<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PokeMerch</title>
		<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="script/UserProducts.js"></script>
		<link rel = "shortcut icon" href = "http://cliparts.co/cliparts/rij/rpj/rijrpj4rT.png" />
		<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			::-webkit-scrollbar-track {
				-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
				border: 10px;
				background-color: #F5F5F5;
			}

			::-webkit-scrollbar {
				width: 5px;
				background-color: #F5F5F5;
			}

			::-webkit-scrollbar-thumb {
				border: 10px;
				-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
				background-color: #555;
			}

			@font-face {
			    font-family: Montserrat;
			    src: url("Montserrat/Montserrat-Regular.ttf");
			}
			
			body {
				overflow-x: hidden;
				/*background: url('images/minimalism_background_macro_chip_board_circuit_74408_1920x1080.jpg');
				background-size: cover;
				background-repeat: no-repeat;*/
                background-color: #FBFCFC;
			}
			
			a {
				text-decoration: none;
                color: #353535;
			}
            
            .separator {
                padding: 5px;
            }
			
			#container {
				overflow: hidden;
                width: 1350px;
                position: relative;
                margin: 0 auto;
                top: 100px;
			}
			
			#registerFormat {
				float: left;
				width: 65%;
				height: 100%;
				display: inline-block;
			}
			
			#registerContainer {
				position: relative;
				top: 100px;
			}
			
			#titleCaption {
				position: relative;
                width: 175px;
				color: #353535;
                float: left;
                bottom: 15px;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
                text-align: left;
                height: 40px;
                display: block;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
			}
            
            #titleCaption:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
            
            #header {
                position: relative;
                width: 85%;
                height: 35px;
                left: 100px;
                border-bottom: 2px solid #3C5AA6;
            }
            
            #search {
                display: inline;
				position: relative;
				height: 30px;
				width: 35%;
                margin: 0 auto;
				left: 200px;
				top: 2px;
				font-size: 13px;
                text-align: center;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #F7F7F7;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
				font-weight: bold;
                transition: all .15s ease-in-out;
				letter-spacing: 1px;
			}
            
            #search:focus {
                transition: all .15s ease-in-out;
                box-shadow: 0px 0px 1px 1px #3C5AA6;
            }
			
			#search::-webkit-input-placeholder {
				color: #353535;
				opacity: 0.75;
				letter-spacing: 0px;
			}
			
			#account {
				position: relative;
                float: right;
                display: inline;
                bottom: 14px;
                right: 40px;
                text-align: right;
				color: #353535;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
                height: 40px;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
				display: none;
			}
            
            #account:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
			
			#sign-out {
				position: relative;
                float: right;
                display: inline;
                bottom: 14px;
                right: 20px;
                text-align: right;
				color: #353535;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
                height: 40px;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
				display: none;
			}
            
            #sign-out:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
            
            #sign-in {
				position: relative;
                float: right;
                display: inline;
                bottom: 14px;
                right: 40px;
                text-align: right;
				color: #353535;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
                height: 40px;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
			}
            
            #sign-in:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
            
            #join {
				position: relative;
                float: right;
                display: inline;
                bottom: 14px;
                right: 20px;
                text-align: right;
				color: #353535;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
                height: 40px;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
			}
            
            #join:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
            
            #myCart {
				position: relative;
                float: right;
                display: inline;
                bottom: 14px;
                text-align: right;
				color: #353535;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
                height: 40px;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
			}
            
            #myCart:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
			
			#nav {
                position: relative;
                width: 85%;
                height: 5%;
                left: 100px;
            }
			
			#subCaption {
				position: relative;
                float: left;
                width: 130%;
                padding-top: 20px;
                bottom: 40px;
				font-size: 12px;
                letter-spacing: 0.5px;
                font-weight: bold;
				color: #353535;
				font-family: Montserrat, Sans-serif; 
            }
			
			#homeA:hover {
                text-decoration: underline;
            }
			
			#productFormat {
				width: 86%;
				float: left;
                position: relative;
                left: 115px;
			}
			
			.productContainer {
				position: relative;
				width: 350px;
				height: 700px;
				margin-right: 30px;
				display: inline-block;
			}
			
			.img {
				width: 350px;
				height: 550px;
				margin-right: 25px;
				margin-bottom: 5px;
				position: relative;
			}
			
			.productDesc {
				position: absolute;
				width: 350px;
				height: 550px;
				margin: 0 auto;
				background-color: rgba(35, 35, 35, 0.75);
				top: 0px;
				text-align: center;
				visibility: hidden;
			}
			
			.productContainer:hover .productDesc {
				visibility: visible;
				background-color: rgba(35, 35, 35, 0.75);
			}
			
			.productContainer:hover .productName {
				visibility: visible;
			 	opacity: 1;
			}
			
			.productContainer:hover .price {
				visibility: visible;
			 	opacity: 1;
			}
			
			.productName {
				position: relative;
				font-size: 20px;
				color: #fff;
				font-family: Montserrat, Sans-serif;
                letter-spacing: 1px;
				text-align: center;
				top: 225px;
			}
			
			.price {
				position: relative;
				color: #fff;
				font-family: Montserrat, Sans-serif;
                font-size: 16px;
                font-weight: bold;
                text-transform: uppercase;
				text-align: center;
				letter-spacing: 1px;
				top:225px;
			}
			
			#funImage {
				position: fixed;
				width: 150px;
				height: 150px;
				left: 0px;
				top: 0px;
			}
            
			#funImage2 {
				position: fixed;
				width: 150px;
				height: 150px;
				right: 0px;
				top: 0px;
			}
			
		</style>
	</head>
	<body>
	<img src = "images/a4068434880_5(flipped).png" id = "funImage"></img>
	<img src = "images/a4068434880_5.png" id = "funImage2"></img>
	<div id = "container">
        <div id = "header">
            <a href = "#"><p id = "titleCaption">SHOP ALL PRODUCTS</p></a>
            <input type = "text" placeholder = "Search our store" id = "search" name = "searchBar" />
            <a href = "cart.jsp"><p id = "myCart">My Cart (1)</p></a>
            <a href = "sign.jsp"><p id = "join">Join</p></a>
            <a href = "sign.jsp"><p id = "sign-in">Sign In</p></a>
			<a href = "sign.jsp"><p id = "sign-out">Sign Out</p></a>
			<a href = "sign.jsp"><p id = "account">Account</p></a>
		</div>
		<div id = "nav">
            <p id = "subCaption"><a href = "#" id = "homeA">Home</a> <span class="separator">�</span> Collections</p>
        </div>
		<article id = "productFormat">
			<div class = "productContainer">
				<a href = "product.jsp"  >
					<img class = "img" src="images/product1.png"></img>	
					<div class = "productDesc">			
						<p class = "productName"> MagikAmph</p>
						<p class = "price"> $0.50</p>
					</div>
				</a>
				
				
			</div>
			<div class = "productContainer">
				<a href = "product.jsp"  >
					<img class = "img" src="images/product2.jpg"></img>	
					<div class = "productDesc">			
						<p class = "productName"> Pik Haching </p>
						<p class = "price"> $88.66</p>
					</div>
				</a>
				
				
			</div>
			<div class = "productContainer">
				<a href = "product.jsp"  >
					<img class = "img" src="images/product3.jpg"></img>
					<div class = "productDesc">				
						<p class = "productName"> Nami-san and Some Dragon Action Figure </p>
						<p class = "price"> $69.69</p>
					</div>
				</a>
				
				
			</div>
        </article>
	</div>
	</body>
	
</html>