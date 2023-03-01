package selenium_course;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamCourse {

    @Test
    public void regularJavaCode(){

        // Count Name starting with alphabet A
        ArrayList<String> allNames = new ArrayList<>();
        allNames.add("Kevin");
        allNames.add("Irene");
        allNames.add("André");
        allNames.add("Alice");
        allNames.add("Zoé");

        int count = 0;

        for (int i=0; i<allNames.size();i++){
            if (allNames.get(i).startsWith("A")){
                count++;
            }
        }

        System.out.println("count = " + count);
    }

    @Test
    public void streamFilterDemo(){

        // Count Name starting with alphabet A
        ArrayList<String> allNames = new ArrayList<>();
        allNames.add("Kevin");
        allNames.add("Irene");
        allNames.add("André");
        allNames.add("Alice");
        allNames.add("Zoé");
        
        Long count = allNames.stream().filter( s -> s.startsWith("A")).count();
        System.out.println("count = " + count);

        allNames.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
//        allNames.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s) );

        Stream.of("ALekya","Irene","Kevin","Rama","Jeff").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        Stream.of("Zoya","ALekya","Irene","Kevin","Rama","Jeff").filter(s -> s.endsWith("a"))
                .sorted()
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        List<String> firstFourDOW = List.of("Monday","Tuesday","Wednesday","Thursday");
        List<String> lastThreeDOW = Arrays.asList("Friday","Saturday","Sunday");

        Stream<String> DOW = Stream.concat(firstFourDOW.stream(),lastThreeDOW.stream());
        System.out.println("Number of Days in the Week : " + DOW.count());
        
        boolean flag = DOW.anyMatch(s -> s.equalsIgnoreCase("friday"));
        System.out.println("flag = " + flag);
        Assert.assertTrue(flag);


    }

    @Test
    public void streamCollectDemo() {

        // Count Name starting with alphabet A
        List<String> daysOfWeek = List.of("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");

        List<String> abbrOfDOW = daysOfWeek.stream().map(s -> s.substring(0,3)).collect(Collectors.toList());
        
        for ( String d : abbrOfDOW){
            System.out.println("d = " + d);
        }
    }
}
