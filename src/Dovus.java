import java.util.Scanner;

public class Dovus {
        
    private Karakter karakter1;
    private Karakter karakter2;
    private static int sayac = 0;
    private int rount = 0;

    public int getRount() {
        return rount;
    }

    public void setRount(int rount) {
        this.rount = rount;
    }

    public int getSayac() {
        return sayac;
    }

    public void setSayac(int sayac) {
        Dovus.sayac = sayac;
    }

    public Dovus(Karakter karakter1, Karakter karakter2) {
        System.out.println("Dövüş Başladı");
        this.karakter1 = karakter1;
        this.karakter2 = karakter2;
    }

    public Karakter getKarakter1() {
        return karakter1;
    }
    public void setKarakter1(Karakter karakter1) {
        this.karakter1 = karakter1;
    }
    public Karakter getKarakter2() {
        return karakter2;
    }
    public void setKarakter2(Karakter karakter2) {
        this.karakter2 = karakter2;
    }
    


    public void canAzaltma(Karakter siradakiKarakter, int saldiri){//karakterin canını karşı saldiriya göre azaltır.
        int yeniCan = siradakiKarakter.getCan() - saldiri;
        siradakiKarakter.setCan(yeniCan);
    }

    public void rount(){//her çağrıldığında rount değerini arttırır
        sayac++;
        this.rount += sayac;
    }



    public int hasarHesapla(Karakter siradakiKarakter) {//karakterin kaç hasar vereceği hesaplanır geriye hasarı döndürür
        int hasar = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Saldırı seç (yumruk / tekme): ");
        String secenek = scanner.next().trim().toLowerCase();
        if (secenek.equals("tekme")) {
            hasar = siradakiKarakter.tekme();
        } 
        else if (secenek.equals("yumruk")) {
            hasar = siradakiKarakter.yumruk();
        } 
        else {
            System.out.println("Geçersiz seçenek!");
        }

        
        scanner.close();
        
        return hasar;
    }
    // public int hasarHesapla(Karakter siradakiKarakter) {
    //     int hasar = 0;
    //     Scanner scanner = new Scanner(System.in);
    
    //     System.out.print("Saldırı seç (yumruk / tekme): ");
    //     String secenek = scanner.next().trim().toLowerCase();
    
    //     if (secenek.isEmpty() || (!secenek.equals("tekme") && !secenek.equals("yumruk"))) {
    //         System.out.println("Geçersiz seçenek! Lütfen 'tekme' veya 'yumruk' giriniz.");
    //         scanner.close();//
    //         return 0;
    //     }
    
    //     if (secenek.equals("tekme")) {
    //         hasar = siradakiKarakter.tekme();
    //     } else if (secenek.equals("yumruk")) {
    //         hasar = siradakiKarakter.yumruk();
    //     }
    
    //     scanner.close();
    
    //     return hasar;
    // }
    


    

    public String oyun(Karakter karakter1, Karakter karakter2){

        while((karakter1.getCan() > 0) && (karakter2.getCan() > 0)){
            rount();
            int hasar = hasarHesapla(karakter1);
            canAzaltma(karakter2, hasar);
            canBilgi(karakter2);
            
            if (karakter2.getCan() > 0){//vurduktan sonra tekrar kontrol yapılır
                hasar = hasarHesapla(karakter2);
                canAzaltma(karakter1, hasar);
                canBilgi(karakter1); 
            }
        }

        if (karakter1.getCan() <= 0) {
            return karakter2.getIsim() + " kazandı!";
        } 
        else {
            return karakter1.getIsim() + " kazandı!";
        }
    }


    public String canBilgi(Karakter karakter){//geriye karakterin canını ve ismini döndürür.
        return karakter1.getIsim() + " : " + karakter1.getCan();
    }

}
