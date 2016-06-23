package ipprinter;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IpPrinterTest {
    private static IpPrinter ipPrinter;
    public IpPrinterTest() {
    }

    @BeforeClass
    public static void ipPrinterInit() {
        ipPrinter = new IpPrinter();
    }

    @Test
    public void isIpValidTest() {
        String validIp = "192.168.0.100";
        String invalidIp = "192.300.0.100";

        assertTrue(ipPrinter.isIpValid(validIp));
        assertFalse(ipPrinter.isIpValid(invalidIp));
    }

    @Test
    public void stringIpToLongIpTest() {
        String ip = "192.168.0.100";
        long longIp = ipPrinter.stringIpToLongIp(ip);
        //string "192.168.0.100" = 3232235620 long
        assertEquals(longIp, 3232235620L);
    }

    @Test
    public void longIpToStringIpTest() {
        long longIp = 3232235620L;
        String ip = ipPrinter.longIpToStringIp(longIp);

        assertEquals(ip, "192.168.0.100");
    }
}
