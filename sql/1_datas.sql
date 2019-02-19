--
-- Déchargement des données de la table race_cheval
--

INSERT INTO RACE_CHEVAL (ID, LIBELLE, DESCRIPTION, DELETED) VALUES
(1, 'Arabo-frison', 'L’Arabo-frison est une race chevaline récente, sélectionnée sur plusieurs générations depuis les années 1960 pour obtenir la morphologie du Frison moderne associée aux qualités d\'endurance du Pur-sang arabe.', 0),
(2, 'Lombok', 'Le Lombok (indonésien : Kuda lombok), est la race de poneys présente sur l\'île de Lombok, en Indonésie.', 0),
(3, 'Halla ', 'Le Halla est une race de chevaux de course originaire de Corée du Sud.', 0);

--
-- Déchargement des données de la table pays
--

INSERT INTO PAYS (ID, LIBELLE, DELETED) VALUES
(1, 'Angleterre', 0),
(2, 'France', 0);

--
-- Déchargement des données de la table lieu
--

INSERT INTO LIEU (ID, ville, nb_Boxes, commentaire, DELETED) VALUES
(1, 'Caen', 5, 'Hippodrome de caen', 0),
(2, 'Vire', 10, 'Hippodrome de vire', 0);

--
-- Déchargement des données de la table compte
--

