<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理系统 - 传智博客</title>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css">
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:60px;padding:10px;background-color:#e6efff ">用户管理系统</div>
	<div data-options="region:'west',split:true,title:'菜单'" style="width:200px;">
		
		<div class="easyui-accordion" style="height:300px;">
        <div title="用户管理" data-options="" style="overflow:auto;padding:5px;">
        	<ul id="myTree" class="easyui-tree">
	            <li>
	                <span>用户管理</span>
	                <ul>
	                    <li data-options="link:'/page/user-add'">
	                        <span>添加用户</span>
	                    </li>
	                    <li data-options="link:'/page/user-list'">
	                        <span>查询用户</span>
	                    </li>
	                    <li>
	                        <span>搜索用户</span>
	                    </li>
	                    <li>
	                        <span>管理用户</span>
	                    </li>
	                </ul>
	            </li>
	        </ul>
        </div>
        <div title="系统管理" style="padding:10px;">
            	
        </div>
        <div title="安全管理" style="padding:10px;">
            
        </div>
    </div>
	
	</div>
	<div data-options="region:'center'">
	 <div id="myTabs" class="easyui-tabs" data-options="border:false" style="width:100%;">
        <div title="首页" style="padding:10px">
            <p style="font-size:14px">欢迎使用用户管理系统，如需帮助请拨打10086.</p>
        </div>
    </div>
	</div>
<script type="text/javascript">
	//左侧菜单树添加事件
	$(function(){
		$('#myTree').tree({
			onClick: function(node){
				 if ($('#myTabs').tabs('exists', node.text)){ 
			         $('#myTabs').tabs('select', node.text); 
			     } else {
		    	 $('#myTabs').tabs('add',{
			            title: node.text,
			            href: node.link,
			            closable: true,
			            height:'auto'
			        });
			     }
			}
		});
	});
</script>
</body>
</html>