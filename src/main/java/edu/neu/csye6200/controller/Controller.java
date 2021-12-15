package edu.neu.csye6200.controller;

import java.util.List;

public abstract class Controller<T> {
    public abstract List<T> getList();
    public abstract void add(T t);
    public abstract void update(T t);
    public abstract T detail(T t);
    public abstract T query(T t);
}
