import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MainNotebookSshop {
    public static void main(String[] args) {
        // Создаем ноутбуки
        NotebookSshop notebook1 = new NotebookSshop(1, 8, 256, "Windows", "Black");
        NotebookSshop notebook2 = new NotebookSshop(2, 16, 512, "Windows", "White");
        NotebookSshop notebook3 = new NotebookSshop(3, 8, 1024, "MacOS", "Gray");
        NotebookSshop notebook4 = new NotebookSshop(4, 32, 3072, "Windows", "Black");
        NotebookSshop notebook5 = new NotebookSshop(5, 16, 1024, "MacOS", "White");
        NotebookSshop notebook6 = new NotebookSshop(6, 8, 512, "Windows", "White");

        // Создаем множество ноутбуков и добавляем в него созданные ноутбуки
        Set<NotebookSshop> notebooks = new HashSet<>(
                Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6));

        // Выводим информацию о всех ноутбуках
        System.out.println("Все ноутбуки:");
        for (NotebookSshop notebook : notebooks) {
            System.out.println(notebook);
        }

        // Создаем критерии фильтрации
        Map<Integer, String> criteria = new TreeMap<>();
        criteria.put(1, "RAM");
        criteria.put(2, "HDD");
        criteria.put(3, "OS");
        criteria.put(4, "Color");

        // Получаем от пользователя критерий фильтрации
        int criterion = getCriterionFromUser(criteria);
        String criterionName = criteria.get(criterion);
        Object minValue = getMinValueForCriterion(criterionName);

        // Фильтруем ноутбуки по выбранному критерию и минимальному значению
        Set<NotebookSshop> filteredNotebooks = filterByCriterion(criterionName, minValue, notebooks);

        // Выводим отфильтрованные ноутбуки
        System.out.println("\nОтфильтрованные ноутбуки:");
        for (NotebookSshop notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    // Получение критерия фильтрации от пользователя
    public static int getCriterionFromUser(Map<Integer, String> criteria) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        printCriteria(criteria); // Выводим список критериев
        return scanner.nextInt();
    }

    // Вывод списка критериев на экран
    public static void printCriteria(Map<Integer, String> criteria) {
        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Получение минимального значения для указанного критерия от пользователя
    public static Object getMinValueForCriterion(String criterionName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите минимальное значение для " + criterionName + ":");
        if (criterionName.equals("RAM") || criterionName.equals("HDD")) {
            return scanner.nextInt();
        } else {
            return scanner.next();
        }
    }

    // Фильтрация ноутбуков по указанному критерию и минимальному значению
    public static Set<NotebookSshop> filterByCriterion(String criterionName, Object minValue, Set<NotebookSshop> notebooks) {
        Set<NotebookSshop> filteredNotebooks = new HashSet<>();

        for (NotebookSshop notebook : notebooks) {
            boolean matches = false;

            if (criterionName.equals("RAM")) {
                matches = notebook.getRAM() >= (int) minValue;
            } else if (criterionName.equals("HDD")) {
                matches = notebook.getHDDSize() >= (int) minValue;
            } else if (criterionName.equals("OS")) {
                matches = notebook.getOS().equalsIgnoreCase((String) minValue);
            } else if (criterionName.equals("Color")) {
                matches = notebook.getColor().equalsIgnoreCase((String) minValue);
            }

            if (matches) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}