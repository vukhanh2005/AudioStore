# Web Ban Thiet Bi Am Thanh

Du an gom 2 phan:

- `front-end`: Giao dien ReactJS, dung `react-router-dom` de chuyen trang.
- `back-end/webbanhang-server`: API Spring Boot ket noi SQL Server.

## Yeu cau bai tap da duoc chuan bi

- Co Banner, Top Menu, Left Menu, Content va Footer dung chung cho tat ca trang.
- Co cac trang: Trang chu, Chi tiet san pham, Dang nhap, Dang ky, Lien he, Gio hang.
- CSS rieng cho Top Menu, Left Menu, tieu de content, thong tin va hieu ung hover.
- Frontend lay san pham tu API Spring Boot, khong dung du lieu mau trong React.
- Backend doc cau hinh database tu file `.env`.

## Chay backend

Mo thu muc `back-end/webbanhang-server` bang IntelliJ, dam bao Project SDK la JDK 17 tro len. May hien co JDK tai:

```text
C:\Program Files\Java\jdk-21
```

File cau hinh bi mat nam o:

```text
back-end/webbanhang-server/.env
```

Backend dang ket noi SQL Server database `dtb` voi user `nvk`. Neu database chua co bang, chay file:

```text
back-end/webbanhang-server/database/schema.sql
```

## Chay frontend

Trong thu muc `front-end`, chay:

```bash
npm run dev
```

Frontend lay API tu file:

```text
front-end/.env
```
"# Audio Store" 
