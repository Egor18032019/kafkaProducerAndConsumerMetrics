Producer для отправки метрик, Consumer для их обработки и анализа, а также REST API для просмотра метрик.

Общая архитектура системы:

Producer Service:

Создать микросервис "Metrics Producer", 
который будет отслеживать и собирать метрики работы приложения и отправлять их в Kafka топик "metrics-topic".

Реализовать следующие API для взаимодействия с микросервисом:

POST /metrics: Отправка метрик работы приложения в формате JSON. 
Метрики могут включать информацию о производительности, использовании ресурсов, ошибках и т. д.