import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    List<String> depth = Collections.emptyList();
    ///This report indicates that, scanning outward from the submarine,
    // the sonar sweep found depths of 199, 200, 208, 210, and so on.
    //
    //The first order of business is to figure out how quickly the depth increases,
    // just so you know what you're dealing with -
    // you never know if the keys will get carried into deeper water
    // by an ocean current or a fish or something.
    //
    //To do this, count the number of times a depth measurement increases
    // from the previous measurement. (There is no measurement before the
    // first measurement.) In the example above, the changes are as follows:
    //
    //199 (N/A - no previous measurement)
    //200 (increased)
    //208 (increased)
    //210 (increased)
    //200 (decreased)
    //207 (increased)
    //240 (increased)
    //269 (increased)
    //260 (decreased)
    //263 (increased)


    //In this example, there are 7 measurements that are larger than the
    // previous measurement.
    //
    //How many measurements are larger than the previous measurement?
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();

        main.readMeasurement();

        System.out.println("Final Count is " + main.isLarger());

    }

    public void readMeasurement() throws FileNotFoundException {
       try {
           depth = Files.readAllLines(Paths.get("/Users/miablo/Desktop/Puzzle1/src/input.txt"), StandardCharsets.UTF_8);
       } catch (IOException e) {
           e.printStackTrace();
       }
        // store them in arraylist
        // file input
        // read measurements
    }

    // perform analysis on the list
    public int isLarger(){
        int measurements = 0;

        Iterator<String> itr = depth.iterator();
        int previous, next;
        previous = Integer.parseInt(itr.next());

        while(itr.hasNext()){
            next = Integer.parseInt(itr.next());
            if(previous < next) {
                System.out.println("Previous " + previous + " Next " + next + " increased");
                measurements++;
            } else if (!itr.hasNext()){
                break;
            }
            previous = next;
        }


        return measurements;
    }
}
