package myJson;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import pojo.AuthorPOJO;
import pojo.BookPOJO;
import pojo.DayPOJO;
import pojo.SimpleTestCasePOJO;

class JsonTestMethodTest {
	private String simpleTestCasejsonSource = "{ \n" + 
			"	\"title\": \"code from scratch\",\n" + 
			"	\"author\":\"akmal\"\n" + 
			"}";
	
	private String dayScenario="{\n" + 
			"	\"date\": \"2020-07-31\",\n" + 
			"	\"name\": \"Eid day\"\n" + 
			"}";
	
	private String authorBooks="{\n" + 
			"	\"authorName\": \"Akmal\",\n" + 
			"	\"books\": [\n" + 
			"		{\n" + 
			"			\"bookName\": \"Selenium with java\",\n" + 
			"			\"title\": \"Beginner Java2\",\n" + 
			"			\"inPrint\": \"true\",\n" + 
			"			\"publishDate\": \"2020-07-15\"\n" + 
			"		},\n" + 
			"		{\n" + 
			"			\"bookName\": \"Selenium with C#\",\n" + 
			"			\"title\": \" Beginner C#\",\n" + 
			"			\"inPrint\": \"true\",\n" + 
			"			\"publishDate\": \"2020-07-16\"\n" + 
			"		},\n" + 
			"		{\n" + 
			"			\"bookName\": \"Selenium with Python\",\n" + 
			"			\"title\": \"Beginner Python\",\n" + 
			"			\"inPrint\": \"false\",\n" + 
			"			\"publishDate\": \"2020-07-17\"\n" + 
			"		}\n" + 
			"	]\n" + 
			"}";

	
	 @Test
	void paser() throws IOException {
		JsonNode node = Json.parse(simpleTestCasejsonSource);

		assertEquals(node.get("title").asText(), "code from scratch");
		System.out.println(node.get("title").asText());
	}

	@Test
	void fromTheJson() throws IOException {
		JsonNode node = Json.parse(simpleTestCasejsonSource);
		SimpleTestCasePOJO pojo = Json.fromJson(node, SimpleTestCasePOJO.class);
		assertEquals(pojo.getTitle(), "code from scratch");
	}
	@Test
	void toJson() {
		SimpleTestCasePOJO pojo=new SimpleTestCasePOJO();
		pojo.setTitle("Testing123");
		JsonNode node=Json.toJson(pojo);
		assertEquals(node.get("title").asText(), "Testing123");
	}
	@Test
	void convertString() throws JsonProcessingException {
		SimpleTestCasePOJO pojo=new SimpleTestCasePOJO();
		pojo.setTitle("Testing123");
		JsonNode node=Json.toJson(pojo);
		
		System.out.println(Json.convertString(node));
		System.out.println(Json.prttyLook(node));
		
	}
	@Test
	void dayTest() throws IOException {
		JsonNode node = Json.parse(dayScenario);
		DayPOJO pojo = Json.fromJson(node, DayPOJO.class);
		System.out.println("Date :"+pojo.getDate());
		assertEquals("2020-07-31",pojo.getDate().toString());
	}
	@Test
	void authorBooksTest() throws IOException {
		JsonNode node = Json.parse(authorBooks);
		AuthorPOJO pojo = Json.fromJson(node, AuthorPOJO.class);
		System.out.println("Author Name :"+pojo.getAuthorName());
		
		for(BookPOJO bp : pojo.getBooks()) {
			System.out.println("Books Name :"+bp.getBookName());
			System.out.println("Books Title :"+bp.getTitle());
			System.out.println("Is in print :"+bp.isInPrint());
			System.out.println("Date of published :"+ bp.getPublishDate());
		}
	}

}
