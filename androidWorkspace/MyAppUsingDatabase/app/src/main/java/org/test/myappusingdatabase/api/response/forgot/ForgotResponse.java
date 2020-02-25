package org.test.myappusingdatabase.api.response.forgot;

import java.util.List;

public class ForgotResponse {

    private List<ForgotResponseList> response = null;

    private boolean status;

    public List<ForgotResponseList> getResponse() {
        return response;
    }

    public void setResponse(List<ForgotResponseList> response) {
        this.response = response;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
