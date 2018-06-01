CREATE TABLE peca (

    id INT UNSIGNED AUTO_INCREMENT,
    descricao varchar(50) NOT NULL,
    nome varchar (50) NOT NULL,
    marca varchar (50) NOT NULL,
    primary key (id)



)Engine = Innodb default charset = utf8;

insert into peca (descricao,nome,marca) values ('500 gb','HD','Samgung');
insert into peca (descricao,nome,marca) values ('8 gb ddr3','memoria','Samgung');

