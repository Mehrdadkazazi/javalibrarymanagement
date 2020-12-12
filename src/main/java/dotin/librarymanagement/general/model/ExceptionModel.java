package dotin.librarymanagement.general.model;

public class ExceptionModel {
    private String timestamp;
    private String code;
    private String errorMessage;

    public ExceptionModel() {
    }

    public ExceptionModel(String timestamp, String code, String errorMessage) {
        this.timestamp = timestamp;
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
