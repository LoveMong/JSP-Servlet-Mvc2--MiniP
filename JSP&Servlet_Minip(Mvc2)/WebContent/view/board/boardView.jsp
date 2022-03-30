<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
table th {
text-align: center;
}
</style>
<body>
	<jsp:include page="/view/common/header.jsp"></jsp:include>

	<div id="wrap" align="center">
		<h2 style="margin-bottom: 50px">게시글 상세 보기</h2>
	   		 <table>
				<tr>
					<th>작 성 자</th>
					<td>${board.name}</td>
					<th>이 메 일</th>
					<td>${board.email}</td>
				</tr>
			    <tr>
					<th>작 성 일</th>
					<td><fmt:formatDate value="${board.writeDate}"/></td>
					<th>조 회 수</th>
					<td>${board.readCount}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="3">${board.title}</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="3"><pre>${board.content}</pre></td>
				</tr>
			</table>
			<br><br><input type="button" value="수정" onclick="open_win('/board/check_pass.do?num=${board.num}', 'update')">
				<input type="button" value="삭제" onclick="open_win('/board/check_pass.do?num=${board.num}', 'delete')">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type="button" value="등록" onclick="location.href='write.do'">
				
	</div>
	
	<jsp:include page="/view/common/footer.jsp"></jsp:include>
</body>
</html>
