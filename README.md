# Spring Board CRUD

Spring Boot를 사용하여 게시판 CRUD API를 구현한 학습용 프로젝트입니다.

## 학습 목적

- Spring Boot 기본 구조 이해
- Controller 역할 이해
- Service 계층 분리
- REST API 기본 흐름 학습
- Postman을 활용한 API 테스트

## 기술 스택

- Java 17
- Spring Boot
- Gradle
- Spring Web
- H2 Database
- Lombok

## 현재 구현 기능.

- 게시글 생성
- 게시글 전체 조회
- 게시글 단건 조회
- 게시글 수정
- 게시글 삭제
- Controller와 Service 계층 분리

## API 명세

| Method | URL | 기능 |
|---|---|---|
| POST | /api/posts | 게시글 생성 |
| GET | /api/posts | 게시글 전체 조회 |
| GET | /api/posts/{id} | 게시글 단건 조회 |
| PUT | /api/posts/{id} | 게시글 수정 |
| DELETE | /api/posts/{id} | 게시글 삭제 |

## 프로젝트 구조

```text
src/main/java/com/example/board
 ├── controller
 │   ├── HelloController.java
 │   └── PostController.java
 ├── domain
 │   └── Post.java
 ├── service
 │   └── PostService.java
 └── BoardApplication.java
```
## 학습 기록
### 1일차
- 개발 환경 구축
- Spring Boot 프로젝트 생성
- Controller 개념 학습
- 게시글 생성/전체 조회 API 구현

### 2일차
- 게시글 단건 조회 구현
- 게시글 수정 구현
- 게시글 삭제 구현
- Service 계층 분리
- DI 개념 기초 학습