<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title></title>
</head>
<body>
<%
	String err=request.getParameter("err");
%>
	<div id="container">
		<form action="<%=request.getContextPath() %>/login.do" method="post">
			<div id="userName">
				<label for="userName">�ʺ�</label>
				<input type="text" name="userName" value=""/>
			</div>
			<div id="password">
				<label for="password">����</label>
				<input type="password" name="password" value=""/>
			</div>
			<div id="err">
				<%if(err!=null) out.println("��������ʺŻ����������"); %>
			</div>
			<div id="button">
				<input type="submit" name="login" value="��¼"/>
			</div>
		</form>
		��û����ǿͨ��֤ô���Ǿ�<a href="http://passport.ziqiang.net" target="_parent">ע��</a>��
	</div>
</body>
</html>