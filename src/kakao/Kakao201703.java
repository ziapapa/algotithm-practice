package kakao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Kakao201703 {

	static int sum[] = new int[3];

	public static void main(String[] args) {
		// 3 ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul","NewYork", "LA"] 50
		// 3 ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo","Seoul"] 21
		// 2 ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul","Rome", "Paris", "Jeju", "NewYork", "Rome"] 60
		// 5 ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul","Rome", "Paris", "Jeju", "NewYork", "Rome"] 52
		// 2 ["Jeju", "Pangyo", "NewYork", "newyork"] 16
		// 0 ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"] 25

		Kakao201703 ka = new Kakao201703();
		ka.cacheTime(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul","NewYork", "LA" });
		ka.cacheTime(3, new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo","Seoul" });
		ka.cacheTime(2, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul","Rome", "Paris", "Jeju", "NewYork", "Rome" });
		ka.cacheTime(5, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul","Rome", "Paris", "Jeju", "NewYork", "Rome" });
		ka.cacheTime(2, new String[] { "Jeju", "Pangyo", "NewYork", "newyork" });
		ka.cacheTime(0, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" });

	}

	public void cacheTime(int cacheSize, String[] cities) {
		int runningTime = 0;
		LRUCache lc = new LRUCache(cacheSize);

		for (int i = 0; i < cities.length; i++) {

			String target = cities[i];
			if (lc.containsKey(target.toUpperCase())) {
				runningTime++;
			} else {
				runningTime += 5;
				lc.put(target.toUpperCase(), target.toUpperCase());
			}
			//System.out.println(lc.toString());
		}

		System.out.println("runningTime:" + runningTime);

	}

	class LRUCache extends java.util.LinkedHashMap<String, String> {
		public LRUCache(int maxsize) {
			super(maxsize, 0.75f, true);
			this.maxsize = maxsize;
		}

		protected int maxsize;

		protected boolean removeEldestEntry(Map.Entry eldest) {
			return size() > maxsize;
		}
	}

}
