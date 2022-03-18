CREATE TABLE climbing_rock
(
    location varchar(255) NOT NULL,
    difficulty varchar(255),
    bolting varchar(255),
    PRIMARY KEY (location)
);

INSERT INTO climbing_rock (location, difficulty, bolting) VALUES
                                                              ('48.68984755044936, 8.362811253038053','EASY', 'VERY_GOOD');