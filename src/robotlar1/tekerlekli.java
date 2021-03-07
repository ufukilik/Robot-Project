//---------- tekerlekli
package robotlar1;


public class tekerlekli extends gezgin{
    private int tekerlekSayisi;
    
    public tekerlekli(){
        
    }
    
    public tekerlekli(int motorSayisi, int yukMiktari, String robotTipi, int gezinmeHizi, int tekerlekSayisi) {
        this.motorSayisi = motorSayisi;
        this.yukMiktari = yukMiktari;
        this.robotTipi = robotTipi;
        this.gezinmeHizi = gezinmeHizi;
        this.tekerlekSayisi = tekerlekSayisi;
    }

    public int gettekerlekSayisi(){
        return this.tekerlekSayisi;
    }
    
    public void settekerlekSayisi(int tekerlekSayisi){
        this.tekerlekSayisi = tekerlekSayisi;
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
        return getmotorSayisi() * 0.5;
    }

}

