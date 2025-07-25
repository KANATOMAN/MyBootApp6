<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>図書登録</title>
</head>
<body>
    <h1>図書登録フォーム</h1>
    <p>このページはSpring Bootのサンプルです。</p>

    <!-- メッセージ表示 -->
    <p><%= request.getAttribute("msg") %></p>

    <!-- 登録フォーム -->
    <form method="post" action="/post">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID<span style="color:red">*</span>：</td>
                <td><input type="text" name="id" required /></td>
            </tr>
            <tr>
                <td>タイトル：</td>
                <td><input type="text" name="title" /></td>
            </tr>
            <tr>
                <td>著者：</td>
                <td><input type="text" name="writter" /></td>
            </tr>
            <tr>
                <td>出版社：</td>
                <td><input type="text" name="publisher" /></td>
            </tr>
            <tr>
                <td>価格：</td>
                <td><input type="text" name="price" /></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="登録" />
    </form>
</body>
</html>
