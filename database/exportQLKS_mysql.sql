-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema qlks_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema qlks_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qlks_project` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `qlks_project` ;

-- -----------------------------------------------------
-- Table `qlks_project`.`loai_dich_vu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`loai_dich_vu` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name_LDV` VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`don_vi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`don_vi` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name_DV` VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`dich_vu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`dich_vu` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_LDV` BIGINT NOT NULL,
  `price` FLOAT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `id_DV` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dich_vu` (`id_LDV` ASC) VISIBLE,
  INDEX `fk_dich_vu_dv` (`id_DV` ASC) VISIBLE,
  CONSTRAINT `fk_dich_vu`
    FOREIGN KEY (`id_LDV`)
    REFERENCES `qlks_project`.`loai_dich_vu` (`id`),
  CONSTRAINT `fk_dich_vu_dv`
    FOREIGN KEY (`id_DV`)
    REFERENCES `qlks_project`.`don_vi` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`khach_hang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`khach_hang` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) CHARACTER SET 'utf8' NOT NULL,
  `birthDay` DATE NOT NULL,
  `gennder` VARCHAR(20) CHARACTER SET 'utf8' NOT NULL,
  `phone` VARCHAR(250) NOT NULL,
  `address` VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  `identityCard` VARCHAR(250) NOT NULL,
  `nation` VARCHAR(250) NOT NULL,
  `numberOfCheckIn` INT NOT NULL DEFAULT '1',
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `missedRoom` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`loai_phong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`loai_phong` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name_LP` VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  `price` FLOAT NOT NULL,
  `maxPeople` INT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`phong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`phong` (
  `id` VARCHAR(10) NOT NULL,
  `id_LP` BIGINT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `status` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_phong_LP` (`id_LP` ASC) VISIBLE,
  CONSTRAINT `fk_phong_LP`
    FOREIGN KEY (`id_LP`)
    REFERENCES `qlks_project`.`loai_phong` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`su_dung_dich_vu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`su_dung_dich_vu` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_DV` BIGINT NOT NULL,
  `amount` INT NOT NULL,
  `id_HD` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sddv_dv` (`id_DV` ASC) VISIBLE,
  INDEX `pk_SDDV_HD` (`id_HD` ASC) VISIBLE,
  CONSTRAINT `fk_sddv_dv`
    FOREIGN KEY (`id_DV`)
    REFERENCES `qlks_project`.`dich_vu` (`id`),
  CONSTRAINT `pk_SDDV_HD`
    FOREIGN KEY (`id_HD`)
    REFERENCES `qlks_project`.`hoa_don` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`trang_thai_hoa_don`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`trang_thai_hoa_don` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name_TTHD` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`hoa_don`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`hoa_don` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_KH` BIGINT NOT NULL,
  `id_P` VARCHAR(10) NOT NULL,
  `id_TTHD` BIGINT NOT NULL,
  `id_SDDV` BIGINT NULL DEFAULT NULL,
  `hinh_thucTT` VARCHAR(250) CHARACTER SET 'utf8' NOT NULL,
  `phu_phi` FLOAT NULL DEFAULT NULL,
  `tien_phong` FLOAT NOT NULL,
  `tien_dich_vu` FLOAT NULL DEFAULT NULL,
  `giam_giaKH` FLOAT NULL DEFAULT NULL,
  `so_ngay` FLOAT NOT NULL,
  `thanh_tien` FLOAT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `so_ngay_thuc_te` DATE NULL DEFAULT NULL,
  `so_ngay_du_kien` DATE NULL DEFAULT NULL,
  `ngay_den_thuc_te` DATE NULL DEFAULT NULL,
  `ngay_den_du_kien` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hoa_don_KH` (`id_KH` ASC) VISIBLE,
  INDEX `fk_hoa_don_Phong` (`id_P` ASC) VISIBLE,
  INDEX `fk_hoa_don_SDDV` (`id_SDDV` ASC) VISIBLE,
  INDEX `fk_hoa_don_TTHD` (`id_TTHD` ASC) VISIBLE,
  CONSTRAINT `fk_hoa_don_KH`
    FOREIGN KEY (`id_KH`)
    REFERENCES `qlks_project`.`khach_hang` (`id`),
  CONSTRAINT `fk_hoa_don_Phong`
    FOREIGN KEY (`id_P`)
    REFERENCES `qlks_project`.`phong` (`id`),
  CONSTRAINT `fk_hoa_don_SDDV`
    FOREIGN KEY (`id_SDDV`)
    REFERENCES `qlks_project`.`su_dung_dich_vu` (`id`),
  CONSTRAINT `fk_hoa_don_TTHD`
    FOREIGN KEY (`id_TTHD`)
    REFERENCES `qlks_project`.`trang_thai_hoa_don` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`khuyen_mai`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`khuyen_mai` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Code` VARCHAR(50) NULL DEFAULT NULL,
  `value` FLOAT NULL DEFAULT NULL,
  `content` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `type` BIT(1) NULL DEFAULT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `thoi_gian_bat_dau` DATE NULL DEFAULT NULL,
  `thoi_gian_ket_thuc` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`nhom_quyen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`nhom_quyen` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name_NQ` VARCHAR(250) CHARACTER SET 'utf8' NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`nhan_vien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`nhan_vien` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) CHARACTER SET 'utf8' NOT NULL,
  `birthDay` DATE NOT NULL,
  `gender` VARCHAR(20) CHARACTER SET 'utf8' NOT NULL,
  `image` BLOB NULL DEFAULT NULL,
  `email` VARCHAR(250) NOT NULL,
  `userName` VARCHAR(150) NOT NULL,
  `passWord` TEXT NOT NULL,
  `cmnd` VARCHAR(12) NOT NULL,
  `degree` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `id_NQ` BIGINT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE,
  INDEX `fk_nhan_vien_NQ` (`id_NQ` ASC) VISIBLE,
  CONSTRAINT `fk_nhan_vien_NQ`
    FOREIGN KEY (`id_NQ`)
    REFERENCES `qlks_project`.`nhom_quyen` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`quyen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`quyen` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) CHARACTER SET 'utf8' NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`phan_quyen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`phan_quyen` (
  `id_Q` BIGINT NOT NULL,
  `id_NQ` BIGINT NOT NULL,
  PRIMARY KEY (`id_Q`, `id_NQ`),
  INDEX `fk_phan_quyen_NQ` (`id_NQ` ASC) VISIBLE,
  CONSTRAINT `fk_phan_quyen_NQ`
    FOREIGN KEY (`id_NQ`)
    REFERENCES `qlks_project`.`nhom_quyen` (`id`),
  CONSTRAINT `fk_phan_quyen_Q`
    FOREIGN KEY (`id_Q`)
    REFERENCES `qlks_project`.`quyen` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `qlks_project`.`thiet_bi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlks_project`.`thiet_bi` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_LP` BIGINT NOT NULL,
  `name_TB` VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  `amount_TB` INT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `createdBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `modifiedBy` VARCHAR(250) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_thiet_bi_LP` (`id_LP` ASC) VISIBLE,
  CONSTRAINT `fk_thiet_bi_LP`
    FOREIGN KEY (`id_LP`)
    REFERENCES `qlks_project`.`loai_phong` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

