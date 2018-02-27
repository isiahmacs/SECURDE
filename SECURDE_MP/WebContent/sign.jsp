<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create Account - PokeMerch</title>
		<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="script/UserSign.js"></script>
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
				background: url('images/MV0Dahl(flipped).gif'), url('images/MV0DahI.gif');
				background-size: 15% 40%, 15% 40%;
                background-position: 45% 70%, 55% 70%;
                background-repeat: no-repeat;
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
				width: 25%;
				height: auto;
				display: inline-block;
                top: 40px;
                left: 100px;
                position: relative;
			}
			
			#registerContainer {
				position: relative;
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
			
			#registerSettings {
				position: relative;
				width: 100%;
				height: auto;
				bottom: 70px;
			}
			
			#signup {
				position: relative;
				margin-top: 20px;
				top: 20px;
				font-size: 25px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
			}
			
			#firstname {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 90%;
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
            
            #firstname:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
			
			#lastname {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 90%;
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
			
            #lastname:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
            
			#regEmail {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 90%;
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
            
            #regEmail:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
			
			#regPass {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 90%;
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
            
            #regPass:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
			
			#regRePass {
				position: relative;
				margin-top: 20px;
				height: 40px;
				width: 90%;
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
            
            #regRePass:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
			
			#register {
				position: relative;
				left: 75px;
				margin-top: 30px;
				margin-bottom: 20px;
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
			
			#register:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			
			#loginFormat {
				float: right;
				width: 35%;
				height: auto;
				display: inline-block;
                position: relative;
                right: 110px;
			}
			
			#loginContainer {
				position: relative;
                left: 65px;
                top: 20px;
			}
			
			#haveAccount {
				position: relative;
				left: 80px;
				font-size: 27px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
			}
			
			#email {
				position: relative;
				left: 80px;
				height: 40px;
				width: 70%;
				font-size: 13px;
                padding-left: 10px;
				border: 1px solid #E7E7E7;
                border-radius: 2px;
				background-color: #F7F7F7;
				color: #353535;
				font-family: Montserrat, Sans-serif;
				outline: none;
				font-weight: bold;
                transition: all .15s ease-in-out;
				letter-spacing: 1px;
				transition: all .15s ease-in-out;
			}
            
            #email:focus {
                transition: all .15s ease-in-out;
                box-shadow: 0px 0px 1px 1px #3C5AA6;
            }
			
			#pword {
				position: relative;
				left: 80px;
				top: 15px;
				height: 40px;
				width: 70%;
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
            
            #pword:focus {
                box-shadow: 0px 0px 1px 1px #3C5AA6;
                transition: all .15s ease-in-out;
            }
			
			.registration::-webkit-input-placeholder {
				color: #353535;
				opacity: 0.75;
				letter-spacing: 0px;
			}
			
			.logination::-webkit-input-placeholder {
				color: #353535;
				opacity: 0.75;
				letter-spacing: 0px;
			}
			
			#submit {
				position: relative;
				left: 80px;
				top: 40px;
				width: 90px;
				height: 35px;
				background-color: #353535;
                border-radius: 2px;
				color: #F8F7F7;
				border: none;
				font-family: Montserrat, Sans-serif;
				font-weight: bold;
				font-size: 13px;
				transition: all .15s ease-in-out;
			}
			
			#submit:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}
			
			#forgot {
				position: relative;
				left: 100px;
				top: 40px;
				font-size: 12px;
				color: #353535;
				font-family: Montserrat, Sans-serif;
			}
            
            #forgot:hover {
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
                top: 2px;
				left: 200px;
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
            
			#passNote {
				position: relative;
				font-family: Montserrat, Sans-serif;
				font-size: 9px;
				line-height: 15px;
				top: 10px;
				font-style: italic;
				display: none;
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
			
			#errorHand {
				position: relative;
				font-family: Montserrat, Sans-serif;
				font-size: 12px;
				line-height: 15px;
				top: 10px;
				font-style: italic;
				color: indianred;
				display: none;
			}
			
			#errorPassHand {
				position: relative;
				font-family: Montserrat, Sans-serif;
				font-size: 12px;
				line-height: 15px;
				top: 10px;
				font-style: italic;
				color: indianred;
				display: none;
			}
			
			#errorLogHand {
				position: relative;
				font-family: Montserrat, Sans-serif;
				font-size: 12px;
				left: 80px;
				line-height: 15px;
				bottom: 10px;
				font-style: italic;
				color: indianred;
				display: none;
			}
			
			#errorLoginHand {
				position: relative;
				font-family: Montserrat, Sans-serif;
				font-size: 12px;
				left: 80px;
				line-height: 15px;
				bottom: 10px;
				font-style: italic;
				color: indianred;
				display: none;
			}
			
			#errorLoginHandler {
				position: relative;
				font-family: Montserrat, Sans-serif;
				font-size: 12px;
				left: 80px;
				line-height: 15px;
				bottom: 10px;
				font-style: italic;
				color: indianred;
				display: none;
			}

			#modal1 {
			    width: 50%;
				position: absolute;
				top: 0;
				left: 0;
				right: 0;
				bottom: 0;
			    margin: 0 auto;
			    position: relative;
			    background-color: #fff;
			    border: 1px solid #E7E7E7;
			    z-index: 1000;
				height: 135px;
				
			}
			
			#modver {
			    width: 90%;
			    font-size: 14px;
			    font-weight: 400;
			    font-family: Montserrat, Sans-serif;
			    padding: 10px;
			    position: relative;
				border-bottom: 1px solid #E7E7E7;
				left: 30px;
			}
			
			#proceedModal {
				font-size: 14px;
			    font-weight: 400;
			    font-family: Montserrat, Sans-serif;
			    padding: 10px;
			    position: relative;
			    float: right;
				top: 5px;
			    bottom: 10px;
				right: 10px;
			    background-color: #353535;
                border-radius: 2px;
				color: #F8F7F7;
				border: none;
				font-family: Montserrat, Sans-serif;
				transition: all .15s ease-in-out;
			}
			
			#proceedModal:hover {
				background-color: #454545;
				cursor: pointer;
				transition: all .15s ease-in-out;
			}

		</style>
	</head>
	<body>
	<img src = "images/a4068434880_5(flipped).png" id = "funImage"></img>
	<img src = "images/a4068434880_5.png" id = "funImage2"></img>
	<div id="modal1" class="modal modal-fixed-footer">
    	<div class="modal-content">
        	<p id="modver">A verification link has been sent to the email address you used to create your account. Please click on the link to verify your account and proceed with the registration.</p>
        	<div class="modal-footer">
        		<button class="modal-action modal-close waves-effect waves-green btn-flat " id = "proceedModal">Proceed</button>
        	</div>
		</div>
    </div>
	<div id = "container">
        <div id = "header">
            <a href = "index.jsp"><p id = "titleCaption">SHOP ALL PRODUCTS</p></a>
            <input type = "text" placeholder = "Search our store" id = "search" name = "searchBar" />
            <a href = "cart.jsp"><p id = "myCart">My Cart</p></a>
		</div>
		<div id = "nav">
            <p id = "subCaption"><a href = "index.jsp" id = "homeA">Home</a> <span class="separator">»</span> Account</p>
        </div>
		<section id = "registerFormat">
			<div id = "registerContainer">		
				<div id = "registerSettings">
					<p id = "signup">Sign Up NOW!</p>
					<form action = "register" method = "POST" id = "signupForm">
						<input type = "text" placeholder = "First name" id = "firstname" name = "firstname" class = "registration" required /> <br>
						<input type = "text" placeholder = "Last name" id = "lastname" name = "lastname" class = "registration" required /> <br>
						<input type = "email" placeholder = "Enter email" id = "regEmail" name = "regEmail" class = "registration" required /> <br>
						<span id = "errorHand">*Email already exists.*</span>
						<input type = "password" placeholder = "Enter password" id = "regPass" name = "regPass" class = "registration" required /> <br>
						<span id = "passNote">Note: Your password must be at least 8 characters. It must contain at least 1 uppercase and lowercase letter, numbers, and symbols.</span>
						<input type = "password" placeholder = "Re-enter password" id = "regRePass" name = "regRePass" class = "registration" /> <br>
						<span id = "errorPassHand">*Passwords do not match.*</span> <br>
					</form>
					<button id = "register">Register</button>
				</div>
			</div>
		</section>
		
		<section id = "loginFormat">
			<div id = "loginContainer">
				<p id = "haveAccount">Have an account?</p>
				<span id = "errorLogHand">*Wrong username / password.*</span> 
				<span id = "errorLoginHand">*Email has not been verified.*</span> 
				<span id = "errorLoginHandler">*Email does not exist.*</span> 
				<form action = "login" method = "POST" id = "loginForm">
					<input type = "email" placeholder = "Email" id = "email" class = "logination" name = "logUser" required /> <br>
					<input type = "password" placeholder = "Password" id = "pword" class = "logination" name = "logPass" required /> <br>
				</form>
				<button id = "submit">Submit</button>
				<a href = "#"><span id = "forgot">Forgot password?</span></a>
			</div>
		</section>
	</div>
	</body>
	
</html>