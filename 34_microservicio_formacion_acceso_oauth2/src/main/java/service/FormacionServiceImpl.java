package service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import jakarta.annotation.PostConstruct;
import model.Formacion;
import model.TokenResponse;
@Service
public class FormacionServiceImpl implements FormacionService {
	@Value("${app.urlAuth}")
	String urlAuth;
	@Value("${app.username}")
	String username;
	@Value("${app.password}")
	String password;
	@Value("${app.client_id}")
	String clientId;
	@Value("${app.grant_type}")
	String grantType;
	
	String url="http://localhost:8000/cursos/";
	RestClient restClient;
	String token;
	public FormacionServiceImpl(RestClient restClient) { //inyección por constructor		
		this.restClient=restClient;
	}
	
	@PostConstruct
	public void init() {
		token=getToken();
	}
	private String getToken() {
		//aquí hay que conectar con Keycloak y recoger el token
		MultiValueMap<String,String> params=new LinkedMultiValueMap<>();
		params.add("client_id", clientId);
		params.add("username", username);
		params.add("password", password);
		params.add("grant_type", grantType);
		
		return restClient.post()
		.uri(urlAuth)
		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
		.body(params)  //body de la petición 
		.retrieve()
		.body(TokenResponse.class) //TokenResponse     body de la respuesta
		.getAccess_token();
	}

	@Override
	public List<Formacion> buscarPorArea(String area) {
		return Arrays.stream(restClient
				.get()
				.uri(url+"recuperartodos")
				.header("Authorization", "Bearer "+token)
				.retrieve()
				.body(Formacion[].class)//Formacion[]
			)//Stream<Formacion>
			.filter(f->f.getArea().equals(area))
			.toList();
	}

	@Override
	public void altaFormacion(Formacion formacion) {
		restClient
		.post()
		.uri(url+"alta")
		.header("Authorization", "Bearer "+token)
		.contentType(MediaType.APPLICATION_JSON)
		.body(formacion)
		.retrieve()
		.toBodilessEntity();
		
	}
	
	

}
