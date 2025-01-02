-- Insertar datos en la tabla Users
INSERT INTO Users (password, email, name, last_name, is_active) VALUES
('password123', 'user1@example.com', 'John', 'Doe', true),
('password456', 'user2@example.com', 'Jane', 'Smith', true);

-- Insertar datos en la tabla Plants
INSERT INTO Plants (name, country) VALUES
('Plant A', 'USA'),
('Plant B', 'Canada'),
('Plant C', 'Germany');

-- Insertar datos en la tabla Readings
INSERT INTO Readings (plant_id, timestamp, temperature, pressure, wing_speed, energy_level, tension, carbon_monoxide, other_gases) VALUES
(1, '2025-01-01 10:00:00', 25.3, 1.2, 12.3, 90.5, 220.1, 0.03, 0.02),
(2, '2025-01-01 10:05:00', 24.8, 1.0, 10.8, 85.0, 215.0, 0.02, 0.01),
(3, '2025-01-01 10:10:00', 26.0, 1.5, 13.5, 92.0, 230.0, 0.04, 0.03);

-- Insertar datos en la tabla Alerts
INSERT INTO Alerts (plant_id, timestamp, message, type) VALUES
(1, '2025-01-01 11:00:00', 'High temperature alert', 'TEMPERATURE'),
(2, '2025-01-01 11:15:00', 'Pressure drop detected', 'PRESSURE'),
(3, '2025-01-01 11:30:00', 'Wind speed anomaly', 'WIND_SPEED');

-- Insertar relación entre Users y Plants
INSERT INTO user_plants (user_id, plant_id) VALUES
(1, 1),
(1, 2),
(2, 3);
