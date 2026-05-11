# Spring Board CRUD

Spring Boot와 JPA를 활용하여 게시판 CRUD API를 구현한 학습용 프로젝트입니다.

단순 CRUD 구현을 넘어,

* 계층 분리(Controller / Service / Repository)
* DTO 구조 적용
* Validation
* 예외 처리
* API 응답 구조 통일

등 실무형 API 구조를 학습하는 것을 목표로 진행했습니다.

---

# 학습 목적

* Spring Boot 기본 구조 이해
* REST API 흐름 이해
* Controller / Service / Repository 계층 분리
* JPA를 활용한 DB CRUD 구현
* DTO를 활용한 요청/응답 분리
* Validation을 활용한 요청 데이터 검증
* ExceptionHandler를 활용한 예외 처리
* API 응답 구조 통일 경험
* Git/GitHub 협업 흐름 학습

---

# 기술 스택

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Validation
* H2 Database
* Gradle
* Lombok
* Postman

---

# 현재 구현 기능

## 게시글 CRUD

* 게시글 생성
* 게시글 전체 조회
* 게시글 단건 조회
* 게시글 수정
* 게시글 삭제

---

## 구조 개선

* Controller / Service / Repository 계층 분리
* DTO(Request / Response) 적용
* Validation 적용
* Global Exception Handler 적용
* API 응답 구조 통일
* JPA 기반 DB 연동
* H2 Database 연동

---

# API 명세

| Method | URL             | 기능        |
| ------ | --------------- | --------- |
| POST   | /api/posts      | 게시글 생성    |
| GET    | /api/posts      | 게시글 전체 조회 |
| GET    | /api/posts/{id} | 게시글 단건 조회 |
| PUT    | /api/posts/{id} | 게시글 수정    |
| DELETE | /api/posts/{id} | 게시글 삭제    |

---

# API 응답 예시

## 성공 응답

```json
{
  "success": true,
  "message": "게시글 생성 성공",
  "data": {
    "id": 1,
    "title": "제목",
    "content": "내용",
    "author": "작성자"
  }
}
```

---

## 실패 응답

```json
{
  "success": false,
  "message": "게시글을 찾을 수 없습니다.",
  "data": null
}
```

---

# 프로젝트 구조

```text
src/main/java/com/example/board
 ├── controller
 │   └── PostController.java
 │
 ├── domain
 │   └── Post.java
 │
 ├── dto
 │   ├── ApiResponseDto.java
 │   ├── PostRequestDto.java
 │   └── PostResponseDto.java
 │
 ├── exception
 │   ├── GlobalExceptionHandler.java
 │   └── PostNotFoundException.java
 │
 ├── repository
 │   └── PostRepository.java
 │
 ├── service
 │   └── PostService.java
 │
 └── BoardApplication.java
```

---

# 학습 기록

## 1일차

* 개발 환경 구축
* Spring Boot 프로젝트 생성
* Controller 개념 학습
* 게시글 생성/조회 API 구현
* Postman 테스트

---

## 2일차

* 게시글 단건 조회 구현
* 게시글 수정 구현
* 게시글 삭제 구현
* Service 계층 분리
* DI(의존성 주입) 기초 학습

---

## 3일차

* JPA 학습
* Entity 적용
* Repository 생성
* H2 Database 연동
* DB 기반 CRUD 구현
* SQL 로그 확인

---

## 4일차

* DTO 적용
* Request / Response 분리
* Validation 적용
* 사용자 정의 예외(Custom Exception)
* Global Exception Handler 적용
* API 응답 구조 통일

---

# 실행 방법

## 프로젝트 실행

```bash
./gradlew bootRun
```

또는 IntelliJ에서 `BoardApplication` 실행.

---

# H2 Console 접속

```text
http://localhost:8080/h2-console
```

## 접속 정보

```text
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

---

# 프로젝트를 통해 학습한 내용

* Spring MVC 흐름
* 계층형 아키텍처
* JPA 기반 DB 처리
* DTO 패턴
* Validation
* 예외 처리 구조
* API 응답 설계

