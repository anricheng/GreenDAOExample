package chou.aric.com.mydao.dbutils;

import org.greenrobot.greendao.annotation.*;

import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "SON".
 */
@Entity(active = true)
public class Son {
    private String name;
    private Integer age;

    @Id
    private Long id;
    private Long fatherId;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient SonDao myDao;

    @ToOne(joinProperty = "fatherId")
    private Father father;

    @Generated
    private transient Long father__resolvedKey;

    @Generated
    public Son() {
    }

    public Son(Long id) {
        this.id = id;
    }

    @Generated
    public Son(String name, Integer age, Long id, Long fatherId) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.fatherId = fatherId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSonDao() : null;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated
    public Father getFather() {
        Long __key = this.fatherId;
        if (father__resolvedKey == null || !father__resolvedKey.equals(__key)) {
            __throwIfDetached();
            FatherDao targetDao = daoSession.getFatherDao();
            Father fatherNew = targetDao.load(__key);
            synchronized (this) {
                father = fatherNew;
            	father__resolvedKey = __key;
            }
        }
        return father;
    }

    @Generated
    public void setFather(Father father) {
        synchronized (this) {
            this.father = father;
            fatherId = father == null ? null : father.getId();
            father__resolvedKey = fatherId;
        }
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

}
