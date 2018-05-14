<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#import "/spring.ftl" as spring />
<@security.authentication property="principal.id" var="userId" scope="page" />



<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="<@spring.url "/" />">BOOKING TICKETS</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Actions <span class="caret"></span></a>
                                <ul class="dropdown-menu">

                                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                                        <li><a href="<@spring.url "/users" />">Users</a>
                                        </@security.authorize>

                                    <li><a href="<@spring.url "/events" />">Events</a>
                                    </li>
                                    <li><a href="<@spring.url "/auditoriums" />">Auditoriums</a>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Tickets for event</a>
                                    </li>
                                    <li><a href="<@spring.url "/booking/ticketsforuser?userId=${userId}" />">My tickets</a>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Get ticket price</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
<#--                        <form class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>-->
                        <ul class="nav navbar-nav navbar-right">
                            <form action="/logout" method="post">
                                <button type="submit" class="btn btn-link btn-logout">Logout</button>
                            </form>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-fluid -->
            </nav>
        </div>
    </div>