-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 05 juin 2018 à 12:38
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rose`
--

-- --------------------------------------------------------

--
-- Structure de la table `concept`
--

DROP TABLE IF EXISTS `concept`;
CREATE TABLE IF NOT EXISTS `concept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(21000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(21000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `job`
--

INSERT INTO `job` (`ID`, `name`, `description`) VALUES
(1, 'Consultant (Developpeur/Chef de projet)', ''),
(2, 'Chef de projet Cloud', ''),
(3, 'Developpeur et Scrum Master', ''),
(4, 'Architecte devops', ''),
(5, 'Consultant en Cybersecurite', ''),
(6, 'Data Scientist', ''),
(7, 'Data Analyste', ''),
(8, 'Data Manager', ''),
(9, 'Chercheur', ''),
(10, 'Ingenieur Systeme', ''),
(11, 'Developpeur produit e-sante', ''),
(12, 'Architecte plateforme embarque', ''),
(13, 'Specialiste qualification', ''),
(14, 'Specialiste Integration', ''),
(15, 'Responsable Systeme', ''),
(16, 'Expert Techno Embarque / Responsable Support', '');

-- --------------------------------------------------------

--
-- Structure de la table `job_major`
--

DROP TABLE IF EXISTS `job_major`;
CREATE TABLE IF NOT EXISTS `job_major` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_job` int(11) NOT NULL,
  `ID_major` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_foreign_key_name` (`ID_job`),
  KEY `fk_foreign_key_nam` (`ID_major`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `job_major`
--

INSERT INTO `job_major` (`ID`, `ID_job`, `ID_major`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 2, 3),
(6, 2, 4),
(7, 3, 1),
(8, 3, 2),
(9, 4, 1),
(10, 4, 2),
(11, 5, 2),
(12, 5, 5),
(13, 6, 7),
(14, 7, 7),
(15, 8, 7),
(16, 9, 1),
(17, 10, 6),
(18, 11, 6),
(19, 12, 3),
(20, 12, 4),
(24, 13, 3),
(25, 13, 4),
(26, 14, 3),
(27, 14, 4),
(28, 15, 3),
(29, 15, 4),
(30, 16, 3);

-- --------------------------------------------------------

--
-- Structure de la table `major`
--

DROP TABLE IF EXISTS `major`;
CREATE TABLE IF NOT EXISTS `major` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(21000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `major`
--

INSERT INTO `major` (`ID`, `name`, `description`) VALUES
(1, 'Logiciel', ''),
(2, 'SI', ''),
(3, 'Systeme Embarque', ''),
(4, 'IOT', ''),
(5, 'Securite Reseaux', ''),
(6, 'Sante', ''),
(7, 'Business Intelligence', '');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(21000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `module_concept`
--

DROP TABLE IF EXISTS `module_concept`;
CREATE TABLE IF NOT EXISTS `module_concept` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_module` int(11) NOT NULL,
  `ID_concept` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_foreign_key_na` (`ID_module`),
  KEY `fk_foreign_key_n` (`ID_concept`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `module_major`
--

DROP TABLE IF EXISTS `module_major`;
CREATE TABLE IF NOT EXISTS `module_major` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_module` int(11) NOT NULL,
  `ID_major` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_foreign_key_` (`ID_module`),
  KEY `fk_foreign_key` (`ID_major`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
CREATE TABLE IF NOT EXISTS `requirement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `field` varchar(255) NOT NULL,
  `value` int(11) NOT NULL,
  `ID_module` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_foreign_ke` (`ID_module`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Structure de la table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `job_major`
--
ALTER TABLE `job_major`
  ADD CONSTRAINT `fk_foreign_key_nam` FOREIGN KEY (`ID_major`) REFERENCES `major` (`ID`),
  ADD CONSTRAINT `fk_foreign_key_name` FOREIGN KEY (`ID_job`) REFERENCES `job` (`ID`);

--
-- Contraintes pour la table `module_concept`
--
ALTER TABLE `module_concept`
  ADD CONSTRAINT `fk_foreign_key_n` FOREIGN KEY (`ID_concept`) REFERENCES `concept` (`id`),
  ADD CONSTRAINT `fk_foreign_key_na` FOREIGN KEY (`ID_module`) REFERENCES `module` (`ID`);

--
-- Contraintes pour la table `requirement`
--
ALTER TABLE `requirement`
  ADD CONSTRAINT `fk_foreign_ke` FOREIGN KEY (`ID_module`) REFERENCES `module` (`ID`);

--
-- Contraintes pour la table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
