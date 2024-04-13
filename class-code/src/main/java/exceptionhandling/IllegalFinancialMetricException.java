package exceptionhandling;

//user defined exception example
public class IllegalFinancialMetricException extends Exception {

    private String message;

    public IllegalFinancialMetricException(String message) {
        super(message);
        this.message = message;
    }

    public IllegalFinancialMetricException() {
    }

    //for transformation or translation of an exception
    public IllegalFinancialMetricException(Throwable e) {
        super(e);
    }

    public IllegalFinancialMetricException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }

}
