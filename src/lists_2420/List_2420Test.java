package lists_2420;

import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chloe on 2/17/2017.
 */
public class List_2420Test {

    /**
     * allow changing between linked and array lists
     */
    public List_2420 new_list() {

        //return new Linked_List_2420();
        return new Array_List_2420();
    }

    @Test
    public void addFirstTest() {
        List_2420 listTest = new_list();

        listTest.add_first(6);
        assertEquals(6, listTest.get_first());

        listTest.add_first(7);
        assertEquals(7, listTest.get_first());

        listTest.add_first(10);
        assertEquals(10, listTest.get_first());

        //checks to make sure all 3 are still in the linked list
        assertEquals(3, listTest.size());

        assertEquals(6, listTest.get_last());

        if (listTest instanceof Linked_List_2420) {

            Linked_List_2420 linkedList = (Linked_List_2420) listTest;
            // test linked list here
            // checks to make sure everything is there
            assertEquals("(3) [10]--> [7]--> [6]--> null", linkedList.toString());

        }

    }

    @Test
    public void addLastTest() {
        List_2420 listTest = new_list();

        listTest.add_last(6);
        assertEquals(6, listTest.get_last());

        listTest.add_last(7);
        assertEquals(7, listTest.get_last());

        listTest.add_last(10);
        assertEquals(10, listTest.get_last());

        //checks to make sure all 3 are still in the linked list
        assertEquals(3, listTest.size());
        if (listTest instanceof Linked_List_2420) {

            Linked_List_2420 linkedList = (Linked_List_2420) listTest;
            // test linked list here
            // checks to make sure everything is there
            assertEquals("(3) [6]--> [7]--> [10]--> null", linkedList.toString());

        }
    }

    @Test
    public void addMiddleTest() {
        List_2420 listTest = new_list();
        listTest.add_first(6);
        listTest.add_first(7);
        listTest.add_middle(0, 10);

        // checks if contains the inserted value
        assertEquals(true, listTest.contains(10));

        if (listTest instanceof Linked_List_2420) {

            Linked_List_2420 linkedList = (Linked_List_2420) listTest;
            // test linked list here
            assertEquals("(3) [7]--> [10]--> [6]--> null", linkedList.toString());

            linkedList.add_middle(1, 5);
            assertEquals("(4) [7]--> [10]--> [5]--> [6]--> null", linkedList.toString());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void clearTest() {
        List_2420 listTest = new_list();
        listTest.add_first(6);
        listTest.add_first(7);
        listTest.clear();

        assertEquals(null, listTest.get_first());

        assertEquals(null, listTest.get_last());
        if (listTest instanceof Linked_List_2420) {

            Linked_List_2420 linkedList = (Linked_List_2420) listTest;
            // test linked list here
            assertEquals(0, linkedList.size());
            assertEquals("empty", linkedList.toString());

        }

    }

    @Test
    public void containsTest() {
        List_2420 listTest = new_list();
        // if the list is null
        assertEquals(false, listTest.contains(4));

        listTest.add_first(6);
        listTest.add_first(7);

        assertEquals(true, listTest.contains(6));

        assertEquals(false, listTest.contains(10));

    }

    @Test
    public void containsRecursive() {
        List_2420 listTest = new_list();
        // if the list is null
        assertEquals(false, listTest.contains_recursive(4));

        listTest.add_first(6);
        listTest.add_first(7);
        assertEquals(true, listTest.contains_recursive(6));

        listTest.add_first(10);
        assertEquals(true, listTest.contains_recursive(10));
    }

    @Test
    public void getFirst() {
        List_2420 listTest = new_list();

        // assertEquals(NoSuchElementException, listTest.get_first());

        //tests get first when add_first is called
        listTest.add_first(6);
        listTest.add_first(7);

        assertEquals(7, listTest.get_first());
        listTest.clear();

        //test get first when add_last is called
        listTest.add_last(6);
        listTest.add_last(7);

        assertEquals(6, listTest.get_first());

    }

    @Test
    public void getLast() {
        List_2420 listTest = new_list();

        // assertEquals(NoSuchElementException, listTest.get_last());

        //tests get first when add_first is called
        listTest.add_first(6);
        listTest.add_first(7);

        assertEquals(6, listTest.get_last());
        listTest.clear();

        //test get first when add_last is called
        listTest.add_last(6);
        listTest.add_last(7);

        assertEquals(7, listTest.get_last());
    }

    @Test
    public void removeFirstTest() {
        List_2420 listTest = new_list();

        // assertEquals(NoSuchElementException, listTest.get_last());

        listTest.add_first(6);
        listTest.add_first(7);

        assertEquals(7, listTest.remove_first());
        listTest.clear();

        listTest.add_last(6);
        listTest.add_last(7);

        assertEquals(6, listTest.remove_first());
    }

    @Test
    public void removeLastTest() {
        List_2420 listTest = new_list();

        // assertEquals(NoSuchElementException, listTest.get_last());

        listTest.add_first(6);
        listTest.add_first(7);

        assertEquals(6, listTest.remove_last());
        listTest.clear();

        listTest.add_last(6);
        listTest.add_last(7);

        assertEquals(7, listTest.remove_last());

    }

    @Test
    public void sizeNonRecursiveTest() {
        List_2420 listTest = new_list();

        assertEquals(0, listTest.size());

        listTest.add_first(6);
        listTest.add_first(7);
        listTest.add_first(8);

        assertEquals(3, listTest.size());
        listTest.clear();

        listTest.add_last(6);
        listTest.add_last(7);

        assertEquals(2, listTest.size());
    }

    @Test
    public void reverseTest() {
        List_2420 listTest = new_list();

        listTest.add_first(6);
        listTest.add_first(7);
        listTest.add_first(8);
        listTest.add_first(9);

        listTest.reverse();
        assertEquals(6, listTest.get_first());
        assertEquals(9, listTest.get_last());
        listTest.clear();

        if (listTest instanceof Linked_List_2420) {

            Linked_List_2420 linkedList = (Linked_List_2420) listTest;

            linkedList.add_first(6);
            linkedList.add_first(7);
            linkedList.add_first(8);
            linkedList.add_first(9);
            // test linked list here
            linkedList.reverse();
            assertEquals("(4) [6]--> [7]--> [8]--> [9]--> null", linkedList.toString());

        }

    }

    @Test
    public void computeSizeRecursiveTest() {
        List_2420 listTest = new_list();

        assertEquals(0, listTest.compute_size_recursive());

        listTest.add_first(6);
        listTest.add_first(7);
        listTest.add_first(8);

        assertEquals(3, listTest.compute_size_recursive());
        listTest.clear();

        listTest.add_last(6);
        listTest.add_last(7);

        assertEquals(2, listTest.compute_size_recursive());
    }

    @Test
    public void toArrayListPostRecurse() {
        List_2420 listTest = new_list();
        listTest.add_first(6);
        listTest.add_last(7);
        listTest.add_last(10);

        ArrayList test = new ArrayList();
        test.add(10);
        test.add(7);
        test.add(6);

        assertEquals(test, listTest.to_ArrayList_post_recurse());
    }

    @Test
    public void toArrayList() {
        List_2420 listTest = new_list();
        listTest.add_first(6);
        listTest.add_first(7);
        listTest.add_first(10);

        ArrayList test = new ArrayList();
        test.add(10);
        test.add(7);
        test.add(6);

        assertEquals(test, listTest.to_ArrayList());
    }
}
