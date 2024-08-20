
INSERT INTO client (name) VALUES ('Obi Van'), ('Ja Ja Bins'), ('Kwaigon Jin'), ('General Grivus'), ('Queen Amidala'),
('Palpatin'), ('Master Yoda'), ('Asoka Tano'), ('Lord Duku'), ('Mira Jade');

INSERT INTO planet (id, name) VALUES ('X1', 'Melmak'), ('R2D2', 'Korusant'), ('OPTIMUS1', 'Cyberthron'),
('BABYLON5', 'Minbar'), ('SECTORCAPRULU','Tarsonis');

INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id) VALUES
('2009-06-04 18:25:08', 1, 'Melmak', 'Korusant'),
('2012-06-04 19:25:08', 2, 'Cyberthron', 'Korusant'),
('2013-07-05 20:25:08', 3, 'Melmak', 'Cyberthron'),
('2009-07-05 21:25:08', 4, 'Melmak', 'Melmak'),
('2020-04-01 10:25:08', 5, 'Tarsonis', 'Korusant'),
('2011-08-09 23:25:08', 6, 'Korusant', 'Melmak'),
('2006-06-06 00:25:08', 7, 'Cyberthron', 'Korusant'),
('2005-05-05 04:25:08', 8, 'Minbar', 'Korusant'),
('2009-08-12 05:25:08', 9, 'Minbar', 'Melmak'),
('2019-06-04 15:25:08', 10, 'Melmak', 'Tarsonis');