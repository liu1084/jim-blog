package com.jim.service.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MyBatisRedis implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(MyBatisRedis.class);
    private Jedis jedisClient = new Jedis();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private String id;

    public MyBatisRedis(final String id){
        if (id == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        logger.debug("key:" + SerializeUtil.serialize(o).toString() + ", value:" + SerializeUtil.serialize(o1).toString());
        jedisClient.set(SerializeUtil.serialize(o), SerializeUtil.serialize(o1));
    }

    @Override
    public Object getObject(Object o) {
        Object value = SerializeUtil.unSerialize(jedisClient.get(SerializeUtil.serialize(o)));
        logger.debug("key:" + SerializeUtil.serialize(o).toString() + ", value:" + value);
        return value;
    }

    @Override
    public Object removeObject(Object o) {
        logger.debug("remove key:" + SerializeUtil.serialize(o));
        return jedisClient.del(SerializeUtil.serialize(o));
    }

    @Override
    public void clear() {
        logger.debug("flush db.");
        jedisClient.flushDB();
    }

    @Override
    public int getSize() {
        return Integer.getInteger(jedisClient.dbSize().toString());
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    public static Jedis createRedis(){
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost");
        return jedisPool.getResource();
    }
}
