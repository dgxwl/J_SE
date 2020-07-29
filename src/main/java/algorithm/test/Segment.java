package algorithm.test;


public class Segment {

    private int startHour;
    private int endHour;
    private String greeting;

    public Segment() {
    }

    public Segment(int startHour, int endHour, String greeting) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.greeting = greeting;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
