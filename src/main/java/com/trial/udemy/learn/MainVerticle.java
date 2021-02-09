package com.trial.udemy.learn;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();  // vertx instance to a new variable

// deploys app internally and the start method is called
    vertx.deployVerticle(new MainVerticle());// we can call the methods of it

  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    //vertx instance from the abstract verticle, new http server is created
    vertx.createHttpServer().requestHandler(req -> {
    //call back
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello Roy, this is vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