USE `qlks_project` ;

-- -----------------------------------------------------
-- procedure add_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_SDDV`(
IN Iid_DV bigint,
IN Iamount int,
IN Iid_HD bigint
)
BEGIN
INSERT INTO su_dung_dich_vu(id_DV, amount, id_HD) values (Iid_DV, Iamount, Iid_HD);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_dich_vu`(
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

-- -----------------------------------------------------
-- procedure add_don_vi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_don_vi`(
IN Iname_DV varchar(150),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO don_vi(name_DV, createdDate, createdBy) values(Iname_DV, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_hoa_don`(
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

-- -----------------------------------------------------
-- procedure add_khach_hang
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_khach_hang`(
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
IN ImissedRoom int
)
BEGIN
INSERT INTO khach_hang(name, birthDay, gennder, phone, address, identityCard, nation, numberOfCheckIn, createdDate, createdBy, missedRoom) 
values(Iname, IbirthDay, Igender, Iphone, Iaddress, IidentityCard,Ination, InumberOfCheckIn, IcreatedDate, IcreatedBy, ImissedRoom);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_khuyen_mai`(
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

-- -----------------------------------------------------
-- procedure add_loai_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_loai_dich_vu`(
IN Iname varchar(150),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO loai_dich_vu(name_LDV, createdDate, createdBy) values(Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_loai_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_loai_phong`(
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

-- -----------------------------------------------------
-- procedure add_nhan_vien
-- -----------------------------------------------------

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

-- -----------------------------------------------------
-- procedure add_nhom_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_nhom_quyen`(
IN Iname nvarchar(250),
IN IcreatedDate timestamp,
IN IcreatedBy nvarchar(250)

)
BEGIN
INSERT INTO nhom_quyen(name_NQ, createdDate, createdBy) values (Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_phan_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_phan_quyen`(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
INSERT INTO phan_quyen(id_Q, id_NQ) values (Iid_Q, Iid_NQ);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_phong`(
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

-- -----------------------------------------------------
-- procedure add_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_thiet_bi`(
IN Iid_LP bigint,
IN Iname_TB varchar(150),
IN Iamount_TB int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO thiet_bi(id_LP, name_TB, amount_TB, createdDate, createdBy) values(Iid_LP, Iname_TB, Iamount_TB, IcreatedDate, IcreatedBy) ;
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_trang_thai_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_trang_thai_hoa_don`(
IN Iname varchar(100),
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250)
)
BEGIN
INSERT INTO trang_thai_hoa_don(name_TTHD , createdDate, createdBy) values (Iname, IcreatedDate, IcreatedBy);
SELECT @@identity;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_SDDV`(
IN Iid bigint
)
BEGIN
DELETE FROM su_dung_dich_vu WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_dich_vu`(
IN Iid bigint
)
BEGIN
DELETE FROM dich_vu WHERE id = Iid;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_don_vi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_don_vi`(
IN Iid bigint
)
BEGIN
DELETE FROM don_vi WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_hoa_don`(

IN Iid bigint
)
BEGIN
DELETE FROM hoa_don WHERE id = Iid;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_khach_hang
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_khach_hang`(
IN Iid bigint
)
BEGIN
DELETE FROM khach_hang WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_khuyen_mai`(
IN Iid bigint
)
BEGIN
DELETE FROM khuyen_mai WHERE id = Iid;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_loai_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_loai_dich_vu`(
IN Iid bigint
)
BEGIN
DELETE FROM loai_dich_vu WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_loai_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_loai_phong`(
IN Iid bigint
)
BEGIN
DELETE FROM loai_phong WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_nhan_vien
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_nhan_vien`(
iN Iid bigint
)
BEGIN
DELETE FROM nhan_vien WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_nhom_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_nhom_quyen`(
IN Iid bigint
)
BEGIN
DELETE FROM  nhom_quyen WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_phan_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_phan_quyen`(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
DELETE FROM phan_quyen WHERE id_Q = Iid_Q AND id_NQ = Iid_NQ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_phong`(
IN Iid varchar(10)
)
BEGIN
DELETE FROM phong WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_quyen`(

IN Iid bigint
)
BEGIN
DELETE FROM quyen WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_thiet_bi`(
IN Iid bigint
)
BEGIN
DELETE FROM thiet_bi WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_trang_thai_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_trang_thai_hoa_don`(
IN Iid bigint
)
BEGIN
DELETE FROM trang_thai_hoa_don WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure findByUserNameAndPassword_nhan_vien
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `findByUserNameAndPassword_nhan_vien`(
IN IuserName nvarchar(150) COLLATE utf8_unicode_ci
)
BEGIN
SELECT * FROM  nhan_vien AS n INNER JOIN nhom_quyen AS r ON r.id = n.id_NQ WHERE n.userName = IuserName;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_DV_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_DV_SDDV`(
IN Iid_DV bigint
)
BEGIN
SELECT * FROM  su_dung_dich_vu AS sd INNER JOIN dich_vu AS d ON d.id = sd.id_DV WHERE sd.id_DV = Iid_DV;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_allHD_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_allHD_SDDV`(
IN ImaHD bigint,
IN Iid_KH bigint
)
BEGIN
SELECT * FROM su_dung_dich_vu AS sd
 INNER JOIN dich_vu AS d ON d.id = sd.id_DV
 INNER JOIN hoa_don AS hd ON hd.id = sd.id_HD
 WHERE sd.id_HD = ImaHD AND hd.id_KH = Iid_KH
 ORDER BY sd.id DESC;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_SDDV`(

)
BEGIN
SELECT * FROM su_dung_dich_vu AS sd
 INNER JOIN dich_vu AS d ON d.id = sd.id_DV;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_dich_vu`(

)
BEGIN
SELECT * FROM dich_vu AS d 
INNER JOIN  loai_dich_vu AS l ON l.id = d.id_LDV
INNER JOIN don_vi AS v ON v.id = d.id_DV;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_don_vi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_don_vi`(

)
BEGIN
SELECT * FROM don_vi;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_find_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_find_hoa_don`(

)
BEGIN
SELECT * FROM hoa_don AS hd 
INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH
INNER JOIN phong AS p ON p.id = hd.id_P
INNER JOIN trang_thai_hoa_don AS tt ON tt.id = hd.id_TTHD
INNER JOIN su_dung_dich_vu AS sd ON sd.id = hd.id_SDDV;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_hoa_don`(

)
BEGIN
SELECT * FROM hoa_don AS hd INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH
INNER JOIN phong AS p ON p.id = hd.id_P
INNER JOIN trang_thai_hoa_don AS tt ON tt.id = hd.id_TTHD;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_hoa_don_byKH
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_hoa_don_byKH`(
IN ICmndKH varchar(250)
)
BEGIN
SELECT * FROM hoa_don AS hd INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH WHERE kh.identityCard = ICmndKH;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_khach_hang
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_khach_hang`(

)
BEGIN
SELECT * FROM khach_hang;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_khuyen_mai`(

)
BEGIN
SELECT * FROM khuyen_mai;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_loai_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_loai_dich_vu`(

)
BEGIN
SELECT * FROM loai_dich_vu;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_loai_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_loai_phong`(

)
BEGIN
SELECT * FROM loai_phong;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_nhan_vien
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_nhan_vien`()
BEGIN
SELECT * FROM nhan_vien AS n INNER JOIN nhom_quyen AS q ON q.id = n.id_NQ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_nhom_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_nhom_quyen`(
)
BEGIN
SELECT * FROM  nhom_quyen;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_phan_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_phan_quyen`(
IN Iid bigint
)
BEGIN
SELECT * FROM  nhom_quyen;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_phong`(

)
BEGIN
SELECT * FROM phong AS p INNER JOIN loai_phong AS l ON l.id = p.id_LP;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_quyen`()
BEGIN
SELECT * FROM quyen;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_thiet_bi`(

)
BEGIN
SELECT * FROM thiet_bi AS t INNER JOIN loai_phong AS p ON p.id = t.id_LP;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_trang_thai_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_trang_thai_hoa_don`(

)
BEGIN
SELECT * FROM trang_thai_hoa_don;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_cmnd_khach_hang
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_cmnd_khach_hang`(
IN IidentityCard varchar(250)
)
BEGIN
SELECT * FROM khach_hang WHERE identityCard = IidentityCard;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_code_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_code_khuyen_mai`(
IN Icode varchar(50)
)
BEGIN
SELECT * FROM khuyen_mai WHERE code = Icode;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_count_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_count_phong`(

)
BEGIN
SELECT count(*) AS count FROM phong;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_id_P_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_id_P_hoa_don`(
IN Iid_P varchar(10)
)
BEGIN
SELECT * FROM hoa_don INNER JOIN trang_thai_hoa_don ON trang_thai_hoa_don.id = hoa_don.id_TTHD WHERE id_P = Iid_P ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_maLP_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_maLP_thiet_bi`(
IN Iid_LP bigint
)
BEGIN
SELECT * FROM thiet_bi AS t INNER JOIN loai_phong AS p ON t.id_LP = p.id WHERE t.id_LP;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_name_don_vi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_name_don_vi`(
IN Iname_DV varchar(150)
)
BEGIN
SELECT * FROM don_vi WHERE name_DV = Iname_DV COLLATE utf8_unicode_ci;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_name_loai_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_name_loai_dich_vu`(
IN Iname_LDV varchar(150)
)
BEGIN
SELECT * FROM loai_dich_vu WHERE name_LDV = Iname_LDV COLLATE utf8_unicode_ci;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_name_loai_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_name_loai_phong`(
IN Iname_LP varchar(150)
)
BEGIN
SELECT * FROM loai_phong WHERE name_LP = Iname_LP COLLATE utf8_unicode_ci;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_name_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_name_thiet_bi`(
IN Iname varchar(150)
)
BEGIN
SELECT * FROM thiet_bi WHERE name_TB = Iname  COLLATE utf8_unicode_ci;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_name_trang_thai_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_name_trang_thai_hoa_don`(
IN Iname varchar(100)
)
BEGIN
SELECT * FROM trang_thai_hoa_don WHERE name_TTHD = Iname COLLATE utf8_unicode_ci;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_SDDV`(
IN Iid bigint
)
BEGIN
SELECT * FROM  su_dung_dich_vu  AS sd
INNER JOIN dich_vu AS d ON d.id = sd.id_DV
 WHERE sd.id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_cmnd
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_cmnd`(
IN Icmnd varchar(12)
)
BEGIN
SELECT * FROM nhan_vien WHERE cmnd= Icmnd;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_dich_vu`(
IN Iid bigint
)
BEGIN
SELECT * FROM dich_vu AS dv 
INNER JOIN loai_dich_vu AS ld ON ld.id = dv.id_LDV
INNER JOIN don_vi AS d ON d.id = dv.id_DV
WHERE dv.id = Iid;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_don_vi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_don_vi`(
IN Iid bigint
)
BEGIN
SELECT * FROM don_vi WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_email
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_email`(
IN Iemail nvarchar(250)  COLLATE utf8_unicode_ci
)
BEGIN
SELECT * FROM nhan_vien WHERE email = Iemail;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_hoa_don`(
IN Iid bigint
)
BEGIN
SELECT * FROM hoa_don WHERE id = Iid ;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_join_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_join_hoa_don`(
IN IidHD bigint
)
BEGIN
SELECT * FROM hoa_don AS hd INNER JOIN khach_hang AS kh ON kh.id = hd.id_KH
INNER JOIN phong AS p ON p.id = hd.id_P
INNER JOIN trang_thai_hoa_don AS tt ON tt.id = hd.id_TTHD
INNER JOIN su_dung_dich_vu AS sddv ON sddv.id = hd.id_SDDV WHERE hd.id = IidHD;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_khach_hang
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_khach_hang`(
IN Iid bigint
)
BEGIN
SELECT * FROM khach_hang WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_khuyen_mai`(
IN Iid bigint
)
BEGIN
SELECT * FROM khuyen_mai WHERE id = Iid;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_loai_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_loai_dich_vu`(
IN Iid bigint
)
BEGIN
SELECT * FROM loai_dich_vu WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_loai_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_loai_phong`(
IN Iid bigint
)
BEGIN
SELECT * FROM loai_phong WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_nhan_vien
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_nhan_vien`(
iN Iid bigint
)
BEGIN
SELECT * FROM nhan_vien WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_nhom_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_nhom_quyen`(
IN Iid bigint
)
BEGIN
SELECT * FROM  nhom_quyen WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_phan_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_phan_quyen`(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
SELECT * FROM phan_quyen WHERE  id_Q = Iid_Q OR id_NQ = Iid_NQ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_phong`(
IN Iid varchar(10)
)
BEGIN
SELECT * FROM phong AS p INNER JOIN loai_phong AS l ON l.id = p.id_lp WHERE p.id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_quyen`(

IN Iid bigint
)
BEGIN 
SELECT * FROM quyen WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_thiet_bi`(
IN Iid bigint
)
BEGIN
SELECT * FROM thiet_bi AS t INNER JOIN loai_phong AS l ON l.id = t.id_LP WHERE t.id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_trang_thai_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_trang_thai_hoa_don`(
IN Iid bigint
)
BEGIN
SELECT * FROM trang_thai_hoa_don WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_one_userName
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_one_userName`(
IN IuserName nvarchar(150)  COLLATE utf8_unicode_ci
)
BEGIN
SELECT * FROM nhan_vien WHERE userName = IuserName;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_trungDV_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_trungDV_SDDV`(
IN Iid_DV bigint,
IN Iid_HD bigint
)
BEGIN
SELECT * FROM  su_dung_dich_vu AS sd 
INNER JOIN dich_vu AS d ON d.id = sd.id_DV
INNER JOIN hoa_don AS hd ON hd.id = sd.id_HD WHERE sd.id_DV = Iid_DV AND sd.id_HD = Iid_HD;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_type_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_type_khuyen_mai`(
IN Itype bit
)
BEGIN
SELECT * FROM khuyen_mai WHERE type = Itype;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_SDDV
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_SDDV`(
IN Iid_DV bigint,
IN Iamount int,
IN Iid_HD bigint,
IN Iid bigint
)
BEGIN
UPDATE  su_dung_dich_vu SET id_DV = Iid_DV, amount = Iamount, id_HD = Iid_HD WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_dich_vu`(
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

-- -----------------------------------------------------
-- procedure update_don_vi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_don_vi`(
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

-- -----------------------------------------------------
-- procedure update_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_hoa_don`(
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

-- -----------------------------------------------------
-- procedure update_khach_hang
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_khach_hang`(
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
IN ImissedRoom int,
IN Iid bigint
)
BEGIN
UPDATE khach_hang SET name = Iname, birthDay = IbirthDay, gennder = Igender, phone = Iphone, address = Iaddress,
 identityCard  = IitendityCard, nation = Ination, numberOfCheckIn = InumberOfCheckIn, createdDate = IcreatedDate,
 createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy, missedRoom = ImissedRoom WHERE id = Iid;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_khuyen_mai
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_khuyen_mai`(
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

-- -----------------------------------------------------
-- procedure update_loai_dich_vu
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_loai_dich_vu`(
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

-- -----------------------------------------------------
-- procedure update_loai_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_loai_phong`(
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

-- -----------------------------------------------------
-- procedure update_nhan_vien
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_nhan_vien`(
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

-- -----------------------------------------------------
-- procedure update_nhom_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_nhom_quyen`(
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

-- -----------------------------------------------------
-- procedure update_phan_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_phan_quyen`(
IN Iid_Q bigint,
IN Iid_NQ bigint
)
BEGIN
 UPDATE phan_quyen set id_Q = Iid_Q, id_NQ = Iid_NQ WHERE id_Q = Iid_Q AND id_NQ = Iid_NQ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_phong
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_phong`(
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

-- -----------------------------------------------------
-- procedure update_quyen
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_quyen`(
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

-- -----------------------------------------------------
-- procedure update_thiet_bi
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_thiet_bi`(
IN Iid_LP bigint,
IN Iname_TB varchar(150),
IN Iamount_TB int,
IN IcreatedDate timestamp,
IN IcreatedBy varchar(250),
IN ImodifiedDate timestamp,
IN ImodifiedBy varchar(250),
IN Iid bigint
)
BEGIN
UPDATE thiet_bi SET id_LP = Iid_LP, name_TB = Iname_TB, amount_TB = Iamount_TB, createdDate = IcreatedDate, createdBy = IcreatedBy, modifiedDate = ImodifiedDate, modifiedBy = ImodifiedBy WHERE id = Iid;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_trang_thai_hoa_don
-- -----------------------------------------------------

DELIMITER $$
USE `qlks_project`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_trang_thai_hoa_don`(
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

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
