package Main.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderResult {

    private boolean status;

    private RewiewRequest rewiewRequest;

    public RewiewRequest getRewiewRequest() {
        return rewiewRequest;
    }

    public void setRewiewRequest(RewiewRequest rewiewRequest) {
        this.rewiewRequest = rewiewRequest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
