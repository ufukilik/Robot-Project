// ------------- paletli
package robotlar1;


public class paletli extends gezgin{
    private int paletSayisi;
    
    public paletli(){
        
    }
    
    public paletli(int motorSayisi, int yukMiktari, String robotTipi, int gezinmeHizi, int paletSayisi) {
        this.motorSayisi = motorSayisi;
        this.yukMiktari = yukMiktari;
        this.robotTipi = robotTipi;
        this.gezinmeHizi = gezinmeHizi;
        this.paletSayisi = paletSayisi;
    }
    
    public int getpaletSayisi(){
        return this.paletSayisi;
    }
    
    public void setpaletSayisi(int paletSayisi){
        this.paletSayisi = paletSayisi;
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
    public int getgezinmeHizi() {
        return this.gezinmeHizi;
    }

    @Override
    public void setgezinmeHizi(int gezinmeHizi) {
        this.gezinmeHizi = gezinmeHizi;
    }
    
    public double EngelGecmeSuresiBul(){
        return getmotorSayisi() * 3;
    }

}

