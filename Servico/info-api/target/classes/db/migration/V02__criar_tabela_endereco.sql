create table endereco(
    id int unsigned auto_increment,
	numero VARCHAR(10) not null,
	cep VARCHAR(15) ,
	cidade VARCHAR(30) not null,
    descricao varchar(100) not null,
    primary key (id)

)Engine=InnoDB default charset = utf8;


insert into endereco (numero,cep,cidade,descricao) values(' ', ' ',' ',' ');
