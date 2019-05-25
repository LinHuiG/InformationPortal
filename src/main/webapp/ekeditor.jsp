<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body style="width: 100%">
<div style="">
    <script type="text/javascript"src="ckeditor/ckeditor.js"></script>
    <form method="post" action="get.jsp" >
        <h2>标题:<input type="text" id="title1" name="title1" style="width:800px;height:35px"></h2>
        <p><input type="radio" name="partof" value="pat" /> pat</p>
        <p><input type="radio" name="partof" value="Car" checked="checked" />car</p>
        <p><input type="radio" name="partof" value="pat2" checked="checked" /> pat2</p>
    <textarea name="editor1" id="editor1" rows="10" cols="80">

    </textarea>
        <input type="submit" onclick="">
        <script>
            CKEDITOR.replace( 'editor1',  {
                //'kama', 'v2', 'office2003'
                height : 600,
                width : 1000
            });
        </script>
    </form>
</div>

</body>
</html>