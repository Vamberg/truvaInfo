CREATE TABLE cliente(

    id int unsigned auto_increment,
    id_pessoa INT UNSIGNED,
    id_papel INT UNSIGNED,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)

)Engine = innodb default charset = utf8;
