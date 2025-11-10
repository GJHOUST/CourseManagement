# CourseManagement

CourseManagement je projekt v jazyce Java, který usnadňuje správu kurzů a uživatelů. Využívá Spring Boot k poskytování RESTful API pro administraci dat o kurzech a uživatelských účtech.

## Funkce

- **Správa uživatelů:**  
  - Registrace nových uživatelů  
  - Přihlášení uživatelů  
  - Získání informací o uživateli  
  - Smazání uživatelského účtu  

- **Správa kurzů:**  
  - Vytváření nových kurzů  
  - Zobrazení všech kurzů  
  - Aktualizace informací o kurzu  
  - Smazání kurzu  

## Použité technologie

- Java
- Spring Boot
- JPA/Hibernate pro perzistenci dat
- Lombok pro zjednodušení kódu

## Testování API

API můžete testovat pomocí nástrojů:
- **Postman** – ruční testování jednotlivých endpointů
- **Swagger UI** – interaktivní dokumentace a testování endpointů v prohlížeči

Pokud je Swagger UI povoleno, otevřete `/swagger-ui/index.html` na běžícím serveru.

## Struktura projektu

- **Entity:**  
  - `User` (`src/main/java/com/example/CourseManagement/data/entities/User.java`): Data o uživateli a roli  
  - `Course` (`src/main/java/com/example/CourseManagement/data/entities/Course.java`): Základní atributy kurzu

- **DTO:**  
  - `UserLoginDTO`, `UserRegistrationDTO`, `UserViewDTO`, `CourseCreateDTO`, `CourseViewDTO`: Slouží pro předávání dat mezi API a backendem

- **Kontrolery:**  
  - `UserController` (`src/main/java/com/example/CourseManagement/controller/UserController.java`): Endpointy související s uživateli  
  - Endpointy pro správu kurzů (viz zdrojový kód)

- **Služby a mapování:**  
  - `UserService`, `CourseServiceImp`, `CourseMapper`: Logika aplikace a konverze mezi entitami a DTO

## Ukázka endpointů

- **API pro uživatele**  
  - `POST /api/users/register` – Registrace nového uživatele  
  - `POST /api/users/login` – Přihlášení uživatele  
  - `GET /api/users/getAllUsers` – Přehled uživatelů  
  - `DELETE /api/users/deleteUser/{userId}` – Smazání uživatele  

- **API pro kurzy**  
  - `POST /api/courses/create` – Vytvoření nového kurzu  
  - `GET /api/courses` – Přehled všech kurzů  
  - `PUT /api/courses/update/{courseId}` – Aktualizace kurzu  
  - `DELETE /api/courses/delete/{courseId}` – Smazání kurzu  

*(Konkrétní cesty API ověřte ve zdrojovém kódu)*

## Jak začít

Naklonujte repozitář a spusťte aplikaci pomocí Maven a Spring Boot:

```bash
git clone https://github.com/GJHOUST/CourseManagement.git
cd CourseManagement
./mvnw spring-boot:run
```
