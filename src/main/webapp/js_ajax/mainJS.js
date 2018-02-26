$(document).ready(function(){
  $('#signOutDisplay').hide();

  $.get({url: "http://localhost:8080/BOI_bankingApp/rest/json", success: function(result){
           $("#output").append("Output form Server "+result.result);


       }});



  $("#signOutButton").click(function(){
    $('#signOutDisplay').show();
  });

});
