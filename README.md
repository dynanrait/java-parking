# java-parking
This is simple Application java for parking.  not use framework 

pada aplikasi ada beberapa menu utama
1. input manual
2. input by file

pada input manual ada 5 submenu
1. Register car number to parking slot -- > Register mobil ke dalam slot parking
2. Leave Parking --> set parking menjadi available
3. Status --> menampilkan semua status slot parking 
4. Create Parking Slot --> membuat slot parking
5. Search 
pada menu search ada menu
1. search by no registratiom
2. search by color

Rules input manual
pada saat sistem berjalan yang terlebih dahulu bisa kita lakukan adalah kita memilih input manual atau input by file. pada saat input manual kita pilih maka kita harus membuat slot parking terlebih dahulu (sub menu no 4 create parking slot) jika kita belum membuat parking slot
kita tidak bisa registrasi mobil ke dalam parking. dan setelah parking dibuat maka kita bisa melakukan semuanya diantarnya registrasi mobil
ke slot parkir, melihat status, leave parking dan search
 
Rules input by file
sama seperti diatas namun bedanya kita melakukan create parking, leave parking, dan register mobil ke parking lewat file. jadi kita harus membuat file terlebih dahulu. saya menyediakan 3 format file
1. file.txt --> untuk register mobil
2. file2.txt --> untuk create slot parking
3. file3.txt --> untuk leave parking (mengubah status parkir menjadi available)

pada file saya memakai format file 
1. H(Header)
2. D(Detail)
aplikasi nantinya akan membaca data yang ada di detail. header dibuat agar nantinya file mudah dimodifikasi apabila format berubah

status parkir 
1. available (slot parking masih tersedia)

