import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(List.of("assembler", "basic", "dart", "fortran", "java", "python", "rust"));
        // Создайте HashSet<String>, добавьте 5 слов и выведите все элементы
        System.out.println("Все элементы HashSet:");
        for (String s : stringSet) {
            System.out.println(s);
        }

        // Проверьте, содержится ли слово "java" в множестве
        {
            String word = "java";
            System.out.println();
            System.out.printf("В множестве содержится %sслово \"%s\"\n", (stringSet.contains(word) ? "" : "не "), word);
        }

        // Удалите слово "python" из множества (если оно есть)
        stringSet.remove("python");

        // Дан список строк с повторами
        List<String> stringList = new ArrayList<>(List.of("Раз", "Раз", "Два", "Три", "Три", "Четыре", "Пять", "Пять"));
        // Добавьте их в HashSet
        stringSet.addAll(stringList);
        // Выведите количество уникальных слов
        System.out.println();
        System.out.printf("Количество уникальных слов: %s\n", stringSet.size());

        // Создайте HashMap<String, Integer> с названиями предметов и оценками
        HashMap<String, Integer> gradeForSubjectHashMap = new HashMap<>(){{
            put("Math", 5);
            put("Physics", 4);
            put("Literature", 5);
            put("English", 4);
            put("Biology", 5);
        }};
        // Выведите все пары ключ-значение
        System.out.println();
        System.out.println("Пары ключ-значение:");
        for (Map.Entry<String, Integer> entry : gradeForSubjectHashMap.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue());
        }

        // Выведите значение по ключу "Math"
        {
            String subject = "Math";
            System.out.println();
            System.out.printf("Значение по ключу \"%s\": %s\n", subject, gradeForSubjectHashMap.get(subject));
        }

        // Измените значение по ключу "English" на 5
        gradeForSubjectHashMap.put("English", 5);

        // Проверьте, есть ли в мапе ключ "History"
        {
            String word = "History";
            System.out.println();
            System.out.printf("В мапе %s \"%s\"\n", (gradeForSubjectHashMap.containsKey(word) ? "есть слово" : "нет слова"), word);
        }

        // Удалите ключ "Physics" из мапы
        gradeForSubjectHashMap.remove("Physics");
    }

    public static HashMap<String, Integer> stringToHashMap(String string) {
        HashMap<String, Integer> stringHashMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            String key = String.valueOf(string.charAt(i));
            stringHashMap.put(key, stringHashMap.getOrDefault(key, 0) + 1);
        }

        return stringHashMap;
    }

    // Метод, который возвращает true, если строки состоят из одинаковых символов
    public static boolean areAnagrams(String a, String b) {
        return stringToHashMap(a).equals(stringToHashMap(b));
    }

    // Метод, который возвращает true, если в списке есть дубликаты
    public static boolean hasDuplicates(List<Integer> list) {
        return list.size() > (new HashSet<>(list)).size();
    }

    /*
     * Дан Map<String, Integer> (имя студента → балл)
     * Верните имя студента с максимальным баллом
     */
    public static String getBestStudent(Map<String, Integer> studentsMap) {
        String bestStudentName = "";
        Integer bestScore = Integer.MIN_VALUE;
        for (String key : studentsMap.keySet()) {
            Integer score = studentsMap.get(key);
            if (score > bestScore) {
                bestStudentName = key;
                bestScore = score;
            }
        }

        return bestStudentName;
    }

    // Создайте Map<String, Set<String>> — ключ: слово, значение: набор синонимов
    public static Map<String, Set<String>> synonymMap = new HashMap<>(){{
        put("большой", new HashSet<>(List.of("огромный", "гигантский", "великий", "массивный")));
        put("маленький", new HashSet<>(List.of("небольшой", "крошечный", "миниатюрный", "мелкий")));
    }};
    // Реализуйте метод addSynonym(String word, String synonym)
    public static void addSynonym(String word, String synonym) {
        if (!synonymMap.containsKey(word)) {
            synonymMap.put(word, new HashSet<>(List.of(synonym)));
        }

        synonymMap.get(word).add(synonym);
    }
}