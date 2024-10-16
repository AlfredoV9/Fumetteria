-- --------------------------------------------------------
-- Host:                         localhost
-- Versione server:              8.0.35 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database fumetteria
CREATE DATABASE IF NOT EXISTS `fumetteria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fumetteria`;

-- Dump della struttura di tabella fumetteria.actionfigure
CREATE TABLE IF NOT EXISTS `actionfigure` (
  `id` int NOT NULL AUTO_INCREMENT,
  `articolo_id` int DEFAULT NULL,
  `altezza` decimal(5,2) DEFAULT NULL,
  `materiale` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `articolo_id` (`articolo_id`),
  CONSTRAINT `actionfigure_ibfk_1` FOREIGN KEY (`articolo_id`) REFERENCES `articolocollezionabile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.actionfigure: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.articolocollezionabile
CREATE TABLE IF NOT EXISTS `articolocollezionabile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `descrizione` text,
  `data_rilascio` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.articolocollezionabile: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.autore
CREATE TABLE IF NOT EXISTS `autore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `nazionalita` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.autore: ~10 rows (circa)
INSERT INTO `autore` (`id`, `nome`, `cognome`, `nazionalita`) VALUES
	(1, 'Yukinobu', 'Tatsu', 'Giappone'),
	(2, 'Tatsuki', 'Fujimoto', 'Giappone'),
	(3, 'Donny', 'Cates', 'Stati Uniti'),
	(4, 'Chugong', NULL, 'Corea Del Sud'),
	(5, 'Chip', 'Zdarsky', 'Canada'),
	(6, 'Jonathan', 'Hickman', 'Stati Uniti'),
	(7, 'Eiichiro', 'Oda', 'Giappone'),
	(8, 'Lee', 'Jong-hu', 'Corea Del Sud'),
	(9, 'Takashi', 'Nagasaki', 'Giappone'),
	(10, 'Lee', 'Hyeon-Sook', 'Corea Del Sud');

-- Dump della struttura di tabella fumetteria.capitolo
CREATE TABLE IF NOT EXISTS `capitolo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `titolo` varchar(255) DEFAULT NULL,
  `volume_id` int NOT NULL,
  `data_pubblicazione` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `volume_id` (`volume_id`),
  CONSTRAINT `capitolo_ibfk_1` FOREIGN KEY (`volume_id`) REFERENCES `volume` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.capitolo: ~34 rows (circa)
INSERT INTO `capitolo` (`id`, `numero`, `titolo`, `volume_id`, `data_pubblicazione`) VALUES
	(1, 1, 'Ehi, ma così non è come ci si innamora?', 1, '2022-09-21'),
	(2, 2, 'Ehi, ma quello non è un alieno?', 1, '2022-09-21'),
	(3, 3, 'Vecchia contro vecchia', 1, '2022-09-21'),
	(4, 4, 'Andiamo in bagno', 1, '2022-09-21'),
	(5, 5, 'Riempiamo di botte la turbononna', 1, '2022-09-21'),
	(6, 6, 'A te non va un po\' di granchio?', 2, '2022-10-12'),
	(7, 7, 'La nonna da 100 km/h', 2, '2022-10-12'),
	(8, 8, 'Mangiamo il granchio', 2, '2022-10-12'),
	(9, 9, 'Ma dove sei?', 2, '2022-10-12'),
	(10, 10, 'Dove sono finite le mie palle?', 2, '2022-10-12'),
	(11, 11, 'La mela marcia', 2, '2022-10-12'),
	(12, 12, 'Sì, è davvero carina', 2, '2022-10-12'),
	(13, 13, 'Una strana donna', 2, '2022-10-12'),
	(14, 14, 'L\'acrobata dai capelli setosi (che nome lungo, eh?)', 2, '2022-10-12'),
	(15, 15, 'Chiamiamola Acroseta', 3, '2022-11-16'),
	(16, 16, 'Acroseta', 3, '2022-11-16'),
	(17, 17, 'In un mondo migliore', 3, '2022-11-16'),
	(18, 18, 'Mangiamoci un somen', 3, '2022-11-16'),
	(19, 19, 'Mi sa che si è arrabbiata', 3, '2022-11-16'),
	(20, 20, 'Ancora questi?', 3, '2022-11-16'),
	(21, 21, 'Voglio dei vestiti', 3, '2022-11-16'),
	(22, 22, 'Momo è ancora arrabbiata', 3, '2022-11-16'),
	(23, 23, 'Allora ti importa', 3, '2022-11-16'),
	(24, 24, 'Fusione! Serpo-Dover-Nessie!', 4, '2023-01-11'),
	(25, 25, 'Ehi, perché il mio cuore batte così forte?', 4, '2023-01-11'),
	(26, 26, 'Abbiamo trovato un kappa', 4, '2023-01-11'),
	(27, 27, 'Hai mai visto la mutilazione del bestiame? ', 4, '2023-01-11'),
	(28, 28, 'Turbamenti amorosi in arrivo', 4, '2023-01-11'),
	(29, 29, 'Primo amore', 4, '2023-01-11'),
	(30, 30, 'Non arrenderti!', 4, '2023-01-11'),
	(31, 31, 'Una vita da modello anatomico', 4, '2023-01-11'),
	(32, 32, 'Alla casa infestata!', 4, '2023-01-11'),
	(33, 1, 'Sayonara', 16, '2022-07-04'),
	(34, 2, 'Eri', 17, '2022-08-04');

-- Dump della struttura di tabella fumetteria.capitololetto
CREATE TABLE IF NOT EXISTS `capitololetto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utente_id` int NOT NULL,
  `capitolo_id` int NOT NULL,
  `stato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_id` (`utente_id`),
  KEY `capitolo_id` (`capitolo_id`),
  CONSTRAINT `capitololetto_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`),
  CONSTRAINT `capitololetto_ibfk_2` FOREIGN KEY (`capitolo_id`) REFERENCES `capitolo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.capitololetto: ~2 rows (circa)
INSERT INTO `capitololetto` (`id`, `utente_id`, `capitolo_id`, `stato`) VALUES
	(1, 1, 3, 'completato'),
	(2, 1, 33, 'completato'),
	(4, 1, 34, 'completato');

-- Dump della struttura di tabella fumetteria.cartecollezionabili
CREATE TABLE IF NOT EXISTS `cartecollezionabili` (
  `id` int NOT NULL AUTO_INCREMENT,
  `articolo_id` int DEFAULT NULL,
  `rarita` varchar(255) DEFAULT NULL,
  `set_collezione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `articolo_id` (`articolo_id`),
  CONSTRAINT `cartecollezionabili_ibfk_1` FOREIGN KEY (`articolo_id`) REFERENCES `articolocollezionabile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.cartecollezionabili: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.casaeditrice
CREATE TABLE IF NOT EXISTS `casaeditrice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `paese` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.casaeditrice: ~6 rows (circa)
INSERT INTO `casaeditrice` (`id`, `nome`, `paese`) VALUES
	(1, 'J-Pop', 'Italia'),
	(2, 'Star Comics', 'Italia'),
	(3, 'Panini Comics', 'Italia'),
	(4, 'Saldapress', 'Italia'),
	(5, 'BAO Publishing', 'Italia'),
	(6, 'Planet Manga', 'Italia');

