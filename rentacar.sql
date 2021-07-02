/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.1.35-MariaDB : Database - rentacar
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rentacar` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rentacar`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `idKlijent` bigint(20) NOT NULL AUTO_INCREMENT,
  `imePrezimeKlijent` varchar(20) DEFAULT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `brojTelefona` varchar(50) DEFAULT NULL,
  `vozackaDozvola` varchar(30) DEFAULT NULL,
  `zaposleniId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idKlijent`),
  KEY `klijent_fk` (`zaposleniId`),
  CONSTRAINT `klijent_fk` FOREIGN KEY (`zaposleniId`) REFERENCES `zaposleni` (`idZaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `klijent` */

insert  into `klijent`(`idKlijent`,`imePrezimeKlijent`,`datumRodjenja`,`brojTelefona`,`vozackaDozvola`,`zaposleniId`) values 
(1,'Petar Petrovic','1992-12-12','0645432184','vazeca',1),
(2,'Marko Markovic','1990-05-07','0623884219','nema',2),
(4,'dasd','1998-05-06','06666666666','nema',1),
(5,'Milica Savic','1999-05-13','2324234324','istekla',1),
(6,'fasf asd','1992-06-18','45645345','nema',1),
(7,'Milos Milosic','1989-06-14','5678578678','vazeca',1),
(8,'Jelena Jelenic','1994-06-14','0623227432','vazeca',1),
(9,'kk','1997-06-03','kk','nema',1);

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `idRezervacija` bigint(20) NOT NULL AUTO_INCREMENT,
  `nazivRezervacije` varchar(30) DEFAULT NULL,
  `datumRezervacije` date DEFAULT NULL,
  `datumOd` date DEFAULT NULL,
  `datumDo` date DEFAULT NULL,
  `cenaRezervacije` double(30,0) DEFAULT NULL,
  `voziloId` bigint(20) DEFAULT NULL,
  `klijentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idRezervacija`),
  KEY `rez_fk1` (`voziloId`),
  KEY `rez_fk2` (`klijentId`),
  CONSTRAINT `rez_fk1` FOREIGN KEY (`voziloId`) REFERENCES `vozilo` (`idVozilo`),
  CONSTRAINT `rez_fk2` FOREIGN KEY (`klijentId`) REFERENCES `klijent` (`idKlijent`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`idRezervacija`,`nazivRezervacije`,`datumRezervacije`,`datumOd`,`datumDo`,`cenaRezervacije`,`voziloId`,`klijentId`) values 
(1,'prva','2019-06-02','2019-06-11','2019-06-21',3456,2,2),
(2,'r1','2019-06-02','2019-06-11','2019-06-30',28500,1,4),
(3,'rezervacija 5','2019-06-16','2019-06-18','2019-06-22',13332,12,8);

/*Table structure for table `unajmljivanje` */

DROP TABLE IF EXISTS `unajmljivanje`;

CREATE TABLE `unajmljivanje` (
  `idUnajmljivanje` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumUnajmljivanja` date DEFAULT NULL,
  `nacinPlacanja` varchar(30) DEFAULT NULL,
  `cenaUnajmljivanja` decimal(30,0) DEFAULT NULL,
  `klijentId` bigint(20) DEFAULT NULL,
  `vozacId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idUnajmljivanje`),
  KEY `unajmljivanje_fk1` (`klijentId`),
  KEY `unajmljivanje_fk2` (`vozacId`),
  CONSTRAINT `unajmljivanje_fk1` FOREIGN KEY (`klijentId`) REFERENCES `klijent` (`idKlijent`),
  CONSTRAINT `unajmljivanje_fk2` FOREIGN KEY (`vozacId`) REFERENCES `vozac` (`idVozac`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `unajmljivanje` */

insert  into `unajmljivanje`(`idUnajmljivanje`,`datumUnajmljivanja`,`nacinPlacanja`,`cenaUnajmljivanja`,`klijentId`,`vozacId`) values 
(1,'2019-06-09','kes',123,1,5),
(2,'2019-06-16','kes',234,5,4),
(3,'2019-06-16','kes',123,1,4);

/*Table structure for table `vozac` */

DROP TABLE IF EXISTS `vozac`;

CREATE TABLE `vozac` (
  `idVozac` bigint(20) NOT NULL AUTO_INCREMENT,
  `imePrezimeVozac` varchar(20) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  `daLiJeSlobodan` tinyint(1) DEFAULT NULL,
  `zaposleniId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idVozac`),
  KEY `vozac_fk` (`zaposleniId`),
  CONSTRAINT `vozac_fk` FOREIGN KEY (`zaposleniId`) REFERENCES `zaposleni` (`idZaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `vozac` */

insert  into `vozac`(`idVozac`,`imePrezimeVozac`,`jmbg`,`daLiJeSlobodan`,`zaposleniId`) values 
(4,'Pera Peric','1211994321399',1,1),
(5,'Mare Maric','2212996234113',1,1);

/*Table structure for table `vozilo` */

DROP TABLE IF EXISTS `vozilo`;

CREATE TABLE `vozilo` (
  `idVozilo` bigint(20) NOT NULL AUTO_INCREMENT,
  `kilometraza` double(20,2) DEFAULT NULL,
  `tipVozila` varchar(40) DEFAULT NULL,
  `brojPutnika` int(20) DEFAULT NULL,
  `cenaPoDanu` double(20,2) DEFAULT NULL,
  `zaposleniId` bigint(20) DEFAULT NULL,
  `marka` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idVozilo`),
  KEY `vozilo_fk` (`zaposleniId`),
  CONSTRAINT `vozilo_fk` FOREIGN KEY (`zaposleniId`) REFERENCES `zaposleni` (`idZaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `vozilo` */

insert  into `vozilo`(`idVozilo`,`kilometraza`,`tipVozila`,`brojPutnika`,`cenaPoDanu`,`zaposleniId`,`marka`) values 
(1,5000.00,'putnicko',4,1500.00,1,'mercedes'),
(2,698.00,'sportsko',2,2000.00,2,'bmw'),
(3,585.00,'putnicko',8,2500.00,4,'vw'),
(4,661.00,'sdfds',5,1234.00,1,'sdf'),
(5,346.00,'kkk',6,478.00,1,'sdf'),
(8,123.00,'qwe',4,123.00,3,'sdf'),
(9,234.00,'esrfs',4,23425.00,1,'qw'),
(10,567.00,'aeae',8,4444.00,1,'mers'),
(11,23423.00,'fff',4,1234.00,1,'proba'),
(12,123.60,'eeee',5,3333.00,1,'bently'),
(13,3444.00,'rew',2,45.00,2,'t4'),
(14,123.40,'sportsko',2,3333.00,1,'porse');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `idZaposleni` bigint(20) NOT NULL AUTO_INCREMENT,
  `imePrezimeZaposleni` varchar(20) DEFAULT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idZaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`idZaposleni`,`imePrezimeZaposleni`,`datumRodjenja`,`username`,`password`,`jmbg`) values 
(1,'Jelisaveta Sapsaj','1997-11-20','liza','liza','2011997715100'),
(2,'Aleksandra Rakic','1996-10-14','saki','saki','1410996715200'),
(3,'Ana Colovic','1996-05-29','ana','ana','2905996715321'),
(4,'Jovana Mitrovic','1996-07-27','joli','joli','2707996715432'),
(5,'Ana Dzudovic',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
