package beans.controllers.ws;

import beans.models.User;
import beans.services.UserService;
import gen.ws.user.GetUserRequest;
import gen.ws.user.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {


    private static final String NAMESPACE_URI = "http://com/ws/userservice";
    private final UserService service;

    @Autowired
    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserById")
    @ResponsePayload
    public GetUserResponse getUserById(@RequestPayload GetUserRequest request) {
        User user = service.getById(request.getId());
        GetUserResponse getUserResponse = new GetUserResponse();
        map(user, getUserResponse);

        return getUserResponse;
    }

    private void map(User user, GetUserResponse getUserResponse) {
        getUserResponse.setName(user.getName());
        getUserResponse.setEmail(user.getEmail());
    }

}
