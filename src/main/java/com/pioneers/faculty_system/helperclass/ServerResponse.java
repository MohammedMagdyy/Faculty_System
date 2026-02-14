package com.pioneers.faculty_system.helperclass;

import com.pioneers.faculty_system.models.dtos.GeneralResponse;

public class ServerResponse {

    public static <T> GeneralResponse<T> success(T data) {
        GeneralResponse<T> response = new GeneralResponse<>();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    public static  <T> GeneralResponse<T> failure(String message) {
        GeneralResponse<T> response = new GeneralResponse<>();
        response.setStatus(404);
        response.setMessage(message);
        response.setData(null);
        return response;
    }

}
