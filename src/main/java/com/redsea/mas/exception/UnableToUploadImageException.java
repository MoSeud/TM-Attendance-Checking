package com.redsea.mas.exception;

public class UnableToUploadImageException extends RuntimeException {
    private static final long serialVersionUID= -694354952032299587L;
    private  String studentId;
    public UnableToUploadImageException(String studentId){
        this.studentId=studentId;
    }
    public String getStudentId(){
        return studentId;
    }
}
