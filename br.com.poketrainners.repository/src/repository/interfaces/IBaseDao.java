/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.interfaces;

/**
 *
 * @author marcus
 * @param <T>
 */
public interface IBaseDao<T> {

    public IQueryable<T> Index();

    public T Show(int id);

    public boolean Store(T data);

    public boolean Update(int id, T data);

    public boolean Delete(int id);

}
