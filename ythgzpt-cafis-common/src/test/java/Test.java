/**
 * asda
 *
 * @author zhaoqian
 * @create 2017-03-06 11:06
 * mail to zhaoqian@hisign.com.cn
 **/

import java.io.IOException;

/**
 * asda
 * @author zhaoqian
 * @create 2017-03-06 11:06
 * mail to zhaoqian@hisign.com.cn
 **/
public class Test {

    public static void main(String[] args) {
        String batPath = "D:\\Workspaces\\MyEclipse10.7\\ytgzpt-cafis-root\\ythgzpt-cafis-web\\src\\main\\resources\\run.bat";

        Runtime rt = Runtime.getRuntime();
        try {
            Process p = rt.exec("D:\\Program Files\\TGP\\tgp_launcher.exe");
            int num =  p.waitFor();
            if (num == 0) {
                System.out.println(1111);
            } else {
                System.out.println(000);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
