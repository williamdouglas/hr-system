package br.com.example.payrollapi.resources.exceptions;

import java.time.LocalDateTime;

public class StandardError {

    private LocalDateTime localDateTime;
    private String mensageError;
    private Integer status;
    private String path;

    public StandardError(LocalDateTime localDateTime, String mensageError, Integer status, String path) {
        this.localDateTime = localDateTime;
        this.mensageError = mensageError;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getMensageError() {
        return mensageError;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

}
