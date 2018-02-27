<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Your Shopping Cart - PokeMerch</title>
		<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="script/UserCart.js"></script>
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
                top: 100px;
				margin: 0 auto;
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
            
            #header {
                position: relative;
                width: 85%;
                height: 35px;
                left: 100px;
                border-bottom: 2px solid #3C5AA6;
            }
			
			#nav {
                position: relative;
                width: 85%;
                height: 5%;
                left: 100px;
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
            
            #cartFormat {
				float: left;
				width: 85%;
				height: auto;
				display: inline-block;
                position: relative;
                left: 100px;
                top: 30px;
			}
			
			#cartContainer {
				position: relative;
			}
			
			#cart {
				position: relative;
                bottom: 60px;
				font-size: 20px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
                letter-spacing: 1px;
                line-height: 40px;
			}
            
            #itemCart {
                position: relative;
                bottom: 60px;
				width: 100%;
            }
            
            #emptyCart {
                position: relative;
				font-size: 13px;
                bottom: 60px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
                letter-spacing: 1px;
                line-height: 10px;
            }
			
			th {
				padding: 15px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
                line-height: 10px;
				font-size: 13px;
				border-top: 1px solid #ABB2B9;
				border-bottom: 1px solid #ABB2B9;
				border-left: 1px solid #ABB2B9;
				background-color: #EAECEE;
				position: relative;
			}
			
			td {
				padding: 15px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
                line-height: 10px;
				font-size: 13px;
				border-bottom: 1px solid #ABB2B9;
				border-left: 1px solid #ABB2B9;
				position: relative;
				letter-spacing: 1px;
			}
			
			.priceTag {
				border-right: 1px solid #ABB2B9;
			}
			
			img {
				padding-right: 10px;
				width: 77px;
				height: 100px;
			}
			
			.quantity {
                display: inline;
				position: relative;
				height: 30px;
				width: 50px;
				font-size: 13px;
                text-align: center;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #FDFEFE;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
                transition: all .15s ease-in-out;
			}
            
            .quantity:focus {
                transition: all .15s ease-in-out;
                box-shadow: 0px 0px 1px 1px #3C5AA6;
            }
			
			.removeItem {
				border: none;
				background-color: transparent;
				color: #353535;
				font-family: Montserrat;
			}
			
			.removeItem:hover {
                text-decoration: underline;
				cursor: pointer;
            }
			
			#subtotal {
				position: relative;
                float: right;
                display: inline;
                bottom: 50px;
                text-align: right;
				color: #353535;
				font-family: Montserrat, Sans-serif;
                font-size: 16px;
                font-weight: bold;
                height: 40px;
                text-transform: uppercase;
                letter-spacing: 1px;
                line-height: 40px;
                transition: all .15s ease-in-out;
			}
			
			#update {
				position: relative;
				margin-bottom: 10px;
				left: 995px;
				width: 150px;
				height: 35px;
				background-color: #353535;
                border-radius: 2px;
				color: #F8F7F7;
				border: none;
				font-family: Montserrat, Sans-serif;
				transition: all .15s ease-in-out;
				font-size: 13px;
				font-weight: bold;
			}
			
			#update:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			
			#checkout {
				position: relative;
				left: 995px;
				bottom: 15px;
				width: 150px;
				height: 35px;
				margin-bottom: 50px;
				background-color: #353535;
                border-radius: 2px;
				color: #F8F7F7;
				border: none;
				font-family: Montserrat, Sans-serif;
				transition: all .15s ease-in-out;
				font-size: 13px;
				font-weight: bold;
			}
			
			#checkout:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			
			#funImage {
				position: fixed;
				width: 150px;
				height: 150px;
				left: 0px;
				top: 0px;
			}
            
		</style>
	</head>
	<body> 
	<img src = "images/a4068434880_5(flipped).png" id = "funImage"></img>
	<div id = "container">
        <div id = "header">
            <a href = "index.jsp"><p id = "titleCaption">SHOP ALL PRODUCTS</p></a>
            <input type = "text" placeholder = "Search our store" id = "search" name = "searchBar" />
            <a href = "#"><p id = "myCart">My Cart (1)</p></a>
            <a href = "sign.jsp"><p id = "join">Join</p></a>
            <a href = "sign.jsp"><p id = "sign-in">Sign In</p></a>
			<a href = "sign.jsp"><p id = "sign-out">Sign Out</p></a>
			<a href = "sign.jsp"><p id = "account">Account</p></a>
		</div>
		<div id = "nav">
            <p id = "subCaption"><a href = "index.jsp" id = "homeA">Home</a> <span class="separator">�</span> Your Shopping Cart</p>
        </div>
        <article id = "cartFormat">
            <div id = "cartContainer">
                <p id = "cart">My Cart</p>
                <p id = "emptyCart">Your cart is currently empty.</p>
				<form method = "checkOut" action = "POST">
					<form method = "updateCart" action = "POST">
		                <table id = "itemCart" cellspacing = "0" cellpadding = "0">
							<tr>
								<th width = 1400>Product</th>
								<th width = 150>Item Price</th>
								<th width = 100>Quantity</th>
								<th width = 100>Remove</th>
								<th width = 100 class = "priceTag">Price</th>
							</tr>
							
						<input type = "submit" id = "update" value = "Update Cart" /> <br>
					</form>
					<button id = "checkout">Check Out</button>
				</form>
					
				
            </div>
        </article>
	</div>
	</body>
	
</html>