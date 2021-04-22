<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"    uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div>
	<div>
		<div>
			<button type="button" id="updateServerBtn" name="updateServerBtn">서버목록 업데이트</button>
		</div>
		<div>
			<button type="button" id="updateJobBtn" name="updateJobBtn">직업목록 업데이트</button>
		</div>
		<!-- 서버 목록 시작 -->
		<div>
			<form name="searchServerForm" action="/character/search">
				<select id="serverId" name="serverId">
					<c:forEach var="serverList" items="${serverList}" varStatus="index">
						<option value="<c:out value='${serverList.serverId}'/>">${serverList.serverName}</option>
					</c:forEach>
				</select>
				<input type="text" id="characterName" name="characterName">
				<input type="submit" id="searchServerBtn" name="searchServerBtn" value="검색">
			</form>
		</div>
		<!-- 서버 목록 종료 -->
		
	</div>
</div>

<script>
	$(function() {
		/* 서버목록 업데이트 */
		$("#updateServerBtn").click(function () {
			console.log("click");
			$.ajax({
				type : "POST",
				url : "/cmm/updateServer",
				success : function(data) {
					console.log("서버목록 가져오기 성공!");
				},
				error : function (xhr, status, error) {
					console.log("서버목록 가져오기 실패!");
				}
			});
		});

		/* 직업목록 업데이트 */
		$("#updateJobBtn").click(function () {
			console.log("click");
			$.ajax({
				type : "POST",
				url : "/cmm/updateJob",
				success : function(data) {
					console.log("직업목록 가져오기 성공!");
				},
				error : function (xhr, status, error) {
					console.log("직업목록 가져오기 실패!");
				}
			});
		});
	});
</script>