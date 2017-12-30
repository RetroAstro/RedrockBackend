import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tools {

    public static Map<String,ArrayList> getCollageToMajorMap() throws IOException {
        String data = getData("http://jwzx.cqupt.edu.cn/jwzxtmp/pubBjsearch.php?action=bjStu");
        Pattern pattern = Pattern.compile("<tr><td>(.*?)</td>");
        Matcher matcher = pattern.matcher(data);
        int i = 0;
        ArrayList collage = getCollageList();//获取学院名单
        Map<String, ArrayList> collageToMajor = new LinkedHashMap();//实例化学院到专业类即创建新的HashMap容器
        for (String string:getCollageList()){
            collageToMajor.put(string,new ArrayList<String>());
        }
        while (matcher.find()) {
            String temp = matcher.group(1);
            if (temp.equals("专业")) {
                i++;
                continue;
            }
            collageToMajor.get(collage.get(i-1)).add(matcher.group(1));//容器内装的即是学院对应的专业
        }
        return collageToMajor;
    }//第二步

    public static ArrayList<String> getCollageList() throws IOException {
        String data = getData("http://jwzx.cqupt.edu.cn/jwzxtmp/pubBjsearch.php?action=bjStu");
        ArrayList<String> collage = new ArrayList<>();
        Pattern pattern = Pattern.compile("<h3>(.*?)</h3>");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            collage.add(matcher.group(1));
        }
        return collage;

    }//获取学院名单方法 第一步

    public static String getData(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "UTF-8"
                )
        );
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        connection.disconnect();
        return builder.toString();
    }//获取教务在线数据

    public static Map<String, ArrayList<String>> getClassList(String ClassID) throws IOException {
        URL url = new URL("http://jwzx.cqupt.edu.cn/jwzxtmp/showBjStu.php?bj=" + ClassID);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "UTF-8"
                )
        );
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        connection.disconnect();
        String PageData = builder.toString();
        Pattern pattern=Pattern.compile("<tr><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td>");
        Matcher matcher = pattern.matcher(PageData);
        Map<String, ArrayList<String>> students = new LinkedHashMap<>();
        while (matcher.find()) {
            if(matcher.group(1).equals("No."))
                continue;
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                if (i==3)
                    continue;
                temp.add(matcher.group(i));
            }
            students.put(matcher.group(3), temp);
        }
        return students;
    }//获取key姓名和value具体的学生姓名 第四步班级到学生

    public static Map<String,List<String>> getMajorToClassList() throws IOException {
        String data = getData("http://jwzx.cqupt.edu.cn/jwzxtmp/pubBjsearch.php?action=bjStu");
        Pattern pattern = Pattern.compile("<tr><td>(.*?)</td>(.*?)</tr>");
        Matcher matcher = pattern.matcher(data);
        Map<String, List<String>> clazzes = new HashMap<>();
        while (matcher.find()) {
            Pattern p = Pattern.compile("showBjStu\\.php\\?bj\\=(.*?)\\'");
            Matcher m = p.matcher(matcher.group(2));
            List<String> c = new ArrayList<>();
            while (m.find()) {
                c.add(m.group(1));
            }
            clazzes.put(matcher.group(1), c);//专业对应班级列表
        }
        return clazzes;
    }

}//第三步专业到班级
