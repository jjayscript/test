//移动到某个笔记本中的下拉列表	  
$(function(){
	  $("#add_note").click(function(){
			$(".opacity_bg").show();
			$("#can").load("alert/alert_note.html");
		    
		});
		$("#can").on("click",".close,.cancle",function(){
		//	$("#please_select").siblings().remove();
			
			closewindow();
		});
  });
		$(function(){
			$("#can").on("click","#addnote",function(){
				var li=$("#contacts-list a.checked").parent();
				var bookID=li.data("bookID");
				var notetitle=$("#input_note").val().trim();
				var userid=getCookie("uid");
				if(bookID==undefined||notetitle==""){
					//closewindow();
					return;
				}
				$.ajax({
					url:"http://localhost:8080/CloudNote/note/addnote.do",
					type:"post",
					dataType:"json",
					data:{"userid":userid,"bookid":bookID,"booktitle":notetitle},
					success:function(result){
						if(result.status==0){
							closewindow();
							var note=$('<li class="online">'+
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
							note.data("noteID",result.data);
							$("#note_list").prepend(note);										
						}
					}								
				});	
	  });
			
  });		