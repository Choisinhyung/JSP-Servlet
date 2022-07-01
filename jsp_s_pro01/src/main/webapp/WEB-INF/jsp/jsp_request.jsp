<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP/Servlet - request 객체</title>
</head>
<body>
	<h1>JSP/Servlet - request 객체</h1>
	<h2>getMethod()</h2>
	<p>
		request.getMethod() : <%=request.getMethod() %>
	</p>
	<form action="./jsp_request" method="get">
		<button type="submit">GET 전송</button>
	</form>
	<form action="./jsp_request" method="post">
		<button type="submit">POST 전송</button>
	</form>
	<hr>
	<h2>getParameter(name)</h2>
	<p>
		request.getParameter(name) : <%=request.getParameter("param_name") %><br>
		name 은 input 태그 등에 사용하는 name 속성의 값을 지칭한다.
	</p>
	<form action="./jsp_request" method="get">
		<div>
			<input type="text" name="param_name">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<hr>
	<h2>getParameterValues(name)</h2>
	<p>
		request.getParameterValues(name) : 
		<%
			if(request.getParameterValues("param_chk") != null) {
		%>
			<%=Arrays.asList(request.getParameterValues("param_chk")) %>
		<%
			}
		%>
		<br>
		name 은 input 태그 등에 사용하는 name 속성의 값을 지칭한다.
	</p>
	<form action="./jsp_request" method="get">
		<div>
			<input type="checkbox" value="a" name="param_chk">
			<input type="checkbox" value="b" name="param_chk">
			<input type="checkbox" value="c" name="param_chk">
			<input type="checkbox" value="d" name="param_chk">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<hr>
	<h2>getParameterNames()</h2>
	<p>
		request.getParameterNames() :
		<%
			Iterator<String> iter = request.getParameterNames().asIterator();
			while(iter.hasNext()) {
		%>
				<%=iter.next() %>
		<% } %>
		<br>
		input 태그 등에 사용하는 name 속성의 값을 반환한다.
	</p>
	<form action="./jsp_request" method="get">
		<div>
			<input type="text" name="username">
			<input type="text" name="password">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<h2>setCharacterEncoding()</h2>
	<p>
		<%=request.getParameter("username") %>
		request.setCharacterEncoding : 클라이언트에서 서버로 전송한 한글 데이터에 문제가 발생했을 때 servlet의 가장<br>
		첫 번째 줄에 적용을 하거나 Filter를 만들어 적용할 것. -> request.setCharacterEncoding("UTF-8")
	</p>
	<form action="./jsp_request" method="post">
		<div>
			<input type="text" name="username">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<hr>
	<h2>getSession()</h2>
	<p>
		세션 객체 : <%=request.getSession() %> <br>
		세션 id : <%=request.getSession().getId() %> <!-- 이 아이디는 개발자모드의 app탭 왼쪽 메뉴 cookies httplocalhost 아이디값이다. -->
	</p>
</body>
</html>