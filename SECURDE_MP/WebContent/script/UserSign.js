/**
 * 
 */

function enterKeyEvent(event) {
    var char = event.which || event.keyCode;
    
    if (char == 13) {

    }
}

function duplicateHandler(data) {
	
	//front end handling constraint done here (create functions for them so we can reuse it on the 3rd case in the switch-case)
	if(data === "EMAIL-TAKEN") {
		$('#errorHand').show();
        $('#regEmail').css("border-color", "indianred"); 
	}
        
	if (data === "PASSWORD-MISMATCH") {
		$('#errorPassHand').show();
        $('#regPass').css("border-color", "indianred");
        $('#regRePass').css("border-color", "indianred");
	}
                                    
	if (data !== "EMAIL-TAKEN" && data === "PASSWORD-MISMATCH") {
		$('#errorHand').hide();
        $('#regEmail').css('border-color', '#E7E7E7'); 
	}
	
	if (data === "EMAIL-TAKEN" && data !== "PASSWORD-MISMATCH") {
		$('#errorPassHand').hide();
        $('#regPass').css('border-color', '#E7E7E7');
        $('#regRePass').css('border-color', '#E7E7E7');
	}
	
	if (data !== "EMAIL-TAKEN" && data !== "PASSWORD-MISMATCH") {
		document.location.href = 'sign.jsp';
	}
	
}

// https://stackoverflow.com/questions/46155/how-to-validate-email-address-in-javascript
function validatePassword(password) {
	var re = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
	return re.test(password);
}

//Account login failure front-end done here.
function accPassMismatch(data) {
	//Front end constraint warning here
	if(data === "FAIL-LOGIN") {
		$('#errorLogHand').show();
		$('#email').css("border-color", "indianred");
		$('#pword').css("border-color", "indianred");
	}
	
	else if(data === "NOT-EXIST") {
		$('#errorLoginHandler').show();
		$('#email').css("border-color", "indianred");
	}
	
	else if(data === "NOT-VERIFIED") {
		console.log("NOT YET VERIFIED!");
		$('#errorLoginHand').show();
		$('#email').css("border-color", "indianred");
	}
	
	//redirect to adminhomepage.
	else if(data === "PASS-LOGIN-ADMIN"){
		document.location.href = 'index.jsp';
	}
	
	//redirect to user homepage.
	else {
		document.location.href = 'index.jsp';
	}
}



$("document").ready(function() {

	//Submit form!
	$("#register").click(function() {
		var firstname = document.getElementById("firstname").value;
		var lastname = document.getElementById("lastname").value;
		var email = document.getElementById("regEmail").value;
		var password = document.getElementById("regPass").value;
		var repassword = document.getElementById("regRePass").value;
		
		submitTheRegisterForm();
	});
	
	$("#submit").click(function() {
		var loginEmail = document.getElementById("email").value;
		var loginPassword = document.getElementById("pword").value;
		
		submitTheLoginForm();
	});
	
	$("#regPass").focus(function() {
		$("#passNote").show();
	});
	
	$("#regPass").blur(function() {
		$("#passNote").hide();
	});
	
});

//This function handles submitting the data.
function submitTheRegisterForm() {
	
	$.ajax({
		   context: this,
	      url:'register',
	      data:$("form#signupForm").serialize(),
	      type:'POST',
	      cache:false,
	      success: function(data){
	    	 duplicateHandler(data);
	      },
	      error:function(){
	      	console.log("error searchResult.js");
	      }
	});
}

//This function handles submitting the data.
function submitTheLoginForm() {
	$.ajax({
	   context: this,
      url:'login',
      data:$("form#loginForm").serialize(),
      type:'POST',
      cache:false,
      success: function(data){
    	  
    	  accPassMismatch(data);
      	
      },
      error:function(){
      	console.log("error searchResult.js");
      }
   });
}