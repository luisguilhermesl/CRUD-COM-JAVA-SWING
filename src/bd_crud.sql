create database bd_crud;
use bd_crud;

create table usuarios(
id int not null auto_increment primary key,
nome varchar(100) not null,
sobrenome  varchar(100) not null,
email varchar(100) not null unique,
cidade varchar(100) not null,
cpf varchar(14) not null unique
)default charset = utf8mb4;

desc usuarios;

-- Inserindo usuários a tabela 
insert into usuarios (nome, sobrenome, email,cidade,cpf) values
('Marcio','Marcio Oliveira','marcio@oliveira.com','Tramandaí','123.456.789-00'),
('João','Claude','joao@claude.com','Pinhal','987.654.321-11'),
('Rodrigo','Carvalho','rodrigo@carvalho.com','Tramandaí','159.357.555-99');

-- Listando os registros inserindo na tabela
select * from usuarios;
