-- Generated by Oracle SQL Developer Data Modeler 3.1.2.704
--   at:        2012-09-16 11:33:36 CAT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



DROP TABLE BID CASCADE CONSTRAINTS 
;
DROP TABLE CATEGORY CASCADE CONSTRAINTS 
;
DROP TABLE GARAGE CASCADE CONSTRAINTS 
;
DROP TABLE PRODUCT CASCADE CONSTRAINTS 
;
DROP TABLE PRODUCTSALES CASCADE CONSTRAINTS 
;
DROP TABLE SALESHISTORY CASCADE CONSTRAINTS 
;
DROP TABLE USERACCOUNT CASCADE CONSTRAINTS 
;
DROP SEQUENCE USERACCOUNT_ID_SEQ
;

CREATE TABLE BID 
    ( 
     BIDID NUMBER (19)  NOT NULL , 
     BIDAMOUNT NUMBER (19,2) , 
     USERID NUMBER (19,2) , 
     PRODID NUMBER (19) 
    ) 
        TABLESPACE USERS 
        LOGGING 
;


CREATE UNIQUE INDEX BID_PK ON BID 
    ( 
     BIDID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE BID 
    ADD CONSTRAINT BID_PK PRIMARY KEY ( BIDID ) 
    USING INDEX BID_PK ;



CREATE TABLE CATEGORY 
    ( 
     CATEGORYID NUMBER (19)  NOT NULL , 
     CATEGORYTYPE VARCHAR2 (255 BYTE) , 
     PRODID NUMBER (19) 
    ) 
        TABLESPACE USERS 
        LOGGING 
;


CREATE UNIQUE INDEX CATEGORY_PK ON CATEGORY 
    ( 
     CATEGORYID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;
CREATE INDEX CATEGORY_CATAGORYTYPE_INDEX ON CATEGORY 
    ( 
     CATEGORYTYPE ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE CATEGORY 
    ADD CONSTRAINT CATEGORY_PK PRIMARY KEY ( CATEGORYID ) 
    USING INDEX CATEGORY_PK ;



CREATE TABLE GARAGE 
    ( 
     GARAGEID NUMBER (19)  NOT NULL , 
     CLOSEDATE DATE , 
     GARAGETYPE VARCHAR2 (255 BYTE) , 
     OPENDATE DATE  NOT NULL , 
     USERID NUMBER (19) 
    ) 
        TABLESPACE USERS 
        LOGGING 
;


CREATE UNIQUE INDEX GARAGE_PK ON GARAGE 
    ( 
     GARAGEID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE GARAGE 
    ADD CONSTRAINT GARAGE_PK PRIMARY KEY ( GARAGEID ) 
    USING INDEX GARAGE_PK ;



CREATE TABLE PRODUCT 
    ( 
     PRODID NUMBER (19)  NOT NULL , 
     GARAGE_USERID NUMBER (19,2) , 
     PRODCONDITION VARCHAR2 (255 BYTE) , 
     PRODDESC VARCHAR2 (255 BYTE) , 
     PRODIMAGE BLOB , 
     PRODPRICE NUMBER (19,2) , 
     GARAGEID NUMBER (19) 
    ) 
        TABLESPACE USERS 
        LOGGING 
    LOB ( PRODIMAGE ) STORE AS 
        ( 
        TABLESPACE USERS 
        STORAGE ( 
            PCTINCREASE 0 
            MINEXTENTS 1 
            MAXEXTENTS UNLIMITED 
            FREELISTS 1 
            BUFFER_POOL DEFAULT 
        ) 
        CHUNK 8192 
        RETENTION 
        ENABLE STORAGE IN ROW
        NOCACHE LOGGING 
    ) 
;


CREATE UNIQUE INDEX PRODUCT_PK ON PRODUCT 
    ( 
     PRODID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE PRODUCT 
    ADD CONSTRAINT PRODUCT_PK PRIMARY KEY ( PRODID ) 
    USING INDEX PRODUCT_PK ;



CREATE TABLE PRODUCTSALES 
    ( 
     PRODID NUMBER (19)  NOT NULL , 
     PRODCONDITION VARCHAR2 (255 BYTE) , 
     PRODDESC VARCHAR2 (255 BYTE) , 
     PRODIMAGE BLOB , 
     PRODPRICE NUMBER (19,2) , 
     USERID NUMBER (19) 
    ) 
        TABLESPACE USERS 
        LOGGING 
    LOB ( PRODIMAGE ) STORE AS 
        ( 
        TABLESPACE USERS 
        STORAGE ( 
            PCTINCREASE 0 
            MINEXTENTS 1 
            MAXEXTENTS UNLIMITED 
            FREELISTS 1 
            BUFFER_POOL DEFAULT 
        ) 
        CHUNK 8192 
        RETENTION 
        ENABLE STORAGE IN ROW
        NOCACHE LOGGING 
    ) 
;


CREATE UNIQUE INDEX PRODUCTSALES_PK ON PRODUCTSALES 
    ( 
     PRODID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE PRODUCTSALES 
    ADD CONSTRAINT PRODUCTSALES_PK PRIMARY KEY ( PRODID ) 
    USING INDEX PRODUCTSALES_PK ;



CREATE TABLE SALESHISTORY 
    ( 
     USERID NUMBER (19)  NOT NULL , 
     SALESID NUMBER (19,2)  NOT NULL , 
     TOTALSALES NUMBER (19,2) , 
     TOTALSALESCOUNT NUMBER (5) 
    ) 
        TABLESPACE USERS 
        LOGGING 
;


CREATE UNIQUE INDEX SALESHISTORY_PK ON SALESHISTORY 
    ( 
     USERID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE SALESHISTORY 
    ADD CONSTRAINT SALESHISTORY_PK PRIMARY KEY ( USERID ) 
    USING INDEX SALESHISTORY_PK ;



CREATE TABLE USERACCOUNT 
    ( 
     USERID NUMBER (19)  NOT NULL , 
     ACCOUNTPASSWORD VARCHAR2 (255 BYTE)  NOT NULL , 
     ADDRESSLINE VARCHAR2 (255 BYTE) , 
     AREACODE VARCHAR2 (255 BYTE) , 
     CITY VARCHAR2 (255 BYTE) , 
     COUNTRY VARCHAR2 (255 BYTE) , 
     ROAD VARCHAR2 (255 BYTE) , 
     SUBURB VARCHAR2 (255 BYTE) , 
     AGE NUMBER (19,2) , 
     CELL VARCHAR2 (255 BYTE) , 
     EMAIL VARCHAR2 (255 BYTE) , 
     HOMETELL VARCHAR2 (255 BYTE) , 
     WORKTELL VARCHAR2 (255 BYTE) , 
     DOB DATE  NOT NULL , 
     FIRSTNAME VARCHAR2 (255 BYTE)  NOT NULL , 
     LASTNAME VARCHAR2 (255 BYTE)  NOT NULL , 
     MIDDLENAME VARCHAR2 (255 BYTE) 
    ) 
        TABLESPACE USERS 
        LOGGING 
;


CREATE UNIQUE INDEX USERACCOUNT_PK ON USERACCOUNT 
    ( 
     USERID ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;
CREATE INDEX USERACCOUNT_CITY_INDEX ON USERACCOUNT 
    ( 
     CITY ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;
CREATE INDEX USERACCOUNT_LASTNAME_INDEX ON USERACCOUNT 
    ( 
     LASTNAME ASC 
    ) 
    TABLESPACE USERS 
    LOGGING 
;

ALTER TABLE USERACCOUNT 
    ADD CONSTRAINT USERACCOUNT_PK PRIMARY KEY ( USERID ) 
    USING INDEX USERACCOUNT_PK ;




ALTER TABLE BID 
    ADD CONSTRAINT FK100DD5C36971C FOREIGN KEY 
    ( 
     PRODID
    ) 
    REFERENCES PRODUCT 
    ( 
     PRODID
    ) 
    NOT DEFERRABLE 
;


ALTER TABLE PRODUCT 
    ADD CONSTRAINT FK185958CF937726CE FOREIGN KEY 
    ( 
     GARAGEID
    ) 
    REFERENCES GARAGE 
    ( 
     GARAGEID
    ) 
    NOT DEFERRABLE 
;


ALTER TABLE CATEGORY 
    ADD CONSTRAINT FK31A8ACFE5C36971C FOREIGN KEY 
    ( 
     PRODID
    ) 
    REFERENCES PRODUCT 
    ( 
     PRODID
    ) 
    NOT DEFERRABLE 
;


ALTER TABLE GARAGE 
    ADD CONSTRAINT FK7CE24F27BA9B6423 FOREIGN KEY 
    ( 
     USERID
    ) 
    REFERENCES USERACCOUNT 
    ( 
     USERID
    ) 
    NOT DEFERRABLE 
;


ALTER TABLE PRODUCTSALES 
    ADD CONSTRAINT FKC7A9217D6F9B2993 FOREIGN KEY 
    ( 
     USERID
    ) 
    REFERENCES SALESHISTORY 
    ( 
     USERID
    ) 
    NOT DEFERRABLE 
;


ALTER TABLE SALESHISTORY 
    ADD CONSTRAINT FKD8F67E08BA9B6423 FOREIGN KEY 
    ( 
     USERID
    ) 
    REFERENCES USERACCOUNT 
    ( 
     USERID
    ) 
    NOT DEFERRABLE 
;

CREATE SEQUENCE USERACCOUNT_ID_SEQ MINVALUE 1 MAXVALUE 99999999 INCREMENT BY 1 START WITH 4021 CACHE 20 NOORDER NOCYCLE ;

create or replace
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
  /

CREATE OR REPLACE TRIGGER USERACCOUNT_ID_TRIG 
    BEFORE INSERT ON USERACCOUNT 
    FOR EACH ROW 
BEGIN :NEW.USERID := CREATE_USERACCOUNT_ID;
END; 
/





-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                            10
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          1
-- CREATE TRIGGER                           1
-- ALTER TRIGGER                            0
-- CREATE STRUCTURED TYPE                   0
-- CREATE COLLECTION TYPE                   0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          1
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
