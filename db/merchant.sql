
CREATE TABLE merchant(
    mer_id VARCHAR(255) PRIMARY KEY,
    car_info_id  VARCHAR(255),
    mer_name VARCHAR(255),
    user_id VARCHAR(255),
    -- CONSTRAINT FK_MerchantUserId FOREIGN KEY (userId) REFERENCES users(userId),
    -- CONSTRAINT FK_MerchantCarInfoId FOREIGN KEY (carInfoId) REFERENCES carinfo(carInfoId)
);