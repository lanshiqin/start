CREATE TABLE user(
    user_id bigint(20) not null AUTO_INCREMENT,
    name varchar(100) not null unique,
    primary key(user_id)
);