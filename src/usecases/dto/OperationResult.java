package usecases.dto;

public class OperationResult {
    private final boolean resultStatus;
    private final String resultMessage;

    private OperationResult(boolean result, String message) {
        this.resultStatus = result;
        this.resultMessage = message;
    }

    public static OperationResult ok(String message) {
        return new OperationResult(true, message);
    }

    public static OperationResult fail(String message) {
        return new OperationResult(false, message);
    }

    public boolean wasSuccess() { return resultStatus; }
    public String getResultMessage() { return resultMessage; }

    @Override
    public String toString() { return resultMessage; }
}
