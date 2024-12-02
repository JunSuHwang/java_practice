public class Main {
    public static void main(String[] args) {
        EmailSample emailSample = new EmailSample();
        emailSample.findUserEmailOrElse();
        System.out.println();
        emailSample.findUserEmailOrElseGet();
    }
}