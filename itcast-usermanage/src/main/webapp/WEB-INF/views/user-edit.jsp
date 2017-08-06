<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="easyui-panel"  data-options="border:false" style="width:400px">
        <div style="padding:10px 60px 20px 60px">
        <form id="userEditForm" method="post">
        	<input type="hidden" name="id" />
            <table cellpadding="5">
                <tr>
                    <td>姓名:</td>
                    <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td><input class="easyui-numberbox" type="text" name="age" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <select class="easyui-combobox" name="sex" data-options="required:true">
                        	<option value="true">男</option>
                        	<option value="false">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>生日:</td>
                    <td><input class="easyui-datebox" name="birthday" data-options="required:true"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
        </div>
        </div>
    </div>
    <script>
        function submitForm(){
            if(!$("#userEditForm").form("validate")){
            	$.messager.alert('提示','表单未填写完成!');
            	return;
            }
            
            //修复性别初始化，未修改的情况下产生的bug
            var _val = $("#userEditForm [name=sex]").val();
            if(_val != "true" || _val != "false"){
            	if(_val == "男"){
            		$("#userEditForm [name=sex]").val("true");
            	}else{
            		$("#userEditForm [name=sex]").val("false");
            	}
            }
            
            $.post("/user/update", $("#userEditForm").serialize(),
       		   function(data){
       		     if(data.status==200){
       		    	$.messager.alert('提示','用户数据修改成功!',"info",function(){
       		    		//关闭窗口
           		    	$("#editUserWindow").window("close");
           		    	//刷新datagrid
           		    	$("#userList").datagrid("reload");
       		    	});
       		     }else{
       		    	$.messager.alert('提示','用户数据修改失败!');
       		     }
       		 });
        }
        function clearForm(){
            $('#userEditForm').form('clear');
        }
    </script>