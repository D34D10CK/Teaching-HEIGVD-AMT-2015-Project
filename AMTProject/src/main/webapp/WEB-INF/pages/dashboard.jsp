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
                <td>${app.apiKey.apiKey}</td>
                <td><a href="list-users?appId=${app.id}&page=0">${app.endUsers.size()}</a></td>
                <td><a href="#" class="btn btn-sm btn-primary">Edit</a> <a data-id="${app.id}" data-is-enable="true" class="btn btn-sm btn-success enable-button">Enable</a></td>
            </tr>
        </c:forEach>

    </table>

<script src="static/js/fetch.js"></script>
<script src="static/js/enable-button.js"></script>
  <%@include file="includes/footer.jsp" %>
