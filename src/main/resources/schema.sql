-- Удаление таблицы отелей, если она существует
DROP TABLE IF EXISTS hotels; 

-- Создание таблицы отелей
CREATE TABLE IF NOT EXISTS hotels (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price_per_night DECIMAL(10,2) NOT NULL,
    total_rooms INTEGER NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
); 