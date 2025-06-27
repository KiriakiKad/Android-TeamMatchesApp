-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: localhost
-- Χρόνος δημιουργίας: 29 Μάη 2022 στις 11:10:33
-- Έκδοση διακομιστή: 10.4.24-MariaDB
-- Έκδοση PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `battles`
--
CREATE DATABASE IF NOT EXISTS `battles` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `battles`;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `fixtures`
--

CREATE TABLE `fixtures` (
  `home` int(11) NOT NULL,
  `away` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Άδειασμα δεδομένων του πίνακα `fixtures`
--

INSERT INTO `fixtures` (`home`, `away`) VALUES
(2, 1),
(2, 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `name` varchar(24) COLLATE utf8_bin NOT NULL,
  `emblem` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Άδειασμα δεδομένων του πίνακα `team`
--

INSERT INTO `team` (`id`, `name`, `emblem`) VALUES
(1, 'MCU', 'https://i1.sndcdn.com/avatars-000246853705-jvwi7h-t500x500.jpg'),
(2, 'DC', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/DC_Comics_logo.svg/1200px-DC_Comics_logo.svg.png'),
(3, 'FF', 'https://upload.wikimedia.org/wikipedia/en/thumb/5/58/Finos_Film_logo.svg/1280px-Finos_Film_logo.svg.png');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `team_member`
--

CREATE TABLE `team_member` (
  `id` int(11) NOT NULL,
  `team` int(11) NOT NULL,
  `name` varchar(24) COLLATE utf8_bin NOT NULL,
  `image` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Άδειασμα δεδομένων του πίνακα `team_member`
--

INSERT INTO `team_member` (`id`, `team`, `name`, `image`) VALUES
(3, 1, 'Iron Man', 'https://m.media-amazon.com/images/M/MV5BMTI5ODY5NTUzMF5BMl5BanBnXkFtZTcwOTAzNTIzMw@@._V1_.jpg'),
(4, 1, 'Black Panther', 'https://media.oneman.gr/onm-images/Black-Panther-Chadwick-Boseman-1.jpg'),
(5, 1, 'Doctor Strange', 'https://youfly.com/wp-content/uploads/2022/04/doctor-strange-multiverse-of-madness-saoudikh-aravia.jpg'),
(9, 2, 'Superman', 'https://media-flix-gr.s3.amazonaws.com/cache/fc/96/fc96e77ba85cc20dbda39fe4d6ef2a68.jpg'),
(10, 2, 'Batman', 'https://cawettejones.com/wp-content/uploads/2020/07/x_qs-dark-knight-prm_b-e1594647350574.jpg'),
(11, 2, 'Wonder Woman', 'https://i.blogs.es/94381a/wonder-woman-artwork/original.jpg'),
(12, 3, 'Θου Βου', 'https://www.koupakoupa.gr/media/upload-files/resizes/6392/lightbox_mochup_700x700_90_thumbnailoverlay_60659118ea115.jpg'),
(13, 3, 'Ζήκος', 'https://nb.bbend.net/media/news/2017/03/20/778739/snapshot/mpakalogatos.jpg'),
(14, 3, 'Θεία από Σικάγο', 'https://kouiz.gr/wp-content/uploads/kouiz-quiz-h-theia-ap-to-sikago-7.jpg');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `fixtures`
--
ALTER TABLE `fixtures`
  ADD PRIMARY KEY (`home`,`away`);

--
-- Ευρετήρια για πίνακα `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- Ευρετήρια για πίνακα `team_member`
--
ALTER TABLE `team_member`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `team`
--
ALTER TABLE `team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT για πίνακα `team_member`
--
ALTER TABLE `team_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `fixtures`
--
ALTER TABLE `fixtures`
  ADD CONSTRAINT `fixtures_ibfk_1` FOREIGN KEY (`home`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fixtures_ibfk_2` FOREIGN KEY (`away`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Περιορισμοί για πίνακα `team_member`
--
ALTER TABLE `team_member`
  ADD CONSTRAINT `team_member_ibfk_1` FOREIGN KEY (`team`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
