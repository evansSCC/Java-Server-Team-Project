-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2019 at 05:56 PM
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
  `courseName` varchar(30) NOT NULL,
  `creditHours` double NOT NULL,
  `pcWeb` char(1) DEFAULT NULL,
  `integrated` char(1) DEFAULT NULL,
  `type` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`ID`, `courseID`, `courseName`, `creditHours`, `pcWeb`, `integrated`, `type`) VALUES
(1, 'INFO1121', 'Microsoft Word & PowerPoint', 1.5, 'R', 'R', 'Q'),
(2, 'INFO1131', 'Microsoft Excel', 1.5, 'R', 'R', 'Q'),
(3, 'INFO1151', 'Information Technology Fundame', 4.5, 'R', 'R', 'Q'),
(4, 'INFO1161', 'Windows Operating Systems', 4.5, 'R', 'R', 'Q'),
(5, 'INFO1211', 'Microsoft Access', 3, 'R', 'R', 'Q'),
(6, 'INFO1214', 'Program Design & Problem Solvi', 4.5, 'R', 'R', 'Q'),
(7, 'INFO1381', 'Data Communications & Networki', 4.5, 'R', 'R', 'Q'),
(8, 'INFO1311', 'Database Concepts', 3, 'R', 'R', 'Q'),
(9, 'INFO1334', 'C#.NET', 4.5, 'R', 'R', 'Q'),
(10, 'INFO1337', 'IBMI Environment', 2, 'E', 'R', 'Q'),
(11, 'INFO1431', 'Web Page Fundamentals', 3, 'R', 'R', 'Q'),
(12, 'INFO2531', 'Linux Operating Systems', 2, 'R', 'R', 'Q'),
(13, 'INFO1441', 'Advanced Windows Operating Sys', 3, 'R', '', 'Q'),
(14, 'INFO1314', 'Java', 4.5, 'R', 'R', 'Q'),
(15, 'INFO1434', 'Advanced C#.NET', 4.5, 'R', 'R', 'Q'),
(16, 'INFO1515', 'Database Administration', 3, 'R', 'R', 'Q'),
(17, 'INFO1221', 'MVS Environment', 2, 'E', 'R', 'Q'),
(18, 'INFO1414', 'Advanced Java', 4.5, 'R', 'R', 'Q'),
(19, 'INFO1425', 'JavaScript & jQuery', 3, 'R', 'R', 'Q'),
(20, 'INFO1428', 'COBOL', 4.5, 'E', 'R', 'Q'),
(21, 'INFO2514', 'JSP', 4.5, 'E', 'R', 'Q'),
(22, 'INFO2678', 'DB2 & SQL', 3, '', 'R', 'Q'),
(23, 'INFO2528', 'Advanced COBOL', 4.5, '', 'R', 'Q'),
(24, 'INFO2558', 'System Analysis & Design', 3, '', 'R', 'Q'),
(25, 'INFO2611', 'Practicum or Employment Tech', 3, 'R', 'R', 'Q'),
(26, 'INFO2638', 'Integrated Capstone', 4.5, '', 'R', 'Q'),
(27, 'INFO1522', 'Web Layout', 3, 'R', 'E', 'Q'),
(28, 'INFO1511', 'Advanced Database Concepts', 3, 'R', 'E', 'Q'),
(29, 'INFO2534', 'ASP', 4.5, 'R', 'E', 'Q'),
(30, 'INFO1525', 'Web Server Scripting', 4.5, 'R', '', 'Q'),
(31, 'INFO1514', 'Mobile Device Programming', 4.5, 'R', 'E', 'Q'),
(32, 'INFO2544', 'Object-Oriented Analysis & Des', 3, 'R', '', 'Q'),
(33, 'INFO2644', 'PC & Web Capstone', 4.5, 'R', '', 'Q'),
(34, 'INFO2533', 'SharePoint', 2, 'E', 'E', 'Q'),
(35, 'INFO2574', 'Advanced Programming Using VB', 4.5, 'E', 'E', 'Q'),
(36, 'BSAD1010', 'Microsoft Applications I', 3, 'R', 'R', 'S'),
(38, 'INFO1151', 'IT Fundamentals', 3, 'R', 'R', 'S'),
(39, 'INFO1171', 'PC Operating Systems', 3, 'R', 'R', 'S'),
(40, 'INFO1214', 'Programming Concepts', 2, 'R', 'R', 'S'),
(41, 'INFO1281', 'Networking Concepts', 2, 'R', 'R', 'S'),
(42, 'INFO1411', 'Database Concepts', 3, 'R', 'R', 'S'),
(43, 'INFO1428', 'JCL & COBOL', 4, 'R', 'R', 'S'),
(44, 'INFO1431', 'Web Page Fundamentals', 3, 'R', 'R', 'S'),
(45, 'INFO1434', 'C#.NET', 4, 'R', 'R', 'S'),
(46, 'INFO1414', 'Java', 4, 'R', 'R', 'S'),
(47, 'INFO2431', 'JavaScript & jQuery', 3, 'R', 'R', 'S'),
(48, 'INFO2411', 'Advanced DB', 3, 'R', 'E', 'S'),
(49, 'INFO2534', 'ASP.NET', 3, 'R', 'E', 'S'),
(50, 'INFO2525', 'Web Server Scripting', 3, 'R', 'E', 'S'),
(51, 'INFO2418', 'DB2', 3, 'E', 'R', 'S'),
(52, 'INFO2514', 'Java Server', 3, 'E', 'R', 'S'),
(53, 'INFO2528', 'Advanced COBOL', 3, 'E', 'R', 'S'),
(54, 'INFO2574', 'Advanced Programming Using VB', 3, 'R', 'R', 'S'),
(55, 'INFO2584', 'Mobile Device Programming', 3, 'R', 'R', 'S'),
(56, 'INFO2700', 'Practicum or Employment Tech', 3, 'R', 'R', 'S'),
(57, 'INFO2644', 'PC Capstone', 4, 'R', '', 'S'),
(58, 'INFO2638', 'IP Capstone', 4, '', 'R', 'S');

