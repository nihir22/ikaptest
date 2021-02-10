<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Alumni Portal Login</title>
        <link rel="stylesheet" type="text/css" media="all" href="css/styles.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <div class="container text-center"><a href=#> <img alt="Logo" src="images/iitkgp_logo.png" class="logo"> </a></div>

        <h1>Alumni Portal </h1>
        <div class="container-fluid">
            <div class="slide">
                <div class="w3-content w3-section" style="max-width:1150px">
                    <img class="mySlides" src="images/slide1.png" style="width:100%">
                    <img class="mySlides" src="images/slide2.jpg" style="width:100%">
                    <img class="mySlides" src="images/slide3.jpg" style="width:100%">
                    <img class="mySlides" src="images/slide4.jpg" style="width:100%">
                    <img class="mySlides" src="images/slide5.jpg" style="width:100%">
                    <img class="mySlides" src="images/slide6.png" style="width:100%">
                    <img class="mySlides" src="images/slide7.png" style="width:100%">
                    <img class="mySlides" src="images/slide8.png" style="width:100%">
                </div>
            </div>
            <div class="login"><form method="post" action="login">
                    <h6>Please enter your roll number as "Login Id" and date of birth in DDMMYYYY format as "Password" to login.</h6>
                    <span style="color:red;">${param.error }</span>
                    <h4>LOGIN ID:</h4><input type="text" placeholder="Roll No." name="alum_roll"><br>
                    <h4>PASSWORD: </h4><input type="password" placeholder="Date of birth(ddmmyyyy)" name="alum_dob" id="myInput"><br><br>
                    <input type="checkbox" onclick="myFunction()">
                    <input type="submit" value="Login" class="btn"></form><br>
                <div class="reg">
                    <form method="post" action="register.jsp">
                        <input type="submit" class="btn" value="Register">
                    </form></div>
            </div>
        </div>
        <script>
            var myIndex = 0;
            carousel();

            function carousel() {
                var i;
                var x = document.getElementsByClassName("mySlides");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                myIndex++;
                if (myIndex > x.length) {
                    myIndex = 1;
                }
                x[myIndex - 1].style.display = "block";
                setTimeout(carousel, 5000); // Change image every 5 seconds
            }

            function myFunction() {
                var x = document.getElementById("myInput");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
    </body>
</html>
