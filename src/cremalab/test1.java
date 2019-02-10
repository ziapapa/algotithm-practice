package cremalab;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test1 {

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> dates = new ArrayList<>();

		for (int i = 0; i < datesCount; i++) {
			String datesItem = bufferedReader.readLine();
			dates.add(datesItem);
		}

		List<String> result = Result.reformatDate(dates);

		for (int i = 0; i < result.size(); i++) {
			bufferedWriter.write(result.get(i));

			if (i != result.size() - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();

	}

}

class Result {

	/*
	 * Complete the 'reformatDate' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING_ARRAY dates as parameter.
	 */

	public static List<String> reformatDate(List<String> dates) throws ParseException {
		// Write your code here
		List<String> dateList = new ArrayList<>();

		SimpleDateFormat inFormat = new SimpleDateFormat("d MMM yyyy");
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			for (String dateString : dates) {
				Date inDate = inFormat.parse(dateString.replaceFirst("([0-9]+)(st|nd|rd|th)", "$1"));
				String outDate = outFormat.format(inDate);
				dateList.add(outDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateList;
	}

}