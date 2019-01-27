package Main;

import Heap.HData;
import Heap.Heap;

public class Main {

	public static void main(String[] args) {
		
		Heap heap = new Heap();
		
		heap.add(new HData(1,1500));
		heap.add(new HData(6,1500));
		heap.add(new HData(3,1500));
		heap.add(new HData(60,1500));
		heap.add(new HData(60,150));
		heap.add(new HData(3,750));
		
		for(int i=1; i<=heap.size(); i++) {
			System.out.println(heap.get(i).age+", "+heap.get(i).money);
		}
		
		System.out.println("----------");
		
		while(!heap.isEmpty()) {
			HData data = heap.remove();
			System.out.println(data.age+", "+data.money);
		}
	}

}
