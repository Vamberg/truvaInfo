create table endereco(
    id int unsigned auto_increment,
	numero VARCHAR(10),
	cep VARCHAR(15),
	cidade VARCHAR(30),
    descricao varchar(100),
    primary key (id)

)Engine=InnoDB default charset = utf8;

