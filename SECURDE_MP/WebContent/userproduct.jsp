<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PokeMerch</title>
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
                height: 40px;
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
			
			 #productFormat {
				width: 85%;
				height: auto;
				display: inline-block;
                position: relative;
                left: 120px;
				bottom: 20px;
			}
			
			#productContainer {
				position: relative;
				display: flex; 
				flex-wrap: nowrap; 
				align-items: flex-start;
			}
			
			img {
				width: 350px;
				height: 550px;
			}
			
			#productDescCont {
				position: relative;
				left: 50px;
				width: 700px;
				height: auto;
			}
			
			#productNameCont {
				position: relative;
				width: 100%;
				height: 75px;
				border-bottom: 1px solid #EAECEE;
			}
			
			#productName {
				position: relative;
				font-size: 20px;
				bottom: 20px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
                letter-spacing: 1px;
			}
			
			#price {
				position: relative;
				color: #353535;
				bottom: 20px;
				font-family: Montserrat, Sans-serif;
                font-size: 16px;
                font-weight: bold;
                text-transform: uppercase;
			}
			
			#addtoCart {
				position: relative;
				bottom: 20px;
				left: 50px;
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
			
			#addtoCart:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			
			#productDesc {
				position: relative;
				width: 100%;
				height: auto;
				top: 20px;
			}
			
			#description {
				position: relative;
				color: #353535;
				bottom: 20px;
				font-family: Montserrat, Sans-serif;
                font-size: 14px;
                font-weight: bold;
				text-align: justify;
				letter-spacing: 0.5px;
			}
			
			#collA:hover {
                text-decoration: underline;
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
            <a href = "index.jsp"><p id = "titleCaption">SHOP ALL PRODUCTS</p></a>
            <input type = "text" placeholder = "Search our store" id = "search" name = "searchBar" />
            <a href = "cart.jsp"><p id = "myCart">My Cart (1)</p></a>
            <a href = "sign.jsp"><p id = "join">Join</p></a>
            <a href = "sign.jsp"><p id = "sign-in">Sign In</p></a>
			<a href = "sign.jsp"><p id = "sign-out">Sign Out</p></a>
			<a href = "sign.jsp"><p id = "account">Account</p></a>
		</div>
		<div id = "nav">
            <p id = "subCaption"><a href = "index.jsp" id = "homeA">Home</a> <span class="separator">»</span> <a href = "index.jsp" id = "collA">Collections</a> <span class="separator">Â»</span> Product</p>
        </div>
		<article id = "productFormat">
            <div id = "productContainer">
                <img src = "images/Shopify-Uncaged03-patch01.jpg"></img>
				<div id = "productDescCont">
					<div id = "productNameCont">
						<p id = "productName">Uncaged 03 Embroidered Patch</p>
						<span id = "price">$10.00</span>
						<button id = "addtoCart">Add to Cart</button> <br>
					</div>
					<div id = "productDesc">
						<p id = "description">
							Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the 
							industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and 
							scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap 
							into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the 
							release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software 
							like Aldus PageMaker including versions of Lorem Ipsum.
							<br><br>
							It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. 
							The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 
							'Content here, content here', making it look like readable English. Many desktop publishing packages and web page 
							editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites 
							still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
						</p>
					</div>
				</div>
            </div>
        </article>
	</div>
	</body>
	
</html>