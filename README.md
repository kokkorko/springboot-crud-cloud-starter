# Spring Boot CRUD App

This project is a Spring Boot CRUD application with persistent PostgreSQL and Docker support. It also includes Kubernetes manifests for Minikube-based local simulation and deployment.

---

## Prerequisites

- Java 17+ and Maven
- Docker and Docker Compose
- Minikube and kubectl (for Kubernetes simulation)

---

## 1. Build the Application

```bash
mvn clean package
```
This will generate a JAR file in the `target` directory.

---

## 2. Run Locally with Docker Compose

### a. Build the Docker Image

```bash
docker build -t cloudstarter:local .
```

### b. Start Services

```bash
docker-compose up
```

This will start:
- A PostgreSQL database
- The Spring Boot application (from your built image)

### c. Access the Application

- The API is available at: `http://localhost:8080`
- The PostgreSQL database runs on port `5432` (internal use)

---

## 3. Simulate Locally with Minikube (Kubernetes)

### a. Start Minikube

```bash
minikube start
```

### b. Build and Load Docker Image into Minikube

```bash
eval $(minikube docker-env)
docker build -t cloudstarter:local .
```

### c. Deploy PostgreSQL

```bash
kubectl apply -f k8s/postgres-deployment.yaml
kubectl apply -f k8s/postgres-service.yaml
```

### d. Deploy Spring Boot Application

```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

### e. Access the Application

To get the service URL:
```bash
minikube service cloudstarter-service
```
This will open your browser to the running application.

---

## 4. File Descriptions

- `docker-compose.yaml`: Docker Compose for local development
- `k8s/postgres-deployment.yaml`: PostgreSQL deployment for Kubernetes
- `k8s/postgres-service.yaml`: PostgreSQL service for Kubernetes
- `k8s/deployment.yaml`: Spring Boot app deployment for Kubernetes
- `k8s/service.yaml`: Spring Boot app service for Kubernetes

---

## 5. API Usage

- Example endpoint: `GET /api/items`
- Use Postman or `curl` to interact with the API

---

## Troubleshooting

- Ensure Docker and Minikube are running before starting containers or applying manifests.
- If you rebuild your app, also rebuild the Docker image before restarting services.

---

Enjoy developing and testing your Spring Boot CRUD app locally and with Kubernetes!