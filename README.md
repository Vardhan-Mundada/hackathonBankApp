# API Endpoints

## CustomerController APIs

- **Create Customer:** `POST http://localhost:8081/customer`
- **Get Customer Info:** `GET http://localhost:8081/customer/{acctID}`
- **Delete Customer:** `DELETE http://localhost:8081/customer/{acctID}`

# AccountController APIs

## Get Account Balance
- **Endpoint:** `GET http://localhost:8081/account/{acctID}/balance`
- **Description:** Retrieve the balance of the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
- **Response:** The balance of the specified account.

## Deposit Amount
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/deposit/{amount}`
- **Description:** Deposit the specified amount into the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
  - `amount` (path): The amount to be deposited.
- **Response:** No content.

## Withdraw Amount
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/withdraw/{amount}`
- **Description:** Withdraw the specified amount from the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
  - `amount` (path): The amount to be withdrawn.
- **Response:** No content.

## Transfer Amount
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/transfer/{destAcctID}/{amount}`
- **Description:** Transfer the specified amount from the account with the specified account ID to the destination account with the specified destination account ID.
- **Parameters:**
  - `acctID` (path): The ID of the source account.
  - `destAcctID` (path): The ID of the destination account.
  - `amount` (path): The amount to be transferred.
- **Response:** No content.

## Delete Account
- **Endpoint:** `DELETE http://localhost:8081/account/{acctID}`
- **Description:** Delete the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
- **Response:** No content.

## Get Account Info
- **Endpoint:** `GET http://localhost:8081/account/{acctID}`
- **Description:** Retrieve the details of the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
- **Response:** The account details including account holder name, account type, balance, status, branch, and interest rate.

## Create Account
- **Endpoint:** `POST http://localhost:8081/account/create`
- **Description:** Create a new account with the specified details.
- **Parameters:**
  - `acctID` (query): The ID of the new account.
  - `balance` (query): The initial balance of the account.
  - `acctStatus` (query): The status of the account.
  - `accountHolderName` (query): The name of the account holder.
  - `accountType` (query): The type of the account.
  - `createdDate` (query): The creation date of the account.
  - `lastUpdatedDate` (query): The last updated date of the account.
  - `branch` (query): The branch of the bank where the account is held.
  - `interestRate` (query): The interest rate of the account.
- **Response:** No content.

## Activate Account
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/activate`
- **Description:** Activate the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
- **Response:** No content.

## Deactivate Account
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/deactivate`
- **Description:** Deactivate the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
- **Response:** No content.

## Update Account Information
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/update`
- **Description:** Update the information of the account with the specified account ID.
- **Parameters:**
  - `acctID` (path): The ID of the account.
  - `accountHolderName` (query): The name of the account holder.
  - `accountType` (query): The type of the account.
  - `branch` (query): The branch of the bank where the account is held.
  - `interestRate` (query): The interest rate of the account.
- **Response:** No content.


## LoggerController APIs

- **Show Account Logs:** `GET http://localhost:8081/account/{acctID}/logs`

## Models

### Customer
- **Attributes:**
    - `acctID` (int)
    - `custName` (String)
    - `city` (String)
    - `state` (String)
    - `country` (String)
    - `phoneNo` (int)
    - `password` (String)

### Accounts
- **Attributes:**
    - acctID (int)
    - balance (int)
    - acctStatus (String)
    - accountHolderName (String)
    - accountType (String)
    - createdDate (Date)
    - lastUpdatedDate (Date)
    - branch (String)
    - interestRate (double)

### Logger
- **Attributes:**
    - `acctID` (int)
    - `transacType` (String)
    - `transacStatus` (String)
    - `initBal` (int)
    - `finalBal` (int)
