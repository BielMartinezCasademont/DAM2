CREATE DATABASE IF NOT EXISTS DAM2;

CREATE TABLE Professors (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nom VARCHAR(100) NOT NULL,
                            cognoms VARCHAR(150) NOT NULL
);

INSERT INTO Professors (nom, cognoms) VALUES
                                          ('Anna', 'Garcia Martinez'),
                                          ('Pau', 'Sanchez Lopez'),
                                          ('Marta', 'Ramon Puig');

CREATE TABLE ModulsProfessionals (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     nom VARCHAR(150) NOT NULL,
                                     id_professor INT,
                                     CONSTRAINT fk_modul_professor FOREIGN KEY (id_professor) REFERENCES Professors(id) ON DELETE SET NULL
);

INSERT INTO ModulsProfessionals (nom, id_professor) VALUES
                                                        ('Desenvolupament Web', 1),
                                                        ('Bases de Dades', 2),
                                                        ('Sistemes Informàtics', 3);
