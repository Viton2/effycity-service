create table if not exists users(
    id int not null primary key,
    name varchar(40) not null,
    email varchar(100) not null,
    password varchar(200) not null,
    role varchar(10) not null
);

INSERT INTO users VALUES
    (1,'admin@gmail.com','admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'admin'),
    (2,'test@gmail.com','test', '$2a$12$TYSPPDsgR1T9vpgMSavOteZoqzjGVLt7rzsqKLrGL4oQdE3rWDNru', 'test');