/**
 * 
 */
var productId;


function loadProduct(){
	$.ajax({
 	    context: this,
        url: 'viewProduct',
        type: 'GET',
        cache:false,
        success: function(data){
            var buttonProduct = document.getElementById("addtoCartBut");
        	var productFeed = document.getElementById("productFormat");
        	if(productFeed != null){
	        	// Remove all children
	        	while (productFeed.firstChild) {	
	        		productFeed.removeChild(productFeed.firstChild);
	        	}
	
	        	// Append html snippet 
                $(buttonProduct).append(buttonProduct);
	    	    $(productFeed).append(data);
        	}
    	},
        error:function(){
            console.log("URL viewProduct does not exist");
        }
    });
}


$(document).ready(function() {
	loadProduct();
});
