//----------------- hibrit

package robotlar1;

public class hibrit extends gezgin implements manipulator {

    private int yukTasimaKapasitesi;
    private int kolUzunlugu;
    private int tasimaHizi;
    private int paletSayisi;
    private int tekerlekSayisi;
    private int bacakSayisi;
    private int sabitlenmeSuresi;
    private int gecisSuresi;

    public hibrit() {

    }

    public hibrit(int motorSayisi, int yukMiktari, String robotTipi, int yukTasimaKapasitesi, int kolUzunlugu, int tasimaHizi, int gezinmeHizi, int eklemSayisi, int gecisSuresi, int sabitlenmeSuresi) {
        this.motorSayisi = motorSayisi;
        this.yukMiktari = yukMiktari;
        this.robotTipi = robotTipi;
        this.yukTasimaKapasitesi = yukTasimaKapasitesi;
        this.kolUzunlugu = kolUzunlugu;
        this.tasimaHizi = tasimaHizi;
        this.gezinmeHizi = gezinmeHizi;
        this.sabitlenmeSuresi = sabitlenmeSuresi;
        this.gecisSuresi = gecisSuresi;
        switch (Robotlar1.gezginTut) {
            case 0:
                this.bacakSayisi = eklemSayisi;
                break;
            case 1:
                this.paletSayisi = eklemSayisi;
                break;
            case 2:
                this.tekerlekSayisi = eklemSayisi;
                break;
            default:
                break;
        }
    }

    public int getsabitlenmeSuresi() {
        return this.sabitlenmeSuresi;
    }

    public void setsabitlenmeSuresi(int sabitlenmeSuresi) {
        this.sabitlenmeSuresi = sabitlenmeSuresi;
    }

    public int getgecisSuresi() {
        return this.gecisSuresi;
    }

    public void setgecisSuresi(int gecisSuresi) {
        this.gecisSuresi = gecisSuresi;
    }

    public int getbacakSayisi() {
        return this.bacakSayisi;
    }

    public void setbacakSayisi(int bacakSayisi) {
        this.bacakSayisi = bacakSayisi;
    }

    public int gettekerlekSayisi() {
        return this.tekerlekSayisi;
    }

    public void settekerlekSayisi(int tekerlekSayisi) {
        this.tekerlekSayisi = tekerlekSayisi;
    }

    public int getpaletSayisi() {
        return this.paletSayisi;
    }

    public void setpaletSayisi(int paletSayisi) {
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

    public double EngelGecmeSuresiBul() {
        switch (Robotlar1.gezginTut) {
            case 1:
                return getmotorSayisi() * 3;
            case 2:
                return getmotorSayisi() * 0.5;
            default:
                return 0;
        }
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
