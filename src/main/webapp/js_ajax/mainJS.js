$(document).ready(function(){
//  $('#signOutDisplay').hide();

var $mainCustomerId=1;
 function get_mainCustomer(){
	 
	  $.get({url: "http://localhost:8080/boideployment/rest/customer/json/"+$mainCustomerId, success: function(result){
	           console.log(result);
	       }});
	  }


 
 
 function get_mainCustomerAccTransacitons(account_id)
 {
	 
	  $.get({url: "http://localhost:8080/boideployment/rest/account/json/"+$mainCustomerId, success: function(result)
		  {
		  //result is the overall returned object
	           console.log(result); 
	           console.log(result[0].transRefs[0]);
	           
	           //get each transaction
	           $.each(result[account_id].transRefs,function(key,value){
	         var $row ='<div class = "row dataHeader2">'+
            '<span class = "col-sm-2"> '+value.date+'  </span>'+
            '<span class = "col-sm-4">'+value.transName+'</span>'+
            '<span class = "col-sm-2"> '+value.amount+' </span>'+
            '<button type="button" class="btn btn-info btn-default col-sm-2" data-toggle="modal" data-target="#TransactionOne " data-reciept="'+value.receipts.length+'">Receipt </button>' +
            '</div>';
	         $('#datatable').append($row);
	        	   });
	       }
	  });
}
 

 

 function get_receipt(transactionID){
	 
	  $.get({url: "http://localhost:8080/boideployment/rest/receipt/json/"+transactionID, success: function(result){
	          // full receipt
	           console.log("reciept");
	           console.log(result);
	           
	         //get each receipt item
	           $.each(result.receiptItemsRefs,function(key,value){
	        	   console.log(value.name);
	        	   });


	       }});
	  }

 
 get_mainCustomer();
 get_mainCustomerAccTransacitons(1);
 get_receipt(6);
 
 
//  $("#signOutButton").click(function(){
//    $('#signOutDisplay').show();
//  });

});
