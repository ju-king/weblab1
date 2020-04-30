package webadv.s99201105.p02;
import java.io.*;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) throws IOException {
        String account=null;
        String password=null;

        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        account = args[0];
        password = args[1];
        FileReader fr = new FileReader("a.txt");
        BufferedReader br = new BufferedReader(fr);
        boolean flag=false;
        br.readLine();
        String a="";
        while ((a=br.readLine())!=null && !flag){
            String userAccount = a.split(":")[0];
            String userPassword = a.split(":")[1];
            if (account.equals(userAccount))
                if (sha256hex(password).equals(userPassword)){
                    flag = true;
                    System.out.println("***********************************************************");
                    System.out.println("login");
                    System.out.println("account:"+userAccount);
                    System.out.println("password:"+userPassword);
                }
        }
        if (!flag){
            System.out.println("***********************************************************");
            System.out.println("login denied");
        }
        br.close();
        fr.close();
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

