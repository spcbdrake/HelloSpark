package com.theironyard;

import spark.Spark;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList();
        Spark.staticFileLocation("/public");
        Spark.init();
        Spark.post(
                "/create-account",
                ((request, response) -> {
                    User user = new User();
                    user.name = request.queryParams("username");
                    user.password = request.queryParams("password");
                    users.add(user);
                    response.redirect("/");
                    return "";
                })
        );
        Spark.get(
                "/accounts",
                ((request, response) -> {
                    return "Account page";
                })
        );
    }
}
