import java.util.*;

public class SortedIntegerList {

	public static void main(String[] args) {
		SortedIntegerList a = new SortedIntegerList(true);
		a.add(0);
		a.add(1);
		a.add(5);
		System.out.println(a);
		SortedIntegerList b = new SortedIntegerList(false);
		b.add(0);
		b.add(1);
		b.add(5);
		SortedIntegerList c = new SortedIntegerList(false);
		c.add(0);
		c.add(1);
		c.add(5);
		System.out.println(b);
		System.out.println(c);
		SortedIntegerList o = intersection(a, b, c);
		System.out.println(o);
	}
	
	private LinkedList <Integer> list;
	private boolean repeat;
	
	public SortedIntegerList(boolean r) {
		list = new LinkedList<Integer>();
		repeat = r;
	}
	
	final public void add(int element) {
		for(ListIterator<Integer> i = list.listIterator(); ; ) {
			if(!i.hasNext()) {
				list.add(element);
				break;
			}
			int cur = i.next();
			if(element <= cur) {
				if(!repeat && element == cur) 
					break;
				i.previous();
				i.add(element);
				break;
			}
		}
	}
	
	final public void remove(int element) {
		for(ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
			if(i.next() == element) {
				i.remove();
			}
		}
	}
	
	final public boolean equals(Object a) {
		if (a instanceof SortedIntegerList) {
			SortedIntegerList t = (SortedIntegerList)a;
			return list.equals(t.list);
		} else {
			return false;
		}
	}
	
	static public SortedIntegerList intersection(SortedIntegerList a, SortedIntegerList b, SortedIntegerList c) {
		SortedIntegerList temp = new SortedIntegerList(false);
		for(ListIterator<Integer>it = a.list.listIterator() ;it.hasNext(); ){
			int num = it.next();
			if(c.list.contains(num) && b.list.contains(num))
				temp.add(num);
		}
		return temp;
		}

	
	final public String toString() {
		return list.toString();
	}
}

