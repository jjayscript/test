$(function(){
			$("#add_notebook").click(function(){
				$(".opacity_bg").show();
				$("#can").load("alert/alert_notebook.jsp");
			    
			});
			$("#can").on("click",".close,.cancle",function(){
				//$("#please_select").siblings().remove();
				closewindow();
			});
		});
		$(function(){
			$("#can").on("click","#addnotebook",function(){
				//alert("mimias");
				 $("#pc_part_4").hide();
				
				var notebookname=$("#input_notebook").val().trim();
				var userid=getCookie("uid");
				if(notebookname==""){
					closewindow();
					return;
				}
				$("#pc_part_3").empty();
				$("#note_list").empty();
				$.ajax({
					url:"http://localhost:8080/CloudNote/notebook/addbook.do",
					type:"post",
					dataType:"json",
					data:{"bookname":notebookname,"userid":userid},
					success:function(result){
					    if(result.status==0){
					    	closewindow();
					    	var bookID=result.data;
					    	var ai=$('<li class="online">'+
		    						'<a>'+
			                        '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'+
			                        notebookname+
			                        '<button type="button" class="btn btn-default btn-xs btn_position btn_delete">'+
			                        '<i class="fa fa-times"></i></button>'+
		                            '</a></li>');
					    	ai.data("bookID",bookID);
					    	$("#contacts-list").prepend(ai);
					    
					    }
					},
					error:function(){
						alert("创建失败");
					}
				});
			});
		});
		function closewindow(){
			$(".opacity_bg").hide();
			$("#can").empty();
		}