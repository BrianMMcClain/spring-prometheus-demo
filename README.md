spring-prometheus-demo
===

This is a simple example of how you can export both custom and default Spring Boot Actuator metrics in a way that Prometheus can scrape and gather.

The application can be ran with:

`./mvnw spring-boot:run`

And the Prometheus metrics are available at http://localhost:8080/actuator/prometheus

This demo also uses a custom counter to track visits named `visit_counter_total`. This is increased every time a GET request is made to `/`.