package com.example.pinal.myjsoncontact;

import java.util.ArrayList;

/**
 * Created by pinal on 10/5/16.
 */
public class Model {
public String titel;
    public String url;
    ArrayList<Categories>arrCat=new ArrayList<>();
    ArrayList<Tags>arrTag=new ArrayList<>();
    public static class Categories{
public String cat;
    }
    public static class Tags{
public String tag;
    }
}
