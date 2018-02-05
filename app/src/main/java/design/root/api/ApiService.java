package design.root.api;

import design.root.entity.HttpMessage;
import design.root.entity.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/1/31.
 */

public interface ApiService {

    @POST("index.php?c=Index&a=login")
    Observable<HttpMessage<User>> login(@Body User userEntity);

    @POST("index.php?c=Super&a=super")
    Observable<HttpMessage<String>> superUser(@Body User userEntity);
}
