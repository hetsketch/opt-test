package test0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        // TODO: 6/21/16
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
