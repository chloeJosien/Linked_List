package lists_2420;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by chloe on 2/17/2017.
 */
public class Array_List_2420 implements List_2420<Integer> {

    private Integer first = 0;
    private Integer last = 0;
    private Integer[] backingArray = new Integer[1024];


    @Override
    public void add_first(Integer data) {
        if (backingArray[bound(first)] == null && bound(first) == 0) {
            backingArray[bound(first)] = data;
        } else {
            if (last - first + 1 == backingArray.length) {
               backingArray= expand(backingArray);
            }
            first--;
            backingArray[bound(first)] = data;
        }
    }

    @Override
    public void add_last(Integer data) {
        if (last == 0 && backingArray[bound(last)] == null) {
            backingArray[bound(last)] = data;
        } else {
            if (last - first + 1 == backingArray.length) {
                backingArray=expand(backingArray);
            }
            last++;
            backingArray[bound(last)] = data;
        }

    }

    @Override
    public void add_middle(int after, Integer data) {
        if (backingArray[bound(first)] == null) {
            add_first(data);
        } else {
            if (last - first + 1 == backingArray.length) {
                backingArray=expand(backingArray);
            }
            last++;
            for (int count = last; count > after; count--) {
                backingArray[bound(count)] = backingArray[bound(count - 1)];
            }
            backingArray[bound(after + 1)] = data;
        }

    }

    @Override
    public void clear() {

        for (int count = first; count <= last; count++) {
            backingArray[bound(count)] = null;
        }
        last = 0;
        first = 0;
    }

    @Override
    public boolean contains(Integer item) {
        if (backingArray[bound(first)] == null) {
            return false;
        }
        for (int count = first; count <= last; count++) {
            if (backingArray[bound(count)] == (int) item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains_recursive(Integer item) {
        int count = first;
        if (backingArray[bound(first)] == null) {
            return false;
        }
        return containsRecursiveHelper(count, item);
    }

    public boolean containsRecursiveHelper(int position, Integer item) {
        if (backingArray[bound(position)] == (int) item) {
            return true;
        }

        return containsRecursiveHelper(++position, item);
    }

    @Override
    public Integer get_first() throws NoSuchElementException {
        if (backingArray[bound(first)] == null) {
            throw new NoSuchElementException();
        }
        return backingArray[bound(first)];
    }

    @Override
    public Integer get_last() throws NoSuchElementException {
        if (backingArray[bound(last)] == null) {
            throw new NoSuchElementException();
        }
        return backingArray[bound(last)];
    }

    @Override
    public Integer remove_first() throws NoSuchElementException {
        if (backingArray[bound(first)] == null) {
            throw new NoSuchElementException();
        }
        int temp = backingArray[bound(first)];
        backingArray[bound(first)] = null;
        first++;
        return temp;
    }

    @Override
    public Integer remove_last() throws NoSuchElementException {
        if (backingArray[bound(last)] == null) {
            throw new NoSuchElementException();
        }
        int temp = backingArray[bound(last)];
        backingArray[bound(last)] = null;
        last--;
        return temp;
    }

    @Override
    public int size() {
        if (backingArray[bound(first)] == null && backingArray[bound(last)] == null) {
            return 0;
        }

        return (last-first+1);
    }

    @Override
    public void reverse() {
        int lastIndex = last;
        for (int count = first; count < last; count++) {
            int temp = backingArray[bound(count)];
            backingArray[bound(count)] = backingArray[bound(lastIndex)];
            backingArray[bound(lastIndex)] = temp;
            lastIndex--;
        }

    }

    @Override
    public int compute_size_recursive() {
        return size();
    }

    @Override
    public ArrayList<Integer> to_ArrayList_post_recurse() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int count = last; count >= first; count--) {
            list.add(backingArray[bound(count)]);
        }
        return list;
    }

    @Override
    public ArrayList<Integer> to_ArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int count = first; count <= last; count++) {
            list.add(backingArray[bound(count)]);
        }
        return list;
    }

    public Integer[] expand(Integer[] array) {

        if(size()==backingArray.length){
            Integer[] temp = new Integer[array.length * 2];
            for(int count=0; count<temp.length/2;count++){
                temp[count]= array[bound(first+count)];
            }
            first=0;
            last=(temp.length/2)-1;
            return temp;
        }
        return array;
    }

    public int bound(int position) {
        return Math.floorMod(position, backingArray.length);
    }
}