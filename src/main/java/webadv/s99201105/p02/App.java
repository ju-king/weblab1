package webadv.s99201105.p02;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        if(sha256hex(args[1]).equals(sha256hex("123456"))){
            System.out.println("id:"+args[0]);
            System.out.println("password:"+sha256hex(args[1]));
            System.out.println("登录成功");
        }
        else{
            System.out.println("id or password is wrong!");
        }
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

