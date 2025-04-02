-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2024 a las 22:41:51
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreria`
--
CREATE DATABASE IF NOT EXISTS `libreria` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `libreria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE `autores` (
  `id_autor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `pais` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`id_autor`, `nombre`, `pais`) VALUES
(1, 'Gabriel García Márquez', 'Colombia'),
(2, 'Isabel Allende', 'Chile'),
(3, 'Mario Vargas Llosa', 'Perú'),
(4, 'Julio Cortázar', 'Argentina'),
(5, 'Jorge Luis Borges', 'Argentina'),
(6, 'Carlos Fuentes', 'México'),
(7, 'Pablo Neruda', 'Chile'),
(8, 'Octavio Paz', 'México'),
(9, 'Roberto Bolaño', 'Chile'),
(10, 'Laura Esquivel', 'México');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

CREATE TABLE `editoriales` (
  `id_editorial` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `pais` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `editoriales`
--

INSERT INTO `editoriales` (`id_editorial`, `nombre`, `pais`) VALUES
(1, 'Penguin Random House', 'Estados Unidos'),
(2, 'Planeta', 'España'),
(3, 'Alfaguara', 'España'),
(4, 'Anagrama', 'España'),
(5, 'Seix Barral', 'España'),
(6, 'Tusquets', 'España'),
(7, 'Fondo de Cultura Económica', 'México'),
(8, 'Siglo XXI Editores', 'México'),
(9, 'Norma', 'Colombia'),
(10, 'Ediciones B', 'España');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id_libro` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  `id_editorial` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id_libro`, `titulo`, `fecha_publicacion`, `id_autor`, `id_editorial`) VALUES
(1, 'Cien años de soledad', '1967-05-30', 1, 1),
(2, 'La casa de los espíritus', '1982-11-10', 2, 2),
(3, 'La ciudad y los perros', '1963-01-20', 3, 3),
(4, 'Rayuela', '1963-06-28', 4, 4),
(5, 'Ficciones', '1944-10-23', 5, 5),
(6, 'Aura', '1962-09-01', 6, 6),
(7, 'Veinte poemas de amor y una canción desesperada', '1924-07-15', 7, 7),
(8, 'El laberinto de la soledad', '1950-06-30', 8, 8),
(9, '2666', '2004-11-15', 9, 9),
(10, 'Como agua para chocolate', '1989-12-01', 10, 10),
(11, 'El otoño del patriarca', '1975-03-20', 1, 1),
(12, 'Los detectives salvajes', '1998-02-02', 9, 3),
(13, 'El amor en los tiempos del cólera', '1985-09-15', 1, 2),
(14, 'Pantaleón y las visitadoras', '1973-04-19', 3, 4),
(15, 'Crónica de una muerte anunciada', '1981-10-13', 1, 5),
(16, 'Confieso que he vivido', '1974-05-18', 7, 6),
(17, 'Pedro Páramo', '1955-03-12', 6, 1),
(18, 'Los pasos perdidos', '1953-09-12', 8, 9),
(19, 'El Aleph', '1949-09-05', 5, 7),
(20, 'El reino de este mundo', '1949-07-10', 4, 10),
(21, 'El coronel no tiene quien le escriba', '1961-05-01', 1, 1),
(22, 'La sombra del viento', '2001-04-25', 2, 2),
(23, 'Conversación en La Catedral', '1969-03-28', 3, 3),
(24, 'Final del juego', '1956-09-25', 4, 4),
(25, 'El hacedor', '1960-08-15', 5, 5),
(26, 'La región más transparente', '1958-07-20', 6, 6),
(27, 'Residencia en la tierra', '1933-09-05', 7, 7),
(28, 'Piedra de sol', '1957-02-14', 8, 8),
(29, 'Estrella distante', '1996-08-18', 9, 9),
(30, 'Tan veloz como el deseo', '1989-12-01', 10, 10),
(31, 'El general en su laberinto', '1989-04-12', 1, 1),
(32, 'Hija de la fortuna', '1999-07-05', 2, 2),
(33, 'La tía Julia y el escribidor', '1977-07-07', 3, 3),
(34, 'Historias de cronopios y de famas', '1962-03-25', 4, 4),
(35, 'El jardín de senderos que se bifurcan', '1941-01-01', 5, 5),
(36, 'La muerte de Artemio Cruz', '1962-06-19', 6, 6),
(37, 'Odas elementales', '1954-09-14', 7, 7),
(38, 'El arco y la lira', '1956-11-10', 8, 8),
(39, 'Nocturno de Chile', '1971-01-15', 9, 9),
(40, 'La ley del amor', '2000-05-22', 10, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`id_autor`);

--
-- Indices de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`id_editorial`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id_libro`),
  ADD KEY `id_autor` (`id_autor`),
  ADD KEY `id_editorial` (`id_editorial`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autores`
--
ALTER TABLE `autores`
  MODIFY `id_autor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  MODIFY `id_editorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id_libro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`),
  ADD CONSTRAINT `libros_ibfk_2` FOREIGN KEY (`id_editorial`) REFERENCES `editoriales` (`id_editorial`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