-- Dump della struttura di tabella fumetteria.collezione
CREATE TABLE IF NOT EXISTS `collezione` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utente_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_id` (`utente_id`),
  CONSTRAINT `collezione_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.collezione: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.collezionearticolo
CREATE TABLE IF NOT EXISTS `collezionearticolo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `collezione_id` int NOT NULL,
  `articolo_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `collezione_id` (`collezione_id`),
  KEY `articolo_id` (`articolo_id`),
  CONSTRAINT `collezionearticolo_ibfk_1` FOREIGN KEY (`collezione_id`) REFERENCES `collezione` (`id`),
  CONSTRAINT `collezionearticolo_ibfk_2` FOREIGN KEY (`articolo_id`) REFERENCES `articolocollezionabile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.collezionearticolo: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.collezionevolume
CREATE TABLE IF NOT EXISTS `collezionevolume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `collezione_id` int NOT NULL,
  `volume_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `collezione_id` (`collezione_id`),
  KEY `volume_id` (`volume_id`),
  CONSTRAINT `collezionevolume_ibfk_1` FOREIGN KEY (`collezione_id`) REFERENCES `collezione` (`id`),
  CONSTRAINT `collezionevolume_ibfk_2` FOREIGN KEY (`volume_id`) REFERENCES `volume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.collezionevolume: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.commento
