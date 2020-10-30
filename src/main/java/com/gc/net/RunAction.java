package com.gc.net;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 6c6763
 * @date 2020/10/28
 */

public class RunAction {

    static final String WIN = "Windows";

    public static void main(String[] args) throws Exception {
        System.out.println(executeLinuxCmd("ls /Users/6c6763/soft"));
    }

    static boolean executeLinuxCmd(String cmd) throws Exception {
        System.out.println("got cmd job : " + cmd);
        Runtime run = Runtime.getRuntime();
        try {
            String osName = System.getProperties().getProperty("os.name");
            System.out.println(osName);
            if (osName.contains(WIN)) {
                throw new Exception("windows系统下，不支持该功能");
            } else {
                Process process = run.exec(cmd);
                InputStream in = process.getInputStream();
                StringBuilder out = new StringBuilder();
                byte[] b = new byte[8192];
                for (int n; (n = in.read(b)) != -1; ) {
                    out.append(new String(b, 0, n));
                }
                System.out.println("job result [" + out.toString() + "]");
                in.close();
                process.destroy();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
