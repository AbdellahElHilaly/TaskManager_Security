package com.youcode.taskmanager.shared.Const;


import org.springframework.stereotype.Component;

@Component
public class AppEndpoints {

    public static final String VERSION_1 = "/api/v1";
    public static final String BASE = VERSION_1;

    public static final String TASK = BASE + "/tasks";
    public static final String TAG = BASE + "/tags";
    public static final String USER = BASE + "/users";

    public static final String SECURITY = BASE + "/security";

    public static final String REFRESH_TOKEN = SECURITY + "/refresh-token";
    public static final String SIGN_IN = SECURITY + "/signin";
    public static final String SIGN_UP = SECURITY + "/signup";
    public static final String SIGN_OUT = SECURITY + "/signout";

}
