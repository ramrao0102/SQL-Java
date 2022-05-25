/* Create Data Dictionary Table ID 1 Person
Azure SQL creates clustered index on SSN
*/

Create Table Person (
primary key (SSN),
Name varchar(20),
SSN varchar(20),
Birth_Date date,
Race varchar(20),
Gender varchar(20),
Street_No varchar(20),
Street_Name varchar(20),
City varchar(20),
State varchar(20),
Zip int,
On_Mailing_List varchar(10),
Profession_Name varchar(20),
);

/* Create Nonclusted Index on On_Mailing_List in Person Table
*/

create nonclustered index list on Person(On_Mailing_List);


/* Create Data Dictionary Table ID 2 Additional_Contact 
Azure SQL creates clustered index on SSN
*/

Create Table Additional_Contact (
primary key (SSN, Email_Address),
SSN varchar(20),
Email_Address varchar(64),
Work_Phone varchar(20),
Cell_Phone varchar(20),
Home_Phone varchar(20),
foreign key (SSN) references Person,
);

/* Create Data Dictionary Table ID 3 Emergency_Contact
*/

Create Table Emergency_Contact (
primary key (SSN, Emergency_Contact_Name),
SSN varchar(20),
Emergency_Contact_Name varchar(20),
Emergency_Contact_Email_Address varchar(64),
Emergency_Contact_Work_Phone varchar(20),
Emergency_Contact_Cell_Phone varchar(20),
Emergency_Contact_Home_Phone varchar (20),
Relationship_Type varchar(20),
);

/* Create Nonclusted Index for Emergency_Contact Table
*/

create nonclustered index ESSN on Emergency_Contact(SSN);
create nonclustered index EName on Emergency_Contact(Emergency_Contact_Name);


/* Create Data Dictionary Table ID 4 Client
*/

Create Table Client (
  primary key (Client_SSN),
  Client_SSN varchar(20),
  Date_Assigned date,
  foreign key (Client_SSN) references Person,
  ); 


/* Create Nonclustered Index on  in Client Table
*/

create nonclustered index ClientSSN on Client(Client_SSN);

/* Create Data Dictionary Table ID 5 Volunteer
Azure SQL creates clustered index on SSN
*/

  create table Volunteer (
   primary key (Volunteer_SSN),
   Volunteer_SSN varchar(20),
   Date_Joined date,
   Date_Training_Course date,
   Location_Training_Course varchar(24),
   foreign key (Volunteer_SSN) references Person,
   );

* Create Nonclustered Index on Volunteer_SSN in Volunteer Table
*/

create nonclustered index VolSNN on Volunteer(Volunteer_SSN);

/* Create Data Dictionary Table ID 6 Employee
Azure SQL creates clustered index on Employee_SSN
*/

 create table Employee (
 primary key (Employee_SSN),
  Employee_SSN varchar(20),
  Date_Hired date,
  Employee_Salary float(20),
  Marital_Status varchar(20),
  foreign key (Employee_SSN) references Person,
    );

/* Create Data Dictionary Table ID 7 Donor
Azure SQL creates clustered index on Employee_SSN
*/



create table Donor (
 primary key (Donor_SSN),
  Donor_SSN varchar(20),
  Is_Anonymous varchar(20),
  foreign key (Donor_SSN) references Person,
  );

/* Create Data Dictionary Table ID 8 
*/

Create Table Client_Attorney (
primary key (Client_SSN, Attorney_Name),
Client_SSN varchar(20),
Attorney_Name varchar(20),
Street_No varchar(20),
Street_Name varchar(20),
City varchar(20),
State varchar(20),
Zip varchar(20),
AttorneyPhone varchar(20)
foreign key (Client_SSN) references Client,
);

/*
* Create Nonclustered Index on Client_SSN in Client_Attorney Table
*/

create nonclustered index Client_SSN on Client_Attorney(Client_SSN);
create nonclustered index Attorney_Name on Client_Attorney(Attorney_Name);

/* Create Data Dictionary Table ID 9 
Azure SQL creates clustered index on Client_SSN and Doctor_Name
*/

