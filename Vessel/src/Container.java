
import java.io.IOException;
import java.util.*;
public class Container {

    public static void main(String[] args) throws IOException {
        ArrayList<String> collegeList = Tools.getCollageList();//获取学院名单
        Map<String, ArrayList> collegeToMajorMap = Tools.getCollageToMajorMap();//获取学院到专业的Map
        Map<String, List<String>> majorToClassMap = Tools.getMajorToClassList();//获取专业到班级的Map
        Map<String, Map<String, Map<String, Map<String, ArrayList<String>>>>> Container = new LinkedHashMap<>();//装载全部数据的容器

        System.out.println("请输入您想查询学生信息的学生学号并稍等片刻......");
        System.out.println("获得学生信息后您最后将得到全校的学生信息！！！");
        Scanner str = new Scanner(System.in);
        String studentInfo = str.next();

        for (String col : collegeList) {

            Map<String, Map<String, Map<String, ArrayList<String>>>> majorlist = new LinkedHashMap<>();//装载专业及以下数据的容器

            for (Object Majorlist : collegeToMajorMap.get(col)) {

                Map<String, Map<String, ArrayList<String>>> classlist = new LinkedHashMap<>();   //装载班级及以下数据的容器

                for (String Classlist : majorToClassMap.get(Majorlist)) {

                    Map<String, ArrayList<String>> students = new LinkedHashMap<>(); //学生及其属性

                    for (Map.Entry<String, ArrayList<String>> i : Tools.getClassList(Classlist).entrySet()) {
                        String stuName = i.getKey();
                        ArrayList<String> stuInfo = i.getValue();

                        for (String l:stuInfo) {
                                if (studentInfo.equals(stuInfo.get(1))) {
                                        System.out.println(l);
                                }
                        }

                        students.put(stuName, stuInfo);
                    }
                    classlist.put(Classlist, students);
                }
                majorlist.put((String) Majorlist, classlist);
            }
            Container.put(col, majorlist);
        }
        System.out.println(Container);
    }
}
