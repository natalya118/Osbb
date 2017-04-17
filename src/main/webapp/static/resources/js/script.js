$(document).ready(function(){
    $(function () {
  $('[data-toggle="popover"]').popover()
})
//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
    var step=1;

$(".next").click(function(){
	if(animating) return false;
	animating = true;

	current_fs = $(this).parent();
	next_fs = $(this).parent().next();
    next_fs.css('margin-left', '250%');
	
	//activate next step on progressbar using the index of next_fs
    if(step==1){
        $("#connector12").animate({width: '35%'},500,function(){
            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
        });
        step++;
    } else if(step==2){
        $("#connector23").animate({width: '35%'},500, function(){
            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
        });
        step++;
    }
    
	//show the next fieldset
	next_fs.show(); 
	//hide the current fieldset with style
    current_fs.animate({marginLeft: '15%'}, 200);
	current_fs.animate({marginLeft: '-250%'}, 800, function(){
        next_fs.animate({marginLeft: '10%'});
			current_fs.hide();
			animating = false;
		}
	);
});

$(".previous").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();
    previous_fs.css('margin-left', '-250%');
	
	//de-activate current step on progressbar
    $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
    if(step==2){
        $("#connector12").animate({width: '0%'},500);
        step--;
    } else if(step==3){
        $("#connector23").animate({width: '0%'},500);
        step--;
    }
	
	//show the previous fieldset
	//hide the current fieldset with style
	current_fs.animate({marginLeft: '5%'}, 200);
	current_fs.animate({marginLeft: '250%'}, 800, function(){
        current_fs.hide();
        previous_fs.show(); 
        previous_fs.animate({marginLeft: '10%'});
			animating = false;
		}
	);
});

$(".submit").click(function(){
	return false;
})

});