package kko;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class kt1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int leftShifts = Integer.parseInt(bufferedReader.readLine().trim());

        int rightShifts = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.getShiftedString(s, leftShifts, rightShifts);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    /*
     * Complete the 'getShiftedString' function below.
     *
     * The function is expected to return a STRING. The function accepts following
     * parameters: 1. STRING s 2. INTEGER leftShifts 3. INTEGER rightShifts
     */

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        // Write your code here
        StringBuilder resultStr = new StringBuilder(s);
        int left = 0;
        int right = 0;
        if (leftShifts - rightShifts > 0) {
            left = leftShifts - rightShifts;
            left = left % resultStr.length();
        }
        if (leftShifts - rightShifts < 0) {
            right = rightShifts - leftShifts;
            right = right % resultStr.length();
        }

        for (int i = 0; i < left; i++) {
            char tempChar = resultStr.charAt(0);
            resultStr.deleteCharAt(0);
            resultStr.append(tempChar);
        }
        for (int j = 0; j < right; j++) {
            char tempChar = resultStr.charAt(resultStr.length() - 1);
            resultStr.deleteCharAt(resultStr.length() - 1);
            resultStr.insert(0, tempChar);
        }
        return resultStr.toString();
    }

}