package br.com.rrc.autentication.controller;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import br.com.rrc.autentication.AutenticationApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AutenticationApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class UsuarioControllerTest {

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}	

	@Test
	public void usuarioControllerTest() throws IOException {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(" {                               ");
		stringBuffer.append("  'name': 'João da Silva',       ");
		stringBuffer.append("  'email': 'joao@silva.org',     ");
		stringBuffer.append("  'password': 'hunter2',         ");
		stringBuffer.append("  'telefone': [                  ");
		stringBuffer.append("      {                          ");
		stringBuffer.append("          'number': '987654321', ");
		stringBuffer.append("          'ddd': '21'            ");
		stringBuffer.append("      }                          ");
		stringBuffer.append("  ]                              ");
		stringBuffer.append(" }                               ");
		given().                                                     
		contentType(ContentType.JSON).
		body(stringBuffer).
		when().
		post("/usuario/save").
		then().
		statusCode(HttpStatus.SC_OK);
	}
}
