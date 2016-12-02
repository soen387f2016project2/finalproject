
 
      

$(function(){
    
           function login()
    {       
        username=$("input[name=username]").val();
        password=$("input[name=password]").val();
        if(username != "" && password != "")
        {
        $.ajax({
         method: "POST",
         url: "authenticate.jsp",
         data: "username="+username+"&password="+password,
         dataType: 'HTML',
         success: function(html){    
              if(html.trim()=='true')    {
                  $("#output").addClass("alert alert-success animated fadeInUp").html("Welcome back " + "<span style='text-transform:uppercase'>" + username + "</span>");
                  $("#output").removeClass(' alert-danger');
                  $("input").css({
                  "height":"0",
                  "padding":"0",
                  "margin":"0",
                  "opacity":"0"
                  });
                  //change button text 
                  $('#login-btn').html("continue")
                  .removeClass("btn-info")
                  .addClass("btn-info").click(function(){
                  location.replace("resources.jsp");
                  });
                  
                  //show avatar
                  $(".avatar").css({
                      "background-image": "url('https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRL1uzmgyrfPwUC7UwnOFHFtkAhQrAUYufbLzWvOt9N8pRt1zlV')"
                  });
                  setTimeout(function() {   //calls click event after a certain time
                    location.replace("resources.jsp");
                 }, 3000);
              }
              else    {
              //    console.log(html);
                 $("#output").removeClass(' alert-danger');
                 $("#output").addClass("alert alert-danger animated fadeInUp").html("Wrong username and/or password ");
              }
         },
         beforeSend:function()
         {
              $("#add_err").css('display', 'inline', 'important');
              $("#add_err").html("<img src='images/ajax-loader.gif' /> Loading...")
         }
        });//end of ajax
    }
                  
	
    }
    
    $("form[name=loginForm]").submit(function() {
        login();
        event.preventDefault();
    });


    $('.hideButton').click(function() {
        //("#" + id).fadeOut();
        var index = $(this).attr('container');
        $("#" + index).fadeOut();
//        setTimeout(function() {   //calls click event after a certain time
//            $("#" + index).attr('style' , "display:none" );
//           }, 1000);
        console.log("#" + index);
    });
    
//    $('.view-resource-button').click(function() {
//            event.preventDefault();
//        var index = $(this).attr('ID');
//        
//        $("#ResourceCard" + index).removeClass("wow slideInUp");
//        
//        var el = $("#ResourceCard" + index);
//            newone = el.clone(true);
//            
//        el.before(newone);
//        el.remove();
//        
//        newone.addClass("animated slideOutUp");
//
//        //$('#ResourceCard').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', 
//            //window.location.href = "viewresource.jsp?id="+index);
//                  setTimeout(function() {   //calls click event after a certain time
//                    window.location.href = "viewresource.jsp?id="+index;
//                 }, 500);
//    });    
           // location.replace("viewresource.jsp?id="+index)

    $('.login-continue').click(function() {
        location.replace("resources.jsp");
    });   
    
    $('.search-panel .dropdown-menu').find('a').click(function(e) {
            e.preventDefault();
            var param = $(this).attr("href").replace("#","");
            var concept = $(this).text();
            $('.search-panel span#search_concept').text(concept);
            $('.input-group #search_param').val(param);
    });

        new WOW().init();

});
