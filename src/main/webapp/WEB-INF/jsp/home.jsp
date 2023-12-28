<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Victory Bank - User Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link href="styles/main.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="scripts/main.js"></script>
    <script>
        function setTransactionDate(formId) {
                var currentDate = new Date();
                var formattedDate = currentDate.toISOString().split('T')[0]; // Format date as YYYY-MM-DD
                document.getElementById(formId).elements['transactionDate'].value = formattedDate;
            }
    </script>
</head>
<body>
    <header class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Victory Bank</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <!-- Navigation Links -->
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <!-- ... other links ... -->
            </ul>
        </div>
    </header>
    <main class="container mt-4">
        <div class="welcome-message">
            <h1>Welcome, ${username}!</h1>
            <p>Your current balance is: <strong>${userBalance}</strong></p>
        </div>
        <div id="userOptions">
            <!-- Add Money Form -->
            <form id="addMoneyForm" action="${pageContext.request.contextPath}/creditamount" method="post" onsubmit="setTransactionDate('addMoneyForm')">
                <label for="amountToAdd">Add Money:</label>
                <input type="number" id="amountToAdd" name="amount" placeholder="Enter amount" required>
                <input type="hidden" id="transactionDateAdd" name="transactionDate">
                <input type="submit" value="Add">
            </form>

            <!-- Withdraw Money Form -->
            <form id="withdrawMoneyForm" action="${pageContext.request.contextPath}/withdrawamount" method="post" onsubmit="setTransactionDate('withdrawMoneyForm')">
                <label for="amountToWithdraw">Withdraw Money:</label>
                <input type="number" id="amountToWithdraw" name="amount" placeholder="Enter amount" required>
                <input type="hidden" id="transactionDateWithdraw" name="transactionDate">
                <input type="submit" value="Withdraw">
            </form>
        </div>
        <section class="transactions mb-4">
            <h2>Previous Transactions:</h2>
            <div class="table-responsive">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>Transaction ID</th>
                            <th>Action</th>
                            <th>Amount</th>
                            <th>Date</th>
                            <th>Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="transaction" items="${userTransactions}">
                            <tr>
                                <td>${transaction.transactionID}</td>
                                <td>${transaction.action}</td>
                                <td>${transaction.amount}</td>
                                <td>${transaction.date}</td>
                                <td>${transaction.balance}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

    </main>
    <footer class="footer bg-light mt-5 py-3">
        <div class="container text-center">
            <p>&copy; <%= new java.util.Date().getYear() + 1900 %> Victory Bank. All Rights Reserved.</p>
        </div>
    </footer>
    <script src="scripts/transaction.js"></script>
</body>
</html>
