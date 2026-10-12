# DoorDash — Food Ordering & Pre-Booking Desktop App

DoorDash is a Java desktop application built with **JavaFX** and **FXML**. It provides a graphical interface for customer registration and login, placing food orders, viewing orders, making restaurant pre-bookings, viewing bookings, and recording a payment/advance transaction. MySQL is used for persistence through JDBC.

> **Project status:** Academic/demo project. It is not production-ready and has not been security-audited. See **Known limitations** before using it with real users or data.

## Features

- Customer registration and login
- Customer profile viewing and update flow
- Food order form with restaurant/cloud-kitchen choices
- Order history table filtered by the logged-in user's mobile number
- Restaurant pre-booking form and booking list
- Payment/advance transaction record
- JavaFX scene navigation using FXML layouts

## Technology stack

- Java 21
- JavaFX Controls and FXML 21
- Maven (project build configuration and JavaFX Maven plugin)
- MySQL 8-compatible server and MySQL Connector/J 8.3.0
- FontAwesomeFX icons
- IntelliJ IDEA (original development environment)

## Project structure

```text
DoorDash/
├── pom.xml
├── mvnw / mvnw.cmd
└── src/main/
    ├── java/
    │   ├── module-info.java
    │   └── org/example/doordash/
    │       ├── HelloApplication.java       # JavaFX entry point and scene navigation
    │       ├── Singletone.java              # Shared JDBC connection configuration
    │       ├── controller/                  # FXML event handlers and UI logic
    │       ├── model/                       # User, order, booking and transaction data objects
    │       └── service/                     # JDBC database operations
    └── resources/org/example/doordash/
        ├── *.fxml                           # JavaFX screens
        └── images and GIFs                  # UI assets
```

## Requirements

1. Install **JDK 21**.
2. Install and start **MySQL Server**.
3. Open this folder in IntelliJ IDEA as a Maven project and allow Maven to download dependencies.
4. Create a MySQL database named `DoorDash` (or configure a different name).
5. Create the tables expected by the service classes before running the application. **The original project archive does not include a database schema or SQL setup script**, so the database tables must be prepared separately.

## Database configuration

Database settings are read from environment variables. Do not commit database passwords to GitHub. Set these variables in the environment used to launch IntelliJ IDEA:

| Variable | Purpose | Default / example |
|---|---|---|
| `DOORDASH_DB_HOST` | MySQL host | `localhost` |
| `DOORDASH_DB_NAME` | Database name | `DoorDash` |
| `DOORDASH_DB_USER` | MySQL username | `root` |
| `DOORDASH_DB_PASSWORD` | MySQL password | **Required; set your own value** |

For local development on Windows PowerShell, you can set them for the current terminal session (replace the example password with your local MySQL password):

```powershell
$env:DOORDASH_DB_HOST = "localhost"
$env:DOORDASH_DB_NAME = "DoorDash"
$env:DOORDASH_DB_USER = "root"
$env:DOORDASH_DB_PASSWORD = "your-local-mysql-password"
```

Then launch the app from that same terminal, or configure the same variables in IntelliJ IDEA's Run Configuration. Do not paste real credentials into source code or commit them.

The current JDBC service code expects tables named `user`, `dashboard_user`, `preorder_user`, and `transactionservice`. Column order and names must match the SQL statements in the service classes. The project currently has no checked-in schema script.

## Run the application

From the project root, with Java 21, Maven, MySQL and the required schema configured:

```bash
# Windows
./mvnw.cmd clean javafx:run

# macOS / Linux
./mvnw clean javafx:run
```

You can also open the Maven tool window in IntelliJ IDEA and run the `javafx:run` goal. If the wrapper is not executable on macOS/Linux, run `chmod +x mvnw` first.

## Main classes

### Application
- `HelloApplication` — starts JavaFX at the login screen and switches between FXML scenes.
- `Singletone` — opens the shared JDBC connection using environment-based configuration.

### Controllers
- `LoginController` — login and password visibility toggle.
- `RegistrationController` — customer registration and password visibility toggle.
- `DashboardController` — selects service/vendor/menu, places orders, and navigates to booking/profile/order screens.
- `OrderController` — loads and displays the logged-in user's orders.
- `PreBookController` — collects restaurant, menu, quantity and table preference for a pre-booking.
- `PreOrderController` — displays the logged-in user's pre-bookings and navigates to payment.
- `PaymentController` — records a transaction entry.
- `ProfileController` — displays profile data, submits profile updates, and logs out.
- `AdminController` — currently an empty placeholder.

### Models
- `User` — customer/admin account fields.
- `AdminUser` — admin account data object; currently not connected to a complete admin workflow.
- `DashBoardUser` — food order details and associated mobile number.
- `PreOrderUser` — restaurant booking details and associated mobile number.
- `Transaction` — mobile number, transaction service and amount.

### Services
- `UserService` — registration, login and profile update SQL operations.
- `DashBoardUserService` — inserts and reads food orders.
- `PreOrderUserService` — inserts and reads pre-bookings.
- `TransactionService` — records a transaction row.
- `AdminUserService` — currently contains only commented-out/incomplete admin login code.

## Known limitations and security notes

- The database schema is not included, so a fresh clone cannot connect successfully until the required tables are created.
- Several service methods build SQL by concatenating user input. Use `PreparedStatement` to prevent SQL injection before using real data.
- The current design stores/compares passwords as plain text. Passwords should be hashed with a suitable password-hashing algorithm and existing plain-text passwords should not be reused in a real deployment.
- Login handling can throw a `NullPointerException` when authentication fails because the controller accesses the returned user before checking for `null`.
- The profile update service currently returns `false` even after a successful SQL execution, so the UI's success/failure flow is incorrect.
- The payment screen currently uses a hard-coded mobile number and only records a database row; it does not integrate with a real payment gateway or verify payment.
- Input validation and error handling need improvement (for example, empty selections and non-numeric payment values).
- The application uses one shared JDBC connection rather than a connection pool.
- `AdminController` and `AdminUserService` are placeholders; the admin workflow is incomplete.

## Future improvements

- Add a versioned SQL schema/setup script.
- Replace concatenated SQL with prepared statements and use try-with-resources for JDBC resources.
- Add password hashing, validation, and safer authentication handling.
- Correct profile update and payment flows.
- Add automated tests and clearer error messages.

## License

No license is currently specified. Add a license file if you want others to reuse, modify, or distribute this project under explicit terms.
