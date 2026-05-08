CREATE TABLE users (
                          id serial PrimaRY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          senha Varchar(255) NOT NULL
);