CREATE TABLE IF NOT EXISTS `commento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utente_id` int DEFAULT NULL,
  `tipo_entita` varchar(50) DEFAULT NULL,
  `entita_id` int DEFAULT NULL,
  `testo` varchar(250) DEFAULT NULL,
  `data_commento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_id` (`utente_id`),
  CONSTRAINT `commento_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.commento: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.fumetto
CREATE TABLE IF NOT EXISTS `fumetto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(255) NOT NULL,
  `descrizione` text,
  `data_rilascio` date DEFAULT NULL,
  `autore_id` int DEFAULT NULL,
  `casa_editrice_id` int DEFAULT NULL,
  `tipo` enum('MANGA','COMICS_AMERICANI','MANHWA','COMICS_ITALIANI','BANDE_DESSINEE','WEBTOON') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stato` enum('INTERROTTO','FINITO','IN_CORSO') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `raccomandato` tinyint DEFAULT NULL,
  `franchise` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `titolo` (`titolo`),
  KEY `autore_id` (`autore_id`),
  KEY `casa_editrice_id` (`casa_editrice_id`),
  CONSTRAINT `fumetto_ibfk_1` FOREIGN KEY (`autore_id`) REFERENCES `autore` (`id`),
  CONSTRAINT `fumetto_ibfk_2` FOREIGN KEY (`casa_editrice_id`) REFERENCES `casaeditrice` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.fumetto: ~23 rows (circa)
INSERT INTO `fumetto` (`id`, `titolo`, `descrizione`, `data_rilascio`, `autore_id`, `casa_editrice_id`, `tipo`, `stato`, `raccomandato`, `franchise`) VALUES
	(1, 'DanDaDan', 'Ken Takakura è un ragazzo vittima di atti di bullismo. Un giorno, il giovane inizia a dialogare per caso con la sua compagna di classe Momo Ayase. Lui è un fanatico dell\'occulto, mentre lei crede soltanto nei fantasmi. I due, per una scommessa, decidono di recarsi separatamente in zone associate sia all\'occulto che al soprannaturale. Visitando i rispettivi luoghi, entrambi si devono ricredere... inizia così la loro avventura.', '2022-09-21', 1, 1, 'MANGA', 'IN_CORSO', 1, 'Shonen Jump'),
	(2, 'Goodbye Eri', 'La madre di Yuta, sofferente di una malattia in fase terminale, chiede al figlio di filmarla per lasciargli un ricordo. Il giovane inizialmente accetta, rifiutandosi in seguito di registrare i suoi ultimi momenti. In preda allo sconforto, intende suicidarsi gettandosi dal tetto dell\'ospedale, dove incontra una strana ragazza che attira la sua attenzione', '2022-07-04', 2, 2, 'MANGA', 'FINITO', 0, 'Shonen Jump'),
	(3, 'Secret Wars: Battleworld', 'Un evento che riunisce diversi universi Marvel in una battaglia epica per la sopravvivenza.', '2015-05-07', 3, 3, 'COMICS_AMERICANI', 'FINITO', 1, 'Marvel Comics'),
	(4, 'Crossover', 'Un evento che unisce personaggi di fumetti diversi in un’unica narrazione, esplorando le conseguenze della fusione dei mondi.', '2020-11-04', 3, 4, 'COMICS_AMERICANI', 'IN_CORSO', 1, 'Marvel Comics'),
	(5, 'Doctor Strange: Damnation', 'Doctor Strange si ritrova a combattere forze oscure per riportare indietro le anime dei morti.', '2018-03-07', 3, 3, 'COMICS_AMERICANI', 'FINITO', 0, 'Marvel Comics'),
	(6, 'Thor (2020)', 'Le avventure del dio del tuono, Thor Odinson, mentre combatte contro forze oscure e affronta la sua eredità divina.', '2020-10-27', 3, 3, 'COMICS_AMERICANI', 'IN_CORSO', 0, 'Marvel Comics'),
	(7, 'Web of Venom: Wraith', 'La storia di Wraith, un personaggio che si interseca con l\'universo di Venom e Spider-Man.', '2019-03-27', 3, 3, 'COMICS_AMERICANI', 'FINITO', 0, 'Marvel Comics'),
	(8, 'Solo Leveling', 'Un ragazzo di nome Sung Jin-Woo diventa il cacciatore più forte di tutti dopo aver ottenuto la possibilità di aumentare il proprio livello in un mondo pieno di mostri.', '2018-03-25', 4, 2, 'MANHWA', 'FINITO', 1, 'Naver Webtoon'),
	(9, 'Solo Leveling Season 2: Arise from the Shadow', 'La continuazione delle avventure di Sung Jin-Woo mentre affronta nuove sfide e nemici.', '2021-07-04', 4, 2, 'MANHWA', 'IN_CORSO', 1, 'Naver Webtoon'),
	(10, 'Batman: Urban Legends', 'Una serie antologica che esplora le storie di Batman e dei suoi alleati.', '2021-03-09', 3, 3, 'COMICS_AMERICANI', 'IN_CORSO', 1, 'DC Comics'),
	(11, 'Sex Criminals', 'Una coppia scopre che può fermare il tempo quando fanno sesso, e decide di usare questo potere per rubare da una banca.', '2013-09-04', 5, 4, 'COMICS_AMERICANI', 'FINITO', 0, NULL),
	(12, 'Spider-Man: Life Story', 'Un racconto che narra la vita di Peter Parker, esplorando come le sue avventure come Spider-Man evolvono attraverso le decadi.', '2019-01-02', 5, 3, 'COMICS_AMERICANI', 'FINITO', 1, 'Marvel Comics'),
	(13, 'East of West', 'Un western distopico che esplora le conseguenze di una guerra tra gli Stati Uniti e una serie di poteri sovrannaturali.', '2013-03-20', 6, 4, 'COMICS_AMERICANI', 'FINITO', 1, NULL),
	(14, 'Avengers World', 'Una serie che esplora le avventure degli Avengers in un mondo sempre più pericoloso.', '2014-01-01', 6, 4, 'COMICS_AMERICANI', 'FINITO', 1, 'Marvel Comics'),
	(15, 'Ultimate Comics: Hawkeye', 'Le avventure di Hawkeye nell\'universo Ultimate.', '2011-12-14', 6, 3, 'COMICS_AMERICANI', 'FINITO', 0, 'Marvel Comics'),
	(16, 'Ultimate Comics: Ultimates', 'La storia degli Ultimates, una versione alternativa dei Vendicatori.', '2011-05-01', 6, 3, 'COMICS_AMERICANI', 'FINITO', 0, 'Marvel Comics'),
	(17, 'One Piece New Edition', 'La nuova edizione delle avventure di Monkey D. Luffy e la sua ciurma mentre cercano il tesoro leggendario conosciuto come One Piece.', '2019-09-04', 7, 2, 'MANGA', 'IN_CORSO', 1, 'Shonen Jump'),
	(18, 'One Piece Serie Blu', 'Un\'altra edizione delle avventure di One Piece, con storie classiche e nuovi archi narrativi.', '2019-11-15', 7, 2, 'MANGA', 'IN_CORSO', 1, 'Shonen Jump'),
	(19, 'Tower of God', 'Le avventure di Bam mentre cerca di raggiungere la cima della Tower of God e scoprire i misteri che essa nasconde.', '2010-07-17', 6, 6, 'WEBTOON', 'IN_CORSO', 1, 'LINE Webtoon'),
	(20, 'King of Eden', 'La storia di un mondo post-apocalittico, dove i sopravvissuti devono affrontare una nuova realtà.', '2010-09-03', 9, 6, 'MANGA', 'FINITO', 0, 'Kodansha'),
	(21, 'Nobody Knows', 'Una serie che affronta temi di isolamento e la ricerca di connessione in un mondo frenetico.', '2009-04-10', 10, 6, 'MANGA', 'FINITO', 0, 'Kodansha'),
	(22, 'The Flowers of Evil', 'Un racconto oscuro che esplora la giovinezza, la ribellione e le conseguenze delle azioni.', '2009-06-15', 10, 6, 'MANGA', 'FINITO', 0, 'Kodansha'),
	(23, 'Savage Garden', 'Una serie che combina elementi fantastici e drammatici in un mondo ricco di dettagli.', '2012-11-05', 10, 6, 'MANGA', 'FINITO', 0, 'Kodansha');

-- Dump della struttura di tabella fumetteria.fumetto_genere
CREATE TABLE IF NOT EXISTS `fumetto_genere` (
  `fumetto_id` int NOT NULL,
  `genere_id` int NOT NULL,
  PRIMARY KEY (`fumetto_id`,`genere_id`),
  KEY `genere_id` (`genere_id`),
  CONSTRAINT `fumetto_genere_ibfk_1` FOREIGN KEY (`fumetto_id`) REFERENCES `fumetto` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fumetto_genere_ibfk_2` FOREIGN KEY (`genere_id`) REFERENCES `genere` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.fumetto_genere: ~24 rows (circa)
