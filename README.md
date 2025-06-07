# Pix2TeX Web API

![Pix2TeX Banner](https://latex.ai/static/media/logo.429eaad5.svg)

A simple and clean web application that provides an API for converting images of mathematical expressions into LaTeX code. This service **acts as a web interface** for the open-source [pix2tex](https://github.com/lukas-blecher/LaTeX-OCR) model.

---

## ✨ Highlights

* ✅ Exposes a single REST endpoint: `/image/upload`
* 📷 Accepts image uploads of mathematical expressions (PNG, JPG, etc.)
* 🧠 Converts image input into accurate LaTeX code
* ⚖️ This is a **web service wrapper**; it uses but does not include or alter the core `pix2tex` model
* 🚪 Built with Spring Boot and Docker for portability and ease of deployment

---

## 🛠️ API Usage

### Endpoint

```
POST /image/upload
```

### Request

* Content-Type: `multipart/form-data`
* Form field name: `file`
* File type: `image/png`, `image/jpeg`, etc.
* Ideal image size: \~384x384 px (recommended for pix2tex)

#### Example using `curl`

```bash
curl -X POST http://localhost:8080/image/upload \
  -F 'file=@expression.png'
```

### Response

```json
{
  "latex": "\\frac{a}{b} = c"
}
```

---

## 📆 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/pix2tex-api.git
cd pix2tex-api
```

### 2. Set Up Environment Variables

Create a `.env` file:

```ini
SPRING_PROFILES_ACTIVE=prod
SERVER_PORT=8080
... # other necessary vars
```

### 3. Run with Docker Compose

```bash
docker compose up --build
```

---

## 🔐 Notes

* This application does **not** include the pix2tex model; it only **calls** the model hosted in a separate container or service.
* Make sure to run the actual pix2tex service (e.g., via its Python API) and update the backend URL accordingly.
* Ensure the input image is clean, centered, and high-contrast for better recognition.

---

## 📜 License

MIT License. This project uses the open-source [pix2tex model](https://github.com/lukas-blecher/LaTeX-OCR), licensed under GPLv3. This repository does not modify or bundle the model directly.
