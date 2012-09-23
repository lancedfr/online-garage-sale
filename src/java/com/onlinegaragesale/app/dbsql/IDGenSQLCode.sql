CREATE SEQUENCE USERACCOUNT_ID_SEQ MINVALUE 1 MAXVALUE 99999999 INCREMENT BY 1 START WITH 4001 CACHE 20 NOORDER NOCYCLE;

CREATE OR REPLACE
  FUNCTION CREATE_USERACCOUNT_ID
    RETURN NUMBER
  IS
    SAMPLEID NUMBER;
  BEGIN
    RETURN TO_NUMBER(CONCAT(TO_CHAR(TO_CHAR(SYSDATE, 'YYYY')), USERACCOUNT_ID_SEQ.NEXTVAL), 99999999);
  EXCEPTION
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20001,'AN ERROR WAS ENCOUNTERED - '||SQLCODE||' -ERROR- '||SQLERRM);
  END;
  
CREATE OR REPLACE TRIGGER USERACCOUNT_ID_TRIG BEFORE
  INSERT ON USERACCOUNT FOR EACH ROW BEGIN :NEW.USERID := CREATE_USERACCOUNT_ID;
END;

INSERT
INTO USERACCOUNT
  (
    USERID, ACCOUNTPASSWORD, ADDRESSLINE, AREACODE, CITY, COUNTRY, ROAD, SUBURB, AGE, CELL, EMAIL, HOMETELL, WORKTELL, DOB, FIRSTNAME, LASTNAME, MIDDLENAME
  )
  VALUES
  (
    345, '345', '345', '345', '345', '345', '345', '345', 45, '3499', '345', '345', '345', TO_DATE('05-05-2005', 'DD-MM-YYYY'), '234', '234', '234'
  );




