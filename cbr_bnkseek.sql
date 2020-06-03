CREATE DATABASE IF NOT EXISTS cbr_bnkseek;
USE cbr_bnkseek;

DROP TABLE IF EXISTS `bnkseek`;
CREATE TABLE `bnkseek` (
  `vkey` varchar(8) NOT NULL,
  `real` varchar(4) DEFAULT NULL,
  `pzn` varchar(2) DEFAULT NULL,
  `uer` varchar(1) NOT NULL,
  `rgn` varchar(2) NOT NULL,
  `ind` varchar(6) DEFAULT NULL,
  `tnp` varchar(1) DEFAULT NULL,
  `nnp` varchar(25) DEFAULT NULL,
  `adr` varchar(30) DEFAULT NULL,
  `rkc` varchar(9) DEFAULT NULL,
  `namep` varchar(45) NOT NULL,
  `namen` varchar(30) NOT NULL,
  `newnum` varchar(9) NOT NULL,
  `newks` varchar(9) DEFAULT NULL,
  `permfo` varchar(6) DEFAULT NULL,
  `srok` varchar(2) NOT NULL,
  `at1` varchar(7) DEFAULT NULL,
  `at2` varchar(7) DEFAULT NULL,
  `telef` varchar(25) DEFAULT NULL,
  `regn` varchar(9) DEFAULT NULL,
  `okpo` varchar(8) DEFAULT NULL,
  `dt_izm` date NOT NULL,
  `cks` varchar(6) DEFAULT NULL,
  `ksnp` varchar(20) DEFAULT NULL,
  `date_in` date NOT NULL,
  `date_ch` date DEFAULT NULL,
  `vkeydel` varchar(8) DEFAULT NULL,
  `dt_izmr` date DEFAULT NULL,
  PRIMARY KEY (`vkey`),
  UNIQUE KEY `newnum_UNIQUE` (`newnum`),
  UNIQUE KEY `vkey_UNIQUE` (`vkey`) /*!80000 INVISIBLE */,
  KEY `bs_rgn_to_reg_rgn_idx` (`rgn`,`pzn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
  DROP TABLE IF EXISTS `pzn`;
  CREATE TABLE `pzn` (
  `vkey` varchar(45) NOT NULL,
  `pzn` varchar(45) DEFAULT NULL,
  `imy` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `cb_date` date DEFAULT NULL,
  `ce_date` date DEFAULT NULL,
  PRIMARY KEY (`vkey`),
  UNIQUE KEY `pzn_UNIQUE` (`pzn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS tnp;
CREATE TABLE `tnp` (
  `vkey` varchar(45) DEFAULT NULL,
  `tnp` varchar(45) DEFAULT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `shortname` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS uer;
CREATE TABLE `uer` (
  `vkey` varchar(45) DEFAULT NULL,
  `uer` varchar(45) DEFAULT NULL,
  `uername` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS reg;
CREATE TABLE `reg` (
  `vkey` varchar(45) NOT NULL,
  `rgn` varchar(2) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `center` varchar(45) DEFAULT NULL,
  `namet` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vkey`),
  UNIQUE KEY `rgn_UNIQUE` (`rgn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  