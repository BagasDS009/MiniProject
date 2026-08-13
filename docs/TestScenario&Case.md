# AlterraShop - Test Scenario & Test Case

> **Project:** AlterraShop E-Commerce  
> **Base URL API:** https://be-qa.alta.id  
> **Team:** Project Avengers  

---

## 1. Authentication

### 1.1 Register

| No | Test Case | Method | Endpoint | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|-------------|-----------------|-----------------|
| 1 | Register with valid data | POST | /api/auth/register | `{"fullname":"User1","email":"user1@gmail.com","password":"Pass123"}` | 200 | User created successfully |
| 2 | Register with duplicate email | POST | /api/auth/register | `{"fullname":"User2","email":"user1@gmail.com","password":"Pass456"}` | 400 | Error: email already registered |
| 3 | Register with invalid email format | POST | /api/auth/register | `{"fullname":"User3","email":"08650000","password":"Pass789"}` | 400 | Error: invalid email format |
| 4 | Register with empty fullname | POST | /api/auth/register | `{"fullname":"","email":"user4@gmail.com","password":"Pass123"}` | 400 | Error: fullname is required |
| 5 | Register with empty password | POST | /api/auth/register | `{"fullname":"User5","email":"user5@gmail.com","password":""}` | 400 | Error: password is required |

### 1.2 Login

| No | Test Case | Method | Endpoint | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|-------------|-----------------|-----------------|
| 1 | Login with valid credentials | POST | /api/auth/login | `{"email":"user1@gmail.com","password":"Pass123"}` | 200 | Return auth token |
| 2 | Login with unregistered email | POST | /api/auth/login | `{"email":"noexist@gmail.com","password":"Pass123"}` | 400 | Error: invalid email or password |
| 3 | Login with wrong password | POST | /api/auth/login | `{"email":"user1@gmail.com","password":"WrongPass"}` | 400 | Error: invalid email or password |
| 4 | Login with empty email | POST | /api/auth/login | `{"email":"","password":"Pass123"}` | 400 | Error: email is required |
| 5 | Login with empty password | POST | /api/auth/login | `{"email":"user1@gmail.com","password":""}` | 400 | Error: password is required |

---

## 2. Categories

| No | Test Case | Method | Endpoint | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|-------------|-----------------|-----------------|
| 1 | Get all categories | GET | /api/categories | - | 200 | Return list of categories |
| 2 | Create category with valid name | POST | /api/categories | `{"name":"Elektronik"}` | 200 | Category created |
| 3 | Create category with empty name | POST | /api/categories | `{"name":""}` | 400 | Error: name is required |
| 4 | Create category with duplicate name | POST | /api/categories | `{"name":"Elektronik"}` | 400 | Error: category already exists |

---

## 3. Products

| No | Test Case | Method | Endpoint | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|-------------|-----------------|-----------------|
| 1 | Get all products | GET | /api/products | - | 200 | Return list of products |
| 2 | Get product by valid ID | GET | /api/products/{id} | - | 200 | Return product detail |
| 3 | Get product by invalid ID | GET | /api/products/99999 | - | 404 | Error: product not found |
| 4 | Create product with valid data | POST | /api/products | `{"name":"Durian","price":290000,"categories":[1]}` | 200 | Product created |
| 5 | Create product with negative price | POST | /api/products | `{"name":"Bad","price":-6000000,"categories":[1]}` | 400 | Error: price must be positive |
| 6 | Create product with empty name | POST | /api/products | `{"name":"","price":10000,"categories":[1]}` | 400 | Error: name is required |

---

## 4. Orders / Transactions

| No | Test Case | Method | Endpoint | Auth | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|------|-------------|-----------------|-----------------|
| 1 | Get all orders (authenticated) | GET | /api/orders | Bearer Token | - | 200 | Return list of orders |
| 2 | Create order with valid data | POST | /api/orders | Bearer Token | `[{"product_id":1,"quantity":2}]` | 200 | Order created |
| 3 | Create order with multiple items | POST | /api/orders | Bearer Token | `[{"product_id":1,"quantity":2},{"product_id":7,"quantity":5}]` | 200 | Order created with multiple items |
| 4 | Create order with negative quantity | POST | /api/orders | Bearer Token | `[{"product_id":1,"quantity":-2}]` | 400 | Error: quantity must be positive |
| 5 | Create order with invalid product_id | POST | /api/orders | Bearer Token | `[{"product_id":-2,"quantity":4}]` | 400 | Error: invalid product_id |
| 6 | Create order without auth | POST | /api/orders | None | `[{"product_id":1,"quantity":2}]` | 401 | Error: unauthorized |

