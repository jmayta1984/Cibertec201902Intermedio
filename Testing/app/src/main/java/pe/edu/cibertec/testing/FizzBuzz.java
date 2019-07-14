package pe.edu.cibertec.testing;

public class FizzBuzz {
    static final String FIZZ = "FIZZ";
    static final String BUZZ = "BUZZ";

    public String execute(int number) {
        String result = "";

        if (multiple3(number)) result += FIZZ;
        if (multiple5(number)) result += BUZZ;
        if (result.isEmpty()) result = "" + number;

        return result;
    }

    private boolean multiple5(int number) {
        return number % 5 == 0;

    }

    private boolean multiple3(int number) {
        return number % 3 == 0;
    }
}
