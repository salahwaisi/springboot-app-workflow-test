CREATE TABLE IF NOT EXISTS users
(
    id SERIAL NOT NULL PRIMARY KEY,
    firstName character varying(255),
    lastName character varying(255)
);