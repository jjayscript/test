//显示笔记本列表
$(function(){      
		   var uid=getCookie("uid");
		   //alert(uid)
	       if(uid==""){
		       window.location.href="login.html";
			}
	       //$("#pc_part_3").empty();
	       $("#input_note_title").val("");
	       $.ajax({
	    		url:"http://localhost:8080/CloudNote/notebook/notebook.do",
	    		type:"post",
	    		//async:false,
	    		dataType:"json",
	    		data:{"id":uid},
	    		success:function(result){
	    			var books=result.data;
	    			for(var i=0;i<books.length;i++){
	    				var ai=$('<li class="online">'+
	    						'<a>'+
		                        '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'+
		                        books[i].cn_notebook_name+
		                        '<button type="button" class="btn btn-default btn-xs btn_position btn_delete">'+
		                        '<i class="fa fa-times"></i></button>'+
	                            '</a></li>');
	    				var bookID=books[i].cn_notebook_id;
	    				ai.data("bookID",bookID);
	    				$("#contacts-list").append(ai);
	    			}
	    			
	    		}
	    		
	    	});
	    });
//显示笔记列表
$(function(){
	
	$("#contacts-list").on("click","li",function(){
		$("#pc_part_4").hide();
		$("#pc_part_8").hide();
	    $("#pc_part_7").hide();
	    $("#pc_part_3").show();
	    $("#pc_part_2").show();
	    $("#pc_part_5").hide();
	    $("#pc_part_6").hide();
		$("#note_list").empty();
		um= UM.getEditor('myEditor');
		um.setContent("");
		$("#input_note_title").val("");
		$("#contacts-list li").children().removeClass("checked");
		var bookID=$(this).data("bookID");
		$(this).find("a").addClass("checked");
		$.ajax({
			url:"http://localhost:8080/CloudNote/note/note.do",
			type:"post",
			dataType:"json",
			data:{"id":bookID},
			success:function(result){
			if(result.status==0){
				var cn_note=result.data;
				for(var i=0;i<cn_note.length;i++){
					var notetitle=cn_note[i].cn_note_title;
					var noteid=cn_note[i].cn_note_id;
					var note=
						$('<li class="online">'+
					'<a>'+
					'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+notetitle+
					'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
				'</a>'+
				'<div class="note_menu" tabindex="-1">'+
					'<dl>'+
						'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
						'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
						'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
					'</dl>'+
				'</div>'+
			'</li>');
			note.data("noteID",noteid);		
			$("#note_list").append(note);				
				}
			}
			}
		});
	});		
	});



