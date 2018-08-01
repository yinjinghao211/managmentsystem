CREATE TABLE cars(
    carId VARCHAR(32) PRIMARY KEY,
    carName VARCHAR(255),
    carNumber VARCHAR(255) NOT NULL,
    carType VARCHAR(32),
    userId VARCHAR(32),
    -- CONSTRAINT FK_UserId FOREIGN KEY (userId) REFERENCES Users(userId)
);