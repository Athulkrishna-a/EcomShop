# 🛍️ EcomShop - A Spring Boot E-commerce Backend

Welcome to **EcomShop**, a robust backend application for a basic e-commerce platform built with **Spring Boot 3** and **Java 17**.

This project provides core functionalities for managing products and handling customer orders, utilizing **Spring Data JPA** for persistence with a **MySQL** database.

---

## 🚀 Getting Started

### ⚙️ Prerequisites

Ensure you have the following installed on your system:

* **Java 17** or above
* **Maven** (to build the project)
* **MySQL** (or any relational database supported by Spring Data JPA)

### 💾 Database Setup

1.  **Create the Database:**
    ```sql
    CREATE DATABASE ecomshop;
    ```

2.  **Configure `application.properties`:**
    Update your `src/main/resources/application.properties` file with your specific database credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ecomshop
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    ```

### ▶️ How to Run

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/](https://github.com/)<your-username>/EcomShop.git
    cd EcomShop
    ```
    *(Remember to replace `<your-username>` with your actual GitHub username)*

2.  **Build the Project:**
    ```bash
    mvn clean install
    ```

3.  **Run the Application:**
    You can run the application using Maven or your IDE:
    ```bash
    mvn spring-boot:run
    ```
    The server will start at: **👉 `http://localhost:8080`**

---

## 🧱 Project Structure

The project follows a standard Spring Boot layered architecture within the `com.chandhu.EcomShop` package:

| Directory | Description | Key Files |
| :--- | :--- | :--- |
| **`controller`** | Handles API requests and responses. | `ProductController.java`, `OrderController.java` |
| **`service`** | Contains the core business logic. | `ProductService.java`, `OrderService.java` |
| **`repository`** | Defines Spring Data JPA interfaces for database interaction. | *(JPA Repositories)* |
| **`model`** | Defines the JPA entities and DTOs (Data Transfer Objects). | `Product.java`, `Order.java`, `OrderRequest.java`, etc. |
| **`EcomShopApplication.java`** | Main entry point of the application. | |

---

## 📡 API Endpoints

All endpoints are prefixed with `/api`.

### Product APIs (`/api/products` or `/api/product`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/products` | Get all available products. |
| `GET` | `/api/products/{id}` | Get a single product by its ID. |
| `GET` | `/api/product/{productId}/image` | Fetch the image for a specific product. |
| `POST` | `/api/product` | **Add a new product.** Requires `multipart/form-data` with product JSON and an image file. |
| `PUT` | `/api/product/{id}` | Update details of an existing product. |
| `DELETE`| `/api/product/{id}` | Delete a product by its ID. |
| `GET` | `/api/products/search?keyword=...` | Search products by a given keyword. |

### Order APIs (`/api/orders`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/orders/place` | **Place a new customer order.** Accepts an `OrderRequest` DTO. |
| `GET` | `/api/orders` | Get a list of all placed orders. |

### 🧪 Example Request: Add Product

To add a product, use a **POST** request to `/api/product` with `multipart/form-data`:

**Form Data:**

* `product`: JSON string containing product details.
* `imageFile`: The actual image file to upload.

**Example JSON for `product` field:**

```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.99,
  "stock": 25
}
