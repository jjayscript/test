//移动笔记
$(function(){
			$("#note_list").on("click",".btn_move",function(){
				$(".opacity_bg").show();
				$("#can").load("alert/alert_move.html",getNoteBook);
				//$("#can").on("click","#moveSelect",getNoteBook);		
			});
			//$("#can").on("click","#move_btn",function(){
				var bookid=$("#moveSelect option:checked").data("bookID");
				$("#can #moveSelect").empty();
				if(bookid==null){
					return;
				}
				var $li=$("#note_list a.checked").parent();
				var noteid=$li.data("noteID");
				$.ajax({
					url:"http://localhost:8080/CloudNote/note/swap.do",
					type:"post",
					dataType:"json",
					data:{"bookid":bookid,"noteid":noteid},
					success:function(result){
						if(result.status==0){
							$li.remove();
							um= UM.getEditor('myEditor');
							um.getContent("");
							$("#input_note_title").val("");
							//alert("移动成功");
							closewindow();
						}
					}
				});
			});	
		//});		
		
		function getNoteBook(){
			var userid=getCookie("uid");
			var values=$("#please_select").next().attr("value");
			//var last=$("#please_select").last().attr("value");
			//alert(values);
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
	    				$("#moveSelect").append(options);
	    			}
	    			
	    		}
	    			
	    	  }
	    	});
		}