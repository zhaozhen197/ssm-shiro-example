<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FreeMarker Web</title>
</head>
<body>
<h1>Hello ${name} !</h1>


<#list users as user>
    ${user.username}<br>
</#list>

</body>
</html>
