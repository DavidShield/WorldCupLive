package external;


import org.springframework.stereotype.Component;

// using factory pattern in case of the changes of API in the future.
@Component
public class ExternalAPIFactory {
    private static final String DEFAULT_PIPELINE = "worldcupliveAPI";


    //start different ExternalAPI based on the pipeline
    public static ExternalAPI getExternalAPI(String pipeline) {
        switch (pipeline) {
            case "worldcupliveAPI":
                return new WorldCupAPI();
            default:
                throw new IllegalArgumentException("Invalid pipeline " + pipeline);
        }
    }

    public static ExternalAPI getExternalAPI() {
        return getExternalAPI(DEFAULT_PIPELINE);
    }
}
