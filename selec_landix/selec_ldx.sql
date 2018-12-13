CREATE DATABASE LDXPS;

CREATE TABLE vendedores(
	CDVEND varchar(36) NOT NULL PRIMARY KEY, #CHAVE PRIMÁRIA NÃO PODE SER NULA
    DSNOME varchar(50) NOT NULL,
    CDTAB integer NOT NULL,
    DTNASC date
);

CREATE TABLE clientes(
	CDCL varchar(36) NOT NULL PRIMARY KEY,
    DSNOME varchar(50) NOT NULL,
    IDTIPO char(2) DEFAULT 'PF',
	CDVEND varchar(36),
    DSLIM decimal(15,2),
    FOREIGN KEY(CDVEND) REFERENCES vendedores(CDVEND)
);

CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';
