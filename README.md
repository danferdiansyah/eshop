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

### Secure Coding Practices

Selain clean code principle, saya juga perlu memperhatikan kemananan dari product yang saya buat guna mencegah serangan peretas dan data user tetap aman. 

- **Penggunaan UUID:** Menggunakan UUID sebagai `productId` lebih aman dibandingkan ID yang mudah ditebak, misalnya integer increment.

- **CSRF Protection:** Form yang dikirim melalui `POST` akan dilindungi dari serangan `CSRF`.

- **Data Encapsulation:** Variabel `productData` di `ProductRepository` bersifat private, dan akses ke data dilakukan melalui metode yang menggunakan encapsulation.


### Area Improvisasi

Tentunya, Clean Code Principle dan Secure Coding Practice yang saya terapkan sudah saya improvisasi dibandingkan mengikuti penuh Tutorial 1. Akan tetapi, masih ada beberapa field yang dapat saya tingkatkan lagi, sebagai berikut

- **Error Handling:** Code saya saat ini kurang menangani error dengan baik. Misalnya, jika `findById` tidak menemukan produk, ia mengembalikan `null`, yang dapat menyebabkan `NullPointerException`. Alternatifnya, saya bisa menggunakan `Optional` atau throw `Exception` yang sesuai.

- **Validasi Tambahan:** Saat ini, validasi input hanya dilakukan pada sisi client (`HTML`). Akan lebih secure apabila saya nantinya menambahkan validasi pada sisi server atau back-end. Misalnya, validasi `productName` yang tidak boleh kosong atau `productQuantity` yang harus lebih dari 0.

Sejauh ini, saya rasa Tutorial 1 sudah cukup memberi pandangan yang luas bagaimana Clean Code Principle dan Secure Coding Practices dapat diterapkan. Berikutnya, akan ada pembahasan lebih lanjut mengenai CI yang akan dibahas pada Refleksi 2.

 ---

 # Reflection 2

 ---

 **1.** Setelah membuat unit test, saya merasa cukup secure karena dapat memastikan bahwa code yang telah saya buat dapat berjalan sebagaimana mestinya. Akan tetapi, ada bagian trickynya di mana saya perlu menulis code yang relatif repetitif dan terkadang terkesan membosankan. Atau mungkin memastikan edge case jika ke depannya saya perlu melakukan unit testing terhadap function yang lebih kompleks. Lalu
 **Berapa banyak unit test yang diperlukan dalam suatu class?** Unit test perlu dibuat sebisa mungkin dapat melakukan coverage seluruh bagian pada class. Misalnya, untuk semua logika bisnis atau method public. Lalu, unit test untuk skenario positif dan negatif. Serta, unit test untuk berbagai kemungkinan parameter.
 **Bagaimana memastikan kalau unit testnya sudah cukup?** Ada code coverage yang bisa dijadikan sebagai acuan seberapa banyak code dapat dieksekusi sesuai ekspektasi. Usahakan untuk membuat unit test dengan code coverage yang tinggi. Namun demikian, tetap perlu review dari tim yang memiliki kapabilitas sebagai tester.
 **Jika code coverage mencapai 100%, apakah program bebas bug?** Belum tentu. Karena unit test hanya akan berjalan seperti yang kita perintahkan. Unit test memastikan bahwa method yang kita buat memberi output sesuai dengan ekspektasi yang kita inginkan. Akan tetapi, tetap saja ada kemungkinan bug di luar method, misalnya bug yang terjadi akibat kesalahan integrasi antarkomponen code yang tidak terdteksi unit test.
