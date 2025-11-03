# 🛒 EcomShop

EcomShop is a **Java-based Spring Boot backend** for an e-commerce application.  
It allows users to add, update, and manage products, upload product images, and handle customer orders efficiently through RESTful APIs.

---

## 🧱 Project Structure

```
com.chandhu.EcomShop
│
├── controller
│   ├── ProductController.java       # Handles product-related endpoints
│   └── OrderController.java         # Handles order placement and retrieval
│
├── model
│   ├── Product.java                 # Product entity
│   ├── Order.java                   # Order entity
│   ├── OrderItem.java               # Order item entity
│   └── dto
│       ├── OrderRequest.java
│       ├── OrderResponse.java
│       ├── OrderItemRequest.java
│       └── OrderItemResponse.java
│
├── repository                       # JPA repositories (Spring Data)
│
├── service
│   ├── ProductService.java          # Business logic for products
│   └── OrderService.java            # Business logic for orders
│
└── EcomShopApplication.java         # Main Spring Boot application entry point
```

---

## ⚙️ Configuration

### **1. Prerequisites**
- **Java 17** or above  
- **Maven**  
- **MySQL** (or any relational DB)

---

### **2. Database Setup**

Create a new database in MySQL:
```sql
CREATE DATABASE ecomshop;
```

Update your `application.properties` file with your credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecomshop
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## ▶️ How to Run

### **1. Clone the Repository**
```bash
git clone https://github.com/<your-username>/EcomShop.git
cd EcomShop
```

### **2. Build the Project**
```bash
mvn clean install
```

### **3. Run the Application**
```bash
mvn spring-boot:run
```
Or directly run `EcomShopApplication.java` from IntelliJ IDEA.

The server will start at:
```
👉 http://localhost:8080
```

---

## 📡 API Endpoints

### **Product APIs**

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `GET` | `/api/products` | Get all products |
| `GET` | `/api/products/{id}` | Get product by ID |
| `GET` | `/api/product/{productId}/image` | Fetch product image |
| `POST` | `/api/product` | Add new product (multipart with image + product JSON) |
| `PUT` | `/api/product/{id}` | Update existing product |
| `DELETE` | `/api/product/{id}` | Delete product by ID |
| `GET` | `/api/products/search?keyword=...` | Search products |

---

### **Order APIs**

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/api/orders/place` | Place a new order |
| `GET` | `/api/orders` | Get all orders |

---

## 🧪 Example Request: Add Product

**POST** `/api/product`  
**Form Data:**
- `product` → JSON  
- `imageFile` → Image file  

**Example JSON:**
```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.99,
  "stock": 25
}
```

---

## 📁 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Maven**

---


---

## 📝 License

This project is licensed under the **MIT License** – feel free to use and modify.

---
