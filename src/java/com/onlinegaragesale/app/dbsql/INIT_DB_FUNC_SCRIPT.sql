CREATE OR REPLACE TRIGGER BID_BIDSTATUS_TRIG 
    AFTER UPDATE OF BIDSTATUS ON BID 
    FOR EACH ROW 
BEGIN 
  IF :NEW.BIDSTATUS = '1' THEN 
    ADD_SALES(:NEW.PRODID, :NEW.BIDAMOUNT, :NEW.USERID);
  END IF;
END; 
/


CREATE OR REPLACE TRIGGER BID_ID_TRG 
    BEFORE INSERT ON BID 
    FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
      SELECT BID_ID_SEQ.NEXTVAL INTO :NEW.BIDID FROM DUAL;
  END COLUMN_SEQUENCES;
END;       
/


CREATE OR REPLACE TRIGGER CATEGORY_ID_TRG 
    BEFORE INSERT ON CATEGORY 
    FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
      SELECT CATEGORY_ID_SEQ.NEXTVAL INTO :NEW.CATEGORYID FROM DUAL;
  END COLUMN_SEQUENCES;
END;       
/


CREATE OR REPLACE TRIGGER GARAGE_ID_TRG 
    BEFORE INSERT ON GARAGE 
    FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
      SELECT GARAGE_ID_SEQ.NEXTVAL INTO :NEW.GARAGEID FROM DUAL;
  END COLUMN_SEQUENCES;
END;       
/


CREATE OR REPLACE TRIGGER PRODUCTSALES_ID_TRG 
    BEFORE INSERT ON PRODUCTSALES 
    FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
      SELECT PRODUCTSALES_ID_SEQ.NEXTVAL INTO :NEW.PRODID FROM DUAL;
  END COLUMN_SEQUENCES;
END;        
/


CREATE OR REPLACE TRIGGER PRODUCT_ID_TRG 
    BEFORE INSERT ON PRODUCT 
    FOR EACH ROW 
BEGIN <<COLUMN_SEQUENCES>> BEGIN
  SELECT PRODUCT_ID_SEQ.NEXTVAL INTO :NEW.PRODID FROM DUAL;
END COLUMN_SEQUENCES;
END;       
/


CREATE OR REPLACE TRIGGER SALESHISTORY_ID_TRG 
    BEFORE INSERT ON SALESHISTORY 
    FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    SELECT SALESHISTORY_ID_SEQ.NEXTVAL INTO :NEW.USERID FROM DUAL;
  END COLUMN_SEQUENCES;
END;        
/


CREATE OR REPLACE TRIGGER USERACCOUNT_ID_TRIG 
    BEFORE INSERT ON USERACCOUNT 
    FOR EACH ROW 
BEGIN :NEW.USERID := CREATE_USERACCOUNT_ID;
END;          
/



CREATE OR REPLACE PROCEDURE ADD_SALES(
    P_PRODID    IN NUMBER ,
    P_BIDAMOUNT IN NUMBER ,
    P_BIDDERID  IN NUMBER )
AS
  V_GARAGEID      NUMBER;
  V_USERID        NUMBER;
  V_PRODCONDITION VARCHAR2(255);
  V_PRODDESC      VARCHAR2(255);
  V_PRODIMAGE BLOB;
BEGIN
  V_GARAGEID := GET_GARAGEID_FROM_PRODID(P_PRODID);
  V_USERID   := GET_USERID_FROM_GARAGEID(V_GARAGEID);
  
  SELECT PRODCONDITION, PRODDESC, PRODIMAGE
  INTO V_PRODCONDITION, V_PRODDESC, V_PRODIMAGE
  FROM PRODUCT
  WHERE PRODID = P_PRODID;
  
  UPDATE SALESHISTORY
  SET TOTALSALES   = (SELECT TOTALSALES FROM SALESHISTORY WHERE USERID = V_USERID) + P_BIDAMOUNT,
  TOTALSALESCOUNT  = (SELECT TOTALSALESCOUNT FROM SALESHISTORY WHERE USERID = V_USERID) + 1
  WHERE USERID     = V_USERID;
  
  INSERT
  INTO PRODUCTSALES
    ( PRODID, PRODCONDITION, PRODDESC, PRODIMAGE, PRODPRICE, USERID, BIDDERID )
    VALUES
    ( P_PRODID, V_PRODCONDITION, V_PRODDESC, V_PRODIMAGE, P_BIDAMOUNT, V_USERID, P_BIDDERID );
END ADD_SALES;
/

CREATE OR REPLACE FUNCTION CREATE_USERACCOUNT_ID
    RETURN NUMBER
  IS
  BEGIN
    RETURN TO_NUMBER(CONCAT(TO_CHAR(TO_CHAR(SYSDATE, 'YYYY')), USERACCOUNT_ID_SEQ.NEXTVAL), 99999999);
  EXCEPTION
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20001,'AN ERROR WAS ENCOUNTERED - '||SQLCODE||' -ERROR- '||SQLERRM);
  END;
/

CREATE OR REPLACE FUNCTION GET_GARAGEID_FROM_PRODID(P_PRODID IN NUMBER)
    RETURN NUMBER
  AS
    V_GARAGEID NUMBER;
  BEGIN
    SELECT GARAGEID INTO V_GARAGEID FROM PRODUCT WHERE PRODID = P_PRODID;
    RETURN V_GARAGEID;
  END GET_GARAGEID_FROM_PRODID;
/

CREATE OR REPLACE FUNCTION GET_USERID_FROM_GARAGEID(P_GARAGEID IN NUMBER)
    RETURN NUMBER
  AS
    V_USERID NUMBER;
  BEGIN
    SELECT USERID INTO V_USERID FROM GARAGE WHERE GARAGEID = P_GARAGEID;
    RETURN V_USERID;
  END GET_USERID_FROM_GARAGEID;
/

ALTER TRIGGER BID_ID_TRG DISABLE
/
ALTER TRIGGER CATEGORY_ID_TRG DISABLE
/
ALTER TRIGGER GARAGE_ID_TRG DISABLE
/
ALTER TRIGGER PRODUCT_ID_TRG DISABLE
/
ALTER TRIGGER PRODUCTSALES_ID_TRG DISABLE
/
ALTER TRIGGER SALESHISTORY_ID_TRG DISABLE
/
ALTER TRIGGER USERACCOUNT_ID_TRIG DISABLE
/