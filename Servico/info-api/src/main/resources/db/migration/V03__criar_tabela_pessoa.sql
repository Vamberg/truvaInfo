CREATE TABLE pessoa (
    id INT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(30) NOT NULL,
    id_endereco INT UNSIGNED,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    foreign key (id_endereco) references endereco(id),
    PRIMARY KEY(id)
)Engine = INNODB default charset = utf8;
