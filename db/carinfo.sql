CREATE TABLE carinfo(
    car_info_id VARCHAR(255),
    car_charge VARCHAR(255),
    car_id VARCHAR(255),
    car_modify_time VARCHAR(255),
    car_reason VARCHAR(255),
    end_time VARCHAR(255),
    in_time VARCHAR(255),
    origin_time VARCHAR(255),
    out_time VARCHAR(255),
    parking_security VARCHAR(255),
    parking_time VARCHAR(255),
    pay_mode VARCHAR(255),
    toll_collector VARCHAR(255),
    travel_record VARCHAR(255),
    PRIMARY KEY(car_info_id),
    -- 考虑到使用外键会降低性能，数据库完整性就用事务来保持，此项目中采用逻辑外键
    -- CONSTRAINT FK_CarId FOREIGN KEY (carId) REFERENCES cars(carId)
);