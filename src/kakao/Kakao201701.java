package kakao;

public class Kakao201701 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		//["#####","# # #", "### #", "# ##", "#####"]
		String[] result = new String[n];
		
		for (int i = 0; i < n ; i++) {
			int arr = arr1[i] | arr2[i];
			System.out.println("" + Integer.toBinaryString(arr).replaceAll("1", "#").replaceAll("0", " "));
			result[i] = Integer.toBinaryString(arr).replaceAll("1", "#").replaceAll("0", " ");
		}
	}

}
