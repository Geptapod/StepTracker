import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    int goal;
    HashMap<Integer, Integer[]> monthSteps;// объявил
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);

    StepTracker(int goalNew) {
        goal = goalNew;

        monthSteps = new HashMap<>();

        for (int i = 0; i < 12; i++) {
            monthSteps.put(i, new Integer[30]);
        }

    }


    void stepCounter(int month, int day, int steps) {// 1 - Ввести количество шагов за определённый день
        if ((day >= 1 && day <= 30) && steps > 0 && (month >= 0 && month <= 12)) {
            if (monthSteps.get(month)[day-1] == null) {
                monthSteps.get(month)[day-1] = 0;
            }
            if (monthSteps.get(month)[day - 1] != 0) {// Проверяю есть ли запись за этот день отличная от нуля
                System.out.println("Этот день уже содержит запись! Перезаписать? 1 - Да; 2 - Нет. Шаги будут суммированы");
                int command = scanner.nextInt();
                if (command == 1) {
                    monthSteps.get(month)[day - 1] = steps;
                    System.out.println("Значение перезаписано!");
                } else {
                    int oldValue = monthSteps.get(month)[day - 1];
                    monthSteps.get(month)[day - 1] = steps + oldValue;
                    System.out.println("Шаги суммированы!");
                }
            } else {
                monthSteps.get(month)[day - 1] = steps;
                System.out.println("Шаги добавлены!");
            }
        } else if (steps < 0){
            System.out.println("Число шагов не может быть отрицательным!");
        } else {
            System.out.println("Неверно указан месяц или день!");
        }
    }


    //2 - Напечатать статистику за определённый месяц
    public void printAllDaysInMonth(int month) {//печатает шаги по дням
        for (int dayD = 0; dayD < 30; dayD++) {
            if (monthSteps.get(month)[dayD] == null) {
                monthSteps.get(month)[dayD] = 0;
            }
            System.out.print((dayD + 1) + " день: " + monthSteps.get(month)[dayD] + ", ");
        }
    }

    int totalStepsByMonth(int month) {//Общее количество шагов за месяц
        int sumSteps = 0;
        for (int steps : monthSteps.get(month)) {
            sumSteps += steps;
        }

        return sumSteps;
    }

    int maxStepsInMonth(int month) {//Максимальное пройденное количество шагов в месяце
        int maxSteps = 0;
        for (Integer steps : monthSteps.get(month)) {
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }

        return maxSteps;
    }

    double midleStepsInMonth(int month) {//Среднее количество шагов;
        int sumSteps = 0;
        for (int steps : monthSteps.get(month)) {
            sumSteps += steps;
        }
        return (double) sumSteps /30;
    }

    double walkedKilometers(int month) {//Пройденная дистанция (в км)
        int sumSteps = 0;

        for (Integer steps : monthSteps.get(month)) {
            sumSteps += steps;
        }

        return converter.convertKilometers(sumSteps);
    }

    double burnedKolories(int month) {//подсчёт количества сожжённых килокалорий
        int sumSteps = 0;

        for (Integer steps : monthSteps.get(month)) {
            sumSteps += steps;
        }

        return converter.convertKolories(sumSteps);
    }

    //Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
    int betterSeries(int month) {
        int seriesDays = 0;
        int counter = 0;

        for (Integer steps : monthSteps.get(month)) {
            if (steps >= goal) {
                counter++;
            } else {
                if (counter > seriesDays) {
                    seriesDays = counter;
                } else {
                    counter = 0;
                }
            }
        }

        return seriesDays;
    }

    int changeGoal(int newGoal) {//Изменение целевого количества шагов
        if (newGoal > 0) {
            goal = newGoal;
        }
        return goal;
    }
}






