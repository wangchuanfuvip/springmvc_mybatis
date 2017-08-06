<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="margin-top: 10px;margin-left: 10px">
<table id="userList" class="easyui-datagrid" style="width:100%;"
        data-options="rownumbers:true,singleSelect:true,url:'/user/list',method:'get',toolbar:toolbar,pagination:true">
    <thead>
        <tr>
            <th data-options="field:'id',width:40">ID</th>
            <th data-options="field:'userName',width:100">用户名</th>
            <th data-options="field:'name',width:80,align:'center'">姓名</th>
            <th data-options="field:'age',width:80,align:'center'">年龄</th>
            <th data-options="field:'sex',width:60,formatter:formatterSex,align:'center'">性别</th>
            <th data-options="field:'birthdayStr',width:100,align:'center'">出生日期</th>
            <th data-options="field:'created',width:140,align:'center',formatter:formatterDate">创建时间</th>
            <th data-options="field:'updated',width:140,align:'center',formatter:formatterDate">更新时间</th>
        </tr>
    </thead>
</table>
</div>
<div id="editUserWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/user-edit'" style="width:80%;height:80%;padding:10px;">
		 
</div>

<script type="text/javascript">
    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var node = $('#userList').datagrid('getSelected');
        	if(!node){
        		$.messager.alert('提示','必须选择一行数据才能编辑!');
        		return ;
        	}
        	
        	//弹出编辑框
        	$("#editUserWindow").window({
        		onLoad : function(){
        			if(node.sex){
        				node.sex = "男";
        			}else if(node.sex == false){
        				node.sex = "女";
        			}
        			node.birthday = formatterDate(node.birthday);
        			//数据回显
        			$("#userEditForm").form("load",node);
        		}
        	}).window('open');
        	
        	//修改保存
        	
        	//刷新数据表格
        	
        	//关闭编辑框
        	
        }
    },'-',{
        text:'删除',
        iconCls:'icon-remove',
        handler:function(){alert('save')}
    },'-',{
        text:'导出',
        iconCls:'icon-print',
        handler:function(){
        	$("<form>").attr({
        		"action":"/user/export",
        		"method":"get"
        	}).submit();
        }
    }];
    
    function formatterSex(value,row){
    	if(value == null){
    		return "未知";
    	}
    	if(value){
    		return "男";
    	}
    	return "女";
    }
    
    function formatterDate(value,row){
    	return new Date(value).format("yyyy-MM-dd hh:mm:ss");
    }
</script>