INSERT INTO `fumetto_genere` (`fumetto_id`, `genere_id`) VALUES
	(1, 1),
	(8, 1),
	(9, 1),
	(1, 2),
	(17, 2),
	(18, 2),
	(20, 3),
	(23, 3),
	(11, 5),
	(19, 8),
	(3, 9),
	(4, 9),
	(5, 9),
	(6, 9),
	(7, 9),
	(10, 9),
	(12, 9),
	(14, 9),
	(15, 9),
	(16, 9),
	(2, 10),
	(21, 11),
	(22, 11),
	(13, 14);

-- Dump della struttura di tabella fumetteria.funkopop
CREATE TABLE IF NOT EXISTS `funkopop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `articolo_id` int DEFAULT NULL,
  `serie` varchar(255) DEFAULT NULL,
  `numero_edizione` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `articolo_id` (`articolo_id`),
  CONSTRAINT `funkopop_ibfk_1` FOREIGN KEY (`articolo_id`) REFERENCES `articolocollezionabile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.funkopop: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.genere
CREATE TABLE IF NOT EXISTS `genere` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.genere: ~15 rows (circa)
INSERT INTO `genere` (`id`, `nome`) VALUES
	(1, 'AZIONE'),
	(2, 'AVVENTURA'),
	(3, 'FANTASY'),
	(4, 'FANTASCIENZA'),
	(5, 'HORROR'),
	(6, 'ROMANCE'),
	(7, 'COMMEDIA'),
	(8, 'MISTERO'),
	(9, 'SUPEREROI'),
	(10, 'STORICO'),
	(11, 'SLICE OF LIFE'),
	(12, 'NOIR'),
	(13, 'SPORT'),
	(14, 'WESTERN'),
	(15, 'SURREALE');

