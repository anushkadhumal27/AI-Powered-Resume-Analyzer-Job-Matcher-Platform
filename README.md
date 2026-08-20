🤖 AI-Powered Resume Analyzer & Job Matcher Platform

«Enterprise-grade AI-powered platform for intelligent resume analysis, ATS optimization, job matching, resume improvement, and personalized career roadmaps.»

"Status" (https://img.shields.io/badge/status-under--development-orange)
"Java" (https://img.shields.io/badge/Java-21-red)
"Spring%20Boot" (https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen)
"Python" (https://img.shields.io/badge/Python-3.14-blue)
"React" (https://img.shields.io/badge/React-Vite-61DAFB)
"FastAPI" (https://img.shields.io/badge/FastAPI-API-009688)
"Database" (https://img.shields.io/badge/Database-PostgreSQL%20%7C%20H2-blue)

---

📌 Overview

The AI-Powered Resume Analyzer & Job Matcher Platform is a full-stack career intelligence platform that analyzes resumes and compares them against target job descriptions and industry roles.

The platform goes beyond basic keyword matching by combining:

- Resume parsing
- NLP-based skill extraction
- Skill categorization
- Multi-factor ATS scoring
- Job description matching
- Missing skill identification
- Actionable resume improvement suggestions
- AI-assisted bullet point rewriting
- Personalized learning roadmaps
- Historical resume analytics
- PDF/JSON report generation

The system is implemented as a modular architecture consisting of a React frontend, Java Spring Boot backend, and Python FastAPI ML/NLP microservice.

---

🎯 Problem Statement

Many candidates submit resumes without understanding:

- How well their resume matches a target role
- Which technical skills are missing
- Whether their experience is quantified effectively
- Whether their resume structure is ATS-friendly
- Which parts of their resume should be improved
- What skills they should learn next

Existing resume checkers often focus primarily on keyword matching.

This project aims to provide a more comprehensive analysis by evaluating resume structure, skills, measurable impact, action verbs, formatting, and semantic similarity against target job descriptions.

---

💡 Proposed Solution

The platform accepts a resume in formats such as:

- PDF
- DOCX
- Plain text

The resume is parsed and analyzed by the NLP service.

The system extracts:

Candidate Information
        ↓
Resume Sections
        ↓
Skills
        ↓
Experience & Projects
        ↓
ATS Metrics
        ↓
Target Job Comparison
        ↓
Skill Gap
        ↓
Improvement Suggestions
        ↓
Learning Roadmap

---

🏗️ System Architecture

flowchart TD

    USER[Candidate]

    USER --> FRONTEND[React + Vite Frontend]

    FRONTEND --> BACKEND[Spring Boot Backend]

    BACKEND --> DB[(Database)]

    BACKEND --> ML[Python FastAPI ML Service]

    ML --> PARSER[Resume Parser]
    ML --> SKILLS[Skill Extractor]
    ML --> ATS[ATS Scoring Engine]
    ML --> MATCHER[Job Matcher]
    ML --> SUGGESTIONS[Suggestion Engine]
    ML --> ROADMAP[Roadmap Generator]

    BACKEND --> EXPORT[Report Export]

    EXPORT --> PDF[PDF Report]
    EXPORT --> JSON[JSON Report]

---

🧩 Core Modules

1. Resume Processing

Supports:

- PDF
- DOCX
- Plain text

The parser extracts:

- Name
- Email
- Phone
- LinkedIn
- GitHub
- Portfolio
- Summary
- Experience
- Education
- Skills
- Projects
- Certifications

---

2. Intelligent Skill Extraction

The platform uses a curated skill taxonomy containing 2,500+ technical and soft skills.

Skills are organized into eight major domains:

💻 Languages

Examples:

- Java
- Python
- C++
- JavaScript
- TypeScript
- Go
- Rust

🌐 Web & Backend

Examples:

- Spring Boot
- React
- Node.js
- Django
- FastAPI
- REST
- GraphQL

🗄️ Databases

Examples:

- MySQL
- PostgreSQL
- MongoDB
- Redis
- DynamoDB

☁️ Cloud & DevOps

Examples:

- AWS
- GCP
- Docker
- Kubernetes
- Terraform
- CI/CD

🤖 AI / ML & Data

Examples:

- PyTorch
- TensorFlow
- Scikit-Learn
- Pandas
- spaCy
- LLMs

🏗️ Architecture & Systems

Examples:

- Microservices
- Kafka
- REST APIs
- Distributed Systems

🧪 Testing & QA

Examples:

- JUnit
- Jest
- Selenium
- Cypress
- TDD

🤝 Soft Skills & Methodologies

Examples:

- Agile
- Scrum
- Leadership
- Communication
- Cross-functional Collaboration

---

3. ATS Scoring Engine

The platform generates an overall score between 0 and 100.

Category| Weight
Keyword & Skills Match| 30
Quantifiable Impact & Metrics| 25
Action Verb Strength| 20
Structure & Section Completeness| 15
Formatting & Brevity| 10
Total| 100

Example

Overall ATS Score
        88 / 100

Keyword & Skills       27 / 30
Impact & Metrics       20 / 25
Action Verbs           18 / 20
Structure              14 / 15
Formatting               9 / 10

The scoring model is designed to provide a more granular analysis than a simple keyword count.

---

4. Job Matching

Users can compare their resume against:

Predefined Industry Roles

Examples:

- Full Stack Developer
- Java Backend Developer
- Frontend Developer
- ML Engineer
- Data Engineer
- DevOps Engineer
- Cloud Engineer

Custom Job Description

Users can paste a real job description into the platform.

The system calculates:

- Overall match percentage
- Keyword overlap
- Matched skills
- Missing skills
- Must-have skill gaps
- Nice-to-have skill gaps
- Improvement recommendations

---

5. Semantic Job Matching

The initial matching engine uses:

TF-IDF
+
Cosine Similarity
+
Weighted Keyword Matching

This allows the system to compare resume content with job requirements beyond simple exact keyword counting.

---

6. Resume Improvement Engine

The platform generates actionable suggestions categorized as:

🔴 Critical

Issues that may significantly affect resume performance.

🟡 Recommended

Improvements that can strengthen the resume.

🟢 Nice-to-Have

Optional improvements for further optimization.

---

✍️ Before vs After Bullet Rewriting

The system evaluates weak resume bullets and proposes stronger alternatives.

Example

Before

«Worked on a web application using Java.»

After

«Developed a Java-based web application that improved application processing efficiency by 25% through optimized backend workflows.»

The system follows the principle:

Accomplished X
as measured by Y
by doing Z

---

🗺️ Personalized Learning Roadmap

Based on missing skills, the platform generates a milestone-based learning roadmap.

Phase 1 — Core Fundamentals

Focus on foundational concepts required for the target role.

Phase 2 — Production Frameworks

Learn practical frameworks and development tools.

Phase 3 — Cloud & Scale

Learn deployment, cloud infrastructure and scalable architecture.

Phase 4 — Capstone Project

Build a practical project combining the acquired skills.

Each milestone can contain:

- Skill
- Learning objective
- Estimated duration
- Recommended resources
- Project idea
- Completion milestone

---

📊 Analytics Dashboard

The platform provides visual analytics including:

- Overall ATS score
- ATS subscore breakdown
- Skill distribution
- Missing skill matrix
- Job match percentage
- Resume history
- Score progression
- Target role distribution

---

📤 Report Export

Users can export analysis results as:

JSON
PDF

Exported reports contain:

- ATS score
- Subscores
- Extracted skills
- Missing skills
- Job match
- Suggestions
- Learning roadmap

---

🛠️ Technology Stack

Backend

- Java 21
- Spring Boot 3.3
- Spring Web
- Spring Data JPA
- Spring Validation
- Maven
- Lombok

ML / NLP

- Python
- FastAPI
- scikit-learn
- NumPy
- spaCy
- pypdf
- python-docx

Frontend

- React
- Vite
- JavaScript
- CSS
- Responsive UI
- Interactive charts and visualizations

Database

- PostgreSQL
- H2 development fallback

Document Processing

- PDF parsing
- DOCX parsing
- Plain-text processing

DevOps

- Docker
- Docker Compose
- GitHub Actions — planned

---

📁 Project Structure

ai-resume-analyzer/
│
├── backend-spring-boot/
│
├── ml-python-service/
│   ├── analyzer/
│   ├── tests/
│   ├── main.py
│   └── requirements.txt
│
├── frontend-react/
│
├── database/
│
├── docs/
│
├── assets/
│
├── docker-compose.yml
├── start-platform.bat
├── start-platform.ps1
├── README.md
├── LICENSE
├── .gitignore
├── .env.example
├── CONTRIBUTING.md
└── CHANGELOG.md

---

🔌 API Endpoints

ML Service

Resume Analysis

POST /api/ml/analyze-resume

Analyzes uploaded resume content and returns:

- Parsed sections
- Contact information
- Extracted skills
- ATS scores
- Suggestions
- Bullet rewrites

Job Comparison

POST /api/ml/compare-job

Compares resume content against a job description.

Learning Roadmap

POST /api/ml/generate-roadmap

Generates a structured roadmap based on missing skills.

Health

GET /health

---

☕ Spring Boot APIs

Resume

POST   /api/resumes/upload
POST   /api/resumes/analyze-text
GET    /api/resumes/{id}
GET    /api/resumes
DELETE /api/resumes/{id}

Job Matching

POST /api/jobs/compare
GET  /api/jobs/roles
POST /api/jobs/match-role/{resumeId}/{roleId}

Analytics

GET /api/analytics/summary
GET /api/export/{id}/json
GET /api/export/{id}/pdf

---

🗄️ Database Design

Core entities include:

Resume
ResumeAnalysis
JobRole
JobComparison

Resume

Stores:

- Filename
- File type
- Raw text
- Parsed sections
- Candidate information
- Creation timestamp

ResumeAnalysis

Stores:

- Overall ATS score
- Keyword score
- Impact score
- Action verb score
- Structure score
- Formatting score
- Extracted skills
- Missing skills
- Suggestions
- Roadmap

JobRole

Stores:

- Role name
- Required skills
- Preferred skills
- Role description

JobComparison

Stores:

- Resume
- Target role
- Job description
- Match percentage
- Matched skills
- Missing skills
- Improvement tips

---

⚙️ Local Development

Prerequisites

Install:

- Java 21
- Maven
- Python
- Node.js
- npm
- PostgreSQL — optional when using H2 development mode
- Docker — optional

---

🐍 Start ML Service

cd ml-python-service
pip install -r requirements.txt
uvicorn main:app --port 8000

Service:

http://localhost:8000

Health check:

GET /health

---

☕ Start Spring Boot Backend

cd backend-spring-boot
.\mvnw.cmd spring-boot:run

Default backend:

http://localhost:8080

---

⚛️ Start React Frontend

cd frontend-react
npm install
npm run dev

The Vite development server will provide the frontend URL in the terminal.

---

🐳 Docker

The project includes Docker Compose support for running the complete platform.

Planned services:

PostgreSQL
Spring Boot
FastAPI
React
Nginx

Start the platform with:

docker compose up --build

---

🧪 Testing

Python ML Tests

cd ml-python-service
python -m unittest discover tests

Tests cover:

- Resume parser
- Skill extractor
- ATS scorer
- Job matcher

Spring Boot Tests

cd backend-spring-boot
.\mvnw.cmd test

Tests cover:

- Application context
- JPA entities
- Database integration
- REST APIs
- Validation

---

🔍 Verification Workflow

A complete end-to-end verification should follow:

Upload Resume
      ↓
Parse Resume
      ↓
Extract Sections
      ↓
Extract Skills
      ↓
Calculate ATS Score
      ↓
Compare Job Description
      ↓
Identify Missing Skills
      ↓
Generate Suggestions
      ↓
Generate Learning Roadmap
      ↓
Export Report

---

🚀 Development Roadmap

Phase 1 — Project Foundation

- [x] Repository creation
- [ ] Spring Boot setup
- [ ] FastAPI setup
- [ ] React setup
- [ ] Database configuration
- [ ] Environment configuration

Phase 2 — Resume Processing

- [ ] PDF parser
- [ ] DOCX parser
- [ ] Plain text parser
- [ ] Section detection
- [ ] Contact extraction

Phase 3 — Skill Intelligence

- [ ] Skill taxonomy
- [ ] Skill categorization
- [ ] Alias normalization
- [ ] Skill extraction
- [ ] Missing skill detection

Phase 4 — ATS Engine

- [ ] Keyword scoring
- [ ] Impact scoring
- [ ] Action verb scoring
- [ ] Structure scoring
- [ ] Formatting scoring
- [ ] Overall ATS score

Phase 5 — Job Matching

- [ ] Role database
- [ ] Custom JD comparison
- [ ] TF-IDF similarity
- [ ] Cosine similarity
- [ ] Weighted keyword matching
- [ ] Match percentage

Phase 6 — Recommendations

- [ ] Resume critique
- [ ] Priority categorization
- [ ] Bullet rewriting
- [ ] Before/after comparison

Phase 7 — Learning Roadmap

- [ ] Missing skill analysis
- [ ] Milestone generation
- [ ] Learning phases
- [ ] Project recommendations
- [ ] Learning resources

Phase 8 — Dashboard

- [ ] ATS gauge
- [ ] Skill visualization
- [ ] Job comparison
- [ ] Suggestions
- [ ] Roadmap timeline
- [ ] History analytics

Phase 9 — Engineering

- [ ] Unit tests
- [ ] Integration tests
- [ ] API documentation
- [ ] Docker
- [ ] CI/CD
- [ ] Production deployment

---

🔐 Security

Sensitive information must never be committed to the repository.

Do not commit:

.env
API keys
Passwords
Database credentials
Private certificates
Access tokens

Use:

.env.example

for configuration documentation.

---

📈 Future Enhancements

Potential future improvements:

- Authentication and authorization
- Multiple resume profiles
- Resume version comparison
- LinkedIn profile analysis
- Real-time job aggregation
- LLM-powered resume rewriting
- Interview question generation
- Personalized interview preparation
- Recruiter dashboard
- Multi-language resume analysis
- Cloud deployment
- CI/CD automation

---

🎓 Placement Relevance

This project demonstrates practical knowledge of:

- Java
- Spring Boot
- REST API development
- Microservice architecture
- React
- Python
- FastAPI
- NLP
- Machine Learning
- SQL / relational databases
- JPA / Hibernate
- Docker
- Git & GitHub
- Automated testing
- API integration
- Software architecture

---

👩‍💻 Author

Anushka Dhumal

B.Tech Computer Science & Engineering

---

📄 License

This project is licensed under the MIT License.

---

⭐ Project Status

Currently under active development.

The documentation and feature list will evolve as new modules are implemented and verified.
