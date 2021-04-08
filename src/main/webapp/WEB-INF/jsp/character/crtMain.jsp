<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
	<h1>crtMain</h1>
</div>

<div>
	<div>
		<!-- 서버 목록 시작 -->
		<div>
			<form name="searchForm" action="/character/search">
				<select id="serverId" name="serverId">
					<c:forEach var="serverList" items="${serverList}" varStatus="index">
						<option value="${serverList.serverId}" <c:if test="${serverList.serverId eq serverVO.serverId}">selected</c:if>>${serverList.serverName}</option>
					</c:forEach>
				</select>
				<input type="text" id="characterName" name="characterName" value="${characterVO.characterName}">
				<input type="submit" id="searchBtn" name="searchBtn" value="검색">
			</form>
		</div>
		<!-- 서버 목록 종료 -->
		
	</div>
</div>