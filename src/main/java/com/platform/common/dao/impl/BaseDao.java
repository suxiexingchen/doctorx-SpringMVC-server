package com.platform.common.dao.impl;

import java.util.Collection;
import java.util.List;

import com.platform.bean.PageInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platform.common.dao.IBaseDao;

/**
 * @ClassName: BaseDao
 * @Description: baseDao实现
 */
@SuppressWarnings({"unchecked"})
@Repository
public class BaseDao<T> implements IBaseDao<T> {

    private SessionFactory sessionFactory;

    /**
     * <保存实体>
     * <完整保存实体>
     *
     * @param t 实体参数
     */
    public void save(T t) {
        this.getSession().save(t);
    }

    /**
     * <保存或者更新实体>
     *
     * @param t 实体
     */
    public void saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
    }

    /**
     * <load>
     * <加载实体的load方法>
     *
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public T load(Class<T> t, String id) {
        T load = (T) this.getSession().load(t, id);
        return load;
    }

    /**
     * <get>
     * <查找的get方法>
     *
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public T get(Class<T> t, String id) {
        T load = (T) this.getSession().get(t, id);
        return load;
    }

    /**
     * <delete>
     * <删除表中的t数据>
     *
     * @param t 实体
     */
    public void delete(T t) {
        this.getSession().delete(t);
    }

    /**
     * <根据ID删除数据>
     *
     * @param Id 实体id
     * @return 是否删除成功
     */

    public boolean deleteById(Class<T> t, String Id) {
        T tt = get(t, Id);
        if (tt == null) {
            return false;
        }
        delete(tt);
        return true;
    }

    /**
     * <删除所有>
     *
     * @param entities 实体的Collection集合
     */

    public void deleteAll(Collection<T> entities) {
        for (Object entity : entities) {
            this.getSession().delete(entity);
        }
    }

    /**
     * <执行Hql语句>
     *
     * @param hqlString hql
     * @param values    不定参数数组
     *                  java.lang.Object[])
     */

    public void queryHql(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.executeUpdate();
    }

    /**
     * <执行Sql语句>
     *
     * @param sqlString sql
     * @param values    不定参数数组
     *                  java.lang.Object[])
     */

    public void querySql(Class<T> t, String sqlString, Object... values) {
        Query query;
        if (t != null) {
            query = this.getSession().createSQLQuery(sqlString).addEntity(t);
        } else {
            query = this.getSession().createSQLQuery(sqlString);
        }

        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.executeUpdate();
    }

    /**
     * <根据HQL语句查找唯一实体>
     *
     * @param hqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询实体
     * java.lang.Object[])
     */

    public T getByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    /**
     * <根据SQL语句查找唯一实体>
     *
     * @param sqlString SQL语句
     * @param values    不定参数的Object数组
     * @return 查询实体
     * java.lang.Object[])
     */

    public T getBySQL(Class<T> t, String sqlString, Object... values) {
        Query query;
        if (t != null) {
            query = this.getSession().createSQLQuery(sqlString).addEntity(t);
        } else {
            query = this.getSession().createSQLQuery(sqlString);
        }
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    /**
     * <根据HQL语句，得到对应的list>
     *
     * @param hqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询多个实体的List集合
     * java.lang.Object[])
     */

    public List<T> getListByHQL(String hqlString, PageInfo pageInfo, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        if (pageInfo == null) {
            return query.list();
        } else {
            Integer start = (pageInfo.getPageNo() - 1) * pageInfo.getPageSize();
            Long total = this.countByHql("select count(" + pageInfo.getEntityAlias() + ") " + hqlString, values);
            pageInfo.setTotal(total);

            return query.setFirstResult(start).setMaxResults(pageInfo.getPageSize()).list();

        }

    }

    /**
     * <根据SQL语句，得到对应的list>
     *
     * @param sqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询多个实体的List集合
     * java.lang.Object[])
     */

    public List<T> getListBySQL(String sqlString, Class<T> t, Object... values) {
        Query query;
        if (t != null) {
            query = this.getSession().createSQLQuery(sqlString).addEntity(t);
        } else {
            query = this.getSession().createSQLQuery(sqlString);
        }
        // .setResultTransformer(Transformers.aliasToBean(entityClass));
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.list();
    }

    public List<Object[]> getListBySQLName(String sqlName, PageInfo pageInfo, Object... values) {

        Query query = this.getSession().getNamedQuery(sqlName);

        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }

        if (pageInfo == null) {
            return query.list();
        } else {
            Integer start = (pageInfo.getPageNo() - 1) * pageInfo.getPageSize();
            pageInfo.setTotal(Long.valueOf(query.list().size()));
            return query.setFirstResult(start).setMaxResults(pageInfo.getPageSize()).list();
        }

    }

    /**
     * <refresh>
     *
     * @param t 实体
     */

    public void refresh(T t) {
        this.getSession().refresh(t);
    }

    /**
     * <update>
     *
     * @param t 实体
     */

    public void update(T t) {
        this.getSession().update(t);
    }

    /**
     * <根据HQL得到记录数>
     *
     * @param hql    HQL语句
     * @param values 不定参数的Object数组
     * @return 记录总数
     * java.lang.Object[])
     */

    public Long countByHql(String hql, Object... values) {
        Query query = this.getSession().createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (Long) query.iterate().next();
    }


    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return session
     */
    public Session getSession() {
        // 需要开启事物，才能得到CurrentSession
        return sessionFactory.getCurrentSession();
    }

}
