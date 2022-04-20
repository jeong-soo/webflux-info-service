package dev.jsoo.infoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserInfoHandler {

    private WebClient localWebClient;

    @Autowired
    public UserInfoHandler(WebClient localWebClient) {
        this.localWebClient = localWebClient;
    }

    public Mono<ServerResponse> getInfo(ServerRequest request) {
        String name = request.queryParam("name").get();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                localWebClient.get().uri("/hello?name=" + name).retrieve().bodyToMono(User.class).map(u -> new UserInfo(u))
                , UserInfo.class);
    }
}
