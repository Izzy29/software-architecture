/* First, create the table */
create table STUDENT(
studentID int(6) PRIMARY KEY,
studentName varchar(20)
);

/* Second, input these data into the table */
INSERT INTO STUDENT VALUES (206457, 'Farhan');
INSERT INTO STUDENT VALUES (208429, 'Kamal');

/* Third, display all data */
SELECT * FROM STUDENT;