package com.fdm.tradingplatform.model;
import java.util.Hashtable;


public abstract class AbstractObjectPool<T> {
	  private long expirationTime;

	  protected Hashtable<T, Long> locked, unlocked;

	  public AbstractObjectPool(long experationTime) {
	    this.expirationTime = experationTime;
	    locked = new Hashtable<T, Long>();
	    unlocked = new Hashtable<T, Long>();
	  }

	  protected abstract T create();

	  public abstract boolean validate(T o);

	  public abstract void expire(T o);

	  public synchronized T checkOut() {
	    long now = System.currentTimeMillis();
	    if (unlocked.size() > 0) {
	     for(T key : unlocked.keySet()) {
	        if ((now - unlocked.get(key)) > expirationTime) {
	          unlocked.remove(key);
	          expire(key);
	          key = null;
	        } else {
	        	if (validate(key)) {
	            unlocked.remove(key);
	            locked.put(key, now);
	            return (key);
	          } else {
	            unlocked.remove(key);
	            expire(key);
	            key = null;
	          }
	        }
	      }
	    }
	    T newObject;
	    newObject = create();
	    locked.put(newObject, now);
	    return (newObject);
	  }

	  public synchronized void checkIn(T object) {
	    locked.remove(object);
	    unlocked.put(object, System.currentTimeMillis());
	  }
	}
