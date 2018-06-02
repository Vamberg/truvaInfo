CREATE TABLE empresa(
     id int unsigned auto_increment,
     razao_social varchar(50) not null,
     nome_fantasia varchar(50) not null,
     cnpj varchar(50) not null,
     primary key (id)
    
)Engine=InnoDB default charset = utf8;


insert into empresa (nome_fantasia,razao_social,cnpj) values ('Truva Info','','00000');






