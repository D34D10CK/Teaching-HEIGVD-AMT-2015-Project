<%@include file="includes/header.jsp" %>

    <div class="container">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" >
                    <c:if test="${not empty error}">
                            <span class="btn btn-danger navbar-btn navbar-left">${error}</span>
                        </c:if>
                    <form class="navbar-form navbar-left" method="post" action="home">
                        <input type="text" class="form-control" placeholder="Username" name="username" value="${prevUsername}">
                        <input type="password" class="form-control" placeholder="Password" name="password">
                        <input type="submit" class="btn btn-default">
                    </form>
                        
                    <a href="registration" class="navbar-right btn btn-default navbar-btn">create account</a>
                </div>
            </div>
        </nav>

        <h1 class="text-center">Welcome to GamY!</h1>
        <p>${accountCreated} accounts created</p>
        <p>${applicationManaged} applications managed</p>
        <p>${userByApp} users created by applications during the last 30 days</p>
        
<%@include file="includes/footer.jsp" %>

