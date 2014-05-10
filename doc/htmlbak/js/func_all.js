
/**
 * @name		jQuery Cascdejs plugin
 * @author		zdy
 * @version 	1.0 
 */
 
	
//首先需要初始化
 
		var INSURANCEPERIOD=10; //use an constant, fixed 10years insurance
			var arr_n_a_cash=arr_n_a_cash1.concat(arr_n_a_cash2,arr_n_a_cash3,arr_n_a_cash4);  //concat the four arrays
			var i_age=25;
			var i_sex=0;
			var i_years=5;
			var i_premium=5000;
			var f_mainpremium=0;
			var f_additionalpremium=0;
			var f_maincoverage=0;
			var f_additionalcoverage=0;
			var i_money_check=0; 
			
		$(function(){
			var p = navigator.platform;
		    if( p.indexOf('Linux') == -1){
		    	$('.prn').show();		    	
		    }
		    else{		    	
		    	$('.prn').hide();
		    }	    
						
			$('.prnbtn').click(function(){
				window.print();
				});
		});
			function showBlankDiv(currInput){
				//used for the premium input,so it would not be cover by the soft keyboard
				var h=$(window).height();
				//h=h+1; //just for break point
				$(currInput).find(".blankdiv").first().height(0.4*h); //raise the premium input in window
				var scroll_offset = $(currInput).offset(); //得到premium的offset，包含两个值，top和left
				$("body,html").animate({
					scrollTop:scroll_offset.top //让body的scrollTop等于pos的top，就实现了滚动
				},0);
			}
			function hideBlankDiv(currInput){
				//var h=$(window).height();
				//h=h+1;  //just for break point
				$(currInput).find(".blankdiv").first().height(0); //fall back the premium input in window
				$("body,html").animate({scrollTop:0	},0);
			}
			function premiumOK(){ //value must be  integer multiple of 1000
				var premium=i_money_check;
				 
				if(((Math.round(premium/1000)*1000) != premium)||(Math.round(premium/1000)*1000) ==0){
				//alert("a");
					//showBlankDiv();
					$(".premiumalert").show();
					$("#premium").select();
					return(false);
				}
				else{
				//alert("b");
					$(".premiumalert").hide();
					//hideBlankDiv();
					return(true);
				}
			}
			
			function premiumOK_2(){ //value must be  integer multiple of 500
				var premium=i_money_check;   //设定全局变量保存金额
				if(((Math.round(premium/500)*500) != premium)||(Math.round(premium/500)*500) ==0 ||(Math.round(premium/500)*500) ==500) {
					$(".premiumalert").show();
					$("#premium").select();
					return(false);
				}
				else{
					$(".premiumalert").hide();
					hideBlankDiv();
					return(true);
				}
			}
			
			function premiumOK_20(){ //每份1000元,20份起售
				var premium=i_money_check;   //设定全局变量保存金额
				 
				if(((Math.round(premium/1000)*1000) != premium)||(Math.round(premium/1000)*1000) ==0 ||(premium<20000)) {
					$(".premiumalert").show();
					$("#premium").select();
					return(false);
				}
				else{
					$(".premiumalert").hide();
					hideBlankDiv();
					return(true);
				}
			}
			
			function premiumOK_bbb(){ //百倍保要根据金额来提示
				var premium=i_money_check;   //设定全局变量保存金额
				var i_years_bbb=$('input:radio[name="years_bbb"]:checked').val();
				if(i_years_bbb=="1")
				{
					if(((Math.round(premium/500)*500) != premium)||(Math.round(premium/500)*500) ==0 ||(Math.round(premium/500)*500) ==500||(premium>15000)) {
					$("#remind_bbb").text("趸交请输入15000元以下");     //趸交不超过1.5W
					$(".premiumalert").show();
					$("#premium").select();
					return(false);
						}
					else{
						$(".premiumalert").hide();
						hideBlankDiv();
						return(true);
						}
				}
				else
				{
					if(i_years_bbb=="3")
					{
						if(((Math.round(premium/500)*500) != premium)||(Math.round(premium/500)*500) ==0 ||(Math.round(premium/500)*500) ==500 ||(premium>5000)) {
							$("#remind_bbb").text("3年期交请输入5000元以下");     //3年期不超过5000
							$(".premiumalert").show();
							$("#premium").select();
							return(false);
							}
						else{
							$(".premiumalert").hide();
							hideBlankDiv();
							return(true);
						}
					}
					else
					{
						if(((Math.round(premium/500)*500) != premium)||(Math.round(premium/500)*500) ==0 ||(Math.round(premium/500)*500) ==500 ||(premium>3000)) {
							$("#remind_bbb").text("5年期交请输入3000元以下");     //5年期不超过3000
							$(".premiumalert").show();
							$("#premium").select();
							return(false);
							}
						else{
							$(".premiumalert").hide();
							hideBlankDiv();
							return(true);
						}
					}
				}
			}
			
				function formatNum(num)
			{//参数说明：num 要格式化的数字,简化为保留2位小数
				num = String(num.toFixed(2));
				var re = /(-?\d+)(\d{3})/;
				while(re.test(num)) {num = num.replace(re,"$1,$2");}
				return ("￥"+num);
			}  
			
			/*年B部分暂时注销测试*/			
		       
			/*富1测试暂时注销*/
			
			/*fu3*/
			
			/*绵2部分暂时注销测试*/	
			
			/*新年A测试暂时注销*/ 
		
       		/*年年好百倍保*/
			

		$(document).on("pageinit", function() {			
			 //age:0~55,-1 for not set,sex:1 for male,years:3 or 5,premium per year
				//alert("getguarantee");
				/* var i_age=25;
				var i_sex=0;
				var i_years=5;
				var i_premium=5000;
				var f_mainpremium=0;
				var f_additionalpremium=0;
				var f_maincoverage=0;
				var f_additionalcoverage=0;
				var i_money_check=0;  */  //moved to public var define area
			
			$.mobile.defaultPageTransition = "none";
			//$("#cover").click(function(){
			//	$.mobile.changePage("#main");
			//});
			$("#exitprogram").click(function(){
				window.close();
				//navigator.app.exitApp(); //navigator.app.exitApp();
			});  
			 
			$(".premium_input").mouseup(function(){
				//alert("mouseup" +$("#premium").val());
				//$("#premium").val(5000); //set the value for apple bug(there ,the input wouldn't show effect if not del all number first.
				$(".premium_input").select();
				//showBlankDiv();	
			});
			
			
			//raise the premium input in window,by giveing the div height below it
			
			var h=$(window).height();
			$(".blankdiv").each(function(){
				$(this).height(0.4*h); 
			});
			$(".premium_input").each(function(){
				$(this).focus(function(){
					showBlankDiv(this);
				});
				$(this).blur(function(){
					hideBlankDiv(this);
				});
			});  
			
			
			/* $(".premium_input").each(function(){
				$(this).blur(function(){
					hideBlankDiv(this);
				});
			});
			$(".premium_input").blur(function(){
				hideBlankDiv();
			}); */
			
			/*年B部分,暂时注销测试 */
			
			
			/*mian2 info  */
			
			
			
			
			/*新年A测试暂时注销  */
			
			
			/*年年好百倍保  info  */ 
			
			/*富1测试暂时注销   
			/*fu1-end*/
			
			/*fu3  info  
			/*fu3-end*/
			
			
		});
