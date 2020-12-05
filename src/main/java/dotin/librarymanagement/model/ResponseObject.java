package dotin.librarymanagement.model;

import java.util.List;

public class ResponseObject {
    private boolean hasError;
    private String code;
    private String message;
    private List<?> data;

    public ResponseObject() {
    }

    public ResponseObject(boolean hasError, String code, String message, List<?> data) {
        this.hasError = hasError;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
