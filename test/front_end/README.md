
# 🎨 Qima Frontend - Product & Category Management

Angular application developed as the frontend solution for the technical challenge.  
This project allows managing products and categories, consuming the backend REST API.

## 📄 Summary

- 🎯 Features
- ⚙️ Requirements
- 🚀 How to run
- 🗂️ Project structure
- 📌 Technical considerations
- 📚 Technologies used

---

## 🎯 Features

- ✅ Product listing with Material Design table
- ✅ Sorting, filtering and pagination for product list
- ✅ CRUD for products (create, edit, delete)
- ✅ Validation of product data (name, price, stock)
- ✅ Product-category relationship management
- ✅ Responsive layout with Angular Material
- ✅ Authentication support via Basic Auth
- ✅ CORS configured to communicate with backend

---

## ⚙️ Requirements

- Node.js 18+
- Angular CLI 17+
- (Optional) Visual Studio Code

---

## 🚀 How to run

1. **Clone the repository:**

```bash
git clone <your-repository>
cd frontend
```

2. **Install dependencies:**

```bash
npm install
```

3. **Run the application:**

```bash
npm run dev
```

The application will be available at:

```
http://localhost:4200
```

> Note: Ensure that the backend API is running at `http://localhost:8080`

---

## 🗂️ Project structure

```
src/
 ├── app/
 │   ├── components/           # Standalone components (product, category)
 │   ├── models/               # Data models
 │   ├── services/             # API service layer
 │   ├── app.routes.ts         # Application routing
 │   └── app.component.ts/html # Main component and template
 └── index.html                # Entry point
```

---

## 📌 Technical considerations

- The project uses **Angular Standalone Components** (Angular 17+).
- UI built with **Angular Material**.
- Full CRUD operations implemented for products.
- Product form includes validation:
  - `name` cannot be empty
  - `price` must be greater than zero
  - `quantityInStock` must be greater than zero
- Authentication implemented using **Basic Auth** and Angular Http Interceptor.
- Compatible with the backend API provided in this challenge.

---

## 📚 Technologies used

- Angular 17+
- TypeScript
- Angular Material
- RxJS
- Vite (optional for development server)
- Basic Auth Interceptor

---

