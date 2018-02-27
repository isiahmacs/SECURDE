/**
 * 
 */
var productId;


function loadProduct(){
	$.ajax({
 	    context: this,
        data: {'productId' : producid},
        type: 'GET',
        cache:false,
        success: function(data){
        	var productFeed = document.getElementById("productFormat");
        	if(productFeed != null){
	        	// Remove all children
	        	while (productFeed.firstChild) {	
	        		productFeed.removeChild(productFeed.firstChild);
	        	}
	
	        	// Append html snippet 
	    	    $(productFeed).append(data);
        	}
    	},
        error:function(){
            console.log("URL getPosts does not exist");
        }
    });
}


$(document).ready(function() {
	loadProduct();
});
