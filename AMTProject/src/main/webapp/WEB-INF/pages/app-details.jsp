<%@include file="includes/header.jsp" %>
<div class="container">
    <h1 class="text-center">App details</h1>
        <form class="form-horizontal" method="post" action="app-details">
            <div class="form-group">
                <label for="input-name" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="input-name" placeholder="Name" value="${app.name}" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="input-description" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="6" id="input-description" placeholder="Description" name="description">${app.description}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="input-api-key" class="col-sm-2 control-label">API Key</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="input-api-key" value="${apiKey.apiKey}" name="apiKey" readonly="readonly">
                </div>
                
                <input type="hidden" name="id" value="${app.id}">
                <input type="hidden" name="idApiKey" valeu="${apiKey.id}">
            </div>
            <div class="form-group">
                <label for="input-users" class="col-sm-2 control-label">Number of users</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="input-users" value="???" name="api-key" disabled="disabled">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Change State</label>
                <div class="col-sm-10">
                    <a class="btn btn-success">Enable</a>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="dashboard" class="btn btn-warning">Cancel</a>
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </div>
        </form>
    <%@include file="includes/footer.jsp" %>

