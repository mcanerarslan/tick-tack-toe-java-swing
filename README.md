# ❌ Tic-Tac-Toe - AI Edition ⭕

Java Swing kullanılarak geliştirilmiş, modern görünümlü ve akıllı yapay zeka katmanlarına sahip gelişmiş bir XOX oyunudur.

## 🚀 Öne Çıkan Özellikler

- **Gelişmiş Bot Mekanikleri:** Üç farklı zorluk seviyesi (`Easy`, `Medium`, `Hard`) ile dinamik oyun deneyimi.
- **Akıllı Hamle Hiyerarşisi:** Botlar sadece rastgele oynamaz; galibiyet fırsatlarını, savunma gereksinimlerini ve stratejik konumları (Merkez ve Köşeler) analiz eder.
- **Probabilistic (Olasılıksal) Yapay Zeka:** Kolay ve Orta modlarda botlar her zaman mükemmel oynamaz, insan benzeri "hata yapma" payı bırakır.
- **Şık Arayüz:** Özel arka plan, ikonlar, transparan butonlar ve akıcı bir kullanıcı arayüzü.
- **Esnek Oyun Modları:** İster yapay zekaya karşı, ister aynı bilgisayardan bir arkadaşına karşı (P2P) oyna.

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