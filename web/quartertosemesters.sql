-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2019 at 06:54 PM
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
(11, 'INFO1431', 'Web Page Fund', 3, 'R', 'R', 'Q'),
(12, 'INFO2531', 'Linux Operating Systems', 2, 'R', 'R', 'Q'),
(13, 'INFO1441', 'Advanced Windows Operating Sys', 3, 'R', '', 'Q'),
(14, 'INFO1314', 'Java', 4.5, 'R', 'R', 'Q'),
(15, 'INFO1434', 'Advanced C#.NET', 4.5, 'R', 'R', 'Q'),
(16, 'INFO1515', 'Database Administration', 3, 'R', 'R', 'Q'),
(17, 'INFO1221', 'MVS Environment', 2, 'E', 'R', 'Q'),
(18, 'INFO1414', 'Advanced Java', 4.5, 'R', 'R', 'Q'),
(19, 'INFO1425', 'JavaScript & jQuery', 3, 'R', 'R', 'Q');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
