--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `stock`, `category`, `provider`, `handle`) VALUES
(1, 'Porsche Cayenne', 40670, 'trop beau mash mash ++', 1, 1, 2, NULL),
(2, 'Audi RS9', 100345, 'superbe voiture qui claque sa mère', 5, 1, 2, NULL),
(3, 'Audi TT', 30201, 'bof', 10, 2, 1, NULL),
(4, 'Audi A7', 60678, 'carre comme le nord de la Coré', 6, 1, 1, NULL),
(5, 'Audi A1', 20678, 'pas mal', 2, 1, 1, NULL);



--
-- Déchargement des données de la table `provider`
--

INSERT INTO `provider` (`id`, `denomination`, `siret`, `address`, `first_name`, `last_name`) VALUES
(1, 'Audi', 'SHDGH35437JK', '56 rue des pommes', 'Jean', 'Bite'),
(2, 'Porsche', '19732HJUY8', '2 chemin des lol', 'Jerome', 'Lamp'),
(4, 'azdazd', '1231', 'azded', 'azdazd', 'zedzed'),
(5, 'ezef', '1234', 'zefzefze', 'zefzef', 'zedzed'),
(6, 'ezef', '1234', 'zefzefze', 'zefzef', 'zedzed'),
(7, 'ezef', '1234', 'zefzefze', 'zefzef', 'zedzed');

