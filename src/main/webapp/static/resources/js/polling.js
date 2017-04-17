
$(document).ready(function(){
    var voted = false;
    var childCount = $(".details").children().length;
    var aboutLen = $(".polling").width();
    var detLen = $(".details").width();
        $(".details").css("margin-left", ""+((aboutLen-detLen)/2)-50+"px");
    
    
    $(".btn-poll").click(function(){
        voted = true;
        $(".btn-poll").remove();
        $(".valperc").show().fadeIn();
        $('.first').circleProgress({
            value: 0.68,
            fill: {
                gradient: ['#9cc7e0', '#5bafd0']
            },
        });
    });

    $(".showRes").click(function(e){
        if(voted){
            $("#votedForThis").modal("show");
        }
    });
    var variantsCount = 3;
    $(".add-variant").click(function(){
        if(variantsCount < 6){
            var newVar = $("<div>");
            newVar.append("<div id='"+variantsCount+"'><form:input path='v3' type='text' placeholder='Новий варіант' class='variant'/><button type='button' class='delete-variant close'>&times;</button></div>");
            newVar.hide();
            newVar.appendTo("#variants").slideDown();
        variantsCount++;
        }
        
        $(".delete-variant").click(function(){
        	 variantsCount--;
        $(this).parent().slideUp("normal", function(){$(this).remove()});
    });
    });
    
    $(".first").hover(function(){
        if(voted) $(this).find(".showRes").animate({opacity:1}, 100);
    });
    
    $(".first").mouseleave(function(){
        if(voted) $(this).find(".showRes").animate({opacity:0}, 100);
    });
    
});

jQuery.fn.mouseIsOver = function () {
    return $(this).parent().find($(this).selector + ":hover").length > 0;
}; 
