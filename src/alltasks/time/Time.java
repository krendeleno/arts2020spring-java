package alltasks.time;

/**
 * Задача на ООП класс "время"
 */
public class Time {

    private final int hours;
    private final int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        if (hours < 10) return "0" + hours + ":" + minutes;
        return hours + ":" + minutes;
    }

    public String show() {
        return this.toString();
    }

    public String sayHello() {
        return (isNight()) ? "Доброй ночи" : (isMorning()) ? "Доброе утро" : (isDay()) ? "Добрый день" : "Добрый вечер";
    }

    public Time add(int m) {
        return new Time((hours + (minutes + m) / 60) % 24, (minutes + m) % 60);
    }

    public boolean isDay() {
        return 12 <= hours && hours <= 18;
    }

    public boolean isMorning() {
        return 5 <= hours && hours <= 11;
    }

    public boolean isEvening() {
        return 19 <= hours && hours <= 23;
    }

    public boolean isNight() {
        return 0 <= hours && hours <= 4;
    }
}
