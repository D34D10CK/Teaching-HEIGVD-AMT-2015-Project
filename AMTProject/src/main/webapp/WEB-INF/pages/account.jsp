<%@include file="includes/header.jsp" %>
<%@include file="includes/dashboard-menu.jsp" %>
    <h1 class="text-center">Edit Account Details</h1>
    <form class="form-horizontal" method="post" action="account">
        <div class="form-group">
            <label for="input-email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="input-email" placeholder="Email" name="email"  readonly="readonly" value="${user.email}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input-first-name" class="col-sm-2 control-label" >First Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="input-first-name" placeholder="First Name" name="first-name" value="${user.firstName}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input-last-name" class="col-sm-2 control-label">Last Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="input-last-name" placeholder="Last Name" name="last-name" value="${user.lastName}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input-password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="input-password" placeholder="Password" name="password" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input-password-confirm" class="col-sm-2 control-label">Confirm Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="input-password-confirm" placeholder="Confirm Password" name="password-confirm" required="required">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a href="dashboard" class="btn btn-warning">Cancel</a>
                <button type="submit" class="btn btn-primary">Edit</button>
            </div>
        </div>
    </form>
    <script src="static/js/account.js"></script>
    <%@include file="includes/footer.jsp" %>

