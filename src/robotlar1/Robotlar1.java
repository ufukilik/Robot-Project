package robotlar1;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Robotlar1 {

    public class izgaraCiz extends JFrame {

        @Override
        public void paint(Graphics grph) {
            super.paint(grph);
            this.setBackground(Color.white);
            int i;
            for (i = 0; i < 110; i += 5) {
                grph.drawLine(5 * i, 50, 5 * i, 550);
            }
            for (i = 0; i < 115; i += 5) {
                grph.drawLine(25, 5 * i, 525, 5 * i);
            }
            grph.setColor(Color.black);
            for (i = 0; i < engelSayisi; i++) {
                grph.fillRect(25 * matris[0][i], 25 * (matris[1][i] + 1), 25, 25);
            }

            grph.setColor(Color.red);
            if (xRobotNerede != -1 && yRobotNerede != -1) {
                grph.fillRect(xRobotNerede, yRobotNerede, 25, 25);
            }

            grph.setColor(Color.blue);
            if (xKolNerede != -1 && yKolNerede != -1) {
                grph.fillRect(xKolNerede, yKolNerede, 25, 25);
            }
        }
    }

    static int[][] matris;
    static int engelSayisi, xRobotNerede = -1, yRobotNerede = -1, xKolNerede = -1, yKolNerede = -1;
    static int gezginTut;

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        int robotSayisi, index;
        do {
            System.out.print("Tanimlanacak robot sayisini giriniz: ");
            robotSayisi = sc.nextInt();
            if (robotSayisi < 0) {
                System.out.println("Negatif deger girmeyiniz: ");
            }
        } while (robotSayisi < 0);
        String robotTipleri[] = new String[robotSayisi];
        String hibritRobotTipi[][] = new String[2][robotSayisi];

        int motorSayisi, yukMiktari, gezinmeHizi, yukTasimaKapasitesi, kolUzunlugu, tasimaHizi, bacakSayisi, paletSayisi, tekerlekSayisi, sabitlenmeSuresi, gecisSuresi;
        spider sp[];
        sp = new spider[robotSayisi];
        paletli pl[];
        pl = new paletli[robotSayisi];
        seri sr[];
        sr = new seri[robotSayisi];
        tekerlekli tk[];
        tk = new tekerlekli[robotSayisi];
        paralel pr[];
        pr = new paralel[robotSayisi];
        hibrit hb[];
        hb = new hibrit[robotSayisi];

        sp[0] = new spider();
        pl[0] = new paletli();
        sr[0] = new seri();
        tk[0] = new tekerlekli();
        pr[0] = new paralel();
        hb[0] = new hibrit();
        for (int j = 0; j < robotTipleri.length; j++) {
            System.out.println("");
            System.out.println("");
            do {
                System.out.print((j + 1) + ". robot tipini giriniz : ");
                robotTipleri[j] = sc.next().toLowerCase();
            } while (!"seri".equals(robotTipleri[j]) && !"paralel".equals(robotTipleri[j]) && !"spider".equals(robotTipleri[j]) && !"paletli".equals(robotTipleri[j]) && !"tekerlekli".equals(robotTipleri[j]) && !"hibrit".equals(robotTipleri[j]));
            if ("spider".equals(robotTipleri[j])) {
                sp[j] = new spider();
                sp[j].setrobotTipi("spider");
                System.out.print("Motor sayisini giriniz: ");
                motorSayisi = sc.nextInt();
                sp[j].setmotorSayisi(motorSayisi);
                System.out.print("Yuk miktarini giriniz: ");
                yukMiktari = sc.nextInt();
                sp[j].setyukMiktari(yukMiktari);
                System.out.print("Robotun hizini giriniz: ");
                gezinmeHizi = sc.nextInt();
                sp[j].setgezinmeHizi(gezinmeHizi);
                while (true) {
                    if (sp[j].getgezinmeHizi() < 10 || 30 <= sp[j].getgezinmeHizi()) {
                        System.out.println("Girilen hizinizi kontrol ediniz !!! (10, 30)");
                        System.out.print("Lütfen tekrar giriniz: ");
                        gezinmeHizi = sc.nextInt();
                        sp[j].setgezinmeHizi(gezinmeHizi);
                    } else {
                        break;
                    }
                }
                System.out.print("Bacak sayisini giriniz: ");
                bacakSayisi = sc.nextInt();
                sp[j].setbacakSayisi(bacakSayisi);
            }
            if ("paletli".equals(robotTipleri[j])) {
                pl[j] = new paletli();
                pl[j].setrobotTipi("paletli");
                System.out.print("Motor sayisini giriniz: ");
                motorSayisi = sc.nextInt();
                pl[j].setmotorSayisi(motorSayisi);
                System.out.print("Yuk miktarini giriniz: ");
                yukMiktari = sc.nextInt();
                pl[j].setyukMiktari(yukMiktari);
                System.out.print("Robotun hizini giriniz: ");
                gezinmeHizi = sc.nextInt();
                pl[j].setgezinmeHizi(gezinmeHizi);
                while (true) {
                    if (pl[j].getgezinmeHizi() < 30 || 50 <= pl[j].getgezinmeHizi()) {
                        System.out.println("Girilen hizinizi kontrol ediniz !!! (30, 50)");
                        System.out.print("Lütfen tekrar giriniz: ");
                        gezinmeHizi = sc.nextInt();
                        pl[j].setgezinmeHizi(gezinmeHizi);
                    } else {
                        break;
                    }
                }
                System.out.print("Palet sayisini giriniz: ");
                paletSayisi = sc.nextInt();
                pl[j].setpaletSayisi(paletSayisi);
            }
            if ("tekerlekli".equals(robotTipleri[j])) {
                tk[j] = new tekerlekli();
                tk[j].setrobotTipi("tekerlekli");
                System.out.print("Motor sayisini giriniz: ");
                motorSayisi = sc.nextInt();
                tk[j].setmotorSayisi(motorSayisi);
                System.out.print("Yuk miktarini giriniz: ");
                yukMiktari = sc.nextInt();
                tk[j].setyukMiktari(yukMiktari);
                System.out.print("Robotun hizini giriniz: ");
                gezinmeHizi = sc.nextInt();
                tk[j].setgezinmeHizi(gezinmeHizi);
                while (true) {
                    if (tk[j].getgezinmeHizi() < 50) {
                        System.out.println("Girilen hizinizi kontrol ediniz !!! (50+)");
                        System.out.print("Lütfen tekrar giriniz: ");
                        gezinmeHizi = sc.nextInt();
                        tk[j].setgezinmeHizi(gezinmeHizi);
                    } else {
                        break;
                    }
                }
                System.out.print("Tekerlek sayisini giriniz: ");
                tekerlekSayisi = sc.nextInt();
                tk[j].settekerlekSayisi(tekerlekSayisi);
            }
            if ("seri".equals(robotTipleri[j])) {
                sr[j] = new seri();
                sr[j].setrobotTipi(robotTipleri[j]);
                System.out.print("Motor sayisini giriniz: ");
                motorSayisi = sc.nextInt();
                sr[j].setmotorSayisi(motorSayisi);
                System.out.print("Yuk tasima kapasitesini giriniz: ");
                yukTasimaKapasitesi = sc.nextInt();
                sr[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("paralel".equals(robotTipleri[k])) {
                        if (pr[k].getyukTasimaKapasitesi() <= sr[j].getyukTasimaKapasitesi()) {
                            System.out.println("Seri robotun yuk tasima kapasitesi paralel robotun degerinden buyuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            yukTasimaKapasitesi = sc.nextInt();
                            sr[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                            k = -1;
                        }
                    }
                }
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("paralel".equals(hibritRobotTipi[1][k])) {
                        if (hb[k].getyukTasimaKapasitesi() <= sr[j].getyukTasimaKapasitesi()) {
                            System.out.println("Seri robotun yuk tasima kapasitesi paralel robotun degerinden buyuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            yukTasimaKapasitesi = sc.nextInt();
                            sr[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                            k = -1;
                        }
                    }
                }
                System.out.print("Yuk miktarini giriniz: ");
                yukMiktari = sc.nextInt();
                sr[j].setyukMiktari(yukMiktari);
                while (true) {
                    if (sr[j].getyukTasimaKapasitesi() < sr[j].getyukMiktari()) {
                        System.out.println("Girilen yuk miktari yuk tasima kapasitesini asti !!");
                        System.out.print("Lutfen yeni yuk miktarini giriniz: ");
                        yukMiktari = sc.nextInt();
                        sr[j].setyukMiktari(yukMiktari);
                    } else {
                        break;
                    }
                }
                System.out.print("Kol uzunlugunu giriniz: ");
                kolUzunlugu = sc.nextInt();
                sr[j].setkolUzunlugu(kolUzunlugu);
                System.out.print("Tasima hizini giriniz: ");
                tasimaHizi = sc.nextInt();
                sr[j].settasimaHizi(tasimaHizi);
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("paralel".equals(robotTipleri[k])) {
                        if (pr[k].gettasimaHizi() <= sr[j].gettasimaHizi()) {
                            System.out.println("Tasima hizi degeriniz paralel robotun degerinden buyuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            tasimaHizi = sc.nextInt();
                            sr[j].settasimaHizi(tasimaHizi);
                            k = -1;
                        }
                    }
                }
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("paralel".equals(hibritRobotTipi[1][k])) {
                        if (hb[k].gettasimaHizi() <= sr[j].gettasimaHizi()) {
                            System.out.println("Tasima hizi degeriniz paralel robotun degerinden buyuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            tasimaHizi = sc.nextInt();
                            sr[j].settasimaHizi(tasimaHizi);
                            k = -1;
                        }
                    }
                }
            }
            if ("paralel".equals(robotTipleri[j])) {
                pr[j] = new paralel();
                pr[j].setrobotTipi("paralel");
                System.out.print("Motor sayisini giriniz: ");
                motorSayisi = sc.nextInt();
                pr[j].setmotorSayisi(motorSayisi);
                System.out.print("Yuk tasima kapasitesini giriniz: ");
                yukTasimaKapasitesi = sc.nextInt();
                pr[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("seri".equals(robotTipleri[k])) {
                        if (pr[j].getyukTasimaKapasitesi() <= sr[k].getyukTasimaKapasitesi()) {
                            System.out.println("Paralel robotun yuk tasima kapasitesi seri robotun degerinden kucuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            yukTasimaKapasitesi = sc.nextInt();
                            pr[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                            k = -1;
                        }
                    }
                }
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("seri".equals(hibritRobotTipi[1][k])) {
                        if (pr[j].getyukTasimaKapasitesi() <= hb[k].getyukTasimaKapasitesi()) {
                            System.out.println("Paralel robotun yuk tasima kapasitesi seri robotun degerinden kucuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            yukTasimaKapasitesi = sc.nextInt();
                            pr[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                            k = -1;
                        }
                    }
                }
                System.out.print("Yuk miktarini giriniz: ");
                yukMiktari = sc.nextInt();
                pr[j].setyukMiktari(yukMiktari);
                while (true) {
                    if (pr[j].getyukTasimaKapasitesi() < pr[j].getyukMiktari()) {
                        System.out.println("Girilen yuk miktari yuk tasima kapasitesini asti !!");
                        System.out.print("Lutfen yeni yuk miktarini giriniz: ");
                        yukMiktari = sc.nextInt();
                        pr[j].setyukMiktari(yukMiktari);
                    } else {
                        break;
                    }
                }
                System.out.print("Kol uzunlugunu giriniz: ");
                kolUzunlugu = sc.nextInt();
                pr[j].setkolUzunlugu(kolUzunlugu);
                System.out.print("Tasima hizini giriniz: ");
                tasimaHizi = sc.nextInt();
                pr[j].settasimaHizi(tasimaHizi);
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("seri".equals(robotTipleri[k])) {
                        if (pr[j].gettasimaHizi() <= sr[k].gettasimaHizi()) {
                            System.out.println("Tasima hizi degeriniz seri robotun degerinden kucuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            tasimaHizi = sc.nextInt();
                            pr[j].settasimaHizi(tasimaHizi);
                            k = -1;
                        }
                    }
                }
                for (int k = 0; k < robotTipleri.length; k++) {
                    if ("seri".equals(hibritRobotTipi[1][k])) {
                        if (pr[j].gettasimaHizi() <= hb[k].gettasimaHizi()) {
                            System.out.println("Tasima hizi degeriniz seri robotun degerinden kucuk veya esit olamaz !!");
                            System.out.print("Lutfen tekrar giriniz: ");
                            tasimaHizi = sc.nextInt();
                            pr[j].settasimaHizi(tasimaHizi);
                            k = -1;
                        }
                    }
                }
            }
            if ("hibrit".equals(robotTipleri[j])) {
                do {
                    System.out.print("Hibrit robot icin hareketli kisim: ");
                    hibritRobotTipi[0][j] = sc.next().toLowerCase();
                } while (!"spider".equals(hibritRobotTipi[0][j]) && !"tekerlekli".equals(hibritRobotTipi[0][j]) && !"paletli".equals(hibritRobotTipi[0][j]));
                do {
                    System.out.print("Hibrit robot icin hareketsiz kisim: ");
                    hibritRobotTipi[1][j] = sc.next().toLowerCase();
                } while (!"seri".equals(hibritRobotTipi[1][j]) && !"paralel".equals(hibritRobotTipi[1][j]));
                if (null != hibritRobotTipi[0][j]) {
                    switch (hibritRobotTipi[0][j]) {
                        case "spider":
                            gezginTut = 0;
                            break;
                        case "paletli":
                            gezginTut = 1;
                            break;
                        case "tekerlekli":
                            gezginTut = 2;
                            break;
                        default:
                            break;
                    }
                }
                hb[j] = new hibrit();
                hb[j].setrobotTipi("hibrit");
                System.out.print("Motor sayisini giriniz: ");
                motorSayisi = sc.nextInt();
                hb[j].setmotorSayisi(motorSayisi);
                System.out.print("Robotun hizini giriniz: ");
                gezinmeHizi = sc.nextInt();
                hb[j].setgezinmeHizi(gezinmeHizi);
                if (null != hibritRobotTipi[0][j]) {
                    switch (hibritRobotTipi[0][j]) {
                        case "spider":
                            while (true) {
                                if (hb[j].getgezinmeHizi() < 10 || 30 <= hb[j].getgezinmeHizi()) {
                                    System.out.println("Girilen hizinizi kontrol ediniz !!! (10, 30)");
                                    System.out.print("Lütfen tekrar giriniz: ");
                                    gezinmeHizi = sc.nextInt();
                                    hb[j].setgezinmeHizi(gezinmeHizi);
                                } else {
                                    break;
                                }
                            }
                            System.out.print("Bacak sayisini giriniz: ");
                            bacakSayisi = sc.nextInt();
                            hb[j].setbacakSayisi(bacakSayisi);
                            break;
                        case "paletli":
                            while (true) {
                                if (hb[j].getgezinmeHizi() < 30 || 50 <= hb[j].getgezinmeHizi()) {
                                    System.out.println("Girilen hizinizi kontrol ediniz !!! (30, 50)");
                                    System.out.print("Lütfen tekrar giriniz: ");
                                    gezinmeHizi = sc.nextInt();
                                    hb[j].setgezinmeHizi(gezinmeHizi);
                                } else {
                                    break;
                                }
                            }
                            System.out.print("Palet sayisini giriniz: ");
                            paletSayisi = sc.nextInt();
                            hb[j].setpaletSayisi(paletSayisi);
                            break;
                        case "tekerlekli":
                            while (true) {
                                if (hb[j].getgezinmeHizi() < 50) {
                                    System.out.println("Girilen hizinizi kontrol ediniz !!! (50+)");
                                    System.out.print("Lütfen tekrar giriniz: ");
                                    gezinmeHizi = sc.nextInt();
                                    hb[j].setgezinmeHizi(gezinmeHizi);
                                } else {
                                    break;
                                }
                            }
                            System.out.print("Tekerlek sayisini giriniz: ");
                            tekerlekSayisi = sc.nextInt();
                            hb[j].settekerlekSayisi(tekerlekSayisi);
                            break;
                        default:
                            break;
                    }
                }
                System.out.print("Yuk tasima kapasitesini giriniz: ");
                yukTasimaKapasitesi = sc.nextInt();
                hb[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                if ("seri".equals(hibritRobotTipi[1][j])) {
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("paralel".equals(robotTipleri[k])) {
                            if (pr[k].getyukTasimaKapasitesi() <= hb[j].getyukTasimaKapasitesi()) {
                                System.out.println("Seri robotun yuk tasima kapasitesi paralel robotun degerinden buyuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                yukTasimaKapasitesi = sc.nextInt();
                                hb[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                                k = -1;
                            }
                        }
                    }
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("paralel".equals(hibritRobotTipi[1][k])) {
                            if (hb[k].getyukTasimaKapasitesi() <= hb[j].getyukTasimaKapasitesi()) {
                                System.out.println("Seri robotun yuk tasima kapasitesi paralel robotun degerinden buyuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                yukTasimaKapasitesi = sc.nextInt();
                                hb[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                                k = -1;
                            }
                        }
                    }
                }
                if ("paralel".equals(hibritRobotTipi[1][j])) {
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("seri".equals(robotTipleri[k])) {
                            if (hb[j].getyukTasimaKapasitesi() <= sr[k].getyukTasimaKapasitesi()) {
                                System.out.println("Paralel robotun yuk tasima kapasitesi seri robotun degerinden kucuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                yukTasimaKapasitesi = sc.nextInt();
                                hb[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                                k = -1;
                            }
                        }
                    }
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("seri".equals(hibritRobotTipi[1][k])) {
                            if (hb[j].getyukTasimaKapasitesi() <= hb[k].getyukTasimaKapasitesi()) {
                                System.out.println("Paralel robotun yuk tasima kapasitesi seri robotun degerinden kucuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                yukTasimaKapasitesi = sc.nextInt();
                                hb[j].setyukTasimaKapasitesi(yukTasimaKapasitesi);
                                k = -1;
                            }
                        }
                    }
                }
                System.out.print("Yuk miktarini giriniz: ");
                yukMiktari = sc.nextInt();
                hb[j].setyukMiktari(yukMiktari);
                if ("seri".equals(hibritRobotTipi[1][j]) || "paralel".equals(hibritRobotTipi[1][j])) {
                    while (true) {
                        if (hb[j].getyukTasimaKapasitesi() < hb[j].getyukMiktari()) {
                            System.out.println("Girilen yuk miktari yuk tasima kapasitesini asti !!");
                            System.out.print("Lutfen yeni yuk miktarini giriniz: ");
                            yukMiktari = sc.nextInt();
                            hb[j].setyukMiktari(yukMiktari);
                        } else {
                            break;
                        }
                    }
                }
                System.out.print("Kol uzunlugunu giriniz: ");
                kolUzunlugu = sc.nextInt();
                hb[j].setkolUzunlugu(kolUzunlugu);
                System.out.print("Tasima hizini giriniz: ");
                tasimaHizi = sc.nextInt();
                hb[j].settasimaHizi(tasimaHizi);
                if ("seri".equals(hibritRobotTipi[1][j])) {
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("paralel".equals(robotTipleri[k])) {
                            if (pr[k].gettasimaHizi() <= hb[j].gettasimaHizi()) {
                                System.out.println("Tasima hizi degeriniz paralel robotun degerinden buyuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                tasimaHizi = sc.nextInt();
                                hb[j].settasimaHizi(tasimaHizi);
                                k = -1;
                            }
                        }
                    }
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("paralel".equals(hibritRobotTipi[1][k])) {
                            if (hb[k].gettasimaHizi() <= hb[j].gettasimaHizi()) {
                                System.out.println("Tasima hizi degeriniz paralel robotun degerinden buyuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                tasimaHizi = sc.nextInt();
                                hb[j].settasimaHizi(tasimaHizi);
                                k = -1;
                            }
                        }
                    }
                }
                if ("paralel".equals(hibritRobotTipi[1][j])) {
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("seri".equals(robotTipleri[k])) {
                            if (hb[j].gettasimaHizi() <= sr[k].gettasimaHizi()) {
                                System.out.println("Tasima hizi degeriniz seri robotun degerinden kucuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                tasimaHizi = sc.nextInt();
                                hb[j].settasimaHizi(tasimaHizi);
                                k = -1;
                            }
                        }
                    }
                    for (int k = 0; k < robotTipleri.length; k++) {
                        if ("seri".equals(hibritRobotTipi[1][k])) {
                            if (hb[j].gettasimaHizi() <= hb[k].gettasimaHizi()) {
                                System.out.println("Tasima hizi degeriniz seri robotun degerinden kucuk veya esit olamaz !!");
                                System.out.print("Lutfen tekrar giriniz: ");
                                tasimaHizi = sc.nextInt();
                                hb[j].settasimaHizi(tasimaHizi);
                                k = -1;
                            }
                        }
                    }
                }
                System.out.print("Robotun konuma sabitlenme suresini giriniz: ");
                sabitlenmeSuresi = sc.nextInt();
                hb[j].setsabitlenmeSuresi(sabitlenmeSuresi);
                System.out.print("Yukun kola gecis suresini giriniz: ");
                gecisSuresi = sc.nextInt();
                hb[j].setgecisSuresi(gecisSuresi);

            }

        }
        for (int j = 0; j < robotSayisi; j++) {
            System.out.println((j + 1) + ". robot tipi :" + robotTipleri[j]);
        }
        do {
            System.out.println("Hangi siradaki robot hareket ettirelecek: ");
            index = sc.nextInt();
            if (index > robotSayisi) {
                System.out.println(index + ". sirada robot yok !!");
                System.out.println("Lutfen tekrar giriniz: ");
            }
        } while (index > robotSayisi);

        Robotlar1.izgaraCiz fr;
        fr = new Robotlar1().new izgaraCiz();
        fr.setSize(600, 600);
        fr.setVisible(false);

        int girisBilgisi, i, x = 0, y = 0, x2 = 0, y2 = 0;
        if ("spider".equals(sp[index - 1].getrobotTipi()) || "paletli".equals(pl[index - 1].getrobotTipi()) || "tekerlekli".equals(tk[index - 1].getrobotTipi()) || "spider".equals(hibritRobotTipi[0][index - 1]) || "paletli".equals(hibritRobotTipi[0][index - 1]) || "tekerlekli".equals(hibritRobotTipi[0][index - 1])) {
            do {
                System.out.print("Engel koymak istiyorsanız 1'e, istemiyorsanız 0'a basiniz!! : ");
                girisBilgisi = sc.nextInt();
            } while (girisBilgisi != 1 && girisBilgisi != 0);
            if (girisBilgisi == 1) {
                System.out.print("Engel sayisini giriniz : ");
                engelSayisi = sc.nextInt();
                matris = new int[2][engelSayisi];
                for (i = 0; i < engelSayisi; i++) {
                    do {
                        System.out.print("x: ");
                        matris[0][i] = sc.nextInt();
                        System.out.print("y: ");
                        matris[1][i] = sc.nextInt();
                        if (!(matris[0][i] > 0) || !(matris[1][i] <= 20) || !(matris[0][i] <= 20) || !(matris[1][i] > 0)) {
                            System.out.println("x veya y girisi uygun degil !!");
                            System.out.println("Lutfen tekrar giriniz:");
                        }
                    } while (!(matris[0][i] > 0) || !(matris[1][i] <= 20) || !(matris[0][i] <= 20) || !(matris[1][i] > 0));
                }
                fr.setVisible(true);
            } else if (girisBilgisi == 0) {
                fr.setVisible(true);
            }

            System.out.println("Robotun konum bilgisi : ");
            do {
                System.out.print("x : ");
                x = sc.nextInt();
                xRobotNerede = x * 25;
                System.out.print("y : ");
                y = sc.nextInt();
                yRobotNerede = (y + 1) * 25;
                if (!(x > 0) || !(x <= 20) || !(y <= 20) || !(y > 0)) {
                    System.out.println("x veya y girisi uygun degil !!");
                    System.out.println("Lutfen tekrar giriniz:");
                }
            } while (!(x > 0) || !(y <= 20) || !(x <= 20) || !(y > 0));
        }

        if ("seri".equals(sr[index - 1].getrobotTipi()) || "paralel".equals(pr[index - 1].getrobotTipi())) {
            System.out.println("Kolun konum bilgisi : ");
            do {
                System.out.print("x : ");
                x2 = sc.nextInt();
                xKolNerede = x2 * 25;
                System.out.print("y : ");
                y2 = sc.nextInt();
                yKolNerede = (y2 + 1) * 25;
                fr.setVisible(true);
                if (!(x2 > 0) || !(x2 <= 20) || !(y2 <= 20) || !(y2 > 0)) {
                    System.out.println("x veya y girisi uygun degil !!");
                    System.out.println("Lutfen tekrar giriniz:");
                }
            } while (!(x2 > 0) || !(y2 <= 20) || !(x2 <= 20) || !(y2 > 0));
        }

        if ("spider".equals(sp[index - 1].getrobotTipi())) {
            Spider(x, y, sp[index - 1].getgezinmeHizi(), fr);
        }

        if ("paletli".equals(pl[index - 1].getrobotTipi())) {
            PaletliTekerlekli(x, y, pl[index - 1].getgezinmeHizi(), pl[index - 1].EngelGecmeSuresiBul(), fr);
        }

        if ("tekerlekli".equals(tk[index - 1].getrobotTipi())) {
            PaletliTekerlekli(x, y, tk[index - 1].getgezinmeHizi(), tk[index - 1].EngelGecmeSuresiBul(), fr);
        }

        if ("seri".equals(sr[index - 1].getrobotTipi())) {
            SeriParalel(x2, y2, sr[index - 1].gettasimaHizi(), sr[index - 1].getkolUzunlugu(), fr);
        }

        if ("paralel".equals(pr[index - 1].getrobotTipi())) {
            SeriParalel(x2, y2, pr[index - 1].gettasimaHizi(), pr[index - 1].getkolUzunlugu(), fr);
        }

        if ("hibrit".equals(hb[index - 1].getrobotTipi())) {
            Hibrit(x, y, hibritRobotTipi[0][index - 1], hibritRobotTipi[1][index - 1], hb[index - 1], fr);
        }
    }

    public static void MenuyeDonmekIstermisin(Robotlar1.izgaraCiz fr) {
        Scanner sc = new Scanner(System.in);
        int giris;
        do {
            System.out.println("Yeni robot girisi icin 1'e cikis icin 0'a basiniz:");
            giris = sc.nextInt();
            if (giris == 1) {
                fr.dispose();
                Menu();
            } else if (giris == 0) {
                System.exit(0);
            }
        } while (giris != 1 && giris != 0);
    }

    public static void Spider(int x, int y, int hiz, Robotlar1.izgaraCiz fr) {
        Scanner sc = new Scanner(System.in);
        int saga, sola, ileri, geri, yedek, toplamYol = 0;
        String ilkBilgi;
        System.out.print("Yon bilgisi giriniz (Girmek istemiyorsaniz -1'e basiniz ) : ");
        while (true) {
            ilkBilgi = sc.nextLine();
            if (ilkBilgi.contains("saga")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    saga = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    saga = Integer.parseInt(ilkBilgi.substring(0, 2));
                }

                yedek = 20;
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[0][j] < yedek && x < matris[0][j] && y == matris[1][j]) {
                        yedek = matris[0][j];
                    }
                }
                if (x + saga > 20 && (yedek < x || yedek == 20)) {
                    System.out.print("Izgarayı astiniz !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                }
                if (x + saga >= yedek) {
                    System.out.print("Robot engele carpti. !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                } else {
                    x = x + saga;
                    toplamYol += saga;
                    xRobotNerede = x * 25;
                    fr.setVisible(true);
                }

            }
            if (ilkBilgi.contains("sola")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    sola = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    sola = Integer.parseInt(ilkBilgi.substring(0, 2));
                }

                yedek = 0;
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[0][j] > yedek && x > matris[0][j] && y == matris[1][j]) {
                        yedek = matris[0][j];
                    }
                }
                if (x - sola < 0 && (yedek > x || yedek == 0)) {
                    System.out.print("Izgarayı astiniz !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                }
                if (x - sola <= yedek) {
                    System.out.print("Robot engele carpti. !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                } else {
                    x = x - sola;
                    toplamYol += sola;
                    xRobotNerede = x * 25;
                    fr.setVisible(true);
                }

            }
            if (ilkBilgi.contains("geri")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    geri = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    geri = Integer.parseInt(ilkBilgi.substring(0, 2));
                }

                yedek = 0;
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[1][j] > yedek && y > matris[1][j] && x == matris[0][j]) {
                        yedek = matris[1][j];
                    }
                }
                if (y - geri < 0 && (yedek > y || yedek == 0)) {
                    System.out.print("Izgarayı astiniz !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                }
                if (y - geri <= yedek) {
                    System.out.print("Robot engele carpti. !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                } else {
                    y = y - geri;
                    toplamYol += geri;
                    yRobotNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }

            }
            if (ilkBilgi.contains("ileri")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    ileri = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    ileri = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                yedek = 20;
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[1][j] < yedek && y < matris[1][j] && x == matris[0][j]) {
                        yedek = matris[1][j];
                    }
                }
                if (y + ileri > 20 && (yedek < y || yedek == 20)) {
                    System.out.print("Izgarayı astiniz !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                }
                if (y + ileri >= yedek) {
                    System.out.print("Robot engele carpti. !!!");
                    SpiderHesapla(toplamYol, hiz, fr);
                } else {
                    y = y + ileri;
                    toplamYol += ileri;
                    yRobotNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }

            }
            if (ilkBilgi.contains("-1")) {
                SpiderHesapla(toplamYol, hiz, fr);
            }
        }
    }

    public static void SpiderHesapla(int toplamYol, int hiz, Robotlar1.izgaraCiz fr) {
        double sn = (double) (toplamYol * 10) / hiz;
        System.out.println("Robotun son konumu : (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
        System.out.println("Gecen sure : " + sn + "sn");
        MenuyeDonmekIstermisin(fr);
    }

    public static void PaletliTekerlekli(int x, int y, int hiz, double engelGecmeSuresi, Robotlar1.izgaraCiz fr) {
        Scanner sc = new Scanner(System.in);
        int saga, sola, ileri, geri, sayac2 = 0, sayac = 0, toplamYol = 0, toplamEngelGecme = 0;
        String ilkBilgi;
        System.out.print("Yon bilgisi giriniz (Girmek istemiyorsaniz -1'e basiniz ) : ");
        while (true) {
            ilkBilgi = sc.nextLine();
            if (ilkBilgi.contains("saga")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    saga = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    saga = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                if (x + saga > 20) {
                    System.out.print("Izgarayı astiniz !!!");
                    PaletliTekerlekliHesapla(toplamYol, hiz, toplamEngelGecme, engelGecmeSuresi, fr);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[0][j] < x + saga && x < matris[0][j] && y == matris[1][j]) {
                        toplamEngelGecme++;
                        sayac++;// robotun ilerleyisi esnasinda engel goruyor mu, gorsuyorsa +1.
                        sayac2++;// ardasik konulan engeller icin kontrol amacli.
                    }
                }
                if (sayac2 > 0) { // ardasik engelleri gectikten sonra robotu saga kaydir.
                    x = x + saga; // robotu x de hareket ettir.
                    toplamYol += saga;
                    xRobotNerede = x * 25;
                    fr.setVisible(true);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[0][j] == x + saga && x < matris[0][j] && y == matris[1][j]) {
                        x = x + saga;
                        toplamYol += saga;
                        toplamEngelGecme++;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                        sayac++;// robotun ilerleyisi esnasinda engel goruyor mu, gorsuyorsa +1.
                    }
                }
                if (sayac == 0) {
                    x = x + saga;
                    toplamYol += saga;
                    xRobotNerede = x * 25;
                    fr.setVisible(true);
                }
                sayac = 0;
                sayac2 = 0;
            }
            if (ilkBilgi.contains("sola")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    sola = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    sola = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                if (x - sola <= 0) {
                    System.out.print("Izgarayı astiniz !!!");
                    PaletliTekerlekliHesapla(toplamYol, hiz, toplamEngelGecme, engelGecmeSuresi, fr);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[0][j] > x - sola && x > matris[0][j] && y == matris[1][j]) {
                        toplamEngelGecme++;
                        sayac++;
                        sayac2++;
                    }
                }
                if (sayac2 > 0) {
                    x = x - sola;
                    toplamYol += sola;
                    xRobotNerede = x * 25;
                    fr.setVisible(true);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[0][j] == x - sola && x > matris[0][j] && y == matris[1][j]) {
                        x = x - sola;
                        toplamYol += sola;
                        toplamEngelGecme++;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                        sayac++;
                    }
                }
                if (sayac == 0) {
                    x = x - sola;
                    toplamYol += sola;
                    xRobotNerede = x * 25;
                    fr.setVisible(true);
                }
                sayac = 0;
                sayac2 = 0;
            }
            if (ilkBilgi.contains("geri")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    geri = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    geri = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                if (y - geri <= 0) {
                    System.out.print("Izgarayı astiniz !!!");
                    PaletliTekerlekliHesapla(toplamYol, hiz, toplamEngelGecme, engelGecmeSuresi, fr);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[1][j] > y - geri && y > matris[1][j] && x == matris[0][j]) {
                        toplamEngelGecme++;
                        sayac++;
                        sayac2++;
                    }
                }
                if (sayac2 > 0) {
                    y = y - geri;
                    toplamYol += geri;
                    yRobotNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[1][j] == y - geri && y > matris[1][j] && x == matris[0][j]) {
                        y = y - geri;
                        toplamYol += geri;
                        toplamEngelGecme++;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                        sayac++;
                    }
                }
                if (sayac == 0) {
                    y = y - geri;
                    toplamYol += geri;
                    yRobotNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }
                sayac = 0;
                sayac2 = 0;
            }
            if (ilkBilgi.contains("ileri")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    ileri = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    ileri = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                if (y + ileri > 20) {
                    System.out.print("Izgarayı astiniz !!!");
                    PaletliTekerlekliHesapla(toplamYol, hiz, toplamEngelGecme, engelGecmeSuresi, fr);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[1][j] < y + ileri && y < matris[1][j] && x == matris[0][j]) {
                        toplamEngelGecme++;
                        sayac++;
                        sayac2++;
                    }
                }
                if (sayac2 > 0) {
                    y = y + ileri;
                    toplamYol += ileri;
                    yRobotNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }
                for (int j = 0; j < engelSayisi; j++) {
                    if (matris[1][j] == y + ileri && y < matris[1][j] && x == matris[0][j]) {
                        y = y + ileri;
                        toplamYol += ileri;
                        toplamEngelGecme++;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                        sayac++;
                    }
                }
                if (sayac == 0) {
                    y = y + ileri;
                    toplamYol += ileri;
                    yRobotNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }
                sayac = 0;
                sayac2 = 0;
            }
            if (ilkBilgi.contains("-1")) {
                PaletliTekerlekliHesapla(toplamYol, hiz, toplamEngelGecme, engelGecmeSuresi, fr);
            }
        }
    }

    public static void PaletliTekerlekliHesapla(int toplamYol, int hiz, int toplamEngelGecme, double engelGecmeSuresi, Robotlar1.izgaraCiz fr) {
        double sn = ((double) (toplamYol * 10) / hiz) + (toplamEngelGecme * engelGecmeSuresi);
        System.out.println("Robotun son konumu : (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
        System.out.println("Gecen sure : " + sn + "sn");
        MenuyeDonmekIstermisin(fr);
    }

    public static void SeriParalel(int x, int y, int hiz, int kolUzunlugu, Robotlar1.izgaraCiz fr) {
        int xKol = x;
        int yKol = y;
        Scanner sc = new Scanner(System.in);
        int saga, sola, ileri, geri, toplamYol = 0;
        double sonuc;
        String ilkBilgi;
        System.out.print("Yon bilgisi giriniz (Girmek istemiyorsaniz -1'e basiniz ) : ");
        while (true) {
            ilkBilgi = sc.nextLine();
            if (ilkBilgi.contains("saga")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    saga = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    saga = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                sonuc = Math.sqrt(Math.pow((xKol - (x + saga)), 2) + Math.pow((yKol - y), 2));
                if (x + saga > 20) {
                    System.out.print("Izgarayı astiniz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else if (sonuc * 10 > kolUzunlugu) {
                    System.out.print("Kol uzunlugu yetersiz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else {
                    x = x + saga;
                    toplamYol += saga;
                    xKolNerede = x * 25;
                    fr.setVisible(true);
                }
            }
            if (ilkBilgi.contains("sola")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    sola = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    sola = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                sonuc = Math.sqrt(Math.pow((xKol - (x - sola)), 2) + Math.pow((yKol - y), 2));
                if (x - sola <= 0) {
                    System.out.print("Izgarayı astiniz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else if (sonuc * 10 > kolUzunlugu) {
                    System.out.print("Kol uzunlugu yetersiz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else {
                    x = x - sola;
                    toplamYol += sola;
                    xKolNerede = x * 25;
                    fr.setVisible(true);
                }
            }
            if (ilkBilgi.contains("geri")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    geri = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    geri = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                sonuc = Math.sqrt(Math.pow((xKol - x), 2) + Math.pow((yKol - (y - geri)), 2));
                if (y - geri <= 0) {
                    System.out.print("Izgarayı astiniz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else if (sonuc * 10 > kolUzunlugu) {
                    System.out.print("Kol uzunlugu yetersiz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else {
                    y = y - geri;
                    toplamYol += geri;
                    yKolNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }
            }
            if (ilkBilgi.contains("ileri")) {
                if (" ".equals(ilkBilgi.substring(1, 2))) {
                    ileri = Integer.parseInt(ilkBilgi.substring(0, 1));
                } else {
                    ileri = Integer.parseInt(ilkBilgi.substring(0, 2));
                }
                sonuc = Math.sqrt(Math.pow((xKol - x), 2) + Math.pow((yKol - (y + ileri)), 2));
                if (y + ileri > 20) {
                    System.out.print("Izgarayı astiniz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else if (sonuc * 10 > kolUzunlugu) {
                    System.out.print("Kol uzunlugu yetersiz !!!");
                    SeriParalelHesapla(toplamYol, hiz, fr);
                } else {
                    y = y + ileri;
                    toplamYol += ileri;
                    yKolNerede = (y + 1) * 25;
                    fr.setVisible(true);
                }
            }
            if (ilkBilgi.contains("-1")) {
                SeriParalelHesapla(toplamYol, hiz, fr);
            }
        }
    }

    public static void SeriParalelHesapla(int toplamYol, int hiz, Robotlar1.izgaraCiz fr) {
        double sn = ((double) (toplamYol * 10) / hiz);
        System.out.println("Robot kolunun son konumu : (" + (xKolNerede / 25) + ", " + ((yKolNerede / 25) - 1) + ")");
        System.out.println("Gecen sure : " + sn + "sn");
        MenuyeDonmekIstermisin(fr);
    }

    public static void Hibrit(int x, int y, String gezgin, String mnp, hibrit hb, Robotlar1.izgaraCiz fr) {
        Scanner sc = new Scanner(System.in);
        int saga, sola, ileri, geri, yedek, sayac2 = 0, sayac = 0, toplamYol = 0, toplamYol2 = 0, toplamEngelGecme = 0;
        double sonuc;
        String ilkBilgi;
        System.out.print("Yon bilgisi giriniz (Girmek istemiyorsaniz -1'e basiniz ) : ");
        if ("spider".equals(gezgin)) {
            while (true) {
                ilkBilgi = sc.nextLine();
                if (ilkBilgi.contains("saga")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        saga = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        saga = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }

                    yedek = 20;
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[0][j] < yedek && x < matris[0][j] && y == matris[1][j]) {
                            yedek = matris[0][j];
                        }
                    }
                    if (x + saga > 20 && (yedek < x || yedek == 20)) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    if (x + saga >= yedek) {
                        System.out.print("Robot engele carpti. !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    } else {
                        x = x + saga;
                        toplamYol += saga;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                    }

                }
                if (ilkBilgi.contains("sola")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        sola = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        sola = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }

                    yedek = 0;
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[0][j] > yedek && x > matris[0][j] && y == matris[1][j]) {
                            yedek = matris[0][j];
                        }
                    }
                    if (x - sola < 0 && (yedek > x || yedek == 0)) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    if (x - sola <= yedek) {
                        System.out.print("Robot engele carpti. !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    } else {
                        x = x - sola;
                        toplamYol += sola;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                    }

                }
                if (ilkBilgi.contains("geri")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        geri = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        geri = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }

                    yedek = 0;
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[1][j] > yedek && y > matris[1][j] && x == matris[0][j]) {
                            yedek = matris[1][j];
                        }
                    }
                    if (y - geri < 0 && (yedek > y || yedek == 0)) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    if (y - geri <= yedek) {
                        System.out.print("Robot engele carpti. !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    } else {
                        y = y - geri;
                        toplamYol += geri;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }

                }
                if (ilkBilgi.contains("ileri")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        ileri = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        ileri = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    yedek = 20;
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[1][j] < yedek && y < matris[1][j] && x == matris[0][j]) {
                            yedek = matris[1][j];
                        }
                    }
                    if (y + ileri > 20 && (yedek < y || yedek == 20)) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    if (y + ileri >= yedek) {
                        System.out.print("Robot engele carpti. !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    } else {
                        y = y + ileri;
                        toplamYol += ileri;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }

                }
                if (ilkBilgi.contains("-1")) {
                    System.out.println("Robot konuma sabitlendi !!");
                    System.out.println("Sabitlenen konum (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
                    break;
                }
            }
        }
        if ("paletli".equals(gezgin) || "tekerlekli".equals(gezgin)) {
            while (true) {
                ilkBilgi = sc.nextLine();
                if (ilkBilgi.contains("saga")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        saga = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        saga = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    if (x + saga > 20) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[0][j] < x + saga && x < matris[0][j] && y == matris[1][j]) {
                            toplamEngelGecme++;
                            sayac++;// robotun ilerleyisi esnasinda engel goruyor mu, gorsuyorsa +1.
                            sayac2++;// ardasik konulan engeller icin kontrol amacli.
                        }
                    }
                    if (sayac2 > 0) { // ardasik engelleri gectikten sonra robotu saga kaydir.
                        x = x + saga; // robotu x de hareket ettir.
                        toplamYol += saga;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[0][j] == x + saga && x < matris[0][j] && y == matris[1][j]) {
                            x = x + saga;
                            toplamYol += saga;
                            toplamEngelGecme++;
                            xRobotNerede = x * 25;
                            fr.setVisible(true);
                            sayac++;// robotun ilerleyisi esnasinda engel goruyor mu, gorsuyorsa +1.
                        }
                    }
                    if (sayac == 0) {
                        x = x + saga;
                        toplamYol += saga;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                    }
                    sayac = 0;
                    sayac2 = 0;
                }
                if (ilkBilgi.contains("sola")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        sola = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        sola = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    if (x - sola <= 0) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[0][j] > x - sola && x > matris[0][j] && y == matris[1][j]) {
                            toplamEngelGecme++;
                            sayac++;
                            sayac2++;
                        }
                    }
                    if (sayac2 > 0) {
                        x = x - sola;
                        toplamYol += sola;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[0][j] == x - sola && x > matris[0][j] && y == matris[1][j]) {
                            x = x - sola;
                            toplamYol += sola;
                            toplamEngelGecme++;
                            xRobotNerede = x * 25;
                            fr.setVisible(true);
                            sayac++;
                        }
                    }
                    if (sayac == 0) {
                        x = x - sola;
                        toplamYol += sola;
                        xRobotNerede = x * 25;
                        fr.setVisible(true);
                    }
                    sayac = 0;
                    sayac2 = 0;
                }
                if (ilkBilgi.contains("geri")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        geri = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        geri = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    if (y - geri <= 0) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[1][j] > y - geri && y > matris[1][j] && x == matris[0][j]) {
                            toplamEngelGecme++;
                            sayac++;
                            sayac2++;
                        }
                    }
                    if (sayac2 > 0) {
                        y = y - geri;
                        toplamYol += geri;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[1][j] == y - geri && y > matris[1][j] && x == matris[0][j]) {
                            y = y - geri;
                            toplamYol += geri;
                            toplamEngelGecme++;
                            yRobotNerede = (y + 1) * 25;
                            fr.setVisible(true);
                            sayac++;
                        }
                    }
                    if (sayac == 0) {
                        y = y - geri;
                        toplamYol += geri;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }
                    sayac = 0;
                    sayac2 = 0;
                }
                if (ilkBilgi.contains("ileri")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        ileri = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        ileri = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    if (y + ileri > 20) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, gezgin);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[1][j] < y + ileri && y < matris[1][j] && x == matris[0][j]) {
                            toplamEngelGecme++;
                            sayac++;
                            sayac2++;
                        }
                    }
                    if (sayac2 > 0) {
                        y = y + ileri;
                        toplamYol += ileri;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }
                    for (int j = 0; j < engelSayisi; j++) {
                        if (matris[1][j] == y + ileri && y < matris[1][j] && x == matris[0][j]) {
                            y = y + ileri;
                            toplamYol += ileri;
                            toplamEngelGecme++;
                            yRobotNerede = (y + 1) * 25;
                            fr.setVisible(true);
                            sayac++;
                        }
                    }
                    if (sayac == 0) {
                        y = y + ileri;
                        toplamYol += ileri;
                        yRobotNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }
                    sayac = 0;
                    sayac2 = 0;
                }
                if (ilkBilgi.contains("-1")) {
                    System.out.println("Robot konuma sabitlendi !!");
                    System.out.println("Sabitlenen konum (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
                    break;
                }
            }
        }
        int xKol = x;
        int yKol = y;
        xKolNerede = x * 25;
        yKolNerede = (y + 1) * 25;
        if ("seri".equals(mnp) || "paralel".equals(mnp)) {
            System.out.print("Kol icin yon bilgisi giriniz (Girmek istemiyorsaniz -1'e basiniz): ");
            while (true) {
                ilkBilgi = sc.nextLine();
                if (ilkBilgi.contains("saga")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        saga = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        saga = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    sonuc = Math.sqrt(Math.pow((xKol - (x + saga)), 2) + Math.pow((yKol - y), 2));
                    if (x + saga > 20) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else if (sonuc * 10 > hb.getkolUzunlugu()) {
                        System.out.print("Kol uzunlugu yetersiz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else {
                        x = x + saga;
                        toplamYol2 += saga;
                        xKolNerede = x * 25;
                        fr.setVisible(true);
                    }
                }
                if (ilkBilgi.contains("sola")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        sola = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        sola = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    sonuc = Math.sqrt(Math.pow((xKol - (x - sola)), 2) + Math.pow((yKol - y), 2));
                    if (x - sola <= 0) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else if (sonuc * 10 > hb.getkolUzunlugu()) {
                        System.out.print("Kol uzunlugu yetersiz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else {
                        x = x - sola;
                        toplamYol2 += sola;
                        xKolNerede = x * 25;
                        fr.setVisible(true);
                    }
                }
                if (ilkBilgi.contains("geri")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        geri = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        geri = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    sonuc = Math.sqrt(Math.pow((xKol - x), 2) + Math.pow((yKol - (y - geri)), 2));
                    if (y - geri <= 0) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else if (sonuc * 10 > hb.getkolUzunlugu()) {
                        System.out.print("Kol uzunlugu yetersiz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else {
                        y = y - geri;
                        toplamYol2 += geri;
                        yKolNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }
                }
                if (ilkBilgi.contains("ileri")) {
                    if (" ".equals(ilkBilgi.substring(1, 2))) {
                        ileri = Integer.parseInt(ilkBilgi.substring(0, 1));
                    } else {
                        ileri = Integer.parseInt(ilkBilgi.substring(0, 2));
                    }
                    sonuc = Math.sqrt(Math.pow((xKol - x), 2) + Math.pow((yKol - (y + ileri)), 2));
                    if (y + ileri > 20) {
                        System.out.print("Izgarayı astiniz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else if (sonuc * 10 > hb.getkolUzunlugu()) {
                        System.out.print("Kol uzunlugu yetersiz !!!");
                        HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, mnp);
                    } else {
                        y = y + ileri;
                        toplamYol2 += ileri;
                        yKolNerede = (y + 1) * 25;
                        fr.setVisible(true);
                    }
                }
                if (ilkBilgi.contains("-1")) {
                    HibritHesapla(toplamYol, toplamYol2, toplamEngelGecme, hb, fr, "hibrit");
                }
            }
        }
    }

    public static void HibritHesapla(int toplamYol, int toplamYol2, int toplamEngelGecme, hibrit hb, Robotlar1.izgaraCiz fr, String hangisi) {
        double sn;
        if ("spider".equals(hangisi)) {
            sn = (double) (toplamYol * 10) / hb.getgezinmeHizi();
            System.out.println("Robotun son konumu : (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
            System.out.println("Gecen sure : " + sn + "sn");
        } else if ("paletli".equals(hangisi) || "tekerlekli".equals(hangisi)) {
            sn = ((double) (toplamYol * 10) / hb.getgezinmeHizi()) + (toplamEngelGecme * hb.EngelGecmeSuresiBul());
            System.out.println("Robotun son konumu : (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
            System.out.println("Gecen sure : " + sn + "sn");
        } else if ("seri".equals(hangisi) || "paralel".equals(hangisi) || "hibrit".equals(hangisi)) {
            sn = ((double) (toplamYol * 10) / hb.getgezinmeHizi()) + ((double) (toplamYol2 * 10) / hb.gettasimaHizi()) + (toplamEngelGecme * hb.EngelGecmeSuresiBul()) + hb.getgecisSuresi() + hb.getsabitlenmeSuresi();
            System.out.println("Robot kolunun son konumu : (" + (xKolNerede / 25) + ", " + ((yKolNerede / 25) - 1) + ")");
            System.out.println("Robotun son konumu : (" + (xRobotNerede / 25) + ", " + ((yRobotNerede / 25) - 1) + ")");
            System.out.println("Gecen sure : " + sn + "sn");
        }
        MenuyeDonmekIstermisin(fr);
    }

}
