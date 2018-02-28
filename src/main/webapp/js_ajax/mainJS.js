$(document).ready(function(){
//  $('#signOutDisplay').hide();

var $mainCustomerId=1;
get_mainCustomer();
get_mainCustomerAccTransacitons(1);

function get_mainCustomer(){

	  $.get({url: "http://localhost:8080/boideployment/rest/customer/json/"+$mainCustomerId, success: function(result){
        console.log('full result');
        console.log(result);

            var heading='<h5 class="col-sm-4"">Profile of :'+ result.customerName+'<small><br>Email :  '+result.email+'</small></h5>';
            $('#customerName').append(heading);
	       }});
	  }

 function get_mainCustomerAccTransacitons(account_id)
 {
	
	  $.get({url: "http://localhost:8080/boideployment/rest/account/json/"+$mainCustomerId, success: function(result)
		  {
		  //result is the overall returned object
	          // console.log(result);
	          // console.log(result[0].transRefs[0]);
             $("#accountButtons").empty();
              $('#datatable').empty();
              var heading='<div class = "row dataHeader"><span class = "col-sm-2"> Date:   </span>'+
              '<span class = "col-sm-4"> Description:</span>'+
              '<span class = "col-sm-2"> Total Amount:   </span>'+
              '<span class = "col-sm-2"> Receipt:</span>'+
              '</div>';
              $('#datatable').append(heading);
            $.each(result,function(key,value){
             //console.log(value);
             var $buttonString='<button  type="button" class="btn btn-info btn-default col-sm-3 myAccountBtn" data-value="'+value.id+'" >'+value.description+'<span id="ac1"> </span> </button>';
             $("#accountButtons").append($buttonString);
             });
	           //get each transaction
	           $.each(result[account_id-1].transRefs,function(key,value){
               var $buttonString="";
               if(value.receipts.length>0)
               {
                 $buttonString='<button type="button" class="btn btn-info btn-default col-sm-2 recieptButton" data-toggle="modal" data-target="#TransactionOne " data-reciept="'+value.transId+'">Receipt </button>';
               }
	         var $row ='<div class = "row dataHeader2">'+
            '<span class = "col-sm-2"> '+value.date+'  </span>'+
            '<span class = "col-sm-4">'+value.transName+'</span>'+
            '<span class = "col-sm-2"> '+value.amount+' </span>'+
            $buttonString+
            '</div>';
	         $('#datatable').append($row);
	        	   });
	       }
	  });
}

 function get_receipt(transactionID){

	  $.get({url: "http://localhost:8080/boideployment/rest/receipt/json/"+transactionID, success: function(result){
	          // full receipt
	        //   console.log("reciept");
	         //  console.log(result);
            $('#transactionBody').empty();
           var transactionBody=
           '<div>'+
             '<label for="TransactionOne">Description:</label><span>'+result.text+'</span>'+
           '</div>'+
           '<div>'+
             '<label for="TransactionOne">Location:</label><span>'+result.location+'</span>'+
           '</div>';
           $('#transactionBody').append(transactionBody);

	         //get each receipt item
	           $.each(result.receiptItemsRefs,function(key,value){
	        	   //console.log(value.name);

            var receiptItem= '<div class="row"><div class="col-sm-4">'+
                 '<label for="TransactionOne">Name: </label><span>'+value.name+'</span>'+
               '</div>'+
               '<div class="col-sm-2">'+
                    '<label for="TransactionOne">QTY: </label><span>'+value.quantity+'</span>'+
                  '</div>'+
               '<div class="col-sm-2">'+
                 '<label for="TransactionOne">Unit Price: </label><span>'+value.price+'</span>'+
               '</div></div>';
                $('#transactionBody').append(receiptItem);
	        	   });
	       }});
	  }


 $('#accountButtons').on('click', '.myAccountBtn', function(){
      var $buttonID= $(this).attr("data-value");
      get_mainCustomerAccTransacitons($buttonID);
 });


 $('#datatable').on('click', '.recieptButton', function(){
    //  console.log("the button id is clicked REC" );
      var $buttonID= $(this).attr("data-reciept");
       get_receipt($buttonID);
      $('#TransactionOne').modal('toggle');

 });


});
