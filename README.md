# login-app
In order to make this work, we also need to have working instance of Keycloak. 
I used dockerized keycloak instance (jboss/keycloak docker image from docker hub). Once image is downloaded, run it using:
docker run -p 8080:8080 jboss/keycloak
Application can be accessed via localhost on port 8080: localhost:8080
Create admin user and then follow tutorial from this link:https://www.baeldung.com/spring-boot-keycloak in order to add realm,
client, role and user. Do not forget to set application to work on another port (8080 is used by keycloak) or set different port for
keycloak.
In order to test endpoint, use postman. Add POST request to postman:
http://localhost:8080/auth/realms/REALM_NAME/protocol/openid-connect/token
Add Body x-www-form-urlencoded data with following keys:
client_id CLIENT_ID_FROM_KEYCLOAK
username USERNAME_FROM_KEYCLOAK
password USER_PASSWORD_FROM_KEYCLOAK (this username and password are user/pass for a created user, NOT the keycloak admin user)
grant_type: password

This call will acquire ACCEESS_TOKEN. 

Create another (GET) request: localhost:8081/customers
Select Authorization TAB and select 'Bearer Token'. Paste ACCESS_TOKEN to Token field. 
This should be sufficient to gain access to the appropriate endpoint.
