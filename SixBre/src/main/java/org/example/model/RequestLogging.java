package org.example.model;


import javax.persistence.*;

@Entity
@Table(name = "Request_Log")
public class RequestLogging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_log_id")
    public int id;
    @Column(name = "module_name")
    public String moduleName;
    @Column(name = "request_method_name")
    public String requestMethod;
    @Column(name = "request_endPoint")
    public String requestEndpoint;
    @Column(name = "request_body")
    public String requestBody;
    @Column(name = "response_body")
    public String responseBody;
    @Column(name = "api_type")
    public String apiType;

    @Override
    public String toString() {
        return "RequestLogging{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestEndpoint='" + requestEndpoint + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", apiType='" + apiType + '\'' +
                '}';
    }

    public RequestLogging() {
    }

    public RequestLogging(int id, String moduleName, String requestMethod, String requestEndpoint, String requestBody, String responseBody, String apiType) {
        this.id = id;
        this.moduleName = moduleName;
        this.requestMethod = requestMethod;
        this.requestEndpoint = requestEndpoint;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
        this.apiType = apiType;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestEndpoint() {
        return requestEndpoint;
    }

    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }



}
