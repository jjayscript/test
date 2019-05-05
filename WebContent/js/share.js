$(function(){
	$("#note_list").on("click",".btn_share",function(){
		//var $li=$(this).parents("li");
		var $li=$("#note_list a.checked").parent();
		var noteid=$li.data("noteID");
		$.ajax({
			url:"http://localhost:8080/CloudNote/share/shareNote.do",
			type:"post",
			dataType:"json",
			data:{"noteid":noteid},
			success:function(result){
				if(result.status==0){
					alert("分享成功");
				}
			},
			error:function(){
				alert("分享失败");
			}
		});
	});
});