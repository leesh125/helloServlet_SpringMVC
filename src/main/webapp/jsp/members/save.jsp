<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    // GET의 쿼리 스트링이든, HTML form의 post 방식이든 파라미터를 읽어올 수 있음
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); // request.getParameter의 응답결과는 항상 문자열(변환이 필요)

    Member member = new Member(username, age); // 파라미터로 불러온 값으로 멤버 객체 생성
    memberRepository.save(member); // 멤버 객체 저장
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>

