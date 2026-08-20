# 🤖 AI-Powered Resume Analyzer & Job Matcher

> **Enterprise-grade AI platform for resume analysis, ATS optimization, job matching, and personalized career guidance.**

![Status](https://img.shields.io/badge/status-under--development-orange)
![Java](https://img.shields.io/badge/Java-21-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen)
![Python](https://img.shields.io/badge/Python-3-blue)
![React](https://img.shields.io/badge/React-Vite-61DAFB)
![FastAPI](https://img.shields.io/badge/FastAPI-API-009688)
![Database](https://img.shields.io/badge/Database-PostgreSQL%20%7C%20H2-blue)

## 📌 Overview

A full-stack **AI-powered career intelligence platform** that analyzes resumes, evaluates ATS readiness, matches candidates with job descriptions, identifies skill gaps, and provides actionable improvement suggestions.

### ✨ Key Features

* 📄 PDF, DOCX & text resume parsing
* 🧠 NLP-based skill extraction and categorization
* 📊 Multi-factor ATS scoring
* 🎯 Job description & role matching
* 🔍 Missing skill identification
* ✍️ Resume improvement & bullet rewriting
* 🗺️ Personalized learning roadmaps
* 📈 Resume analytics & score history
* 📤 PDF & JSON report generation

## 🏗️ Architecture

```text
React + Vite
     ↓
Spring Boot Backend
     ↓
PostgreSQL / H2
     ↓
Python FastAPI ML Service
     ↓
Resume Parser → Skill Extractor → ATS Engine
                         ↓
                 Job Matcher
                         ↓
            Suggestions & Roadmap
```

## 🛠️ Tech Stack

**Backend:** Java 21, Spring Boot, Spring Data JPA, Maven
**ML/NLP:** Python, FastAPI, scikit-learn, spaCy, NumPy
**Frontend:** React, Vite, JavaScript, CSS
**Database:** PostgreSQL, H2
**Documents:** pypdf, python-docx
**DevOps:** Docker, Docker Compose, GitHub Actions *(planned)*

## 📁 Project Structure

```text
ai-resume-analyzer/
├── backend-spring-boot/
├── ml-python-service/
├── frontend-react/
├── database/
├── docs/
├── assets/
├── docker-compose.yml
├── .env.example
├── README.md
└── LICENSE
```

## 🚀 Getting Started

### ML Service

```bash
cd ml-python-service
pip install -r requirements.txt
uvicorn main:app --port 8000
```

### Spring Boot Backend

```bash
cd backend-spring-boot
./mvnw spring-boot:run
```

### React Frontend

```bash
cd frontend-react
npm install
npm run dev
```

### Docker

```bash
docker compose up --build
```

## 🔌 Main APIs

| Service | Endpoint                        | Purpose          |
| ------- | ------------------------------- | ---------------- |
| ML      | `POST /api/ml/analyze-resume`   | Analyze resume   |
| ML      | `POST /api/ml/compare-job`      | Compare with job |
| ML      | `POST /api/ml/generate-roadmap` | Generate roadmap |
| Backend | `POST /api/resumes/upload`      | Upload resume    |
| Backend | `POST /api/jobs/compare`        | Job matching     |
| Backend | `GET /api/analytics/summary`    | Analytics        |
| ML      | `GET /health`                   | Health check     |

## 🧪 Testing

```bash
# Python
python -m unittest discover tests

# Spring Boot
./mvnw test
```

## 🚧 Development Status

Currently **under active development**.

Planned improvements include:

* Authentication & authorization
* LLM-powered resume rewriting
* Real-time job aggregation
* Interview preparation
* Resume version comparison
* Cloud deployment
* CI/CD automation

## 👩‍💻 Author

**Anushka Dhumal**
B.Tech Computer Science & Engineering

## 📄 License

MIT License
