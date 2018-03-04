<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PokeMerch</title>
		<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="script/addProduct.js"></script>
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
                height: 40px;
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
			
			#addProd {
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
            
            #addProd:hover {
                color: #BBBBBB;
                text-decoration: none;
                transition: all .15s ease-in-out;
            }
			
			#sign-out {
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
            
            #sign-out:hover {
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
			
			#addProductFormat {
				width: 86%;
				height: auto;
				float: left;
                position: relative;
                left: 115px;
			}
			
			#addProductContainer {
				position: relative;
				display: flex; 
				flex-wrap: nowrap; 
				align-items: flex-start;
			}
			
			.img {
				width: 350px;
				height: 550px;
				margin-right: 25px;
				margin-bottom: 20px;
				position: relative;
			}

			#productDescCont {
				position: relative;
				left: 50px;
				width: 700px;
				height: auto;
			}
			
			#prodname {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 50%;
				font-size: 13px;
                padding-left: 10px;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #F7F7F7;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
				font-weight: bold;
				letter-spacing: 1px;
				transition: all .15s ease-in-out;
			}
            
            #prodname:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
			
			#proddesc {
				position: relative;
				margin-top: 20px;
				height: 70px;
				width: 90%;
				font-size: 13px;
				padding-top: 10px;
                padding-left: 10px;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #F7F7F7;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
				font-weight: bold;
				letter-spacing: 1px;
				transition: all .15s ease-in-out;
				resize: none;
			}
			
            #proddesc:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
            
			#prodprice {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 10%;
				font-size: 13px;
                padding-left: 10px;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #F7F7F7;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
				font-weight: bold;
				letter-spacing: 1px;
				transition: all .15s ease-in-out;
			}
            
            #prodprice:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }

            #prodquantity {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 11%;
				font-size: 13px;
                padding-left: 10px;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #F7F7F7;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
				font-weight: bold;
				letter-spacing: 1px;
				transition: all .15s ease-in-out;
			}
            
            #prodquantity:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }

            input[type="file"] {
			    display: none;
			}
			
			.custom-file-upload {
				position: relative;
				text-align: center;
				padding: 10px;
				background-color: #F7F7F7;
                border-radius: 2px;
				color: #353535;
				border: 1px solid #E7E7E7;
				font-family: Montserrat, Sans-serif;
				transition: all .15s ease-in-out;
				font-size: 13px;
				font-weight: bold;
			}
            
            .custom-file-upload:hover {
               	box-shadow: 0px 0px 1px 1px #3C5AA6;
               	cursor: pointer;
				transition: all .15s ease-in-out;
            }
			
			#addProdBtn {
				position: relative;
				margin-top: 30px;
				margin-bottom: 20px;
				text-align: center;
				width: 150px;
				height: 45px;
				background-color: #353535;
                border-radius: 2px;
				color: #F8F7F7;
				border: none;
				font-family: Montserrat, Sans-serif;
				transition: all .15s ease-in-out;
				font-size: 13px;
				font-weight: bold;
				float: left;
				left: 0px;
			}

			#addProdBtn:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			
			.upload::-webkit-input-placeholder {
				color: #353535;
				opacity: 0.75;
				letter-spacing: 0px;
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
            <a href = "admin.jsp"><p id = "titleCaption">VIEW ALL PRODUCTS</p></a>
            <input type = "text" placeholder = "Search our store" id = "search" name = "searchBar" />
			<a href = "logout"><p id = "sign-out">Sign Out</p></a>
		</div>
		<div id = "nav">
            <p id = "subCaption"><a href = "admin.jsp" id = "homeA">Home</a> <span class="separator">»</span> Add Product</p>
        </div>
		<article id = "addProductFormat">
			<div id = 'addProductContainer'>
	            <img src = "images/question-marks-background-200px-Question_mark.png" class = "img" id = "image"></img>
	            <div id = 'productDescCont'>
	            	<form action = "addProduct" method = "POST" id = "addProdForm">
							<input type = "text" placeholder = "Product Name" id = "prodname" name = "prodName" class = "upload" required /> <br>
							<input type = "number" placeholder = "Price" id = "prodprice" name = "prodPrice" class = "upload" min = "0.01" step = "0.01" required /> <br>
							<input type = "number" placeholder = "Quantity" id = "prodquantity" name = "prodQuantity" class = "upload" min = "1" required /> <br>
							<textarea placeholder = "Product Description" id = "proddesc" name = "prodDesc" class = "upload" required></textarea> <br><br>
							<label for = "prodImage" class="custom-file-upload" id = "label">
							    Add Image
							</label>
							<input type = "file" id = "prodImage" name = "prodImage" class = "upload" accept=".png, .jpg, .jpeg" required /> <br><br>
						<input type = "submit" id = "addProdBtn" value = "Add Product" />
					</form>
	            </div>
	        </div>
        </article>
	</div>
	</body>
	
</html>