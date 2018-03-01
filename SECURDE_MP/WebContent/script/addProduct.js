
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        var files = input.files;

        reader.onload = function (e) {
            $('#image').attr('src', e.target.result);
            $('label[for=prodimage]').empty();
	        for (var i = 0, l = files.length; i < l; i++) {
	            $('label[for=prodimage]').append(files[i].name + '\n');
	        }
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$(document).ready(function() {

	$("#prodimage").change(function(){
	    readURL(this);
	});

	$("#addProdBtn").click(function() {
		submitProductForm();
	});

});

//This function handles submitting the data.
function submitProductForm() {
	$.ajax({
		context: this,
      	url:'addProduct',
	    data:$("form#addProdForm").serialize(),
	    type:'POST',
	    cache:false,
	    success: function(data){
	    	  window.location.href = "admin.jsp";
	    },
	    error:function(){
	    	console.log("error searchResult.js");
	   	}
   });
}