$(document).ready(function(){
  $('#signOutDisplay').hide();

 function get_accounts(){
	  $.get({url: "http://localhost:8080/boideployment/rest/customer/json", success: function(result){
	           $("#output").append("Output form Server ");
	           console.log(result);


	       }});
	  }

  get_accounts();
  $("#signOutButton").click(function(){
    $('#signOutDisplay').show();
  });

});
