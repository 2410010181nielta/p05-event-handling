# p05-event-handling

Tugas 5 - Event Handling, Pemrograman Berbasis Objek 2 (TIF1508).
Nama: Haura Nielta Azkiya | NPM: 2410010181

Isi proyek (package `id.ac.uniska.pbo2.p05`):

| Kelas | Keterangan |
|---|---|
| `PengamatEvent` | Praktikum 2, mengamati event |
| `KonverterSuhu` | Praktikum 3, logika konversi tanpa GUI |
| `KonversiSuhu` | Praktikum 3, form konversi suhu |
| `KalkulatorSederhana` | Praktikum 4, tiga cara menghubungkan event |
| `FormAnggotaPerpustakaan` | Latihan mandiri, form dengan event (kumpulan utama) |

Setiap form memiliki file `.java` dan `.form`.

## 1. Tabel Pengamatan Praktikum 2

| No | Tindakan | Event yang tercatat |
|---|---|---|
| 1 | Arahkan kursor ke tombol, lalu jauhkan | `MouseEvent` kursor masuk ke tombol, lalu `MouseEvent` kursor keluar dari tombol |
| 2 | Klik tombol Klik saya | `MouseEvent` kursor masuk ke tombol (saat kursor tiba), lalu `ActionEvent` tombol diklik |
| 3 | Centang lalu hapus centang Aktifkan fitur | `ItemEvent` kotak dicentang, lalu `ItemEvent` centang dihapus |
| 4 | Ganti pilihan dari Pagi menjadi Malam | `ItemEvent` memilih Malam (hanya satu baris, karena DESELECTED disaring) |
| 5 | Klik isian, lalu ketik kata "abc" | `FocusEvent` isian mendapat fokus, lalu tiga `KeyEvent` mengetik huruf a, b, c |
| 6 | Klik tombol setelah mengetik di isian | `MouseEvent` kursor masuk ke tombol, `FocusEvent` isian kehilangan fokus, lalu `ActionEvent` tombol diklik |

## 2. Jawaban Eksperimen Praktikum 3 (KonversiSuhu)

1. **Tanpa pemeriksaan `SELECTED`, berapa kali pesan tercetak?** Dua kali setiap pilihan diganti: sekali untuk pilihan lama (`DESELECTED`) dan sekali untuk pilihan baru (`SELECTED`).
2. **Mengapa hasil terlambat satu karakter dengan `keyPressed`?** `keyPressed` dipicu saat tombol ditekan, sebelum karakternya dimasukkan ke isian. Jadi `getText()` masih berisi teks sebelum ketikan terbaru. `keyReleased` dipicu setelah tombol dilepas, saat karakter sudah masuk ke isian.
3. **Tanpa `try` dan `catch`, apa yang muncul di Output?** `Double.parseDouble` melempar `NumberFormatException` (misalnya `For input string: "a"`). Stack trace tercetak di jendela Output dari thread `AWT-EventQueue-0`. Aplikasi tidak tertutup, tetapi `hasilLabel` tidak diperbarui dan pengguna tidak mendapat umpan balik.

## 3. Jawaban Eksperimen Praktikum 4 (KalkulatorSederhana)

1. **Event `kaliButton` dari Events plus lambda di konstruktor:** pesan "kali" tercetak dua kali (satu dari lambda, satu dari event handler GUI Builder), karena dua listener terdaftar pada tombol yang sama. Satu tombol sebaiknya memakai satu cara agar aksi tidak berjalan ganda, hasil tidak membingungkan, dan kode mudah dilacak.
2. **Menambahkan tombol `%`:**
   - Tab Design: tambahkan tombol `%` (misalnya `modButton`) ke `operatorPanel`, ubah Columns Grid Layout dari 4 menjadi 5, lalu buat event `actionPerformed` melalui Events.
   - Tab Source: isi `modButtonActionPerformed` dengan `hitung('%');`, tambahkan `case '%' -> a % b;` pada `switch`, dan ubah pemeriksaan nol menjadi `(operator == '/' || operator == '%') && b == 0`.
3. **Mengapa kursor langsung di isian pertama setelah Hapus?** Karena method `hapus` memanggil `angka1Field.requestFocusInWindow()` setelah mengosongkan isian.

## 4. Peta Event FormAnggotaPerpustakaan

| Komponen | Menu Events | Method | Aksi |
|---|---|---|---|
| `setujuCheck` (kotak centang) | Item: `itemStateChanged` | `setujuCheckItemStateChanged` | Tombol Daftar hanya aktif jika dicentang |
| `batalButton` | Action: `actionPerformed` | `batalButtonActionPerformed` | Mengosongkan semua isian dan mengembalikan fokus ke NPM (lewat method `kosongkan()`) |
| `daftarButton` | Action: `actionPerformed` | `daftarButtonActionPerformed` | Menampilkan ringkasan data dengan `JOptionPane` |
| `npmField` | Key: `keyReleased` | `npmFieldKeyReleased` | Label `jumlahDigitLabel` menampilkan jumlah digit, misalnya "8 dari 10 digit" (lewat method `perbaruiJumlahDigit()`) |
| Form (JFrame di Navigator) | Window: `windowClosing` | `formWindowClosing` | Meminta konfirmasi sebelum aplikasi ditutup |

Pengaturan Properties: `defaultCloseOperation` = `DO_NOTHING` dan `enabled` pada `daftarButton` tidak dicentang.

## 5. Tangkapan Layar

Jendela Properties bagian Events untuk tombol Daftar:

![Properties Events tombol Daftar](docs/properties-events-daftar.png)

Dialog ringkasan:

![Dialog ringkasan](docs/dialog-ringkasan.png)

Dialog konfirmasi keluar:

![Dialog konfirmasi keluar](docs/dialog-konfirmasi-keluar.png)

## 6. Deklarasi Penggunaan AI

saya menggunakan ai untuk membantu saya mengerjakan atau mencari dimana letak yang saya tidak tahu
