create database qlks_project 
CHARACTER SET utf8
COLLATE utf8_unicode_ci;

use qlks_project;

create table khach_hang
(
id bigint not null primary key auto_increment,
name nvarchar(250) not null,
birthDay date not null,
gennder nvarchar(20) not null,
phone varchar(250) not null,
address nvarchar(150) not null,
identityCard varchar(250) not null,
nation varchar(250) not null,
numberOfCheckIn int default 1 not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table nhan_phong
(
id bigint not null primary key auto_increment,
id_KH bigint not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table CT_nhan_phong
(
id_NP bigint  not null,
id_phong varchar(10),
nameKH nvarchar(250) not null,
indentityCard varchar(250) not null,
receivedDate date not null,
payDateExpect date not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null

);

create table phong
(
id varchar(10) not null primary key,
id_LP bigint not null,
id_TTP bigint not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table loai_phong
(
id bigint not null primary key auto_increment,
name nvarchar(150) not null,
price float not null,
maxPeople int not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table thiet_bi
(
id bigint not null primary key auto_increment,
id_LP bigint not null,
name nvarchar(150) not null,
amount int not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table hoa_don
(
id bigint not null primary key auto_increment,
id_KH bigint not null,
id_NP bigint not null,
id_KM bigint not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table CT_hoa_don
(
id_HD bigint not null,
id_P varchar(10) not null,
id_sddv bigint not null,
id_CSTP bigint not null,
surcharge float null,
roomCharge float not null,
serviceFee float null,
discount float null,
payments nvarchar(100) not null,
numberDays  int,
totalMoney float not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table khuyen_mai
(
id bigint not null primary key auto_increment,
Code varchar(50) null,
value float null,
content nvarchar(250) null,
type bit null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null

);


create table dich_vu
(
id bigint not null primary key auto_increment,
id_LDV bigint not null,
id_DV bigint not null,
price float not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table loai_dich_vu
(
id bigint not null primary key auto_increment,
name nvarchar(150) not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table su_dung_dich_vu
(
id bigint not null,
id_DV bigint not null,
id_NP bigint not null,
amount int not null
);

create table nhan_vien
(
id bigint not null primary key auto_increment,
name nvarchar(250) not null,
birthDay date not null,
gender nvarchar(20) not null,
image text null,
email varchar(250) not null unique,
userName varchar(150) not null,
passWord text not null,
id_NQ bigint not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table nhom_quyen 
(
id bigint not null primary key auto_increment,
name nvarchar(250) not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table phan_quyen
(
id_Q bigint not null,
id_NQ bigint not null
);
	
create table quyen
(
id bigint not null primary key auto_increment,
name nvarchar(250) not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);