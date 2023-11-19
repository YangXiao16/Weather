package com.example.weather3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Weather3Application {

    public static void main(String[] args) {
        SpringApplication.run(Weather3Application.class, args);
    }

    @RestController
    class WeatherController {
        @GetMapping("/weather/{city}")
        public String getWeather(@PathVariable String city) {
            String url = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName?theCityName=" + city;
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            return response;
        }
    }

}