Create Table Client_Doctor (
 primary key (Client_SSN, Doctor_Name),
 Client_SSN varchar(20),
Doctor_Name varchar(20),
Street_No varchar(20),
Street_Name varchar(20),
City varchar(20),
State varchar(20),
Zip varchar(20),
DoctorPhone varchar(20)
foreign key (Client_SSN) references Client,
);

/* Create Data Dictionary Table ID 10 Needs_List
*/

create Table Needs_List (
primary key (Client_SSN, Needs_Type),
Client_SSN varchar(20),
Needs_Type varchar(20),
Needs_Rank int);

* Create Nonclustered Index on Needs_Rank in Needs_List Table
*/

create nonclustered index NeedsRank on Needs_List(Needs_Rank);


/* Create Data Dictionary Table ID 11 Insurance_Policy
*/

create Table Insurance_Policy (

primary key(Client_SSN, Policy_ID),
Client_SSN varchar(20),
Policy_ID int,
Provider_ID varchar(20),
Street_No varchar(20),
Street_Name varchar(20),
Suite_No varchar(20),
City varchar(20),
State varchar(20),
Zip varchar(20),
Policy_Type varchar(20),
);

/*
* Create Indices on Insurance_Policy Table
*/

create nonclustered index Client_SSN on Insurance_Policy(Client_SSN);
create nonclustered index PolicyID on Insurance_Policy(Policy_ID);
create clustered index Policy_Type on Insurance_Policy(Policy_Type);


/* Create Data Dictionary Table ID 12 
Azure SQL creates clustered index on Team
*/

Create Table Team (
 primary key (Team_Name),
 Team_Name varchar(64) NOT NULL,
 Team_Type varchar(24),
 Date_Formed date,
 );

/*
* Create Indices on Team Table
*/

create nonclustered index TeamName on Team(Team_Name);
create clustered index Date_Formed on Team(Date_Formed);

/* Create Data Dictionary Table ID 13 
Azure SQL creates clustered index on Client_SSN, Team_Name, Volunteer_SSN

*/

create Table Client_Care (

 primary key(Client_SSN, Team_Name, Volunteer_SSN),
 Client_SSN varchar(20),
 Team_Name varchar(64),
 Volunteer_SSN varchar(20),
 Client_Active varchar(5),
 Volunteer_Active varchar(5),
 foreign key(Client_SSN) references Client,
 foreign key(Team_Name) references Team,
  foreign key(Volunteer_SSN) references Volunteer,
);

/*  Create Data Dictionary Table ID 14 
    Table Volunteer_Leads
*/

create Table Volunteer_Leads (
 primary key(Client_SSN, Team_Name, Volunteer_Member_SSN),
 Client_SSN varchar(20),
 Team_Name varchar(64),
 Volunteer_Member_SSN varchar(20),
 Volunteer_Leader_SSN varchar(20),
 foreign key(Client_SSN, Team_Name, Volunteer_Member_SSN) references Client_Care,
 );

/*
* Create Indices on Volunteer_Leads Table
*/

create nonclustered index index1 on Volunteer_Leads(Client_SSN, Team_Name, Volunteer_Member_SSN);


/*  Create Data Dictionary Table ID 15 
    Table Monthly_Tracking
*/

create Table Monthly_Tracking (
 primary key(Client_SSN, Team_Name, Volunteer_SSN, Month),
 Client_SSN varchar(20),
 Team_Name varchar(64),
 Volunteer_SSN varchar(20),
 Month varchar(20),
 Hrs_Worked varchar(20),

 foreign key(Client_SSN, Team_Name, Volunteer_SSN) references Client_Care,
 );

/*  Create Data Dictionary Table ID 16 
   Azure SQL creates clustered index on Date_of_Donation
    Table Donation_Details
*/

create Table Donation_Details (
 primary key(Date_of_Donation),
 Date_of_Donation date,
 Amount_of_Donation float(20),
 Name_of_Fund_Raising_Campaign varchar(64),
);

/*  Create Data Dictionary Table ID 17 
   Azure SQL creates clustered index on Date_of_Donation
    Table Donation_Details
*/

