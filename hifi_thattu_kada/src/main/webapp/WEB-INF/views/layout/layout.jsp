<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>hifi_thattu_kada</title>

<!--  header add-ons -->
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/header.css" />

<!-- header add-ons ends here -->
<style type="text/css">

#banner{
	position: relative;
	top: 0;
	width: 100%;
	height: 50px;
	padding-bottom: 100px;	
}

#content{
position:relative;
/* padding-bottom: 350px; */
}

#bottom{

	 color: #000;
     font-size: 12px;
     font-family: Verdana, Geneva, Arial, sans-serif;
     background-color: #EBE8E8;   
     text-align: center;
     position: absolute;
     bottom: 0px;
     left: 0px;
     width: 100%;
     height: 28px
	
}
</style>

</head>
<body>
	<div id="banner"> 
		<tiles:insertAttribute name="header" /><br/>		
	</div>
	<div id="content">
		<tiles:insertAttribute name="body" />
	</div>			
	<div id="bottom" >	
		<tiles:insertAttribute name="footer" />	
	</div>			
</body>

</html>
