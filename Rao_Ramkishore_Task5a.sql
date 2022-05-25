

ALTER PROCEDURE ADDPERSON
@Name varchar(20),
@SSN varchar(20),
@Birth_Date date,
@Race varchar(20),
@Gender varchar(20),
@Street_No varchar(20),
@Street_Name varchar(20),
@City varchar(20),
@State varchar(20),
@Zip int,
@On_Mailing_List varchar(10),
@Profession_Name varchar(20)

AS
BEGIN

INSERT INTO Person (Name, SSN, Birth_Date, Race, Gender, Street_No, Street_Name, City, State, Zip, On_Mailing_List, Profession_Name)
VALUES (@Name, @SSN, @Birth_Date, @Race, @Gender, @Street_No, @Street_Name, @City, @State, @Zip, @On_Mailing_List, @Profession_Name)


END

ALTER PROCEDURE ADDCONTACT

@SSN varchar(20),
@Email_Address varchar(64),
@Work_Phone varchar(20),
@Cell_Phone varchar(20),
@Home_Phone varchar(20)

AS
BEGIN

INSERT INTO Additional_Contact (SSN, Email_Address, Work_Phone, Cell_Phone,  Home_Phone)
VALUES (@SSN, @Email_Address, @Work_Phone, @Cell_Phone,  @Home_Phone)

END


ALTER PROCEDURE ADDEMERGENCYCONTACT

@SSN varchar(20),
@Emergency_Contact_Name varchar(20),
@Emergency_Contact_Email_Address varchar(64),
@Emergency_Contact_Work_Phone varchar(20),
@Emergency_Contact_Cell_Phone varchar(20),
@Emergency_Contact_Home_Phone varchar (20),
@Relationship_Type varchar(20)

AS
BEGIN

INSERT INTO Emergency_Contact (SSN, Emergency_Contact_Name, Emergency_Contact_Email_Address, Emergency_Contact_Cell_Phone,  Emergency_Contact_Home_Phone, Relationship_Type)
VALUES (@SSN, @Emergency_Contact_Name, @Emergency_Contact_Email_Address, @Emergency_Contact_Cell_Phone,  @Emergency_Contact_Home_Phone, @Relationship_Type)

END


ALTER PROCEDURE ADDCLIENT

@Client_SSN varchar(20),
@Date_Assigned date

AS
BEGIN

INSERT INTO Client (Client_SSN, Date_Assigned)
VALUES (@Client_SSN, @Date_Assigned)

END


ALTER PROCEDURE ADDVOLUNTEER

 @Volunteer_SSN varchar(20),
 @Date_Joined date,
 @Date_Training_Course date,
 @Location_Training_Course varchar(24)


AS
BEGIN

INSERT INTO Volunteer (Volunteer_SSN, Date_Joined, Date_Training_Course, Location_Training_Course)
VALUES (@Volunteer_SSN, @Date_Joined, @Date_Training_Course, @Location_Training_Course)

END


ALTER PROCEDURE ADDEMPLOYEE

@Employee_SSN varchar(20),
@Date_Hired date,
@Employee_Salary float(20),
@Marital_Status varchar(20)

AS
BEGIN

INSERT INTO Employee (Employee_SSN, Date_Hired, Employee_Salary, Marital_Status)
VALUES (@Employee_SSN, @Date_Hired, @Employee_Salary, @Marital_Status)

END


ALTER PROCEDURE ADDDONOR

  @Donor_SSN varchar(20),
  @Is_Anonymous varchar(20)

AS
BEGIN

INSERT INTO Donor (Donor_SSN, Is_Anonymous)
VALUES (@Donor_SSN, @Is_Anonymous)

END


ALTER PROCEDURE ADDCLIENT_ATTORNEY

@Client_SSN varchar(20),
@Attorney_Name varchar(20),
@Street_No varchar(20),
@Street_Name varchar(20),
@City varchar(20),
@State varchar(20),
@Zip varchar(20),
@AttorneyPhone varchar(20)

AS
BEGIN

INSERT INTO Client_Attorney(Client_SSN, Attorney_Name, Street_No, Street_Name, City, State, Zip, AttorneyPhone)
VALUES (@Client_SSN, @Attorney_Name, @Street_No, @Street_Name, @City, @State, @Zip, @AttorneyPhone)

END


ALTER PROCEDURE ADDCLIENT_DOCTOR

@Client_SSN varchar(20),
@Doctor_Name varchar(20),
@Street_No varchar(20),
@Street_Name varchar(20),
@City varchar(20),
@State varchar(20),
@Zip varchar(20),
@DoctorPhone varchar(20)

