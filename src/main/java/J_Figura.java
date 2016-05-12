/**
 * Created by sotikin on 10.05.2016.
 */

public class J_Figura extends Figura {
    J_Figura() {
        Kolor = 2;

        wspolrzedne = new int[9][3];     // 9 kwadracikow , 2 wsp x i y w podtablicy i kolor

        /*         NR     X                             Y                           KOLOR   */       //startowe wspolrzedne obiektu na maciery glownej
        wspolrzedne[0][0] = 2;
        wspolrzedne[0][1] = 0;
        wspolrzedne[0][2] = Kolor;           //kwadracik1
        wspolrzedne[1][0] = 2;
        wspolrzedne[1][1] = 1;
        wspolrzedne[1][2] = Kolor;           //kwadracik2              [1][2][3]
        wspolrzedne[2][0] = 2;
        wspolrzedne[2][1] = 2;
        wspolrzedne[2][2] = Kolor;           //kwadracik3              [3][4][6]
        wspolrzedne[3][0] = 1;
        wspolrzedne[3][1] = 2;
        wspolrzedne[3][2] = Kolor;           //kwadracik4              [7][8][9]

    }
}
