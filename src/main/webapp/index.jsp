<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<script type="text/javascript"src="ckeditor/ckeditor.js"></script>
<form method="post" action="get.jsp">
    <textarea name="editor1" id="editor1" rows="10" cols="80">
                阿萨德
    </textarea>
    <input type="submit" onclick="">
    <script>
        CKEDITOR.replace( 'editor1' );
    </script>
</form>
</body>
</html>