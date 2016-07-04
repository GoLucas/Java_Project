import java.awt.*;

/**
 * Created by KAMIL BIELSKI on 2016-05-08.
 */
abstract public class Figura
{
    int Kolor;
    int Kolor_osadzenia=4;
    int faza_obrotu;                  //0-pozycja wyjsciowa 1-R 2-RR 3-RRR przyjmuje wartosci od 0 do 4
    int ostatni_ruch=0;               //1 - lewo , 2-prawo,3-dol 4 -gora
    public int[][] wspolrzedne;
    int[] kwadraciki_do_zamazania;



    int szerokosc_macierzy=5;              //kazda macierz na figure powinna miec szerokosc 5

    //metody abstrakcyje , różne dla kazdej jednej figury dlatego sa abstrakcyjne

    abstract public void ruch();


    //metody zwyczajne takie same dla kazdej figury

    public void zamaz(int[] ktore_kwadraciki,int jakim_Kolorem)                //zamazuje slad po figurze przy animacji
    // podaje ktore kwadraciki wyczyscic w tablicy
    {
        for(int i=0;i<ktore_kwadraciki.length;i++)
        {
            wspolrzedne[ktore_kwadraciki[i]][2] = jakim_Kolorem;

            if(wspolrzedne[ktore_kwadraciki[i]][0]==0)                             //zeby nie zamzywalo czerwonej ramki macierzy przy kolizji obiektu ze sciana z lewej strony
            {
                wspolrzedne[ktore_kwadraciki[i]][2] = 1;
            }

            if(wspolrzedne[ktore_kwadraciki[i]][0]==Macierz.getSzerokosc()-1)      //tu równiez ale ze strony prawej
            {
                wspolrzedne[ktore_kwadraciki[i]][2] = 1;
            }
        }

    }


    public int zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaZPrawejStrony()
    {
        int najbardziej_wysunieta_wspolrzedna=wspolrzedne[0][0];

        for(int i=0;i<wspolrzedne.length;i++)
        {
            if(wspolrzedne[i][0]>najbardziej_wysunieta_wspolrzedna&&wspolrzedne[i][2]!=3)najbardziej_wysunieta_wspolrzedna=wspolrzedne[i][0];    //szukam najbardziej wysunietej wspolrzednej z prawej strony czyli tej z najwiekszym x
        }
        return najbardziej_wysunieta_wspolrzedna;
    }

    public int zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaZLewejStrony()
    {
        int najbardziej_wysunieta_wspolrzedna=wspolrzedne[4][0];

        for(int i=0;i<wspolrzedne.length;i++)
        {
            if(wspolrzedne[i][0]<najbardziej_wysunieta_wspolrzedna&&wspolrzedne[i][2]!=3)najbardziej_wysunieta_wspolrzedna=wspolrzedne[i][0];    //szukam najbardziej wysunietej wspolrzednej z prawej strony czyli tej z najwiekszym x
        }
        return najbardziej_wysunieta_wspolrzedna;
    }

    public int zwrocWspolrzednaKolomnowaNajbardziejWysunietegoKwadracikaZDolu()
    {
        int najbardziej_wysunieta_wspolrzedna=wspolrzedne[0][1];

        for(int i=0;i<wspolrzedne.length;i++)
        {
            if(wspolrzedne[i][1]>najbardziej_wysunieta_wspolrzedna&&wspolrzedne[i][2]!=3)najbardziej_wysunieta_wspolrzedna=wspolrzedne[i][1];    //szukam najbardziej wysunietej wspolrzednej z prawej strony czyli tej z najwiekszym x
        }
        return najbardziej_wysunieta_wspolrzedna;
    }

    public int zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaWMalejMaciery()
    {
        return wspolrzedne[24][1];
    }


