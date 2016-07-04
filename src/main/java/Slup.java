/**
 * Created by KAMIL BIELSKI on 2016-05-16.
 */
public class Slup extends Figura
{
    Slup(int kkolor)
    {
        Kolor = kkolor;
        wspolrzedne = new int[25][3];     // 25 kwadracikow , 2 wsp x i y w podtablicy i kolor,
        kwadraciki_do_zamazania = new int[3];



        /*         NR  X                                Y                         KOLOR   */                           //startowe wspolrzedne obiektu na maciery glownej

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

        wspolrzedne[7][2]=Kolor;   //wypelniam figure kolorem zoltym
        wspolrzedne[12][2]=Kolor;
        wspolrzedne[17][2]=Kolor;
        wspolrzedne[18][2]=Kolor;


    }




    @Override
    public void ruch()
    {
        ostatni_ruch=3;
        for(int i=0;i<wspolrzedne.length;i++)
        {
            wspolrzedne[i][1]++;          //przesun na dol
        }

        kwadraciki_do_zamazania[0]=7;
        kwadraciki_do_zamazania[1]=12;
        kwadraciki_do_zamazania[2]=17;

        zamaz(kwadraciki_do_zamazania,2);        //tu wpisuje figure , niby funkcja zamaz ale tak naprawde rysuje , tez mozna jej tak uzyc

        for(int i=0;i<wspolrzedne.length;i++)
        {
            if(i!=7&&i!=12&&i!=17)
            wspolrzedne[i][2]=3;          //wypelnij wszystkie kolorem bialym
        }
    }
}
