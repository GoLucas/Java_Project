/**
 * Created by KAMIL BIELSKI on 2016-05-08.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Macierz
{
    static int wysokosc;                                                        //wysokosc i szerokosc macierzy
    static int szerokosc;
    int kolor_tla=3;
    int[][] macierz;                                                     //na macierzy beda ustawiane obiekty bada mialy jakies wspolrzedne , po to wlasnie ta macierz
    /***************************************************************************************************************************************/

    Figura poli_figura;
    MojPanelRysunkowy panel;

    /*******************************GETTERY I SETTERY***************************************************************************************/

    public static int getWysokosc()
    {
        return wysokosc;
    }

    public static int getSzerokosc()
    {
        return szerokosc;
    }


    /****************************************
     * DO INICJACJI MACIERZY*************************************OPIS_FUNKCJI
     *************************/

    Macierz(int wwysokosc, int sszerokosc)                                                       //konstruktor dla Macierzy
    {

        wysokosc = wwysokosc;
        szerokosc = sszerokosc;
        macierz = new int[wysokosc][szerokosc];

        obrysujMacierz();                                                                     //tu utworzy kontury macierzy

        /*************************************KONSTRUKTOR OKIENKA********************************************************************/
        JFrame ramka = new JFrame();    // tworze ramke(OKNO)
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //ustawiam zeby okienko sie wylaczylo po kliknieciu krzyzyka

        MojPanelRysunkowy nowy_panel = new MojPanelRysunkowy();      //tworze panel do rysowania, taka matryca poprostu wewnatrz ramki

        ramka.getContentPane().add(nowy_panel);                      //dodaje panel do okienka , teraz bedzie na czym rysowac xD
        ramka.setSize(500, 700);                                 //jaka wielkosc ramki zobaczymy na ekranie
        ramka.setVisible(true);                                 //pokazujemy ramke ramem z panelem
        panel=nowy_panel;

        /************************************KONIEC KONSTRUKTORA OKIENKA**************************************************************/
    }

    public void obrysujMacierz()                                                                           //wypelnia wszytkie elementy zerami i obrysuwuje po bokach i od dołu , wstawia tam poprostu jedynki
    {
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                macierz[i][j] = kolor_tla;
                if (j == 0 || j == szerokosc - 1 || i == wysokosc - 1)
                    macierz[i][j] = 1;                                                                //zero oznacza ze nic nie ma na tych wspolrzednych na macierz
            }


        }

        //panel.repaint();
    }

    public void wpiszFigureNaMacierz(Figura figura)
    {
        poli_figura=figura;

        for (int i = 0; i < figura.wspolrzedne.length; i++)
        {

            if (figura.wspolrzedne[i][0] == 0|| figura.wspolrzedne[i][0]<0 || figura.wspolrzedne[i][0] == szerokosc-1 || figura.wspolrzedne[i][0]>szerokosc-1 || figura.wspolrzedne[i][1]== wysokosc - 1)                        //jezeli wsp x lub y malej macierzy wejdzie w ramke lub wyjdzie poza nia to nie wpisuje tej czesci macierzy(warunek takze do tego zeby figura nie zamaywala drugiej
            {

            }
            else
            {
                if(macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]]==1||macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]]==4)     //jezeli tam gdzie chce wpisac jest np 1 2 4 to nie nadpisuj
                {

                }
                else
                {
                /*                            K                         W                          KOLOR   */
                    macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]] = figura.wspolrzedne[i][2];             //uzupelniam odpowiednio macierz wspolrzednymi ze stworzonej figury
                }
            }


        }


    }

    public void wpiszFigureNaMacierz2(Figura figura)
    {
        poli_figura=figura;

        for (int i = 0; i < figura.wspolrzedne.length; i++)
        {

            if (figura.wspolrzedne[i][0] == 0|| figura.wspolrzedne[i][0]<0 || figura.wspolrzedne[i][0] == szerokosc-1 || figura.wspolrzedne[i][0]>szerokosc-1 || figura.wspolrzedne[i][1]== wysokosc - 1)                        //jezeli wsp x lub y malej macierzy wejdzie w ramke lub wyjdzie poza nia to nie wpisuje tej czesci macierzy(warunek takze do tego zeby figura nie zamaywala drugiej
            {

            }
            else
            {
               // if(macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]]==1||macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]]==4)     //jezeli tam gdzie chce wpisac jest np 1 2 4 to nie nadpisuj
                {

                }
                if(figura.wspolrzedne[i][2]==4)        //wpisuj tylko czarne kwadraciki

                {
                /*                            K                         W                          KOLOR   */
                    macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]] = figura.wspolrzedne[i][2];             //uzupelniam odpowiednio macierz wspolrzednymi ze stworzonej figury
                }
            }


        }


    }




    public void pokazMacierzNaEkranie() {
        panel.repaint();
    }

    /********************************************METODY DLA OBSERWATORA*****************************************************************/

    public Boolean sprwadzCzyKtorykolwiekKwadracikNajechalNaRamkiMacierzy(int malaMacierz[][])   //sprawdza czy figura najechala na dol macierzy
    {
        for(int i = 0;i<malaMacierz.length;i++)
        {
                if(malaMacierz[i][1]==macierz.length-1&&malaMacierz[i][2]!=kolor_tla)                   //jezeli wsp y ktoregos kwadraciku jest rowna dlugosci macierzy i kolor kwadraciku jest rozny od domyslego to znaczy ze kolizja z dolem macierzy
                return true;
        }

        return false;
    }

    /********************************************KONIEC METOD DLA OBSERWATORA***********************************************************/



    class MojPanelRysunkowy extends JPanel implements KeyListener
    {
        MojPanelRysunkowy()
        {
            addKeyListener(this);
            setFocusable(true);
        }

        public void paintComponent(Graphics g)
        {

            for (int i = 0; i < wysokosc; i++) {
                for (int j = 0; j < szerokosc; j++) {
                    if (macierz[i][j] == 1)                              // wtedy rysuj czerwony kwadracik
                    {
                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.red);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);
                    }


                    if (macierz[i][j] == 2)                              // wtedy rysuj zolty kwadracik
                    {
                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.yellow);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);

                        /*
                        g.setColor(Color.lightGray);                      //wyczyszczenie ekranu
                        g.fillRect((j) * 20, (i - 2) * 20, 20, 20);*/
                    }


                    if (macierz[i][j] == kolor_tla)                              // wtedy bialy kwadracik
                    {
                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.WHITE);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);
                    }

                    if (macierz[i][j] == 4)                              // wtedy czarny kwadracik
                    {
                        g.setColor(Color.white);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.black);
                        g.fillRect(j * 20 + 1, i * 20 + 1, 18, 18);
                    }

                }
            }

        }

        /************************************STERWOANIE STRZALKAMI***************************************************************************/

        @Override
        public void keyTyped(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                System.out.println("Right key typed");
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                System.out.println("Left key typed");
            }
        }

        @Override
        public void keyPressed(KeyEvent e)
        {




        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                if(poli_figura.zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaZPrawejStrony()!=szerokosc-2)             //ograniczenie zeby figura nie wyszla poza ramki macierzy 2 bo indexy od zera i jeszcze ramka
                {
                    poli_figura.ruch_od_strzalek(false,true,false,false);
                    wpiszFigureNaMacierz(poli_figura);
                    repaint();
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if(poli_figura.zwrocWspolrzednaKolumnowaNajbardziejWysunietegoKwadracikaZLewejStrony()!=1)             //ograniczenie zeby figura nie wyszla poza ramki macierzy
                {
                    poli_figura.ruch_od_strzalek(true,false,false,false);
                    wpiszFigureNaMacierz(poli_figura);
                    repaint();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                poli_figura.ruch_od_strzalek(false,false,true,false);
                wpiszFigureNaMacierz(poli_figura);
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                poli_figura.ruch_od_strzalek(false,false,false,true);
                wpiszFigureNaMacierz(poli_figura);

                repaint();
            }



        }

        /***************************************KONIEC STEROWANIA*******************************************************************************/
    }
}
