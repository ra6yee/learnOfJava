package packageone;

public class SmsLogger extends AbstractLogger implements Logger {


    public SmsLogger(int level) {
        super(level);
    }


    @Override
    public void info(String message) {
        System.out.println("Send SMS to CEO: " + message);
    }
}