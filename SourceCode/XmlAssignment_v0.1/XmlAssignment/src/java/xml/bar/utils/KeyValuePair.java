/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.utils;

/**
 *
 * @author Tu
 */
public class KeyValuePair<T,U>{
    private T key;
    private U obj;

    public KeyValuePair(T key, U obj) {
        this.key = key;
        this.obj = obj;
    }

    public T getKey() {
        return key;
    }

    public U getObj() {
        return obj;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setObj(U obj) {
        this.obj = obj;
    }
    
}
