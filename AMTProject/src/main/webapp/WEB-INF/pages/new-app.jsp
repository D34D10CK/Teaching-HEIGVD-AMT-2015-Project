<%@include file="includes/header.jsp" %>
<div class="container">
    <h1 class="text-center">Register New App</h1>
    <form class="form-horizontal" method="post" action="new-app">
        <div class="form-group">
            <label for="input-name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="input-name" placeholder="Name" name="name">
            </div>
        </div>
        <div class="form-group">
            <label for="input-description" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="6" id="input-description" placeholder="Description" name="description"></textarea>
            </div>
        </div>
        
        <div class="form-group">
            <label for="input-api-key" class="col-sm-2 control-label">API Key</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="input-api-key" value="${apiKey}" name="apiKey" readonly="readonly">
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

