<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="false"%>

<script>
alert("사진 업로드 성공")
//var result    = '${savedName}';
//var delResult = '${delResult}';
var result    = '${delResult}';
alert("delResult->"+delResult);
parent.addFilePath(result); /* 얘가 upLoadFormStart.jsp의 addFilePath(msg)로 감. */

</script>

