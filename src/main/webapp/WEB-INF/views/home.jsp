<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<script type="text/javascript">
 
$(document).ready(function(){
 $("#msgid").html("This is Hello World by JQuery");
});
 
</script>
<div id="msgid">
</div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
