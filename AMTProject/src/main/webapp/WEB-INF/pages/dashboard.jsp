<%@include file="includes/header.jsp" %>
<div id="dashboard-menu">
<h3><a href="dashboard">Apps</a></h3>
<h3><a href="account">Account</a></h3>
</div>
<div class="container-fluid" id="dashboard-content">
    <div class="logged-in-bar">
        Logged in as ???
        <a class="btn btn-warning">Logout</a>
    </div>
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

        <tr>
            <td>My App</td>
            <td>This app is great</td>
            <td>23jrh2k3jhk23h</td>
            <td>10203</td>
            <td><a class="btn btn-sm btn-primary">Edit</a> <a class="btn btn-sm btn-success">Enable</a></td>
        </tr>

        <tr>
            <td>CoolApp 2.0</td>
            <td>The coolest App ever!</td>
            <td>v8wkq3j9sk39djwl</td>
            <td>4</td>
            <td><a class="btn btn-sm btn-primary">Edit</a> <a class="btn btn-sm btn-danger">Disable</a></td>
        </tr>
    </table>

  <%@include file="includes/footer.jsp" %>
