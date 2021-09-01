# evo-test-task

#### Для инициализации БД надо запустить скрипт `init_db.sql`

#### Запуск сервиса
`gradle bootRun`

#### Примеры запросов
Создание пользователя:

`curl -XPOST localhost:8080 -d '{"type":"CREATE", "login":"evo-user", "password":"supersecret"}' -H 'content-type: application/json;charset=utf-8'`

Запрос баланса:

`curl -XPOST localhost:8080 -d '{"type":"GET_BALANCE", "login":"Admin", "password":"12345"}' -H 'content-type: application/json;charset=utf-8'`

WEB-сервис может быть развернут в кластере на нескольких машинах, так как
балансировку трафика обеспечат администраторы через NGINX, а данные хранятся в единой БД,
куда будут ходить инстансы поднятых нод сервиса.