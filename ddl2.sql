-- Table to store Personagem
CREATE TABLE Personagem (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    vida INTEGER NOT NULL
);

-- Table to store Equipamentos
CREATE TABLE Equipamento (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    tipo TEXT NOT NULL  -- Add any additional attributes as necessary
);

-- Join table to associate Personagem with Equipamentos
CREATE TABLE Personagem_Equipamento (
    personagem_id INTEGER,
    equipamento_id INTEGER,
    PRIMARY KEY (personagem_id, equipamento_id),
    FOREIGN KEY (personagem_id) REFERENCES Personagem(id) ON DELETE CASCADE,
    FOREIGN KEY (equipamento_id) REFERENCES Equipamento(id) ON DELETE CASCADE
);