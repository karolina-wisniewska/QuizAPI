<a id="readme-top"></a>

[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]
<div align="center">
<h3 align="center">Quiz API</h3>
  <p align="center">
    REST API for solving quizzes 
    <br />
    <a href="https://github.com/karolina-wisniewska/QuizAPI"><strong>Explore the docs »</strong></a>
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
      <ul>
        <li><a href="#about-solution">Remarks On Task Solution</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#demo">Demo</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

<a name="about-the-project"></a>
<!-- ABOUT THE PROJECT -->
## About The Project

The application uses questions from https://quizapi.io/. Ten questions with answers are loaded and saved to database at 
the start of the application.

REST API has two endpoints:
- GET **/api/questions** to get random question with possible answers
- POST **/api/answers** to answer question and get message whether the answer was correct

Full API documentation is provided by Swagger after installation. 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a id="built-with"></a>
### Built With
* Java 17
* MySQL
* Maven
* Spring Boot
* Hibernate
* Lombok
* OpenApi 3 (Swagger)
* JUnit
* IntelliJ IDEA
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a id="about-solution"></a>
### Remarks On Task Solution

1. **Schema creation scripts:** there are two scripts in **/init** directory: 
   * **schema.sql** that creates database and is used by docker to create mysql container
   * **schema-with-tables.sql** that creates database and required tables
   

2. **Saving questions to database:** when saving a question from https://quizapi.io/ to the database,
  there is no check if the question already exists in the database so questions can be potentially duplicated.
  To solve this, the CommandLineRunner could use while loop to save questions until ten distinct questions are saved.
  Saving a question could use checking if the question already exists by **FindByApiId** method in **QuestionRepository**.
 

3. **Getting random question from database:** if it cannot be assumed that question ids are unremovable, to obtain random 
  question we could:
   * get all questions from the database to a **list**;
   * get **random number** from between zero and (**list** size - 1)
   * get the element of the **list** on position **random number**
   

4. **Docker-compose:** uses image from Gitlab repository which does not include testing
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a id="getting-started"></a>
<!-- GETTING STARTED -->
## Getting Started

<a id="prerequisities"></a>
### Prerequisites
Docker, Docker compose

<a id="installation"></a>
### Installation

1. To launch the application, you need to clone the GitHub project:
   ```sh
   git clone https://github.com/karolina-wisniewska/QuizAPI.git
   ```

2. Change directory to project root directory:
   ```sh
   cd QuizAPI/
   ```

3. Run docker-compose up in detached mode:
   ```sh
   docker-compose up -d
   ```

4. The web application starts on port 8080 in the localhost by default. Open the URL http://localhost:8080/swagger-ui/index.html to browse API documentation and test API.

5. To close the app, remove containers and volumes run:
   ```sh
   docker-compose down -v
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a id="license"></a>
<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/karolina-wisniewska/QuizAPI/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/karolina-wi

