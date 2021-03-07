//-------------- paralel
package robotlar1;


public class paralel implements manipulator{
    private int motorSayisi;
    private int yukMiktari;
    private String robotTipi;
    private int yukTasimaKapasitesi;
    private int kolUzunlugu;
    private int tasimaHizi;
    
    public paralel(){
        
    }
    
    public paralel(int motorSayisi, int yukMiktari, String robotTipi, int yukTasimaKapasitesi, int kolUzunlugu, int tasimaHizi) {
        this.motorSayisi = motorSayisi;
        this.yukMiktari = yukMiktari;
        this.robotTipi = robotTipi;
        this.yukTasimaKapasitesi = yukTasimaKapasitesi;
        this.kolUzunlugu = kolUzunlugu;
        this.tasimaHizi = tasimaHizi;
    }
    
    @Override
    public int getmotorSayisi() {
        return this.motorSayisi;
    }

    @Override
    public int getyukMiktari() {
        return this.yukMiktari;
    }

    @Override
    public String getrobotTipi() {
        return this.robotTipi;
    }

    @Override
    public void setmotorSayisi(int motorSayisi) {
        this.motorSayisi = motorSayisi;
    }

    @Override
    public void setyukMiktari(int yukMiktari) {
        this.yukMiktari = yukMiktari;
    }

    @Override
    public void setrobotTipi(String robotTipi) {
        this.robotTipi = robotTipi;
    }

    @Override
    public int getyukTasimaKapasitesi() {
        return yukTasimaKapasitesi;
    }

    @Override
    public void setkolUzunlugu(int kolUzunlugu) {
        this.kolUzunlugu = kolUzunlugu;
    }

    @Override
    public int getkolUzunlugu() {
        return this.kolUzunlugu;
    }

    @Override
    public void settasimaHizi(int tasimaHizi) {
        this.tasimaHizi = tasimaHizi;
    }

    @Override
    public int gettasimaHizi() {
        return this.tasimaHizi;
    }

    @Override
    public void setyukTasimaKapasitesi(int yukTasimaKapasitesi) {
        this.yukTasimaKapasitesi = yukTasimaKapasitesi;
    }
    
}

