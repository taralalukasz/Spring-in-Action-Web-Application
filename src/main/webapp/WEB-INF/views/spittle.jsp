<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

Here we have the single spittle from path variable
<div class="spittleMessage">
    <c:out value="${spittle.message}" />
</div>
<div>
    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
</div>
</div>
