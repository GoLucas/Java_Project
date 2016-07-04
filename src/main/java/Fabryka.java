import java.util.Random;

/**
 * Created by KAMIL BIELSKI on 2016-06-16.
 */


public class Fabryka
{
    static Random generator = new Random();
    static int i;

    static Figura stworz_losowa_figure()
    {
        i = generator.nextInt(3);  //int z wkresu 0 do 1 narazie
        //kolor tez narazie tylko żółty

          switch(0)
          {
              case 0:
                  return new Kwadrat(2);
              case 1:
                  return new Slup(2);

              default :
                  return new Kwadrat(2);   //defaultowo zwraca kwadrat
          }
    }
}
