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
                $('#note').show();
                $('#address').show();
                $('#checkout').show();
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
    	    	    $(cartFeed).show();
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

function loadPrice(){
	$.ajax({
 	    context: this,
        url: 'viewPrice',
        type: 'GET',
        cache:false,
        success: function(data){
        	if(data !== "NO-ITEMS-CART") {
        		$(cartPrice).show();
            	var cartPrice = document.getElementById("totalOrderPrice");
            	if(cartPrice != null){
    	        	// Remove all children
    	        	while (cartPrice.firstChild) {	
    	        		cartPrice.removeChild(cartPrice.firstChild);
    	        	}
    	
    	        	// Append html snippet 
    	    	    $(cartPrice).append("Total Price: $" + data);
            	}
            	$(cartPrice).show();
        	} else if (data === "NO-ITEMS-CART") {
                $(cartPrice).hide();
            }
    	},
        error:function(){
            console.log("URL viewPrice does not exist");
        }
    });
}


$(document).ready(function() {
	loadCart();
	loadPrice();
});
