# redis-studies
책 Redis 의 예제를 업로드 하고 간단한 테스트를 진행 해 보는 Repository 입니다

## Server 환경

* redis 7.2.4
* Java 17 (oracle-jdk)
* Spring boot 3.2.3

# Redis 설치

redis 는 각 cpu 에 따라 맞는 버전을 다운 받아야 합니다.

다만 현재 프로젝트는 7.2.4 버전을 사용하고 있습니다.

```shell
docker pull redis:latest
```

## Redis 실행

```shell
docker run -d -p 6379:6379 --name redis-studies redis
```
