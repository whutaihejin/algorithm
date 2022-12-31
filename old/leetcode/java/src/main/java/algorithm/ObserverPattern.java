package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static abstract class Observer {
        protected Observer() {}
        public abstract void Update(Subject subject);
    }

    public static class Subject {
        private List<Observer> observerList;

        public Subject() {
            observerList = new ArrayList<>();
        }

        public void Attach(Observer observer) {
            observerList.add(observer);
        }

        public void Detach(Observer observer) {
            observerList.remove(observer);
        }

        public void Notify() {
            for (Observer o : observerList) {
                o.Update(this);
            }
        }

        protected int GetStatus() {
            return 0;
        }
    }

    public static class ClockTimer extends Subject {
        private int timer;

        public ClockTimer() {
            timer = 0;
        }

        public int GetStatus() {
            return timer;
        }

        public void Tick() {
            for (int i = 0; i < 10; ++i) {
                timer++;
                Notify();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        }
    }

    public static class DigitalClock extends Observer {

        private Subject subject;

        public  DigitalClock(Subject subject) {
            this.subject = subject;
            this.subject.Attach(this);
        }

        public void Update(Subject subject) {
            if (subject == this.subject) {
                System.out.println("redraw digit: " + subject.GetStatus());
            }
        }
    }

    public static class AnalogClock extends Observer {
        private Subject subject;

        public AnalogClock(Subject subject) {
            this.subject = subject;
            this.subject.Attach(this);
        }

        public void Update(Subject subject) {
            System.out.println("analock redraw: " + subject.GetStatus());
        }
    }

    public static void main(String[] args) {
        ClockTimer clockTimer = new ClockTimer();
        DigitalClock digitalClock = new DigitalClock(clockTimer);
        AnalogClock analogClock = new AnalogClock(clockTimer);
        clockTimer.Tick();

        clockTimer.Detach(digitalClock);
        clockTimer.Tick();

        clockTimer.Detach(analogClock);
        clockTimer.Tick();
    }
}
