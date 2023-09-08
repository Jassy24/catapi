package csc340.dogapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DogapiApplication {

public static void main(String[] args) {
	SpringApplication.run(DogapiApplication.class, args);
        catapi();
        System.exit(0);
    }
        
    public static void catapi() {
        try {
            String url = "https://catfact.ninja/fact";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonPrice = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonPrice);

            String fact = root.findValue("fact").asText();

            System.out.println("Fact: " + fact);

        } catch (JsonProcessingException ex) {
            System.out.println("error in cat fact");
        }
    }
}
