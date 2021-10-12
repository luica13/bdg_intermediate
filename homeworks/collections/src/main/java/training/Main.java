package training;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int a;

    public static void main(String[] args) {
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(6);
        a=12;
        System.out.println(verifySum(list, a));



//        Integer.valueOf(3);
//        LocalDateTime lt = LocalDateTime.of(2017,3,14,1,59);
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("M.ddhhmm");
//        System.out.println(df.format(lt));
////list.add("sdf");
//list.add("adf");
//list.add("saa");
//
//        System.out.println(list.stream().filter(c->c.startsWith("a")).count());
    }

    public static boolean verifySum(List<Integer> list, int a) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == a)
                    return true;
            }
        }
        return false;
    }
}
