package pers.demo.enterprise.utils;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/13 16:20
 */
public class CommonUtils {
    public static long makeWorkerId() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int[] ips = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for (int ip: ips) {
                sums += ip;
            }
            return (sums % 1024);
        } catch (UnknownHostException e) {
            return RandomUtils.nextLong(0, 1024);
        }
    }
}
