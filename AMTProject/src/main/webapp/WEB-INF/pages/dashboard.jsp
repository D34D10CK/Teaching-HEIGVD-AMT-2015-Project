<%@include file="includes/header.jsp" %>
<%@include file="includes/dashboard-menu.jsp" %>
    <h1 class="text-center">Your Apps</h1>
    <div class="text-center"><a href="new-app" class="btn btn-primary">Register New App</a></div>

    <table class="table table-hover">
        <tr>
            <th>${name} </th>
            <th>Name</th>
            <th>Descrition</th>
            <th>API Key</th>
            <th>Users</th>
            <th>Actions</th>
        </tr>

        <tr>
            <td>My App</td>
            <td>This app is great</td>
            <td>23jrh2k3jhk23h</td>
            <td><a href="list-users?id=1">10203</a></td>
            <td><a href="app-details" class="btn btn-sm btn-primary">Edit</a> <a class="btn btn-sm btn-success">Enable</a></td>
        </tr>

        <tr>
            <td>CoolApp 2.0</td>
            <td>The coolest App ever!</td>
            <td>v8wkq3j9sk39djwl</td>
            <td><a href="list-users?id=2">4</a></td>
            <td><a href="app-details" class="btn btn-sm btn-primary">Edit</a> <a class="btn btn-sm btn-danger">Disable</a></td>
        </tr>
    </table>

  <%@include file="includes/footer.jsp" %>
