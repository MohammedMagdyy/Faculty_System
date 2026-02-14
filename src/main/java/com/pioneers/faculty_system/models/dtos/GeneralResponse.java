package com.pioneers.rest.models.dtos;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class GeneralResponse <T>{
    private String timestamp;
    private int status;
    private String message;
    private String path;
    private T data;
    private List<String> errors;

    // ================= Constructors =================

    public GeneralResponse() {
        this.timestamp = Instant.now().toString();
    }

    public GeneralResponse(int status, String message, String path, T data) {
        this();
        this.status = status;
        this.message = message;
        this.path = path;
        this.data = data;
    }

    public GeneralResponse(int status, String message, String path, List<String> errors) {
        this();
        this.status = status;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    // ================= Getters & Setters =================

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


    // ================= Equals & HashCode =================

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return status == that.status && Objects.equals(timestamp, that.timestamp) && Objects.equals(message, that.message) && Objects.equals(path, that.path) && Objects.equals(data, that.data) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, message, path, data, errors);
    }


    // ================= ToString =================

    @Override
    public String toString() {
        return "ApiResponse{" +
                "timestamp='" + timestamp + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", data=" + data +
                ", errors=" + errors +
                '}';
    }
}
