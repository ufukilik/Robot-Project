//-------- spider
package robotlar1;


public class spider extends gezgin{
    private int bacakSayisi;
    
    public spider(){
        
    }
    
    public spider(int motorSayisi, int yukMiktari,String robotTipi, int gezinmeHizi, int bacakSayisi){
        this.motorSayisi = motorSayisi;
        this.yukMiktari = yukMiktari;
        this.robotTipi = robotTipi;
        this.gezinmeHizi = gezinmeHizi;
        this.bacakSayisi = bacakSayisi;
    }

    public int getbacakSayisi(){
        return this.bacakSayisi;
    }
    
    public void setbacakSayisi(int bacakSayisi){
        this.bacakSayisi = bacakSayisi;
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

}

