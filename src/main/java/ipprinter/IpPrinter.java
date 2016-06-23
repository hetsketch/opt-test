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
        long startLongIp = stringIpToLongIp(start);
        long endLongIp = stringIpToLongIp(end);

        longIpToStringIp(startLongIp);
        while (startLongIp < endLongIp - 1) {
            startLongIp++;
            System.out.println(longIpToStringIp(startLongIp));
        }
    }

    //check ip with regexp pattern
    public boolean isIpValid(String ip) {
        String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern pat = Pattern.compile(pattern);
        Matcher matcher = pat.matcher(ip);
        return matcher.matches();
    }

    public long stringIpToLongIp(String ip) {
        long[] ipArray = Arrays.stream(ip.split("\\.")).mapToLong(Long::parseLong).toArray();
        long result = 0;
        for (int i = 0; i < ipArray.length; i++) {
            switch (i) {
                case 0:
                    result |= ipArray[i] << 24;
                    break;
                case 1:
                    result |= ipArray[i] << 16;
                    break;
                case 2:
                    result |= ipArray[i] << 8;
                    break;
                case 3:
                    result |= ipArray[i];
            }
        }
        return result;
    }

    public String longIpToStringIp(long longIp) {
        StringBuilder sb = new StringBuilder();
        sb.append((longIp >> 24) & 0xFF);
        sb.append(".");
        sb.append((longIp >> 16) & 0xFF);
        sb.append(".");
        sb.append((longIp >> 8) & 0xFF);
        sb.append(".");
        sb.append(longIp & 0xFF);
        return sb.toString();
    }
}
