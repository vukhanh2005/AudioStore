# ApiCrud

Project Spring Boot theo cau truc:

```text
src/main/java/com/nvk/apicrud
├── Controllers
├── DTO
├── Entity
├── Repository
├── Services
└── ApiCrudApplication.java
```

## Yeu cau

- IntelliJ IDEA
- JDK 26, vi du:

```text
C:\Program Files\Java\jdk-26.0.1
```

- XAMPP MySQL
- Spring Boot 4.0.6

## Import database

Import file:

```text
database/audio_products.sql
```

## Chay project

Mo file:

```text
src/main/java/com/nvk/apicrud/ApiCrudApplication.java
```

Sau do bam Run.

Neu IntelliJ bao chua co JDK:

```text
File -> Project Structure -> Project SDK -> Add SDK -> JDK
```

Chon:

```text
C:\Program Files\Java\jdk-26.0.1
```

Neu muon chay bang terminal:

```powershell
cd C:\Users\Admin\Documents\Codex\2026-05-12\files-mentioned-by-the-user-screenshot\apicrud
java -jar target\apicrud-0.0.1-SNAPSHOT.jar
```

## API

Lay tat ca san pham:

```http
GET http://localhost:8080/api/products
```

Lay san pham theo id:

```http
GET http://localhost:8080/api/products/1
```

Loc theo danh muc:

```http
GET http://localhost:8080/api/products?category=Tai nghe
```

Them san pham:

```http
POST http://localhost:8080/api/products
Content-Type: application/json

{
  "name": "Loa Sony SRS-XB100",
  "category": "Loa",
  "price": 1290000,
  "image": "sony-srs-xb100.jpg",
  "status": "Con hang",
  "description": "Loa bluetooth nho gon, chong nuoc."
}
```

Sua san pham:

```http
PUT http://localhost:8080/api/products/1
Content-Type: application/json

{
  "name": "Tai nghe Sony WH-1000XM5",
  "category": "Tai nghe",
  "price": 7290000,
  "image": "sony-wh-1000xm5.jpg",
  "status": "Con hang",
  "description": "Tai nghe chong on chu dong."
}
```

Xoa san pham:

```http
DELETE http://localhost:8080/api/products/1
```
