<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<base href='<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="./css/common-neptune.css" />
<link rel="stylesheet" type="text/css" href="./extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
<!-- 
<link rel="stylesheet" type="text/css" href="./css/common.css" />
<link rel="stylesheet" type="text/css" href="./extjs/resources/ext-theme-classic/ext-theme-classic-all.css" />
-->
<script type="text/javascript" charset="utf-8" src="./extjs/ext-all.gzjs"></script>
<script type="text/javascript" charset="utf-8" src="./extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8">

Ext.onReady(function(){
	
	Ext.MessageBox.alert('提示信息','Welcome to ExtJS World!!');
	Ext.create('Ext.Button',{
	    text: '退出',
        renderTo :Ext.getBody(),
	    handler : function () {
            window.location = "https://www.yancy.com:8443/cas/logout";
        }
    });
	
});

</script>

</head>
<body>
</body>
</html>