AS
BEGIN

INSERT INTO Client_Doctor(Client_SSN, Doctor_Name, Street_No, Street_Name, City, State, Zip, DoctorPhone)
VALUES (@Client_SSN, @Doctor_Name, @Street_No, @Street_Name, @City, @State, @Zip, @DoctorPhone)

END


ALTER PROCEDURE ADDINSURANCE_POLICY

@Client_SSN varchar(20),
@Policy_ID int,
@Provider_ID varchar(20),
@Street_No varchar(20),
@Street_Name varchar(20),
@Suite_No varchar(20),
@City varchar(20),
@State varchar(20),
@Zip varchar(20),
@Policy_Type varchar(20)

AS
BEGIN

INSERT INTO Insurance_Policy(Client_SSN, Policy_ID, Provider_ID, Street_No, Street_Name,  Suite_No, City, State, Zip, Policy_Type )
VALUES (@Client_SSN, @Policy_ID, @Provider_ID, @Street_No, @Street_Name,  @Suite_No, @City, @State, @Zip, @Policy_Type)

END


ALter PROCEDURE ADDNEEDS_LIST
 
@Client_SSN varchar(20),
@Needs_Type varchar(20),
@Needs_Rank int


AS
BEGIN

INSERT INTO Needs_List(Client_SSN,  Needs_Type, Needs_Rank)
VALUES (@Client_SSN,  @Needs_Type, @Needs_Rank)

END




ALTER PROCEDURE ADDTEAM


@Team_Name varchar(64),
@Team_Type varchar(24),
@Date_Formed date

AS
BEGIN

INSERT INTO Team(Team_Name, Team_Type, Date_Formed )
VALUES (@Team_Name, @Team_Type, @Date_Formed)

END


ALTER PROCEDURE ADDCLIENT_CARE

@Client_SSN varchar(20),
@Team_Name varchar(64),
@Volunteer_SSN varchar(20),
@Client_Active varchar(5),
@Volunteer_Active varchar(5)

AS
BEGIN

INSERT INTO Client_Care(Client_SSN, Team_Name, Volunteer_SSN, Client_Active, Volunteer_Active)
VALUES (@Client_SSN, @Team_Name, @Volunteer_SSN, @Client_Active, @Volunteer_Active)

END

ALTER PROCEDURE ADDVOLUNTEER_LEAD

@Client_SSN varchar(20),
@Team_Name varchar(64),
@Volunteer_Member_SSN varchar(20),
@Volunteer_Leader_SSN varchar(20)

AS
BEGIN

INSERT INTO Volunteer_Leads(Client_SSN, Team_Name, Volunteer_Member_SSN, Volunteer_Leader_SSN)
VALUES (@Client_SSN, @Team_Name, @Volunteer_Member_SSN, @Volunteer_Leader_SSN)

END


ALTER PROCEDURE ADDMONTHLY_TRACKING

@Client_SSN varchar(20),
@Team_Name varchar(64),
@Volunteer_SSN varchar(20),
@Month varchar(20),
@Hrs_Worked varchar(20)

AS
BEGIN

INSERT INTO Monthly_Tracking(Client_SSN, Team_Name, Volunteer_SSN, Month, Hrs_Worked)
VALUES (@Client_SSN, @Team_Name, @Volunteer_SSN, @Month, @Hrs_Worked)

END


CREATE PROCEDURE ADDDONATION_DETAILS

@Date_of_Donation date,
@Amount_of_Donation float(20),
@Name_of_Fund_Raising_Campaign varchar(64)

AS
BEGIN


INSERT INTO Donation_Details(Date_of_Donation, Amount_of_Donation, Name_of_Fund_Raising_Campaign)
VALUES (@Date_of_Donation, @Amount_of_Donation, @Name_of_Fund_Raising_Campaign)

END


ALTER PROCEDURE ADDDONOR_MAKES 

@Donor_SSN varchar(20),
@Date_of_Donation date
 
AS
BEGIN

INSERT INTO Donor_Makes(Donor_SSN, Date_of_Donation)
VALUES (@Donor_SSN, @Date_of_Donation)

END


alter PROCEDURE ADDTYPE_OF_PAYMENT  
@Donor_SSN varchar(20),
@Date_of_Donation date,
@Payment_Type varchar(20)

AS
BEGIN

INSERT INTO Type_of_Payment(Donor_SSN, Date_of_Donation, Payment_Type)
VALUES (@Donor_SSN, @Date_of_Donation, @Payment_Type)

END


