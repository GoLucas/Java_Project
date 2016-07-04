import java.awt.*;

public class Kwadrat extends Figura {
    Kwadrat(int kkolor) {
        Kolor = kkolor;
        wspolrzedne = new int[25][3];     // 10 kwadracikow , 2 wsp x i y w podtablicy i kolor, informacja czy figura została osadzona w macierzy
        kwadraciki_do_zamazania = new int[4];



        /*         NR  X                                Y                         KOLOR   */                           //startowe wspolrzedne obiektu na maciery glownej

        /*wspolrzedne[0][0] = 8;          wspolrzedne[0][1] = 0;       wspolrzedne[0][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[1][0] = 9;          wspolrzedne[1][1] = 0;       wspolrzedne[1][2] = 3;  //kwadracik1 CZYSTY
        wspolrzedne[2][0] = 10;         wspolrzedne[2][1] = 0;       wspolrzedne[2][2] = 3;  //kwadracik2 CZYSTY
        wspolrzedne[3][0] = 11;         wspolrzedne[3][1] = 0;       wspolrzedne[3][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[4][0] = 8;          wspolrzedne[4][1] = 1;       wspolrzedne[4][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[5][0] = 9;          wspolrzedne[5][1] = 1;       wspolrzedne[5][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[6][0] = 10;         wspolrzedne[6][1] = 1;       wspolrzedne[6][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[7][0] = 11;         wspolrzedne[7][1] = 1;       wspolrzedne[7][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[8][0] = 8;          wspolrzedne[8][1] = 2;       wspolrzedne[8][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[9][0] = 9;          wspolrzedne[9][1] = 2;       wspolrzedne[9][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[10][0] = 10;        wspolrzedne[10][1] =2;      wspolrzedne[10][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[11][0] = 11;        wspolrzedne[11][1] =2;      wspolrzedne[11][2] = 3;  //kwadracik0 CZYSTY*/

        int x_startowe=8;
        int x_tmp=8,y_tmp=0;

        for(int ktory_kwadrat=0;ktory_kwadrat<wspolrzedne.length;ktory_kwadrat++)                                       //tu wypelniam wszystkie kolorem tla
        {

            if(ktory_kwadrat%5==0)
            {
                x_tmp=x_startowe;
                y_tmp++;                            //uzupelniam nastepna kolumne
            }
            wspolrzedne[ktory_kwadrat][0]=x_tmp;
            wspolrzedne[ktory_kwadrat][1]=y_tmp;
            wspolrzedne[ktory_kwadrat][2]=3;
            x_tmp++;

        }

        wspolrzedne[11][2]=Kolor;   //wypelniam figure kolorem zoltym
        wspolrzedne[12][2]=Kolor;
        wspolrzedne[16][2]=Kolor;
        wspolrzedne[17][2]=Kolor;


    }



    public void ruch()
    {
        ostatni_ruch=3;
        for(int i=0;i<wspolrzedne.length;i++)
        {
            wspolrzedne[i][1]++;          //przesun na dol
        }

        kwadraciki_do_zamazania[0]=11;
        kwadraciki_do_zamazania[1]=12;
        kwadraciki_do_zamazania[2]=16;
        kwadraciki_do_zamazania[3]=17;

        for(int i=0;i<wspolrzedne.length;i++)
        {
            //if(i!=7&&i!=12&&i!=17&&i!=16)
            wspolrzedne[i][2]=3;          //wypelnij wszystkie kolorem bialym
        }

        zamaz(kwadraciki_do_zamazania,2);        //tu wpisuje figure , niby funkcja zamaz ale tak naprawde rysuje , tez mozna jej tak uzyc

    }


}
