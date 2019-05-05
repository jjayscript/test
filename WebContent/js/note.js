//显示编辑面板
var um ;		
$(function(){
	$("#note_list").on("click","li",function(){
		 $("#pc_part_4").hide();
	       $("#pc_part_3").show();
	      
		$("#note_list li").children().removeClass("checked");
		$("#input_note_title").val("");
		var noteid=$(this).data("noteID");
		$(this).find("a").addClass("checked");
		$.ajax({
			url:"http://localhost:8080/CloudNote/note/content.do",
			type:"post",
			dataType:"json",
			data:{"noteid":noteid},
			success:function(result){
				if(result.status==0){
					var note=result.data;
					$("#input_note_title").val(note.cn_note_title);
					um= UM.getEditor('myEditor');
					um.setContent(note.cn_note_body);
				}
			}
			
		});
	});			
});
//保存编辑内容
$(function(){
	$("#save_note").click(function(){
		var notetitle=$("#input_note_title").val().trim();
		var li=$("#note_list a.checked").parent();
		var title=$("#note_list a.checked").text();
		//alert(title);
		var noteid=li.data("noteID");
		//
		if(noteid==null){
			return;
		}
		um= UM.getEditor('myEditor');
		var content=um.getContent();
		$.ajax({
			url:"http://localhost:8080/CloudNote/note/savecontent.do",
			type:"post",
			dataType:"json",
			data:{"title":notetitle,"body":content,"noteid":noteid},
			success:function(result){
				if(result.status==0){
					//li.empty();
					alert("保存成功");
					if(notetitle!=title){
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
					
					note.data("noteID",noteid);
					$("#note_list").append(note);
					li.remove();
					}
				}
			}
		});
	});
});
//显示操作菜单 移动 分享 删除
$(function(){
	$("#note_list .note_menu").hide();
	$("#note_list").on("click",".btn_slide_down",function(){
		$(this).parents("li").find(".note_menu").fadeToggle();
	});
	$("#note_list").on("mouseout",".note_menu",function(){
		$(this).parents("li").find(".note_menu").hide();
	});
	$("#note_list").on("mouseover",".note_menu",function(){
		$(this).parents("li").find(".note_menu").show();
	});
	
});
//删除笔记到回收站
$(function(){
	$("#note_list").on("click",".btn_delete",function(){
		$(".opacity_bg").show();
		$("#can").load("alert/alert_delete_note.html");
		$("#can").on("click",".close,.cancle",function(){
			closewindow();
		});
		$("#can").on("click","#delete_note",function(){
			var li=$("#note_list a.checked").parent();
			//var li=$(this).parents("li");
			var noteid=li.data("noteID");
			
			$.ajax({
				url:"http://localhost:8080/CloudNote/note/upstatus.do",
				type:"post",
				dataType:"json",
				data:{"noteid":noteid},
				success:function(result){
					if(result.status==0){
						um= UM.getEditor('myEditor');
						um.setContent("");
						$("#input_note_title").val("");
						li.remove();
						closewindow();
					}
				}
			});
			
		});
		
	});
			
});
		