<%@include file="includes/header.jsp" %>
<%@include file="includes/dashboard-menu.jsp" %>
    <h1 class="text-center">List User for "${appName}"</h1>

        <table class="table table-hover">
            <tr>
                <th>User ID</th>
                <th>Creation Date</th>
            </tr>
            
            <c:forEach items="${endUsers}" var="eu">
                <tr>
                    <td>${eu.userId}</td>
                    <td>${eu.dateCrea.getTime()}</td>
                </tr>
                
            </c:forEach>
            
        </table>
    <p>page ${page+1}/${nbPages}</p>
    
    
    <c:if test="${page > 0}"><a href="list-users?appId=${appId}&page=0">first page</a> <a href="list-users?appId=${appId}&page=${page -1}">previous</a> </c:if>
    <c:if test="${page < nbPages-1}"><a href="list-users?appId=${appId}&page=${page +1}">next</a> <a href="list-users?appId=${appId}&page=${nbPages-1}">last page </a></c:if>
        
    <%@include file="includes/footer.jsp" %>

