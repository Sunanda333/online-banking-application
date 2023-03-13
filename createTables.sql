CREATE TABLE Customer(
   customerID INT NOT NULL,
   customerName VARCHAR(50) NOT NULL,
   dob DATE NOT NULL,
   isBlocked boolean,
   custTypeID INT NOT NULL,
   isOnlineBanking boolean NOT NULL,
   PRIMARY KEY (customerID)
);

CREATE TABLE verifyType(
   verifyTypeID INT,
   verifyName VARCHAR(50) NOT NULL,
   PRIMARY KEY (verifyTypeID)
);

CREATE TABLE CustomerKYC(
   customerID INT,
   verifyNo VARCHAR(50) NOT NULL,
   verifyTypeID INT,
   customerVerifyID INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   PRIMARY KEY (customerVerifyID),
   CONSTRAINT Customer_CustomerKYC FOREIGN KEY (customerID)
   REFERENCES Customer (customerID),
   CONSTRAINT VerifyType_CustomerKYC FOREIGN KEY (verifyTypeID)
   REFERENCES verifyType (verifyTypeID)
);

CREATE TABLE contactType(
   contactTypeID INT,
   contactTypeName VARCHAR(50) NOT NULL,
   PRIMARY KEY (contactTypeID)
);

CREATE TABLE ContactInfo(
   contactID INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   customerID INT,
   contactInfo VARCHAR(50) NOT NULL,
   contactTypeID INT,
   isPrimary boolean,
   PRIMARY KEY (contactID),
   CONSTRAINT Customer_ContactInfo FOREIGN KEY (customerID)
   REFERENCES Customer (customerID),
   CONSTRAINT Customer_contactType FOREIGN KEY (contactTypeID)
   REFERENCES contactType (contactTypeID)
);

CREATE TABLE CustomerAddress(
   customerID INT,
   buildingName VARCHAR(100),
   city VARCHAR(30),
   pincode INT NOT NULL,
   state VARCHAR(30) NOT NULL,
   country VARCHAR(30) NOT NULL,
   PRIMARY KEY (customerID),
   CONSTRAINT Customer_CustomerAddress FOREIGN KEY (customerID)
   REFERENCES Customer (customerID)
);

CREATE TABLE OnlineBankingCredentials(
   userName VARCHAR(50),
   customerID INT,
   password VARCHAR(30) NOT NULL,
   PRIMARY KEY (userName),
   CONSTRAINT Customer_OnlineBankingCredentials FOREIGN KEY (customerID)
   REFERENCES Customer (customerID)
);

CREATE TABLE AccountType(
   typeID INT,
   typeName VARCHAR(50),
   minBalance float,
   overdraftAmountLimit float,
   PRIMARY KEY (typeID )
);

CREATE TABLE Account(
   accountID BIGINT,
   customerID INT  NOT NULL,
   openingDate date  NOT NULL,
   TypeID INT ,
   currentBalance float  NOT NULL,
   PRIMARY KEY (accountID),
   CONSTRAINT Customer_Account FOREIGN KEY (customerID)
   REFERENCES Customer (customerID),
   CONSTRAINT AccountType_Account FOREIGN KEY (typeID)
   REFERENCES AccountType (typeID)
);

CREATE TABLE LoginInfo(
   username VARCHAR(50),
   loginTime timestamp NOT NULL,
   ipAddress VARCHAR(50)  NOT NULL,
   sessionTime timestamp  NOT NULL,
   sessionID INT,
   PRIMARY KEY (sessionID),
   CONSTRAINT OnlineBankingCredentials_LoginInfo FOREIGN KEY (userName)
   REFERENCES OnlineBankingCredentials(userName)
);

CREATE TABLE TransactionType(
   transactionTypeID INT,
   transactionName VARCHAR(50) NOT NULL,
   PRIMARY KEY (transactionTypeID)
);

CREATE TABLE Transactions(
   transactionID bigINT  NOT NULL,
   accountID BIGINT,
   transactionTime timestamp  NOT NULL,
   transactionTypeID INT,
   remarks VARCHAR(50),
   amount float NOT NULL,
   PRIMARY KEY (transactionID),
   CONSTRAINT TransactionType_Transactions FOREIGN KEY (transactionTypeID)
   REFERENCES TransactionType(transactionTypeID)
);

Insert into verifyType values(
   1, 'Pan Card'
);

Insert into verifyType values(
   2, 'Aadhar Card'
);

Insert into verifyType values(
   1, 'Passport'
);

Insert into contactType(
  1, 'Skype'
);

Insert into contactType(
  2, 'WeChat'
);

Insert into contactType(
  3, 'PhoneNumber'
);
Insert into contactType(
  4, 'Email'
);

Insert into AccountType(
   100 , 'Savings' , 20000.0, 0.0
);

Insert into AccountType(
   200 , 'Current' , 20000.0, 0.0
);

Insert into TransactionType(
   1, 'Debit'
);

Insert into TransactionType(
   2, 'Cebit'
);

Insert into TransactionType(
   3, 'Invalid'
);
