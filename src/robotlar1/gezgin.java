//------------ gezgin
package robotlar1;


public abstract class gezgin implements robot{
    protected int gezinmeHizi;
    protected int motorSayisi;
    protected int yukMiktari;
    protected String robotTipi;
    public abstract int getgezinmeHizi();
    public abstract void setgezinmeHizi(int gezinmeHizi);
}
