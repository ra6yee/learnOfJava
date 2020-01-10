package packageone;

public abstract class  AbstractLogger implements Logger {
    int level;
    Logger next;

    public AbstractLogger(int level) {
        this.level = level;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}
