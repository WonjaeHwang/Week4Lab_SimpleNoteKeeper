<%-- 
    Document   : viewnote
    Created on : Feb 5, 2021, 11:16:54 PM
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
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        
        <h3>Title:</h3> ${Note.title}
        <h3>Contents:</h3>${Note.content}<br>
        
        <a href="note?edit" >Edit</a>

    </body>
</html>
