-- SQLite
-- Create a table for Characters
CREATE TABLE Characters (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    health INTEGER NOT NULL,
    attack_power INTEGER NOT NULL,
    defense_power INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create a table for Duels
CREATE TABLE Duels (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    character_one_id INTEGER,
    character_two_id INTEGER,
    duel_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    winner_id INTEGER,
    FOREIGN KEY (character_one_id) REFERENCES Characters(id),
    FOREIGN KEY (character_two_id) REFERENCES Characters(id),
    FOREIGN KEY (winner_id) REFERENCES Characters(id)
);

-- Create a table for Duel Results
CREATE TABLE DuelResults (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    duel_id INTEGER,
    character_id INTEGER,
    damage_dealt INTEGER,
    was_defeated BOOLEAN,
    FOREIGN KEY (duel_id) REFERENCES Duels(id),
    FOREIGN KEY (character_id) REFERENCES Characters(id)
);