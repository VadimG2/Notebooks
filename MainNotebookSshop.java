import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    }
}