-- Dump della struttura di tabella fumetteria.inventario
CREATE TABLE IF NOT EXISTS `inventario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `volume_id` int NOT NULL,
  `giacenza` int NOT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  `stato` enum('NUOVO','USATO') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `volume_id` (`volume_id`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`volume_id`) REFERENCES `volume` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.inventario: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.offerte
CREATE TABLE IF NOT EXISTS `offerte` (
  `id` int NOT NULL AUTO_INCREMENT,
  `inventario_id` int DEFAULT NULL,
  `percentuale_sconto` decimal(5,2) DEFAULT NULL,
  `data_inizio` date DEFAULT NULL,
  `data_fine` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `inventario_id` (`inventario_id`),
  CONSTRAINT `offerte_ibfk_1` FOREIGN KEY (`inventario_id`) REFERENCES `inventario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.offerte: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.preordine
CREATE TABLE IF NOT EXISTS `preordine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `inventario_id` int DEFAULT NULL,
  `data_preordine` date DEFAULT NULL,
  `data_disponibilita` date DEFAULT NULL,
  `stato` enum('DISPONIBILE','NON_DISPONIBILE','RILASCIATO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `inventario_id` (`inventario_id`),
  CONSTRAINT `preordine_ibfk_1` FOREIGN KEY (`inventario_id`) REFERENCES `inventario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.preordine: ~0 rows (circa)

-- Dump della struttura di tabella fumetteria.ruolo
CREATE TABLE IF NOT EXISTS `ruolo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.ruolo: ~2 rows (circa)
INSERT INTO `ruolo` (`id`, `nome`) VALUES
	(1, 'AMMINISTRATORE'),
	(2, 'CLIENTE');

-- Dump della struttura di tabella fumetteria.utente
CREATE TABLE IF NOT EXISTS `utente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `ruolo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `ruolo_id` (`ruolo_id`),
  CONSTRAINT `utente_ibfk_1` FOREIGN KEY (`ruolo_id`) REFERENCES `ruolo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.utente: ~1 rows (circa)
INSERT INTO `utente` (`id`, `username`, `password`, `nome`, `cognome`, `email`, `ruolo_id`) VALUES
	(1, 'Principito09', 'Romanomista09.', 'Alfredo', 'Valerii', 'alfredo.roma99@gmail.com', 2);

