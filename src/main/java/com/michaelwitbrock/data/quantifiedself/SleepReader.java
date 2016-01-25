/**
 * @license APACHE LICENSE, VERSION 2.0 http://www.apache.org/licenses/LICENSE-2.0
 * @author Michael Witbrock
 */
package com.michaelwitbrock.data.quantifiedself;

import com.michaelwitbrock.jacksonstream.JsonArrayStreamDataSupplier;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingBy;

public class SleepReader {

    //Some example uses of the reader turning Jackson streamed reading into
    // a java8 stream.
    //Not that the reader is currently only usable for top level arrays.
    //Extension should be straightforward, but perhaps not elegant
    
    public static void main(String[] args) {
  
    //Use the JSON File included as a resource
        ClassLoader classLoader = SleepReader.class.getClassLoader();
        File dataFile = new File(classLoader.getResource("example.json").getFile());

        //Simple example of getting the Sleep Objects from that JSON
        new JsonArrayStreamDataSupplier<>(dataFile, Sleep.class) //Got the Stream
                .forEachRemaining(nightsRest -> {
                    System.out.println(nightsRest.toString());
                });
        
        
        //Slighly more complex example, using a collector on the sleep objects
        //To produce a histogram over howers of sleep
        JsonArrayStreamDataSupplier<Sleep> supplier = new JsonArrayStreamDataSupplier(dataFile, Sleep.class);
        Map<Integer, Long> ts = new HashMap<>();
        ts = supplier.getStream()
                .collect(groupingBy(Sleep::getHours, counting()));
        System.out.println("Collected " + ts.size());

        //And find the most common 10 sleep durations
        Comparator<Map.Entry<Integer, Long>> byCount = (e1, e2) -> Long.compare(
                e1.getValue(), e2.getValue());
        String topSleeps = ts.entrySet()
                .stream()
                .sorted(byCount.reversed())
                .limit(10)
                .map((s) -> {
                    return " " + s.getValue() + " with " + s.getKey().toString() + " hours";
                })
                .collect(Collectors.joining("\n"));
        
        System.out.println("Top:\n" + topSleeps);
    }

}
