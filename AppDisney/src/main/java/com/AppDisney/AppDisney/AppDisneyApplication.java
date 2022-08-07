package com.AppDisney.AppDisney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDisneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDisneyApplication.class, args);
	}

}

//TO DO

//GET /characters?name=nombre, GET /characters?age=edad, GET /characters?movies=idMovie en moviecharacter
//CRUD en movies
// GET /movies?name=nombre /movies?genre=idGenero /movies?order=ASC | DESC
// agregar/remover personajes a una película: POST /movies/{idMovie}/characters/{idCharacter} DELETE /movies/{idMovie}/characters/{idCharacter}
//POST genre

//Autenticacion: registro y login para obtener token: /auth/login /auth/register

//Envio de mails: Al registrarse en el sitio, el usuario deberá recibir un email de bienvenida. Es
//recomendable, la utilización de algún servicio de terceros como SendGrid

//Documentar los endpoints con postman

//Tests
//De forma opcional, se podrán agregar tests de los diferentes endpoints de la APP,
//verificando posibles escenarios de error:
//- Campos faltantes o con un formato inválido en BODY de las peticiones
//- Acceso a recursos inexistentes en endpoints de detalle
//Los tests pueden realizarse utilizando JUnit y Mockito
