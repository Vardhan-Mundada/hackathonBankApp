# My Bank App
 
# Swagger
- **Localhost:** `http://localhost:8081/swagger-ui/index.html`

# API Endpoints

## CustomerController APIs


### Create Customer
- **Endpoint:** `POST http://localhost:8081/customer`

### Get Customer Info
- **Endpoint:** `GET http://localhost:8081/customer/{acctID}`

### Delete Customer
- **Endpoint:** `DELETE http://localhost:8081/customer/{acctID}`

## AccountController APIs

### Get Account Balance
- **Endpoint:** `GET http://localhost:8081/account/{acctID}/balance`

### Deposit Amount
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/deposit/{amount}`


### Withdraw Amount
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/withdraw/{amount}`


### Transfer Amount
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/transfer/{destAcctID}/{amount}`


### Delete Account
- **Endpoint:** `DELETE http://localhost:8081/account/{acctID}`

### Get Account Info
- **Endpoint:** `GET http://localhost:8081/account/{acctID}`

### Create Account
- **Endpoint:** `POST http://localhost:8081/account/create`

### Activate Account
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/activate`

### Deactivate Account
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/deactivate`

### Update Account Information
- **Endpoint:** `PUT http://localhost:8081/account/{acctID}/update`


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
