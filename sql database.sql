drop database philipsdb;

create database dbcancerdemama;

use dbcancerdemama;

create user 'java'@localhost IDENTIFIED BY 'Passw123!@';

create table regiao (id int auto_increment primary key, regiao varchar(20), total_exames int);

create table faixa_etaria (id int AUTO_INCREMENT primary key, faixa_i int, faixa_n int, descricao varchar(50));

create table incidencia (id int AUTO_INCREMENT PRIMARY KEY, regiao_id int, mes int, faixa_id int, qnt_exames int);

alter table incidencia  add constraint fk_regiao foreign key(regiao_id) references regiao(id);

alter table incidencia  drop constraint fk_faixa_etaria;

alter table incidencia  add constraint fk_faixa_etaria foreign key(faixa_id) references faixa_etaria(id);
