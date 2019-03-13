-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2019 at 04:22 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quartertosemesters`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `ID` int(11) NOT NULL,
  `courseID` varchar(10) NOT NULL,
  `courseName` varchar(50) NOT NULL,
  `creditHours` double NOT NULL,
  `pcWeb` char(1) DEFAULT NULL,
  `integrated` char(1) DEFAULT NULL,
  `type` char(1) NOT NULL,
  `equivalent` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`ID`, `courseID`, `courseName`, `creditHours`, `pcWeb`, `integrated`, `type`, `equivalent`) VALUES
(1, 'INFO1121', 'Microsoft Word & PowerPoint', 1.5, 'R', 'R', 'Q', 'BSADIOIO'),
(2, 'INFO1131', 'Microsoft Excel', 1.5, 'R', 'R', 'Q', 'BSADIOIO'),
(3, 'INFO1151', 'Information Technology Fundamentals', 4.5, 'R', 'R', 'Q', 'INFO1151'),
(4, 'INFO1161', 'Windows Operating Systems', 4.5, 'R', 'R', 'Q', 'INFO1171'),
(5, 'INFO1211', 'Microsoft Access', 3, 'R', 'R', 'Q', 'BSADIOIO'),
(6, 'INFO1214', 'Program Design & Problem Solving', 4.5, 'R', 'R', 'Q', 'INFO1214'),
(7, 'INFO1381', 'Data Communications & Networking', 4.5, 'R', 'R', 'Q', 'INFO1281'),
(8, 'INFO1311', 'Database Concepts', 3, 'R', 'R', 'Q', 'INFO1411'),
(9, 'INFO1334', 'C#.NET', 4.5, 'R', 'R', 'Q', 'INFO1434'),
(10, 'INFO1337', 'IBMI Environment', 2, 'E', 'R', 'Q', ''),
(11, 'INFO1431', 'Web Page Fundamentals', 3, 'R', 'R', 'Q', 'INFO1431'),
(12, 'INFO2531', 'Linux Operating Systems', 2, 'R', 'R', 'Q', 'INFO1171'),
(13, 'INFO1441', 'Advanced Windows Operating Systems', 3, 'R', '', 'Q', ''),
(14, 'INFO1314', 'Java', 4.5, 'R', 'R', 'Q', 'INFO1414'),
(15, 'INFO1434', 'Advanced C#.NET', 4.5, 'R', 'R', 'Q', 'INFO1434'),
(16, 'INFO1515', 'Database Administration', 3, 'R', 'R', 'Q', ''),
(17, 'INFO1221', 'MVS Environment', 2, 'E', 'R', 'Q', 'INFO1428'),
(18, 'INFO1414', 'Advanced Java', 4.5, 'R', 'R', 'Q', 'INFO1414'),
(19, 'INFO1425', 'JavaScript & jQuery', 3, 'R', 'R', 'Q', 'INFO2431'),
(20, 'INFO1428', 'COBOL', 4.5, 'E', 'R', 'Q', 'INFO1428'),
(21, 'INFO2514', 'JSP', 4.5, 'E', 'R', 'Q', 'INFO2514'),
(22, 'INFO2678', 'DB2 & SQL', 3, '', 'R', 'Q', 'INFO2418'),
(23, 'INFO2528', 'Advanced COBOL', 4.5, '', 'R', 'Q', 'INFO2528'),
(24, 'INFO2558', 'System Analysis & Design', 3, '', 'R', 'Q', 'INFO2638'),
(25, 'INFO2611', 'Practicum or Employment Tech', 3, 'R', 'R', 'Q', 'INFO2700'),
(26, 'INFO2638', 'Integrated Capstone', 4.5, '', 'R', 'Q', 'INFO2638'),
(27, 'INFO1522', 'Web Layout', 3, 'R', 'E', 'Q', ''),
(28, 'INFO1511', 'Advanced Database Concepts', 3, 'R', 'E', 'Q', 'INFO2411'),
(29, 'INFO2534', 'ASP', 4.5, 'R', 'E', 'Q', 'INFO2534'),
(30, 'INFO1525', 'Web Server Scripting', 4.5, 'R', '', 'Q', 'INFO2525'),
(31, 'INFO1514', 'Mobile Device Programming', 4.5, 'R', 'E', 'Q', 'INFO2584'),
(32, 'INFO2544', 'Object-Oriented Analysis & Design', 3, 'R', '', 'Q', 'INFO2644'),
(33, 'INFO2644', 'PC & Web Capstone', 4.5, 'R', '', 'Q', 'INFO2644'),
(34, 'INFO2533', 'SharePoint', 2, 'E', 'E', 'Q', ''),
(35, 'INFO2574', 'Advanced Programming Using VB', 4.5, 'E', 'E', 'Q', 'INFO2574'),
(36, 'BSADIOIO', 'Microsoft Applications I', 3, 'R', 'R', 'S', 'MULTIPLE'),
(38, 'INFO1151', 'IT Fundamentals', 3, 'R', 'R', 'S', 'INFO1151'),
(39, 'INFO1171', 'PC Operating Systems', 3, 'R', 'R', 'S', 'MULTIPLE'),
(40, 'INFO1214', 'Programming Concepts', 2, 'R', 'R', 'S', 'INFO1214'),
(41, 'INFO1281', 'Networking Concepts', 2, 'R', 'R', 'S', 'INFO1381'),
(42, 'INFO1411', 'Database Concepts', 3, 'R', 'R', 'S', 'INFO1311'),
(43, 'INFO1428', 'JCL & COBOL', 4, 'R', 'R', 'S', 'MULTIPLE'),
(44, 'INFO1431', 'Web Page Fundamentals', 3, 'R', 'R', 'S', 'INFO1431'),
(45, 'INFO1434', 'C#.NET', 4, 'R', 'R', 'S', 'MULTIPLE'),
(46, 'INFO1414', 'Java', 4, 'R', 'R', 'S', 'MULTIPLE'),
(47, 'INFO2431', 'JavaScript & jQuery', 3, 'R', 'R', 'S', 'INFO1425'),
(48, 'INFO2411', 'Advanced Database Concepts', 3, 'R', 'E', 'S', 'INFO1511'),
(49, 'INFO2534', 'ASP.NET', 3, 'R', 'E', 'S', 'INFO2534'),
(50, 'INFO2525', 'Web Server Scripting', 3, 'R', 'E', 'S', 'INFO1525'),
(51, 'INFO2418', 'DB2', 3, 'E', 'R', 'S', 'INFO2678'),
(52, 'INFO2514', 'Java Server', 3, 'E', 'R', 'S', 'INFO2514'),
(53, 'INFO2528', 'Advanced COBOL', 3, 'E', 'R', 'S', 'INFO2528'),
(54, 'INFO2574', 'Advanced Programming Using VB', 3, 'R', 'R', 'S', 'INFO2574'),
(55, 'INFO2584', 'Mobile Device Programming', 3, 'R', 'R', 'S', 'INFO1514'),
(56, 'INFO2700', 'Practicum or Employment Tech', 3, 'R', 'R', 'S', 'INFO2611'),
(57, 'INFO2644', 'PC Capstone', 4, 'R', '', 'S', 'MULTIPLE'),
(58, 'INFO2638', 'IP Capstone', 4, '', 'R', 'S', 'MULTIPLE');

-- --------------------------------------------------------

--
-- Table structure for table `plandata`
--

CREATE TABLE `plandata` (
  `PlanID` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studentplans`
--

CREATE TABLE `studentplans` (
  `PlanID` int(11) NOT NULL,
  `StudentID` int(6) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `lName` varchar(50) NOT NULL,
  `planDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `plandata`
--
ALTER TABLE `plandata`
  ADD PRIMARY KEY (`PlanID`,`ID`),
  ADD KEY `FK_CoursID` (`ID`);

--
-- Indexes for table `studentplans`
--
ALTER TABLE `studentplans`
  ADD PRIMARY KEY (`PlanID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT for table `studentplans`
--
ALTER TABLE `studentplans`
  MODIFY `PlanID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `plandata`
--
ALTER TABLE `plandata`
  ADD CONSTRAINT `FK_CoursID` FOREIGN KEY (`ID`) REFERENCES `courses` (`ID`),
  ADD CONSTRAINT `FK_PlanID` FOREIGN KEY (`PlanID`) REFERENCES `studentplans` (`PlanID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
