package ipprinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpPrinter {
    private String start;
    private String end;

    public void readInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter first valid IP address");
            start = readAndCheckIp(br);
            System.out.println("Enter second valid IP address");
            end = readAndCheckIp(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readAndCheckIp(BufferedReader br) throws IOException {
        String currentLine = br.readLine();
        while (true) {
            if (!isIpValid(currentLine)) {
                System.out.println("Ip is not valid. Try again.");
                currentLine = br.readLine();
            } else {
                return currentLine;
            }
        }
    }

    public void printIpRange() {
        System.out.println(start);
        System.out.println(end);
        int[] startIp = Arrays.stream(start.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] endIp = Arrays.stream(end.split("\\.")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(startIp));
        System.out.println(Arrays.toString(endIp));

        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < 4; i++) {
//            if (startIp[i] < endIp[i]) {
//                for (int j = startIp[i]+1; j < endIp[i]; j++) {
//                    System.out.println(sb.toString() + j);
//                    sb.append(".");
//
//                }
//            } else {
//                sb.append(startIp[i]);
//                sb.append(".");
//            }
//        }
        for (int i = 0; i < 4; i++) {
            if (startIp[i] < endIp[i]) {

            }
        }
//        System.out.println(sb.toString());

    }

    //check ip with regexp pattern
    private boolean isIpValid(String ip) {
        String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern pat = Pattern.compile(pattern);
        Matcher matcher = pat.matcher(ip);
        return matcher.matches();
    }


}
