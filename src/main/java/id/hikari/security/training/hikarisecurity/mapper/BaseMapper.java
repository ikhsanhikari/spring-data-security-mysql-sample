package id.hikari.security.training.hikarisecurity.mapper;

public abstract class BaseMapper<R,S> {
    public abstract  R convert(S s);
}
