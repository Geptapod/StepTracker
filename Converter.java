public class Converter {
    int distanse = 75;//один шаг равен 75 см
    int calories = 50;//1 шаг = 50 калорий

    double convertKilometers(int sumSteps) {//Пройденная дистанция (в км);
       return (double) (sumSteps * distanse) /100000;
    }

    double convertKolories(int sumSteps) {//Количество сожжённых килокалорий
        return ((double) (sumSteps * calories) /1000);//1 килокалория = 1 000 калорий
    }
}
