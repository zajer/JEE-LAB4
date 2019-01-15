/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pc.wat.rswebservice;

import java.security.InvalidAlgorithmParameterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author PC
 */
@Stateless
@Path("hw")
public class JsonHWResource {
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyCustomResultClass Test(){
        
        MyCustomResultClass res = MyCustomResultClass.builder().field1("abc").field2(3).build();
        //return Response.status(200).entity(res).build();
        return res;
    }
    
    @GET
    @Path("inner")
    public String Yolo(){
        return "abc";
    }
    
    @POST
    @Path("doit")
    public String JustDoIt(MyCustomResultClass input){
        if(input.getField2()==2)
            return "odp1";
        else
            return "odp2";
    }
    
    @GET
    @Path("doit2")
    @Produces("application/json")
    public Response JustDoItV2(){
        Response res =  Response.status(Response.Status.FORBIDDEN).entity(new MyCustomResultClass("abc", 33)).build();
        return res;
    }
    
    @GET
    @Path("trolo/{myinput}")
    public void doSomething(@PathParam("myinput") String myInput){
        System.out.println(myInput);
    }
    
    @GET
    @Path("trolo2")
    public void doSomething2(@DefaultValue("undefined") @QueryParam("myinput") String myInput){
        System.out.println(myInput);
    }
    
    
}
