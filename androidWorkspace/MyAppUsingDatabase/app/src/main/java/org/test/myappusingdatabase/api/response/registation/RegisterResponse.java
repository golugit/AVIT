package org.test.myappusingdatabase.api.response.registation;

import java.util.List;

public class RegisterResponse {

    private List<RegistationResponseList> response = null;
    private boolean status;

    public List<RegistationResponseList> getResponse() {
        return response;
    }

    public void setResponse(List<RegistationResponseList> response) {
        this.response = response;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
