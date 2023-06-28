# 정책

### 회원 <Member>
- 비회원은 회원 가입 할 수 있다.
- 회원은 로그인 할 수 있다.
- 회원은 (공연, 공연장) 사업자 등록을 할 수 있다.
    - 사업자 등록 시 바로 요청한 사업자 권한이 부여 되고, 로그아웃 된다.
    - 한 회원은 여러 사업자 권한을 가질 수 있다.

### 영화 <Movie, Schedule>
- 회원(영화 사업자)는 영화 정보<Movie>를 등록 할 수 있다.
- 비회원, 회원은 영화 정보<Movie> 를 조회 할 수 있다.
- 회원(영화 사업자)는 영화 상영 시간표<Schedule> 를 / 을  등록 할 수 있다.
- 비회원, 회원은 영화 상영 시간표<Schedule>을 조회 할 수 있다.

### 극장 <Theater>
- 회원(극장 사업자)은 극장 정보 <Theater>를 좌석과 함께 등록 할 수 있다.
- 비회원, 회원은 극장 정보를 조회할 수 있다.

### 예매 <Reservation, Ticket>
- 회원은 티켓<Ticket> 여러 장을 한 예매<Reservation>에 등록 할 수 있다.


# 기술 스택
Java 8, Spring Boot 2.7, MySQL 8.0


# 엔티티 및 ERD 설계
## 엔티티
<img width="1295" alt="image" src="https://github.com/BnDC/reservation/assets/86050295/b2136670-79c1-4088-a22c-0249bcfbf161">

## ERD
<img width="1336" alt="image" src="https://github.com/BnDC/reservation/assets/86050295/e12ee6e8-7f58-4fc6-9e0f-845490bd78a2">



# 로컬에서 실행 해보기
```
git clone github.com/BnDC/reservation
```


## db 비밀번호 설정
```zsh
cd reservation
mkdir env
```

### reservation/env/db.env 만들기
```yaml
# db.env
MYSQL_ROOT_PASSWORD={원하는 비밀번호}

MYSQL_PORT={원하는 db 포트}
MYSQL_USER={원하는 사용자 이름}
MYSQL_DATABASE={원하는 데이터베이스 이름}
MYSQL_PASSWORD={원하는 비밀번호}
```

### reservation/env/test-db.env 만들기
```yaml
# test-db.env
MYSQL_ROOT_PASSWORD={원하는 비밀번호}

MYSQL_PORT={원하는 db포트}
MYSQL_TEST_PORT={원하는 테스트 db 포트}
MYSQL_TEST_USER={원하는 테스트 데이터베이스 이름}
MYSQL_TEST_DATABASE={원하느 테스트 데이터베이스 이름}
MYSQL_TEST_PASSWORD={원하는 테스트 비밀번호}
```

### reservation/env/total.env 만들기
```yaml
MYSQL_ROOT_PASSWORD={원하는 비밀번호}

MYSQL_PORT={원하는 포트}
MYSQL_USER={원하는 사용자명}
MYSQL_DATABASE={원하는 데이터베이스}
MYSQL_PASSWORD={원하는 비밀번호}

MYSQL_TEST_PORT={원하는 포트}
MYSQL_TEST_USER={원하는 사용자}
MYSQL_TEST_DATABASE={원하는 데이터베이스}
MYSQL_TEST_PASSWORD={원하는 비밀번호}

HOST_NAME=reservation-db
TEST_HOST_NAME=reservation-test-db
```


## docker-compse 실행
```bash
cd reservation/docker
docker compose up -p performance-reservation-service
docker-compose --env-file ../env/total.env -f ./docker-compose.yml -p performance-reservation-service up -d app
```

# api 스펙 문서 주소
docker로 실행 후 
[swagger](http://localhost:8080/swagger-ui/index.html)
