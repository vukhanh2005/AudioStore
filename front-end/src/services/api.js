const API_URL = import.meta.env.VITE_API_URL || "http://localhost:8080/api";

let isRefreskTokenRequest = false;
async function request(path, options = {}) {
  var items = {
    credentials: "include",
    headers: {
      "Content-Type": "application/json",
      ...(options.headers || {})
    },
    ...options
  }
  const response = await fetch(`${API_URL}${path}`, items);
  
  console.log(`Requested to ${path} and got response status ${response.status}`);
  
  if(response.status == 204){
    return null;
  }
  if(response.status == 401 && isRefreskTokenRequest == false){
    try{
      //request refresh token
      await refreshToken();
      return request(path, options);
    }
    catch(e){
      window.location.href = "/";
    }
  }
  if(!request.ok()){
    throw new Error(`HTTP ${response.status}`);
  }
  return response.json();
}

export async function refreshToken(){
  isRefreskTokenRequest = true;
  
  try{
    return await request("/auth/refresh");
  }finally{
    isRefreskTokenRequest = false;
  }
}
export function getProducts() {
  return request("/products");
}
export function getProductsByCategory(category){
  return request(`/products/category/${category}`)
}
export function getProductById(productId) {
  return request(`/products/${productId}`);
}

export function login(username, password) {
  return request("/auth/login", {
    method: "POST",
    body: JSON.stringify({ username, password })
  });
}

export function register(account) {
  return request("/auth/register", {
    method: "POST",
    body: JSON.stringify(account)
  });
}

export function getCurrentAccount() {
  return request("/auth/me")
}

export function logout() {
  return request("/auth/logout", {
    method: "POST"
  });
}

export function orderProduct(productId) {
  return request(`/order/${productId}`, {
    method: "POST"
  });
}

export function getOrderHistory() {
  return request("/orders/history");
}

export function submitContact(contact) {
  return request("/contacts", {
    method: "POST",
    body: JSON.stringify(contact)
  });
}

export function formatPrice(price) {
  const numberPrice = Number(price || 0);

  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND"
  }).format(numberPrice);
}
