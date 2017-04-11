-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2017 at 01:35 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

CREATE TABLE `business` (
  `id_business` int(11) NOT NULL,
  `business_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `business`
--

INSERT INTO `business` (`id_business`, `business_name`) VALUES
(5, 'Cơ quan B'),
(6, 'cơ quan C');

--
-- Triggers `business`
--
DELIMITER $$
CREATE TRIGGER `delete_business` BEFORE DELETE ON `business` FOR EACH ROW BEGIN
DELETE FROM documents
  WHERE documents.id_business=OLD.id_business;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `categorys`
--

CREATE TABLE `categorys` (
  `idcate` int(11) NOT NULL,
  `catename` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `categorys`
--

INSERT INTO `categorys` (`idcate`, `catename`) VALUES
(2, 'Java'),
(11, 'C#'),
(12, 'PHP');

--
-- Triggers `categorys`
--
DELIMITER $$
CREATE TRIGGER `delete_category` BEFORE DELETE ON `categorys` FOR EACH ROW BEGIN
DELETE FROM documents
  WHERE documents.idcate=OLD.idcate;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id_class` int(11) NOT NULL,
  `class_name` varchar(6) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id_class`, `class_name`) VALUES
(1, 'DH14PM'),
(4, 'DH14TH');

--
-- Triggers `class`
--
DELIMITER $$
CREATE TRIGGER `delete_class` BEFORE DELETE ON `class` FOR EACH ROW BEGIN
DELETE FROM documents
  WHERE documents.id_class=OLD.id_class;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `documents`
--

CREATE TABLE `documents` (
  `id_document` int(11) NOT NULL,
  `document_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `idcate` int(11) NOT NULL,
  `id_teacher` int(11) NOT NULL,
  `point` float NOT NULL,
  `student` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `id_business` int(11) NOT NULL,
  `id_class` int(11) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `documents`
--

INSERT INTO `documents` (`id_document`, `document_name`, `idcate`, `id_teacher`, `point`, `student`, `id_business`, `id_class`, `status`) VALUES
(9, 'Website bán hàng máy tính', 12, 5, 8.2, 'Sinh viên A', 5, 4, 1),
(10, 'Phần mềm quản lý kho', 11, 3, 8.2, 'Sinh Viên B', 6, 1, 1),
(11, 'Website tin tức', 12, 3, 7, 'Sinh viên C', 5, 4, 1),
(12, 'Website giới thiệu cơ quan', 2, 5, 7, 'Sinh viên D', 6, 1, 1);

--
-- Triggers `documents`
--
DELIMITER $$
CREATE TRIGGER `delete_document` BEFORE DELETE ON `documents` FOR EACH ROW BEGIN
DELETE FROM orders
  WHERE orders.id_document=OLD.id_document;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `id_notice` int(11) NOT NULL,
  `notice_info` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`id_notice`, `notice_info`, `status`) VALUES
(4, '<p>Th&ocirc;ng b&aacute;o 1</p>\r\n', 1),
(23, '<p>Th&ocirc;ng b&aacute;o 2</p>\r\n', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  `id_document` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `receive_time` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id_order`, `id_account`, `id_document`, `create_time`, `receive_time`, `status`) VALUES
(12, 26, 10, '2017-04-11 06:27:18', '2017-04-11 06:27:48', 1),
(13, 26, 11, '2017-04-11 06:27:18', '2017-04-11 06:31:18', 1);

--
-- Triggers `orders`
--
DELIMITER $$
CREATE TRIGGER `update_status_document` AFTER DELETE ON `orders` FOR EACH ROW BEGIN
UPDATE documents
	SET documents.status=1 WHERE documents.id_document = OLD.id_document;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL,
  `teacher_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id_teacher`, `teacher_name`) VALUES
(3, 'Ngô Văn T'),
(5, 'Nguyễn Ngọc Lý');

--
-- Triggers `teacher`
--
DELIMITER $$
CREATE TRIGGER `delete_teacher` BEFORE DELETE ON `teacher` FOR EACH ROW BEGIN
DELETE FROM documents
  WHERE documents.id_teacher=OLD.id_teacher;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_account` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `level` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_account`, `username`, `password`, `fullname`, `email`, `phone`, `level`) VALUES
(26, 'admin', 'fcea92 f7412b5da7be0cf42b8c93759', 'Thạnh', 'thanh@mail.com', '123456789', 1),
(27, 'member', 'fcea92 f7412b5da7be0cf42b8c93759', 'User', 'user@mail.com', '00000000', 0);

--
-- Triggers `user`
--
DELIMITER $$
CREATE TRIGGER `delete_user` BEFORE DELETE ON `user` FOR EACH ROW BEGIN
DELETE FROM orders
  WHERE orders.id_account=OLD.id_account;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `business`
--
ALTER TABLE `business`
  ADD PRIMARY KEY (`id_business`);

--
-- Indexes for table `categorys`
--
ALTER TABLE `categorys`
  ADD PRIMARY KEY (`idcate`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id_class`);

--
-- Indexes for table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`id_document`),
  ADD KEY `fk_cate` (`idcate`),
  ADD KEY `fk_teach` (`id_teacher`),
  ADD KEY `fk_busi` (`id_business`),
  ADD KEY `fk_class` (`id_class`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`id_notice`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `fk_acc` (`id_account`),
  ADD KEY `fk_doc` (`id_document`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id_teacher`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_account`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `business`
--
ALTER TABLE `business`
  MODIFY `id_business` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `categorys`
--
ALTER TABLE `categorys`
  MODIFY `idcate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id_class` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `documents`
--
ALTER TABLE `documents`
  MODIFY `id_document` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `id_notice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id_teacher` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `documents`
--
ALTER TABLE `documents`
  ADD CONSTRAINT `fk_busi` FOREIGN KEY (`id_business`) REFERENCES `business` (`id_business`),
  ADD CONSTRAINT `fk_cate` FOREIGN KEY (`idcate`) REFERENCES `categorys` (`idcate`),
  ADD CONSTRAINT `fk_class` FOREIGN KEY (`id_class`) REFERENCES `class` (`id_class`),
  ADD CONSTRAINT `fk_teach` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_teacher`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_acc` FOREIGN KEY (`id_account`) REFERENCES `user` (`id_account`),
  ADD CONSTRAINT `fk_doc` FOREIGN KEY (`id_document`) REFERENCES `documents` (`id_document`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
