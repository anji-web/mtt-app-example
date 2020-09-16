package com.example.mtt.service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class KeycloakService {

    @Value("${keycloak.auth-server-url}")
    private String url;

    @Value("${keycloak.realm}")
    private String REALM;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    private static final Logger logger = LoggerFactory.getLogger(KeycloakService.class);


    private UsersResource getUserResource(){
        Keycloak keycloak = KeycloakBuilder.builder().serverUrl(url).realm("master").username("secretcode").password("2827180315")
                    .clientId("admin-cli").resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

        RealmResource realmResource = keycloak.realm(REALM);
        UsersResource usersResource = realmResource.users();
        return usersResource;
    }

    private RealmResource getRealmResource(){
        Keycloak keycloak = KeycloakBuilder.builder().serverUrl(url).realm("master").username("secretcode").password("2827180315")
                .clientId("admin-cli").resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

        RealmResource realmResource = keycloak.realm(REALM);

        return realmResource;
    }

//    public int createToken(List<NameValuePair> urlParams){
//        int statusId = 0;
//    }

    private String sendPost(List<NameValuePair> urlPost) throws Exception{
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url + "/realms/" + REALM + "/protocol/openid-connect/token" );
        post.setEntity(new UrlEncodedFormEntity(urlPost));

        HttpResponse response = client.execute(post);

        BufferedReader result = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = result.readLine()) != null){
            buffer.append(line);
        }

        return buffer.toString();
    }


}
