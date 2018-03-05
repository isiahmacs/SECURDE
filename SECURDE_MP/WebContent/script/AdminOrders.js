/**
 * 
 */


function loadOrders(){
	$.ajax({
 	    context: this,
        url: 'viewOrders',
        type: 'GET',
        cache:false,
        success: function(data){
        	var orderFeed = document.getElementById("transFormat");
        	if(orderFeed != null){
	        	// Remove all children
	        	while (orderFeed.firstChild) {	
	        		orderFeed.removeChild(orderFeed.firstChild);
	        	}
	
	        	// Append html snippet 
	    	    $(orderFeed).append(data);
        	}
    	},
        error:function(){
            console.log("URL viewOrders does not exist");
        }
    });
}


$(document).ready(function() {
	loadOrders();
});
