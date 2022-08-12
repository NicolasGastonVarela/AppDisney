package com.AppDisney.AppDisney;

import com.AppDisney.AppDisney.Email.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDisneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDisneyApplication.class, args);
	}

}

//TO DO

//1GET /characters?name=nombre, GET /characters?age=edad, GET /characters?movies=idMovie en moviecharacter
// 1GET /movies?name=nombre /movies?genre=idGenero /movies?order=ASC | DESC
// 1agregar/remover personajes a una película: POST /movies/{idMovie}/characters/{idCharacter} DELETE /movies/{idMovie}/characters/{idCharacter}


//3Documentar los endpoints con postman

//4Tests
//4De forma opcional, se podrán agregar tests de los diferentes endpoints de la APP,
//4verificando posibles escenarios de error:
//4- Campos faltantes o con un formato inválido en BODY de las peticiones
//4- Acceso a recursos inexistentes en endpoints de detalle
//4Los tests pueden realizarse utilizando JUnit y Mockito