-- --------------------------------------------------------

--
-- Table structure for table `plancomments`
--

CREATE TABLE `plancomments` (
  `commentID` int(11) NOT NULL,
  `planID` int(11) NOT NULL,
  `adminID` int(11) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `plandata`
--

CREATE TABLE `plandata` (
  `PlanID` int(11) NOT NULL,
  `ID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plandata`
--

INSERT INTO `plandata` (`PlanID`, `ID`) VALUES
(11, '2');

-- --------------------------------------------------------

--
-- Table structure for table `studentplans`
--

CREATE TABLE `studentplans` (
  `PlanID` int(11) NOT NULL,
  `StudentID` int(6) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `lName` varchar(50) NOT NULL,
  `planDate` datetime NOT NULL,
  `focus` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentplans`
--

INSERT INTO `studentplans` (`PlanID`, `StudentID`, `fName`, `lName`, `planDate`, `focus`) VALUES
(1, 123456, 'John', 'Doe', '2019-03-11 10:27:13', 'pcweb'),
(2, 123456, 'John', 'Doe', '2019-03-11 10:31:43', 'pcweb'),
(3, 123456, 'John', 'Doe', '2019-03-11 10:32:29', 'pcwb'),
(4, 123456, 'John', 'Doe', '2019-03-11 10:33:29', 'pcweb'),
(5, 123456, 'John', 'Doe', '2019-03-11 10:44:03', 'pcweb'),
(6, 123456, 'John', 'Doe', '2019-03-11 10:44:51', 'pcweb'),
(7, 123456, 'John', 'Doe', '2019-03-11 10:47:19', 'pcweb'),
(8, 123456, 'John', 'Doe', '2019-03-11 10:48:47', 'pcweb'),
(9, 123456, 'John', 'Doe', '2019-03-11 10:49:45', 'pcweb'),
(10, 123456, 'John', 'Doe', '2019-03-11 10:49:58', 'pcweb'),
(11, 123456, 'John', 'Doe', '2019-03-11 10:50:57', 'pcweb');

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE `userrole` (
  `adminID` int(11) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `adminID` int(11) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `password` tinytext NOT NULL
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
-- Indexes for table `plancomments`
--
ALTER TABLE `plancomments`
  ADD PRIMARY KEY (`commentID`);

--
-- Indexes for table `plandata`
--
ALTER TABLE `plandata`
  ADD PRIMARY KEY (`PlanID`,`ID`);

--
-- Indexes for table `studentplans`
--
ALTER TABLE `studentplans`
  ADD PRIMARY KEY (`PlanID`);

--
-- Indexes for table `userrole`
--
ALTER TABLE `userrole`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`adminID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT for table `plancomments`
--
ALTER TABLE `plancomments`
  MODIFY `commentID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `studentplans`
--
ALTER TABLE `studentplans`
  MODIFY `PlanID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `userrole`
--
ALTER TABLE `userrole`
  ADD CONSTRAINT `fk_adminID` FOREIGN KEY (`adminID`) REFERENCES `users` (`adminID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
