import java.util.Scanner;
public class Count {

    public static void main(String[] args){
        System.out.println("请输入完整的式子并进行简单的四则运算");
        while (true) {
        try {
                int sum = 0;
                Scanner scanner = new Scanner(System.in);
                String strline = new String();
                strline = scanner.nextLine();
                //split方法，匹配对应符号把其左右两边的字符串分割并返回数组！
                String[] str = strline.split("\\D+");  //返回数字
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                String[] ch = strline.split("\\d+");  //返回运算符号

                switch (ch[1]) {
                    case "+":
                        sum = a + b;
                        break;
                    case "-":
                        sum = a - b;
                        break;
                    case "*":
                        sum = a * b;
                        break;
                    case "/":
                        if (a / b == 0){
                            sum = a / b;
                        }else{
                            System.out.println("您输入的式子不能被整除！");
                        }
                        break;
                    default:
                        System.out.println("您输入的格式有误！");

                }
                System.out.println("计算结果为：" + sum);
              }catch (java.lang.ArithmeticException e){
                System.out.println("除数不能为零！");
            }
        }

    }
}
