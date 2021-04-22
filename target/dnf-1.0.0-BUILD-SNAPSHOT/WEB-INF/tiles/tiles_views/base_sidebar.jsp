<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Sidebar -->
<div id="sidebar">

    <!-- Logo -->
    <h1 id="logo">
        <a href="/">OGMALOAN</a>
    </h1>

    <!-- Search -->
    <section class="box search">
        <div>
            <form method="post" action="#">
                <input type="text" class="inputText" placeholder="Search" maxlength="6">
                <input type="submit" class="searchBtn" value="캐릭터 검색">
            </form>
        </div>
    </section>

    <!-- Nav -->
    <nav id="nav">
        <ul>
            <li>
                <a href="#"><span class="side_menu">캐릭터</span></a>
                <ul>
                    <li>1</li>
                    <li>1</li>
                    <li>1</li>
                </ul>
            </li>
            <li>
                <a href="#"><span class="side_menu">장비</span></a>
            </li>
            <li>
                <a href="#"><span class="side_menu">게시판</span></a>
            </li>
            <li>
                <a href="#"><span class="side_menu">로그인</span></a>
            </li>
        </ul>
    </nav>

    <section class="side_footer">
        <!-- Copyright -->
        <ul id="copyright">
            <li>© Ogmaloan ALL RIGHTS RESERVED.</li>
        </ul>

        <%-- OPEN API --%>
        <ul id="apiLink">
            <li>
                <a href="https://developers.neople.co.kr" target="_blank" class="api">
                    <i class="lightgray">Powered by</i>&nbsp;<i class="yellow">Neople</i>&nbsp;<i class="gray">OpenAPI</i>
                </a>
            </li>
        </ul>
    </section>
</div>

<%-- Titlebar --%>
<div id="titleBar">
    <a href="#sidebar" class="toggle"></a>
    <span class="title">
        <a href="#">OGMALOAN</a>
    </span>
</div>

<script>
    $(function() {
        $(".toggle").click(function() {
            var $body_class = $('body').attr('class');
            if ($body_class == "" || $body_class == null) {
                $('body').addClass('sidebar-visible');
            } else {
                $('body').removeClass('sidebar-visible');
            }
        });
    });
</script>