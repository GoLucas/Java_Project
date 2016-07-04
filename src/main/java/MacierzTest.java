import java.awt.*;

/**
 * Created by KAMIL BIELSKI on 2016-05-08.
 */

import java.awt.EventQueue;
import java.util.ArrayList;

public class MacierzTest
{
    public int ilosc_punktow=0;
    static int szybkosc_ruchu_kwadracika=50;
    static int wsp_y_zapelnionego_poziomu=-1;


    public static void main(String[] args)
    {
        //metody ktore trzeba dopisac
        //fabryka_oiektu()
        ////Ekran.wpiszFigureNaMacierz(Figura);
        //jezeli kolizja to tworz nastepny obiekt tu bd działał obserwator wykrywajacy kolizje, jezeli obserwator zglosi kolije i obiekt poza macierza to koniec gry

        Macierz Ekran = new Macierz(30, 20);          //rozmiar to 30x20 (jeden kwadrat to 20 pikseli
        int[] sumator_poziomow = new int[Macierz.getWysokosc()-1]; // do przesuwania gdy figury uloza sie w jedna linie
        Figura poli_figura;
        ArrayList<Figura> tablica_osadzonych_figur = new  ArrayList<Figura>();
        int ilosc_ruchow_figury=-1;
        Figura ktora_figura;
        Boolean KONIEC_GRY=false;
        //Figura poli_figura = new Slup(2);

       // Ekran.wpiszFigureNaMacierz(poli_figura);
        //Ekran.pokazMacierzNaEkranie();

      while(true)                                   //glowna petla gry
      {
          if(KONIEC_GRY)break; ///koniec gry
          {
              System.out.println("KONIEC GRY ");
          }
          ilosc_ruchow_figury=-1;

          poli_figura=Fabryka.stworz_losowa_figure();
          while (true)                                            //while do poruszania jedna figura
          {
              ilosc_ruchow_figury++;
              //if (Ekran.sprwadzCzyKtorykolwiekKwadracikNajechalNaRamkiMacierzy(poli_figura.wspolrzedne) == true)
              if(poli_figura.zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaWMalejMaciery()==Ekran.getWysokosc()-1 )     //KOLIZJA Z DOLEM MACIERZY
              {
                  System.out.println("KOLIZJA z dołem macierzy!!");

                  poli_figura.osadz_figure();
                  tablica_osadzonych_figur.add(poli_figura);   //dodaj osadzona figure do tablicy figur
                  Ekran.wpiszFigureNaMacierz(poli_figura);    //zmieniamy kolor osadzonej figury

                  wsp_y_zapelnionego_poziomu = Obserwator.sprawdz_czy_figury_zapelnily_ktorys_poziom(tablica_osadzonych_figur,Ekran,sumator_poziomow);
                  if(wsp_y_zapelnionego_poziomu>0)
                  {
                      System.out.println("wsp_y_zapelnionego pozimu to " + wsp_y_zapelnionego_poziomu);
                      Obserwator.przesun_figury_w_dol(tablica_osadzonych_figur,wsp_y_zapelnionego_poziomu,Ekran);
                      //Ekran.wpiszFigureNaMacierz(poli_figura);    //zmieniamy kolor osadzonej figury
                      Obserwator.odswierz(tablica_osadzonych_figur,Ekran);
                      Ekran.pokazMacierzNaEkranie();
                  }


                  break;        //przerwij jezeli kolorowy kwadrat figury najechal na ramki macierzy
              }

              if(Obserwator.wykryj_kolizje_z_usadowionymi_figurami(tablica_osadzonych_figur,poli_figura))
              {
                  if(ilosc_ruchow_figury==0)
                  {
                      KONIEC_GRY = true;
                  }

                  poli_figura.osadz_figure();
                  System.out.println("KOLIZJA z innym lementem macierzy!!");
                  tablica_osadzonych_figur.add(poli_figura);   //dodaj osadzona figure do tablicy figur
                  if(poli_figura.ostatni_ruch==1)
                  {
                      poli_figura.ruch_od_strzalek(false,true,false,false);
                  }
                  if(poli_figura.ostatni_ruch==2)
                  {
                      poli_figura.ruch_od_strzalek(true,false,false,false);
                  }
                  if(poli_figura.ostatni_ruch==3)
                  {
                      poli_figura.ruch_w_gore();
                  }

                  Ekran.wpiszFigureNaMacierz(poli_figura);    //zmieniamy kolor osadzonej figury
                  Ekran.pokazMacierzNaEkranie();                     //pokaz zaktualiowana macierz



                  wsp_y_zapelnionego_poziomu = Obserwator.sprawdz_czy_figury_zapelnily_ktorys_poziom(tablica_osadzonych_figur,Ekran,sumator_poziomow);
                  if(wsp_y_zapelnionego_poziomu>0)
                  {
                      System.out.println("wsp_y_zapelnionego pozimu to " + wsp_y_zapelnionego_poziomu);
                      Obserwator.przesun_figury_w_dol(tablica_osadzonych_figur,wsp_y_zapelnionego_poziomu,Ekran);
                      //Ekran.wpiszFigureNaMacierz(poli_figura);    //zmieniamy kolor osadzonej figury
                      Obserwator.odswierz(tablica_osadzonych_figur,Ekran);
                      Ekran.pokazMacierzNaEkranie();
                  }


                  break;

              }

              //if(wsp_y_zapelnionego_poziomu>0)
             // {
                  //Obserwator.przesun_figury_w_dol(tablica_osadzonych_figur,wsp_y_zapelnionego_poziomu);
              //}

              poli_figura.ruch();                                //rusz odpowiednio figura , tu tylko w dol , ruch od strzalek w klasie Macierz uzywamy do tego metody

              Ekran.wpiszFigureNaMacierz(poli_figura);           //wpisz ja na macierz
              Ekran.pokazMacierzNaEkranie();                     //pokaz zaktualiowana macierz

              System.out.println("naj wsp z prawej to " + poli_figura.zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaZPrawejStrony());
              System.out.println("naj wsp z lewej to " + poli_figura.zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaZLewejStrony());
              System.out.println("naj wsp z dolu to " + poli_figura.zwrocWspolrzednaKolomnowaNajbardziejWysunietegoKwadracikaZDolu());
              System.out.println("naj wsp malej macierzzy z dolu to " + poli_figura.zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaWMalejMaciery());

              try {
                  Thread.sleep(szybkosc_ruchu_kwadracika);                            //poczekaj pol sekundy
              } catch (Exception ex) {

              }

          }
      }
    }

}

