CREATE TABLE INDEXES (
  DB_ID INT NOT NULL REFERENCES DATABASES_ (DB_ID) ON DELETE CASCADE,
  TID INT NOT NULL REFERENCES TABLES (TID) ON DELETE CASCADE,
  INDEX_NAME VARCHAR(128) NOT NULL,
  COLUMN_NAME VARCHAR(128) NOT NULL,
  DATA_TYPE VARCHAR(128) NOT NULL,
  INDEX_TYPE CHAR(32) NOT NULL,
  PATH VARCHAR(4096),
  IS_UNIQUE BOOLEAN NOT NULL,
  IS_CLUSTERED BOOLEAN NOT NULL,
  IS_ASCENDING BOOLEAN NOT NULL,
  CONSTRAINT C_INDEXES_PK PRIMARY KEY (DB_ID, INDEX_NAME)
)