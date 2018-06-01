CREATE TABLE ordem_servico(
    id INT UNSIGNED AUTO_INCREMENT,
    data_abertura date not null,
    data_baixa date,
    orcamento varchar(60),
    status varchar(30),
    data_orcamento date,
    id_funcionario int unsigned not null, 
    id_responsavel int unsigned not null,
    suposto_problema varchar(50),
    id_cliente int unsigned not null,
    id_equipamento int unsigned not null,
    constraint fk_func foreign key (id_funcionario) references funcionario(id),
    constraint fk_resp foreign key (id_responsavel) references funcionario(id),
    constraint fk_cl foreign key (id_cliente) references cliente(id),
    foreign key (id_equipamento) references equipamento(id),
    primary key (id)
    
)Engine = Innodb default charset = utf8;
