<%@ page import = " java.util.* " %>
        <div class="container">
            <div class="hero-unit">
                <h1><img src="https://s3.amazonaws.com/cdn.freshdesk.com/data/helpdesk/attachments/production/6000441619/logo/k68pEIS95R2nxQjoEu3NlXZmeizE70Y10Q.png"> Sample Java App</h1>
                <hr>
                <h2>Congratulations!</h2>
                <p>Your Java application is now running on the host &ldquo;<%= java.net.InetAddress.getLocalHost().getHostName() %>&rdquo; in your own dedicated environment in the AWS&nbsp;Cloud.</p>
                <p>This host is running Java version <%= System.getProperty("java.version") %>.</p>
		<%
		if(session.getAttribute("root360-java-app-visits") == null) {
			session.setAttribute("root360-java-app-visits", 0);
		%>
		This is the first time you're visiting this server.
		<%
		} else {
		%>
		Your number of vists: <%= session.getAttribute("root360-java-app-visits") %>
		<%
		}
		session.setAttribute("root360-java-app-visits", (int) session.getAttribute("root360-java-app-visits") + 1);
		%>
		</br></br>
    		Server IP: <%= request.getLocalAddr() %></br>
		Client IP: <%= request.getRemoteAddr() %></br>
    		Cookies:</br>
		<%
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if( cookies != null ) {
			out.println("<ul>");
			for (int i = 0; i < cookies.length; i++) {
			      cookie = cookies[i];
			%>
			<li><%= cookie.getName() %> = <%= cookie.getValue() %> <br/>
			<%
			}
			out.println("</ul>");
		} else {
		%>
			<h2>No cookies founds</h2>"
		<%
		}
		%>
<hr>
<p>Hier gehts zum <a href="https://root360.atlassian.net/wiki/spaces/KBDE/pages/66153456/Schnelleinstieg" target="_blank">root360 Quickstart</a></p>
<p>See <a href="https://root360.atlassian.net/wiki/spaces/KB/pages/66154327/Quickstart" target="_blank">root360 Quickstart</a></p>
<hr>
<script type="text/javascript" src="http://assets.freshdesk.com/widget/freshwidget.js"></script>
<style type="text/css" media="screen, projection">
	@import url(http://assets.freshdesk.com/widget/freshwidget.css);
</style>
<iframe title="Feedback Form" class="freshwidget-embedded-form" id="freshwidget-embedded-form" src="https://root360.freshdesk.com/widgets/feedback_widget/new?&widgetType=embedded&screenshot=no&searchArea=no" scrolling="no" height="900px" width="100%" frameborder="0" >
</iframe>

</div>
<%@ include file="/WEB-INF/templates/includes/footer.jsp"%>
