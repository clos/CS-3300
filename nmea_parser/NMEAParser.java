package nmea_parser;

import gps.CoordinateType;
import gps.Hemisphere;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * NMEAParser handles handles parsing a subset of the NMEA 0183 protocol.
 *
 * @author Mason Foster
 */
public class NMEAParser {
       //Regex patterns to parse NMEA sentences
       private Pattern gll;
       private Pattern gga;

       //
       private Matcher currMatcher;
       private Scanner scan;
       private String nmeaSentencePattern;
       static String sentence;

       public String getSentence() {
               return sentence;
       }


       public void setSentence(String sentence) {
               this.sentence = sentence;
       }


       public NMEAParser(){
               this.gll = Pattern.compile("\\$(GP|LC|IT|IN|EC|CD|GL|GN)GLL,([0-9]){4}\\.([0-9]){2}([0-9])*,(N|S),([0-9]){5}\\.([0-9]){2}([0-9])*,(E|W),(((0|1)[0-9])|2[0-3])[0-5][0-9][0-5][0-9](\\.[0-9]+)?,(A|V)((,)?|(,[0-9a-zA-Z],)?)\\*[0-9a-fA-F][0-9a-fA-F]\r\n");
               this.gga = Pattern.compile("\\$(GP|LC|IT|IN|EC|CD|GL|GN)GGA,([0-9]){6}\\.([0-9]){3},([0-9]){4}\\.([0-9]){4},(N|S),([0-9]){5}\\.([0-9]){4},(E|W),([0-8]),([0-9]),([0-9]){2}\\.([0-9])");
               this.nmeaSentencePattern = "\\$[^\\$\\r\\n]*\\r\\n";
       }



       /*
       ------------------------------------------------------------------------------
              1       2 3        4 5         6 7   8
              |       | |        | |         | |   |
       $--GLL,llll.ll,a,yyyyy.yy,a,hhmmss.ss,a,m,*hh<CR><LF>
       ------------------------------------------------------------------------------

       Field Number:

       1. Latitude
       2. N or S (North or South)
       3. Longitude
       4. E or W (East or West)
       5. Universal Time Coordinated (UTC)
       6. Status A - Data Valid, V - Data Invalid
       7. FAA mode indicator (NMEA 2.3 and later)
       8. Checksum

       GP | LC | IT | IN | EC | CD | GL | GN
       */

       public String parse(){
       NMEAParser parser = new NMEAParser();
               String rawdata="";
               sentence="";
       try
       {
               //Call COMM.py, get its console output (the gps co-ords)
                Runtime r = Runtime.getRuntime();
            Process p = r.exec("cmd /c C:\\COMM.py");
            p.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
                rawdata+=line;
            }
            p.waitFor();

//            System.out.println(rawdata);
           String[] coords = rawdata.split("\\$");
 /*          for(String s : coords){
               System.out.println(s);
           }*/

          String[] data1 = coords[1].split(",");
          String[] data2 = coords[2].split(",");
          String[] data3 = coords[3].split(",");
          String[] data4 = coords[3].split(",");

          String[] data={};
          if(data1[0].equals("GPGGA")){
                  data=data1;
          }
          else if(data2[0].equals("GPGGA")){
                  data=data2;
          }
          else if(data3[0].equals("GPGGA")){
                  data=data3;
          }
          else if(data4[0].equals("GPGGA")){
                  data=data4;
          }
          if(data[0].equals("GPGGA")){
          if(data[3].equals("N")){
                  sentence+="North ";
          }
          else if(data[3].equals("S")){
                  sentence+="South ";
          }
          sentence+=data[4]+" degrees ";
          if(data[5].equals("E")){
                  sentence+="East ";
          }
          else if(data[5].equals("W")){
                  sentence += "West ";
          }
          sentence+=data[6]+" degrees ";

          sentence+= "at time " + data[1].charAt(0)+data[1].charAt(1)+":"+data[1].charAt(2)+data[1].charAt(3);


          }


          /*
          GPSCoordinate lat = new GPSCoordinate();
          GPSCoordinate lon;
          if(data[3]=="N"){
                  lon(Hemisphere.North);
          }
          else if (data[3]=="S"){
                  lon = new GPSCoordinate(CoordinateType.Latitude, Hemisphere.South, Double.parseDouble(data[2]));
          }
          if(data[5]=="E"){
                  lon = new GPSCoordinate(CoordinateType.Latitude, Hemisphere.North, Double.parseDouble(data[2]));           }
          else if (data[3]=="W"){
                  lat.setHemisphere("West");
          }
          GPSLocation gpsloc = new GPSLocation(lat,lon);
*/
           p.waitFor();
          // GPSLocation gpsloc = parser.parseSentence(line);
          // System.out.println(gpsloc.toString());
       }
       catch (Exception e)
       {
           System.out.println(e);
       }


       return sentence;
       }

}
