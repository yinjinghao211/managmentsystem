CREATE TABLE management(
    manage_id VARCHAR(255) PRIMARY KEY,
    car_info_id VARCHAR(255),
    charge_type VARCHAR(255),
    money VARCHAR(255),
    toll_collector VARCHAR(255),
    total_time VARCHAR(255),
    user_id VARCHAR(255),
    -- CONSTRAINT FK_ManageUserId FOREIGN KEY (userId) REFERENCES users(userId),
    -- CONSTRAINT FK_CarInfoId FOREIGN KEY (carInfoId) REFERENCES carinfo(carInfoId)
);