package lists_2420;

/**
 * Created by chloe on 2/17/2017.
 */
public class Timing {
    private static long startTime = 0;
    private static long endTime = 0;

    public static void main(String[] args) {
        Linked_List_2420 linkedList = new Linked_List_2420();
        Array_List_2420 arrayList = new Array_List_2420();

        test_and_time(linkedList, "Linked List", 10, 10, 20);

        //test_and_time(arrayList, "Array List", 100, 100, 200);
    }

    public static void test_and_time(List_2420 list, String name, int start_count, int count_increment, int max_count) {
        System.out.printf("Sorting Using %s:\n", name);
        System.out.printf("Time Analysis for \n");
        System.out.printf("   count\tFirst\tMiddle\tLast\tRemoveFirst\tRemoveLast\n");
        System.out.flush();

        double timeAddFirst = -1;
        double timeAddMiddle = -1;
        double timeAddLast = -1;
        double timeRemoveFirst = -1;
        double timeRemoveLast =-1;

        boolean addFirst = false;
        boolean addMiddle = false;
        boolean addLast = true;
        boolean removeFirst = false;
        boolean removeLast = true;


        for (int count = start_count; count <= max_count; count += count_increment) {
            if (addFirst) {
                timer_on();
                for(int num=0;num<count;num++) {
                    list.add_first(1);
                }
                timer_off();
                timeAddFirst = get_time();
            }

            if (addMiddle) {
                timer_on();
                for(int num=0;num<count;num++) {
                    list.add_middle((int) (Math.random() * list.size()), 1);
                }
                timer_off();
                timeAddMiddle = get_time();
            }

            if (addLast) {
                timer_on();
                for(int num=0;num<count;num++) {
                    list.add_last(1);
                }
                timer_off();
                timeAddLast = get_time();
            }
            if (removeFirst) {
                timer_on();
                for(int num=0;num<count;num++) {
                    list.remove_first();
                }
                timer_off();
                timeRemoveFirst=get_time();
            }

            if (removeLast) {
                for(int num=0;num<count;num++) {
                    list.add_first(1);
                }
                timer_on();
                for(int num=0;num<count;num++) {
                    list.remove_last();
                }
                timer_off();
                timeRemoveLast=get_time();
            }

            System.out.printf("%8d\t%s\t%s\t%s\t%s\t%s\t\n",count,
                    timeAddFirst < 0 ? "     " : String.format("%5.2f", timeAddFirst),
                    timeAddMiddle < 0 ? "     " : String.format("%5.2f", timeAddMiddle),
                    timeAddLast < 0 ? "     " : String.format("%5.2f", timeAddLast),
                    timeRemoveFirst < 0 ? "     " : String.format("%5.2f", timeRemoveFirst),
                    timeRemoveLast < 0 ? "     " : String.format("%5.2f", timeRemoveLast));
            System.out.flush();
        }

    }


    /**
     * start the timer
     */
    private static void timer_on() {
        // save the current time under start time
        startTime = System.nanoTime();
    }

    /**
     * turn off the timer
     */
    private static void timer_off() {
        // save the current time under end time
        endTime = System.nanoTime();
    }

    /**
     * get the time in milliseconds between on and off.
     */
    private static double get_time() {
        //return the time between on and off in seconds
        return ((endTime-startTime)/((double)100000000));
        //return ((endTime - startTime) / ((double) 100000));
    }

}
