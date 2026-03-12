CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

-- The table will be created/updated by Hibernate (hbm2ddl.auto=update),
-- but you can run a manual SQL check with:
SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'inventory_db';
