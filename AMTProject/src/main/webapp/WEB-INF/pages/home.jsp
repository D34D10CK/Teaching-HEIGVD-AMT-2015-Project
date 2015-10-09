<%@include file="includes/header.jsp" %>

    <div class="container">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <form class="navbar-form navbar-left">
                        <input type="text" class="form-control" placeholder="Username">
                        <input type="password" class="form-control" placeholder="Password">
                        <input type="submit" class="btn btn-default">
                    </form>
                    <a href="registration" class="navbar-right btn btn-default navbar-btn">create account</a>
                </div>
            </div>
        </nav>

        <h1 class="text-center">Welcome to GamY!</h1>
        <p>${requestScope.accountCreated} accounts created</p>
        <p>${requestScope.applicationManaged} applications managed</p>
        <p>${requestScope.userByApp} users created by applications during the last 30 days</p>
        
<%@include file="includes/footer.jsp" %>

