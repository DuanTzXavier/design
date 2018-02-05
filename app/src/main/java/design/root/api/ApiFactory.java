package design.root.api;


import design.root.entity.HttpMessage;
import design.root.entity.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/1.
 */

public class ApiFactory {
    public static class Test {
//        public static Observable<ApiDataEntity> getHotTop() {
//            return obFactory(Api.getInstance().apiService.getHotTopic());
//        }
    }

    public static class UserApi {
        public static Observable<User> login(User userEntity) {
            return obFactory(Api.getInstance().apiService.login(userEntity));
        }

        public static Observable<String> superUser(User user) {
            return obFactory(Api.getInstance().apiService.superUser(user));
        }
    }

    public static <T> Observable<T> obFactory(Observable<HttpMessage<T>> observable) {
        return observable.onErrorReturn(new ErrorFilter<>())
                .map(new ResultFilter<>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryHelper(3));
    }
}