INSERT INTO USERACCOUNT (USERID,ACCOUNTPASSWORD,ADDRESSLINE,AREACODE,CITY,COUNTRY,ROAD,SUBURB,AGE,CELL,EMAIL,HOMETELL,WORKTELL,DOB,FIRSTNAME,LASTNAME,MIDDLENAME) VALUES (20124001,'LANCEREID','4 ROLWYN COURT','7945','CAPE TOWN','SOUTH AFRICA','VLEI ROAD','LAKESIDE',22,'0731129035','LANCEDFR@OUTLOOK.COM','7882966','7882566',TO_DATE('02/APR/90','DD/MON/RR'),'LANCE','REID','DAVID');
INSERT INTO USERACCOUNT (USERID,ACCOUNTPASSWORD,ADDRESSLINE,AREACODE,CITY,COUNTRY,ROAD,SUBURB,AGE,CELL,EMAIL,HOMETELL,WORKTELL,DOB,FIRSTNAME,LASTNAME,MIDDLENAME) VALUES (20124002,'DEVONRICHARDS','7 MIKE WAY','7945','CAPE TOWN','SOUTH AFRICA','9TH ROAD','TOKAI',20,'0758864589','DEVON@GMAIL.COM','7854568','7785542',TO_DATE('03/JUL/92','DD/MON/RR'),'DEVON','RICHARDS','CARL');
INSERT INTO USERACCOUNT (USERID,ACCOUNTPASSWORD,ADDRESSLINE,AREACODE,CITY,COUNTRY,ROAD,SUBURB,AGE,CELL,EMAIL,HOMETELL,WORKTELL,DOB,FIRSTNAME,LASTNAME,MIDDLENAME) VALUES (20124003,'DWAYNEPETERSON','22A MAIN FLAT','8080','CAPE TOWN','SOUTH AFRICA','6 EAST ROAD','TABLE VIEW',21,'0852368845','DWAYNE@GMAIL.COM','7882546','7895246',TO_DATE('22/FEB/91','DD/MON/RR'),'DWAYNE','PETERSON','SIMON');
INSERT INTO GARAGE (GARAGEID,USERID,GARAGETYPE,OPENDATE,CLOSEDATE) VALUES (1,20124001,'SMALL',TO_DATE('22/SEP/12','DD/MON/RR'),TO_DATE('22/OCT/12','DD/MON/RR'));
INSERT INTO GARAGE (GARAGEID,USERID,GARAGETYPE,OPENDATE,CLOSEDATE) VALUES (2,20124002,'BIG',TO_DATE('10/SEP/12','DD/MON/RR'),TO_DATE('10/OCT/12','DD/MON/RR'));
INSERT INTO GARAGE (GARAGEID,USERID,GARAGETYPE,OPENDATE,CLOSEDATE) VALUES (3,20124003,'MID',TO_DATE('22/AUG/12','DD/MON/RR'),TO_DATE('22/SEP/12','DD/MON/RR'));
INSERT INTO CATEGORY (CATEGORYID,CATEGORYTYPE) VALUES (1,'LIGHTING');
INSERT INTO CATEGORY (CATEGORYID,CATEGORYTYPE) VALUES (2,'ELECTRONIC');
INSERT INTO CATEGORY (CATEGORYID,CATEGORYTYPE) VALUES (3,'MOBILE');
INSERT INTO CATEGORY (CATEGORYID,CATEGORYTYPE) VALUES (4,'SOUND');
INSERT INTO PRODUCT (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES (1,'GOOD','NOKIA 701',3800,'0',1,3);
INSERT INTO PRODUCT (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES (2,'AVERAGE','NOKIA 5800',500,'0',1,3);
INSERT INTO PRODUCT (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES (3,'POOR','SAMSUNG',10,'1',1,3);
INSERT INTO PRODUCT (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES (4,'GOOD','LAMP',450,'0',2,1);
INSERT INTO PRODUCT (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES (5,'GOOD','HIFI',6600,'1',2,2);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (1,3700,'2',20124003,1);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (2,500,'2',20124003,2);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (3,10,'0',20124002,3);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (4,15,'1',20124003,3);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (5,430,'2',20124001,4);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (6,450,'2',20124002,4);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (7,6000,'0',20124001,5);
INSERT INTO BID (BIDID,BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (8,6600,'1',20124003,5);
INSERT INTO SALESHISTORY (USERID,TOTALSALES,TOTALSALESCOUNT) VALUES (20124001,10,1);
INSERT INTO SALESHISTORY (USERID,TOTALSALES,TOTALSALESCOUNT) VALUES (20124002,6600,1);
INSERT INTO PRODUCTSALES (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,USERID,BIDDERID) VALUES (3,'POOR','SAMSUNG',10,20124001,20124003);
INSERT INTO PRODUCTSALES (PRODID,PRODCONDITION,PRODDESC,PRODPRICE,USERID,BIDDERID) VALUES (5,'GOOD','HIFI',6600,20124002,20124003);



ALTER TRIGGER USERACCOUNT_ID_TRIG ENABLE
;
ALTER TRIGGER CATEGORY_ID_TRG ENABLE
;
ALTER TRIGGER PRODUCT_ID_TRG ENABLE
;
ALTER TRIGGER BID_ID_TRG ENABLE
;
INSERT INTO USERACCOUNT (ACCOUNTPASSWORD,ADDRESSLINE,AREACODE,CITY,COUNTRY,ROAD,SUBURB,AGE,CELL,EMAIL,HOMETELL,WORKTELL,DOB,FIRSTNAME,LASTNAME,MIDDLENAME) VALUES ('LANCEREID','4 ROLWYN COURT','7945','CAPE TOWN','SOUTH AFRICA','VLEI ROAD','LAKESIDE',22,'0731129035','LANCEDFR@OUTLOOK.COM','7882966','7882566',TO_DATE('02/APR/90','DD/MON/RR'),'JASON','HAKE','DAVID');
INSERT INTO USERACCOUNT (ACCOUNTPASSWORD,ADDRESSLINE,AREACODE,CITY,COUNTRY,ROAD,SUBURB,AGE,CELL,EMAIL,HOMETELL,WORKTELL,DOB,FIRSTNAME,LASTNAME,MIDDLENAME) VALUES ('DEVONRICHARDS','7 MIKE WAY','7945','CAPE TOWN','SOUTH AFRICA','9TH ROAD','TOKAI',20,'0758864589','DEVON@GMAIL.COM','7854568','7785542',TO_DATE('03/JUL/92','DD/MON/RR'),'MILL','MICH','CARL');
INSERT INTO USERACCOUNT (ACCOUNTPASSWORD,ADDRESSLINE,AREACODE,CITY,COUNTRY,ROAD,SUBURB,AGE,CELL,EMAIL,HOMETELL,WORKTELL,DOB,FIRSTNAME,LASTNAME,MIDDLENAME) VALUES ('DWAYNEPETERSON','22A MAIN FLAT','8080','CAPE TOWN','SOUTH AFRICA','6 EAST ROAD','TABLE VIEW',21,'0852368845','DWAYNE@GMAIL.COM','7882546','7895246',TO_DATE('22/FEB/91','DD/MON/RR'),'SAM','PETERSON','SIMON');
INSERT INTO CATEGORY (CATEGORYTYPE) VALUES ('GAMES');
INSERT INTO CATEGORY (CATEGORYTYPE) VALUES ('ELECTRONIC');
INSERT INTO CATEGORY (CATEGORYTYPE) VALUES ('VIDEO');
INSERT INTO CATEGORY (CATEGORYTYPE) VALUES ('IMAGE');
INSERT INTO PRODUCT (PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES ('GOOD','NOKIA 701',3800,'0',1,3);
INSERT INTO PRODUCT (PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES ('AVERAGE','NOKIA 5800',500,'0',1,3);
INSERT INTO PRODUCT (PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES ('POOR','SAMSUNG',10,'0',1,3);
INSERT INTO PRODUCT (PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES ('GOOD','LAMP',450,'0',2,1);
INSERT INTO PRODUCT (PRODCONDITION,PRODDESC,PRODPRICE,PRODSTATUS,GARAGEID,CATEGORYID) VALUES ('GOOD','HIFI',6600,'0',2,2);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (3700,'2',20124003,6);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (500,'2',20124003,7);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (10,'2',20124002,8);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (15,'2',20124003,8);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (430,'2',20124001,9);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (450,'2',20124002,9);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (6000,'2',20124001,10);
INSERT INTO BID (BIDAMOUNT,BIDSTATUS,USERID,PRODID) VALUES (6600,'2',20124003,10);

ALTER TRIGGER USERACCOUNT_ID_TRIG DISABLE
;
ALTER TRIGGER CATEGORY_ID_TRG DISABLE
;
ALTER TRIGGER PRODUCT_ID_TRG DISABLE
;
ALTER TRIGGER BID_ID_TRG DISABLE
;



UPDATE BID
SET BIDSTATUS = '1'
WHERE BIDID   = 6; --6 and 2

UPDATE BID
SET BIDSTATUS = '0'
WHERE PRODID  = 4;