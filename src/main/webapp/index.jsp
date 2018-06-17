<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webjars/bootstrap/4.1.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Belépés</title>
    </head>
    <body>

        <br/>
    <center>
        <form action="LoginController" method="post">
            <h2>Munkaidő nyilvántartó rendszer</h2>
            <br/>
            <input type="text" size="15" maxlength="12" placeholder="Felhasználónév" name="uname" required autofocus >
            <br/>
            <input type="password" size="15" maxlength="12" placeholder="Jelszó" name="pwd" required >
            <br/>
            <br/>
            <input type="submit" value="Belépés" />

        </form>

        <br/>
        <font color="red"> ${Hiba} </font>
    </center>

</body>
</html>
