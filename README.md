# Запуск

* Запустить кафку
```shell
docker-compose up
```
* Запустить бд для консумера
```shell
docker run --name t1 -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=metrics -d postgres:11-alpine
```
Перейти в папку consumer и запустить приложение.
Перейти в папку producer и запустить приложение.

## Примеры запросов

 ```shell
curl -i -X POST http://localhost:8080/metrics
```
  ```shell
curl -i -X GET http://localhost:8081/metrics
```

 ```shell
curl -i -X GET http://localhost:8081/metrics/jvm.threads.peak
```
### Kafka ui на http://localhost:8090/

в тз про тесты ничего не было