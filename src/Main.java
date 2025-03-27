import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> planner = new ArrayList();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int input;
            String input2;
            System.out.print("\n" + "Выберите операцию:\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "5. Удалить дело по ключевому слову\n" +
                    "Ваш выбор: ");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 0:
                    break;
                case 1:
                    System.out.print("Введите название задачи: ");
                    input2 = scanner.nextLine();
                    System.out.println(planner.add(input2) ? "Добавлено!" : "Попробуйте еще раз");
                    getTasks(planner);
                    break;
                case 2:
                    getTasks(planner);
                    break;
                case 3:
                    try {
                        System.out.print("Введите номер для удаления: ");
                        input = Integer.parseInt(scanner.nextLine());
                        planner.remove(input);
                        System.out.print("Удалено!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Задача с указанным номером, отсутствует в списке");
                    } finally {
                        getTasks(planner);
                        break;
                    }
                case 4:
                    System.out.print("Введите задачу для удаления: ");
                    input2 = scanner.nextLine();
                    System.out.println(planner.remove(input2) ? "Удалено!" : "Указанной задачи нет в списке");
                    getTasks(planner);
                    break;
                case 5:
                    System.out.print("Введите ключевое слово: ");
                    input2 = scanner.nextLine();
                    List<String> tasksToDelete = new ArrayList<>();
                    Iterator<String> iter = planner.iterator();
                    while (iter.hasNext()) {
                        String task = iter.next();
                        if (task.contains(input2)) {
                            tasksToDelete.add(task);
                        }
                    }
                    System.out.println(planner.removeAll(tasksToDelete) ? "Удалено!" : "В списке нет подходящих задач");
                    getTasks(planner);
            }
        }
    }

    public static void getTasks(List<String> list) {
        System.out.println("Ваш список дел: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
