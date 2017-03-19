$(document).ready(function () {
        var boxWidth = $(".courses").width();
        var checked = [];
        var studAuth = false;
        var schoolAuth = false;
        var studReg = false;
        
      $("#studAuth").click(function(){
    	  console.log("for stud");
      });
       
     $(".button").click(function () {
         if(hiddenTemplates){
          $(".templates").animate({right: '0'});
             $(this).animate({right: '36%'});
             hiddenTemplates = false;
             $(".maincont").animate({left:'0%'});
             $(".school-info-div").animate({left:'-50%'});
         } else{
             $(".templates").animate({right: '-36%'});
        $(this).animate({right: '0'});
             hiddenTemplates = true;
             $(".maincont").animate({left:'25%'});
             $(".school-info-div").animate({left:'13%'});
         }
     });
    
    $(".new-course").click(function(){
        $("body").toggleClass("dialogIsOpen");
    });
    
    
    });