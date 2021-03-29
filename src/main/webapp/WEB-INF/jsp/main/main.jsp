<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
	Hello world!  / Main
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>
	<form action="">
		<select id="serverId" name="serverId">
			<option value="1">서버명1</option>
			<option value="2">서버명2</option>
			<option value="3">서버명3</option>
			<option value="4">서버명4</option>
			<option value="5">서버명5</option>
			<option value="6">서버명6</option>
			<option value="7">서버명7</option>
			<option value="8">서버명8</option>
			<option value="9">서버명9</option>
			<option value="10">서버명10</option>
		</select>
		<input type="text" id="serverName" name="serverName" maxlength="10">
		<input type="submit" id="searchBtn" name="searchBtn" value="검색">
	</form>
</div>