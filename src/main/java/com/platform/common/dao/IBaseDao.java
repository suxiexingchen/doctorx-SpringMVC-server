package com.platform.common.dao;

import com.platform.bean.PageInfo;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: IBaseDao
 * @Description: Dao封装接口
 */
public interface IBaseDao<T> {

    /**
     * <保存实体>
     * <完整保存实体>
     *
     * @param t 实体参数
     */
    public abstract void save(T t);

    /**
     * <保存或者更新实体>
     *
     * @param t 实体
     */
    public abstract void saveOrUpdate(T t);

    /**
     * <load>
     * <加载实体的load方法>
     *
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public abstract T load(Class<T> t, String id);

    /**
     * <get>
     * <查找的get方法>
     *
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public abstract T get(Class<T> entity, String id);

    /**
     * <delete>
     * <删除表中的t数据>
     *
     * @param t 实体
     */
    public abstract void delete(T t);

    /**
     * <根据ID删除数据>
     *
     * @param Id 实体id
     * @return 是否删除成功
     */
    public abstract boolean deleteById(Class<T> t, String Id);

    /**
     * <删除所有>
     *
     * @param entities 实体的Collection集合
     */
    public abstract void deleteAll(Collection<T> entities);

    /**
     * <执行Hql语句>
     *
     * @param hqlString hql
     * @param values    不定参数数组
     */
    public abstract void queryHql(String hqlString, Object... values);

    /**
     * <执行Sql语句>
     *
     * @param sqlString sql
     * @param values    不定参数数组
     */
    public abstract void querySql(Class<T> t, String sqlString, Object... values);

    /**
     * <根据HQL语句查找唯一实体>
     *
     * @param hqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询实体
     */
    public abstract T getByHQL(String hqlString, Object... values);

    /**
     * <根据SQL语句查找唯一实体>
     *
     * @param sqlString SQL语句
     * @param values    不定参数的Object数组
     * @return 查询实体
     */
    public abstract T getBySQL(Class<T> t, String sqlString, Object... values);

    /**
     * <根据HQL语句，得到对应的list>
     *
     * @param hqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询多个实体的List集合
     */
    public abstract List<T> getListByHQL(String hqlString, PageInfo pageInfo, Object... values);

    /**
     * <根据SQL语句，得到对应的list>
     *
     * @param sqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询多个实体的List集合
     */
    public abstract List<T> getListBySQL(String sqlString, Class<T> t, Object... values);


    public List<Object[]> getListBySQLName(String sqlName, PageInfo pageInfo, Object... values);
    /**
     * <refresh>
     *
     * @param t 实体
     */
    public abstract void refresh(T t);

    /**
     * <update>
     *
     * @param t 实体
     */
    public abstract void update(T t);

    public Long countByHql(String hql, Object... values);

}