import java.util.ArrayList;

/**
 * Created by KAMIL BIELSKI on 2016-06-26.
 */
public class Obserwator
{
    public static Boolean wykryj_kolizje_z_usadowionymi_figurami(ArrayList<Figura> tablica_figur_usadowionych,Figura poruszajaca_sie_figura)
    {
        for(Figura figura_osadzona:tablica_figur_usadowionych)
        {
            for(int ktory_kwadracik=0;ktory_kwadracik<figura_osadzona.wspolrzedne.length;ktory_kwadracik++) // biore kazdy jeden kwadracik z figury osadzonej
            {
                for(int i=0;i<poruszajaca_sie_figura.wspolrzedne.length;i++)   // przejezdzam przez kazdy kwadracik poruszajacej sie i sprawdzam czy na siebie najechaly
                {
                   if(poruszajaca_sie_figura.wspolrzedne[i][0] == figura_osadzona.wspolrzedne[ktory_kwadracik][0])       // jezeli maja takie same wspolrzedne x i y to kolizja
                   {
                       if(poruszajaca_sie_figura.wspolrzedne[i][1] == figura_osadzona.wspolrzedne[ktory_kwadracik][1])
                       {
                           if(figura_osadzona.wspolrzedne[ktory_kwadracik][2]==4 && poruszajaca_sie_figura.wspolrzedne[i][2]!=3)
                               return true;
                       }

                   }
                }
            }
        }
        return false;
    }

    public static int sprawdz_czy_figury_zapelnily_ktorys_poziom(ArrayList<Figura> tablica_figur_usadowionych,Macierz Ekran,int[] sumator_dla_poziomow) //zwraca poziom ktory jest zapelniony
    {
        int poziom;
        for(int i=0;i<sumator_dla_poziomow.length;i++)// wyczysc sumator przy nastepnym uruchomieniu funkcji
        {
            sumator_dla_poziomow[i]=0;
        }

            for(Figura figura_usadowiona:tablica_figur_usadowionych)
            {
                for(int ktory_kwadracik=0;ktory_kwadracik<figura_usadowiona.wspolrzedne.length;ktory_kwadracik++)
                {
                    if(figura_usadowiona.wspolrzedne[ktory_kwadracik][2]==4)
                    {
                        poziom = figura_usadowiona.wspolrzedne[ktory_kwadracik][1];

                        sumator_dla_poziomow[poziom]++;
                        if(sumator_dla_poziomow[poziom]==Macierz.getSzerokosc()-2)// minus 2 bo 2 kwadraciki na ramke macierzy // if spelniony jesli figury zapelniaja cały wiersz
                        {
                            return poziom;
                        }
                    }
                }
            }


        return -1;
    }

    public static void przesun_figury_w_dol(ArrayList<Figura> tablica_figur_usadowionych, int wsp_y,Macierz Ekran)
    {
        for(Figura figura_usadowiona:tablica_figur_usadowionych)
        {
            for(int ktory_kwadracik=0;ktory_kwadracik<figura_usadowiona.wspolrzedne.length;ktory_kwadracik++)
            {
                if(figura_usadowiona.wspolrzedne[ktory_kwadracik][1]==wsp_y&&figura_usadowiona.wspolrzedne[ktory_kwadracik][2]==4)
                {
                    //figura_usadowiona.wspolrzedne[ktory_kwadracik][2]=2;         //wyczyszczam te kwadraciki
                    figura_usadowiona.ruch();         //przesuwam w dol
                }
            }

            //Ekran.wpiszFigureNaMacierz(figura_usadowiona);
        }
    }

    public static void odswierz(ArrayList<Figura> tablica_figur_usadowionych,Macierz Ekran)
    {
        Ekran.obrysujMacierz();
        for(Figura figura_usadowiona:tablica_figur_usadowionych)
        {
            Ekran.wpiszFigureNaMacierz2(figura_usadowiona);
        }

        Ekran.pokazMacierzNaEkranie();

    }


}