---

## 5. Ratings

| No | Test Case | Method | Endpoint | Auth | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|------|-------------|-----------------|-----------------|
| 1 | Get product ratings | GET | /api/products/{id}/ratings | - | - | 200 | Return ratings list |
| 2 | Give rating with auth (valid) | POST | /api/products/{id}/ratings | Bearer Token | `{"count":4}` | 200 | Rating submitted |
| 3 | Give rating without auth | POST | /api/products/{id}/ratings | None | `{"count":3}` | 401 | Error: unauthorized |
| 4 | Give rating with invalid count | POST | /api/products/{id}/ratings | Bearer Token | `{"count":-3}` | 400 | Error: invalid rating value |
| 5 | Give rating above max (>5) | POST | /api/products/{id}/ratings | Bearer Token | `{"count":10}` | 400 | Error: rating must be between 1-5 |

---

## 6. Comments

| No | Test Case | Method | Endpoint | Auth | Request Body | Expected Status | Expected Result |
|----|-----------|--------|----------|------|-------------|-----------------|-----------------|
| 1 | Get product comments | GET | /api/products/{id}/comments | - | - | 200 | Return comments list |
| 2 | Post comment with auth (valid) | POST | /api/products/{id}/comments | Bearer Token | `{"content":"Produk bagus"}` | 200 | Comment posted |
| 3 | Post comment without auth | POST | /api/products/{id}/comments | None | `{"content":"No auth comment"}` | 401 | Error: unauthorized |
| 4 | Post empty comment | POST | /api/products/{id}/comments | Bearer Token | `{"content":""}` | 400 | Error: content is required |

---

## 7. Web UI Test Scenarios

### 7.1 Login Page

| No | Test Scenario | Type | Expected Result |
|----|---------------|------|-----------------|
| 1 | Login with valid email and password | Positive | Redirect to dashboard, show welcome message |
| 2 | Login with invalid email format | Negative | Show error "Invalid email or password" |
| 3 | Login with wrong password | Negative | Show error "Invalid email or password" |
| 4 | Login with empty email | Negative | Show error "Email is required" |
| 5 | Login with empty password | Negative | Show error "Password is required" |

### 7.2 Register Page

| No | Test Scenario | Type | Expected Result |
|----|---------------|------|-----------------|
| 1 | Register with all valid data | Positive | Show success, redirect to login |
| 2 | Register with duplicate email | Negative | Show error "Email already registered" |
| 3 | Register with invalid email format | Negative | Show error "Invalid email format" |
| 4 | Register with mismatched passwords | Negative | Show error "Passwords do not match" |

### 7.3 Products Page

| No | Test Scenario | Type | Expected Result |
|----|---------------|------|-----------------|
| 1 | View all products | Positive | Display list of products with name & price |
| 2 | View product detail | Positive | Show product name, price, description |
| 3 | Search for existing product | Positive | Show matching products |
| 4 | Search with no results | Negative | Show empty result message |

### 7.4 Shopping Cart

| No | Test Scenario | Type | Expected Result |
|----|---------------|------|-----------------|
| 1 | Add product to cart (logged in) | Positive | Item added, cart count increases |
| 2 | Remove product from cart | Positive | Item removed, cart count decreases |
| 3 | Add to cart without login | Negative | Redirect to login page |

---

## Tools & Frameworks

| Area | Tool | Version |
|------|------|---------|
| API Performance Testing | Apache JMeter | 5.4.3 |
| Web UI Testing | Serenity BDD + Cucumber | Serenity 3.9.8, Cucumber 7.14 |
| Browser Automation | Selenium WebDriver | 4.15.0 |
| Language | Java | 11 |
| Build Tool | Maven | 3+ |

---

## References

- [Google Sheets - Original Test Cases](https://docs.google.com/spreadsheets/d/1O2cAvjnjCW_6lBgvmLIYHAEFPbemuS3O/edit?usp=sharing&ouid=116746820989281422089&rtpof=true&sd=true)
