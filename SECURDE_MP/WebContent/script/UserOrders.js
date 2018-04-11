/**
 * 
 */


function loadOrders(){
	$.ajax({
 	    context: this,
        url: 'viewTransactions',
        type: 'GET',
        cache:false,
        success: function(data){
        	var tableRowHeader = document.getElementById("rowHeader");
            var tableHeader = document.getElementsByClassName("th");
        	var orderFeed = document.getElementById("itemCart");
        	if(orderFeed != null){
	        	// Remove all children
	        	while (orderFeed.firstChild) {	
	        		orderFeed.removeChild(orderFeed.firstChild);
	        	}
	
	        	// Append html snippet 
	        	$(tableRowHeader).append(tableHeader);
                $(orderFeed).append(tableRowHeader);
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
