package com.gianghoang.iController;


import com.gianghoang.DTO.StudentDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface IStudent extends Serializable {
    public List<StudentDTO> getAll(int quantity);
}
