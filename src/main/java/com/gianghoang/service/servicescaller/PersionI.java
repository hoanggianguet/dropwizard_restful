package com.gianghoang.service.servicescaller;


import com.gianghoang.DTO.PageDTO;
import com.gianghoang.DTO.PersonDTO;

import java.util.List;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface PersionI {
    public List<PersonDTO> getListPerson(int quantity);
    public List<PersonDTO> getAll();
    public PageDTO getPersonWithPage(int pageNumber);
}
