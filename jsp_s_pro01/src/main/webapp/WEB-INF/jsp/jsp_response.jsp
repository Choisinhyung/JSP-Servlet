<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP/Servlet - Response 객체</title>
</head>
<body>
	<h1>JSP/Servlet - Response 객체</h1>
	<h2>sendRedirect(String url)</h2>
	<%
		//response.sendRedirect("./");
	%>
	<p>
		클라이언트에게 다른 주소로 재요청을 하게 만들기 위해 사용하는 기능
		HTML meta tag로 refresh했던 것과 비슷하다. 일정 시간 or 즉시 url주소로 이동이 되게 만드는 것이랑 동일
		HTML 상태코드 : 302
	</p>
	<hr>
	<h2>setStatus(int statusCode)</h2>
	<%
		//response.setStatus(HttpServletResponse.SC_ACCEPTED); 
		//response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
	%>
	<p>
	상태 코드를 설정하는 기능, 원하는 상태코드로 변경 가능. 가급적이면 직접 int값을 쓰기보다는 함수를 이용하는게 오류 발생확률이 적다
	주소 검색창에 http status code 검색 후 mozilla사이트에 들어가서 확인 가능하다. 브라우저마다 다름
	다 알필요는 없고 200 0k (정상)코드와 302(redirect) / 400 401 403 404 405 500 코드만 알고 있어도 됨
	</p>
	<hr>
	<h2>setError(int statusCode)</h2>
	<% 
		//response.sendError(HttpServletResponse.SC_NOT_FOUND); 
		//response.sendError(HttpServletResponse.SC_NOT_FOUND, "잘못된 URL 주소로 요청 하였습니다."); 
		//response.send
	%>
	<p>
	</p>
	<hr>
	<h2>setContentType(String mimeType)</h2>
	<%
		//response.setContentType("text/javascript")
	%>
	<p>
		contentType을 브라우저에게 알려주는 것 / 즉, 타입 지정 / 브라우저가 내가 공유하는 컨텐츠를 어떤 걸로 인식할건지.
		ajax 배울때 사용 . json형식의 데이터를 알려주기위해 설정 / 지금은 안해!
	</p>
	<hr>
</body>
</html>