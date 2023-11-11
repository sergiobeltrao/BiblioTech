package com.mycompany.bibliotech.model.bean;

public class ApplicationContext {

    private static Login login;

    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        ApplicationContext.login = login;
    }
}
