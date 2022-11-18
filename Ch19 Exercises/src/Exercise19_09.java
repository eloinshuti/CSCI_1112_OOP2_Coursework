/*
Eloi Nshuti
11/18/2022
Programming Exercise 19-9
*/
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	  E element;
	  int elementIndex;
	  for (int i = 0; i < list.size()-1; i++) {
		  element = list.get(i);
		  elementIndex = i;
		  for (int j = i + 1; j < list.size(); j++) {
			  if (element.compareTo(list.get(j)) < 0) {
				  element = list.get(j);
				  elementIndex = j;
				  }
			  }
		  if(elementIndex > 1) {
			  list.set(elementIndex, list.get(i));
			  list.set(i, element);
			  }
		  }
	  }
  }
