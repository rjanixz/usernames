package com.intertec.service;

public interface Result<T, V> {

    T isSuccess();

    V results();

    String toJson();
}
