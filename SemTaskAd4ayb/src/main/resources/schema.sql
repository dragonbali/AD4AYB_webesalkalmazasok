CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE TASK (id LONG PRIMARY KEY, lesson VARCHAR2(80), todo VARCHAR2(80), date DATE);