ALTER PROCEDURE ADDCREDIT_CARD 
@Donor_SSN varchar(20),
@Date_of_Donation date,
@Payment_Type varchar(20),
@Credit_Card_No int,
@Card_Type varchar(20),
@Expiration_Date date

AS
BEGIN

INSERT INTO Credit_Card(Donor_SSN, Date_of_Donation, Payment_Type, Credit_Card_No, Card_Type, Expiration_Date)
VALUES (@Donor_SSN, @Date_of_Donation, @Payment_Type, @Credit_Card_No, @Card_Type, @Expiration_Date)

END



ALTER PROCEDURE ADDCHECKS 
@Donor_SSN varchar(20),
@Date_of_Donation date,
@Payment_Type varchar(20),
@CheckNo int


AS
BEGIN

INSERT INTO Checks(Donor_SSN, Date_of_Donation, Payment_Type, CheckNo)
VALUES (@Donor_SSN, @Date_of_Donation, @Payment_Type, @CheckNo)

END


ALTER PROCEDURE ADDORGANIZATION
@Organization_Name varchar(64),
@Street_No varchar(20),
@Street_Name varchar(20),
@City varchar(20),
@State varchar(20),
@Zip varchar(20),
@Phone_Number varchar(20)

AS
BEGIN

INSERT INTO Organization(Organization_Name, Street_No, Street_Name, City, State, Zip, Phone_Number)
VALUES (@Organization_Name, @Street_No, @Street_Name, @City, @State, @Zip, @Phone_Number)

END




ALTER PROCEDURE ADDAFFILITATE_WITH  
@SSN varchar(20),
@Organization_Name varchar(64)

AS
BEGIN

INSERT INTO Affiliated_With(SSN, Organization_Name)
VALUES (@SSN, @Organization_Name)

END



CREATE PROCEDURE ADDBUSINESS 

@Organization_Name varchar(64),
@Business_Type varchar(20),
@Business_Size int,
@Company_Web_Site varchar(100)

AS
BEGIN

INSERT INTO Business(Organization_Name, Business_Type, Business_Size, Company_Web_Site)
VALUES (@Organization_Name, @Business_Type, @Business_Size, @Company_Web_Site)

END



CREATE PROCEDURE ADDCHURCH

@Organization_Name varchar(64),
@Religious_Affiliation varchar(20)

AS
BEGIN

INSERT INTO Church(Organization_Name, Religious_Affiliation)
VALUES (@Organization_Name, @Religious_Affiliation)

END



CREATE PROCEDURE ADDORGANIZATION_DONATION_DETAILS 

@Date_of_Donation date,
@Amount_of_Donation float(20),
@Name_of_Fund_Raising_Campaign varchar(64)

AS
BEGIN

INSERT INTO Organization_Donation_Details(Date_of_Donation, Amount_of_Donation, Name_of_Fund_Raising_Campaign)
VALUES (@Date_of_Donation, @Amount_of_Donation, @Name_of_Fund_Raising_Campaign)

END


CREATE PROCEDURE ADDORGANIZATION_MAKES 

@Organization_Name varchar(64),
@Date_of_Donation date

AS
BEGIN

INSERT INTO Organization_Makes(Organization_Name, Date_of_Donation)
VALUES (@Organization_Name, @Date_of_Donation)

END



CREATE PROCEDURE ADDORGANIZATION_TYPE_OF_PAYMENT 

@Organization_Name varchar(64),
@Date_of_Donation date,
@Payment_Type varchar(20)

AS
BEGIN

INSERT INTO Organization_Type_of_Payment(Organization_Name, Date_of_Donation, Payment_Type )
VALUES (@Organization_Name, @Date_of_Donation, @Payment_Type )

END



ALTER PROCEDURE ADDORGANIZATION_CREDIT_CARD 

 @Organization_Name varchar(64),
 @Date_of_Donation date,
 @Payment_Type varchar(20),
 @Credit_Card_No int,
 @Card_Type varchar(20),
 @Expiration_Date date
 
AS
BEGIN

INSERT INTO  Orgnization1_Credit_Card(Organization_Name, Date_of_Donation, Payment_Type, Credit_Card_No, Card_Type, Expiration_Date )
VALUES (@Organization_Name, @Date_of_Donation, @Payment_Type, @Credit_Card_No, @Card_Type, @Expiration_Date)

END



ALTER PROCEDURE ADDORGANIZATION_CHECKS 

@Organization_Name varchar(64),
@Date_of_Donation date,
@Payment_Type varchar(20),
@CheckNo int


AS
BEGIN

