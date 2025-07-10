#  SummarEase : AI-powered blog summarizer 

A Project Assignment under **KoffeClan**

## Overview
The **Blogging Backend Service** is a backend system built using **Java Spring Boot** with **Spring Data JPA** and **MySQL** for database management. It integrates an **AI-powered text summarization feature**, leveraging **spaCy NLP**, served via a Flask API.

This project provides RESTful APIs that enable users to:
- **Create blogs** with a title, content, author, and timestamp.
- **Retrieve** all blogs.
- **Fetch a blog by its ID.**
- **Summarize a blog's content** using an AI-powered **text summarization service** implemented with **Python & spaCy**.
- **Deploy on AWS** via **API Gateway, EC2, and Docker**.

## Project Structure
```
Blogging/
│── blog-summarizer/         # Python Flask app for AI-based summarization
│── src/                     # Java Spring Boot source code
│── template.yaml            # AWS CloudFormation template
│── pom.xml                  # Maven project configuration
│── mvnw, mvnw.cmd           # Maven wrapper scripts
│── target/                  # Compiled JAR files
```

## Features
- **RESTful APIs** for creating, retrieving, and summarizing blog content.
- **Spring Boot & JPA integration** for database management.
- **MySQL Database** for structured data storage.
- **Flask-based AI summarization service** using **spaCy NLP**.
- **Spring Boot + Flask integration** through REST APIs.
- **Maven build & dependency management**.
- **AWS-Ready Deployment** using **AWS EC2, Docker, and API Gateway** (Template provided for deployment).
- **Best practices** in **code structure, performance optimization (caching, pagination), and AI integration**.

## Prerequisites
Ensure you have the following installed:
- **Java 17**
- **Spring Boot (v3.4.3)**
- **Apache Maven**
- **MySQL** (For database storage)
- **Python 3.12** with **Flask** and **spaCy**
- **Docker** (For containerized deployment)
- **AWS CLI & AWS Account** (For cloud deployment, but currently not deployed due to financial limitations)

## Installation & Setup
### 1. Clone the Repository
```bash
git clone https://github.com/KoffeClan/Blogging.git
cd Blogging
```

### 2. Set Up MySQL Database
Create a database in MySQL and configure it in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://your-database-endpoint:3306/blog_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```

### 3. Build & Run Spring Boot Application
```sh
mvn clean install
java -jar target/Blogging-0.0.1-SNAPSHOT.jar
```
The Spring Boot backend will start running on `http://localhost:8080`.

### 4. Start the Flask Summarization Service
Navigate to the `blog-summarizer/` directory and run the following commands:
```bash
pip install -r requirements.txt  # Install required Python dependencies
python -m spacy download en_core_web_sm  # Download spaCy model
python app.py  # Start Flask service at http://127.0.0.1:5000
```

## API Endpoints

| Method | Endpoint             | Description |
|--------|----------------------|-------------|
| **POST** | `/api/blogs/save` | Save a new blog post |
| **GET** | `/api/blogs/all` | Retrieve all blog posts |
| **GET** | `/api/blogs/{id}` | Get a single blog post by ID |
| **POST** | `/api/blogs/summarize` | Get a summary using spaCy NLP |

## Deployment on AWS 
The service is designed to be deployed on **AWS EC2 with API Gateway and Docker**.
A **CloudFormation template (`template.yaml`)** is provided to automate the deployment.

⚠ **Note**: The service **has not been deployed on AWS due to financial limitations**, but the deployment template can be used to deploy easily. To deploy:

### AWS Deployment Steps (Manual)
1. **Create an EC2 instance** (t2.micro or t3.micro under free tier if available).
2. **Install Docker & Java 17** on the EC2 instance.
3. **Clone this repository** to the EC2 instance.
4. **Build & Run Spring Boot App**:
   ```sh
   cd /home/ec2-user/Blogging
   mvn clean package -DskipTests
   java -jar target/Blogging-0.0.1-SNAPSHOT.jar
   ```

## AWS CloudFormation Deployment 
A **CloudFormation template (`template.yaml`)** is included in this repository to automate the AWS deployment process.

### CloudFormation Deployment Steps
1. **Login to AWS Console**
2. **Navigate to AWS CloudFormation**
3. Click **Create Stack** > **With New Resources**
4. Upload the `template.yaml` file
5. **Set Parameters**:
   - Specify **Instance Type** (e.g., `t3.micro` for free-tier eligibility)
   - Set **KeyName** for SSH access
   - Add necessary **IAM Roles** and **Security Groups**
6. **Deploy Stack**
7. **Obtain Public IP** of EC2 instance and update API Gateway settings.
8. **Deploy the API Gateway** and link it with your Spring Boot backend service.

## Contributing
We welcome contributions! If you'd like to contribute, please follow these steps:
1. **Fork the repository** on GitHub.
2. **Create a new branch** for your feature/fix.
3. **Commit your changes** with clear messages.
4. **Push to your branch** and create a Pull Request (PR).
5. **Wait for review & merge** by the maintainers.

## Acknowledgments
This project is a self-assessment assignment aimed at refining backend development, AI integration, and AWS deployment skills. It follows industry best practices to improve software design and cloud deployment capabilities.

## Contact
For any queries or feedback, please reach out:

📧 Email: [amitk1602info@gmail.com](mailto:amitk1602info@gmail.com)

🔗 LinkedIn: [Amit Kumar](https://www.linkedin.com/in/kumaramit02/)

