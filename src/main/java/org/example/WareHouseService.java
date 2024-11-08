package org.example;

import java.util.*;


public class WareHouseService {
    public static Scanner input;
    static int id;
    static HashMap<Integer, ProductPOJO> wareHouseService;

    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String BLUE = "\u001B[34m";
    //final String PURPLE = "\u001B[35m";
    final String CYAN = "\u001B[36m";

    HashMap<Integer, Integer> shelfMap = new HashMap<>();
    int shelfCount = 10;
    int shelfCapacity = 100;
    private int QuantitytoAdd;

    public void mainMenu() {

        // Scanner input = new Scanner(System.in);
        selectedValue();
        //------Depo Giris Ekranidir Secimlerin Yapilmasi ve Islemlerin Baslatilmasi bu Kisimda Kodlanacaktir.
        //Tasarim Kismi Bu Kisimda Olacak Yapilinca Toplu Bir Sekilde Bura Tasarimi Uzerinde Tartisilacak
        //Ozel Kutuphaneler Ile Bu Ana Ekran Suslenebilir - Amac Konsolun Goze Hitap Etmesi
        //----YAPACCAK KISILER: ------- todo:Fatih ,Edip
    }

    public void selectedValue() {
        //-----Kullanicidan Degerin Surekli Alinabilmesi Icin Dongu Olusturulmali
        //----YAPACCAK KISILER: ------- todo:Fatih ,Edip

        int secim;

        do {
            //System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(RED + "       MAIN MENU" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(CYAN + "|" + GREEN + "    1. Product Define   " + CYAN + "|" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(CYAN + "|" + GREEN + "    2. Product View     " + CYAN + "|" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(CYAN + "|" + GREEN + "    3. New Product      " + CYAN + "|" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(CYAN + "|" + GREEN + "    4. Shelf Assign     " + CYAN + "|" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(CYAN + "|" + GREEN + "    5. Out of Product   " + CYAN + "|" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.println(CYAN + "|" + BLUE + "    0. Exit             " + CYAN + "|" + RESET);
            System.out.println(CYAN + "--------------------------" + RESET);
            System.out.print(YELLOW + "Please Select an Option: " + RESET);

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
                    System.out.println(RED + "Exiting..." + RESET);
                    break;
                default:
                    System.out.println(RED + "Invalid Selection Please Try Again" + RESET);
            }
        } while (secim != 0);
    }

    public void productDefine() {
        //----urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
        // MAP<id,pojoUrun>   RAF="-" ve Miktar=0 //arraylist. default olarak raf ve miktar atamalari burda yapilacak
        //id ilk urun kaydinda otomatik kaydedilecek --id BEZERSIZ OLMALI
        //----YAPACCAK KISILER: ------- todo: Emircan, Aysegul

        String cevap = "E";

        while (cevap.equals("E")) {
            input.nextLine();
            System.out.print(GREEN + "Bir ürün giriniz : " + RESET);
            String ürünİsmi = input.nextLine();
            System.out.print(GREEN + "Ürünün üreticisi : " + RESET);
            String üreticisi = input.nextLine();
            int miktar = 0;
            System.out.print(GREEN + "Ürünün birimini giriniz : " + RESET);
            String birim = input.nextLine();
            String raf = "-";
            boolean mevcutMu = wareHouseService.values().stream()
                    .anyMatch(product -> product.getUrunIsmi().equals(ürünİsmi) && product.getUretici().equals(üreticisi));

            if (mevcutMu) {
                System.out.print(GREEN + "Bu ürün ve üretici zaten mevcut!" + RESET);
                productDefine();
            } else {
                ProductPOJO productPOJO = new ProductPOJO(ürünİsmi, üreticisi, miktar, birim, raf);

                wareHouseService.put(id, productPOJO);
                int var10001 = id;
                System.out.println("\tID: " + var10001 + " " + wareHouseService.get(id));
                id++;

                System.out.print(GREEN + "Ürün eklemeye devam etmek ister misiniz?(E/H) " + RESET);
                cevap = input.next().toUpperCase();
            }
        }

        /*
        input.nextLine();
        System.out.print(GREEN + "Bir ürün giriniz : " + RESET);
        String ürünİsmi = input.nextLine();
        System.out.print(GREEN + "Ürünün üreticisi : " + RESET);
        String üreticisi = input.nextLine();
        int miktar = 0;
        System.out.print(GREEN + "Ürünün birimini giriniz : " + RESET);
        String birim = input.nextLine();
        String raf = "-";
        boolean mevcutMu = wareHouseService.values().stream()
                .anyMatch(product -> product.getUrunIsmi().equals(ürünİsmi) && product.getUretici().equals(üreticisi));

        if (mevcutMu) {
            System.out.print(GREEN + "Bu ürün ve üretici zaten mevcut!" + RESET);
            productDefine();
        } else {
            ProductPOJO productPOJO = new ProductPOJO(ürünİsmi, üreticisi, miktar, birim, raf);

            wareHouseService.put(id, productPOJO);
            int var10001 = id;
            System.out.println("\tID: " + var10001 + " " + wareHouseService.get(id));
            id++;

            System.out.print(GREEN + "Ürün eklemeye devam etmek ister misiniz? E/H girin! " + RESET);
            String cevap = input.next().toUpperCase();
            if (cevap.equals("E")) {
                this.productDefine();
            }
        }
        */

    }


    // productView() start -----------------------------------------------------

    /**
     * Ürün listeleme  - Belkis - Neval
     */
    public void productView() {
        // Başlık çizgisi
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("\033[1;37m%-4s \033[1;32m| %-20s \033[1;33m| %-15s \033[1;34m| %-10s \033[1;35m| %-9s \033[1;36m| \033[1;37m%-5s \n",
                "ID", "PRODUCT NAME", "MANUFACTURER", "AMOUNT", "UNIT TYPE", "SHELF");
        System.out.println("-------------------------------------------------------------------------------------");

        if (wareHouseService.isEmpty()) {
            // Ürün yoksa mesaj
            System.out.println("Depoda ürün bulunmuyor.");
        } else {
            // Ürün bilgilerini farklı renklerde listelemek
            wareHouseService.values().forEach(product -> {
                System.out.printf("\033[1;31m%-4s \033[1;32m| \033[1;33m%-20s \033[1;34m| \033[1;35m%-15s \033[1;36m| \033[1;37m%-10s \033[1;38m| \033[1;39m%-9s \033[1;37m| %-5s \n",
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
        System.out.print(GREEN + "Lütfen Miktar Güncellemesi Yapacaginiz Urun id Giriniz: " + RESET);
        int idFromUser = input.nextInt();
        // todo: do while ile kodun surekliligi saglanacak
        try {
            if (idFromUser > 100 && idFromUser < 110) {
                if (wareHouseService.containsKey(idFromUser)) {
                    System.out.print(GREEN + "Lütfen Eklenecek Miktarı Giriniz: " + RESET); //todo: miktarin gecerliligi kontrol edilecek
                    int miktar = input.nextInt();
                    wareHouseService.get(idFromUser).setMiktar(wareHouseService.get(idFromUser).getMiktar() + miktar);
                    productView();
                } else {
                    System.out.print(GREEN + "Bu ID'ye sahip ürün bulunamadı." + RESET);
                }
            } else {
                System.out.print(GREEN + "Lütfen Geçerli Bir Değer Giriniz" + RESET);
            }
        } catch (InputMismatchException e) {
            System.out.print(GREEN + "Hatalı giriş! Lütfen bir sayı giriniz." + RESET);
        }
    }

    public void shelfAssign() {
        // rafa koyma methodu dinamik olacak urun kaydi yapildiginda raf default ayara cekilecek
        //raf sayimiz 10 olarak belirlenecek --> her raf bir urun alacagi icin dolu raflar ustune eklenmemeli
        //bos raflar  liste halinde musteriye gosterilecek - musteri bos olan raflardan birini sececek
        //burdada olusabilecek hatalari kontrol etmemiz gerek try-catch
        //urunuRafaKoy    ==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.

        //----YAPACCAK KISILER: ------- todo: Mustafa, Zeynep

        // Tüm rafları başlangıçta 0 dolulukla başlatmak icin
        for (int i = 1; i <= shelfCount; i++) {
            shelfMap.put(i, 0);
        }
        // Raf doluluk durumunu göstermek için
        System.out.print(GREEN + "\n---- Raf Durumu ----" + RESET);
        for (int i = 1; i <= shelfCount; i++) {
            int currentQuantity = shelfMap.getOrDefault(i, 0); // Null olmaması için varsayılan 0 değeri
            System.out.println(GREEN + "Raf " + i + ": " + currentQuantity + "/" + shelfCapacity + RESET);
        }
        int idFromUser = -1; // Geçici başlangıç değeri
        while (true) {
            System.out.print(GREEN + "Lütfen bir ürün ID numarası girin: " + RESET);
            try {

                idFromUser = input.nextInt();
                // ID'nin geçerli olup olmadığını kontrol et
                if (wareHouseService.containsKey(idFromUser)) {
                    System.out.print(GREEN + "Geçerli bir ID girdiniz." + RESET);
                    break; // Geçerli bir ID girildiğinde döngüden çık
                } else {
                    System.out.print(GREEN + "Geçersiz bir ID numarası girdiniz. Lütfen tekrar deneyin." + RESET);

                }
            } catch (InputMismatchException e) {
                System.out.print(GREEN + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                input.nextLine(); // Scanner'daki hatalı girdiyi temizler
            }
        }
        // Hangi rafa atamak istediğini almak
        int selectedShelf = -1; // Geçici başlangıç değeri ,-1 genel olarak "atanmamış" anlamını taşıdığı için
        while (true) {
            System.out.print(GREEN + "Lütfen ürün atamak istediğiniz raf numarasını seçin: " + RESET);
            try {
                selectedShelf = input.nextInt();

                // Raf numarasının geçerli olup olmadığını kontrol et
                if (selectedShelf >= 1 && selectedShelf <= shelfCount) {
                    System.out.print(GREEN + "Geçerli bir raf numarası girdiniz." + RESET);
                    break; // Geçerli bir raf numarası girildiğinde döngüden çık
                } else {
                    System.out.print(GREEN + "Geçersiz raf numarası. Lütfen 1 ile " + shelfCount + " arasında bir numara girin." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.print(GREEN + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                input.nextLine(); // Scanner'daki hatalı girdiyi temizle
            }
        }
        // Rafın doluluk durumunu alın
        int currentQuantity = shelfMap.getOrDefault(selectedShelf, 0);


        // Miktar girmek için
        int quantityToAdd = 0; // Geçici baslangıc miktar değişkeni
        boolean validQuantityInput = false; // Geçerli miktar kontrolü

        while (!validQuantityInput) {
            System.out.print(GREEN + "Eklemek istediğiniz ürün miktarını girin: " + RESET);
            try {
                quantityToAdd = input.nextInt(); // Kullanıcıdan miktar al
                // Kapasiteyi kontrol et ve ekle
                if (currentQuantity + quantityToAdd > shelfCapacity) {
                    System.out.print(GREEN + "Depodaki urunler:" + RESET);
                    System.out.print(GREEN + "Hata: Bu kadar ürün eklemek kapasiteyi aşar! Mevcut kapasite: " + (shelfCapacity - currentQuantity) + RESET);
                } else {
                    // Rafı güncelle
                    shelfMap.put(selectedShelf, currentQuantity + quantityToAdd);
                    System.out.println(GREEN + "Ürün başarıyla eklendi. Raf " + selectedShelf + " şu anda " + shelfMap.get(selectedShelf) + "/" + shelfCapacity + " dolu." + RESET);
                    validQuantityInput = true; // Geçerli miktar alındı, döngüden çık
                }
            } catch (InputMismatchException e) {
                System.out.print(GREEN + "Hatalı giriş! Lütfen bir sayı giriniz." + RESET); // Hata mesajı
                input.nextLine(); // Hatalı girişi temizle
            }
        }
    }


    public void outOfProduct() {
        //yetersiz stok uyarısı alma istemiyorum.
        //stoktaki ürünleri göstersin sadece böyle bir tercih seçeneği sunalım
        //outOfProduct yapabilmem için ürünleri görmem gerekiyor. ürünleri göstersin
        //id üzerinden işlem yapacağız
        //ürün çıkışı olduktan sonra güncel miktarı söylesin. stok bitti ise söylesin.

        productView();//urun listeleme methodunu cagirdim. kullanicidan ID istiyor o yuzden liste gormem lazim. buyuk bir proje olsa olmaz

        System.out.print(GREEN + "Ürün ID: " + RESET);
        Long id = input.nextLong();//id aldım
        //id kontrol
        System.out.print(GREEN + "Çıkarılacak miktar: " + RESET);
        int amount = input.nextInt();//miktar aldım
        ProductPOJO product = wareHouseService.get(id);//verilen id li urunu getirdim ve product olarak kaydettim

        if (product != null) {//null degilse
            if (product.getMiktar() >= amount) {//miktar verilen miktardan buyukse
                product.setMiktar(product.getMiktar() - amount);//miktari guncelliyorum
                System.out.println(GREEN + "Ürün çıkışı yapıldı: " + product + RESET);
            } else {
                System.out.print(GREEN + "Yetersiz stok. Çıkış yapılamadı." + RESET);
            }
        } else {
            System.out.print(GREEN + "Ürün bulunamadı." + RESET);
        }
    }

    static {
        input = new Scanner(System.in);
        id = 100;
        wareHouseService = new HashMap<>();
    }
}

