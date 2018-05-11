<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
</head>
<body>


<style>

</style>

<h1>Welcome</h1>

<@security.authorize access="isAuthenticated()">
    logged in as <@security.authentication property="principal.username" />
</@security.authorize>

</body>
</html>