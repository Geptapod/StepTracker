import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(10000);


        System.out.println("Hello and welcome!");
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Укажите месяц:");
                printMonths();
                int month = scanner.nextInt();
                System.out.println("Укажите день:");
                int day = scanner.nextInt();
                System.out.println("Укажите количество шагов:");
                int steps = scanner.nextInt();
                stepTracker.stepCounter(month - 1, day, steps);
            } else if (command == 2) {
                System.out.println("Укажите месяц:");
                printMonths();
                int month = scanner.nextInt();
                stepTracker.printAllDaysInMonth(month - 1);
                System.out.println("Общее количество шагов за месяц: " + stepTracker.totalStepsByMonth(month - 1));
                System.out.println("Максимальное пройденное количество шагов в месяце: "
                        + stepTracker.maxStepsInMonth(month - 1));
                System.out.println("Среднее количество шагов: " + stepTracker.midleStepsInMonth(month - 1));
                System.out.println("Пройденная дистанция (в км): " + stepTracker.walkedKilometers(month - 1));
                System.out.println("Количество сожжённых килокалорий: " + stepTracker.burnedKolories(month - 1));
                System.out.println("Лучшая серия: " + stepTracker.betterSeries(month - 1));
            } else if (command == 3) {
                System.out.println("Укажите новую цель:");
                int newGoal = scanner.nextInt();
                System.out.println("Цель " + stepTracker.changeGoal(newGoal) + " шагов установлена!");
            } else if (command == 4) {
                break;
            } else {
                System.out.println("Такой команды нет");
            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("4 - Выйти из приложения");
    }

    public static void printMonths() {
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, 7 - Июль, 8 - Август, " +
                "9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
    }
}