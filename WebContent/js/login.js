 
   $(function(){
		   $("#count_msg").hide();
		   $("#count").blur(function(){
			   var count=$("#count").val().trim();
			   if(count==""){
				   $("#count_msg").html("用户名不能为空");
				   $("#count_msg").show();
				   return;
			   }else{
				   $("#count_msg").hide();
			   }
			   
		   });
	   });
   $(function(){
	   $("#pwd_msg").hide();
	   $("#password").blur(function(){
		   var password=$("#password").val().trim();
		   if(password==""){
			   $("#pwd_msg").html("密码不能为空");
			   $("#pwd_msg").show();
			   return;
		   }else{
			   
			   $("#pwd_msg").hide();
		   }	   
	   });
   });
  
  $(function(){
	
    $("#login").click(function(){
    	   var name=$("#count").val();
    	   var pwd=$("#password").val();
			 $.ajax({
				 url:"http://localhost:8080/CloudNote/user/login.do",
				 data:{"name":name,"pwd":pwd},
				 dataType:"json",
				 success:function(result){
					 if(result.status==1){
						 $("#count_msg").html(result.msg);
						 $("#count_msg").show();
						 return;
					 }else if(result.status==2){
						 $("#pwd_msg").html(result.msg);
						 $("#pwd_msg").show();
						 return;
					 }else{
						 addCookie("uid",result.data,2);
						 window.location.href="edit.html";
						 
					 }
				 }
			 });
		  });
	  });
  
  
  $(function(){
	  $("#regist_username").blur(function(){
		  var regist_name=$("#regist_username").val().trim();
		 if(regist_name==""){
			 $("#name_msg").html("用户名不能为空");
			 $("#warning_1").show();
			 return;
		 } else{
			 $("#warning_1").hide();
		 }
	  });
  });
  $(function(){
		 $("#nick").hide();
		   $("#nickname").blur(function(){
			   var name=$("#nickname").val().trim();
			   if(name==""){
				   $("#nick_msg").html("昵称不能为空");
				   $("#nick").show();
				   return;
			   }else{
				   $("#nick").hide();
			   }
		   });
	});
  $(function(){
	
	
	  
	   $(".password").blur(function(){
		  //var reg="^.{6,20}$";
		   var pwd1=$("#regist_password").val().trim();
		   var pwd2=$("#final_password").val().trim();
		   //if(!pwd1.match(reg)){
			 //  $("#warning_2").show();
			   //$("#regist_msg").html("密码长度至少6位");
				 // return;
		   //}else 
			   if(pwd1==""){
			   $("#regist_msg").html("密码不能为空");
			   $("#warning_2").show();
			  return;
		   }else if(pwd2==""){
			   $("#warning_2").hide();
			   $("#final_msg").html("密码不能为空");
			   $("#warning_3").show();
			   return;
		   }else if(pwd1!=pwd2){
			   $("#final_msg").html("密码不同");
			   $("#warning_3").show();
			   return;
		   }
		   else{
			   $("#warning_2").hide();
			   $("#warning_3").hide();
		   }
	   });
});
  
  $(function(){
	  
	   $("#regist_button").click(function(){
		   var regist_name=$("#regist_username").val().trim();
		   var nickname=$("#nickname").val().trim();
		   var regist_password=$("#regist_password").val().trim();
		   var final_password=$("#final_password").val().trim();
		   if(regist_name==""||nickname==""||regist_password==""||final_password==""){
			   return;
		   }		   
		   $.ajax({
			   url:"http://localhost:8080/CloudNote/user/regist.do",
			   type:"post",
			   dataType:"json",
			   data:{"name":regist_name,"nickname":nickname,"pwd":final_password},
			   success:function(result){
				   if(result.status==1){
					   $("#name_msg").html(result.msg);
					   $("#warning_1").show();
					   return;
				   }else if(result.status==0){
					   $("#back").click();
				   }
			   }
		   });
	   });
	   
  });
  
  
  $(function(){
		$("#sig_in").click(function(){
			
			$("#regist_username").val("");
			$("#nickname").val("");
			$("#regist_password").val("");
			$("#final_password").val("");
			$("#warning_1").hide();
			$("#warning_2").hide();
			$("#warning_3").hide();
		});
	 });
  
  
//检查原始密码
  $(function(){
	  $("#last_password").blur(function(){
		  var oripassword=$("#last_password").val().trim();
			 if(oripassword==""){
				 $("#original_password").html("原密码不能为空");
				 $("#warning_1").show();
				 return;
			 }else{
				 $("#warning_1").hide(); 
			 
	   var userid=getCookie("uid");
	   $.ajax({
		  url:"http://localhost:8080/CloudNote/note/findname.do", 
		  type:"post",
		  dataType:"json",
		  data:{"userid":userid,"password":oripassword},
		  success:function(result){
			  if(result.status==0){
				  $("#warning_1").hide(); 
			  }else if(result.status==1){
				  $("#original_password").html("原始密码错误");
				  $("#warning_1").show();
				  return;
			  }
		  }
	   }); 
	  }
	 });
  });
  //修改密码
  $(function(){
	 $("#changePassword").click(function(){
		 var oripassword=$("#last_password").val().trim();
		 var rpassword=$("#regist_password").val().trim();
		 var fpassword=$("#final_password").val().trim();
		 var userid=getCookie("uid");
		 if(oripassword==""||rpassword==""||fpassword==""){
			 return;
		 }
		 $.ajax({
			url:"http://localhost:8080/CloudNote/user/changepassword.do",
			type:"post",
			dataType:"json",
			data:{"userid":userid,"password":fpassword},
			success:function(result){
				if(result.status==0){
					alert("修改成功");
					window.location.href="login.html";
				}
			},error:function(){
				alert("修改失败");
			}
		 });
	 }) ;
	 $("#back").click(function(){
		 window.location.href="edit.html";
	 });
  });
  //退出登录
  $(function(){
	  $("#logout").click(function(){
		  delCookie("uid");
		  window.location.href="login.html";
	  });
  });
  
  
  
  
  
  