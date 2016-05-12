/**
 * Created by sotikin on 12.05.2016.
 */


public class S_Figura extends Figura {
    S_Figura() {
        Kolor = 2;

        wspolrzedne = new int[9][3];     // 9 kwadracikow , 2 wsp x i y w podtablicy i kolor

        /*         NR     X                             Y                           KOLOR   */       //startowe wspolrzedne obiektu na maciery glownej
        wspolrzedne[0][0] = 3;
        wspolrzedne[0][1] = 2;
        wspolrzedne[0][2] = Kolor;           //kwadracik1
        wspolrzedne[1][0] = 2;
        wspolrzedne[1][1] = 2;
        wspolrzedne[1][2] = Kolor;           //kwadracik2              [1][2][3]
        wspolrzedne[2][0] = 2;
        wspolrzedne[2][1] = 3;
        wspolrzedne[2][2] = Kolor;           //kwadracik3              [3][4][6]
        wspolrzedne[3][0] = 1;
        wspolrzedne[3][1] = 3;
        wspolrzedne[3][2] = Kolor;           //kwadracik4              [7][8][9]

    }
}
