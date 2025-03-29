# SynthLab API

Backend API for SynthLab built with Spring Boot. Provides user management, lesson content, and avatar customization features.

## 📋 Table of Contents
- [Features](#-features)
- [API Documentation](#-api-documentation)
- [Security](#-security)

## ✨ Features

- JWT Authentication
- User Management
- Lesson Content System
- Avatar Customization
- RESTful Endpoints
- CORS Configured
- Stateless Sessions

## 🔌 API Documentation

### Base URL
`https://api.synthlab.io`

### Authentication

| Endpoint | Method | Auth Required | Description |
|----------|--------|--------------|-------------|
| `/auth/register` | POST | No | Register new user |
| `/auth/login` | POST | No | Login and get JWT token |

### Avatars

| Endpoint | Method | Auth Required | Description |
|----------|--------|--------------|-------------|
| `/avatars` | GET | No | Get all avatars |
| `/avatars/{id}` | GET | No | Get avatar by ID |
| `/avatars` | POST | Yes | Create new avatar |
| `/avatars/{id}` | PUT | Yes | Update avatar |
| `/avatars/{id}` | DELETE | Yes | Delete avatar |

### Lessons

| Endpoint | Method | Auth Required | Description |
|----------|--------|--------------|-------------|
| `/lecciones` | GET | No | Get all lesson titles |
| `/lecciones/{id}` | GET | No | Get lesson by ID |
| `/lecciones/contenidos` | GET | No | Get all lesson contents |
| `/lecciones` | POST | Yes | Create new lesson |
| `/lecciones/contenidos/{id}` | POST | Yes | Add content to lesson |

### Users

| Endpoint | Method | Auth Required | Description |
|----------|--------|--------------|-------------|
| `/users/{id}` | PUT | Yes | Update user profile |

### User Avatars

| Endpoint | Method | Auth Required | Description |
|----------|--------|--------------|-------------|
| `/usuario-avatar/agregar` | POST | Yes | Assign avatar to user |

## 🔒 Security

- JWT Authentication required for protected endpoints
- Password hashing
- CSRF protection disabled (handled by frontend)
- CORS configured for specific origins
- Stateless session management

Protected endpoints require Authorization header:
```http
Authorization: Bearer your.jwt.token.here
