CREATE TABLE funcionario (
    id INT UNSIGNED AUTO_INCREMENT,
    id_pessoa INT UNSIGNED,
    id_papel INT UNSIGNED,
    email VARCHAR(50) NOT NULL unique,
    senha VARCHAR(150) NOT NULL,
    ativo BOOLEAN NOT NULL,
    foreign key (id_papel) references papel(id),
    foreign key (id_pessoa) references pessoa(id),
    data_admissao date NOT NULL,
    PRIMARY KEY(id)
    

)Engine = INNODB default charset = utf8;



insert into funcionario (id_pessoa,id_papel,email,senha,ativo,data_admissao) values(1,1,'admin@admin.com','$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.',1,now());
