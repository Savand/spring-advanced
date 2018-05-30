package beans.controllers.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import beans.controllers.ws.gen.user.GetUserRequest;
import beans.controllers.ws.gen.user.GetUserResponse;
import beans.models.User;
import beans.services.UserService;



@Endpoint
public class UserEndpoint {


    private static final String NAMESPACE_URI = "http://www.user.gen.ws.controllers.beans";
    private final UserService service;

    @Autowired
    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserById(@RequestPayload GetUserRequest request) {
        User user = service.getById(request.getId());
        GetUserResponse getUserResponse = new GetUserResponse();
        map(user, getUserResponse);

        return getUserResponse;
    }

    private void map(User user, GetUserResponse getUserResponse) {
        beans.controllers.ws.gen.user.User genUser = new beans.controllers.ws.gen.user.User();
        genUser.setName(user.getName());
        genUser.setEmail(user.getEmail());
        getUserResponse.setUser(genUser);
    }

}