create Table Donor_Makes (
primary key(Donor_SSN, Date_of_Donation),
 Donor_SSN varchar(20),
 Date_of_Donation date,
 foreign key (Donor_SSN) references Donor ,
 foreign key (Date_of_Donation) references Donation_Details,
);

/*  Create Data Dictionary Table ID 18 
*/

create Table Type_of_Payment (
 primary key(Donor_SSN, Date_of_Donation, Payment_Type),
 Donor_SSN varchar(20),
 Date_of_Donation date,
 Payment_Type varchar(20),
 foreign key (Donor_SSN, Date_of_Donation) references Donor_Makes ,
);

/*
* Create Indices on Type_of_Payment Table
*/

create nonclustered index index1 on Type_of_Payment(Donor_SSN);
create nonclustered index index2 on Type_of_Payment(Date_of_Donation);
create nonclustered index index3 on Type_of_Payment(Payment_Type);

/*  Create Data Dictionary Table ID 19 
*/


create Table Credit_Card (
 primary key(Donor_SSN, Date_of_Donation,Payment_Type, Credit_Card_No),
 Donor_SSN varchar(20),
 Date_of_Donation date,
 Payment_Type varchar(20),
 Credit_Card_No int,
 Card_Type varchar(20),
 Expiration_Date date,
 foreign key (Donor_SSN, Date_of_Donation,Payment_Type) references Type_of_Payment ,
);

/*
* Create Indices on Credit_Card Table Table
*/

create nonclustered index index1 on Credit_Card(Donor_SSN);
create nonclustered index index2 on Credit_Card(Date_of_Donation);
create nonclustered index index3 on Credit_Card(Payment_Type);
create nonclustered index index4 on Credit_Card(Credit_Card_No);

/*  Create Data Dictionary Table ID 20
*/

Create Table Checks (
 primary key(Donor_SSN, Date_of_Donation,Payment_Type, CheckNo),
 Donor_SSN varchar(20),
 Date_of_Donation date,
 Payment_Type varchar(20),
 CheckNo int,
 foreign key (Donor_SSN, Date_of_Donation,Payment_Type) references Type_of_Payment ,
);

/*
* Create Indices on Checks Table
*/

create nonclustered index index1 on Checks(Donor_SSN);
create nonclustered index index2 on Checks(Date_of_Donation);
create nonclustered index index3 on Checks(Payment_Type);
create nonclustered index index4 on Checks(CheckNo);

/*  Create Data Dictionary Table ID 21
*/

create Table Organization (
 primary key(Organization_Name),
Organization_Name varchar(64),
Street_No varchar(20),
Street_Name varchar(20),
City varchar(20),
State varchar(20),
Zip varchar(20),
Phone_Number varchar(20),
);

/*
* Create Index on Organization Table
*/

create nonclustered index index1 on Organization(Organization_Name);

/*  Create Data Dictionary Table ID 22
*/


create Table Affiliated_With (
primary key(SSN, Organization_Name),
SSN varchar(20),
Organization_Name varchar(64),
foreign key(SSN) references Person,
foreign key(Organization_Name) references Organization,
);

/*
* Create Index on Affiliated_With
*/

create nonclustered index index1 on Affiliated_With(SSN);
create nonclustered index index2 on Affiliated_With(Organization_Name);


/*  Create Data Dictionary Table ID 23
*/

create Table Business (
primary key(Organization_Name, Business_Type),
Organization_Name varchar(64),
Business_Type varchar(20),
Business_Size int,
Company_Web_Site varchar(100),
foreign key(Organization_Name) references Organization,
);

/*
* Create Index on Organization_Name
*/


create nonclustered index index2 on Business(Organization_Name);
create nonclustered index index3 on Business(Business_Type);

/*  Create Data Dictionary Table ID 24
*/

create Table Church (
primary key(Organization_Name),
Organization_Name varchar(64),
Religious_Affiliation varchar(20),
foreign key(Organization_Name) references Organization,
);

*
* Create Index on Organization_Name
*/

create nonclustered index index2 on Church(Organization_Name);

/*  Create Data Dictionary Table ID 25
*/

