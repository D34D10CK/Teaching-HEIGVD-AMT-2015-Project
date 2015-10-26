<%@include file="includes/header.jsp" %>
<%@include file="includes/dashboard-menu.jsp" %>
    <h1 class="text-center">Your Apps</h1>
    <div class="text-center"><a href="new-app" class="btn btn-primary">Register New App</a></div>

    <table class="table table-hover">
        <tr>
            
            <th>Name</th>
            <th>Descrition</th>
            <th>API Key</th>
            <th>Users</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${apps}" var="app">
            <tr>
                <td>${app.name}</td>
                <td>${app.description}</td>
                <td>${app.apiKey}</td>
                <td><a href="list-users?id=1">10203</a></td>
                <td><a href="app-details?action=edit&appId=${app.id}" class="btn btn-sm btn-primary">Edit</a> <a class="btn btn-sm btn-success">Enable</a></td>
            </tr>
        </c:forEach>

    </table>

  <%@include file="includes/footer.jsp" %>
