
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        var files = input.files;

        reader.onload = function (e) {
            $('#image').attr('src', e.target.result);
            $('label[for=prodImage]').empty();
	        for (var i = 0, l = files.length; i < l; i++) {
	            $('label[for=prodImage]').append(files[i].name + '\n');
	        }
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$(document).ready(function() {

	$("#prodImage").change(function(){
	    readURL(this);
	});

	

});