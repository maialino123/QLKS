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


create table phong
(
id varchar(10) not null primary key,
id_LP bigint not null,
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
id_P varchar(10) not null,
id_TTHD bigint not null,
id_SDDV bigint,
hinh_thucTT nvarchar(250) not null,
phu_phi float null,
tien_phong float not null,
tien_dich_vu float null,
giam_giaKH float null,
so_ngay float not null,
thanh_tien float not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

create table trang_thai_hoa_don
(
id bigint not null primary key auto_increment,
name nvarchar(100) not null,
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
id bigint not null primary key auto_increment,
id_DV bigint not null,
amount int not null
);

create table nhan_vien
(
id bigint not null primary key auto_increment,
name nvarchar(250) not null,
birthDay date not null,
gender nvarchar(20) not null,
image BLOB null,
email varchar(250) not null unique,
userName varchar(150) not null,
passWord text not null,
cmnd varchar(12) not null,
degree nvarchar(100) null,
id_NQ	 bigint not null,
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
insert into nhom_quyen(name) values ('admin');

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

alter table hoa_don add constraint fk_hoa_don_KH foreign key (id_KH) references khach_hang(id);
alter table hoa_don add constraint fk_hoa_don_Phong foreign key (id_P) references phong(id);
alter table hoa_don add constraint fk_hoa_don_SDDV foreign key (id_SDDV) references su_dung_dich_vu(id);
alter table hoa_don add constraint fk_hoa_don_TTHD foreign key (id_TTHD) references trang_thai_hoa_don(id);
alter table phong add constraint fk_phong_LP foreign key (id_LP) references loai_phong(id);
alter table thiet_bi add constraint fk_thiet_bi_LP foreign key (id_LP) references loai_phong(id);
alter table su_dung_dich_vu add constraint fk_sddv_dv foreign key (id_DV) references dich_vu(id);
alter table dich_vu add constraint fk_dich_vu foreign key (id_LDV) references loai_dich_vu(id);
alter table nhan_vien add constraint fk_nhan_vien_NQ foreign key (id_NQ) references nhom_quyen(id);
alter table phan_quyen add constraint fk_phan_quyen_NQ foreign key (id_NQ) references nhom_quyen(id);
alter table phan_quyen add constraint fk_phan_quyen_Q foreign key (id_Q) references quyen(id);
alter table phan_quyen add constraint pk_Q_NQ primary key(id_Q,id_NQ);



DROP procedure IF EXISTS `get_all_nhan_vien`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_nhan_vien` ()
BEGIN
SELECT * FROM nhan_vien;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_one_nhan_vien`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_nhan_vien` 
(
iN Iid bigint
)
BEGIN
SELECT * FROM nhan_vien WHERE id = Iid;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_one_userName`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_userName` 
(
IN IuserName nvarchar(150)  COLLATE utf8_unicode_ci
)
BEGIN
SELECT * FROM nhan_vien WHERE userName = IuserName;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_one_email`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_email` 
(
IN Iemail nvarchar(250)  COLLATE utf8_unicode_ci
)
BEGIN
SELECT * FROM nhan_vien WHERE email = Iemail;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_one_cmnd`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_cmnd` 
(
IN Icmnd varchar(12)
)
BEGIN
SELECT * FROM nhan_vien WHERE cmnd= Icmnd;
END$$

DELIMITER ;


DROP procedure IF EXISTS `update_nhan_vien`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_nhan_vien` 
(
IN Iid bigint,
IN Iname nvarchar(250),
IN IbirthDay Date,
IN Igender nvarchar(20),
IN Iimage binary(250),
IN Iemail nvarchar(250) ,
IN IuserName nvarchar(150),
IN IpassWord text,
IN Icmnd varchar(12),
IN Iid_NQ bigint,
IN IcreatedDate timestamp,
IN IcreatedBy nvarchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy nvarchar(250)
)
BEGIN
UPDATE nhan_vien SET name = Iname , birthDay = IbirthDay, gender = Igender, image = Iimage, email = Iemail, userName = IuserName, passWord = IpassWord,cmnd = Icmnd,id_NQ =Iid_NQ  ,createdDate = IcreatedDate, createdBy = IcreatedBy,modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;
END$$

DELIMITER ;


DROP procedure IF EXISTS `delete_nhan_vien`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_nhan_vien` 
(
iN Iid bigint
)
BEGIN
DELETE FROM nhan_vien WHERE id = Iid;
END$$

DELIMITER ;

DROP procedure IF EXISTS `findByUserNameAndPassword_nhan_vien`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `findByUserNameAndPassword_nhan_vien` 
(
IN IuserName nvarchar(150) COLLATE utf8_unicode_ci
)
BEGIN
SELECT * FROM  nhan_vien AS n INNER JOIN nhom_quyen AS r ON r.id = n.id_NQ WHERE n.userName = IuserName;
END$$

DELIMITER ;



-- nhom_quyen_procedure

DROP procedure IF EXISTS `get_all_nhom_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_nhom_quyen` 
(
)
BEGIN
SELECT * FROM  nhom_quyen;
END$$

DELIMITER ;

DROP procedure IF EXISTS `add_nhom_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_nhom_quyen` 
(
IN Iname nvarchar(250),
IN IcreatedDate timestamp,
IN IcreatedBy nvarchar(250)

)
BEGIN
INSERT INTO nhom_quyen(name, createdDate, createdBy) values (Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

DROP procedure IF EXISTS `update_nhom_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_nhom_quyen` 
(
IN Iid bigint,
IN Iname nvarchar(250),
IN IcreatedDate timestamp,
IN IcreatedBy nvarchar(250),
IN ImodifedDate timestamp,
IN ImodifiedBy nvarchar(250)

)
BEGIN
UPDATE nhom_quyen SET name = Iname, createdDate = IcreatedDate, createdBy = IcreatedBy, modifedDate = ImodifiedDate, modifiedBy = ImodifedBy WHERE id = Iid;
END$$

DELIMITER ;


DROP procedure IF EXISTS `delete_nhom_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_nhom_quyen` 
(
IN Iid bigint
)
BEGIN
DELETE FROM  nhom_quyen WHERE id = Iid;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_one_nhom_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_nhom_quyen` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM  nhom_quyen WHERE id = Iid;
END$$

DELIMITER ;

-- phan quyen
DROP procedure IF EXISTS `add_phan_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_phan_quyen` 
(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
INSERT INTO phan_quyen(id_Q, id_NQ) values (Iid_Q, Iid_NQ);
SELECT @@identity;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_all_phan_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_phan_quyen` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM  nhom_quyen;
END$$

DELIMITER ;

DROP procedure IF EXISTS `update_phan_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_phan_quyen` 
(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
 UPDATE phan_quyen set id_Q = Iid_Q, id_NQ = Iid_NQ WHERE id_Q = Iid_Q AND id_NQ = Iid_NQ;
END$$

DELIMITER ;

DROP procedure IF EXISTS `delete_phan_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_phan_quyen` 
(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
DELETE FROM phan_quyen WHERE id_Q = Iid_Q AND id_NQ = Iid_NQ;
END$$

DELIMITER ;

DROP procedure IF EXISTS `get_one_phan_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_phan_quyen` 
(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
SELECT * FROM phan_quyen WHERE  id_Q = Iid_Q OR id_NQ = Iid_NQ;
END$$

DELIMITER ;

 USE `qlks_project`;
DROP procedure IF EXISTS `qlks_project`.`add_nhan_vien`;
;

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_nhan_vien`(
IN Iname nvarchar(250),
IN IbirthDay Date,
IN Igender nvarchar(20),
IN Iimage blob,
IN Iemail nvarchar(250) ,
IN IuserName nvarchar(150),
IN IpassWord text,
IN Icmnd varchar(12),
IN Iid_NQ bigint,
IN IcreatedDate timestamp,
IN IcreatedBy nvarchar(250)
)
BEGIN
INSERT INTO nhan_vien(name, birthDay, gender, image, email, userName, passWord,cmnd,id_NQ, createdDate, createdBy) values(Iname,IbirthDay,Igender,Iimage,Iemail,IuserName,IpassWord,Icmnd,Iid_NQ,IcreatedDate,IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;
;



