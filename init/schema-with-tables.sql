create database if not exists quiz character set utf8mb4 collate utf8mb4_unicode_ci;

use quiz;

create table if not exists quiz.question(
    id bigint auto_increment primary key,
    api_id bigint,
    question varchar(255)
);

create table if not exists quiz.answer(
    id bigint auto_increment primary key,
    correct bit,
    question_id bigint,
    answer varchar(255),
    foreign key (question_id) references quiz.question (id)
);