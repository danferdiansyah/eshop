<div align="center">

# **Reflection - Pemrograman Lanjut**  
## Daniel Ferdiansyah, 2306275052  

</div>

---


<details>
<summary><b>Assignment 1</b></summary>
<br>

# Reflection 1

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



 # Reflection 2


 **1.** Setelah membuat unit test, saya merasa cukup secure karena dapat memastikan bahwa code yang telah saya buat dapat berjalan sebagaimana mestinya. Akan tetapi, ada bagian trickynya di mana saya perlu menulis code yang relatif repetitif dan terkadang terkesan membosankan. Atau mungkin memastikan edge case jika ke depannya saya perlu melakukan unit testing terhadap function yang lebih kompleks. Lalu
 
- **Berapa banyak unit test yang diperlukan dalam suatu class?** Unit test perlu dibuat sebisa mungkin dapat melakukan coverage seluruh bagian pada class. Misalnya, untuk semua logika bisnis atau method public. Lalu, unit test untuk skenario positif dan negatif. Serta, unit test untuk berbagai kemungkinan parameter.
 
- **Bagaimana memastikan kalau unit testnya sudah cukup?** Ada code coverage yang bisa dijadikan sebagai acuan seberapa banyak code dapat dieksekusi sesuai ekspektasi. Usahakan untuk membuat unit test dengan code coverage yang tinggi. Namun demikian, tetap perlu review dari tim yang memiliki kapabilitas sebagai tester.

- **Jika code coverage mencapai 100%, apakah program bebas bug?** Belum tentu. Karena unit test hanya akan berjalan seperti yang kita perintahkan. Unit test memastikan bahwa method yang kita buat memberi output sesuai dengan ekspektasi yang kita inginkan. Akan tetapi, tetap saja ada kemungkinan bug di luar method, misalnya bug yang terjadi akibat kesalahan integrasi antarkomponen code yang tidak terdteksi unit test.

**2.** Penambahan functional test baru dengan code yang sebagian besar mirip `CreateProductFunctionalTest.java` bisa mengurangi kualitas code. Beberapa issue mengapa hal tersebut mempengaruhi kualitas code adalah sebagai berikut

- **Code Duplication:** Jika setup procedure dan instance variable kebanyakan sama, hal ini dapat mengurangi efisiensi program. Program akan memakan lebih banyak memori untuk code yang persis.
  
- **Poor Maintainability:** Misal ada perubahan yang dilakukan di instance variable, maka kita perlu mengubah dua class: `CreateProductFunctionalTest.java` dan class baru yang telah dibuat.

**Solusinya,** dapat direfactor dengan membuat base test case, misalnya `BaseFunctionalTest.java` yang berisi instance variable dan setup procedure. Lalu, `CreateProductFunctionalTest`.java dapat meng-*inherit* base test tersebut dengan ditambah method tambahan sesuai dengan testing yang akan dilakukan. Sama halnya untuk class baru, bisa langsung meng-*inherit* base test dan kemudian ditambah dengan method untuk menghitung banyaknya row/produk yang telah dibuat.

---
</details>

<details>
<summary><b>Assignment 2</b></summary>
<br>


# Reflection 

**1.** Setelah mengintegrasikan dengan Sonarcloud, ada beberapa issue yang bisa diperbaiki. Namun demikian, beberapa issue tersebut bukanlah issue yang major. Hanya perbaikan minor dan relatif cepat untuk diselesaikan. Dua di antaranya adalah:

- **Removing Unused Imports**. Sesuai dengan prinsip clean code, apabila ada import yang tidak diperlukan lebih baik dihapus saja. Kebanyakan, import yang saya hapus merupakan class dari modul yang digunakan untuk testing dan aman dihapus (karena memang tidak digunakan).
  
- **Dependency Grouping**. Hal ini juga masih berkaitan dengan clean code principle. Code akan lebih mudah terbaca dan mudah untuk direview jika dependency yang saya gunakan digroup berdasarkan fungsionalitasnya. Misalnya ada dependency grouping untuk program utama, development, ci/cd, sampai testing. Untuk masalah ini hanya perlu memperbarui satu komponen saja, yaitu `build.gradle.kts`.

**2.** Ya, implementasi sekarang saya rasa sudah cukup qualified untuk dikatakan sebagai continuous integration dan continuous development. Mari breakdown satu-satu:

- **Continuous Integration**: Di workflow saya, ada `ci.yml` yang berfungsi untuk melakukan build yang dilakukan gradle tiap kali saya melakukan `push` ke repository. Lebih lanjut, di `ci.yml` juga ada konfigurasi untuk membuat laporan JaCoCo baik secara local maupun melalui GitHub actions. Selain itu, ada juga `build.yml` yang dipakai untuk melakukan build sekaligus analisis menggunakan Sonarcloud sesuai dengan token project yand diperoleh di Sonarcloud dan yang ada pada GitHub secret. Jadi, `ci.yml` dan `build.yml` sudah memenuhi kriteria Continuous Integration.

