const API_URL = import.meta.env.VITE_API_URL || "http://localhost:8080/api";

async function request(path) {
  const response = await fetch(`${API_URL}${path}`);
  console.log("Requested to " + `${API_URL}${path}`);
  
  if (!response.ok) {
    throw new Error("Không thể lấy dữ liệu từ server");
  }

  return response.json();
}

export function getProducts() {
  return request("/products");
}
export function getProductsByCategory(category){
  return request(`/products/${category}`)
}
export function getProductById(productId) {
  return request(`/products/${productId}`);
}

export function formatPrice(price) {
  const numberPrice = Number(price || 0);

  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND"
  }).format(numberPrice);
}
