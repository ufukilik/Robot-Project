//------------ manipulator
package robotlar1;


public interface manipulator extends robot {
    void setyukTasimaKapasitesi(int yukTasimaKapasitesi);
    int getyukTasimaKapasitesi();
    void setkolUzunlugu(int kolUzunlugu);
    int getkolUzunlugu();
    void settasimaHizi(int tasimaHizi);
    int gettasimaHizi();
}