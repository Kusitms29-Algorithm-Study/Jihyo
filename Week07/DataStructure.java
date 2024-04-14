package Week07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            Map<String, Integer> clothesMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                String type = scanner.next();

                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (int count : clothesMap.values()) {
                answer *= (count + 1);
            }

            System.out.println(answer - 1);
        }
    }
}
