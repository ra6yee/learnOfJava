package packageone;

public class FileLogger extends AbstractLogger implements Logger {

    public FileLogger(int level) {
        super(level);
    }
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}
