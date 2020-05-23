import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class processor {

    public static void main(String[] args) {

        int[] duration = {16, 51, 20, 45, 20, 2, 42, 50, 26, 16, 25, 3, 13, 14, 38, 15, 48, 32,
                55, 7, 35, 46, 11, 5, 51, 56, 40, 38, 5, 23, 5, 55, 58, 32, 6, 24, 31, 19, 56, 54,
                27, 15, 1, 7, 31, 27, 58, 19, 58, 6, 7, 26, 49, 51, 42, 29, 41, 16, 53, 24, 21, 4,
                45, 4, 12, 30, 5, 41, 9, 14, 44, 30, 35, 1, 40, 20, 46, 4, 34, 25, 58, 21, 40, 59, 16,
                38, 6, 8, 50, 36, 42, 16, 26, 32, 34, 23, 29, 57, 55, 1};

        // Önce bir arraylist oluşturuoruz. Job isimleri(name) ve süreleri(duration) için bir tane Job classı oluşturor.
        ArrayList<Job> ar = new ArrayList<>();
        //Bu arrayin içine 1 den 100 kadar isim ve sırayla duration atıyoruz.
        //(J1,16),(J2,51),(J3,20).... (J100,1) diye
        for (int i = 0; i < 100; i++) {
            int current = i + 1;
            ar.add(new Job("J" + current, duration[i]));
        }
        // Oluşan array i burada sırayla ekrana yazdırıyoruz
        System.out.println("Sırasız listeyi ekrana yazdır.");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        //Önce küçükten büyüğe doğru sıralıyoruz. Jobduration sayesinde aşağıda sadece buyuk kucuk diye.
        Collections.sort(ar, new JobbyDuration());

        //Sıraladıktan sonra ekrana yazdırma kısmı
        System.out.println("Sıralı listeyi ekrana yazdır");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));


        //1- Önce greedy algoritmasına göre küçük işleri en az işi olan işlemciye atıyoruz.
        int[] processorArray = new int[4];
        ArrayList<String> processorOne = new ArrayList<>();
        ArrayList<String> processorTwo = new ArrayList<>();
        ArrayList<String> processorThree = new ArrayList<>();
        ArrayList<String> processorFour = new ArrayList<>();
        for (int i = 0; i < duration.length; i++) {
            int result = getMinValue(processorArray);
            switch (result % 4) {
                case 0:
                    //Toplam sayısı bulmak icin processorlara duration daki sayıyı atıoz icine
                    processorArray[0] = processorArray[0] + ar.get(i).duration;
                    //En son ekrana yazdırmak icin ismini iki nokta ve suresini atıyoruz. sonra ekrana yazcaz ondan.
                    processorOne.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
                case 1:
                    processorArray[1] = processorArray[1] + + ar.get(i).duration;
                    processorTwo.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
                case 2:
                    processorArray[2] = processorArray[2] + + ar.get(i).duration;
                    processorThree.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
                case 3:
                    processorArray[3] = processorArray[3] + + ar.get(i).duration;
                    processorFour.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
            }
        }
        System.out.println("Shortest job first(Greedy Algorithm)");
        System.out.println("P1 total time: " + processorArray[0] + " P1:" + Arrays.toString(processorOne.toArray()));
        System.out.println("P2 total time: " + processorArray[1] + " P2:" + Arrays.toString(processorTwo.toArray()));
        System.out.println("P3 total time: " + processorArray[2] + " P3:" + Arrays.toString(processorThree.toArray()));
        System.out.println("P4 total time: " + processorArray[3] + " P4:" + Arrays.toString(processorFour.toArray()));
        System.out.println("---------P1: " + processorArray[0] + " P2: " + processorArray[1] + " P3: " + processorArray[2] + " P4: " + processorArray[3]);
        System.out.println("Total time: " + getMaxValue(processorArray));
        System.out.println("------------------------------------------");
        //2--
        processorOne.clear();
        processorTwo.clear();
        processorThree.clear();
        processorFour.clear();
        processorArray = new int[4];
        for (int i = duration.length - 1; i >= 0; i--) {
            int result = getMinValue(processorArray);
            switch (result % 4) {
                case 0:
                    processorArray[0] = processorArray[0] + + ar.get(i).duration;
                    processorOne.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
                case 1:
                    processorArray[1] = processorArray[1] + + ar.get(i).duration;
                    processorTwo.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
                case 2:
                    processorArray[2] = processorArray[2] + + ar.get(i).duration;
                    processorThree.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
                case 3:
                    processorArray[3] = processorArray[3] + + ar.get(i).duration;
                    processorFour.add(ar.get(i).name +":"+ ar.get(i).duration);
                    break;
            }
        }
        System.out.println("Longest job first(Greedy Algorithm)");
        System.out.println("P1 total time: " + processorArray[0] + " P1:" + Arrays.toString(processorOne.toArray()));
        System.out.println("P2 total time: " + processorArray[1] + " P2:" + Arrays.toString(processorTwo.toArray()));
        System.out.println("P3 total time: " + processorArray[2] + " P3:" + Arrays.toString(processorThree.toArray()));
        System.out.println("P4 total time: " + processorArray[3] + " P4:" + Arrays.toString(processorFour.toArray()));
        System.out.println("---------P1: " + processorArray[0] + " P2: " + processorArray[1] + " P3: " + processorArray[2] + " P4: " + processorArray[3]);
        System.out.println("Total time: " + getMaxValue(processorArray));
        System.out.println("------------------------------------------");
    }

    //P1:705 P2:714 P3:724 P4:743
    public static int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    public static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        int order = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
                order = i;
            }
        }
        return order;
    }
}
class JobbyDuration implements Comparator<Job> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Job a, Job b) {
        return a.duration - b.duration;
    }
}

class Job {
    String name;
    int duration;

    // Constructor
    public Job(String name, int duration) {
        this.name = name;
        this.duration = duration;

    }

    public String toString() {
        return this.name + " " + this.duration;
    }
}



