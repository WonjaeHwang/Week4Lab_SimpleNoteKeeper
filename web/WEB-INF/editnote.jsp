<%-- 
    Document   : editnote
    Created on : Feb 5, 2021, 11:17:14 PM
    Author     : 833989
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper!</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <h3>title:<input type="text" name="editTitle" value="${edit.title}"></h3>
            <h3>Contents:</h3><textarea name="editContent" value="${edit.contents}"></textarea>
                
        <input type="submit" value="Save">
        </form>
    </body>
</html>
