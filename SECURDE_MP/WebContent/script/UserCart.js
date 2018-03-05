/**
 * 
 */
var productId;


function loadCart(){
	$.ajax({
 	    context: this,
        url: 'viewCart',
        type: 'GET',
        cache:false,
        success: function(data){
            if(data !== "NO-ITEMS-CART") {
                $('#emptyCart').hide();
                var tableRowHeader = document.getElementById("rowHeader");
                var tableHeader = document.getElementsByClassName("th");
            	var cartFeed = document.getElementById("itemCart");
            	if(cartFeed != null){
    	        	// Remove all children
    	        	while (cartFeed.firstChild) {	
    	        		cartFeed.removeChild(cartFeed.firstChild);
    	        	}
    	
    	        	// Append html snippet 
                    $(tableRowHeader).append(tableHeader);
                    $(cartFeed).append(tableRowHeader);
    	    	    $(cartFeed).append(data);
            	}
            } else if (data === "NO-ITEMS-CART") {
                $('#emptyCart').show();
            }
    	},
        error:function(){
            console.log("URL viewCart does not exist");
        }
    });
}


$(document).ready(function() {
	loadCart();
});
