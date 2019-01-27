package Heap;

public class Heap {

	final int HEAP_SIZE = 1000;
	
	int numOfDate;
	HData[] heapArr;
	
	public Heap() {
		this.numOfDate = 0;
		this.heapArr = new HData[HEAP_SIZE];
	}
	
	public boolean isEmpty() {
		return numOfDate == 0? true : false;  
	}
	
	private int getLChiIdx(int idx) {
		return idx*2;
	}
	
	private int getRChiIdx(int idx) {
		return getLChiIdx(idx)+1;
	}
	
	private int getParentIdx(int idx) {
		return idx/2;
	}
	
	public int size() {
		return numOfDate;
	}
	
	public HData get(int idx) {
		if(idx>numOfDate) return null;
		
		return heapArr[idx];
	}
	
	private int getPriChiIdx(int idx) {
		
		if(getLChiIdx(idx) > numOfDate) {
			return 0;
		} else if(getLChiIdx(idx) == numOfDate) {
			return getLChiIdx(idx);
		} else {
			if(DataPriComp(heapArr[getLChiIdx(idx)], heapArr[getRChiIdx(idx)]) < 0) {
				return getLChiIdx(idx);
			} else {
				return getRChiIdx(idx);
			}
		}
	}
	
	private int DataPriComp(HData d1, HData d2) {
		if(d1.age > d2.age) {
			return -1;
		} else if(d1.age < d2.age) {
			return 1;
		} else {
			return d1.money > d2.money ? -1 : 1;
		}
	}
	
	public void add(HData d) {
		
		int idx = ++numOfDate;
		
		while(idx != 1) {
			if(DataPriComp(d, heapArr[getParentIdx(idx)]) > 0 ) {
				break;
			} else {
				heapArr[idx] = heapArr[getParentIdx(idx)];
				idx = getParentIdx(idx);
			}
		}
		
		heapArr[idx] = d;
	}
	
	public HData remove() {
		
		if(isEmpty()) return null;
		
		HData topData = heapArr[1];
		HData lastData = heapArr[numOfDate];
		
		int idx = 1;
		int childIdx = getPriChiIdx(idx);
		
		numOfDate--;
		
		while(childIdx != 0) {
			
			if(DataPriComp(lastData, heapArr[childIdx]) < 0) {
				break;
			} else {
				heapArr[idx] = heapArr[childIdx];
				idx = childIdx;
				childIdx = getPriChiIdx(idx);
			}
		}
		
		heapArr[idx] = lastData;
		return topData;
	}
}
