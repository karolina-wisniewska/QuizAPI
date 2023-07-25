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

The application uses questions and answers data from https://quizapi.io/. Ten questions with answers are loaded at 
the start of the application.

REST API has two endpoints:
- GET /api/questions to get random question with possible answers
- POST /api/answers to answer question and find out whether the answer was correct

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
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/karolina-wi

