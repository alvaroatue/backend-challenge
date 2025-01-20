create database backend_challenge;
use backend_challenge;

-- Insert sample users
INSERT INTO users (username, password, email, name, last_Name) VALUES
('user1', '$2a$10$7QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8', 'user1@example.com', 'User', 'One'),
('user2', '$2a$10$7QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8QJ8', 'user2@example.com', 'User', 'Two');
-- Insert sample plants
INSERT INTO plants (name, country) VALUES
('Plant A', 'Country A'),
('Plant B', 'Country B');
-- Insert sample readings
INSERT INTO readings (plant_id, timestamp, temperature, pressure, wing_Speed, energy_Level, tension, carbon_Monoxide, other_Gases) VALUES
(1, '2023-10-01 10:00:00', 25.0, 1013.0, 5.0, 80.0, 220.0, 0.1, 0.05),
(2, '2023-10-01 11:00:00', 26.0, 1012.0, 6.0, 85.0, 221.0, 0.2, 0.06);
-- Insert sample alerts
INSERT INTO alerts (plant_id, timestamp, message, type) VALUES
(1, '2023-10-01 10:30:00', 'High temperature detected', 'TEMPERATURE'),
(2, '2023-10-01 11:30:00', 'Low pressure detected', 'PRESSURE');
select * from readings;
select * from plants;

INSERT INTO readings (plant_id, timestamp, temperature, pressure, wing_speed, energy_level, tension, carbon_monoxide, other_gases, sensor_status) VALUES
(6, '2023-10-01 10:00:00', 25.0, 1013.0, 5.0, 80.0, 220.0, 0.1, 0.05, 'ENABLED'),
(7, '2023-10-01 10:30:00', 26.0, 1014.0, 5.5, 82.0, 221.0, 0.12, 0.06,  'ENABLED'),
(8, '2023-10-01 11:00:00', 26.0, 1012.0, 6.0, 85.0, 221.0, 0.2, 0.06,'ENABLED'),
(9, '2023-10-01 11:30:00', 27.0, 1011.0, 6.5, 86.0, 222.0, 0.22, 0.07, 'DISABLED');
