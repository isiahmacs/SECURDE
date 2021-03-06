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
		$('#errorNullHand').hide();
		$('#errorHand').show();
        $('#regEmail').css("border-color", "indianred"); 
	}
        
	if (data === "PASSWORD-MISMATCH") {
		$('#errorNullHand').hide();
		$('#errorPassHand').show();
        $('#regPass').css("border-color", "indianred");
        $('#regRePass').css("border-color", "indianred");
	}
                                    
	if (data !== "EMAIL-TAKEN" && data === "PASSWORD-MISMATCH") {
		$('#errorNullHand').hide();
		$('#errorHand').hide();
        $('#regEmail').css('border-color', '#E7E7E7'); 
	}
	
	if (data === "EMAIL-TAKEN" && data !== "PASSWORD-MISMATCH") {
		$('#errorNullHand').hide();
		$('#errorPassHand').hide();
        $('#regPass').css('border-color', '#E7E7E7');
        $('#regRePass').css('border-color', '#E7E7E7');
	}
	
	if (data === "NULL-FIELD") {
		$('#errorNullHand').show();
		$('#firstname').css('border-color', '#E7E7E7');
		$('#lastname').css('border-color', '#E7E7E7');
        $('#regEmail').css('border-color', '#E7E7E7');
		$('#regPass').css('border-color', '#E7E7E7');
        $('#regRePass').css('border-color', '#E7E7E7');
	}
	
	if (data === "PASSWORD-INVALID") {
		$('#errorPassInv').show();
		$('#regPass').css('border-color', '#E7E7E7');
	}
	
	else if (data !== "EMAIL-TAKEN" && data !== "PASSWORD-MISMATCH") {
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
		$('#errorLogHand').show();
		$('#email').css("border-color", "indianred");
		$('#pword').css("border-color", "indianred");
	}
	
	else if(data === "NOT-VERIFIED") {
		$('#errorLogHand').show();
		$('#email').css("border-color", "indianred");
		$('#pword').css("border-color", "indianred");
	}
	
	//redirect to adminhomepage.
	else if(data === "PASS-LOGIN-ADMIN"){
		document.location.href = 'admin.jsp';
	}
	
	//redirect to user homepage.
	else {
		document.location.href = 'user.jsp';
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
		$('#modal1').show();
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
	
	$("#proceedModal").click(function() {
	    // TODO update once verified mail
		//$("form#signUpForm").submit();
		$('#modal1').hide();
		submitTheRegisterForm();
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