public abstract class AKarakter  {
    
    public AKarakter(String isim, String hikaye, int can) {
        this.isim = isim;
        this.hikaye = hikaye;
        this.can = can;
    }

    private String isim;
    private String hikaye;
    private int can;
    

    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getHikaye() {
        return hikaye;
    }
    public void setHikaye(String hikaye) {
        this.hikaye = hikaye;
    }
    public int getCan() {
        return can;
    }
    public void setCan(int can) {
        this.can = can;
    }

}
