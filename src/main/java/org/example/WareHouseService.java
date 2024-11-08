package org.example;

import java.util.*;


public class WareHouseService {
    public static Scanner input;
    static int id;
    static HashMap<Integer, ProductPOJO> wareHouseService;

    ProductPOJO nesne = new ProductPOJO("un", "hekimoglu", 100, "kg", "kenar");

    Scanner input = new Scanner(System.in);//kullanicidan girdi almak icin
    private long idCounter = 1000;  // Otomatik ID üretimi için
    private Map<Integer, ProductPOJO> products = new HashMap<>();//urunler buraya dolacak
    ProductPOJO nesne = new ProductPOJO(123, "un", "hekimoglu", 100, "kg", "kenar");

    private static Map<Integer, ProductPOJO> deneme = new HashMap<>();
    //9 ve 10 Satir Deneme Icin Olusturuldu Dikkate Almayiniz


    HashMap<Integer, Integer> shelfMap = new HashMap<>();
    int shelfCount = 10;
    int shelfCapacity = 100;
    private int QuantitytoAdd;

    public WareHouseService() {
        // Tüm rafları başlangıçta 0 dolulukla başlatıyoruz
        for (int i = 1; i <= shelfCount; i++) {
            shelfMap.put(i, 0);
        }
    }

