/**
 * Created by KAMIL BIELSKI on 2016-05-08.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static oracle.jrockit.jfr.events.Bits.swap;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Macierz {
    private int center = 9;
    private  int wysokosc;                                                        //wysokosc i szerokosc macierzy
    private  int szerokosc;
    private int[][] macierz;
    int[][] macierz_czas; //na macierzy beda ustawiane obiekty bada mialy jakies wspolrzedne , po to wlasnie ta macierz
    private int [][] czas_mas;
    private int przes_y=center;
    private int przes_x=0;
    private int szybkosc =100;
    private JFrame ramka;
    /***************************************************************************************************************************************/
    private MojPanelRysunkowy panel = new MojPanelRysunkowy();      //tworze panel do rysowania, taka matryca poprostu wewnatrz ramki
    private Figura kwadrat = new Kwadrat();

    /****************************************
     * DO INICJACJI MACIERZY*************************************OPIS_FUNKCJI
     *************************/

    Macierz(int wwysokosc, int sszerokosc)          //konstruktor dla Macierzy
    {
        wysokosc = wwysokosc;
        szerokosc = sszerokosc;
        macierz = new int[wysokosc][szerokosc];

        czas_mas = new int [4][4];
        obrysujMacierz();                                                                     //tu utworzy kontury macierzy
    }

    private void obrysujMacierz() //wypelnia wszytkie elementy zerami i obrysuwuje po bokach i od dołu , wstawia tam poprostu jedynki
    {
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                macierz[i][j] = 0;
                if (j == 0 || j == szerokosc - 1 || i == wysokosc - 1)
                    macierz[i][j] = 1;                                                                //zero oznacza ze nic nie ma na tych wspolrzednych na macierz
            }
        }
    }


    private void wpiszFigureNaMacierz1() {
         przes_y=center;
         przes_x=0;
        wyczysc_czas_macierz1();
        for (int i = 0; i < 4; i++)
            /*                         K                          W                          KOLOR   */

            czas_mas[kwadrat.wspolrzedne[i][1]][kwadrat.wspolrzedne[i][0]] = kwadrat.wspolrzedne[i][2];
    }
    private void wyczysc_czas_macierz1() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                czas_mas[i][j] = 0;
        }
    }
    private void pokazMacierzNaEkranie() {
        ramka = new JFrame();    // tworze ramke(OKNO)
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //ustawiam zeby okienko sie wylaczylo po kliknieciu krzyzyka
        ramka.getContentPane().add(panel);                      //dodaje panel do okienka , teraz bedzie na czym rysowac xD
        ramka.setSize(600, 700);                                 //jaka wielkosc ramki zobaczymy na ekranie
        ramka.setVisible(true);
        ramka.setFocusable(true); // устанавливает фокус
    }
    private void obsluga_klaw()
    {
        ramka.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode() ) {
                    case KeyEvent.VK_W:
                        rotacja_figury();
                        break;
                    case KeyEvent.VK_UP:rotacja_figury();
                        szybkosc=200;
                        panel.repaint();
                        break;
                    case   KeyEvent.VK_S:System.out.println("S\n");
                        break;
                    case KeyEvent.VK_DOWN:System.out.println("DOWN\n");
                        szybkosc=100;
                        break;
                    case KeyEvent.VK_A:System.out.println("A\n");
                        przes_y--;
                        panel.repaint();
                        break;
                    case KeyEvent.VK_LEFT:System.out.println("LEFT\n");
                        przes_wlewo();
                        panel.repaint();
                        break;
                    case KeyEvent.VK_D:System.out.println("D\n");
                        przes_y++;

                        panel.repaint();
                        break;
                    case KeyEvent.VK_RIGHT:System.out.println("RIGHT\n");
                        przes_wprawo();
                        panel.repaint();
                        break;
                }
            }

        });
    }
   private void rotacja_figury()
   {

        int m[][] = new int[4][4];
       for(int i=0;i<4;i++)
           for(int j =0;j<4;j++)
               m[3-j][i]=czas_mas[i][j];
       boolean b=false;
           for (int j = 0; j < 4; j++) {
               if (m[j][3] != 0) b = true;
           }
           if (!b)
               for(int i=0;i<4;i++)
               {
                   int a=0;
           for(int j=3;j>0;j--)
           { m[i][j] = m[i][j - 1]; a =j;}
                   m[i][a-1]=0;
           }

       b=false;
       for (int j = 0; j < 4; j++) {
           if (m[3][j] != 0) b = true;

       }
       if (!b)
           for(int j=0;j<4;j++)
           {
               int a=0;
               for(int i=3;i>0;i--)
               { m[i][j] = m[i-1][j]; a =i;}
               m[a-1][j]=0;
           }

       if(czy_mozliwa_rotacja(m)) czas_mas = m;





   }
    private boolean  czy_mozliwa_rotacja( int [][] mas)
    {
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
               if (mas[i][j]!=0 && macierz[i+przes_x][j+przes_y]!=0 )return false;
        return true;
    }
    private boolean blok_opuszczony2()
    {
        for (int i=0;i< 4;i++)
            for(int j=0;j<4;j++)
            if ((czas_mas[i][j]!=0) && (macierz[i+1+przes_x][j+przes_y] != 0)) return true;
        return false;
    }
    private boolean przes_wlewo()
    {
        for (int i=0;i< 4;i++)
            for(int j=0;j<4;j++)
                if ((czas_mas[i][j]!=0) && (macierz[i+przes_x][j+przes_y-1] != 0))
                    return false;
        przes_y--;
        return true;
    }
    private boolean przes_wprawo()
    {
        for (int i=0;i< 4;i++)
            for(int j=0;j<4;j++)
                if ((czas_mas[i][j]!=0) && (macierz[i+przes_x][j+przes_y+1] != 0))
                    return false;
        przes_y++;
        return true;
    }

    private void rand_figure()
    {
        Random rand = new Random();

        switch(rand.nextInt(7)) {
            case 0:
                kwadrat = new Kwadrat();
                break;
            case 1:
                kwadrat = new Slup();
                break;
            case 2:
                kwadrat = new T_Figura();
                break;
            case 3:
                kwadrat = new J_Figura();
                break;
            case 4:
                kwadrat = new S_Figura(); //new S_Figura();
                break;
            case 5:
                kwadrat = new L_Figura();
                break;
            case 6:
                kwadrat = new Z_Figura();
                break;
        }

    }
    private void animacja() {
        //*******************************ANIMACJA***********************************************************************************
        for (int i = 0;; i++) {
            przes_x = i;
            try {
                panel.repaint();
                Thread.sleep(szybkosc);
            } catch (Exception ex) {
            }
            if (blok_opuszczony2()) {
                wpisz_na_pole();
                return;
            }

        }
    }
            public void gra()
    {
        pokazMacierzNaEkranie();
        obsluga_klaw();
        for(;;)
        {
            rand_figure();

            wpiszFigureNaMacierz1();
            if(!czy_mozliwa_rotacja(czas_mas)) {System.out.println("Game over\n"); return;}
            animacja();
            wyczysc_czas_macierz1();
            sprawd_wypewn_wiers();
            panel.repaint();
        }
    }

    private void rysuj(Graphics g)
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //  System.out.print(macierz_czas[i][j] + " ");

                if (czas_mas[i][j] == 2)                              // wtedy rysuj zolty kwadracik
                {
                    g.setColor(Color.black);
                    g.fillRect((j +przes_y)* 20, (i+ przes_x) * 20, 20, 20);
                    g.setColor(Color.yellow);
                    g.fillRect((j+przes_y) * 20 + 2, (i+przes_x) * 20 + 2, 16, 16);
                }
            }

        }
    }

    class MojPanelRysunkowy extends JPanel                            // to klasa wewnetrzna  metoda paintComponent
    {
        public void paintComponent(Graphics g) {

            for (int i = 0; i < wysokosc; i++) {
                for (int j = 0; j < szerokosc; j++) {

                    if (macierz[i][j] == 1)                              // wtedy rysuj czerwony kwadracik
                    {

                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.red);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);
                    }
                    else if (macierz[i][j] == 2)                              // wtedy rysuj czerwony kwadracik
                    {

                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.green);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);
                    }
                    else
                    {
                        g.setColor(Color.lightGray);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.white);
                        g.fillRect(j * 20 + 1, i * 20 + 1, 19, 19);


                    }
                }


            }

            rysuj(g);

        }
    }
    public void wpisz_na_pole()
    {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if(czas_mas[i][j]!=0)
                    macierz[i+przes_x][j+przes_y]=czas_mas[i][j];

    }

    private void  sprawd_wypewn_wiers()
    {
        boolean znaleziono_zero=false;
        for (int i = wysokosc-2; i>=0; i--) {
            System.out.print(i+"] ");
            for (int j = 0; j < szerokosc; j++) {
                if (j == 0 || j == szerokosc - 1 || i == wysokosc - 1) continue;
                System.out.print(macierz[i][j]+" ");
                if( macierz[i][j]==0){ znaleziono_zero = true; continue;}
            }
            if(!znaleziono_zero)
            {
                wyczysc_wiersh(i);
                i=wysokosc-1;
            }
            znaleziono_zero = false;
        }
    }
    private void  wyczysc_wiersh(int wiersh) {
        for (int i = wiersh; i >= 1; i--) {
            for (int j = 1; j < szerokosc - 1; j++) {
                if (j == 0 || j == szerokosc - 1 || i == wysokosc - 1) continue;
                macierz[i][j] = macierz[i - 1][j];
            }
        }
    }

}
