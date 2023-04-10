-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2022 at 12:11 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `aid` int(5) NOT NULL,
  `a_name` varchar(20) NOT NULL,
  `a_add` varchar(30) NOT NULL,
  `aph_no` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`aid`, `a_name`, `a_add`, `aph_no`) VALUES
(23, 'asdfg', 'plase', 9876),
(123, 'Paolo Coelho', 'Rio de Janeiro', 1446834566),
(234, 'Nicola Yoon', 'New York', 1447534972),
(345, 'Sarah Maas', 'Los Angeles', 1444572396),
(456, 'Cecelia Ahern', 'Dublin', 1983375472),
(666, 'HC Varma', 'Mumbai', 917763453),
(667, 'Yashwant Kanetkar', 'Delhi', 913334851);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `Bid` int(5) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `Category` varchar(20) NOT NULL,
  `pg_cnt` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`Bid`, `Title`, `Category`, `pg_cnt`) VALUES
(56, 'dfgh', 'erty', 30),
(92, 'A Court of Mist and Fury', 'Fantasy', 470),
(93, 'A court of Thorn and Roses', 'Fantasy', 450),
(94, 'Flawed', 'Chicklit', 350),
(95, 'Everything Everything', 'Fiction', 300),
(96, 'The Pilgrimage', 'Adventure', 300),
(97, 'Brida', 'Fiction', 400),
(98, 'The Alchemist', 'Adventure', 250),
(100, 'Let Us C', 'Educational', 250),
(101, 'Concepts of Physics', 'Educational', 500);

-- --------------------------------------------------------

--
-- Table structure for table `borrows`
--

CREATE TABLE `borrows` (
  `Bid` int(5) DEFAULT NULL,
  `Uid` varchar(5) DEFAULT NULL,
  `issue_date` varchar(10) DEFAULT NULL,
  `return_date` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrows`
--

INSERT INTO `borrows` (`Bid`, `Uid`, `issue_date`, `return_date`) VALUES
(94, 'rh15', '08-12-2022', '08-01-2023'),
(95, 'sh03', '16-11-2022', '16-12-2022');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Uid` varchar(5) NOT NULL,
  `u_name` varchar(20) NOT NULL,
  `u_add` varchar(30) NOT NULL,
  `uph_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Uid`, `u_name`, `u_add`, `uph_no`) VALUES
('88', 'qwerty', 'ert', 456),
('rh15', 'Rhea Desouza', 'Porvorim', 917744563),
('sh03', 'Sasha Fernandes', 'Mapusa', 917856423);

-- --------------------------------------------------------

--
-- Table structure for table `writes`
--

CREATE TABLE `writes` (
  `Bid` int(5) DEFAULT NULL,
  `aid` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `writes`
--

INSERT INTO `writes` (`Bid`, `aid`) VALUES
(92, 345),
(93, 345),
(96, 123),
(97, 123),
(98, 123),
(95, 234),
(94, 456),
(101, 666),
(100, 667);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`Bid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
