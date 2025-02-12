# Reflection 1
---
### Clean Code Principle

Clean code principle merupakan cara untuk menjadi seorang developer yang baik. Terutama, ketika bekerja dalam tim, kita perlu memastikan bahwa code yang kita buat dapat semudah mungkin dibaca, dimaintain, hingga diperbaiki oleh tim developer lain. Pada Tutorial 1, saya telah mempelajari dan menerapkan clean code principle berikut:

- **Single Responsibility Principle (SRP):**
Setiap kelas memiliki tanggung jawab tunggal. Misalnya, `ProductController` hanya menangani permintaan HTTP, `ProductService` menangani logika bisnis, dan `ProductRepository` menangani akses data.

- **Don't Repeat Yourself (DRY):**
Kode tidak memiliki duplikasi yang signifikan. Logika seperti pembuatan, pembaruan, dan penghapusan produk diimplementasikan sekali dan digunakan di berbagai tempat.

- **Meaningful Names:**
Nama kelas, metode, dan variabel deskriptif dan bermakna. Misalnya, `ProductController`, `createProductPage`, `productData`, dan lain-lain.

- **Separation of Concerns (SoC):**
Kode dipisahkan berdasarkan lapisan (layer) seperti controller, service, dan repository. Hal ini dapat memudahkan maintenance dan testing ke depannya.

- **Use of Annotations:**
Anotasi seperti `@Controller`, `@Service`, `@Repository`, dan `@Autowired` digunakan untuk mengelola dependensi dan konfigurasi Spring secara otomatis.

- **Consistent Formatting:**
Kode diformat secara konsisten, dengan indentasi dan spasi yang sesuai, sehingga code jadi lebih mudah dibaca.
