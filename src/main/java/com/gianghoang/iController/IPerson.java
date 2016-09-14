package com.gianghoang.iController;


import com.gianghoang.DTO.PageDTO;
import com.gianghoang.DTO.PersonDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface IPerson extends Serializable {
    public List<PersonDTO> getListPerson(int quantity);
    public List<PersonDTO> getListPerson();
    public PageDTO getUserWithPage(int pageNumber);
}
