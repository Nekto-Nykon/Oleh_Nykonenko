package nykon.factory;

import lombok.extern.slf4j.Slf4j;
import nykon.dropboxApi.Api;
import nykon.dropboxApi.ApiImpl;

import java.util.ResourceBundle;

@Slf4j
public class FactoryImpl implements Factory {
    private final Api api;
    FactoryImpl() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        String accessToken = resourceBundle.getString("token");
        api = new ApiImpl(accessToken);
    }
    @Override
    public Api getApi() {
        return api;
    }
}
