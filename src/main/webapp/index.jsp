<html>

<body>
<script type="text/javascript"src="ckeditor/ckeditor.js"></script>
<form method="post" action="get.jsp">
    <textarea name="editor1" id="editor1" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
    </textarea>

    <input type="submit">
    <script>
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace( 'editor1' );
    </script>
</form>
</body>
</html>