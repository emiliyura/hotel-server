# Инструкция по тестированию API через Postman

## Регистрация пользователя
1. Откройте Postman
2. Создайте новый POST запрос
3. URL: http://localhost:8080/api/auth/register
4. В разделе Body выберите raw и JSON
5. Введите JSON:
{
    "username": "testuser",
    "password": "password123",
    "email": "test@example.com"
}
6. Нажмите Send
7. Ожидаемый результат: 200 OK с данными созданного пользователя

## Авторизация пользователя
1. Создайте новый POST запрос
2. URL: http://localhost:8080/api/auth/login
3. В разделе Body выберите raw и JSON
4. Введите JSON:
{
    "username": "testuser",
    "password": "password123"
}
5. Нажмите Send
6. Ожидаемый результат: 200 OK с данными авторизованного пользователя

## Возможные ошибки:
- 400 Bad Request: Неверный формат данных
- 409 Conflict: Пользователь уже существует (при регистрации)
- 401 Unauthorized: Неверные учетные данные (при входе) 