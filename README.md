# ❌ Tic-Tac-Toe - AI Edition ⭕

Java Swing kullanılarak geliştirilmiş, modern görünümlü ve akıllı yapay zeka katmanlarına sahip gelişmiş bir XOX oyunudur.

## 📸 Oyun Önizleme
![Tic-Tac-Toe Screen Shot](assets/screenshoot.png)

## 📺 Oynanış ve Yapay Zeka Sunumu
Oyunun mekaniklerini, zorluk seviyelerini ve yapay zekanın nasıl karar verdiğini aşağıdaki videodan izleyebilirsiniz:

[![Tic-Tac-Toe AI Showcase](https://img.youtube.com/vi/nnTUuMH7STU/maxresdefault.jpg)](https://www.youtube.com/watch?v=nnTUuMH7STU)

> *Görsele tıklayarak YouTube üzerinden izleyebilirsiniz.*

## 🚀 Öne Çıkan Özellikler
- **Gelişmiş Bot Mekanikleri:** Üç farklı zorluk seviyesi (`Easy`, `Medium`, `Hard`) ile dinamik oyun deneyimi.
- **Akıllı Hamle Hiyerarşisi:** Botlar sadece rastgele oynamaz; galibiyet fırsatlarını, savunma gereksinimlerini ve stratejik konumları (Merkez ve Köşeler) analiz eder.
- **Probabilistic (Olasılıksal) Yapay Zeka:** Kolay ve Orta modlarda botlar her zaman mükemmel oynamaz, insan benzeri "hata yapma" payı bırakır.
- **Şık Arayüz:** Özel arka plan, ikonlar, transparan butonlar ve akıcı bir kullanıcı arayüzü.
- **Esnek Oyun Modları:** İster yapay zekaya karşı, ister aynı bilgisayardan bir arkadaşına karşı (P2P) oyna.

## 📥 Hemen Oyna (İndir)
Kodlarla uğraşmadan oyunu doğrudan bilgisayarında çalıştırmak istersen, hazır `.jar` dosyasını aşağıdan indirebilirsin:

[**📥 Tic-Tac-Toe v1.0.jar Dosyasını İndir**](https://github.com/mcanerarslan/tick-tack-toe-java-swing/releases/tag/v1.0)

## 🧠 Yapay Zeka Nasıl Çalışır?
Botun karar verme süreci şu hiyerarşiyi takip eder:

| Öncelik | Seviye | Mantık |
| :--- | :--- | :--- |
| **1. Galibiyet** | Hepsi | Eğer bir hamlede kazanabiliyorsa o kareyi doldurur. |
| **2. Savunma** | Hepsi | Rakip (X) kazanmak üzereyse o yolu kapatır. |
| **3. Strateji** | Hard | Tahtanın en değerli noktası olan **Merkez**'i kapmaya çalışır. |
| **4. Pozisyon** | Hard | Köşelere yerleşerek rakibi kıskaca alır. |
| **5. Rastgele** | Hepsi | Hiçbir kritik hamle yoksa kalan boş karelerden birini seçer. |

## 🛠️ Teknik Detaylar
- **Enum Bazlı Mimari:** `BotMechanics` enum yapısı sayesinde zorluk seviyeleri arasında kod tekrarı yapmadan geçiş sağlanır.
- **Timer Kullanımı:** Botun hamleleri arasında `700ms` gecikme eklenerek gerçekçi bir "düşünme" efekti yaratıldı.
- **Sanal Board Analizi:** `winNextMove` fonksiyonu, asıl tahtayı bozmadan tüm ihtimalleri sanal bir matris üzerinde simüle eder.

---
**Geliştirici:** Mahmut Caner Arslan