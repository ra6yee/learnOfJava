package packageone;

public class PhoneLogger extends AbstractLogger  implements Logger  {


    public PhoneLogger(int level) {
        super(level);

    }



    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}