- **Continuous Development**: Repository telah terhubung dengan Koyeb, yang akan dideploy secara otomatis setiap ada `push` pada branch `master`.

Jadi, workflow saya bisa dikatakan sudah menerapkan Continuous Integration dan Continuous Deployment.

---
</details>

<details>
<summary><b>Assignment 3</b></summary>
<br>


# Reflection 

**1.** Saya menerapkan prinsip SOLID principle dalam assignment 3. Detailnya sebagai berikut

- **SRP (Single Responsibility Principle):** Saya melakukan refactoring yang cukup ideal. Pada Tutorial 3, jika mengikuti penuh, class `CarController` diletakkan dalam satu file dengan `ProductController`. Selain itu, `CarController` juga meng-inherit `ProductController`. Isu yang saya lihat di sini adalah `CarController` unnecessarily melakukan inheritance terhadap `ProductController`, padahal keduanya menangani dua model yang berbeda yaitu `product` dan `car`. Sehingga, saya melakukan refactoring dengan memisah kedua class, memastikan bahwa tiap class hanya akan menjalankan satu responsibility major saja. 

- **OCP (Open/Closed Principle):** Daripada membuat dua interface yang kegunaannya mirip, saya menjadikan `ProductService` dan `CarService` menjadi `BaseService`. Isi dari `BaseService` merupakan setup method yang ada pada kedua services tersebut, seperti `create`, `update`, `deleteById`, `findById`, dan `findAll`. Saya masih bisa memodifikasi secara terbuka (Open) implementasi dari Base Service, misalnya menambahkan method atau variable baru pada `CarServiceImpl` dan `ProductServiceImpl`. Akan tetapi, Base Service tidak dapat dimodifikasi (Closed) karena sudah menampung semua setup method yang penting.

- **LSP (Liskov Segregation Principle):** Interface `BaseService` yang saya buat dirancang seminimal mungkin, sehingga tidak ada method yang tidak dioverride oleh class yang mengimplementasinya. Hal ini sejalan dengan Liskov Segregation Principle, di mana subclass yang dibuat (dalam hal ini implementasi dari  `CarServiceImpl` dan `ProductServiceImpl`) dapat menggantikan `BaseService` tanpa mengubah behavior `BaseService` itu sendiri dikarenakan semua yang ada pada `BaseService` diimplement dengan tepat dan efektif pada semua subclassnya.
 
- **ISP (Interface Segregation Principle):** Tidak ada pelanggaran ISP. Kasusnya sama seperti poin kedua dan ketiga. Interface `BaseService` sudah cukup efektif dan efisien, tidak ada method yang berlebihan, serta semua method yang ada pada `BaseService` memang benar-benar diperlukan.

- **DIP (Dependency Inversion Principle):** Pada controller, daripada mengimplementasi konkret class seperti `CarServiceImpl` atau `ProductServiceImpl`, saya menerapkan interface abstract `BaseService<T>`. T bisa berupa model car maupun product. Hal ini sejalan dengan prinsip Dependency Inversion Principle, di mana modul tingkat tinggi seharusnya bergantung pada abstraksi, bukan modul tingkat rendah.

**2.** Setelah menerapkan SOLID principle, codebase project saya terasa jadi lebih rapi dan lebih mudah untuk dimaintain. misalnya dengan menerapkan `BaseSrevice`
```java
package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.List;

public interface BaseService<T> {
    T create(T item);
    List<T> findAll();
    T findById(String id);
    void update(String Id, T item);
    void deleteById(String id);
}
```
saya tidak perlu membuat dua code interface yang berbeda untuk model product dan car. Sehingga, pekerjaan jadi lebih mudah. Terlebih, jika ke depannya akan ada model tambahan, saya hanya perlu membuat implementasinya saja untuk model tersebut. 

Selain itu, prinsip SOLID juga saya terapkan di Controller, di mana saya memisahkan controller untuk product dan car. Hal ini membuat readablity meningkat. Menghilangkan dependency yang kurang diperlukan (seperti `CarController` menginherit `ProductController`) juga akan 'menyelamatkan' saya dari beberapa problem yang tidak diinginkan ke depannya.

**3.** Andai saya tidak menerapkan SOLID, salah satu disadvantage yang cukup terasa adalah mengenai modul `service`. Jika saya membuat implementasi untuk model yang baru, saya perlu membuat interface untuk masing-masing model, bahkan jika setup methodnya relatif sama. Hal ini akan membuat pekerjaan terasa lebih lama dan melelahkan. Selain itu, misal `CarController` tetap menjadi subclass `ProductController`, hal ini bisa mengurangi maintainability. Walaupun tidak ada method yang dioverride, akan tetapi kita bisa melakukan pemanggilan method yang sebenarnya hanya untuk model product melalui controller model car. Hal ini kurang diinginkan dan perlu dihindari. Sehingga, overall jika saya tidak menerapkan SOLID, code yang saya buat akan lebih susah dimaintain daripada code yang sekarang.

</details>
