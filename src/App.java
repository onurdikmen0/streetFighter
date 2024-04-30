public class App {
    public static void main(String[] args) throws Exception {
        Karakter ken = new Karakter("Ken", "yok", 100);
        Karakter johncena = new Karakter("johncena", "yalnız", 200);
        Dovus dovus = new Dovus(ken, johncena);
        dovus.oyun(ken, johncena);
        System.out.println();
        
    }
}

