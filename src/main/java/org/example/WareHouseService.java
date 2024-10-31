package org.example;

import java.util.Scanner;


public class WareHouseService {
        public static Scanner input;

        public void mainMenu(){
            //------Depo Giris Ekranidir Secimlerin Yapilmasi ve Islemlerin Baslatilmasi bu Kisimda Kodlanacaktir.
            //Tasarim Kismi Bu Kisimda Olacak Yapilinca Toplu Bir Sekilde Bura Tasarimi Uzerinde Tartisilacak
            //Ozel Kutuphaneler Ile Bu Ana Ekran Suslenebilir - Amac Konsolun Goze Hitap Etmesi
            //----YAPACCAK KISILER: ------- todo:Fatih ,Edip
        }
        public void selectedValue(){
            //-----Kullanicidan Degerin Surekli Alinabilmesi Icin Dongu Olusturulmali
            //----YAPACCAK KISILER: ------- todo:Fatih ,Edip
        }
        public void productDefine(){
            //----urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
            // MAP<id,pojoUrun>   RAF="-" ve Miktar=0 //arraylist. default olarak raf ve miktar atamalari burda yapilacak
            //id ilk urun kaydinda otomatik kaydedilecek --id BEZERSIZ OLMALI
            //----YAPACCAK KISILER: ------- todo: Emircan, Aysegul
        }
        public void productView(){
            // urunListele     ==> tanimlanan urunler listelenecek.
            // urunun adeti ve raf numarasi tanimlama yapilmadiysa default deger gorunsun.
            //  printf(%10)

            //----Ekran CIKTISI----TEmelde bu sekilde gorunmeli fakat burasida suslenebilir
           //     id      ismi    ureticisi   miktari     birimi      raf
           //    ---------------------------------------------------------------
           //     or: 1000     un     hekimoglu   0           cuval       null
           //----YAPACCAK KISILER: -------  todo: Belkis, Merve
        }
        public void newProduct(){
           // urunGirisi      ==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.

            //id ye gore urun aramasi yapilip---DIKKAT burda id olup olmadigi kontrol edilecek
            // try-catch ile urun id int disinda girilmesi gibi olusabilecek hatalar yakalanacak
            // oncelikle veri girilecek urun id kullanicidan istenip id ye gore urun miktar kaydi yapilacak

            //----YAPACCAK KISILER: ------- todo: Tayfun, Ibrahim
        }
        public void shelfAssign(){
            // rafa koyma methodu dinamik olacak urun kaydi yapildiginda raf default ayara cekilecek
            //raf sayimiz 10 olarak belirlenecek --> her raf bir urun alacagi icin dolu raflar ustune eklenmemeli
            //bos raflar  liste halinde musteriye gosterilecek - musteri bos olan raflardan birini sececek
            //burdada olusabilecek hatalari kontrol etmemiz gerek try-catch
            //urunuRafaKoy    ==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.

            //----YAPACCAK KISILER: ------- todo: Mustafa, Zeynep
        }
        public void outOfProduct(){
            // urun miktar guncelemeleri id uzerinden konrollerle yapilacak
            // urun miktarinin azaltimi yapilacak - urun cikisi yapilacak
            //urun miktarindan fazla urun talebi oldugunda elimizdeki urun miktari belirtilip UYARI verilecek yeterli degil denebilir
            //urun tamamen biterse raf default duruma getirilecek
            //urun miktarinda azalma olunca raf degismeyecek

            //urun adedi 0dan az olamaz. 0 olunca urun tanimlamasi silinmesin. sadece miktari 0 olsun.
             //exception urun adedi 0 altina duserse exeption firlatabilirsin
               //===> yaptigimiz tum degisiklikler listede de gorunsun.

            //----YAPACCAK KISILER: ------- todo: Neval, Belkis
        }








}
