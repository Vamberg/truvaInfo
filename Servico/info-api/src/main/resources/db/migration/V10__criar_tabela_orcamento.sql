CREATE TABLE orcamento (

    id int unsigned not null,
    id_ordem_servico int unsigned not null,
    descricao VARCHAR(150) not null,
    data date not null,
    foreign key (id_ordem_servico) references ordem_servico(id),
    primary key(id)

)Engine = Innodb default charset = utf8;
