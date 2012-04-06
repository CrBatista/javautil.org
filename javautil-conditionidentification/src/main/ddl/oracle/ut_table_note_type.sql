
  CREATE TABLE UT_TABLE_NOTE_TYPE
   (	TABLE_ID VARCHAR2(8) NOT NULL ENABLE,
	NOTE_TYPE_ID VARCHAR2(8) NOT NULL ENABLE,
	ENTRY_USER NUMBER(9,0) NOT NULL ENABLE,
	ENTRY_TM DATE NOT NULL ENABLE,
	MOD_USER NUMBER(9,0),
	MOD_TM DATE,
	 CONSTRAINT UTNT_UT_FK FOREIGN KEY (TABLE_ID)
	  REFERENCES UT_TABLE (TABLE_ID) ENABLE,
	 CONSTRAINT UTNT_UNT_FK FOREIGN KEY (NOTE_TYPE_ID)
	  REFERENCES UT_NOTE_TYPE (NOTE_TYPE_ID) ENABLE
   );

