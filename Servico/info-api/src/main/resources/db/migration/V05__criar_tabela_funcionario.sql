CREATE TABLE funcionario (
    id INT UNSIGNED AUTO_INCREMENT,
    id_pessoa INT UNSIGNED,
    id_papel INT UNSIGNED,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    foreign key (id_papel) references papel(id),
    foreign key (id_pessoa) references pessoa(id),
    data_admissao date NOT NULL,
    PRIMARY KEY(ID)
    

)Engine = INNODB default charset = utf8;

