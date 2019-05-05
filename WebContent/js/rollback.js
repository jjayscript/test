$(function(){
	$("#rollback_button").click(function(){ 
		$("#noput_note_title").html("");
		$("#preview_note").html("");
		   $("#rollback_list li").remove();
		   $("#pc_part_3").hide();
	       $("#pc_part_4").fadeToggle();
	       $("#pc_part_8").hide();
	       $("#pc_part_7").hide();
	       $("#pc_part_2").hide();
	       $("#pc_part_6").hide();
	       $("#pc_part_5").show();
	       $("#note_list li").children().removeClass("checked");
	       $("#contacts-list li").children().removeClass("checked");
	       var userid=getCookie("uid");
	       $.ajax({
	    	   url:"http://localhost:8080/CloudNote/note/recycle.do",
	    	   type:"post",
	    	   dataType:"json",
	    	   data:{"userid":userid},
	    	   success:function(result){
	    		   var notenames=result.data;
	    		   if(result.status==0){
	    			   for(var i=0;i<notenames.length;i++){
	    				   var notename=notenames[i].cn_note_title;
	    				   var noteid=notenames[i].cn_note_id;
	    				   var $li=$('<li class="disable">'+
	    				   '<a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'
	    				      +notename+
	    				   '<button type="button" class="btn btn-default btn-xs btn_position btn_delete">'+
	    				   '<i class="fa fa-times"></i></button><button type="button"'+ 
	    				   'class="btn btn-default btn-xs btn_position_2 btn_replay">'+
	    				   '<i class="fa fa-reply"></i></button></a></li>');
	    				   $li.data("noteID",noteid);
	    				   $("#rollback_list").append($li);
	    			   }
	    		   }
	    	   }
	       });
	   });
});
$(function(){
	 $("#rollback_list").on("click","li",function(){
		   $("#rollback_list li").children().removeClass("checked");
		   $(this).find("a").addClass("checked");
	 });
});
$(function(){
	   $("#rollback_list").on("click",".btn_replay",function(){
		   // $(this).parents("a").addClass("checked");
	        $("#can").load("alert/alert_replay.html");    
	      //  $("#can").on("click","#replaySelect",function(){
	        	var values=$("#replay_select").next().attr("value");
	        	var userid=getCookie("uid");
				$.ajax({
		    		url:"http://localhost:8080/CloudNote/notebook/notebook.do",
		    		type:"post",
		    		dataType:"json",
		    		data:{"id":userid},
		    		success:function(result){
		    			var books=result.data;
		    			if(values==undefined){
		    			for(var i=0;i<books.length;i++){
		    				var bookname=books[i].cn_notebook_name;
		    				var options=$('<option value="'+i+'">'+bookname+'</option>');
		    				options.data("bookID",books[i].cn_notebook_id);
		    				$("#replaySelect").append(options);
		    			}
		    		}
		    		}
		    	 });	
	        //});
	   
	   });
	   
});
//彻底删除笔记
$(function(){
	$("#rollback_list").on("click",".btn_delete",function(){
		$("#can").load("alert/alert_delete_rollback.html");
		$("#can").on("click","#final_delete",function(){
		   var $li=$("#rollback_list a.checked").parent();
		   var noteid=$li.data("noteID");
		   
		   $.ajax({
			  url:"http://localhost:8080/CloudNote/note/deletenote.do",
			  type:"post",
			  dataType:"json",
			  data:{"noteid":noteid},
			  success:function(result){
				  if(result.status==0){
					  $li.remove();
					  closewindow();
				  }
			  }
		   });
	   });
	});
});

//从回收站里面恢复到笔记本中
$(function(){
	$("#can").on("click","#replay",function(){
		var bookid=$("#replaySelect option:checked").data("bookID");
		var $li=$("#rollback_list a.checked").parent();
		var noteid=$li.data("noteID");
		//alert(bookid);
		if(bookid==null){
			return;
		}
		//alert(noteid);
		$.ajax({
			url:"http://localhost:8080/CloudNote/note/replay.do",
			type:"post",
			dataType:"json",
			data:{"notebookid":bookid,"noteid":noteid},
			success:function(result){
				if(result.status==0){
					$li.remove();
					closewindow();
				}
			}
		});
	});
});















