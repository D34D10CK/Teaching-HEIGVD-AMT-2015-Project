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
                <td>${app[0].name}</td>
                <td>${app[0].description}</td>
                <td>${app[0].apiKey.apiKey}</td>
                <td><a href="list-users?appId=${app[0].id}&page=0">${app[1]}</a></td>
                <td><a href="app-details?action=edit&appId=${app[0].id}" class="btn btn-sm btn-primary">Edit</a>
                <c:if test="${app[0].enable}"><a href="app-details?action=disable&appId=${app[0].id}" data-id="${app[0].id}" data-is-enable="true" class="btn btn-sm btn-success enable-button">Enable</a></td></c:if>
                <c:if test="${!app[0].enable}"><a href="app-details?action=disable&appId=${app[0].id}" data-id="${app[0].id}" data-is-enable="true" class="btn btn-sm btn-danger enable-button">Disable</a></td></c:if>
            </tr>
        </c:forEach>
    </table>

<script src="static/js/fetch.js"></script>

  <%@include file="includes/footer.jsp" %>
