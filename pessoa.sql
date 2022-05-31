-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 31-Maio-2022 às 21:39
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `teste`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `nome` varchar(100) DEFAULT NULL,
  `cargo` varchar(200) DEFAULT NULL,
  `digital` varchar(9) DEFAULT NULL,
  `url` varchar(8000) DEFAULT NULL,
  `entrada` varchar(255) DEFAULT NULL,
  `saida` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`nome`, `cargo`, `digital`, `url`, `entrada`, `saida`) VALUES
('Iasgo mais cedo', 'Aluno(a):', '2424', 'https://cdn.discordapp.com/avatars/243437977903169536/dca0707a09dc5eceea11566f82ac16b4.png?size=2048', NULL, NULL),
('Kadminho', 'Aluno(a):', '12', 'https://pbs.twimg.com/media/FEQ96WnXwAEOhAH.jpg', NULL, NULL),
('Rodrigo', 'Aluno(a):', '77', 'https://cdn.discordapp.com/attachments/980503554156539955/980656731115884605/petrede-cachorro-oculos-escuros.jpg', NULL, NULL),
('Ian', 'Aluno(a):', '49', 'https://cdn.discordapp.com/avatars/464570134535602186/a_47fe93c7d533821d2307906739d6880b.gif?size=2048', NULL, NULL),
('Lane', 'Aluno(a):', '222', 'https://cdn.discordapp.com/attachments/885737796944396341/981018446894608444/unknown.png', NULL, NULL),
('Iago L', 'Aluno(a):', '01', 'https://cdn.discordapp.com/attachments/908815223249567795/981019575032365146/gengar.gif', NULL, NULL),
('Venas', 'Aluno(a):', '13/17', 'https://cdn.discordapp.com/attachments/826583208106917936/981030505803812886/twitter_0uoXJPmj_400x400.jpg', NULL, NULL),
('Andre', 'Aluno(a):', '1337', 'https://cdn.discordapp.com/attachments/885737796944396341/981221337697767464/unknown.png', NULL, NULL),
('Nicolas', 'Aluno(a):', '14', 'https://cdn.discordapp.com/attachments/885737796944396341/980199927969873950/85f7ef989006877907ed5abb9b503c9d.jpg', NULL, NULL),
('Alexandre', 'Professor(a):', '100', 'https://pps.whatsapp.net/v/t61.24694-24/71522266_2585993474795854_317743635980382640_n.jpg?ccb=11-4&oh=01_AVyHvOXX3VDtN2YgR5DH8qv43c6HvlJdH7jGFzeRmgA9eA&oe=62A4836B', NULL, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
