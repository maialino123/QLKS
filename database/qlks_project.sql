create database qlks_project 
CHARACTER SET utf8
COLLATE utf8_unicode_ci;

use qlks_project;

create table khach_hang
(
id bigint not null primary key auto_increment,
nameKH nvarchar(250) not null,
birthDayKH date not null,
gennderKH nvarchar(20) not null,
phoneKH varchar(250) not null,
addressKH nvarchar(150) not null,
identityCardKH varchar(250) not null,
nationKH varchar(250) not null,
numberOfCheckInKH int default 1 not null,
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

alter table phong add status bit;

create table loai_phong
(
id bigint not null primary key auto_increment,
name_LP nvarchar(150) not null,
price_LP float not null,
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
name_TP nvarchar(150) not null,
amount_TP int not null,
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

alter table hoa_don
add so_ngay_thuc_te datetime;
alter table hoa_don
add so_ngay_du_kien datetime;


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

create table don_vi
(
id bigint not null primary key auto_increment,
name_DV nvarchar(150) not null,
createdDate timestamp null,
createdBy nvarchar(250) null,
modifiedDate timestamp null,
modifiedBy nvarchar(250) null
);

alter table dich_vu add constraint fk_dich_vu_dv foreign key (id_dv) references don_vi(id);
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
alter table su_dung_dich_vu add constraint pk_SDDV_P foreign key (id_P) references phong(id);




DROP procedure IF EXISTS `get_all_nhan_vien`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_nhan_vien` ()
BEGIN
SELECT * FROM nhan_vien AS n INNER JOIN nhom_quyen AS q ON q.id = n.id_NQ;
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
IN IcreatedBy nvarchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy nvarchar(250),
IN Iid bigint
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
INSERT INTO nhom_quyen(name_NQ, createdDate, createdBy) values (Iname, IcreatedDate, IcreatedBy);
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
UPDATE nhom_quyen SET name_NQ = Iname, createdDate = IcreatedDate, createdBy = IcreatedBy, modifedDate = ImodifiedDate, modifiedBy = ImodifedBy WHERE id = Iid;
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
IN Iname nvarchar(250) COLLATE utf8_unicode_ci,
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


USE `qlks_project`;
DROP procedure IF EXISTS `add_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_quyen` 
(
IN Iname varchar(250),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO quyen(name, createdDate, createdBy) values(Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

DELIMITER ;


USE `qlks_project`;
DROP procedure IF EXISTS `get_one_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_quyen` 
(

IN Iid bigint
)
BEGIN 
SELECT * FROM quyen WHERE id = Iid;
END$$

DELIMITER ;


USE `qlks_project`;
DROP procedure IF EXISTS `update_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_quyen` 
(
IN Iname varchar(250),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE quyen SET name = Iname, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;
END$$

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_quyen`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_quyen` 
(

IN Iid bigint
)
BEGIN
DELETE FROM quyen WHERE id = Iid;
END$$

DELIMITER ;
-- --Khach_hang 


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_khach_hang`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_khach_hang` 
(
IN Iname varchar(250),
IN IbirthDay date,
IN Igender varchar(20),
IN Iphone varchar(250),
IN Iaddress varchar(150),
IN IidentityCard varchar(250),
IN Ination varchar(250),
IN InumberOfCheckIn int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO khach_hang(name, birthDay, gennder, phone, address, identityCard, nation, numberOfCheckIn, createdDate, createdBy) 
values(Iname, IbirthDay, Igender, Iphone, Iaddress, IidentityCard,Ination, InumberOfCheckIn, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_khach_hang`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_khach_hang` 
(
IN Iname varchar(250),
IN IbirthDay date,
IN Igender varchar(20),
IN Iphone varchar(250),
IN Iaddress varchar(150),
IN IidentityCard varchar(250),
IN Ination varchar(250),
IN InumberOfCheckIn int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE khach_hang SET name = Iname, birthDay = IbirthDay, gennder = Igender, phone = Iphone, address = Iaddress,
 identityCard  = IitendityCard, nation = Ination, numberOfCheckIn = InumberOfCheckIn, createdDate = IcreatedDate,
 createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_khach_hang`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_khach_hang` 
(

)
BEGIN
SELECT * FROM khach_hang;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_cmnd_khach_hang`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_cmnd_khach_hang` 
(
IN IidentityCard varchar(250)

)
BEGIN
SELECT * FROM khach_hang WHERE identityCard = IidentityCard;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_khach_hang`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_khach_hang` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM khach_hang WHERE id = Iid;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_khach_hang`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_khach_hang` 
(
IN Iid bigint
)
BEGIN
DELETE FROM khach_hang WHERE id = Iid;

END$$

DELIMITER ;



-- hoa_don

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_hoa_don` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM hoa_don WHERE id = Iid ;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_id_P_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_id_P_hoa_don` 
(
IN Iid_P varchar(10)
)
BEGIN
SELECT * FROM hoa_don INNER JOIN trang_thai_hoa_don ON trang_thai_hoa_don.id = hoa_don.id_TTHD WHERE id_P = Iid_P ;
END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_hoa_don` 
(

)
BEGIN
SELECT * FROM hoa_don AS hd INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH
INNER JOIN phong AS p ON p.id = hd.id_P
INNER JOIN trang_thai_hoa_don AS tt ON tt.id = hd.id_TTHD;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_allNotSDDV_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_allNotSDDV_hoa_don` 
(

)
BEGIN
SELECT * FROM hoa_don AS hd INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH
INNER JOIN phong AS p ON p.id = hd.id_P
INNER JOIN trang_thai_hoa_don AS tt ON tt.id = hd.id_TTHD;
END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_join_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_join_hoa_don` 
(
IN IidHD bigint
)
BEGIN
SELECT * FROM hoa_don AS hd INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH
INNER JOIN phong AS p ON p.id = hd.id_P
INNER JOIN trang_thai_hoa_don AS tt ON tt.id = hd.id_TTHD
INNER JOIN su_dung_dich_vu AS sddv ON sddv.id = hd.id_SDDV WHERE hd.id = IidHD;
END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_hoa_don` 
(
IN Iid_KH bigint,
IN Iid_P varchar(10),
IN Iid_TTHD bigint,
IN Ihinh_thucTT varchar(250),
IN Itien_phong float,
IN Igiam_giaKH float,
IN Iso_ngay float,
IN Ithanh_tien float,
IN IcreatedDate timestamp,
IN IcraetedBy varchar(250),
IN Iso_ngay_du_kien date,
IN Ingay_den_thuc_te date,
IN Ingay_den_du_kien date
)
BEGIN
INSERT INTO hoa_don(id_KH, id_P, id_TTHD, hinh_thucTT, tien_phong,giam_giaKH,so_ngay,thanh_tien,createdDate, createdBy,so_ngay_du_kien, ngay_den_thuc_te, ngay_den_du_kien) 
values(Iid_KH, Iid_P, Iid_TTHD, Ihinh_thucTT, Itien_phong,Igiam_giaKH,Iso_ngay,Ithanh_tien,IcreatedDate, IcraetedBy,Iso_ngay_du_kien, Ingay_den_thuc_te, Ingay_den_du_kien);
SELECT @@identity;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_hoa_don` 
(
IN Iid_KH bigint,
IN Iid_P varchar(10),
IN Iid_TTHD bigint,
IN Iid_SDDV bigint,
IN Ihinh_thucTT varchar(250),
IN Iphu_phi float,
IN Itien_phong float,
IN Itien_dich_vu float,
IN Igiam_giaKH float,
IN Iso_ngay float,
IN Ithanh_tien float,
IN IcreatedDate timestamp,
IN IcraetedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iso_ngay_thuc_te date,
IN Iso_ngay_du_kien date,
IN Ingay_den_thuc_te date,
IN Ingay_den_du_kien date,
IN Iid bigint
)
BEGIN
UPDATE hoa_don SET id_KH = Iid_KH, id_P = Iid_P, id_TTHD = Iid_TTHD, id_SDDV = Iid_SDDV, 
hinh_thucTT = Ihinh_thucTT, phu_phi = Iphu_phi, tien_phong = Itien_phong, 
tien_dich_vu = Itien_dich_vu,giam_giaKH = Igiam_giaKH,so_ngay = Iso_ngay,
thanh_tien=Ithanh_tien,createdDate=IcreatedDate, createdBy=IcraetedBy,
modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy,so_ngay_thuc_te = Iso_ngay_thuc_te, so_ngay_du_kien = Iso_ngay_du_kien, so_ngay_du_kien = Iso_ngay_du_kien,ngay_den_du_kien = Ingay_den_du_kien WHERE id = Iid;


END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_hoa_don` 
(

IN Iid bigint
)
BEGIN
DELETE FROM hoa_don WHERE id = Iid;


END$$

DELIMITER ;

-- dich_vu

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_dich_vu` 
(

)
BEGIN
SELECT * FROM dich_vu AS d 
INNER JOIN  loai_dich_vu AS l ON l.id = d.id_LDV
INNER JOIN don_vi AS v ON v.id = d.id_DV;
END$$

DELIMITER ;




DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_dich_vu` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM dich_vu AS dv 
INNER JOIN loai_dich_vu AS ld ON ld.id = dv.id_LDV
INNER JOIN don_vi AS d ON d.id = dv.id_DV
WHERE dv.id = Iid;


END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_dich_vu` 
(
IN Iid bigint
)
BEGIN
DELETE FROM dich_vu WHERE id = Iid;


END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_dich_vu` 
(
IN Iid_LDV bigint,
IN Iprice float,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN Iid_DV bigint
)
BEGIN
INSERT INTO dich_vu(id_LDV, price, createdDate, createdBy, id_DV) values(Iid_LDV, Iprice, IcreatedDate, IcreatedBy, Iid_DV);
SELECT @@identity;

END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_dich_vu` 
(
IN Iid_LDV bigint,
IN Iprice float,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid_DV bigint,
IN Iid bigint
)
BEGIN
UPDATE dich_vu SET id_LDV = Iid_LDV, price = Iprice, createdDate = IcreatedDate, createdBy = IcreatedBy, id_DV = Iid_DV ,modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;
END$$

DELIMITER ;

-- khuyen_mai-- 

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_khuyen_mai` 
(

)
BEGIN
SELECT * FROM khuyen_mai;


END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_code_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_code_khuyen_mai` 
(
IN Icode varchar(50)
)
BEGIN
SELECT * FROM khuyen_mai WHERE code = Icode;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_type_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_type_khuyen_mai` 
(
IN Itype bit
)
BEGIN
SELECT * FROM khuyen_mai WHERE type = Itype;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_khuyen_mai` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM khuyen_mai WHERE id = Iid;


END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_khuyen_mai` 
(
IN Iid bigint
)
BEGIN
DELETE FROM khuyen_mai WHERE id = Iid;


END$$

DELIMITER ;



DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_khuyen_mai` 
(
IN Icode varchar(50),
IN Ivalue float,
IN Icontent varchar(250),
IN Itype bit(1),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN Ithoi_gian_bat_dau date,
IN Ithoi_gian_ket_thuc date
)
BEGIN
INSERT INTO khuyen_mai(code, value, content, type, createdDate, createdBy, thoi_gian_bat_dau, thoi_gian_ket_thuc) values(Icode, Ivalue, Icontent, Itype, IcreatedDate, IcreatedBy,Ithoi_gian_bat_dau,Ithoi_gian_ket_thuc);
SELECT @@identity;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_khuyen_mai`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_khuyen_mai` 
(
IN Icode varchar(50),
IN Ivalue float,
IN Icontent varchar(250),
IN Itype bit(1),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Ithoi_gian_bat_dau date,
IN Ithoi_gian_ket_thuc date,
IN Iid bigint
)
BEGIN
UPDATE khuyen_mai SET code = Icode, value = Ivalue, content = Icontent, type = Itype, createdDate = IcreatedDate, createdBy= IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy, thoi_gian_bat_dau = Ithoi_gian_bat_dau, thoi_gian_ket_thuc = Ithoi_gian_ket_thuc WHERE id = Iid;


END$$

DELIMITER ;

-- loai_dich_vu


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_loai_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_loai_dich_vu` 
(

)
BEGIN
SELECT * FROM loai_dich_vu;

END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_name_loai_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_name_loai_dich_vu` 
(
IN Iname_LDV varchar(150)
)
BEGIN
SELECT * FROM loai_dich_vu WHERE name_LDV = Iname_LDV COLLATE utf8_unicode_ci;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_loai_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_loai_dich_vu` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM loai_dich_vu WHERE id = Iid;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_loai_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_loai_dich_vu` 
(
IN Iid bigint
)
BEGIN
DELETE FROM loai_dich_vu WHERE id = Iid;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_loai_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_loai_dich_vu` 
(
IN Iname varchar(150),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO loai_dich_vu(name_LDV, createdDate, createdBy) values(Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_loai_dich_vu`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_loai_dich_vu` 
(
IN Iname varchar(150),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodfiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE loai_dich_vu SET name_LDV = Iname, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodfiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;

END$$

DELIMITER ;

-- loai_phong

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_loai_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_loai_phong` 
(

)
BEGIN
SELECT * FROM loai_phong;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_loai_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_loai_phong` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM loai_phong WHERE id = Iid;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_name_loai_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_name_loai_phong` 
(
IN Iname_LP varchar(150)
)
BEGIN
SELECT * FROM loai_phong WHERE name_LP = Iname_LP COLLATE utf8_unicode_ci;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_loai_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_loai_phong` 
(
IN Iid bigint
)
BEGIN
DELETE FROM loai_phong WHERE id = Iid;
END$$

DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_loai_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_loai_phong` 
(
IN Iname_LP varchar(150),
IN Iprice float,
IN ImaxPeople int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO loai_phong(name_LP, price, maxPeople, createdDate, createdBy) values(Iname_LP, Iprice, ImaxPeople, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_loai_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_loai_phong` 
(
IN Iname_LP varchar(150),
IN Iprice float,
IN ImaxPeople int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
Update loai_phong SET name_LP = Iname_LP, price = Iprice, maxPeople = ImaxPeople, createdDate = IcreatedDate, createdBy = IcreatedBy WHERE id = Iid;
END$$

DELIMITER ;


-- phong
DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_phong` 
(

)
BEGIN
SELECT * FROM phong AS p INNER JOIN loai_phong AS l ON l.id = p.id_LP;

END$$

DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_phong` 
(
IN Iid varchar(10)
)
BEGIN
SELECT * FROM phong AS p INNER JOIN loai_phong AS l ON l.id = p.id_lp WHERE p.id = Iid;

END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_count_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_count_phong` 
(

)
BEGIN
SELECT count(*) FROM phong;
END$$
DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_by_status_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_by_status_phong` 
(
IN Istatus bit
)
BEGIN
SELECT * FROM phong WHERE status = Istatus;

END$$


DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_phong` 
(
IN Iid varchar(10)
)
BEGIN
DELETE FROM phong WHERE id = Iid;

END$$


DELIMITER ;



DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_phong` 
(
IN Iid varchar(10),
IN Iid_LP bigint,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN Istatus varchar(100)
)
BEGIN
INSERT INTO phong(id,id_LP, createdDate, createdBy, status) values (Iid,Iid_LP, IcreatedDate, IcreatedBy, Istatus);
SELECT @@identity;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_phong`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_phong` 
(
IN Iid_LP bigint,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Istatus varchar(100),
IN Iid varchar(10)
)
BEGIN
UPDATE phong SET id_LP = Iid_LP, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodifiedDate,modifiedBy = ImodifiedBy ,status = Istatus WHERE id = Iid;

END$$


DELIMITER ;

-- su dung dich vu

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_SDDV` 
(

)
BEGIN
SELECT * FROM su_dung_dich_vu AS sd
 INNER JOIN dich_vu AS d ON d.id = sd.id_DV
 INNER JOIN phong AS p ON p.id = sd.id_P;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_SDDV` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM  su_dung_dich_vu  AS sd
INNER JOIN dich_vu AS d ON d.id = sd.id_DV
INNER JOIN phong AS p ON p.id = sd.id_P WHERE sd.id = Iid;
END$$


DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_P_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_P_SDDV` 
(
IN Iid_P varchar(10)
)
BEGIN
SELECT * FROM  su_dung_dich_vu  AS sd
INNER JOIN dich_vu AS d ON d.id = sd.id_DV
INNER JOIN phong AS p ON p.id = sd.id_P WHERE sd.id_P = Iid_P;
END$$
DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_DV_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_DV_SDDV` 
(
IN Iid_DV bigint
)
BEGIN
SELECT * FROM  su_dung_dich_vu AS sd INNER JOIN dich_vu AS d ON d.id = sd.id_DV WHERE sd.id_DV = Iid_DV;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_SDDV` 
(
IN Iid bigint
)
BEGIN
DELETE FROM su_dung_dich_vu WHERE id = Iid;
END$$


DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_SDDV` 
(
IN Iid_DV bigint,
IN Iamount int,
IN Iid_P varchar(10)
)
BEGIN
INSERT INTO su_dung_dich_vu(id_DV, amount, id_p) values (Iid_DV, Iamount, Iid_p);
SELECT @@identity;
END$$


DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_SDDV`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_SDDV` 
(
IN Iid_DV bigint,
IN Iamount int,
IN Iid_P varchar(10),
IN Iid bigint
)
BEGIN
UPDATE  su_dung_dich_vu SET id_DV = Iid_DV, amount = Iamount, id_P = Iid_P WHERE id = Iid;
END$$


DELIMITER ;

-- thiet bi


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_thiet_bi` 
(

)
BEGIN
SELECT * FROM thiet_bi AS t INNER JOIN loai_phong AS p ON p.id = t.id_LP;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_thiet_bi` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM thiet_bi AS t INNER JOIN loai_phong AS l ON l.id = t.id_LP WHERE t.id = Iid;
END$$
DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_thiet_bi` 
(
IN Iid bigint
)
BEGIN
DELETE FROM thiet_bi WHERE id = Iid;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_thiet_bi` 
(
IN Iid_LP bigint,
IN Iname_TB varchar(150),
IN Iamount int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO thiet_bi(id_LP, name_TB, amount, createdDate, createdBy) values(Iid_LP, Iname_TB, Iamount, IcreatedDate, IcreatedBy) ;
SELECT @@identity;
END$$


DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_thiet_bi` 
(
IN Iid_LP bigint,
IN Iname_TB varchar(150),
IN Iamount int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE thiet_bi SET id_LP = Iid_LP, name_TB = Iname_TB, amount = Iamount, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;
END$$


DELIMITER ;

-- trang thai hoa don

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_trang_thai_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_trang_thai_hoa_don` 
(

)
BEGIN
SELECT * FROM trang_thai_hoa_don;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_trang_thai_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_trang_thai_hoa_don` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM trang_thai_hoa_don WHERE id = Iid;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_name_trang_thai_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_name_trang_thai_hoa_don` 
(
IN Iname varchar(100)
)
BEGIN
SELECT * FROM trang_thai_hoa_don WHERE name_TTHD = Iname COLLATE utf8_unicode_ci;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_trang_thai_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_trang_thai_hoa_don` 
(
IN Iid bigint
)
BEGIN
DELETE FROM trang_thai_hoa_don WHERE id = Iid;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_trang_thai_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_trang_thai_hoa_don` 
(
IN Iname varchar(100),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO trang_thai_hoa_don(name_TTHD , createdDate, createdBy) values (Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$


DELIMITER ;


DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_trang_thai_hoa_don`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_trang_thai_hoa_don` 
(
IN Iname varchar(100),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE trang_thai_hoa_don SET name_TTHD = Iname, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;

END$$


DELIMITER ;



DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_name_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_name_thiet_bi` 
(
IN Iname varchar(150)
)
BEGIN
SELECT * FROM thiet_bi WHERE name_TB = Iname;
END$$
DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_maLP_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_maLP_thiet_bi` 
(
IN Iid_LP bigint
)
BEGIN
SELECT * FROM thiet_bi AS t INNER JOIN loai_phong AS p ON t.id_LP = p.id WHERE t.id_LP;
END$$
DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_thiet_bi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_thiet_bi` 
(
IN Iid_LP bigint,
IN Iname varchar(150),
IN Iamount int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO thiet_bi(id_LP,name,amount,createdDate,createdBy) values(Iid_LP, Iname, Iamount, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$
DELIMITER ;

-- don vi
DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_all_don_vi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_all_don_vi` 
(

)
BEGIN
SELECT * FROM don_vi;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_name_don_vi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_name_don_vi` 
(
IN Iname_DV varchar(150)
)
BEGIN
SELECT * FROM don_vi WHERE name_DV = Iname_DV COLLATE utf8_unicode_ci;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `get_one_don_vi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `get_one_don_vi` 
(
IN Iid bigint
)
BEGIN
SELECT * FROM don_vi WHERE id = Iid;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `delete_don_vi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `delete_don_vi` 
(
IN Iid bigint
)
BEGIN
DELETE FROM don_vi WHERE id = Iid;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `add_don_vi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `add_don_vi` 
(
IN Iname_DV varchar(150),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO don_vi(name_DV, createdDate, createdBy) values(Iname_DV, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$


DELIMITER ;

DELIMITER ;

USE `qlks_project`;
DROP procedure IF EXISTS `update_don_vi`;

DELIMITER $$
USE `qlks_project`$$
CREATE PROCEDURE `update_don_vi` 
(
IN Iname_DV varchar(150),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
iN ImodifiedDate timestamp,
IN ImodfiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE don_vi SET name_DV = Iname_DV, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy Where id = Iid;
END$$


DELIMITER ;

ALTER TABLE `qlks_project`.`khuyen_mai` 
CHANGE COLUMN `thoi_gian_bat_dau` `thoi_gian_bat_dau` DATE NULL DEFAULT NULL ,
CHANGE COLUMN `thoi_gian_ket_thuc` `thoi_gian_ket_thuc` DATE NULL DEFAULT NULL ;

ALTER TABLE `qlks_project`.`phong` 
CHANGE COLUMN `status` `status` VARCHAR(100) NULL DEFAULT NULL ;

ALTER TABLE `qlks_project`.`hoa_don` 
ADD COLUMN `ngay_den_thuc_te` DATE NULL AFTER `so_ngay_du_kien`,
ADD COLUMN `ngay_den_du_kien` DATE NULL AFTER `ngay_den_thuc_te`,
CHANGE COLUMN `so_ngay_thuc_te` `so_ngay_thuc_te` DATE NULL DEFAULT NULL ,
CHANGE COLUMN `so_ngay_du_kien` `so_ngay_du_kien` DATE NULL DEFAULT NULL ;

ALTER TABLE `qlks_project`.`su_dung_dich_vu` 
ADD COLUMN `id_P` VARCHAR(10) NULL AFTER `amount`;
SELECT  * FROM thiet_bi AS t INNER JOIN loai_phong AS p ON p.id = t.id_LP;