INSERT INTO COMPTE (ID, LOGIN, MDP, ID_ROLE, DELETED) VALUES
(1, 'cdeltour', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', NULL, 0),
(2, 'nfime', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', NULL, 0);
--
-- Déchargement des données de la table categ_vente
--

INSERT INTO CATEG_VENTE (ID, LIBELLE, DELETED) VALUES
(1, 'Vente d\'automne', 0),
(2, 'Vente d\'élevage', 0),
(3, 'Vente d\'été', 0),
(4, 'Vente mixte de février', 0);
--
-- Déchargement des données de la table utilisateur
--

INSERT INTO UTILISATEUR (ID, NOM, PRENOM, RUE, COPOS, VILLE, MAIL, ID_PAYS, ID_COMPTE, DELETED) VALUES
(1, 'Deltour', 'Charles', '4 rue du Pont', '14680', 'Bretteville Sur Laize', 'cdeltour@hotmail.com', NULL, 1, 0),
(2, 'Fime', 'Nadia', '5 rue du Montparnasse', '14220', 'Boulon', '', NULL, 2, 0),
(3, 'Ertau', 'Frank', '4 Avenue du président Wilson', '14190', 'Urville', 'frank.ertau@laposte.net', NULL, NULL, 0),
(4, 'Maneur', 'David', '6 rue Charles Péguy', '14220', 'Mutrécy', '', NULL, NULL, 0),
(5, 'Berezovski', 'Sylvie', '18 rue du Château', '14680', 'Barbery', '', NULL, NULL, 0),
(6, 'Finley', 'Pascale', '25 rue de Tolbiac', '14680', 'Caillouet', 'pascfinley@yahoo.fr', NULL, NULL, 0),
(7, 'Vofur', 'Hector', '18 rue Deparcieux', '14190', 'Cauvicourt', 'hvofur@free.fr', NULL, NULL, 0),
(8, 'Derzou', 'Fred', '230 avenue de la libert', '14220', 'Espins', 'ouzala@aol.com', NULL, NULL, 0),
(9, 'Serty', 'Julie', '23 rue du Calvaire', '14220', 'Fresney le Vieux', '', NULL, NULL, 0),
(10, 'Vofur', 'Victor', '18 rue Deparcieux', '14680', 'Bretteville Sur Laize', 'victor.vofur@laposte.net', NULL, NULL, 0),
(11, 'Calende', 'Hugo', '22 rue des jardins', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(12, 'Jemba', 'Hubert', '10 rue du 8 mai 1945', '14680', 'Bretteville Sur Laize', 'jaimeba@yahoo.fr', NULL, NULL, 0),
(13, 'Morin', 'Séverine', '4 rue du bac', '93000', 'Paris', 'morinsev@hotmail.com', NULL, NULL, 0),
(14, 'Benrech', 'Tarek', '79 rue de Caen', '14320', 'May Sur Orne', '', NULL, NULL, 0),
(15, 'Nguyen', 'Marc', '53 impasse Tourneur', '14320', 'Fontenay Le Marmion', 'nguyen774@wanadoo.fr', NULL, NULL, 0),
(16, 'Louali', 'Karima', '89 avenue Poincar', '14320', 'Saint Martin de Fontenay', 'kloua@caramail.fr', NULL, NULL, 0),
(17, 'Paolo', 'Marco', '14 rue du Caire', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(18, 'Map', 'Joanna', '120 boulevard Voltaire', '75012', 'Paris', '', NULL, NULL, 0),
(19, 'Kound', 'Fatoumata', '4 Place Carr', '14190', 'Urville', '', NULL, NULL, 0),
(20, 'Derissam', 'Bachir', '1 rue des Indes', '14190', 'Urville', '', NULL, NULL, 0),
(21, 'Villechalane', 'Louis', '8 rue des Charmes', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(22, 'Andre', 'David', '1 rue Petit', '14220', 'Boulon', '', NULL, NULL, 0),
(23, 'Bedos', 'Christian', '1 rue Peranud', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(24, 'Tusseau', 'Louis', '22 rue des Ternes', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(25, 'Bentot', 'Pascal', '11 allée des Cerises', '14220', 'Boulon', '', NULL, NULL, 0),
(26, 'Bioret', 'Luc', '1 Avenue gambetta', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(27, 'Bunisset', 'Francis', '10 rue des Perles', '14220', 'Espins', '', NULL, NULL, 0),
(28, 'Bunisset', 'Denise', '23 rue Manin', '14320', 'Saint Martin de Fontenay', '', NULL, NULL, 0),
(29, 'Cacheux', 'Bernard', '114 rue Blanche', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(30, 'Cadic', 'Eric', '123 avenue de la République', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(31, 'Charoze', 'Catherine', '100 rue Petit', '14220', 'Boulon', '', NULL, NULL, 0),
(32, 'Clepkens', 'Christophe', '12 allée des Anges', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(33, 'Cottin', 'Vincenne', '36 rue Des Roches', '14220', 'Boulon', '', NULL, NULL, 0),
(34, 'Daburon', 'François', '13 rue de Chanzy', '14220', 'Mutrécy', '', NULL, NULL, 0),
(35, 'De', 'Philippe', '13 rue Barthes', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(36, 'Debelle', 'Michel', '181 avenue Barbusse', '14220', 'Espins', '', NULL, NULL, 0),
(37, 'Debelle', 'Jeanne', '134 allée des Joncs', '14320', 'Saint Martin de Fontenay', '', NULL, NULL, 0),
(38, 'Debroise', 'Michel', '2 Bld Jourdain', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(39, 'Desmarquest', 'Nathalie', '14 Place d Arc', '14220', 'Boulon', '', NULL, NULL, 0),
(40, 'Desnost', 'Pierre', '16 avenue des Cèdres', '14220', 'Mutrécy', '', NULL, NULL, 0),
(41, 'Dudouit', 'Frédéric', '18 rue de l église', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(42, 'Duncombe', 'Claude', '19 rue de la tour', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(43, 'Enault-Pascreau', 'Céline', '25 place de la gare', '14680', 'Bretteville Sur Laize', '', NULL, NULL, 0),
(44, 'Eynde', 'Valérie', '3 Grand Place', '14220', 'Mutrécy', '', NULL, NULL, 0),
(45, 'Finck', 'Jacques', '10 avenue du Prado', '14320', 'Fontenay Le Marmion', '', NULL, NULL, 0),
(46, 'Frémont', 'Fernande', '4 route de la mer', '14220', 'Espins', '', NULL, NULL, 0),
(47, 'Gest', 'Alain', '30 avenue des terres', '14320', 'Saint Martin de Fontenay', '', NULL, NULL, 0);

--
-- Déchargement des données de la table client
--

INSERT INTO CLIENT (ID_UTILISATEUR) VALUES
(1),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38),
(39),
(40),
(41),
(42),
(43),
(44),
(45),
(46),
(47);

--
-- Déchargement des données de la table vente
--

INSERT INTO VENTE (ID, NOM, DATE_DEBUT, ID_CATEG_VENTE, ID_LIEU, DATE_FIN, DATE_VENTE, DELETED) VALUES
(1, 'Garibaldi Princess', '2017-03-09 00:00:00', 1, 1, NULL, NULL, 0),
(2, 'Mixing brain', '2017-09-02 00:00:00', 2, 1, NULL, NULL, 0),
(3, 'Rapsberry Sailing', '2017-07-17 00:00:00', 1, 2, NULL, NULL, 0),
(4, 'Jelly Bay', '2017-08-17 00:00:00', 3, 2, NULL, NULL, 0),
(5, 'Djezair Star', '2017-02-25 00:00:00', 4, 1, NULL, NULL, 0);

--
-- Déchargement des données de la table cheval
--

INSERT INTO CHEVAL (ID, NOM, SEXE, SIRE, ID_RACE_CHEVAL, ID_MERE, ID_PERE, ID_CLIENT, DELETED) VALUES
(7, 'Orlando', 'M', '1679879463', 3, NULL, NULL, 3, 0),
(8, 'Kanelle', 'F', '0346798543', 3, NULL, NULL, 5, 0),
(9, 'Colorado', 'M', '1346798524', 2, NULL, 9, 1, 0),
(6, 'Phoenix', 'F', '0346797643', 1, 8, NULL, 1, 0),
(10, 'Coquelicot', 'M', '1243768956', 2, 8, NULL, 5, 0);

--
-- Déchargement des données de la table client_categ_vente
--

INSERT INTO CLIENT_CATEG_VENTE (ID, ID_CLIENT, ID_CATEG_VENTE, DELETED) VALUES
(23, 6, 1, 0),
(24, 37, 1, 0),
(25, 1, 2, 0),
(26, 1, 3, 0),
(27, 3, 3, 0),
(28, 6, 3, 0),
(29, 7, 3, 0),
(30, 16, 3, 0),
(31, 41, 3, 0),
(32, 35, 3, 0),
(33, 6, 4, 0);

--
-- Déchargement des données de la table courriel
--

INSERT INTO COURRIEL (ID, DATE_ENVOI, OBJET, CORPS, ID_VENTE, DELETED) VALUES
(1, '2018-09-25 00:00:00', 'Vente Raspberry Sailling', 'Bonjour,\r\n\r\nVous trouverez ci joint les différents éléments de la vente.\r\n\r\nCordialement.', 3, 0),
(2, '2018-09-04 00:00:00', 'Vente Djezair Star', 'Bonjour,\r\n\r\nVous trouverez ci joint les différents éléments de la vente Djezair Star.\r\n\r\nCordialement.', 5, 0),
(3, '2018-09-13 00:00:00', 'Vente chevaux Djezair Star complément', 'Bonjour,\r\n\r\nVous trouverez ci joint des élément supplémentaire concernant la vente.\r\n\r\nCordialement.', 5, 0),
(4, '2018-09-12 00:00:00', 'Vente de Jelly Bay', 'Bonjour,\r\n\r\nVous trouverez ci joint des élément concernant la vente à Jelly Bay.\r\n\r\nCordialement.', 4, 0);

--
-- Déchargement des données de la table directeur_general
--

INSERT INTO DIRECTEUR_GENERAL (ID_UTILISATEUR) VALUES
(2);

--
-- Déchargement des données de la table lot
--

INSERT INTO LOT (ID, ID_CHEVAL, ID_VENTE, PRIX_DEPART, VALIDATION, DELETED) VALUES
(1, 6, 3, '10.00', NULL, 0),
(2, 7, 1, '20.00', NULL, 0),
(3, 8, 5, '30.00', NULL, 0),
(4, 9, 2, '40.00', NULL, 0),
(5, 10, 3, '50.00', NULL, 0),
(6, 6, 4, '60.00', NULL, 0),
(7, 7, 2, '70.00', NULL, 0),
(8, 8, 5, '80.00', NULL, 0),
(9, 9, 2, '90.00', NULL, 0),
(10, 10, 3, '100.00', NULL, 0);

--
-- Déchargement des données de la table piece_jointe
--

INSERT INTO PIECE_JOINTE (ID, CHEMIN, DESCRIPTION) VALUES
(1, 'http://www.animauxdico.com/img/charte_graphique/cheval.jpg', 'Cheval n°1 en vente'),
(2, 'http://ecoles.ac-rouen.fr/butot_venesville/cheval2.jpg', 'Cheval n°2 en vente'),
(3, 'http://photoemescontesetlegendes.fond-ecran-image.com/blog-photo/files/2009/03/cheval-bai-criniere-noire58.jpg', 'Cheval n°1 en vente'),
(4, 'http://pascalinette971.p.a.pic.centerblog.net/ylmm815i.jpg', 'Cheval n°1 en vente');

--
-- Déchargement des données de la table joint
--

INSERT INTO JOINT (ID, ID_COURRIEL, ID_PIECE_JOINTE) VALUES
(1, 2, 1),
(2, 2, 2),
(3, 3, 3),
(4, 1, 4);
