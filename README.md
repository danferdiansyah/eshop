# Reflection 1
---
### Clean Code Principle
- **Single Responsibility Principle (SRP)**
Setiap kelas memiliki tanggung jawab tunggal. Misalnya, ProductController hanya menangani permintaan HTTP, ProductService menangani logika bisnis, dan ProductRepository menangani akses data.
**Don't Repeat Yourself (DRY)**
Kode tidak memiliki duplikasi yang signifikan. Logika seperti pembuatan, pembaruan, dan penghapusan produk diimplementasikan sekali dan digunakan di berbagai tempat.
**Meaningful Names**
Nama kelas, metode, dan variabel deskriptif dan bermakna. Misalnya, ProductController, createProductPage, productData, dll.
Separation of Concerns (SoC):
Kode dipisahkan berdasarkan lapisan (layer) seperti controller, service, dan repository. Hal ini dapat memudahkan maintenance dan testing ke depannya.
**Use of Annotations**
Anotasi seperti @Controller, @Service, @Repository, dan @Autowired digunakan untuk mengelola dependensi dan konfigurasi Spring secara otomatis.
**Consistent Formatting**
Kode diformat secara konsisten, dengan indentasi dan spasi yang sesuai, sehingga code jadi lebih mudah dibaca.
