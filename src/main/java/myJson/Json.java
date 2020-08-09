package myJson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json {

	private static ObjectMapper objectMapper = getObjectMapper();

	private static ObjectMapper getObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		defaultObjectMapper.registerModule(new JavaTimeModule());
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultObjectMapper;
	}

	public static JsonNode parse(String src) throws IOException {

		return objectMapper.readTree(src);

	}

	public static <T> T fromJson(JsonNode node, Class<T> classObj) throws JsonProcessingException {
		return objectMapper.treeToValue(node, classObj);
	}

	public static JsonNode toJson(Object obj) {
		return objectMapper.valueToTree(obj);
	}

	public static String convertString(JsonNode node) throws JsonProcessingException {
		//ObjectWriter objWriter = objectMapper.writer();
		//return objWriter.writeValueAsString(node);
		return generateString(node, false);
	}

	public static String prttyLook(JsonNode node) throws JsonProcessingException {
//		ObjectWriter objWriter = objectMapper.writer();
//		objWriter = objWriter.with(SerializationFeature.INDENT_OUTPUT);
//		return objWriter.writeValueAsString(node);
		return generateString(node, true); 
	}

	private static String generateString(JsonNode node,boolean pretty) throws JsonProcessingException {
		ObjectWriter objWriter = objectMapper.writer();
		if (pretty) {
			objWriter = objWriter.with(SerializationFeature.INDENT_OUTPUT);
		}
		
		return objWriter.writeValueAsString(node);
	}
}