package com.jspsmart.upload;

import java.util.Set;
import java.util.HashMap;

public class SmartRequest
{
    private HashMap<String,HashMap<Integer,String>> m_parameters;
    private int m_counter;

    SmartRequest()
    {
        m_parameters = new HashMap<String,HashMap<Integer,String>>();
        m_counter = 0;
    }

    protected void putParameter(String s,String s1)
    {
        if(s == null)
        {
            throw new IllegalArgumentException("The name of an element cannot be null.");
        }
        if(m_parameters.containsKey(s))
        {
            HashMap<Integer,String> hashmap =m_parameters.get(s);
            hashmap.put(new Integer(hashmap.size()),s1);
        }
        else
        {
            HashMap<Integer,String> hashmap1 = new HashMap<Integer,String>();
            hashmap1.put(new Integer(0),s1);
            m_parameters.put(s,hashmap1);
            m_counter++;
        }
    }

    public String getParameter(String s)
    {
        if(s == null)
        {
            throw new IllegalArgumentException("Form's name is invalid or does not exist (1305).");
        }
        HashMap<Integer,String> hashmap =m_parameters.get(s);
        if(hashmap == null)
        {
            return null;
        }
        else
        {
            return hashmap.get(new Integer(0));
        }
    }

    public Set<String> getParameterNames()
    {
        return m_parameters.keySet();
    }

    public String[] getParameterValues(String s)
    {
        if(s == null)
        {
            throw new IllegalArgumentException("Form's name is invalid or does not exist (1305).");
        }
        HashMap<Integer,String> hashmap =m_parameters.get(s);
        if(hashmap == null)
        {
            return null;
        }
        String as[] = new String[hashmap.size()];
        for(int i = 0;i < hashmap.size();i++)
        {
            as[i] =hashmap.get(new Integer(i));
        }
        return as;
    }
}
