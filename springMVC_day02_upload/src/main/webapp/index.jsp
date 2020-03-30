<%--
  Created by IntelliJ IDEA.
  User: wmj
  Date: 2020/3/6
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>文件上传</h2>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload" /><br/>
        <input type="submit" value="上传"/>
    </form>

    <h2>springmvc上传</h2>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload" /><br/>
        <input type="submit" value="上传"/>
    </form>

    <h2>跨服务器上传</h2>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload" /><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
