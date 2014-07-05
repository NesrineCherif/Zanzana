-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Sam 05 Juillet 2014 à 12:46
-- Version du serveur: 5.5.37
-- Version de PHP: 5.3.10-1ubuntu3.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `tunrecrutdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(500) NOT NULL,
  `Password` varchar(500) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `candidate`
--

CREATE TABLE IF NOT EXISTS `candidate` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Resume` varchar(500) NOT NULL,
  `CvPath` varchar(500) NOT NULL,
  `id_member` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk` (`id_member`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `candidate`
--

INSERT INTO `candidate` (`Id`, `Resume`, `CvPath`, `id_member`) VALUES
(4, 'resumezzz', 'cvPathzzzz', 41),
(5, 'resume', 'cvPath', 42),
(6, 'resume', 'cvPath', 43),
(7, 'resume', 'cvPath', 44),
(8, 'resumezzz', 'cvPathzzzz', 45),
(9, 'resumezzz', 'cvPathzzzz', 46),
(10, 'resumezzz', 'cvPathzzzz', 47),
(11, 'resumezzz', 'cvPathzzzz', 48),
(12, 'resumezzz', 'cvPathzzzz', 49),
(13, 'resumezzz', 'cvPathzzzz', 50);

-- --------------------------------------------------------

--
-- Structure de la table `candidate_offer`
--

CREATE TABLE IF NOT EXISTS `candidate_offer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_candidate` int(11) NOT NULL,
  `id_jobOffer` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_candidate` (`id_candidate`),
  KEY `fk_id_jobOffer` (`id_jobOffer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Contenu de la table `candidate_offer`
--

INSERT INTO `candidate_offer` (`id`, `id_candidate`, `id_jobOffer`) VALUES
(1, 5, 5),
(2, 4, 2),
(3, 4, 2),
(5, 4, 2),
(6, 4, 2),
(7, 4, 2),
(8, 4, 2),
(9, 4, 2),
(10, 4, 2),
(11, 4, 2),
(12, 4, 2),
(13, 4, 2),
(14, 4, 2),
(15, 5, 5),
(16, 5, 5),
(17, 5, 5),
(18, 5, 5),
(19, 5, 5),
(20, 5, 5),
(21, 5, 5),
(22, 5, 5),
(23, 5, 5),
(24, 5, 5),
(25, 5, 5),
(26, 5, 5),
(27, 5, 5),
(28, 5, 5),
(29, 5, 5),
(30, 5, 5),
(31, 5, 5),
(32, 5, 5),
(33, 5, 5),
(34, 5, 5),
(35, 5, 5),
(36, 5, 5),
(37, 5, 5),
(38, 5, 5),
(39, 5, 5),
(40, 5, 5),
(41, 5, 5),
(42, 5, 5),
(43, 5, 5),
(44, 5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `joboffers`
--

CREATE TABLE IF NOT EXISTS `joboffers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(500) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `TestLink` varchar(500) NOT NULL,
  `id_recruiter` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `id_recruiter` (`id_recruiter`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `joboffers`
--

INSERT INTO `joboffers` (`Id`, `Name`, `Description`, `TestLink`, `id_recruiter`) VALUES
(2, 'dev java/jee', 'description dev java/jee', 'www.google.com', 13),
(3, 'dev java', 'description dev java', 'googke.com', 13),
(4, 'dev java', 'description dev java', 'googke.com', 13),
(5, 'dev java', 'description dev java', 'googke.com', 13),
(7, 'dev java/jee', 'description dev java/jee', 'www.google.com', 15);

-- --------------------------------------------------------

--
-- Structure de la table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(500) NOT NULL,
  `Password` varchar(500) NOT NULL,
  `FirstName` varchar(500) NOT NULL,
  `LastName` varchar(500) NOT NULL,
  `Email` varchar(500) NOT NULL,
  `DateOfBirth` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Contenu de la table `member`
--

INSERT INTO `member` (`Id`, `Login`, `Password`, `FirstName`, `LastName`, `Email`, `DateOfBirth`) VALUES
(24, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(26, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(27, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(28, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(29, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(31, 'admin', 'admin', 'jihed', 'bentaher', 'jihed.bentaher@gmail.com', '2014-07-04'),
(32, 'admin', 'admin', 'jihed', 'bentaher', 'jihed.bentaher@gmail.com', '2014-07-04'),
(33, 'admin', 'admin', 'jihed', 'bentaher', 'jihed.bentaher@gmail.com', '2014-07-04'),
(34, 'admin', 'admin', 'jihed', 'bentaher', 'jihed.bentaher@gmail.com', '2014-07-04'),
(35, 'administrator', 'administrator', 'jihed', 'bentaher', 'jihed.bentaher@gmail.com', '2014-07-04'),
(36, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(37, 'jihed1', '00e001', 'jiehed', 'ben taher', 'jihed@gmail.com', '2014-07-04'),
(38, 'a', 'a', 'b', 'v', 'email', '2014-07-05'),
(39, 'a', 'a', 'b', 'v', 'email', '2014-07-05'),
(41, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05'),
(42, 'a', 'a', 'b', 'v', 'email', '2014-07-05'),
(43, 'a', 'a', 'b', 'v', 'email', '2014-07-05'),
(44, 'a', 'a', 'b', 'v', 'email', '2014-07-05'),
(45, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05'),
(46, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05'),
(47, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05'),
(48, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05'),
(49, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05'),
(50, 'azz', 'azzz', 'zzzb', 'vzzz', 'emailzzz', '2014-07-05');

-- --------------------------------------------------------

--
-- Structure de la table `recruiter`
--

CREATE TABLE IF NOT EXISTS `recruiter` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(500) NOT NULL,
  `organizationDescription` varchar(500) NOT NULL,
  `organizationAddress` varchar(500) NOT NULL,
  `organizationDomain` varchar(500) NOT NULL,
  `employeesNumber` int(255) NOT NULL,
  `organizationTurnover` longtext NOT NULL,
  `id_member` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_id_member` (`id_member`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `recruiter`
--

INSERT INTO `recruiter` (`Id`, `organizationName`, `organizationDescription`, `organizationAddress`, `organizationDomain`, `employeesNumber`, `organizationTurnover`, `id_member`) VALUES
(13, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 24),
(15, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 26),
(16, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 27),
(17, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 28),
(18, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 29),
(19, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 36),
(20, 'tritux', 'boite dev', 'eetunis - montplaisir', 'dev', 50, '50000', 37);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `candidate`
--
ALTER TABLE `candidate`
  ADD CONSTRAINT `candidate_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `member` (`Id`),
  ADD CONSTRAINT `fk` FOREIGN KEY (`id_member`) REFERENCES `member` (`Id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `candidate_offer`
--
ALTER TABLE `candidate_offer`
  ADD CONSTRAINT `fk_id_jobOffer` FOREIGN KEY (`id_jobOffer`) REFERENCES `joboffers` (`Id`),
  ADD CONSTRAINT `fk_id_candidate` FOREIGN KEY (`id_candidate`) REFERENCES `candidate` (`Id`);

--
-- Contraintes pour la table `joboffers`
--
ALTER TABLE `joboffers`
  ADD CONSTRAINT `joboffers_ibfk_1` FOREIGN KEY (`id_recruiter`) REFERENCES `recruiter` (`Id`);

--
-- Contraintes pour la table `recruiter`
--
ALTER TABLE `recruiter`
  ADD CONSTRAINT `fk_id_member` FOREIGN KEY (`id_member`) REFERENCES `member` (`Id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_member` FOREIGN KEY (`id_member`) REFERENCES `member` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
