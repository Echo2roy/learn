package com.trial.udemy.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleA extends AbstractVerticle {


  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
    System.out.println("Start " + getClass().getName());
    vertx.deployVerticle(new VerticleAA());
    startPromise.complete(); //asynchronous call back
  }
}
