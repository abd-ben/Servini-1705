<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="robots" content="noindex,nofollow" />
<title>Programmers sample guide, help is on the way</title>
<link rel="stylesheet" href="/resources/themes/master.css"
	type="text/css" />
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<script src="apps.js" type="text/javascript"></script>

</head>

<body>
	<div id="allContent">

		<div id="myExample">
			<form id="myAjaxRequestForm" method="post">
				<fieldset>
					<legend>jQuery getJSON() example using Java Servlets and
						MySQL database</legend>

					<p>
						<label >Country Code:</label><br /> <input
							id="countryCode" type="text"  />
					</p>
					<p>
						<input id="myButton" type="button" value="Submit" />
					</p>
				</fieldset>
			</form>
			<div >
				<fieldset>
					<legend>Response from jQuery getJSON() Request</legend>
					<div id="ajaxResponse"></div>
				</fieldset>
			</div>
		</div>

	</div>
</body>
</html>