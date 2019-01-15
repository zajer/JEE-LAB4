/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pc.wat.rswebservice;

import javax.annotation.Resource;
import javax.ejb.Stateful;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author PC
 */
@ApplicationScoped
@Path("dbr")
public class DBResource {
    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private UserTransaction transaction;
    
    @GET
    @Path("db")
    public void dbaction1(){
        Books book = new Books();
        book.setIsbn10("22-11-00");
        book.setTitle("my book ws");
        try {    
            transaction.begin();
            em.persist(book);
            transaction.commit();

        }
        catch(Exception e){
            //logi?
            System.out.println(e);
        }
    }
    
    @GET
    @Path("db2")
    public void dbaction2(){
        try {
            Books book = new Books();
            book.setIsbn10("12-34-56");
            book.setTitle("to nie zostanie zapisane!");
            
            transaction.begin();
            em.persist(book);
            if(book.getIsbn10().contentEquals("12-34-56"))
                throw new IllegalArgumentException();
            transaction.commit();
        }
        catch(Exception e){
            //logi?
            System.out.println(e);
        }
    }
}
