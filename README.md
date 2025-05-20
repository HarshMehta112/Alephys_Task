# Expense Tracker App - Setup Guide

Follow the steps below to clone, set up, and run the Expense Tracker App.

## Prerequisites

- Ensure **JDK 21** is installed on your system.
  - You can verify this by running:
    ```bash
    java -version
    ```
  - If it's not installed, download it from the [Official JDK Downloads](https://jdk.java.net/21/) page.

## Steps to Run the Project

1. **Clone the Repository**
    ```bash
    git clone <REPO_URL>
    cd <REPO_DIRECTORY>
    ```

2. **Run the Application**

    Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse) with **JDK 21** configured.

    Locate the `ExpenseTrackerApp` class and run it from the IDE.

    > If the project uses a build tool like Maven or Gradle, ensure all dependencies are resolved before running.

## Notes

- If you encounter issues, double-check your Java version.
- Make sure your IDE is configured to use JDK 21.

## Result

```
Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 1
Enter date (yyyy-MM-dd): 2025-01-20
Select transaction type:
1. Income
2. Expense
Enter choice: 1
Select category:
1. SALARY
2. BUSINESS
3. INVESTMENT
4. OTHER_INCOME
Enter choice: 1
Enter amount: 1000
Enter description: Test
Transaction added successfully!

Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 2

JANUARY 2025
SALARY         : 1,000.00


Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 1
Enter date (yyyy-MM-dd): 2025-01-20
Select transaction type:
1. Income
2. Expense
Enter choice: 2
Select category:
1. FOOD
2. RENT
3. TRAVEL
4. UTILITIES
5. ENTERTAINMENT
6. OTHER_EXPENSE
Enter choice: 3
Enter amount: AHD
Invalid amount format.
Enter amount: 100
Enter description: AHD
Transaction added successfully!

Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 3
Enter filename to save: Test
Transactions saved successfully!

Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 2

JANUARY 2025
SALARY         : 1,000.00
TRAVEL         : 100.00


Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 4
Enter filename to load: Test
Transactions loaded successfully!

Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 2

JANUARY 2025
SALARY         : 2,000.00
TRAVEL         : 200.00


Expense Tracker Menu:
1. Add Transaction
2. Generate Monthly Report
3. Save Transactions
4. Load Transactions
5. Exit
Enter your choice: 5

Process finished with exit code 0
```
