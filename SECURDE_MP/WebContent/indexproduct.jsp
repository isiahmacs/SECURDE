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
			
			.productContainer {
				position: relative;
				display: flex; 
				flex-wrap: nowrap; 
				align-items: flex-start;
			}
			
			img {
				width: 350px;
				height: 550px;
			}
			
			.productDescCont {
				position: relative;
				left: 50px;
				width: 700px;
				height: auto;
			}
			
			.productNameCont {
				position: relative;
				width: 100%;
				height: 70px;
				border-bottom: 1px solid #EAECEE;
			}
			
			.productName {
				position: relative;
				font-size: 20px;
				bottom: 20px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
                letter-spacing: 1px;
			}
			
			.price {
				position: relative;
				color: #353535;
				bottom: 15px;
				font-family: Montserrat, Sans-serif;
                font-size: 16px;
                font-weight: bold;
                text-transform: uppercase;
			}
			
			#addtoCartBut {
				position: relative;
				left: 500px;
				top: 80px;
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
				z-index: 100;
			}
			
			#addtoCartBut:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			.productDesc {
				position: relative;
				width: 100%;
				height: auto;
				top: 20px;
			}
			
			.description {
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
            <a href = "user.jsp"><p id = "titleCaption">SHOP ALL PRODUCTS</p></a>
            <input type = "text" placeholder = "Search our store" id = "search" name = "searchBar" />
            <p id = "myCart"><a href = "indexcart.jsp">My Cart</a></p>
			<p id = "join"><a href = "sign.jsp">Join</a></p>
           	<p id = "sign-in"><a href = "sign.jsp">Sign In</a></p>
		</div>
		<div id = "nav">
            <p id = "subCaption"><a href = "index.jsp" id = "homeA">Home</a> <span class="separator">»</span> <a href = "index.jsp" id = "collA">Collections</a> <span class="separator">»</span> Product</p>
        </div>
		<article id = "productFormat">
            <button id = "addtoCartBut">Add to Cart</button>
        </article>
	</div>
	</body>
	<script type="text/javascript">

		function createCart() {
		    $.ajax({
		            context: this,
		            url: 'addtoCart',
		            type: 'POST',
		            cache:false,
		            success: function(data){
		                window.location.href = "indexcart.jsp";
		            },
		            error:function(){
		                console.log("URL addtoCart does not exist");
		            }
		        });
		}

		$(document).ready(function() {
			$("#addtoCartBut").click(function() {
	        	createCart();
	    	});
		});
	</script>
</html>