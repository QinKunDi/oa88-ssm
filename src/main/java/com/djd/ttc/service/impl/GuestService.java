package com.djd.ttc.service.impl;

import com.djd.ttc.mapping.GuestMapper;
import com.djd.ttc.model.Guest;
import com.djd.ttc.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@Transactional
public class GuestService implements IGuestService{
    private GuestMapper guestMapper;
    @Autowired
    public void setGuestMapper(GuestMapper guestMapper) {
        this.guestMapper = guestMapper;
    }
    @Transactional(readOnly = true)
    public List<Guest> findall() {
        return guestMapper.findall();
    }
}
