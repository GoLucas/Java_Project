public class Kwadrat extends Figura {
    Kwadrat() {
        Kolor = 2;

        wspolrzedne = new int[9][3];     // 9 kwadracikow , 2 wsp x i y w podtablicy i kolor

        /*         NR     X                             Y                           KOLOR   */       //startowe wspolrzedne obiektu na maciery glownej
        wspolrzedne[0][0] = 10;
        wspolrzedne[0][1] = 0;
        wspolrzedne[0][2] = Kolor;           //kwadracik1
        wspolrzedne[1][0] = 10;
        wspolrzedne[1][1] = 1;
        wspolrzedne[1][2] = Kolor;           //kwadracik2              [1][2][3]
        wspolrzedne[2][0] = 11;
        wspolrzedne[2][1] = 0;
        wspolrzedne[2][2] = Kolor;           //kwadracik3              [3][4][6]
        wspolrzedne[3][0] = 11;
        wspolrzedne[3][1] = 1;
        wspolrzedne[3][2] = Kolor;           //kwadracik4              [7][8][9]

        /*wspolrzedne[2][0]=0;         wspolrzedne[2][1]=0;        wspolrzedne[2][2]=0;               //kwadracik3
        wspolrzedne[5][0]=0;         wspolrzedne[5][1]=0;        wspolrzedne[5][2]=0;               //kwadracik6
        wspolrzedne[6][0]=0;         wspolrzedne[6][1]=0;        wspolrzedne[6][2]=0;               //kwadracik7
        wspolrzedne[7][0]=0;         wspolrzedne[7][1]=0;        wspolrzedne[7][2]=0;               //kwadracik8
        wspolrzedne[8][0]=0;         wspolrzedne[8][1]=0;        wspolrzedne[8][2]=0;               //kwadracik9*/
    }
}
