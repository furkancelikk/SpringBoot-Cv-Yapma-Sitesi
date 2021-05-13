Tek kullanıcı tablosu bulunmaktadır. Tablo içerisinde kullanıcının admin/user rolü belirlenmektedir.

MySQl içerisinde db_cv isimli bir database oluşturulup örnek veri girişleri import edildikten sonra sistem ayağa kaldırılabilir.

Ya da isteğe bağlı bir isimde database oluşturulacaksa projenin application.properties dosyasında database adı db_cv ile değiştirilmelidir. 
Daha sonra ise manuel olarak admin kullanıcısı oluşturulmalıdır. Manuel olarak kaydedilecek kullanıcıların mail adreslerinde @ sembolü bulunmalı, şifreleri ise
Bcrypt olarak kriptolandıktan sonra girilmelidir.

Kullanıcılar (admin dahil) sisteme mail ile giriş yapabilmektedirler.
Örnek verilerde admin kullanıcının
	mail adresi: admin@admin
	şifre: admin
bilgileri ile girildikten sonra sistemdeki diğer kullanıcıların hazırlamış oldukları cv bilgileri görülebilir.

Örnek verilerdeki user rolü olan tüm kullanıcıların şifreleri 123 olarak kaydedilmiştir. Veritabanında ise kriptolu şekilde bulunmaktadır.