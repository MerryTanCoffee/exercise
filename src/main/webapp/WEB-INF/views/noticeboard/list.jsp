<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1>공지사항 게시판</h1>
			</div>
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="#">DDIT HOME</a></li>
					<li class="breadcrumb-item active">공지사항 게시판</li>
				</ol>
			</div>
		</div>
	</div>
</section>


<table class = "table table-bordered">
	<thead>
		<tr>
			<th style="width: 6%">#</th>
			<th style="width: px">제목</th>
			<th style="width: 12%">작성자</th>
			<th style="width: 12%">작성일</th>
			<th style="width: 10%">조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:set var = "noticeList" value = "${pagingVO.dataList }"/>
		<c:choose>
			<c:when test ="${empty noticeList }">
				<tr>
					<td colspan="5">조회한 게시글이 존재하지 않습니다</td> 
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${noticeList }" var="notice">
					<tr>
						<td>${notice. }</td>
						<td><a href = "/notice/detail.do?boNo=${notice.boNo }">${notice.boTitle }</a></td>
						<td>${notice. }</td>
						<td>${notice. }</td>
						<td>${notice. }</td>
					
					
					</tr>
					
				</c:forEach>
			</c:otherwise>	
		</c:choose>
	</tbody> 
</table>