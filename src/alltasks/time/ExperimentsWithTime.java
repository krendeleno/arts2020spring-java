package alltasks.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time t1 = new Time(9, 50);
        t1.add(139);
        System.out.println(t1);
        System.out.println(t1.sayHello());
        System.out.println("isDay: " + t1.isDay());
        System.out.println("isEvening: " + t1.isEvening());
        System.out.println("isNight: " + t1.isNight());
        System.out.println("isMorning: " + t1.isMorning());

        System.out.println("#");

        Time t2 = new Time(23, 59);
        t2.add(62);
        System.out.println(t2);
        System.out.println(t2.sayHello());
        System.out.println("isDay: " + t2.isDay());
        System.out.println("isEvening: " + t2.isEvening());
        System.out.println("isNight: " + t2.isNight());
        System.out.println("isMorning: " + t2.isMorning());

        System.out.println("#");

        Time t3 = new Time(666, 666);
        System.out.println(t3);
        System.out.println(t3.sayHello());
        System.out.println("isDay: " + t3.isDay());
        System.out.println("isEvening: " + t3.isEvening());
        System.out.println("isNight: " + t3.isNight());
        System.out.println("isMorning: " + t3.isMorning());
    }
}
