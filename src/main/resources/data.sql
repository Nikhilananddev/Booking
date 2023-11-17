-- Create the vehicles table if it doesn't exist
CREATE TABLE IF NOT EXISTS vehicles (
    id SERIAL PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    wheel_count INT NOT NULL,
    model VARCHAR(255),
    category VARCHAR(255)
);

-- Insert dummy data into the vehicles table

-- Insert a car with 4 wheels
INSERT INTO vehicles (type, wheel_count, model, category) VALUES
('Car', 4, 'BMW', 'Sedan');

-- Insert a bike with 2 wheels
INSERT INTO vehicles (type, wheel_count, model, category) VALUES
('Bike', 2, 'Pulsure', 'Sporty');

-- Insert another bike with 2 wheels
INSERT INTO vehicles (type, wheel_count, model, category) VALUES
('Bike', 2, 'Ferrari', 'Cruiser');

-- Insert another car with 4 wheels
INSERT INTO vehicles (type, wheel_count, model, category) VALUES
('Car', 4, 'X700', 'SUV');


INSERT INTO vehicles (type, wheel_count, model, category) VALUES
('Car', 4, 'Ferrari 200', 'Sporty');


INSERT INTO vehicles (type, wheel_count, model, category) VALUES
('Car', 4, 'Ferrari 400', 'Sporty');

