package myJson;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonTestMethod {
	public static void main(String[] args) {

		String jsonSource = "{ \"title\": \"code from scratch\"}";
		try {
			JsonNode node = Json.parse(jsonSource);
			System.out.println(node.get("title").asText());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
