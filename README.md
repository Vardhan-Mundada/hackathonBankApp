# API Endpoints

## CustomerController APIs

- **Create Customer:** `POST http://localhost:8081/customer`
- **Get Customer Info:** `GET http://localhost:8081/customer/{acctID}`
- **Delete Customer:** `DELETE http://localhost:8081/customer/{acctID}`

## AccountController APIs

- **Get Account Balance:** `GET http://localhost:8081/account/{acctID}/balance`
- **Deposit Amount:** `PUT http://localhost:8081/account/{acctID}/deposit/{amount}`
- **Withdraw Amount:** `PUT http://localhost:8081/account/{acctID}/withdraw/{amount}`
- **Transfer Amount:** `PUT http://localhost:8081/account/{acctID}/transfer/{destAcctID}/{amount}`
- **Delete Account:** `DELETE http://localhost:8081/account/{acctID}`
- **Get Account Info:** `GET http://localhost:8081/account/{acctID}`

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
    - `acctID` (int)
    - `balance` (int)
    - `acctStatus` (String)

### Logger
- **Attributes:**
    - `acctID` (int)
    - `transacType` (String)
    - `transacStatus` (String)
    - `initBal` (int)
    - `finalBal` (int)
