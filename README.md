# AutomationPomProject
AutomationPomProject, bir POM (Page Object Model) yapısı kullanarak Selenium WebDriver kullanarak otomasyon testleri oluşturma örneğidir. Bu proje, Java programlama dili, Selenium WebDriver, TestNG ve Log4j gibi bir dizi farklı teknolojiyi kullanmaktadır.

Bu proje, [Demoqa](https://demoqa.com) web sitesindeki senaryoları içerir.

## Kullanılan Teknolojiler
- Java 8
- Selenium WebDriver
- TestNG
- Log4j

## Kurulum
Projenin kopyalanması:
```
git clone https://github.com/MelihDemirtel/AutomationPomProject.git
```

1. Projeyi GitHub'dan indirin veya kopyalayın.

2. Java Development Kit'i yükleyin.

3. Projenin bağımlılıklarını indirin. Bu projenin bağımlılıkları, pom.xml dosyasında listelenmiştir. Maven, projenin bağımlılıklarını indirmek için kullanılabilir.

4. Proje dosyalarını bir Java IDE'sinde açın.

## Kullanım
Projenin kurulumundan sonra, aşağıdaki adımları izleyerek senaryoları çalıştırabilirsiniz:

### 1. Testleri çalıştırmak:
   ***src/test/stepDefinitions*** dizininden çalıştırabilirsiniz.

### 2. Test Fail Durumu:
Testiniz fail olursa terminalden hata mesajını görüntüleyebilir ve ***src/test/screenShots*** dosyasında hata ekran görüntüsünü görebilirsiniz.


## Katkıda Bulunma
Herhangi bir hata veya öneriniz varsa, lütfen Github üzerinden issue açın veya pull request gönderin.

Teşekkürler!

## Lisans
Bu proje MIT lisansı altında lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakınız.

# Sürüm Bilgileri

## Sürüm 1.0
- İlk sürüm yayınlandı.

## Sürüm 1.1
- Test senaryoları güncellendi.

- Hata düzeltmeleri yapıldı.

- README.md dosyası güncellendi.

## Sürüm 1.2
- pages paketinin altına "Text Box Page", "Forms Page" eklendi.

## Sürüm 1.3
- pages paketinin altına "AlertsFrameWindows Page", "Interactions Page, Widgets Page" eklendi.
- HomePage sayfası elementleri tanımlandı ve test fonksiyonları yazıldı.
- TextBoxPage sayfası elementleri tanımlandı ve test fonksiyonları yazıldı.
- Test sınıfının içine @BeforeMethod anatasyonu eklendi.
- Test sınıfının içine TextBoxPage senaryoları eklendi.

## Sürüm 1.4
- Tüm sayfalara logger eklendi. Test şablonundaki loglar page'lere taşındı ve görsel karışıklık düzeltildi.
- pages paketinin altına "ChekBoxPage" eklendi.
- testCheckBoxPage adımları eklendi.

## Sürüm 1.5
- pages paketinin altına "RadioButtonPage" eklendi.
- testRadioButtonPage adımları eklendi.
- Selenium sürümü güncellendi. (4.11.0)
- TestNG sürümü güncellendi. (7.7.1)

## Sürüm 1.6
- pages paketi altında yeni sayfa paketleri oluşturuldu ve ilgili sayfa sınıfları kendi paket isimlerine göre içine taşındı.
- elements paketi altına WebTablesPage eklendi.
- Test sınıfına testWebTablesPage adımları eklendi.

## Sürüm 1.7
- log4j sürümü güncellendi 2.x olarak yapılandırıldı
- pom dosyasında log4j bağımlılıkları güncellendi
- properties dosyası XML formatına güncellendi(log4j2.x XML desteklediği için)
- Log4j 1.x: org.apache.log4j.Logger sınıfı ve
- Log4j 2.x: org.apache.logging.log4j.LogManager ve 
- org.apache.logging.log4j.Logger sınıfları olarak güncellendi.