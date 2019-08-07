CREATE DATABASE Fiora;

USE Fiora;

CREATE TABLE usuario (
	login VARCHAR(10) NOT NULL,
	senha INT(10) NOT NULL,
	nome VARCHAR(30) NOT NULL,
	funcao VARCHAR(30),
	PRIMARY KEY (login)
); 

CREATE TABLE artista (
	codArtista INT AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL,
	genero VARCHAR(20),
	anoCriacao INT(4) NOT NULL,
	site VARCHAR(40),
    foto MEDIUMBLOB NOT NULL,
    tipoArtista VARCHAR(15) NOT NULL,
	loginUsuario VARCHAR(10) NOT NULL,
	PRIMARY KEY (codArtista),
	FOREIGN KEY (loginUsuario) REFERENCES usuario (login)
);

CREATE TABLE album (
	codAlbum INT AUTO_INCREMENT,
	titulo VARCHAR(30) NOT NULL,
    capa MEDIUMBLOB NOT NULL,
	anoLancamento INT(4) NOT NULL,
	gravadora VARCHAR(20),
    midia VARCHAR(15) NOT NULL,
    codArtista INT NOT NULL,
	loginUsuario VARCHAR(10) NOT NULL,
	PRIMARY KEY (codAlbum),
    FOREIGN KEY (codArtista) REFERENCES artista(codArtista),
	FOREIGN KEY (loginUsuario) REFERENCES usuario(login)
);

CREATE TABLE faixa (
	numeroFaixa INT(2) NOT NULL,
	nomeFaixa VARCHAR(35) NOT NULL,
    codAlbum INT NOT NULL,
	PRIMARY KEY (codAlbum, numeroFaixa),
    FOREIGN KEY (codAlbum) REFERENCES album(codAlbum)
);

INSERT INTO usuario (login, senha, funcao, nome) VALUES ("fiora", 123, "Administrador", "Renato Aparecido Fioranelli");

select * from usuario where login = 'aaaa';