<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Victory - Your Trusted Banking Partner</title>
<!-- Include CSS files for styling -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">

    <script>
        // JavaScript for showing and hiding the signup pop-up
        function showSignupPopup() {
            document.getElementById('signup-popup').style.display = 'block';
            document.getElementById('signup-overlay').style.display = 'block';
        }

        function hideSignupPopup() {
            document.getElementById('signup-popup').style.display = 'none';
            document.getElementById('signup-overlay').style.display = 'none';
        }
        function validatePassword() {
            var password = document.getElementById('signup-password').value;
            var repassword = document.getElementById('signup-repassword').value;
            var errorLabel = document.getElementById('password-match-error');

            if (password !== repassword) {
                document.getElementById('signup-repassword').classList.add('error');
                errorLabel.innerHTML = 'Passwords do not match.';
                return false;
            } else {
                document.getElementById('signup-repassword').classList.remove('error');
                errorLabel.innerHTML = '';
                return true;
            }
        }
    </script>
</head>
<body>

<div id="header">
  <h1><a href="index.jsp">Victory Bank</a></h1>
</div>

<div id="login">
    <form action="./loggingIn" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" required>
        <label for="password">Password:</label>
        <input type="password" name="password" required>
        <div id="loginHelp">
            <a href="forgotPassword.jsp">Forgot username/password?</a>
            <a href="javascript:void(0);" onclick="showSignupPopup()">Not enrolled? Sign up now.</a>
        </div>
        <input type="submit" value="Log In">
    </form>
</div>

<div id="promo">
  <h2>Enjoy $200</h2>
  <p>Open a Victory Total Checking account with qualifying activities.</p>
  <a href="openAccount.jsp" class="btn">Open an Account</a>
</div>

<div id="signup-overlay" onclick="hideSignupPopup()"></div>

<div id="signup-popup">
    <span id="signup-popup-close" onclick="hideSignupPopup()">x</span>
    <!-- Signup form -->
    <h2>Sign Up</h2>
    <form action="./signingUp" method="post" onsubmit="return validateSignupForm()">
        <div style="margin-top: 10px;"></div> <!-- Add spacing here -->

        <label for="signup-username">Username:</label>
        <input type="text" name="signup-username" required>

        <label for="signup-email">Email:</label>
        <input type="email" name="signup-email" required>

        <label for="signup-dob">Date of Birth:</label>
        <input type="date" name="signup-dob" required>

        <label for="signup-password">Password:</label>
        <input type="password" name="signup-password" id="signup-password" required>

        <label for="signup-repassword">Re-enter Password:</label>
        <input type="password" name="signup-repassword" id="signup-repassword" oninput="validatePassword()" required>
        <div id="password-match-error"></div>

        <input type="submit" value="Sign Up">
    </form>
</div>

<div id="nav">
  <ul>
    <li><a href="checking.jsp">Checking</a></li>
    <li><a href="savings.jsp">Savings & CDs</a></li>
    <li><a href="creditCards.jsp">Credit Cards</a></li>
    <li><a href="loans.jsp">Home Loans</a></li>
    <li><a href="auto.jsp">Auto</a></li>
    <li><a href="investing.jsp">Investing</a></li>
    <li><a href="education.jsp">Education & Goals</a></li>
  </ul>
</div>

<div id="footer">
  <p>&copy; <%= new java.util.Date().getYear() + 1900 %> Victory Bank. All Rights Reserved.</p>
</div>

</body>
</html>