INSERT INTO Organization_Checks(Organization_Name, Date_of_Donation, Payment_Type, CheckNo)
VALUES (@Organization_Name, @Date_of_Donation, @Payment_Type, @CheckNo)

END


CREATE PROCEDURE  ADDORGANIZATON_SPONSORS 
@Organization_Name varchar(64),
@Team_Name varchar(64)

AS
BEGIN

INSERT INTO Organization_Sponsors(Organization_Name, Team_Name)
VALUES (@Organization_Name, @Team_Name)

END


ALTER PROCEDURE ADDTEAM_REPORTS 

@Team_Name varchar(64),
@Employee_SSN varchar(20),
@Description varchar(64),
@Date_of_Report date
 
AS
BEGIN

INSERT INTO Team_Reports(Team_Name, Employee_SSN, Description, Date_of_Report)
VALUES (@Team_Name, @Employee_SSN, @Description, @Date_of_Report)

END


ALTER PROCEDURE ADDEMPLOYEE_EXPENSES  
@Employee_SSN varchar(20),
@Date_of_Expense date,
@Amount_Expensed float(20),
@Description varchar(100)

AS
BEGIN

INSERT INTO Employee_Expenses(Employee_SSN, Date_of_Expense, Amount_Expensed, Description)
VALUES (@Employee_SSN, @Date_of_Expense, @Amount_Expensed, @Description)

END


alter Procedure Query10

@CLIENT_NO varchar(20)
AS
BEGIN


SELECT Doctor_Name, DoctorPhone

from Client_Doctor

where 

CLient_SSN =  @CLIENT_NO

END


Alter Procedure Query11

@Date1 date,
@Date2 date

AS
BEGIN

SELECT Employee_SSN, sum(Amount_Expensed)

from Employee_Expenses
where Date_of_Expense  between @Date1 and @Date2
Group by Employee_SSN
Order BY sum(Amount_Expensed)

END

Alter Procedure Query12

@TeamName varchar(64),
@ClientNo varchar(20)

AS
BEGIN

Select Volunteer_SSN
from Client_Care
where Team_Name = @TeamName and Client_SSN = @ClientNo
END



alter Procedure Query13

AS
BEGIN

select SSN, Name, Birth_Date, Race, Gender, Street_No, Street_Name, City, State, Zip
from [dbo].[Person]
where SSN in (Select Client_SSN
from Client_Care
where Team_Name in (select Team_Name
                      from Organization_Sponsors
                      where Organization_Name like 'B%' 
                        or Organization_Name like 'C%'
                      or Organization_Name like 'D%'
                      or  Organization_Name like 'E%' 
                      or  Organization_Name like 'F%'
                      or  Organization_Name like 'G%'
                      or  Organization_Name like 'H%'
                      or  Organization_Name like 'I%'
                      or  Organization_Name like 'J%'
                      or  Organization_Name like 'K%'))

END

alter Procedure Query14

AS
BEGIN

select Donor.Donor_SSN, Is_Anonymous, Amount_of_Donation
from (Donor left join Donor_Makes on Donor.Donor_SSN = Donor_Makes.Donor_SSN) join Donation_Details on Donor_Makes.Date_of_Donation = Donation_Details.Date_of_Donation
where Donor.Donor_SSN in (select Donor.Donor_SSN
from Donor
Where Donor.Donor_SSN in (Select Employee_SSN
                    from Employee))
Order by Amount_of_Donation                    

END




ALTER Procedure Query15

@DATEENTER DATE

AS
BEGIN

select Team_Name
from Team
where Date_Formed > @DATEENTER

END


ALTER PROCEDURE Query16

AS
BEGIN

Update Employee

set Employee_Salary = Employee_Salary*1.10
where Employee_SSN in (select Employee_SSN
                       from Team_Reports
                       group by Employee_SSN
                       having count(Team_Name)>=1)   

select Employee_SSN, Employee_Salary
from Employee                       
where Employee_SSN in (select Employee_SSN
                       from Team_Reports
                       group by Employee_SSN
                       having count(Team_Name)>=1)  

END   


Alter PROCEDURE Query17

AS
BEGIN

DELETE from [dbo].[Client]
where Client_SSN in ((Select Client_SSN
                     FROM Insurance_Policy
                     group by Client_SSN
                     having count(Policy_ID) <1)
                    union
                     (select Client_SSN
                     from Needs_List
                      where Needs_Type = 'Transportation' and Needs_Rank <5))

END   

Alter Procedure Query19

AS
BEGIN

SELECT Name, Street_No, Street_Name, City, State, Zip
FROM Person  
where On_Mailing_List = 'Yes'

END
