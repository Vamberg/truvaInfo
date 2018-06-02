CREATE TABLE pessoa (
    id INT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(30) NOT NULL,
    id_endereco INT UNSIGNED,
    foreign key (id_endereco) references endereco(id),
    PRIMARY KEY(id)
)Engine = INNODB default charset = utf8;


insert into pessoa (nome,telefone,id_endereco) values(' ', ' ',1);
