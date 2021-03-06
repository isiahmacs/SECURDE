/**
 * 
 */
var productId;


function loadProduct(){
	$.ajax({
 	    context: this,
        url: 'viewProductForAdmin',
        type: 'GET',
        cache:false,
        success: function(data){
        	var link = document.getElementById("link");
        	var editProdBtn = document.getElementById("editProduct");
        	var productFeed = document.getElementById("productFormat");
        	if(productFeed != null){
	        	// Remove all children
	        	while (productFeed.firstChild) {	
	        		productFeed.removeChild(productFeed.firstChild);
	        	}
	
	        	// Append html snippet 
	        	$(link).append(editProdBtn);
	        	$(productFeed).append(link);
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