    public void rotacja_R() //obraca figure w prawo (cala macierz obrocona
    {
        //zmienna potrzebne do rotacji
        int odetnij_kolumne;
        int odejmowanie_startowe;
        int roznica_miedzy_kolumnami;
        int roznica_miedzy_wierszami;
        int ktora_wsp_w_wierszu=0;
        int tmp;
        int tmp_wsp[][] = new int[wspolrzedne.length][3];

        for(int i=0;i<wspolrzedne.length;i++)   //przekpiuj macierz do macierzy tmp
        {
            tmp_wsp[i][0] = wspolrzedne[i][0];
            tmp_wsp[i][1] = wspolrzedne[i][1];
            tmp_wsp[i][2] = wspolrzedne[i][2];
        }

        if(faza_obrotu==0)//jesli figura w pozycji wyjsciowej
        {
            //faza_obrotu++;
            odetnij_kolumne=5;
            odejmowanie_startowe=26;
            roznica_miedzy_kolumnami=-6;
            roznica_miedzy_wierszami=-4;
            ktora_wsp_w_wierszu=0;
            tmp=odejmowanie_startowe; //tmp oznaca ile dodac do tymczasowego i

            for(int i=0;i<wspolrzedne.length;i++)   //odpowiedni obrot
            {
               if(ktora_wsp_w_wierszu!=odetnij_kolumne)
               {
                   ktora_wsp_w_wierszu++;
                   tmp+=roznica_miedzy_kolumnami;
                   wspolrzedne[i]=tmp_wsp[i+tmp];  //przepisz tylko kolor
                   System.out.print(" "+(i+tmp));
               }
                else
               {
                   ktora_wsp_w_wierszu=0;
                   System.out.print("\n");
                   odejmowanie_startowe+=roznica_miedzy_wierszami;
                   tmp=odejmowanie_startowe;
                   i--;
               }
            }
            wspolrzedne[0][3]=1;
            return; //nie idz do nastepnego ifa
        }



        /*if(faza_obrotu==1)
        {

            faza_obrotu++;
            odetnij_kolumne=5;
            odejmowanie_startowe=26;
            roznica_miedzy_kolumnami=-2;
            roznica_miedzy_wierszami=-10;
            ktora_wsp_w_wierszu=0;
            tmp=odejmowanie_startowe; //tmp oznaca ile dodac do tymczasowego i

            for(int i=0;i<wspolrzedne.length;i++)   //odpowiedni obrot
            {
                if(ktora_wsp_w_wierszu!=odetnij_kolumne)
                {
                    ktora_wsp_w_wierszu++;
                    tmp+=roznica_miedzy_kolumnami;
                    wspolrzedne[i]=tmp_wsp[i+tmp];
                    System.out.print(" "+(i+tmp));
                }
                else
                {
                    ktora_wsp_w_wierszu=0;
                    System.out.print("\n");
                    odejmowanie_startowe+=roznica_miedzy_wierszami;
                    tmp=odejmowanie_startowe;
                    i--;
                }
            }
            return;
        }
        if(faza_obrotu==2)
        {
            faza_obrotu++;
            odetnij_kolumne=5;
            odejmowanie_startowe=0;
            roznica_miedzy_kolumnami=4;
            roznica_miedzy_wierszami=-6;
            Boolean pierwszy_raz=true;
            ktora_wsp_w_wierszu=0;
            tmp=odejmowanie_startowe; //tmp oznaca ile dodac do tymczasowego i

            for(int i=0;i<wspolrzedne.length;i++)   //odpowiedni obrot
            {
                if(ktora_wsp_w_wierszu!=odetnij_kolumne||pierwszy_raz==true)
                {
                    ktora_wsp_w_wierszu++;
                    tmp+=roznica_miedzy_kolumnami;
                    wspolrzedne[i]=tmp_wsp[i+tmp];
                    System.out.print(" "+(i+tmp));

                    pierwszy_raz=false;
                }
                else
                {
                    ktora_wsp_w_wierszu=0;
                    System.out.print("\n");
                    odejmowanie_startowe+=roznica_miedzy_wierszami;
                    tmp=odejmowanie_startowe;
                    i--;
                }
            }
        }
        if(faza_obrotu==3)
        {
            faza_obrotu++;
            odetnij_kolumne=5;
            odejmowanie_startowe=0;
            roznica_miedzy_kolumnami=4;
            roznica_miedzy_wierszami=-6;
            Boolean pierwszy_raz=true;
            ktora_wsp_w_wierszu=0;
            tmp=odejmowanie_startowe; //tmp oznacza ile dodac do tymczasowego i

            for(int i=0;i<wspolrzedne.length;i++)   //odpowiedni obrot
            {
                if(ktora_wsp_w_wierszu!=odetnij_kolumne||pierwszy_raz==true)
                {
                    ktora_wsp_w_wierszu++;
                    tmp+=roznica_miedzy_kolumnami;
                    wspolrzedne[i]=tmp_wsp[i+tmp];
                    System.out.print(" "+(i+tmp));

                    pierwszy_raz=false;
                }
                else
                {
                    ktora_wsp_w_wierszu=0;
                    System.out.print("\n");
                    odejmowanie_startowe+=roznica_miedzy_wierszami;
                    tmp=odejmowanie_startowe;
                    i--;
                }
            }
        }*/
    }

    public void osadz_figure()
    {
        for(int i=0;i<wspolrzedne.length;i++)
        {
            if(wspolrzedne[i][2]==Kolor)
            {
                wspolrzedne[i][2]=Kolor_osadzenia;
            }
        }
    }

    public void ruch_w_gore()
    {
        ostatni_ruch=4;
        for(int i=0;i<wspolrzedne.length;i++)
        {
            wspolrzedne[i][1]--;

        }
    }

    public void ruch_od_strzalek(Boolean lewo,Boolean prawo,Boolean obrot,Boolean przyspieszenie) {
        if (lewo == true)
        {
            for(int i=0;i<wspolrzedne.length;i++)
            {
                wspolrzedne[i][0]--;

            }
            ostatni_ruch=1;
        }

        if (prawo == true)
        {
            for(int i=0;i<wspolrzedne.length;i++)
            {
                wspolrzedne[i][0]++;
            }
            ostatni_ruch=2;
        }

        if (obrot == true)
        {
            rotacja_R();
        }

        if (przyspieszenie == true) {
            ruch();
            ostatni_ruch=3;
        }
    }


}

