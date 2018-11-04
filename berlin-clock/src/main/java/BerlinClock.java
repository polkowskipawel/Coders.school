/*
    Berlin Clock
    Create a representation of the Berlin Clock for a given time (hh::mm:ss).

    The Berlin Uhr (Clock) is a rather strange way to show the time.
    On the top of the clock there is a yellow lamp that blinks on/off every two seconds.
    The time is calculated by adding rectangular lamps.

    The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps.
    Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour.
    So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

    The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4.
    In the first row every lamp represents 5 minutes.
    In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour.
    The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

    The lamps are switched on from left to right.

    Y = Yellow
    R = Red
    O = Off
*/
import java.lang.String;
import java.util.Map;
import java.util.HashMap;

public class BerlinClock {
    public String getClock(String time) {
        return getSecondsLamp(time)
                + getFiveHoursRow(time)
                + getSingleHourRow(time)
                + getFiveMinutesRow(time)
                + getSingleMinutesRow(time);
    }
    String getSingleMinutesRow(String time) {

        int minuta = minuty(time);

        int wynik = minuta % 5 ;

        Map<Integer, String> Signal = new HashMap<Integer, String>();
        Signal.put(0, "OOOO");
        Signal.put(1, "YOOO");
        Signal.put(2, "YYOO");
        Signal.put(3, "YYYO");
        Signal.put(4, "YYYY");

        return Signal.get(wynik);

    }
    String getFiveMinutesRow(String time) {

        int minuta = minuty(time);
        char[] minutnik = new char[11];
        int i ;
        int pom = 0;

        for(i= 0;i< minutnik.length;i++){
            minutnik[i]='O';
        }
        i=0;
        while(minuta >=0 ){
            if(pom % 15 == 0)
                minutnik[i] = 'R';
            else if(minuta - 5 > 0 )
                minutnik[i] = 'Y';

            minuta-=5;
            pom+=5;
            i++;
        }

        return String.valueOf(minutnik);
    }
    String getSingleHourRow(String time) {

        int godz = godziny(time);

        int wynik = godz % 5 ;

        Map<Integer, String> Signal = new HashMap<Integer, String>();
        Signal.put(0, "OOOO");
        Signal.put(1, "YOOO");
        Signal.put(2, "YYOO");
        Signal.put(3, "YYYO");
        Signal.put(4, "YYYY");

        return Signal.get(wynik);
    }
    String getFiveHoursRow(String time) {
        int godzina = godziny(time);
        char[] godz = new char[4];
        int i;

        for(i= 0;i<godz.length;i++){
            godz[i]='O';
        }
        i=0;
        while(godzina>0){
            if(godzina -5 > 0)
                godz[i]='R';
            i++;
        }
        return String.valueOf(godz);
    }

    String getSecondsLamp(String time) {
        int sekunda = sekundy(time);

        if(sekunda % 2 == 0)
            return "Y";
        else
            return "O";
    }
    int minuty(String time) {
        String pom;
        char[] czas = time.toCharArray();

        pom = new StringBuilder().append(czas[3]).append(czas[4]).toString();
        return Integer.parseInt(pom);
    }
    int godziny(String time){
        String pom;
        char[] czas = time.toCharArray();

        pom = new StringBuilder().append(czas[0]).append(czas[1]).toString();
        return Integer.parseInt(pom);
    }
    int sekundy(String time){
        String pom;
        char[] czas = time.toCharArray();

        pom = new StringBuilder().append(czas[6]).append(czas[7]).toString();
        return Integer.parseInt(pom);
    }
}
