<#import "/spring.ftl" as spring />

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<@spring.url '/resources/css/bootstrap.css' />"  rel="stylesheet">
    <link href="<@spring.url '/resources/css/app.css' />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>


<div id="mainWrapper">
    <pre>
        admin@ad.com / ap                ROLE_ADMIN
        savand@gmail.com / password      ROLE_BOOKING_MANAGER
        d@com / p                        ROLE_REGISTERED_USER
        laory@yandex.ru / password2      ROLE_REGISTERED_USER
    </pre>
    <div class="login-container">
        <div class="login-card">
            <div class="login-form">

                <form action="<@spring.url "/login" />" method="post" class="form-horizontal">
                    <#if RequestParameters.error??>
                        <div class="alert alert-danger">
                            <p>Invalid username and password.</p>
                        </div>
                    </#if>

                    <#if RequestParameters.logout??>
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </#if>

                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                        <input type="email" class="form-control" id="username" name="email" placeholder="Enter Username" required>
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                    </div>

                    <#--<c:if test="${empty loginUpdate}">-->

                    <div class="checkbox">
                        <label><input type="checkbox" name="remember-me"> Remember me</label>
                    </div>
                <#--</c:if>-->

                    <div class="form-actions">
                        <input type="submit"
                               class="btn btn-block btn-primary btn-default" value="Log in">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>