    public void mainMenu() {

        // Scanner input = new Scanner(System.in);

        //Scanner input = new Scanner(System.in);

        int secim;

        do {
            System.out.println("Ana Menü");
            System.out.println("1. Ürün Tanımla");
            System.out.println("2. Ürünleri Listeleme");
            System.out.println("3. Yeni Ürün Girişi");
            System.out.println("4. Raf Atama");
            System.out.println("5. Ürün Çıkışı");
            System.out.println("0. Çıkış");
            System.out.print("Lütfen bir seçenek girin: ");

            secim = input.nextInt();
            // input.nextLine(); // Buffer temizleme

            switch (secim) {
                case 1:
                    productDefine();
                    break;
                case 2:
                    productView();
                    break;
                case 3:
                    newProduct();
                    break;
                case 4:
                    shelfAssign();
                    break;
                case 5:
                    outOfProduct();
                    break;
                case 0:
                    System.out.println("Çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        } while (secim != 0);
        //------Depo Giris Ekranidir Secimlerin Yapilmasi ve Islemlerin Baslatilmasi bu Kisimda Kodlanacaktir.
        //Tasarim Kismi Bu Kisimda Olacak Yapilinca Toplu Bir Sekilde Bura Tasarimi Uzerinde Tartisilacak
        //Ozel Kutuphaneler Ile Bu Ana Ekran Suslenebilir - Amac Konsolun Goze Hitap Etmesi
        //----YAPACCAK KISILER: ------- todo:Fatih ,Edip
    }

    public void selectedValue() {
        //-----Kullanicidan Degerin Surekli Alinabilmesi Icin Dongu Olusturulmali
        //----YAPACCAK KISILER: ------- todo:Fatih ,Edip
    }

    public void productDefine() {
        //----urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
        // MAP<id,pojoUrun>   RAF="-" ve Miktar=0 //arraylist. default olarak raf ve miktar atamalari burda yapilacak
        //id ilk urun kaydinda otomatik kaydedilecek --id BEZERSIZ OLMALI
        //----YAPACCAK KISILER: ------- todo: Emircan, Aysegul
        input.nextLine();
        System.out.print("Bir ürün giriniz : ");
        String ürünİsmi = input.nextLine();
        System.out.print("Ürünün üreticisi : ");
        String üreticisi = input.nextLine();
        int miktar = 0;
        System.out.print("Ürünün birimini giriniz : ");
        String birim = input.nextLine();
        String raf = "-";
        boolean mevcutMu = wareHouseService.values().stream()
                .anyMatch(product -> product.getUrunIsmi().equals(ürünİsmi) && product.getUretici().equals(üreticisi));

        if (mevcutMu) {
            System.out.println("Bu ürün ve üretici zaten mevcut!");
            productDefine();
        } else {
            ProductPOJO productPOJO = new ProductPOJO(ürünİsmi, üreticisi, miktar, birim, raf);

            wareHouseService.put(id, productPOJO);
            int var10001 = id;
            System.out.println("\tID: " + var10001 + " " + wareHouseService.get(id));
            id++;

            System.out.println("Ürün eklemeye devam etmek ister misiniz? E/H girin!");
            String cevap = input.next().toUpperCase();
            if (cevap.equals("E")) {
                this.productDefine();
            }
        }
    }



    // productView() start -----------------------------------------------------
    /** Ürün listeleme  - Belkis - Neval */
    public void productView() {
        // Başlık çizgisi
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("\033[1;37m%-4s \033[1;32m| %-20s \033[1;33m| %-15s \033[1;34m| %-10s \033[1;35m| %-9s \033[1;36m| \033[1;37m%-5s \n",
                "ID", "PRODUCT NAME", "MANUFACTURER", "AMOUNT", "UNIT TYPE", "SHELF");
        System.out.println("-------------------------------------------------------------------------------------");

        if (products.isEmpty()) {
            // Ürün yoksa mesaj
            System.out.println("Depoda ürün bulunmuyor.");
        } else {
            // Ürün bilgilerini farklı renklerde listelemek
            products.values().forEach(product -> {
                System.out.printf("\033[1;31m%-4s \033[1;32m| \033[1;33m%-20s \033[1;34m| \033[1;35m%-15s \033[1;36m| \033[1;37m%-10s \033[1;38m| \033[1;39m%-9s \033[1;37m| %-5s \n",
                        product.getId(),
                        product.getUrunIsmi(),
                        product.getUretici(),
                        product.getMiktar(),
                        product.getBirim(),
                        product.getRaf());
            });
        }

        System.out.println("-------------------------------------------------------------------------------------");
    }
    // productView() end -------------------------------------------------

    public void newProduct() {
        // urunGirisi      ==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.

        //id ye gore urun aramasi yapilip---DIKKAT burda id olup olmadigi kontrol edilecek
        // try-catch ile urun id int disinda girilmesi gibi olusabilecek hatalar yakalanacak
        // oncelikle veri girilecek urun id kullanicidan istenip id ye gore urun miktar kaydi yapilacak

        //----YAPACCAK KISILER: ------- todo: Tayfun, Ibrahim
        System.out.print("Lütfen Miktar Güncellemesi Yapacaginiz Urun id Giriniz: ");
        int idFromUser = input.nextInt();
        ;
        // todo: do while ile kodun surekliligi saglanacak
        try {
            if (idFromUser > 100 && idFromUser < 110) {
                if (deneme.containsKey(idFromUser)) {
                    System.out.print("Lütfen Eklenecek Miktarı Giriniz: "); //todo: miktarin gecerliligi kontrol edilecek
                    int miktar = input.nextInt();
                    deneme.get(idFromUser).setMiktar(deneme.get(idFromUser).getMiktar() + miktar);
                    productView();
                } else {
                    System.out.println("Bu ID'ye sahip ürün bulunamadı.");
                }
            } else {
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
            }
        } catch (InputMismatchException e) {
            System.err.println("Hatalı giriş! Lütfen bir sayı giriniz.");
        }
    }

    public void shelfAssign() {
        // rafa koyma methodu dinamik olacak urun kaydi yapildiginda raf default ayara cekilecek
        //raf sayimiz 10 olarak belirlenecek --> her raf bir urun alacagi icin dolu raflar ustune eklenmemeli
        //bos raflar  liste halinde musteriye gosterilecek - musteri bos olan raflardan birini sececek
        //burdada olusabilecek hatalari kontrol etmemiz gerek try-catch
        //urunuRafaKoy    ==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.

        //----YAPACCAK KISILER: ------- todo: Mustafa, Zeynep


        deneme.put(123, new ProductPOJO("un", "hekimoglu", 100, "kg", "kenar"));

        // Tüm rafları başlangıçta 0 dolulukla başlatmak icin
        for (int i = 1; i <= shelfCount; i++) {
            shelfMap.put(i, 0);
        }
        // Raf doluluk durumunu göstermek için
        System.out.println("\n---- Raf Durumu ----");
        for (int i = 1; i <= shelfCount; i++) {
            int currentQuantity = shelfMap.getOrDefault(i, 0); // Null olmaması için varsayılan 0 değeri
            System.out.println("Raf " + i + ": " + currentQuantity + "/" + shelfCapacity);
        }
        int idFromUser = -1; // Geçici başlangıç değeri
        while (true) {
            System.out.print("Lütfen bir ürün ID numarası girin: ");
            try {

                idFromUser = input.nextInt();
                // ID'nin geçerli olup olmadığını kontrol et
                if (deneme.containsKey(idFromUser)) {
                    System.out.println("Geçerli bir ID girdiniz.");
                    break; // Geçerli bir ID girildiğinde döngüden çık
                } else {
                    System.out.println("Geçersiz bir ID numarası girdiniz. Lütfen tekrar deneyin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı giriniz.");
                input.nextLine(); // Scanner'daki hatalı girdiyi temizler
            }
        }
        // Hangi rafa atamak istediğini almak
        int selectedShelf = -1; // Geçici başlangıç değeri ,-1 genel olarak "atanmamış" anlamını taşıdığı için
        while (true) {
            System.out.print("Lütfen ürün atamak istediğiniz raf numarasını seçin: ");
            try {
                selectedShelf = input.nextInt();

                // Raf numarasının geçerli olup olmadığını kontrol et
                if (selectedShelf >= 1 && selectedShelf <= shelfCount) {
                    System.out.println("Geçerli bir raf numarası girdiniz.");
                    break; // Geçerli bir raf numarası girildiğinde döngüden çık
                } else {
                    System.out.println("Geçersiz raf numarası. Lütfen 1 ile " + shelfCount + " arasında bir numara girin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı giriniz.");
                input.nextLine(); // Scanner'daki hatalı girdiyi temizle
            }
        }
        // Rafın doluluk durumunu alın
        int currentQuantity = shelfMap.getOrDefault(selectedShelf, 0);


        // Miktar girmek için
        int quantityToAdd = 0; // Geçici baslangıc miktar değişkeni
        boolean validQuantityInput = false; // Geçerli miktar kontrolü

        while (!validQuantityInput) {
            System.out.print("Eklemek istediğiniz ürün miktarını girin: ");
            try {
                quantityToAdd = input.nextInt(); // Kullanıcıdan miktar al
                // Kapasiteyi kontrol et ve ekle
                if (currentQuantity + quantityToAdd > shelfCapacity) {
                    System.out.println("Hata: Bu kadar ürün eklemek kapasiteyi aşar! Mevcut kapasite: " + (shelfCapacity - currentQuantity));
                    System.out.print("Lütfen mevcut raf kapasitesine göre bir miktar giriniz: ");
                } else {
                    // Rafı güncelle
                    shelfMap.put(selectedShelf, currentQuantity + quantityToAdd);
                    System.out.println("Ürün başarıyla eklendi. Raf " + selectedShelf + " şu anda " + shelfMap.get(selectedShelf) + "/" + shelfCapacity + " dolu.");
                    validQuantityInput = true; // Geçerli miktar alındı, döngüden çık
                }
            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş! Lütfen bir sayı giriniz."); // Hata mesajı
                input.nextLine(); // Hatalı girişi temizle
            }
        }
    }


    /** Ürün çıkışı Belkis - Merve */

    public void outOfProduct() {
        //yetersiz stok uyarısı alma istemiyorum.
        //stoktaki ürünleri göstersin sadece böyle bir tercih seçeneği sunalım
        //outOfProduct yapabilmem için ürünleri görmem gerekiyor. ürünleri göstersin
        //id üzerinden işlem yapacağız
        //ürün çıkışı olduktan sonra güncel miktarı söylesin. stok bitti ise söylesin.

        productView();//urun listeleme methodunu cagirdim. kullanicidan ID istiyor o yuzden liste gormem lazim. buyuk bir proje olsa olmaz

        System.out.print("Ürün ID: ");
        Long id = input.nextLong();//id aldım
        //id kontrol
        System.out.print("Çıkarılacak miktar: ");
        int miktar = input.nextInt();//miktar aldım
        ProductPOJO product = products.get(id);//verilen id li urunu getirdim ve product olarak kaydettim

        if (product != null) {//null degilse
            if (product.getMiktar() >= miktar) {//miktar verilen miktardan buyukse
                product.setMiktar(product.getMiktar() - miktar);//miktari guncelliyorum
                System.out.println("Ürün çıkışı yapıldı: " + product);
            } else {
                System.out.println("Yetersiz stok. Çıkış yapılamadı. Ürün çıkışı yapabilmek için geçerli bir miktar giriniz.");
            }
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }
    static {
        input = new Scanner(System.in);
        id = 100;
        wareHouseService = new HashMap<>();
    }

    }

