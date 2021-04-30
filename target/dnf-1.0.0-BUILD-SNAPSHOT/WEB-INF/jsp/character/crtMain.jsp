<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"    uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div id="content">
    <div class="inner">
        <div class="top">
            <div class="search_box">
                <select style="width: 100px; height: 30px; border: none; margin-right: 10px;">
                    <option value="all">전체</option>
                    <option value="all2">전체2</option>
                </select>
                <input type="text" style="width: 200px; height: 30px; border: none; margin-right: 10px;">
                <input type="submit" value="검색">
                <button type="button" class="toggleBtn">+</button>
            </div>
            <div class="search_detail_box">
                <select>
                    <option value="1">1</option>
                    <option value="2">2</option>
                </select>
                <select>
                    <option value="1">1</option>
                    <option value="2">2</option>
                </select>
            </div>
        </div>
    </div>
</div>

<script>
    $(function() {
        $(".toggleBtn").click(function(){
            $(this).removeClass('on');
            $(".search_detail_box").slideToggle('fast');
            $(this).toggleClass('on');
        });
    });
</script>