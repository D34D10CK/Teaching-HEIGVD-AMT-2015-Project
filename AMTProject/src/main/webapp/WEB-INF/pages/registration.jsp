<%@include file="includes/header.jsp" %>
<div class="container">
    <h1 class="text-center">Registration</h1>
    <form class="form-horizontal">
        <div class="form-group">
            <label for="input-email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="input-email" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="input-first-name" class="col-sm-2 control-label">First Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="input-first-name" placeholder="First Name">
            </div>
        </div>
        <div class="form-group">
            <label for="input-last-name" class="col-sm-2 control-label">Last Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="input-last-name" placeholder="Last Name">
            </div>
        </div>
        <div class="form-group">
            <label for="input-password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="input-password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <label for="input-password-confirm" class="col-sm-2 control-label">Confirm Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="input-password-confirm" placeholder="Confirm Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-warning">Cancel</button>
                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </div>
    </form>
<%@include file="includes/footer.jsp" %>