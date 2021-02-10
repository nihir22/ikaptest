
<!doctype html>
<html lang="en-US">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Alumni Portal Registration</title>
        <link rel="stylesheet" type="text/css" media="all" href="css/styles.css">
    </head>


    <body>
        <div class="container text-center"><a href=#> <img alt="Logo" src="images/iitkgp_logo.png" class="logo"> </a></div>
        <!--<div id="wrapper">-->

        <h1>Alumni Portal </h1>

        <div class="header">
            <div>Alumnus<span>&nbsp;Registration</span></div></div><br><br><br><br><br>
        <span class="error" style="color:red;">${param.error }</span>
        <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message}</h4>
        <form action="registerSuccess" method="POST">

            <div class="col-2">
                <label>
                    First Name
                    <input placeholder="What is your first name?" id="alum_fname" name="alum_fname" tabindex="1">
                </label>
            </div>
            <div class="col-2">
                <label>
                    Middle Name
                    <input placeholder="What is your middle name?" id="alum_mname" name="alum_mname" tabindex="2">
                </label>
            </div>

            <div class="col-2">
                <label>
                    Last Name
                    <input placeholder="What is your last name?" id="alum_lname" name="alum_lname" tabindex="3">
                </label>
            </div>
            <div class="col-2">
                <label>
                    Roll No.
                    <input placeholder="What was your Roll No?" id="alum_roll" name="alum_roll" tabindex="4">
                </label>
            </div>
            <div class="col-3">
                <label>
                    Email Address
                    <input placeholder="What is your registered email id with Institute?" id="alum_email" name="alum_email" tabindex="5">
                </label>
            </div>
            <div class="col-3">
                <label>
                    Passing Year of last course
                    <select tabindex="6" name="alum_passingyear">
                        <option>1955</option>
                        <option>1956</option>
                        <option>1957</option>
                        <option>1958</option>
                        <option>1959</option>
                        <option>1960</option>
                        <option>1961</option>
                        <option>1962</option>
                        <option>1963</option>
                        <option>1964</option>
                        <option>1965</option>
                        <option>1966</option>
                        <option>1967</option>
                        <option>1968</option>
                        <option>1969</option>
                        <option>1970</option>
                        <option>1971</option>
                        <option>1972</option>
                        <option>1973</option>
                        <option>1974</option>
                        <option>1975</option>
                        <option>1976</option>
                        <option>1977</option>
                        <option>1978</option>
                        <option>1979</option>
                        <option>1980</option>
                        <option>1981</option>
                        <option>1982</option>
                        <option>1983</option>
                        <option>1984</option>
                        <option>1985</option>
                        <option>1986</option>
                        <option>1987</option>
                        <option>1988</option>
                        <option>1989</option>
                        <option>1990</option>
                        <option>1991</option>
                        <option>1992</option>
                        <option>1993</option>
                        <option>1994</option>
                        <option>1995</option>
                        <option>1996</option>
                        <option>1997</option>
                        <option>1998</option>
                        <option>1999</option>
                        <option>2000</option>
                        <option>2001</option>
                        <option>2002</option>
                        <option>2003</option>
                        <option>2004</option>
                        <option>2005</option>
                        <option>2006</option>
                        <option>2007</option>
                        <option>2008</option>
                        <option>2009</option>
                        <option>2010</option>
                        <option>2011</option>
                        <option>2012</option>
                        <option>2013</option>
                        <option>2014</option>
                        <option>2015</option>
                        <option>2016</option>
                        <option>2017</option>
                        <option>2018</option>
                        <option>2019</option>
                        <option>2020</option>
                    </select>
                </label>
            </div>

            <div class="col-3">
                <label>
                    Date of Birth
                    <input placeholder="When were you born(dd/mm/yyyy)?" id="alum_dob" name="alum_dob" tabindex="7">
                </label>
            </div>


            <div class="col-submit">
                <input type="submit" class="btn" value="Register">
                <a href="index.jsp" class="btn">Back</a>
            </div>

        </form>
    </div>
</body>
</html>