# Front-end

Giao dien React cho website ban thiet bi am thanh.

## Chay du an

```bash
npm install
npm run dev
```

## Cau hinh API

Frontend lay du lieu tu Spring Boot qua file `.env`:

```text
VITE_API_URL=http://localhost:8080/api
```

## Cac trang da tao

- `/`: Trang chu, lay san pham tu database thong qua API.
- `/san-pham/:productId`: Trang chi tiet san pham.
- `/dang-nhap`: Trang dang nhap.
- `/dang-ky`: Trang dang ky.
- `/lien-he`: Trang lien he.
- `/gio-hang`: Trang gio hang.

Tat ca cac trang deu dung chung Banner, Top Menu, Left Menu va Footer theo yeu cau de bai.