-- Dump della struttura di tabella fumetteria.volume
CREATE TABLE IF NOT EXISTS `volume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `fumetto_id` int NOT NULL,
  `data_uscita` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fumetto_id` (`fumetto_id`),
  CONSTRAINT `volume_ibfk_1` FOREIGN KEY (`fumetto_id`) REFERENCES `fumetto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=282 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.volume: ~249 rows (circa)
INSERT INTO `volume` (`id`, `numero`, `fumetto_id`, `data_uscita`) VALUES
	(1, 1, 1, '2022-09-21'),
	(2, 2, 1, '2022-10-12'),
	(3, 3, 1, '2022-11-16'),
	(4, 4, 1, '2023-01-11'),
	(16, 1, 2, '2022-07-04'),
	(17, 2, 2, '2022-08-04'),
	(18, 1, 17, '2008-02-20'),
	(19, 2, 17, '2008-03-20'),
	(20, 3, 17, '2008-04-21'),
	(21, 4, 17, '2008-05-21'),
	(22, 5, 17, '2008-06-19'),
	(23, 6, 17, '2008-07-21'),
	(24, 7, 17, '2008-08-20'),
	(25, 8, 17, '2008-09-18'),
	(26, 9, 17, '2008-10-21'),
	(27, 10, 17, '2008-11-20'),
	(28, 11, 17, '2008-12-18'),
	(29, 12, 17, '2009-01-23'),
	(30, 13, 17, '2009-02-19'),
	(31, 14, 17, '2009-03-19'),
	(32, 15, 17, '2009-04-20'),
	(33, 16, 17, '2009-05-20'),
	(34, 17, 17, '2009-06-17'),
	(35, 18, 17, '2009-07-15'),
	(36, 19, 17, '2009-08-19'),
	(37, 20, 17, '2009-09-16'),
	(38, 21, 17, '2009-10-14'),
	(39, 22, 17, '2009-11-18'),
	(40, 23, 17, '2009-12-16'),
	(41, 24, 17, '2010-01-20'),
	(42, 25, 17, '2010-02-17'),
	(43, 26, 17, '2010-03-17'),
	(44, 27, 17, '2010-04-15'),
	(45, 28, 17, '2010-05-19'),
	(46, 29, 17, '2010-06-17'),
	(47, 30, 17, '2010-07-15'),
	(48, 31, 17, '2010-08-18'),
	(49, 32, 17, '2010-09-16'),
	(50, 33, 17, '2010-10-20'),
	(51, 34, 17, '2010-11-17'),
	(52, 35, 17, '2010-12-16'),
	(53, 36, 17, '2011-01-17'),
	(54, 37, 17, '2011-02-15'),
	(55, 38, 17, '2011-03-16'),
	(56, 39, 17, '2011-04-14'),
	(57, 40, 17, '2011-05-18'),
	(58, 41, 17, '2011-06-16'),
	(59, 42, 17, '2011-07-14'),
	(60, 43, 17, '2011-08-16'),
	(61, 44, 17, '2011-09-15'),
	(62, 45, 17, '2011-10-19'),
	(63, 46, 17, '2011-11-17'),
	(64, 47, 17, '2011-12-14'),
	(65, 48, 17, '2012-01-18'),
	(66, 49, 17, '2012-03-15'),
	(67, 50, 17, '2012-05-16'),
	(68, 51, 17, '2012-07-18'),
	(69, 52, 17, '2012-09-13'),
	(70, 53, 17, '2012-11-15'),
	(71, 54, 17, '2013-01-16'),
	(72, 55, 17, '2013-03-14'),
	(73, 56, 17, '2013-05-16'),
	(74, 57, 17, '2013-07-18'),
	(75, 58, 17, '2013-09-19'),
	(76, 59, 17, '2013-11-14'),
	(77, 60, 17, '2014-02-13'),
	(78, 61, 17, '2014-05-15'),
	(79, 62, 17, '2014-08-14'),
	(80, 63, 17, '2014-10-16'),
	(81, 64, 17, '2015-01-15'),
	(82, 65, 17, '2015-04-15'),
	(83, 66, 17, '2015-07-16'),
	(84, 67, 17, '2015-10-14'),
	(85, 68, 17, '2016-01-20'),
	(86, 69, 17, '2016-04-13'),
	(87, 70, 17, '2016-07-20'),
	(88, 71, 17, '2016-10-19'),
	(89, 72, 17, '2017-01-18'),
	(90, 73, 17, '2017-04-19'),
	(91, 74, 17, '2017-08-16'),
	(92, 75, 17, '2017-10-18'),
	(93, 76, 17, '2018-03-14'),
	(94, 77, 17, '2018-07-18'),
	(95, 78, 17, '2018-09-19'),
	(96, 79, 17, '2018-12-19'),
	(97, 80, 17, '2019-03-20'),
	(98, 81, 17, '2019-07-17'),
	(99, 82, 17, '2019-10-16'),
	(100, 83, 17, '2020-01-22'),
	(101, 84, 17, '2020-05-20'),
	(102, 85, 17, '2020-08-19'),
	(103, 86, 17, '2020-11-18'),
	(104, 87, 17, '2021-02-17'),
	(105, 88, 17, '2021-05-19'),
	(106, 89, 17, '2021-08-18'),
	(107, 90, 17, '2021-10-20'),
	(108, 91, 17, '2022-01-19'),
	(109, 92, 17, '2022-03-16'),
	(110, 93, 17, '2022-05-18'),
	(111, 94, 17, '2022-07-13'),
	(112, 95, 17, '2022-09-14'),
	(113, 96, 17, '2022-12-14'),
	(114, 97, 17, '2023-02-15'),
	(115, 98, 17, '2023-04-12'),
	(116, 99, 17, '2023-06-14'),
	(117, 100, 17, '2023-09-20'),
	(118, 101, 17, '2023-11-15'),
	(119, 102, 17, '2024-02-20'),
	(120, 103, 17, '2024-05-14'),
	(121, 104, 17, '2024-09-24'),
	(122, 105, 17, '2024-11-26'),
	(123, 1, 18, '2001-02-12'),
	(124, 2, 18, '2001-03-14'),
	(125, 3, 18, '2001-05-23'),
	(126, 4, 18, '2001-07-20'),
	(127, 5, 18, '2001-09-14'),
	(128, 6, 18, '2001-11-29'),
	(129, 7, 18, '2002-01-20'),
	(130, 8, 18, '2002-03-13'),
	(131, 9, 18, '2002-05-28'),
	(132, 10, 18, '2002-07-09'),
	(133, 11, 18, '2002-09-19'),
	(134, 12, 18, '2002-11-12'),
	(135, 13, 18, '2002-12-19'),
	(136, 14, 18, '2003-01-27'),
	(137, 15, 18, '2003-03-11'),
	(138, 16, 18, '2003-05-03'),
	(139, 17, 18, '2003-07-11'),
	(140, 18, 18, '2003-09-19'),
	(141, 19, 18, '2003-11-04'),
	(142, 20, 18, '2004-01-14'),
	(143, 21, 18, '2004-03-22'),
	(144, 22, 18, '2004-05-18'),
	(145, 23, 18, '2004-07-15'),
	(146, 24, 18, '2004-09-28'),
	(147, 25, 18, '2004-11-04'),
	(148, 26, 18, '2005-01-11'),
	(149, 27, 18, '2005-03-21'),
	(150, 28, 18, '2005-05-09'),
	(151, 29, 18, '2005-07-06'),
	(152, 30, 18, '2005-09-05'),
	(153, 31, 18, '2005-11-14'),
	(154, 32, 18, '2006-01-27'),
	(155, 33, 18, '2006-03-20'),
	(156, 34, 18, '2006-05-18'),
	(157, 35, 18, '2006-07-19'),
	(158, 36, 18, '2006-09-25'),
	(159, 37, 18, '2006-11-15'),
	(160, 38, 18, '2007-01-15'),
	(161, 39, 18, '2007-03-23'),
	(162, 40, 18, '2007-06-05'),
	(163, 41, 18, '2007-08-28'),
	(164, 42, 18, '2007-10-28'),
	(165, 43, 18, '2008-01-16'),
	(166, 44, 18, '2008-04-11'),
	(167, 45, 18, '2008-05-28'),
	(168, 46, 18, '2008-09-24'),
	(169, 47, 18, '2008-11-18'),
	(170, 48, 18, '2009-01-22'),
	(171, 49, 18, '2009-03-24'),
	(172, 50, 18, '2009-07-15'),
	(173, 51, 18, '2009-09-16'),
	(174, 52, 18, '2009-11-25'),
	(175, 53, 18, '2010-01-20'),
	(176, 54, 18, '2010-04-27'),
	(177, 55, 18, '2010-08-24'),
	(178, 56, 18, '2010-10-15'),
	(179, 57, 18, '2010-12-22'),
	(180, 58, 18, '2011-01-19'),
	(181, 59, 18, '2011-03-21'),
	(182, 60, 18, '2011-05-23'),
	(183, 61, 18, '2011-09-20'),
	(184, 62, 18, '2011-11-21'),
	(185, 63, 18, '2012-02-20'),
	(186, 64, 18, '2012-04-16'),
	(187, 65, 18, '2012-07-17'),
	(188, 66, 18, '2012-09-25'),
	(189, 67, 18, '2012-11-19'),
	(190, 68, 18, '2013-01-14'),
	(191, 69, 18, '2013-03-25'),
	(192, 70, 18, '2013-05-27'),
	(193, 71, 18, '2013-09-16'),
	(194, 72, 18, '2013-11-24'),
	(195, 73, 18, '2014-01-21'),
	(196, 74, 18, '2014-03-25'),
	(197, 75, 18, '2014-06-30'),
	(198, 76, 18, '2014-10-27'),
	(199, 77, 18, '2014-12-30'),
	(200, 78, 18, '2015-03-16'),
	(201, 79, 18, '2015-07-15'),
	(202, 80, 18, '2015-09-29'),
	(203, 81, 18, '2015-11-24'),
	(204, 82, 18, '2016-01-12'),
	(205, 83, 18, '2016-03-30'),
	(206, 84, 18, '2016-07-26'),
	(207, 85, 18, '2016-09-27'),
	(208, 86, 18, '2017-02-27'),
	(209, 87, 18, '2017-07-24'),
	(210, 88, 18, '2017-11-27'),
	(211, 89, 18, '2018-05-28'),
	(212, 90, 18, '2018-10-29'),
	(213, 91, 18, '2019-01-28'),
	(214, 92, 18, '2019-05-29'),
	(215, 93, 18, '2019-09-25'),
	(216, 94, 18, '2019-11-19'),
	(217, 95, 18, '2020-01-29'),
	(218, 96, 18, '2020-07-27'),
	(219, 97, 18, '2021-03-23'),
	(220, 98, 18, '2021-09-24'),
	(221, 99, 18, '2022-03-18'),
	(222, 100, 18, '2022-03-30'),
	(223, 101, 18, '2022-06-29'),
	(224, 102, 18, '2022-10-28'),
	(225, 103, 18, '2023-01-04'),
	(226, 104, 18, '2023-04-19'),
	(227, 105, 18, '2023-08-02'),
	(228, 106, 18, '2023-11-29'),
	(229, 107, 18, '2024-04-02'),
	(230, 108, 18, '2024-08-27'),
	(231, 1, 8, '2021-05-19'),
	(232, 2, 8, '2021-05-19'),
	(233, 3, 8, '2021-07-14'),
	(234, 4, 8, '2021-09-15'),
	(235, 5, 8, '2021-11-17'),
	(236, 6, 8, '2022-02-23'),
	(237, 7, 8, '2022-05-25'),
	(238, 8, 8, '2022-07-20'),
	(239, 9, 8, '2022-09-28'),
	(240, 10, 8, '2022-11-23'),
	(241, 11, 8, '2023-01-25'),
	(242, 12, 8, '2023-04-19'),
	(243, 13, 8, '2023-06-21'),
	(244, 14, 8, '2023-08-23'),
	(245, 15, 8, '2023-12-20'),
	(246, 16, 8, '2024-02-27'),
	(247, 17, 8, '2024-06-18'),
	(248, 18, 8, '2024-09-03'),
	(249, 19, 8, '2024-10-29'),
	(250, 1, 6, '2021-06-23'),
	(251, 2, 6, '2021-10-25'),
	(252, 3, 6, '2022-02-28'),
	(253, 4, 6, '2022-04-19'),
	(254, 5, 6, '2022-06-28'),
	(255, 6, 6, '2022-09-27'),
	(256, 7, 6, '2023-01-24'),
	(257, 8, 6, '2023-03-28'),
	(258, 9, 6, '2023-05-24'),
	(259, 10, 6, '2023-07-25'),
	(260, 11, 6, '2023-09-26'),
	(261, 1, 14, '2014-12-10'),
	(262, 2, 14, '2015-03-12'),
	(263, 3, 14, '2015-06-17'),
	(264, 4, 14, '2015-09-23'),
	(265, 5, 14, '2015-12-23'),
	(266, 6, 14, '2016-04-27'),
	(267, 7, 14, '2016-06-24'),
	(268, 8, 14, '2016-11-24'),
	(269, 1, 19, '2021-05-26'),
	(270, 2, 19, '2021-08-25'),
	(271, 3, 19, '2021-12-21'),
	(272, 4, 19, '2022-04-18'),
	(273, 5, 19, '2022-08-25'),
	(274, 6, 19, '2022-11-17'),
	(275, 7, 19, '2023-03-14'),
	(276, 8, 19, '2023-07-04'),
	(277, 9, 19, '2023-10-03'),
	(278, 10, 19, '2023-11-28'),
	(279, 11, 19, '2024-01-30'),
	(280, 12, 19, '2024-03-25'),
	(281, 13, 19, '2024-06-25');

-- Dump della struttura di tabella fumetteria.voto
CREATE TABLE IF NOT EXISTS `voto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utente_id` int DEFAULT NULL,
  `tipo_entita` varchar(50) DEFAULT NULL,
  `entita_id` int DEFAULT NULL,
  `voto` int DEFAULT NULL,
  `data_voto` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `utente_id` (`utente_id`,`tipo_entita`,`entita_id`),
  CONSTRAINT `voto_ibfk_1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella fumetteria.voto: ~0 rows (circa)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