create table Organization_Donation_Details (

primary key(Date_of_Donation),
 Date_of_Donation date,
 Amount_of_Donation float(20),
 Name_of_Fund_Raising_Campaign varchar(64),
);

*
* Create Index on Organization_Donation_Details
*/

create nonclustered index index2 on Organization_Donation_Details(Date_of_Donation);

/*  Create Data Dictionary Table ID 26
   Azure SQL creates clustered index on Date_of_Donation
    Table Donation_Details
*/

create Table Organization_Makes (
primary key(Organization_Name, Date_of_Donation),
 Organization_Name varchar(64),
 Date_of_Donation date,
 foreign key (Organization_Name) references Organization ,
 foreign key (Date_of_Donation) references Organization_Donation_Details,
);

/*  Create Data Dictionary Table ID 27 
*/

create Table Organization_Type_of_Payment (
 primary key(Organization_Name, Date_of_Donation, Payment_Type),
 Organization_Name varchar(64),
 Date_of_Donation date,
 Payment_Type varchar(20),
 foreign key (Organization_Name, Date_of_Donation) references Organization_Makes,
);

/*
* Create Indices on T Organization_Type_of_Payment Table
*/

create nonclustered index index1 on Organization_Type_of_Payment( Organization_Name);
create nonclustered index index2 on Organization_Type_of_Payment( Date_of_Donation);
create nonclustered index index3 on Organization_Type_of_Payment( Payment_Type);

/*  Create Data Dictionary Table ID 28 
*/


create Table Orgnization_Credit_Card (
 primary key(Organization_Name, Date_of_Donation,Payment_Type, Credit_Card_No),
 Organization_Name varchar(64),
 Date_of_Donation date,
 Payment_Type varchar(20),
 Credit_Card_No int,
 Card_Type varchar(20),
 Expiration_Date date,
 foreign key (Organization_Name, Date_of_Donation,Payment_Type) references Organization_Type_of_Payment ,
);

/*
* Create Indices on Orgnization_Credit_Card Table Table
*/

create nonclustered index index1 on Orgnization_Credit_Card( Organization_Name);
create nonclustered index index2 on Orgnization_Credit_Card(Date_of_Donation);
create nonclustered index index3 on Orgnization_Credit_Card(Payment_Type);
create nonclustered index index4 on Orgnization_Credit_Card(Credit_Card_No);

/*  Create Data Dictionary Table ID 29
*/

create Table Organization_Checks (
 primary key( Organization_Name, Date_of_Donation,Payment_Type, CheckNo),
 Organization_Name varchar(64),
 Date_of_Donation date,
 Payment_Type varchar(20),
 CheckNo int,
 foreign key ( Organization_Name, Date_of_Donation,Payment_Type) references Organization_Type_of_Payment ,
);

/*
* Create Indices on Organization_Checks Table
*/

create nonclustered index index1 on Organization_Checks(Organization_Name);
create nonclustered index index2 on Organization_Checks(Date_of_Donation);
create nonclustered index index3 on Organization_Checks(Payment_Type);
create nonclustered index index4 on Organization_Checks(CheckNo);


/*  Create Data Dictionary Table ID 30
*/

create Table Organization_Sponsors (
 primary key( Organization_Name, Team_Name),
 Organization_Name varchar(64),
 Team_Name varchar(64)
 foreign key ( Organization_Name, Team_Name) references Organization_Sponsors ,
);


/*  Create Data Dictionary Table ID 31
*/

create Table Team_Reports (
 primary key( Team_Name, Employee_SSN, Date_of_Report),
 Team_Name varchar(64),
 Employee_SSN varchar(20),
 Description varchar(64),
 Date_of_Report date,
 foreign key (Team_Name) references Team ,
 foreign key (Employee_SSN) references Employee,
);

/*  Create Data Dictionary Table ID 32
*/

create Table Employee_Expenses (
 primary key( Employee_SSN, Date_of_Expense),
Employee_SSN varchar(20),
Date_of_Expense date,
Amount_Expensed float(20),
Description varchar(100),

 foreign key (Employee_SSN) references Employee ,
);

